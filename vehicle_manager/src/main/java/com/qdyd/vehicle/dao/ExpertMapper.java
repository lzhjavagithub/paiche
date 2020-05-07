package com.qdyd.vehicle.dao;

import com.qdyd.vehicle.po.Expert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExpertMapper {
    // 专家人员列表（专家团）
    @Select("<script>" +
            "select id expert_id,avatar img_url,username expert_name,tags tag,details job,summary tips\n" +
            "from expert " +
            "where 1=1 " +
            "<if test='search!=null'> and (province_name like '${search}' or username LIKE '${search}' or city_nme like '${search}')</if> " +
            "<if test='city!=null'> and city_nme like '%${city}%'</if>" +
            "<if test='solt!=null'> and id=#{solt}</if> limit #{page}, #{page_size}" +
            "</script>")
    public List<Expert> findExpertList(@Param("search") String search, @Param("city") String city, @Param("solt") String solt, int page, int page_size);

}
