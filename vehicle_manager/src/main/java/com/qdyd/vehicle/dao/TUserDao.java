package com.qdyd.vehicle.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qdyd.vehicle.po.TUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface TUserDao {

    @Insert("insert into t_user(id,username,account,password,t_data_status,t_remark,t_per) values(#{id},#{userName},#{account},#{passWord},#{dataStatus},#{remark},#{per})")
    Integer insert(TUser user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Update("update t_user set account=#{account},t_remark=#{remark} where id=#{id}")
    Integer updateUser(TUser user);

    /**
     * 修改密码
     * @param id
     * @param passWord
     * @return
     */
    @Update("update t_user set password=#{passWord} where id=#{id}")
    Integer updatePassWord(String id, String passWord);

    /**
     * 查询所有的用户
     * @return
     */
    @Select("select id id, username userName,account account,password passWord,t_data_status dataStatus,t_remark remark,t_per per from t_user where t_per!=1")
    List<TUser> selectAllUser();

    /**
     * 按照用户状态查询用户
     * @param dataStatus
     * @return
     */
    @Select("select id id, username userName,account account,password passWord,t_data_status dataStatus,t_remark remark from t_user where t_data_status=#{dataStatus}")
    List<TUser> selectUserByDataStatus(String dataStatus);

    /**
     * 根据用户id查看用户具体信息
     */
    @Select("select id id, username userName,account account,password passWord,t_data_status dataStatus,t_remark remark,t_per per from t_user where id=#{id}")
    TUser selectUserById(String id);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @Select("select id id, username userName,account account,password passWord,t_data_status dataStatus,t_remark remark,t_per per from t_user where username=#{userName}")
    TUser selectUserByUserName(String userName);

    /**
     * 修改用户状态
     * @param id
     * @param dataStatus
     * @return
     */
    @Update("update t_user set t_data_status=#{dataStatus} where id=#{id}")
    Integer deleleUser(String id, Integer dataStatus);




}
