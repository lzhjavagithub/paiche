package cn.stylefeng.guns.controller;

import cn.stylefeng.guns.entity.Result;
import cn.stylefeng.guns.entity.ResultStatusCode;
import cn.stylefeng.guns.pojo.*;
import cn.stylefeng.guns.pojos.CourseTypes;
import cn.stylefeng.guns.service.CourseService;
import cn.stylefeng.guns.service.EmployeeService;
import cn.stylefeng.guns.service.LevelService;
import cn.stylefeng.guns.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
@CrossOrigin
@Api(value = "课程管理",description = "课程管理")
public class CourseController {

    @Autowired
    private LevelService levelService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/courseType")
    @ApiOperation("类别/老师/客服/级别下拉列表&班型单选按钮")
    public Result courseType() {
        try {
            // 课程类别下拉列表
            List<Type> typeList = typeService.findType();
            // 课程授课老师下拉列表
            List<Employee> teacherList = employeeService.teacher();
            // 课程适合级别下拉列表
            List<Level> levelList = levelService.findLevel();
            // 客服老师下拉列表
            List<Employee> serviceList = employeeService.service();
            // 班型 长期班、短期班、免费班
            List<CourseType> courseList = courseService.courseList();
            Map<String,Object> map = new HashMap<>();
            map.put("type", typeList);
            map.put("teacher",teacherList);
            map.put("service",serviceList);
            map.put("levelList", levelList);
            map.put("courseList", courseList);
            return new Result(true, ResultStatusCode.SUCCESS, "课程类别下拉列表&单选按钮成功!",map);
        } catch (Exception e) {
            return new Result(false, ResultStatusCode.FAIL, "课程类别下拉列表&单选按钮失败!");
        }
    }

    @PostMapping("/createClassType")
    @ApiOperation("创建课程设置班型")
    public Result createCourseClassType(Integer classTypeId) {
        try {
            // 设置班型
            courseService.creatClassType(classTypeId);
            return new Result(true, ResultStatusCode.SUCCESS, "创建课程设置班型成功!");
        } catch (Exception e) {
            return new Result(false, ResultStatusCode.FAIL, "创建课程设置班型失败!");
        }
    }

    @GetMapping("/findById")
    @ApiOperation("根据id查询课程信息 查询班型")
    public Result findById(Integer id) {
        try {
            CourseTypes courseTypes = courseService.findById(id);
            return new Result(true, ResultStatusCode.SUCCESS, "根据id查询课程信息 查询班型成功!", courseTypes);
        } catch (Exception e) {
            return new Result(false, ResultStatusCode.FAIL, "根据id查询课程信息 查询班型失败!");
        }
    }

    @PutMapping("/editCourseInfo")
    @ApiOperation("编辑课程信息")
    public Result editCourseInfo(Integer id, @RequestBody Course course) {
        try {
            courseService.editCourseInfo(id,course);
            return new Result(true, ResultStatusCode.SUCCESS, "查询适合级别!");
        } catch (Exception e) {
            return new Result(false, ResultStatusCode.FAIL, "查询适合级别!");
        }
    }

}
