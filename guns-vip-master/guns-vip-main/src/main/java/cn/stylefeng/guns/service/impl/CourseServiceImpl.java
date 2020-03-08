package cn.stylefeng.guns.service.impl;

import cn.stylefeng.guns.dao.CourseDao;
import cn.stylefeng.guns.dao.CourseTypeDao;
import cn.stylefeng.guns.dao.CourseTypesDao;
import cn.stylefeng.guns.pojo.Course;
import cn.stylefeng.guns.pojo.CourseType;
import cn.stylefeng.guns.pojos.CourseTypes;
import cn.stylefeng.guns.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseTypeDao courseTypeDao;

    @Autowired
    private CourseTypesDao courseTypesDao;

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<CourseType> courseList() {
        return courseTypeDao.courseList();
    }

    @Override
    public void creatClassType(Integer classTypeId) {
        // 设置班型id 长期班 短期班 免费班
        Course course = new Course();
        course.settClassTypeId(classTypeId);
        courseDao.insert(course);
    }

    @Override
    public CourseTypes findById(Integer id) {
        return courseTypesDao.findById(id);
    }

    @Override
    public void editCourseInfo(Integer id, Course course) {
        CourseTypes courseTypes = courseTypesDao.findById(id);
    }
}
