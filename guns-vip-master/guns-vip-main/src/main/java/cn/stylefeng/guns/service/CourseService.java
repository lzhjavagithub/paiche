package cn.stylefeng.guns.service;

import cn.stylefeng.guns.pojo.Course;
import cn.stylefeng.guns.pojo.CourseType;
import cn.stylefeng.guns.pojos.CourseTypes;

import java.util.List;

public interface CourseService {
    List<CourseType> courseList();
    void creatClassType(Integer classTypeId);
    CourseTypes findById(Integer id);
    void editCourseInfo(Integer id, Course course);
}
