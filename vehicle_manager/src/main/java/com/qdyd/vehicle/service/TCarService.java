package com.qdyd.vehicle.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.qdyd.vehicle.dao.TCarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qdyd.vehicle.po.HkPms;
import com.qdyd.vehicle.po.TCar;
import com.qdyd.vehicle.po.TCarStatus;
import com.qdyd.vehicle.po.TCarType;
import com.qdyd.vehicle.po.TDriver;
import com.qdyd.vehicle.util.IdWorker;

/** 
* @author 作者 : Czyer
* @version 创建时间：2019年8月12日 下午1:45:19 
* 类说明 
*/
@Service
public class TCarService {
	
	@Autowired
    private TCarDao carDao;
	
	@Autowired
	private IdWorker idW;

	//车牌号放栅接口
	public int iscarNo(String carNo){
			int a=carDao.iscarNo(carNo);
			return a;
	}
	
	/*
	 * 车牌号道闸接口 <出场>
	 */
	public int getOutCar(HkPms hkPms){
		String passTime=hkPms.getPassTime();
		//2019-09-01 12:19:40
		//System.out.println(passTime);
		//处理字符串
		StringBuilder sb = new StringBuilder(passTime);//构造一个StringBuilder对象
        sb.insert(4, "-");//在指定的位置1，插入指定的字符串
        sb.insert(7, "-");
        sb.insert(10, " ");
        sb.insert(13, ":");
        sb.insert(16, ":");
        passTime = sb.toString();
        passTime=passTime.substring(0,19);
		hkPms.setPassTime(passTime);
		int b=carDao.getOutCar(hkPms);
		//System.out.println(b);
		//System.out.println(passTime);
		sb=null;
		return b;
	}
	
	/*
	 * 车牌号道闸接口<返场>
	 */
	public int getIntoCar(HkPms hkPms){
		String passTime=hkPms.getPassTime();
		//2019-09-01 12:19:40
		//System.out.println(passTime);
		//处理字符串
		StringBuilder sb = new StringBuilder(passTime);//构造一个StringBuilder对象
        sb.insert(4, "-");//在指定的位置1，插入指定的字符串
        sb.insert(7, "-");
        sb.insert(10, " ");
        sb.insert(13, ":");
        sb.insert(16, ":");
        passTime = sb.toString();
        passTime=passTime.substring(0,19);
		hkPms.setPassTime(passTime);
		int b=carDao.getIntoCar(hkPms);
		//System.out.println(b);
		//System.out.println(passTime);
		sb=null;
		return b;
	}
	
	
	
	
	

	// 查询待命状态车辆
	public List<Map<Object,Object>> findstatus(){
		return carDao.findstatus();
	}
	
	// 查询"今日"值班员和班长

	public List<Map<Object, Object>> finddutydate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date time=null;
		   try {
			time= sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(time);
		return carDao.finddutydate(time);
	}

	// 查询执勤状态车辆
	public List<Map<Object,Object>> findstatus1(){
		return carDao.findstatus1();
	}

	
	
	//查询所有
	public List<Map<Object,Object>> findAll() {
		
		List<Map<Object,Object>> findAll = carDao.tcarfindAll();
        return findAll;
    }
	//查询所有
		public List<Map<Object,Object>> findAllnum(int page,int limit) {
			
			List<Map<Object,Object>> findAll = carDao.tcarfindAllnum((page-1)*limit,limit);
	        return findAll;
	    }
		
		//查询所有
		public List<Map<Object,Object>> tcarTypenum(int page,int limit) {
					
			List<Map<Object,Object>> findAll = carDao.tcarTypenum((page-1)*limit,limit);
			      return findAll;
		}
	//查询所有车辆总数
		public int findAllnum1() {
			int findAll = carDao.tcarfindAll().size();
	        return findAll;
	    }
		//查询所有车辆总数
				public int tcarTypenum1() {
					int findAll = carDao.tcarType().size();
			        return findAll;
			    }
	
	// 查询车牌号下拉选项
	public List<TCar> tcarNo(){
		return carDao.tcarNo();
	}
	
	// 查询车辆类型下拉选项
	public List<TCarType> tcarType(){
		return carDao.tcarType();
	}
	// 查询车辆状态下拉选项
	public List<TCarStatus> tcarStatus(){
		return carDao.tcarStatus();
	}
	
    //添加
	public int tcarinsert(TCar tCar) {
		String drivername=tCar.getCarDriverId();

		// 117746353165006 0288
		tCar.setCarId((idW.nextId()+"").substring(0,15));
		
		tCar.setCreateDate(new Date());
		
		tCar.setDataStatus(0);
		
		String driverid=(idW.nextId()+"");
		
		tCar.setCarDriverId(driverid);
		
		List<TDriver> isname = carDao.isname(drivername);
		System.out.println("czyczyczy:"+isname);
		if(isname!=null && !isname.isEmpty()){
			
			tCar.setCarDriverId(isname.get(0).getDriverId());
		}else{
			carDao.tdriverinsert(driverid,drivername);
		}
		
		carDao.tcarinsert(tCar);

		return 0;
    }

	// 删除
	public int tcardelete(String id) {
		carDao.tcardelete(id);
		return 0;
	}
	
	//通过id查询
	public List<Map<Object, Object>> tcarfindbyId(String carId){
		List<Map<Object, Object>> list=carDao.tcarfindbyId(carId);
		return list;
	}

	//修改
	public int tcarupdate(TCar tCar) {
		System.out.println("czyczy::"+tCar.toString());
		tCar.setCreateDate(new Date());
		tCar.setDataStatus(0);
		String drivername=tCar.getCarDriverId();
		String driverid=(idW.nextId()+"");
		List<TDriver> isname = carDao.isname(drivername);
		System.out.println("czyczyczy:"+isname);
		if(isname!=null && !isname.isEmpty()){

			tCar.setCarDriverId(isname.get(0).getDriverId());
		}else{
			carDao.tdriverinsert(driverid,drivername);
			tCar.setCarDriverId(driverid);
		}
		carDao.tcarupdate(tCar);

		return 0;
	}
	
	//多条件查询
		public List<Map<Object, Object>> tcarselect(TCar tCar) {
			System.out.println(tCar.toString());
			List<Map<Object, Object>> findAll = carDao.tcarselect(tCar);
			System.out.println(findAll);
			return findAll;
	    }
		
		
	
}
