package com.qdyd.vehicle.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qdyd.vehicle.po.TMatter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TMatterDao extends BaseMapper<TMatter> {

    // 查询
    @Select("select * from t_matter where t_data_status=0 order by t_create_date desc")
    @Results({
            @Result(column = "t_id",property = "tid"),
            @Result(column = "t_cause",property = "cause"),
            @Result(column = "t_create_date",property = "createDate"),
            @Result(column = "t_data_status",property = "dataStatus")
    })
    public List<TMatter> findAll();

    // 新增
    @Insert("insert into t_matter(t_id,t_cause,t_create_date,t_data_status)" +
            " value(#{tid},#{cause},#{createDate},#{dataStatus})")
    public void insertMatter(TMatter matter);

    // 删除
    @Update("update t_matter set t_data_status=1 where t_id=#{tid}")
    public abstract void deleteMatter(String tid);

}
