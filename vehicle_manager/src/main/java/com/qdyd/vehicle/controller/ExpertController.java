package com.qdyd.vehicle.controller;

import com.qdyd.vehicle.po.Expert;
import com.qdyd.vehicle.po.ResultCode;
import com.qdyd.vehicle.po.ResultResponse;
import com.qdyd.vehicle.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class ExpertController {
    @Autowired
    private ExpertService expertService;

    @PostMapping("/register")
    public ResultResponse findExpertList(String search, String city, String solt, int page, int page_size) {
        try {
            List<Expert> expertList = expertService.findExpertList(search, city, solt, page, page_size);
            System.out.println(expertList);
            return new ResultResponse(ResultCode.success, "查询成功", expertList);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResultResponse(ResultCode.fail, "查询失败");
        }
    }
}
