package com.qdyd.vehicle.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qdyd.vehicle.po.TDestination;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface TDestinationDao extends BaseMapper<TDestination> {

    // 目的地下拉列表
    @Select("select t_des_id desId,t_des_name desName from t_destination where t_data_status=0 order by t_des_time desc")
    @Results({
            @Result(column = "t_data_status",property = "dataStatus")
    })
    public List<TDestination> destinationSelect();

    // 查询目的地列表
    @Select("select * from t_destination where t_data_status=0 order by t_des_time desc")
    @Results({
            @Result(column = "t_des_id",property = "desId"),
            @Result(column = "t_des_name",property = "desName"),
            @Result(column = "t_data_status",property = "dataStatus"),
            @Result(column = "t_des_time",property = "desTime")
    })
    public List<TDestination> findAll();

    // 增加
    @Insert("insert into t_destination(t_des_id,t_des_name,t_data_status,t_des_time) " +
            "value(#{desId},#{desName},#{dataStatus},#{desTime})")
    public void addDes(TDestination destination);

    //@Delete("delete from t_destination where t_des_id=#{id}")
    @Update("update t_destination set t_data_status=1 where t_des_id=#{id}")
    @Results({
            @Result(column = "t_des_id",property = "desId")
    })
    void delByid(@Param("id") String id);
}
