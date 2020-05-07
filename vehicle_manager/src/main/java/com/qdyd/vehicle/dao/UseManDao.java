package com.qdyd.vehicle.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qdyd.vehicle.po.TCar;
import com.qdyd.vehicle.po.TDriver;
import com.qdyd.vehicle.po.TDriverDepartment;
import com.qdyd.vehicle.po.TDriverStatus;

/** 
* @author 作者 : Czyer
* @version 创建时间：2019年8月12日 下午1:12:07 
* 类说明  
*/
@Mapper
public interface UseManDao{

	// 查询所有
	@Select("<script>select a.t_driver_id driverId,a.t_use_name driverName,a.t_department department,a.t_tel tel,a.t_card_id cardId,a.t_status status,a.t_data_status dataStatus,a.t_remark remark ,c.department_name departmentName"
			+ " from t_driver_use_man a,t_driver_department c where a.t_data_status=0 and a.t_department=c.department_num</script>")
	public List<Map<Object, Object>> tcarfindAll();
	
	// 查询驾驶员姓名下拉选项
		@Select("<script>select t_driver_id driverId, t_use_name driverName from t_driver_use_man where t_data_status=0</script>")
		public List<TDriver> tdriverName();
	
	// 查询驾驶员手机号下拉选项
	    @Select("<script>select t_tel tel from t_driver_use_man where t_data_status=0</script>")
		public List<TDriver> tdriverTel();
	
	// 查询驾驶员状态下拉选项
		@Select("<script>select * from t_driver_status</script>")
		public List<TDriverStatus> tdriverStatus();
	
	// 查询驾驶员部门下拉选项
		@Select("<script>select * from t_driver_department</script>")
		public List<TDriverDepartment> tdriverDepartment();
	
	// 通过id查询
		@Select("<script>select t_driver_id driverId,t_use_name driverName,t_department department,t_tel tel,t_card_id cardId,t_status status,t_data_status dataStatus,t_remark remark "
				+ " from t_driver_use_man where t_driver_id=#{driverId}</script>")
		public List<TDriver> tcarfindbyId(String driverId);

	// 增加
	@Insert("INSERT into t_driver_use_man(t_driver_id,t_use_name,t_department,t_tel,t_card_id,t_data_status,t_remark) VALUES(#{driverId},#{driverName},#{department},#{tel},#{cardId},#{dataStatus},#{remark});")
	public int tcarinsert(TDriver tDriver);

	// 删除
//	@Delete("delete from t_car where t_car_id=#{0};")
//	public int tcardelete(String id);
	@Update("update t_driver_use_man set t_data_status=1 where t_driver_id=#{driverId};")
	public int tcardelete(String driverId);

	// 修改
	@Update("update t_driver_use_man set t_use_name=#{driverName},t_department=#{department},t_tel=#{tel},t_card_id=#{cardId},t_status=#{status},t_remark=#{remark} where t_driver_id=#{driverId};")
	public int tcarupdate(TDriver tDriver);
	
	// 多条件查询
		@Select(value={"<script>" +
	            " select a.t_driver_id driverId,a.t_use_name driverName,a.t_department department,a.t_tel tel,a.t_card_id cardId,a.t_status status,a.t_data_status dataStatus,a.t_remark remark ,c.department_name departmentName"
			+ " from t_driver_use_man a,t_driver_department c where a.t_data_status=0 and a.t_department=c.department_num"+
	            " <if test='driverName != null and  driverName !=\"\" '>"+" and a.t_use_name=#{driverName} "+"</if> "+
	            " <if test='department != null and department !=\"\" '> "+" and a.t_department=#{department} "+"</if> "+
	            " <if test='tel != null and tel !=\"\" '> "+" and a.t_tel=#{tel} "+"</if> "+
	            " <if test='status != null and status !=\"\" '> "+"and a.t_status=#{status} "+"</if> "+
	            " </script>"})
		public List<Map<Object, Object>> tcarselect(TDriver tDriver); 

	
}
