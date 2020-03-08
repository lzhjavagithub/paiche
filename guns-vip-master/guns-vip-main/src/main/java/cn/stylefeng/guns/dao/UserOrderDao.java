package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojos.UserOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserOrderDao extends BaseMapper<UserOrder> {

    // 查询每个学员的订单量
    @Select("SELECT u.id, u.`t_username`,COUNT(*) count FROM tb_order o,tb_user u WHERE o.t_user_guid = u.`id` AND u.`id`=#{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "t_username",property = "tUsername"),
            @Result(column = "count",property = "count")
    })
    List<UserOrder> userOrderCount(@Param("id") Integer id);
}
