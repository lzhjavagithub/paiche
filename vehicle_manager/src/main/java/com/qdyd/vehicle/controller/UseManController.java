package com.qdyd.vehicle.controller;

import javax.servlet.http.HttpSession;

import com.qdyd.vehicle.po.TUser;
import com.qdyd.vehicle.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.qdyd.vehicle.po.TDriver;
import com.qdyd.vehicle.po.entity.Result;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.service.TCarService;
import com.qdyd.vehicle.service.TDriverService;
import com.qdyd.vehicle.service.UseManService;

/** 
* @author 作者 : Czyer
* @version 创建时间：2019年8月12日 下午4:12:42 
* 类说明 
*/
@RestController
@RequestMapping("/useMan")
public class UseManController{
	
	@Autowired
    private UseManService useManService;

	@Autowired
    private TUserService tUserService;
    
	//查询所有
    @GetMapping("/findAll")
    public Result findAll(){
        return new Result(true, StatusCode.OK,"ok",useManService.findAll());
    }
    
    // 查询驾驶员姓名下拉选项
    @GetMapping("/tdriverName")
    public Result tdriverName(){
        return new Result(true, StatusCode.OK,"ok",useManService.tdriverName());
    }
    
    // 查询驾驶员手机号下拉选项
    @GetMapping("/tdriverTel")
    public Result tdriverTel(){
        return new Result(true, StatusCode.OK,"ok",useManService.tdriverTel());
    }
    
    // 查询驾驶员状态下拉选项
    @GetMapping("/tdriverStatus")
    public Result tdriverStatus(){
        return new Result(true, StatusCode.OK,"ok",useManService.tdriverStatus());
    }
    
    
    // 查询驾驶员部门下拉选项
    @GetMapping("/tdriverDepartment")
    public Result tdriverDepartment(){
        return new Result(true, StatusCode.OK,"ok",useManService.tdriverDepartment());
    }
    
    //添加
    @PostMapping("/tcarinsert")
    @ResponseBody
    public Result tcarinsert(TDriver tDriver){
    	System.out.println("添加："+tDriver.toString());
        return new Result(true, StatusCode.OK,"ok",useManService.tcarinsert(tDriver));
    }
    
    //删除
    @DeleteMapping("/tcardelect/{id}")
    public Result tcardelect(@PathVariable("id") String id,HttpSession session){
    	System.out.println("删除："+id);
        String userId=(String)session.getAttribute("userId");
        TUser user=tUserService.selectUserById(userId);
        if(user==null){
            return new Result(true, StatusCode.SESSIONFAIL,"长时间未操作，请你重新登陆");

        }else{
            if(user.getPer()==StatusCode.USER_PER_CAOZUO){
                return new Result(true, StatusCode.ACCESSERROR,"你没有相应的权限");
            }else{
                return new Result(true, StatusCode.OK,"ok",useManService.tcardelete(id));
            }
        }

    }
  //通过id查询
    @GetMapping("/tcarfindbyId")
    public Result tcarfindbyId(HttpSession session){
    	String driverId=(String) session.getAttribute("driverId");
    	System.out.println("通过id查询："+driverId);
		return new Result(true, StatusCode.OK,"ok",useManService.tcarfindbyId(driverId));
    }
    //修改
    @PutMapping("/tcarupdate")
    @ResponseBody
    public Result tcarupdate(TDriver tDriver){
        return new Result(true, StatusCode.OK,"ok",useManService.tcarupdate(tDriver));
    }
    
    //多条件查询
    @PostMapping("/tcarselect")
    public Result tcarselect(TDriver tDriver){
        return new Result(true, StatusCode.OK,"ok",useManService.tcarselect(tDriver));
    }
}
