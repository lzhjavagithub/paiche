package com.qdyd.vehicle.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qdyd.vehicle.dao.UseManDao;
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
public class UseManService {
	
	@Autowired
    private UseManDao useManDao;
	
	@Autowired
	private IdWorker idW;
	
	//查询所有
	public List<Map<Object, Object>> findAll() {
		List<Map<Object, Object>> findAll = useManDao.tcarfindAll();
        return findAll;
    }
	
	// 查询驾驶员姓名下拉选项
	public List<TDriver> tdriverName(){
		return useManDao.tdriverName();
	}
		
	// 查询驾驶员手机号下拉选项
	public List<TDriver> tdriverTel(){
		return useManDao.tdriverTel();
	}
	
	// 查询驾驶员状态下拉选项
	public List<TDriverStatus> tdriverStatus(){
		return useManDao.tdriverStatus();
	}
	
	// 查询驾驶员部门下拉选项
		public List<TDriverDepartment> tdriverDepartment(){
			return useManDao.tdriverDepartment();
		}
	
    //添加
	public int tcarinsert(TDriver tDriver) {
		tDriver.setDriverId((idW.nextId()+"").substring(4));
		tDriver.setDataStatus(0);
		useManDao.tcarinsert(tDriver);
		//System.out.println(tDriver.getDriverName());
		return 0;
    }

	// 删除
	public int tcardelete(String id) {
		useManDao.tcardelete(id);
		return 0;
	}
	//通过id查询
	public List<TDriver> tcarfindbyId(String driverId){
		List<TDriver> list=useManDao.tcarfindbyId(driverId);
		return list;
	}
	// 修改
	public int tcarupdate(TDriver tDriver) {
		useManDao.tcarupdate(tDriver);
		return 0;
	}
	
	//多条件查询
		public List<Map<Object, Object>> tcarselect(TDriver tDriver) {
			List<Map<Object, Object>> findAll = useManDao.tcarselect(tDriver);
			System.out.println(tDriver.getDriverName());
			System.out.println(tDriver.getTel());
			System.out.println(tDriver.getStatus());
			return findAll;
	    }
		
	
}
