package com.qdyd.vehicle.service;

import com.qdyd.vehicle.dao.TCarDao;
import com.qdyd.vehicle.dao.TDriverDao;
import com.qdyd.vehicle.dao.TPaiCheDao;
import com.qdyd.vehicle.dao.TPaiCheMapper;
import com.qdyd.vehicle.po.*;
import com.qdyd.vehicle.util.IdWorker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TPaiCheService {

    @Autowired
    private TPaiCheDao paiCheDao;

    @Autowired
    private TPaiCheMapper paiCheMapper;

    @Autowired
    private IdWorker idWorker;

    public List<Map<String,Object>> findcardriver(String id){
        return paiCheMapper.findcardriver(id);
    }

    // 车牌号
    public List<Map<Object,Object>> carno(){
        List<Map<Object,Object>> carno = paiCheMapper.carno();
        return carno;
    }

    public List<Map<Object,Object>> mantodept(String driveName){
        List<Map<Object, Object>> mantodept = paiCheMapper.mantodept(driveName);
        return mantodept;
    }

    public List<Map<Object,Object>> find(){
        return paiCheMapper.find();
    }

    public List<Map<Object, Object>> findbyid(String paicheId){
        //return paiCheDao.findById(paicheId).get();
        return paiCheMapper.findbyid(paicheId);
    }

    /**
     * 根据id查询派车单
     * @param paicheId
     * @return
     */
    public List<Map<Object,Object>> findById(String paicheId){
        //TPaiChe paiChe = paiCheDao.findById(paicheId).get();
        System.out.println("paicheId===>"+paicheId);
        List<Map<Object,Object>> list = paiCheMapper.findbyid(paicheId);
        //if (paiChe.getDataStatus()!=1) {
            return list;
//        }else {
//            return null;
//        }
    }

    /**
     * 派车单  待命车辆  下拉框
     */
    public List<TCar> cardaimingselect() {
        return paiCheMapper.cardaimingselect();
    }

    /**
     * 修改
     * @param paicheId
     * @param paiChe
     */
    public void update(String paicheId, TPaiChe paiChe) {
        TPaiChe che = paiCheDao.findById(paicheId).get();
        che.setCarId(paiChe.getCarId());// 车辆id
        che.setAuditLeaderShip(paiChe.getAuditLeaderShip());
        che.setCause(paiChe.getCause());// 事由去向
        che.setComeMileage(paiChe.getComeMileage());
        che.setUpdateTime(new Date());// 更新时间
        che.setUseMan(paiChe.getUseMan());// 用车人
        che.setDestination(paiChe.getDestination());//目的地
        che.setMileage(paiChe.getMileage());// 行驶里程
        che.setReturnTime(paiChe.getReturnTime());// 回场时间
        che.setStorageTime(paiChe.getStorageTime()); //入库时间
        che.setRemark(paiChe.getRemark());//备注
        paiCheDao.save(paiChe);
    }

    /**
     * 删除派车单
     * @param paicheId
     */
    public void deleteById(String paicheId) {
        paiCheMapper.deletePaice(paicheId);
    }

    /**
     * 物理删除派车单
     * @param paicheId
     */
    public void delete(String paicheId) {
        paiCheDao.deleteById(paicheId);
    }

    @Autowired
    private TCarDao carDao;

    @Autowired
    private TDriverDao driverDao;

    /**
     * 新增派车单
     * @param paicheVo
     */
    public void add(PaicheVo paicheVo) {
        TPaiChe paiChe = new TPaiChe();
        System.out.println("addyemian");
        // 生成派车单ID
        String id = idWorker.nextId()+"";
        System.out.println(id);
        System.out.println(paicheVo.toString());
        System.out.println(paicheVo.getDesName());

        List<TDestination> destinations = paiCheMapper.findDes(paicheVo.getDesName());
        System.out.println("destinations.get(0).getDesId()========"+destinations);
        if (destinations==null||destinations.isEmpty()) {
            String destinationId = (idWorker.nextId() + "").substring(4);
            // 保存手动输入的目的地
            TDestination destination = new TDestination();
            destination.setDesId(destinationId);
            destination.setDesTime(new Date());
            destination.setDesName(paicheVo.getDesName());
            paiCheMapper.saveDes(destination);
            // 派车表保存目的地ID
            paiChe.setDestination(destinationId);
        } else {
            paiChe.setDestination(destinations.get(0).getDesId());
        }

        List<TMatter> matters = paiCheMapper.findMatter(paicheVo.getMatter());
        System.out.println("matters.get(0).getTid()======>"+matters);
        if (matters==null||matters.isEmpty()) {
            // 生成手动输入的事由ID
            String matterId = (idWorker.nextId() + "").substring(4);
            // 保存手动输入的事由去向
            TMatter matter =  new TMatter();
            matter.setTid(matterId);
            matter.setCause(paicheVo.getMatter());
            matter.setDataStatus(0);
            matter.setCreateDate(new Date());
            paiCheMapper.saveMatter(matter);
            // 派车表保存事由ID
            paiChe.setCause(matterId);
        } else {
            System.out.println("matters.get(0).getTid():"+matters.get(0).getTid());
            paiChe.setCause(matters.get(0).getTid());
        }

        // 生成手动输入的驾驶员ID
        String drvierId = (idWorker.nextId() + "");
        // 生成手动输入的车牌号ID
        String carId = (idWorker.nextId() + "").substring(4);
        List<TDriver> drivers = paiCheMapper.findTDriver(paicheVo.getDriverName());
        // 车牌号
        List<TCar> cars = paiCheMapper.findCar(paicheVo.getCarNo());
        List<TCarType> cartype = paiCheMapper.cartype(paicheVo.getCarType());
        if (cars==null||cars.isEmpty()){
            // 保存手动输入的车牌号
            TCar car = new TCar();
            car.setCarId(carId);
            car.setDataStatus(0);
            car.setCreateDate(new Date());
            car.setCarNo(paicheVo.getCarNo());
            car.setStatus(2);// 待勤
            // 车型
            car.setCarType(cartype.get(0).getTypeNum());
            System.out.println("drivers>>>>>"+drivers);
            //paiCheMapper.saveCarId(car);
            // 驾驶员ID关联车辆
            if (drivers==null||drivers.isEmpty()) {
                System.out.println("1");
                car.setCarDriverId(drvierId);
                paiCheMapper.updateCarIdDrverId(drvierId,carId);
                //paiCheMapper.saveCarId(car);
            } else {
                System.out.println("2");
                System.out.println("drivers.get(0).getDriverId():" + drivers.get(0).getDriverId());
                car.setCarDriverId(drivers.get(0).getDriverId());// 驾驶员关联车辆
                paiCheMapper.updateCarIdDrverId(drivers.get(0).getDriverId(),carId);
                //paiCheMapper.saveCarId(car);
            }
            //paiCheMapper.saveCarId(car);
            // 派车表保存车牌ID
            paiChe.setCarId(carId);
        } else {
            TCar car = new TCar();
            car.setDataStatus(0);
            car.setCreateDate(new Date());
            car.setCarNo(paicheVo.getCarNo());
            car.setStatus(2);// 待勤
            // 车型
            car.setCarType(cartype.get(0).getTypeNum());
            System.out.println("drivers>>>>>"+drivers);
            /*if (drivers==null||drivers.isEmpty()) {
                System.out.println("1");
                car.setCarDriverId(drvierId);
                paiCheMapper.updateCarIdDrverId(drvierId,cars.get(0).getCarId());
                //paiCheMapper.saveCarId(car);
            } else {
                System.out.println("2");
                System.out.println("drivers.get(0).getDriverId():" + drivers.get(0).getDriverId());
                car.setCarDriverId(drivers.get(0).getDriverId());// 驾驶员关联车辆
                paiCheMapper.updateCarIdDrverId(drivers.get(0).getDriverId(),cars.get(0).getCarId());
                //paiCheMapper.saveCarId(car);
            }*/
            paiChe.setCarId(cars.get(0).getCarId());
        }

        if (drivers==null||drivers.isEmpty()) {
            // 保存手动输入的驾驶员
            TDriver driver = new TDriver();
            driver.setDriverId(drvierId);
            driver.setDataStatus(0);
            driver.setDriverName(paicheVo.getDriverName());
            paiCheMapper.saveDriver(driver);
            // 派车表保存驾驶员ID
            paiChe.setDriverId(drvierId);
        } else {
            paiChe.setDriverId(drivers.get(0).getDriverId());
        }

        List<TDriverUseMan> useMans = paiCheMapper.findTDriverUseMan(paicheVo.getUseName());
        if (useMans==null||useMans.isEmpty()) {
            // 生成手动输入的用车人ID
            String useManId = (idWorker.nextId() + "").substring(0,15);
            // 保存手动输入到用车人ID
            TDriverUseMan useMan = new TDriverUseMan();
            useMan.setDriverId(useManId);
            useMan.setUseName(paicheVo.getUseName());
            useMan.setDataStatus(0);
            useMan.setDepartment("1");
            paiCheMapper.saveUseMan(useMan);
            // 派车表保存用车人id
            paiChe.setUseMan(useManId);
        } else {
            paiChe.setUseMan(useMans.get(0).getDriverId());
        }

        // 车型
        //List<TCarType> cartype = paiCheMapper.cartype(paicheVo.getCarType());
        System.out.println("cartypeid:"+cartype.get(0).getTypeNum());
        paiChe.setCarType(cartype.get(0).getTypeNum());

        //paiChe.setCarType(paicheVo.getCarType());

        paiChe.setGujiRetureTime(paicheVo.getGujiRetureTime());
        paiChe.setGujiStorageTime(paicheVo.getGujiStorageTime());
        System.out.println(paicheVo.getGujiRetureTime());

        paiChe.setPaicheId(id.substring(4));
        Date date = new Date();
        paiChe.setDate(date);// 开单日期
        // 单号  流水号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(date);
        String no = format;

        System.out.println(no);
        paiChe.setNo(no);
        paiChe.setDataStatus(0);
        paiChe.setStatus("2");// 正常状态
        paiChe.setDeptId("1");// 设置用车人部门
        // 修改车辆待勤状态
        paiCheMapper.updateCarStatus(paiChe.getCarId());
        System.out.println("paiChe.getCarId()=="+paiChe.getCarId());
        System.out.println("=============\n"+paiChe.toString()+"\n====");
        paiCheMapper.insert(paiChe);
    }

    /**
     * 修改状态
     */
    public void updatePaicheStatus(String status,String paicheId){
        paiCheMapper.updatePaiceStatus(status,paicheId);
    }

}