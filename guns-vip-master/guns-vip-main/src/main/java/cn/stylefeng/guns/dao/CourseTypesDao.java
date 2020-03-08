package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojos.CourseTypes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CourseTypesDao extends BaseMapper<CourseTypes> {

    /**
     * 课程编辑信息 根据id查询班型
     * @param id
     * @return
     */
    @Select("SELECT\n" +
            " ct.id, ct.t_class_name,c.id,c.t_class_type_id,c.t_course_introduce,c.t_course_name,c.t_course_introduce\n" +
            "FROM\n" +
            "\ttb_course_type ct, tb_course c\n" +
            "WHERE\n" +
            "  ct.id = c.t_class_type_id and c.id=#{id}")
    CourseTypes findById(Integer id);

}
