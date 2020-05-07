package com.qdyd.vehicle.controller;

import com.qdyd.vehicle.po.TDestination;
import com.qdyd.vehicle.po.entity.Result;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.service.TDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
public class TDestinationController {

    @Autowired
    private TDestinationService destinationService;

    // 目的地下拉列表
    @GetMapping(value = "/select")
    public Result destinationSelect(){
        List<TDestination> list = destinationService.destinationSelect();
        return new Result(true, StatusCode.OK,"查询成功！",list);
    }

    // 查询列表
    @GetMapping(value = "/findAll")
    public Result findAll(){
        List<TDestination> list = destinationService.findAll();
        return new Result(true, StatusCode.OK,"查询成功！",list);
    }

    @GetMapping(value = "/findbyid")
    public Result findById(String id) {
        TDestination destination = destinationService.findById(id);
        return new Result(true, StatusCode.OK,"查询成功！",destination);
    }

    // 新增目的地
    @PostMapping(value = "/save")
    public Result save(@RequestBody TDestination destination){
        destinationService.save(destination);
        return new Result(true, StatusCode.OK,"save success！");
    }

    // 删除
    @DeleteMapping(value = "/delete/{id}")
    public Result deleteById(@PathVariable("id") String id){
        destinationService.deleteById(id);
        return new Result(true, StatusCode.OK,"delete success！");
    }

}
