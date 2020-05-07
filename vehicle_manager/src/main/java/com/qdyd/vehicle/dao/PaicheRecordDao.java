package com.qdyd.vehicle.dao;

import com.qdyd.vehicle.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface PaicheRecordDao {


    /**
     * 按照条件查询日记记录
     //* @param paichestartTime
     //* @param paicheendTime
     * @return
     */
 @Select("<script> select p.t_no paicheno,DATE_FORMAT(p.t_date,'%Y-%m-%d %H:%i:%s') as  paichedate, " +
            "dum.t_use_name useMan,tm.t_cause cause,p.t_man man,p.t_weight weight,td.t_des_name destination,c.t_car_no carNo, " +
            "ct.type_name carType,d.t_drive_name driverName,p.t_guji_storage_time gujistorageTime, " +
            "p.t_guji_reture_time gujireturnTime,p.t_status status " +
            //"FROM t_driver_department dd join t_driver_use_man dum on dd.department_num=dum.t_department " +
            "FROM  t_driver_use_man dum join t_paiche p ON dum.t_driver_id=p.t_use_man " +
            "join t_driver d on d.t_driver_id=p.t_driver_id " +
            "join t_car c on c.t_car_id=p.t_car_id " +
            "join t_car_type ct on ct.type_num=p.t_car_type " +
            "join t_destination td on td.t_des_id=p.t_des_id " +
            "join t_matter tm on p.t_cause=tm.t_id where p.t_data_status=0 and p.t_status!=3" +
            "<if test='paiCheDeptId!=null'> and dum.t_department=#{paiCheDeptId} </if> " +
            "<if test='paicheuseManId!=null'> and p.t_use_man=#{paicheuseManId} </if> " +
            "<if test='paichecarId!=null'> and p.t_car_id=#{paichecarId} </if> " +
            "<if test='paichedriverId!=null'> and p.t_driver_id=#{paichedriverId} </if> " +
            "<if test='paichestartTime!=null and paicheendTime!=null'> and  DATE_FORMAT(p.t_date,'%Y-%m-%d') between '${paichestartTime}' and '${paicheendTime}' </if>" +
            " ORDER BY p.t_date desc <if test='limit!=0 and page!=0'> limit #{page},#{limit} </if> </script>")
    List<PaicheRecord> selectRecords(@Param(value = "paiCheDeptId") String paiCheDeptId, @Param(value = "paicheuseManId") String paicheuseManId,
                                     @Param(value = "paichecarId") String paichecarId, @Param(value = "paichedriverId") String paichedriverId,
                                     @Param(value = "paichestartTime") String paichestartTime, @Param(value = "paicheendTime") String paicheendTime,
                                     @Param(value = "limit") int limit, @Param(value = "page") int page);


    /**
     * 出车记录查询
     * @param chuCheDeptId
     * @param chucheuseManId
     * @param chuchecarId
     * @param chuchedriverId
     * @param chuchestartTime
     * @param chucheendTime
     * @param limit
     * @param page
     * @return
     */
   @Select("<script>select c.t_car_no carNo,ct.type_name carType,d.t_drive_name driverName,td.t_des_name destination, " +
            /*"p.t_cause cause,DATE_FORMAT(p.t_storage_time,'%Y-%m-%d %H:%i:%s') as  storageTime, " +
            "DATE_FORMAT(p.t_return_time,'%Y-%m-%d %H:%i:%s') as  returnTime,p.t_mileage mileage, " +
            "TIMESTAMPDIFF(SECOND,DATE_FORMAT(p.t_storage_time,'%Y-%m-%d %H:%i:%s'),DATE_FORMAT(p.t_return_time,'%Y-%m-%d %H:%i:%s')) as  drivingTime " +*/
           "tm.t_cause cause,p.t_storage_time storageTime,p.t_return_time returnTime,p.t_mileage mileage, " +
           "TIMESTAMPDIFF(SECOND,p.t_storage_time,p.t_return_time) as drivingTime,tdu.t_use_name useMan " +
           "FROM t_driver_department dd join t_driver_use_man dum on dd.department_num=dum.t_department " +
            "join t_paiche p ON dum.t_driver_id=p.t_use_man " +
            "join t_driver d on d.t_driver_id=p.t_driver_id " +
            "join t_car c on c.t_car_id=p.t_car_id " +
            "join t_car_type ct on ct.type_num=p.t_car_type " +
            "join t_destination td on td.t_des_id=p.t_des_id  " +
           "join t_driver_use_man tdu on tdu.t_driver_id=p.t_use_man  " +
           "join t_matter tm on p.t_cause=tm.t_id  where  p.t_status=3 and p.t_data_status=0" +
            "<if test='chuCheDeptId!=null'> and dum.t_department=#{chuCheDeptId} </if> " +
            "<if test='chucheuseManId!=null'> and p.t_use_man=#{chucheuseManId} </if> " +
            "<if test='chuchecarId!=null'> and p.t_car_id=#{chuchecarId} </if> " +
            "<if test='chuchedriverId!=null'> and p.t_driver_id=#{chuchedriverId} </if> " +
            "<if test='chuchestartTime!=null and chucheendTime!=null'> and  DATE_FORMAT(p.t_drive_time,'%Y-%m-%d') between '${chuchestartTime}' and '${chucheendTime}' </if>" +
           " ORDER BY p.t_date desc <if test='limit!=0 and page!=0'> limit #{page},#{limit} </if> </script>")
    List<PaicheRecord> selectchucheRecords(@Param(value = "chuCheDeptId") String chuCheDeptId, @Param(value = "chucheuseManId") String chucheuseManId,
                                           @Param(value = "chuchecarId") String chuchecarId, @Param(value = "chuchedriverId") String chuchedriverId,
                                           @Param(value = "chuchestartTime") String chuchestartTime, @Param(value = "chucheendTime") String chucheendTime,
                                           @Param(value = "limit") int limit, @Param(value = "page") int page);


   /*
   *打印某一条派车记录
    */
 @Select("<script> select p.t_no paicheno,DATE_FORMAT(p.t_date,'%Y-%m-%d %H:%i:%s') as  paichedate, " +
         "dum.t_use_name useMan,tm.t_cause cause,p.t_man man,p.t_weight weight,td.t_des_name destination,c.t_car_no carNo, " +
         "ct.type_name carType,d.t_drive_name driverName,p.t_guji_storage_time gujistorageTime, " +
         "p.t_guji_reture_time gujireturnTime,p.t_status status " +
         "FROM  t_driver_use_man dum join t_paiche p ON dum.t_driver_id=p.t_use_man " +
         "join t_driver d on d.t_driver_id=p.t_driver_id " +
         "join t_car c on c.t_car_id=p.t_car_id " +
         "join t_car_type ct on ct.type_num=p.t_car_type " +
         "join t_destination td on td.t_des_id=p.t_des_id " +
         "join t_matter tm on p.t_cause=tm.t_id where p.t_data_status=0 and p.t_status!=3 " +
         "and p.t_no=#{paicheNo}</script>")
     PaicheRecord selectPaicheRecordById(String paicheNo);


   /*
    @Select("<script> select p.t_no paicheno,DATE_FORMAT(p.t_date,'%Y-%m-%d %H:%i:%s') as  paichedate,dd.department_name department, " +
            "dum.t_use_name useMan,p.t_cause cause,p.t_man man,p.t_weight weight,td.t_des_name destination,c.t_car_no carNo, " +
            "ct.type_name carType,d.t_drive_name driverName,p.t_com_mander comMander,p.t_audit_leadership auditLeaderShip " +
            "FROM t_driver_department dd join t_driver_use_man dum on dd.department_num=dum.t_department " +
            "join t_paiche p ON dum.t_driver_id=p.t_use_man " +
            "join t_paiche_car_driver tpcd on tpcd.t_paiche_id=p.t_paiche_id "+
            "join t_car c on c.t_car_id=tpcd.t_car_id " +
            "join t_car_type ct on ct.type_num=c.t_car_type " +
            "join t_driver d on d.t_driver_id=tpcd.t_driver_id " +
            "join t_destination td on td.t_des_id=p.t_des_id where p.t_status=2 " +
            "<if test='paicchedriverId!=null'> and p.t_dept_id=#{paicchedriverId} </if> " +
            "<if test='userManId!=null'> and p.t_use_man=#{userManId} </if> " +
            "<if test='paichestartTime!=null and paicheendTime!=null'> and  DATE_FORMAT(p.t_date,'%Y-%m-%d') between '${paichestartTime}' and '${paicheendTime}' </if>" +
            " ORDER BY p.t_date desc</script>")
    List<PaicheRecord> selectRecords(@Param(value = "paicchedriverId") String paicchedriverId,@Param(value = "userManId") String userManId,@Param(value = "paichestartTime") String paichestartTime, @Param(value = "paicheendTime") String paicheendTime);
*/


   /* @Select("<script> " +
            "select dd.department_name,dum.t_use_name useMan,p.t_cause cause,td.t_des_name destination,c.t_car_no carNo,ct.type_name carType," +
            "d.t_drive_name driverName,DATE_FORMAT(p.t_drive_time,'%Y-%m-%d %H:%i:%s') as  driveTime,p.t_mileage mileage,p.t_com_mander comMander," +
            "p.t_audit_leadership auditLeaderShip,DATE_FORMAT(p.t_return_time,'%Y-%m-%d %H:%i:%s') as  returnTime " +
            "FROM t_driver_department dd join t_driver_use_man dum on dd.department_num=dum.t_department " +
            "join t_paiche p ON dum.t_driver_id=p.t_use_man " +
            "join t_driver d on d.t_driver_id=p.t_driver_id " +
            "join t_car c on c.t_car_driver_id=d.t_driver_id " +
            "join t_car_type ct on ct.type_num=c.t_car_type " +
            "join t_destination td on td.t_des_id=p.t_des_id  where p.t_return_time is not null and p.t_status=2 " +
            "<if test='chuCheDeptId!=null'> and p.t_dept_id=#{chuCheDeptId} </if> " +
            "<if test='chucheuseManId!=null'> and p.t_use_man=#{chucheuseManId} </if> " +
            "<if test='chuchecarId!=null'> and p.t_car_id=#{chuchecarId} </if> " +
            "<if test='chuchedriverId!=null'> and p.t_driver_id=#{chuchedriverId} </if> " +
            "<if test='chuchestartTime!=null and chucheendTime!=null'> and  DATE_FORMAT(p.t_date,'%Y-%m-%d') between '${chuchestartTime}' and '${chucheendTime}' </if>" +
            " ORDER BY p.t_date desc</script>")
    List<PaicheRecord> selectchucheRecords(@Param(value = "chuCheDeptId") String chuCheDeptId, @Param(value = "chucheuseManId") String chucheuseManId,
                                           @Param(value = "chuchecarId") String chuchecarId, @Param(value = "chuchedriverId") String chuchedriverId,
                                           @Param(value = "chuchestartTime") String chuchestartTime, @Param(value = "chucheendTime") String chucheendTime);*/

    //查询所有的驾驶员
    @Select("<script>select t_driver_id driverId,t_drive_name driverName,t_department department,t_tel tel,t_card_id cardId,t_status status,t_data_status dataStatus,t_remark remark from t_driver</script>")
    public List<TDriver> selectAllDricer();

    //查询所有的车牌号
    @Select("<script>select t_car_id carId,t_car_no carNo,t_car_driver_id carDriverId,t_car_type carType,t_status status,t_create_date createDate,t_remark remark from t_car</script>")
    public List<TCar> selectAllCar();

    //查询所有的部门
    @Select("<script>select department_num departmentNum,department_name departmentName  from t_driver_department</script>")
    public List<TDriverDepartment> selectAllDepartment();

    //查询某个部门所有的用车人
    @Select("<script>select t_driver_id driverId,t_use_name useName,t_department department,t_tel tel,t_card_id cardId,t_status status,t_data_status dataStatus,t_remark remark from t_driver_use_man where t_department=#{deptId}</script>")
    public List<TDriverUseMan> selectAllByDept(String deptId);

    /**
     * 取消派车单
     * @param paicheNo
     * @returnno
     */
    @Update("<script>update t_paiche set t_status=3 where t_no=#{paicheNo}</script>")
    public Integer quxiaoPaiche(String paicheNo);

    /**
     * 删除派车单
     * @param paicheNo
     * @return
     */
    @Update("<script>update t_paiche set t_data_status=1 where t_no=#{paicheNo}</script>")
    public Integer deletePaiche(String paicheNo);

    /**
     * 取消派车单改变驾驶员状态
     */
    @Update("<script>update t_car set t_status=3 where t_car_no=#{carNo}</script>")
    public Integer updateCarStatus(String carNo);



}
