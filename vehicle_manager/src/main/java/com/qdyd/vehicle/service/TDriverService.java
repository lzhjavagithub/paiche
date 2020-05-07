package com.qdyd.vehicle.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qdyd.vehicle.dao.TCarDao;
import com.qdyd.vehicle.dao.TDriverDao;
import com.qdyd.vehicle.po.TCar;
import com.qdyd.vehicle.po.TCarStatus;
import com.qdyd.vehicle.po.TDriver;
import com.qdyd.vehicle.po.TDriverDepartment;
import com.qdyd.vehicle.po.TDriverStatus;
import com.qdyd.vehicle.util.IdWorker;

/** 
* @author 作者 : Czyer
* @version 创建时间：2019年8月12日 下午1:45:19 
* 类说明 
*/
@Service
public class TDriverService {
	
	@Autowired
    private TDriverDao tDriverDao;
	
	@Autowired
	private IdWorker idW;
				/*
				 * 部门
				 */
				// 查询所有
				public int departmentfindAll() {
					int findAll = tDriverDao.departmentfindAll().size();
					return findAll;
				}
				//查询所有
				public List<Map<Object, Object>> departmentfindAllnum(int page,int limit) {
					List<Map<Object, Object>> findAll = tDriverDao.departmentfindAllnum((page-1)*limit,limit);
			        return findAll;
			    }
				public int departmentdelete(String department_id){
					return tDriverDao.departmentdelete(department_id);
				}		
				public List<Map<Object, Object>> departmentfindbyId(String department_id){
					return tDriverDao.departmentfindbyId(department_id);
				}
				public int departmentinsert(TDriverDepartment tDriverDepartment){
					tDriverDepartment.setDepartmentId((idW.nextId()+"").substring(0,15));
					tDriverDepartment.setDepartmentNum((idW.nextId()+"").substring(0,15));
					tDriverDepartment.setDepartmentDate(new Date());
					tDriverDepartment.setDataStatus(0);
					return tDriverDao.departmentinsert(tDriverDepartment);
				}
				public int departmentupdate(TDriverDepartment tDriverDepartment){
					tDriverDepartment.setDepartmentDate(new Date());
					return tDriverDao.departmentupdate(tDriverDepartment);
				}
				
				/*
				 * 状态
				 */
				
				
				// 查询所有
				public int carStatusfindAll() {
					int findAll = tDriverDao.carStatusfindAll().size();
					return findAll;
				}
				//查询所有
				public List<Map<Object, Object>> carStatusfindAllnum(int page,int limit) {
					List<Map<Object, Object>> findAll = tDriverDao.carStatusfindAllnum((page-1)*limit,limit);
			        return findAll;
			    }
				public int carStatusdelete(String department_id){
					return tDriverDao.carStatusdelete(department_id);
				}		
				public List<Map<Object, Object>> carStatusfindbyId(String department_id){
					return tDriverDao.carStatusfindbyId(department_id);
				}
				public int carStatusinsert(TCarStatus carStatus){
					carStatus.setCarStatusId((idW.nextId()+""));
					carStatus.setStatusNum((idW.nextId()+""));
					return tDriverDao.carStatusinsert(carStatus);
				}
				public int carStatusupdate(TCarStatus carStatus){
					return tDriverDao.carStatusupdate(carStatus);
				}
	
	//查询所有
	public List<Map<Object, Object>> findAll() {
		List<Map<Object, Object>> findAll = tDriverDao.tcarfindAll();
        return findAll;
    }
	
	// 查询驾驶员姓名下拉选项
	public List<TDriver> tdriverName(){
		return tDriverDao.tdriverName();
	}
		
	// 查询驾驶员手机号下拉选项
	public List<TDriver> tdriverTel(){
		return tDriverDao.tdriverTel();
	}
	
	// 查询驾驶员状态下拉选项
	public List<TDriverStatus> tdriverStatus(){
		return tDriverDao.tdriverStatus();
	}
	
	// 查询驾驶员部门下拉选项
		public List<TDriverDepartment> tdriverDepartment(){
			return tDriverDao.tdriverDepartment();
		}
	
    //添加
	public int tcarinsert(TDriver tDriver) {
		tDriver.setDriverId((idW.nextId()+""));
		tDriver.setDataStatus(0);
		tDriverDao.tcarinsert(tDriver);
		//System.out.println(tDriver.getDriverName());
		return 0;
    }

	// 删除
	public int tcardelete(String id) {
		tDriverDao.tcardelete(id);
		return 0;
	}
	//通过id查询
	public List<TDriver> tcarfindbyId(String driverId){
		List<TDriver> list=tDriverDao.tcarfindbyId(driverId);
		return list;
	}
	// 修改
	public int tcarupdate(TDriver tDriver) {
		tDriverDao.tcarupdate(tDriver);
		return 0;
	}
	
	//多条件查询
		public List<Map<Object, Object>> tcarselect(TDriver tDriver) {
			List<Map<Object, Object>> findAll = tDriverDao.tcarselect(tDriver);
			System.out.println(tDriver.getDriverName());
			System.out.println(tDriver.getTel());
			System.out.println(tDriver.getStatus());
			return findAll;
	    }
		
	
}
