package com.qdyd.vehicle.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qdyd.vehicle.po.HkPms;
import com.qdyd.vehicle.po.TCar;
import com.qdyd.vehicle.po.TCarStatus;
import com.qdyd.vehicle.po.TCarType;
import com.qdyd.vehicle.po.TDriver;

/** 
* @author 作者 : Czyer
* @version 创建时间：2019年8月12日 下午1:12:07 
* 类说明  
*/
@Mapper
public interface TCarDao{
	/*
	 * 车牌号道闸接口<判断车牌号能否开闸>
	 */
		@Select("<script>SELECT EXISTS(SELECT b.t_car_no  from t_paiche a,t_car b where a.t_car_id=b.t_car_id and a.t_status=2 and a.t_data_status=0 and b.t_car_no=#{carNo})</script>")
		public int iscarNo(String carNo);
	
	
	/*
	 * 车牌号道闸接口 <出场>
	 */
		@Update("update t_paiche a,t_car b set a.t_storage_time=#{passTime},b.t_status=1  where b.t_car_no=#{plateNo} and a.t_status=2 and b.t_status=2 and a.t_data_status=0 and a.t_car_id=b.t_car_id")
		public int getOutCar(HkPms hkPms);
	
	/*
	 * 车牌号道闸接口<返场>
	 */
		@Update("update t_paiche a,t_car b set a.t_return_time=#{passTime},b.t_status=3,a.t_status=3 where b.t_car_no=#{plateNo} and a.t_status=2 and b.t_status=1 and a.t_data_status=0 and a.t_car_id=b.t_car_id")
		public int getIntoCar(HkPms hkPms);
	
	
	
	// 增加
	@Insert("INSERT  INTO t_driver (t_driver_id,t_drive_name,t_data_status)   VALUE(#{driverid},#{drivername},0);")
	public void tdriverinsert(@Param("driverid") String driverid, @Param("drivername") String drivername);
	//判断是否重名
	@Select("SELECT a.t_driver_id driverId FROM t_driver a where a.t_drive_name=#{drivername};")
	public List<TDriver> isname(@Param("drivername") String drivername);



	// 查询"待命"车辆
//	@Select("SELECT\n" +
//			"\ta.t_car_id carId,\n" +
//			"\ta.t_car_no carNo,\n" +
//			"\ta.t_car_type carType,\n" +
//			"\ta.t_status STATUS,\n" +
//			"\ta.t_create_date createDate,\n" +
//			"\ta.t_data_status dataStatus,\n" +
//			"\ta.t_remark remark,\n" +
//			"\tb.status_name statusName,\n" +
//			"\tc.type_name typeName,\n" +
//			"\td.t_drive_name driverName\n" +
//			"FROM\n" +
//			"\tt_car a,\n" +
//			"\tt_car_status b,\n" +
//			"\tt_car_type c,\n" +
//			"\tt_driver d \n" +
//			"WHERE\n" +
//			"\ta.t_status = b.status_num \n" +
//			"\tAND a.t_car_type = c.type_num \n" +
//			"\tAND a.t_car_driver_id = d.t_driver_id \n" +
//			"\tAND a.t_data_status = 0\n" +
//			"\tand a.t_status=3\n" +
//			"ORDER BY\n" +
//			"\ta.t_create_date DESC")
//	public List<Map<Object,Object>> findstatus();
	// 查询"待命"车辆
	@Select("<script>SELECT*FROM t_car a,t_car_type b,t_driver c WHERE a.t_car_type=b.type_num and a.t_car_driver_id=c.t_driver_id and a.t_status = 3 and a.t_data_status=0</script>")
	public List<Map<Object, Object>> findstatus();
	
	
	
	
	// 查询"出勤"车辆
	@Select("<script>SELECT\r\n" + 
			"	a.t_car_id,\r\n" + 
			"	a.t_car_no,\r\n" + 
			"	a.t_status,\r\n" + 
			"	c.type_name,\r\n" + 
			"	d.t_drive_name,\r\n" + 
			"	e.t_return_time,\r\n" + 
			"	e.t_storage_time,\r\n" + 
			"	e.t_guji_reture_time,\r\n" + 
			"	e.t_guji_storage_time,\r\n" + 
			"	f.status_name,\r\n" + 
			"	g.t_cause\r\n" + 
			"FROM\r\n" + 
			"	t_car a,\r\n" + 
			"	t_car_type c,\r\n" + 
			"	t_driver d,\r\n" + 
			"	t_paiche e,\r\n" + 
			"	t_car_status f,\r\n" + 
			"	t_matter g\r\n" + 
			"WHERE\r\n" + 
			"	a.t_car_type = c.type_num\r\n" + 
			"AND e.t_driver_id = d.t_driver_id\r\n" +
			"AND a.t_car_id = e.t_car_id\r\n" + 
			"AND a.t_status = f.status_num\r\n" + 
			"AND e.t_cause = g.t_id\r\n" + 
			"AND a.t_data_status = 0 AND e.t_data_status = 0 \r\n" +
			"AND (a.t_status IN('1', '2'))\r\n" + 
			"AND e.t_status= 2\r\n" + 
			"GROUP BY\r\n" + 
			"	a.t_car_id,\r\n" + 
			"	a.t_car_no,\r\n" + 
			"	a.t_status,\r\n" + 
			"	c.type_name,\r\n" + 
			"	d.t_drive_name,\r\n" + 
			"	e.t_return_time,\r\n" + 
			"	e.t_storage_time,\r\n" + 
			"	e.t_guji_reture_time,\r\n" + 
			"	e.t_guji_storage_time,\r\n" + 
			"	f.status_name,\r\n" + 
			"	g.t_cause\r\n" + 
			"ORDER BY\r\n" + 
			"	a.t_status ASC</script>")
	public List<Map<Object, Object>> findstatus1();
	
