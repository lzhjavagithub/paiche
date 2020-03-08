package cn.stylefeng.guns.controller;

import cn.stylefeng.guns.entity.Result;
import cn.stylefeng.guns.entity.ResultStatusCode;
import cn.stylefeng.guns.pojo.Role;
import cn.stylefeng.guns.pojos.UserLoginLog;
import cn.stylefeng.guns.pojos.UserOrder;
import cn.stylefeng.guns.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(value = "学生管理列表",description = "学生管理列表")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    @ResponseBody
    @ApiOperation("学生管理列表")
    public Result findAll(int page, int size) {
        try {
            int total = userService.count();
            Map<String,Object> map = new HashMap<>();
            List<UserLoginLog> userLoginLogs = userService.findAll(page, size);
            for (UserLoginLog userLoginLog : userLoginLogs) {
                Integer id = userLoginLog.getId();
                List<UserOrder> userOrderCount = userService.userOrderCount(id);
                map.put("UserOrderCount"+id,userOrderCount);
            }
            map.put("userList",userLoginLogs);
            return new Result(true, ResultStatusCode.SUCCESS, total, "查询成功!", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询失败!");
        }
    }

}
