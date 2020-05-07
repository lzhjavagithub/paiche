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
import com.qdyd.vehicle.po.TCar;
import com.qdyd.vehicle.po.TCarStatus;
import com.qdyd.vehicle.po.TDriver;
import com.qdyd.vehicle.po.TDriverDepartment;
import com.qdyd.vehicle.po.entity.Fenye;
import com.qdyd.vehicle.po.entity.Result;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.service.TDriverService;

/** 
* @author 作者 : Czyer
* @version 创建时间：2019年8月12日 下午4:12:42 
* 类说明 
*/
@RestController
@RequestMapping("/TDriver")
public class TDriverController{
	
	@Autowired
    private TDriverService tDriverService;

	@Autowired
    private TUserService tUserService;

	/*
	 * 部门
	 */
	//查询所有
    @GetMapping("/departmentfindAll")
    public Fenye departmentfindAll(int page,int limit){
    	return new Fenye(0,"ok",tDriverService.departmentfindAll(),tDriverService.departmentfindAllnum(page,limit));
    }
    @DeleteMapping("/departmentdelete/{id}")
    public Result departmentdelete(HttpSession session,@PathVariable("id") String id){
    	System.out.println("删除："+id);
    	String userId=(String)session.getAttribute("userId");
    	TUser user=tUserService.selectUserById(userId);
    	if(user!=null){
    	    if(user.getPer()==1){
                return new Result(true, StatusCode.OK,"ok",tDriverService.departmentdelete(id));
            }else{
                return new Result(true, StatusCode.ERROR,"权限不足，无法操作",null);
            }
        }else{
    	    return new Result(true, StatusCode.ERROR,"你长时间未操作，请重新登录",null);
        }
    }

  //通过id查询
    @GetMapping("/departmentfindbyId")
    public Result departmentfindbyId(HttpSession session){
    	String departmentId=(String) session.getAttribute("departmentId");
    	System.out.println("通过id查询："+departmentId);
    	System.out.println(tDriverService.departmentfindbyId(departmentId));
		return new Result(true, StatusCode.OK,"ok",tDriverService.departmentfindbyId(departmentId));
    }
  //添加
    @PostMapping("/departmentinsert")
    @ResponseBody
    public Result departmentinsert(TDriverDepartment tDriverDepartment){
        return new Result(true, StatusCode.OK,"ok",tDriverService.departmentinsert(tDriverDepartment));
    }
  //修改
    @PutMapping("/departmentupdate")
    @ResponseBody
    public Result departmentupdate(TDriverDepartment tDriverDepartment){
        return new Result(true, StatusCode.OK,"ok",tDriverService.departmentupdate(tDriverDepartment));
    }
    
    /*
	 * 状态
	 */
    @GetMapping("/carStatusfindAll")
    public Fenye carStatusfindAll(int page,int limit){
    	return new Fenye(0,"ok",tDriverService.carStatusfindAll(),tDriverService.carStatusfindAllnum(page,limit));
    }
    @DeleteMapping("/carStatusdelete/{id}")
    public Result carStatusdelete(HttpSession session,@PathVariable("id") String id){
    	System.out.println("删除："+id);
    	String userId=(String)session.getAttribute("userId");
    	TUser user=tUserService.selectUserById(userId);
    	if(user!=null){
    	    if(user.getPer()==1){
                return new Result(true, StatusCode.OK,"ok",tDriverService.carStatusdelete(id));
            }else {
                return new Result(true, StatusCode.ERROR,"权限不足，无法操作",null);
            }
        }else{
            return new Result(false, StatusCode.ERROR,"长时间未操作，请你重新登陆",tDriverService.carStatusdelete(id));
        }

    }
  //通过id查询
    @GetMapping("/carStatusfindbyId")
    public Result carStatusfindbyId(HttpSession session){
    	String carStatusId=(String) session.getAttribute("carStatusId");
    	System.out.println("通过id查询："+carStatusId);
    	System.out.println(tDriverService.departmentfindbyId(carStatusId));
		return new Result(true, StatusCode.OK,"ok",tDriverService.carStatusfindbyId(carStatusId));
    }
  //添加
    @PostMapping("/carStatusinsert")
    @ResponseBody
    public Result carStatusinsert(TCarStatus carStatus){
    	System.out.println("czyczy"+carStatus.toString());
        return new Result(true, StatusCode.OK,"ok",tDriverService.carStatusinsert(carStatus));
    }
  //修改
    @PutMapping("/carStatusupdate")
    @ResponseBody
    public Result carStatusupdate(TCarStatus carStatus){
        return new Result(true, StatusCode.OK,"ok",tDriverService.carStatusupdate(carStatus));
    }
    
    
    


	//查询所有
    @GetMapping("/findAll")
    public Result findAll(){
        return new Result(true, StatusCode.OK,"ok",tDriverService.findAll());
    }
    
    // 查询驾驶员姓名下拉选项
    @GetMapping("/tdriverName")
    public Result tdriverName(){
        return new Result(true, StatusCode.OK,"ok",tDriverService.tdriverName());
    }
    
    // 查询驾驶员手机号下拉选项
    @GetMapping("/tdriverTel")
    public Result tdriverTel(){
        return new Result(true, StatusCode.OK,"ok",tDriverService.tdriverTel());
    }
    
    // 查询驾驶员状态下拉选项
    @GetMapping("/tdriverStatus")
    public Result tdriverStatus(){
        return new Result(true, StatusCode.OK,"ok",tDriverService.tdriverStatus());
    }
    
    
    // 查询驾驶员部门下拉选项
    @GetMapping("/tdriverDepartment")
    public Result tdriverDepartment(){
        return new Result(true, StatusCode.OK,"ok",tDriverService.tdriverDepartment());
    }
    
    //添加
    @PostMapping("/tcarinsert")
    @ResponseBody
    public Result tcarinsert(TDriver tDriver){
    	System.out.println("添加："+tDriver.toString());
        return new Result(true, StatusCode.OK,"ok",tDriverService.tcarinsert(tDriver));
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
                return new Result(true, StatusCode.OK,"ok",tDriverService.tcardelete(id));
            }
        }
    }
  //通过id查询
    @GetMapping("/tcarfindbyId")
    public Result tcarfindbyId(HttpSession session){
    	String driverId=(String) session.getAttribute("driverId");
    	System.out.println("通过id查询："+driverId);
		return new Result(true, StatusCode.OK,"ok",tDriverService.tcarfindbyId(driverId));
    }
    //修改
    @PutMapping("/tcarupdate")
    @ResponseBody
    public Result tcarupdate(TDriver tDriver){
        return new Result(true, StatusCode.OK,"ok",tDriverService.tcarupdate(tDriver));
    }
    
    //多条件查询
    @PostMapping("/tcarselect")
    public Result tcarselect(TDriver tDriver){
        return new Result(true, StatusCode.OK,"ok",tDriverService.tcarselect(tDriver));
    }
}
