package com.qdyd.vehicle.dao;

import com.qdyd.vehicle.po.*;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface TPaiCheMapper {
    // 条件查询 是否存在  用车人、事由、车牌号、驾驶员姓名、目的地 车型
    @Select("select c.type_num typeNum,c.type_name typeName from t_car_type c where c.type_name=#{typeName}")
    public List<TCarType> cartype(@Param("typeName") String typeName);

    @Select("select dum.t_driver_id driverId,dum.t_use_name useName from t_driver_use_man dum where t_use_name=#{useName}")
    public List<TDriverUseMan> findTDriverUseMan(@Param("useName") String useName);

    @Select("select d.t_driver_id driverId,d.t_drive_name driverName from t_driver d where d.t_drive_name=#{driverName}")
    public List<TDriver> findTDriver(@Param("driverName") String driverName);

    @Select("select c.t_car_id carId,c.t_car_no carNo,c.t_car_type carType from t_car c where c.t_car_no=#{carNo}")
    public List<TCar> findCar(@Param("carNo") String carNo);

    @Select("select m.t_id tid,m.t_cause cause from t_matter m where m.t_cause=#{cause}")
    public List<TMatter> findMatter(@Param("cause") String cause);

    @Select("select d.t_des_id desId,d.t_des_name desName from t_destination d where d.t_des_name=#{desName}")
    public List<TDestination> findDes(@Param("desName") String desName);

    // 保存手动输入到用车人
    @Insert("insert into t_driver_use_man(t_driver_id,t_use_name,t_department,t_data_status) values(#{driverId},#{useName},#{department},#{dataStatus})")
    public void saveUseMan(TDriverUseMan driverUseMan);

    // 保存手动输入的事由
    @Insert("insert into t_matter(t_id,t_cause,t_create_date,t_data_status) values(#{tid},#{cause},#{createDate},#{dataStatus})")
    void saveMatter(TMatter matter);

    // 保存手动输入的车牌号
    @Insert("insert into t_car(t_car_id,t_car_no,t_car_type,t_status,t_create_date,t_data_status,t_car_driver_id) " +
            "values(#{carId},#{carNo},#{carType},#{status},#{createDate},#{dataStatus},#{carDriverId})")
    void saveCarId(TCar car);

    @Update("update t_car set t_car_driver_id=#{carDriverId} where t_car_id = #{carId}")
    void updateCarIdDrverId(@Param("carDriverId") String carDriverId,@Param("carId") String carId);

    // 保存手动输入的驾驶员姓名
    @Insert("insert into t_driver(t_driver_id,t_drive_name,t_data_status) values(#{driverId},#{driverName},#{dataStatus})")
    void saveDriver(TDriver driver);

    @Insert("insert into t_destination(t_des_id,t_des_name,t_des_time) values(#{desId},#{desName},#{desTime})")
    void saveDes(TDestination destination);

    //根据车辆ID查询驾驶员
    @Select("SELECT\n" +
            "\td.t_drive_name,c.t_car_no,d.t_driver_id\n" +
            "FROM\n" +
            "\tt_car c,\n" +
            "\tt_driver d \n" +
            "WHERE\n" +
            "\td.t_driver_id=c.t_car_driver_id\n" +
            "\tand c.t_car_id=#{id}")
    public List<Map<String,Object>> findcardriver(String id);

    // 派车单的  待命车辆  下拉框
    @Select("select t_car_id carId,t_car_no carNo from t_car where t_data_status=0 and t_status=3")
    public List<TCar> cardaimingselect();

    // 查询车牌号
    @Select("<script>SELECT\n" +
            "\t t_car_id value,t_car_no title \n" +
            "FROM\n" +
            "\tt_car c\n" +
            "WHERE\n" +
            "\tc.t_data_status =0 </script>")
    public List<Map<Object,Object>> carno();

    @Select("select * from t_driver_use_man a,t_driver_department b where a." +
            "t_department=b.department_num and a.t_data_status=0 " +
            "and a.t_driver_id=#{driverName}")
    public List<Map<Object,Object>> mantodept(String driverName);

    /**
     * 查询派车单列表
     * @return
     */
    public List<Map<Object,Object>> find();

    /**
     * 根据ID查询派车单
     * @param id
     * @return
     */
    public List<Map<Object,Object>> findbyid(String id);

    // 改变车辆状态  为出勤-待勤状态
    @Update("update t_car set t_status=2 where t_car_id=#{id}")
    public void updateCarStatus(String id);

    /**
     * 新增派车单
     * @param paiChe
     */
    @Insert("insert into t_paiche" +
            "(t_paiche_id,t_no,t_date,t_use_man,t_cause,t_car_type,t_weight,t_dept_id," +
            "t_car_id,t_driver_id,t_des_id,t_drive_time, t_go_mileage,t_come_mileage," +
            "t_mileage,t_data_status,t_com_mander,t_audit_leadership,t_return_time,t_storage_time,t_guji_reture_time," +
            "t_guji_storage_time,t_remark,t_status)VALUES" +
            "(#{paicheId},#{no},#{date},#{useMan},#{cause},#{carType},#{weight},#{deptId}," +
            "#{carId},#{driverId},#{destination},#{driveTime},#{goMileage},#{comeMileage}," +
            "#{mileage},#{dataStatus},#{comMander},#{auditLeaderShip},#{returnTime},#{storageTime}," +
            "#{gujiRetureTime},#{gujiStorageTime},#{remark},#{status})")
    public void insert(TPaiChe paiChe);

    // 保存派车单手动输入的用车人
    @Insert("insert into t_driver_use_man(t_driver_id,t_use_name,t_department,t_tel,t_card_id,t_status," +
            "t_data_status,t_remark) values(#{driverId},#{useName},#{department},#{tel},#{cardId},#{status}," +
            "#{dataStatus},#{remark})")
    public void insertUserMan(TDriverUseMan driverUseMan);

    /**
     * 虚拟删除派车单
     * @param paicheId
     */
    @Update("update t_paiche set t_data_status=1 where t_paiche_id=#{paicheId}")
    public void deletePaice(String paicheId);

    /**
     * 修改派车状态
     */
    @Update("update t_paiche set t_status=#{status} where t_paiche_id=#{paicheId}")
    public void updatePaiceStatus(@Param("status") String status, @Param("paicheId") String paicheId);
}
