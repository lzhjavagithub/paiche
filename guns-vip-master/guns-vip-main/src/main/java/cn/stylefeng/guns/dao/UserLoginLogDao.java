package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojos.UserLoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserLoginLogDao extends BaseMapper<UserLoginLog> {

    @Select("SELECT u.`id`,u.`t_age`,u.`t_username`,u.`t_sex`,u.`t_mobile`,\n" +
            "u.`t_register_ip`,u.`t_register_date`,ll.`recordguid`,ll.`t_login_ip`,ll.`t_login_date`\n" +
            "FROM tb_user u, tb_login_log ll")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "t_age", property = "tAge"),
            @Result(column = "t_username", property = "tUsername"),
            @Result(column = "t_mobile", property = "tMobile"),
            @Result(column = "recordguid", property = "recordguid"),
            @Result(column = "t_register_ip", property = "tRegisterIp"),
            @Result(column = "t_register_date", property = "tRegisterDate"),
            @Result(column = "t_login_ip", property = "tLoginIp"),
            @Result(column = "t_login_date", property = "tLoginDate"),
            @Result(column = "t_sex", property = "tSex")
    })
    List<UserLoginLog> findAll();

    @Select("SELECT COUNT(*) FROM tb_user u")
    int count();
}