	// 查询"今日"值班员和班长
		@Select("<script>SELECT * from t_duty where  duty_date=#{dutydate}</script>")
		public List<Map<Object, Object>> finddutydate(Date dutydate);
	
	
			
	// 查询所有数
	@Select("<script>select a.t_car_id carId,a.t_car_no carNo,a.t_car_type carType,a.t_status status,a.t_create_date createDate,a.t_data_status dataStatus,a.t_remark remark,b.status_name statusName,c.type_name typeName,d.t_drive_name driverName"
			+ " from t_car a,t_car_status b,t_car_type c,t_driver d where a.t_status=b.status_num and a.t_car_type=c.type_num and a.t_car_driver_id=d.t_driver_id and a.t_data_status=0 and a.t_data_status=0 order by a.t_create_date desc limit #{page}, #{limit} </script>")
	public List<Map<Object, Object>> tcarfindAllnum(@Param("page") int page, @Param("limit") int limit);
	// 查询所有
		@Select("<script>select a.t_car_id carId,a.t_car_no carNo,a.t_car_type carType,a.t_status status,a.t_create_date createDate,a.t_data_status dataStatus,a.t_remark remark,b.status_name statusName,c.type_name typeName,d.t_drive_name driverName"
				+ " from t_car a,t_car_status b,t_car_type c,t_driver d where a.t_status=b.status_num and a.t_car_type=c.type_num and a.t_car_driver_id=d.t_driver_id and a.t_data_status=0 order by a.t_create_date desc </script>")
		public List<Map<Object, Object>> tcarfindAll();
	
	// 查询车牌号下拉选项
	@Select("<script>select t_car_id carId,t_car_no carNo from t_car where t_data_status=0 </script>")
	public List<TCar> tcarNo();
	// 查询所有数
		@Select("<script>select type_num typeNum,type_name typeName from t_car_type limit #{page}, #{limit} </script>")
		public List<Map<Object, Object>> tcarTypenum(@Param("page") int page, @Param("limit") int limit);
	// 查询车辆类型下拉选项
		@Select("<script>select type_num typeNum,type_name typeName from t_car_type</script>")
		public List<TCarType> tcarType();
			
	// 查询车辆状态下拉选项
	    @Select("<script>select status_num statusNum,status_name statusName from t_car_status</script>")
		public List<TCarStatus> tcarStatus();
	
	// 通过id查询
	@Select("<script>select a.t_car_id carId,a.t_car_no carNo,a.t_car_driver_id carDriverId,a.t_car_type carType,a.t_status status,a.t_create_date createDate,a.t_data_status dataStatus,a.t_remark remark,b.t_drive_name driveName "
			+ " from t_car a,t_driver b where a.t_car_driver_id=b.t_driver_id and a.t_car_id=#{carId}</script>")
	public List<Map<Object, Object>> tcarfindbyId(String carId);
	
	// 增加
	@Insert("INSERT into t_car(t_car_id,t_car_no,t_car_driver_id,t_car_type,t_status,t_create_date,t_data_status,t_remark) VALUES(#{carId},#{carNo},#{carDriverId},#{carType},#{status},#{createDate},#{dataStatus},#{remark});")
	public int tcarinsert(TCar tCar);

	// 删除
//	@Delete("delete from t_car where t_car_id=#{0};")
//	public int tcardelete(String id);
	@Update("update t_car set t_data_status=1 where t_car_id=#{carId};")
	public int tcardelete(String carId);

	// 修改
	@Update("update t_car set t_car_no=#{carNo},t_car_driver_id=#{carDriverId},t_car_type=#{carType},t_status=#{status},t_create_date=#{createDate},t_data_status=#{dataStatus},t_remark=#{remark} where t_car_id=#{carId};")
	public int tcarupdate(TCar tCar);
	
	// 多条件查询
	@Select(value={"<script>" +
            " select a.t_car_id carId,a.t_car_no carNo,a.t_car_type carType,a.t_status status,a.t_create_date createDate,a.t_data_status dataStatus,a.t_remark remark,b.status_name statusName,c.type_name typeName,d.t_drive_name driverName"
			+ " from t_car a,t_car_status b,t_car_type c,t_driver d " +
			"where a.t_status=b.status_num and a.t_car_type=c.type_num and a.t_car_driver_id=d.t_driver_id and a.t_data_status=0 "+
            " <if test='carNo != null and  carNo !=\"\" '>"+" and a.t_car_no=#{carNo} "+"</if> "+
            " <if test='carDriverId != null and  carDriverId !=\"\" '>"+" and a.t_car_driver_id=#{carDriverId} "+"</if> "+
            " <if test='carType != null and carType !=\"\" '> "+" and a.t_car_type=#{carType} "+"</if> "+
            " <if test='status != null and status !=\"\" '> "+"and a.t_status=#{status} "+"</if> "+
            " order by a.t_create_date desc </script>"})
	//order by a.t_create_date desc
	public List<Map<Object, Object>> tcarselect(TCar tCar);
	
}
