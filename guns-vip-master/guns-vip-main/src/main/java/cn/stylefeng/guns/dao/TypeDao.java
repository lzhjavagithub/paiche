package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojo.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeDao extends BaseMapper<Type> {

    @Select("<script>" +
            "select * from tb_type where id=#{id} " +
            " order by t_order" +
            "</script>")
    @Results({
            @Result(column = "t_type_name", property = "tTypeName"),
            @Result(column = "t_order", property = "tOrder"),
            @Result(column = "t_status", property = "tStatus")
    })
    Type findById(@Param("id") String id);

    @Select("<script>" +
            "select * from tb_type where 1=1 " +
            " <if test='tTypeName!=null and tTypeName!=\"\"'> and t_type_name like '%${tTypeName}%'</if>" +
            " order by t_order" +
            "</script>")
    @Results({
            @Result(column = "t_type_name", property = "tTypeName"),
            @Result(column = "t_order", property = "tOrder"),
            @Result(column = "t_status", property = "tStatus")
    })
    Page<Type> findAll(Type type);

    @Select("select count(*) from tb_type")
    int countType();

    /**
     * 下拉列表
     * @return
     */
    @Select("<script>" +
            "select * from tb_type " +
            "</script>")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "t_type_name", property = "tTypeName"),
            @Result(column = "t_order", property = "tOrder"),
            @Result(column = "t_status", property = "tStatus")
    })
    List<Type> findType();
}
