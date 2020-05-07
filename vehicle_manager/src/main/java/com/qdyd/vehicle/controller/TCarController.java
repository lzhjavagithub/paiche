package com.qdyd.vehicle.controller;

import javax.servlet.http.HttpSession;

import com.qdyd.vehicle.po.TUser;
import com.qdyd.vehicle.po.entity.DaoZha;
import com.qdyd.vehicle.service.TCarService;
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

import com.qdyd.vehicle.po.HkPms;
import com.qdyd.vehicle.po.TCar;
import com.qdyd.vehicle.po.entity.Fenye;
import com.qdyd.vehicle.po.entity.Result;
import com.qdyd.vehicle.po.entity.StatusCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/** 
* @author 作者 : Czyer
* @version 创建时间：2019年8月12日 下午4:12:42 
* 类说明 
*/
@RestController
@RequestMapping("/TCar")
public class TCarController{
	
	@Autowired
    private TCarService tCarService;

	@Autowired
    private TUserService tUserService;
	private static final Integer YES=0;
	private static final Integer NO=1;
	/*
	 * 
		请求数据
	   {
		"parkCode" : "6DEA23BC2376F1",
		"plateNo" : "浙 A8888",
		"passTime" : "20181211094656200",
		"vehType" : 0
		}
		返回数据
		{
		"code": 0
		}
	 */
		//车牌号道闸接口 <出场>
	    //localhost:9001/TCar/getOutCar
	    @PostMapping("/getOutCar")
	    @ResponseBody
	    public DaoZha getOutCar(@RequestBody HkPms hkPms){
	    	System.out.println(hkPms.toString());
	    	int a=tCarService.iscarNo(hkPms.getPlateNo());
	    	
	    	if (a==1) {
	    		

	    		int b=tCarService.getOutCar(hkPms);
	    		if (b>0) {
	    			System.out.println("出场："+"放行");
	    			return new DaoZha(YES,"出场放行");
	    			
				}else {
					System.out.println("出场：修改派车单和车辆信息失败,请申请派车单后出勤！");
					return new DaoZha(NO,"修改派车单和车辆信息失败,请申请派车单后出勤！");
					
				}
	    		
	    		
			}else {

				System.out.println("出场：查询车牌号数量不为1");
				return new DaoZha(NO,"第三方：出场不放行");
				
			}
	    }
		
		//车牌号道闸接口<入场>
	    //localhost:9001/TCar/getIntoCar
	    @PostMapping("/getIntoCar")
	    public DaoZha getIntoCar(@RequestBody HkPms hkPms){
	    	System.out.println(hkPms.toString());
	    	int a=tCarService.iscarNo(hkPms.getPlateNo());
	    	
	    	if (a==1) {

	    		int b=tCarService.getIntoCar(hkPms);
	    		if (b>0) {
	    			System.out.println("入场：放行");
	    			return new DaoZha(YES,"入场放行");
	    			
				}else {
					System.out.println("入场：修改派车单和车辆信息失败！");
					return new DaoZha(NO,"数据库修改失败，入场不放行");
				}
	    		
			}else {
				System.out.println("第三方：入场不放行");
				return new DaoZha(NO,"第三方：入场不放行");
				
			}
	    	
	    }
	    
	   


    @RequestMapping("/findstatus")
    public Result findstatus(){
        return new Result(true, StatusCode.OK,"ok",tCarService.findstatus());
    }
    @RequestMapping("/findstatus1")
    public Result findstatus1(){
        return new Result(true, StatusCode.OK,"ok",tCarService.findstatus1());
    }
    @RequestMapping("/finddutydate")
    public Result finddutydate(){
        return new Result(true, StatusCode.OK,"ok",tCarService.finddutydate());
    }

 // 查询车辆类型下拉选项
    @GetMapping("/tcarTypenum")
    public Fenye tcarTypenum(int page,int limit){
        return new Fenye(0,"ok",tCarService.tcarTypenum1(),tCarService.tcarTypenum(page,limit));
    }
    
    
	//查询所有
    @GetMapping("/findAllnum")
    public Fenye findAllnum(int page,int limit){
        return new Fenye(0,"ok",tCarService.findAllnum1(),tCarService.findAllnum(page,limit));
    }
  //查询所有
    @GetMapping("/findAll")
    public Result findAll(){
        return new Result(true, StatusCode.OK,"ok",tCarService.findAll());
    }
    // 查询车牌号下拉选项
    @GetMapping("/tcarNo")
    public Result tcarNo(){
        return new Result(true, StatusCode.OK,"ok",tCarService.tcarNo());
    }
    
    
    
    
    
    // 查询车辆类型下拉选项
    @GetMapping("/tcarType")
    public Result tcarType(){
        return new Result(true, StatusCode.OK,"ok",tCarService.tcarType());
    }
    
    // 查询车辆状态下拉选项
    @GetMapping("/tcarStatus")
    public Result tcarStatus(){
        return new Result(true, StatusCode.OK,"ok",tCarService.tcarStatus());
    }
    
    //添加
    @PostMapping("/tcarinsert")
    @ResponseBody
    public Result tcarinsert(TCar tCar){
    	System.out.println("添加："+tCar.toString());
        return new Result(true, StatusCode.OK,"ok",tCarService.tcarinsert(tCar));
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
                return new Result(true, StatusCode.OK,"ok",tCarService.tcardelete(id));
            }
        }
    }
    
    //通过id查询
    @GetMapping("/tcarfindbyId")
    public Result tcarfindbyId(HttpSession session){
    	String carId=(String) session.getAttribute("id");
    	System.out.println("通过id查询："+carId);
		return new Result(true, StatusCode.OK,"ok",tCarService.tcarfindbyId(carId));
    }
    
    //修改
    @PutMapping("/tcarupdate")
    @ResponseBody
    public Result tcarupdate(TCar tCar){
        return new Result(true, StatusCode.OK,"ok",tCarService.tcarupdate(tCar));
    }
    
    //多条件查询
    @PostMapping("/tcarselect")
    @ResponseBody
    public Result tcarselect(TCar tCar){
    	System.out.println(tCar.toString());
        return new Result(true, StatusCode.OK,"ok",tCarService.tcarselect(tCar));
    }
}
