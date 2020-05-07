package com.qdyd.vehicle.controller;

import com.qdyd.vehicle.po.TMatter;
import com.qdyd.vehicle.po.entity.Result;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.service.TMatterService;
import com.qdyd.vehicle.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 事由
 */
@RestController
@RequestMapping("/matter")
public class TMatterController {

    @Autowired
    private TMatterService matterService;

    @Autowired
    private IdWorker idWorker;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public Result findAll(){
        try {
            return new Result(true, StatusCode.OK,"查询成功！",matterService.findAll());
        }catch (Exception e) {
            return new Result(false,StatusCode.ERROR,"查询失败");
        }
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result insert(@RequestBody TMatter matter){
        try {
            matterService.insertTMatter(matter);
            return new Result(true,StatusCode.OK,"新增成功！");
        }catch (Exception e) {
            return new Result(false,StatusCode.ERROR,"新增失败!");
        }
    }

    @RequestMapping(value = "/del/{tid}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("tid") String tid){
        try {
            matterService.deleteTMatter(tid);
            return new Result(true,StatusCode.OK,"删除成功！");
        }catch (Exception e) {
            return new Result(false,StatusCode.ERROR,"删除失败!");
        }
    }
}
