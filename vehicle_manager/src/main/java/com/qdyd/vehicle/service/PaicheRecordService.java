package com.qdyd.vehicle.service;

import com.qdyd.vehicle.dao.PaicheRecordDao;
import com.qdyd.vehicle.po.*;
import com.qdyd.vehicle.po.TDriverDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PaicheRecordService {

    @Autowired
    private PaicheRecordDao paicheRecordDao;

    public List<PaicheRecord> selectRecords(String paiCheDeptId,String paicheuseManId,String paichecarId,String paichedriverId,
                                            String paichestartTime,String paicheendTime,int limit,int page){

        if ("请选择部门".equals(paiCheDeptId)) {
            paiCheDeptId=null;
        }
        if("请选择用车人".equals(paicheuseManId)){
            paicheuseManId=null;
        }
        if ("请选择车牌号".equals(paichecarId)) {
            paichecarId=null;
        }
        if("请选择驾驶员".equals(paichedriverId)){
            paichedriverId=null;
        }
       if("".equals(paiCheDeptId)){
           paiCheDeptId=null;
        }
        if("".equals(paicheuseManId)){
            paicheuseManId=null;
        }
        if("".equals(paichecarId)){
            paichecarId=null;
        }
        if("".equals(paichedriverId)){
            paichedriverId=null;
        }
        if("".equals(paichestartTime)){
            paichestartTime=null;
        }
        if("".equals(paicheendTime)){
            paicheendTime=null;
        }
        page=(page-1)*limit;
        List<PaicheRecord> lists=paicheRecordDao.selectRecords(paiCheDeptId,paicheuseManId,paichecarId,paichedriverId,paichestartTime,paicheendTime,limit,page);

        return lists;
    }


    public List<PaicheRecord> selectchucheRecords(String chuCheDeptId,String chucheuseManId,String chuchecarId,
                                                  String chuchedriverId,String chuchestartTime,String chucheendTime,int limit,int page){
        if ("请选择部门".equals(chuCheDeptId)) {
            chuCheDeptId=null;
        }
        if("请选择用车人".equals(chucheuseManId)){
            chucheuseManId=null;
        }
        if ("请选择车牌号".equals(chuchecarId)) {
            chuchecarId=null;
        }
        if("".equals(chuchedriverId)){
            chuchedriverId=null;
        }
        if("请选择驾驶员".equals(chuchedriverId)){
            chuchedriverId=null;
        }
        if("".equals(chuCheDeptId)){
            chuCheDeptId=null;
        }
        if("".equals(chuchecarId)){
            chuchecarId=null;
        }
        if("".equals(chucheuseManId)){
            chucheuseManId=null;
        }
        if("".equals(chuchestartTime)){
            chuchestartTime=null;
        }
        if("".equals(chucheendTime)){
            chucheendTime=null;
        }
        page=(page-1)*limit;
        List<PaicheRecord> lists=paicheRecordDao.selectchucheRecords(chuCheDeptId,chucheuseManId,chuchecarId,chuchedriverId,chuchestartTime,chucheendTime,limit,page);
        for(int i=0;i<lists.size();i++){

            lists.get(i).setDrivingTime(foermat(lists.get(i).getDrivingTime()));
        }
        return lists;
    }

    /**
     * 根据派车单号查询某一条派车记录
     * @param paicheNo
     * @return
     */
    public PaicheRecord selectPaicheRecordById(String paicheNo){
        PaicheRecord paicheRecord=paicheRecordDao.selectPaicheRecordById(paicheNo);
        return paicheRecord;
    }


    //查询所有驾驶员
    public List<TDriver> selectAllDricer(){
        List<TDriver> list=paicheRecordDao.selectAllDricer();
        return list;
    }

    //查询所有的车牌号
    public List<TCar> selectAllCar(){
        List<TCar> carList=paicheRecordDao.selectAllCar();
        return carList;
    }

    //查询所有部门
    public List<TDriverDepartment> selectAllDepartment(){
        List<TDriverDepartment> deptList=paicheRecordDao.selectAllDepartment();
        return deptList;
    }

    //查询某个部门的用车人
    public List<TDriverUseMan> selectAllByDept(String deptId){
        List<TDriverUseMan> useManList=paicheRecordDao.selectAllByDept(deptId);
        return useManList;
    }

    /**
     * 取消派车单
     * @param paicheNo
     * @return
     */
    public void quxiaoPaiche(String paicheNo,String carNo){
        paicheRecordDao.quxiaoPaiche(paicheNo);
        paicheRecordDao.updateCarStatus(carNo);

    }


    /**
     * 删除派车单
     * @param paicheNo
     * @return
     */
    public void deletePaiche(String paicheNo,String carNo){
        paicheRecordDao.deletePaiche(paicheNo);
        paicheRecordDao.updateCarStatus(carNo);
    }

    /**
     * 把秒转换成时分秒
     * @param times
     * @return
     */
    public static String foermat(String times){
        Integer time=Integer.valueOf(times);
        if(time<0){
            time=-time;
        }
        int miao = time % 60;
        int fen = time / 60;
        int hour = 0;
        if (fen >= 60) {
            hour = fen / 60;
            fen = fen % 60;
        }
        String timeString = "";
        String miaoString = "";
        String fenString = "";
        String hourString = "";
        if (miao < 10) {
            miaoString = "0" + miao;
        } else {
            miaoString = miao + "";
        }
        if (fen < 10) {
            fenString = "0" + fen;
        } else {
            fenString = fen + "";
        }
        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = hour + "";
        }
        if (hour != 0) {
            timeString = hourString + ":" + fenString + ":" + miaoString;
        } else {
            timeString = fenString + ":" + miaoString;
        }
        return timeString;

    }

}
