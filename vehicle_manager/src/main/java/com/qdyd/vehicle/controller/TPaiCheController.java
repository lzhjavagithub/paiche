package com.qdyd.vehicle.controller;

import com.qdyd.vehicle.po.*;
import com.qdyd.vehicle.po.entity.PageResult;
import com.qdyd.vehicle.po.entity.Result;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.service.TPaiCheService;
import com.qdyd.vehicle.service.TUserService;
import com.qdyd.vehicle.util.DownloadUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/paiche")
public class TPaiCheController {

    @Autowired
    private TPaiCheService paiCheService;

    @Autowired
    private TUserService tUserService;

    // 根据carid查询驾驶员
    @RequestMapping(value = "/findcardriver/{carId}")
    @ResponseBody
    public Result findcardriver(@PathVariable("carId") String carId) {
        List<Map<String, Object>> findcardriver = paiCheService.findcardriver(carId);
        return new Result(true,StatusCode.OK,"查询成功！",findcardriver);
    }

    @RequestMapping(value = "/carno")
    @ResponseBody
    public Result carno(){
        List<Map<Object,Object>> carno = paiCheService.carno();
        return new Result(true,StatusCode.OK,"查询成功！",carno);
    }

    @RequestMapping(value = "/mantodept/{driveName}")
    @ResponseBody
    public Result mantodept(@PathVariable("driveName") String driveName){
        System.out.println(driveName);
        List<Map<Object, Object>> mantodept = paiCheService.mantodept(driveName);
        System.out.println(mantodept);
        return new Result(true,StatusCode.OK,"查询成功！",mantodept);
    }

    /**
     * 根据id查询
     * @param paicheId
     * @return
     */
    @RequestMapping(value = "/findid/{paicheId}",method = RequestMethod.GET)
    @ResponseBody
    public Result findbyid(@PathVariable("paicheId") String paicheId) {
        try {
            System.out.println("paicheId->"+paicheId);
            List<Map<Object, Object>> findbyid = paiCheService.findbyid(paicheId);
            System.out.println("findbyid->"+findbyid);
            return new Result(true,StatusCode.OK,"查询成功！",findbyid);
        }catch (Exception e) {
            return new Result(false,StatusCode.OK,"查询失败！");
        }
    }

    /**
     * 查询派车列表
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    public Result findAll(){
        try {
            List<Map<Object,Object>> list = paiCheService.find();
            System.out.println(list);
            return new Result(true, StatusCode.OK,"ok",list);
        } catch (Exception e) {
            return new Result(false, StatusCode.ERROR,"error");
        }
    }

    /**
     * 根据id查询派车列表
     * @param paicheId
     * @return
     */
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ResponseBody
    public Result findById(String paicheId){
        try {
            List<Map<Object,Object>> list = paiCheService.findById(paicheId);
            return new Result(true, StatusCode.OK,"ok",list);
        } catch (Exception e) {
            return new Result(false, StatusCode.ERROR,"error");
        }
    }

    /**
     * 派车单  车牌号下拉列表
     */
    @GetMapping(value = "/carno")
    @ResponseBody
    public Result search(){
        List<TCar> findcon = paiCheService.cardaimingselect();
        return new Result(true, StatusCode.OK,"ok",findcon);
    }

    /**
     * 新增派车单
     * @param paicheVo
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpSession session, PaicheVo paicheVo){
        System.out.println("no==>"+paicheVo.getNo());
        String userId=(String)session.getAttribute("userId");
        session.setAttribute("paicheVo", paicheVo);
        System.out.println("userid==="+userId);
        TUser user=tUserService.selectUserById(userId);
        if(user.getPer()==1){
            return new Result(false, StatusCode.ERROR,"你是管理员没有相应的权限");
        }else {
            System.out.println("111111");
            try {
                System.out.println(paicheVo.toString());
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                paiCheService.add(paicheVo);
                return new Result(true, StatusCode.OK,"新增成功！");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, StatusCode.ERROR,"error");
            }
        }
    }

    /*
      打印页面值
     */
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public Result find(HttpSession session){
        PaicheVo paicheVo=(PaicheVo)session.getAttribute("paicheVo");

        return new Result(true, StatusCode.OK,"ok",paicheVo);
    }


    /**
     * 修改派车状态
     */
    @PostMapping(value = "/updatePaicheStatus/{id}/{status}")
    @ResponseBody
    public Result updatePaicheStatus(@PathVariable("status") String status,@PathVariable("id") String id){
        try {
            paiCheService.updatePaicheStatus(status,id);
            return new Result(true, StatusCode.OK,"修改成功！");
        } catch (Exception e) {
            return new Result(false, StatusCode.ERROR,"error");
        }
    }

    /**
     * 根据id虚拟删除
     */
    @RequestMapping(value = "/delete/{paicheId}",method = RequestMethod.GET)
    @ResponseBody
    public Result deleteById(@PathVariable("paicheId") String paicheId, HttpSession session){
        try {
            String userId=(String)session.getAttribute("userId");
            TUser user=tUserService.selectUserById(userId);
            if(user==null){
                return new Result(true, StatusCode.SESSIONFAIL,"长时间未操作，请你重新登陆");

            }else{
                if(user.getPer()==StatusCode.USER_PER_CAOZUO){
                    return new Result(true, StatusCode.ACCESSERROR,"你没有相应的权限");
                }else{
                    paiCheService.deleteById(paicheId);
                    return new Result(true, StatusCode.OK,"温馨提示：您已删除成功，请刷新页面查看！");
                }
            }
        } catch (Exception e) {
            return new Result(false, StatusCode.ERROR,"删除失败！");
        }
    }

    /**
     * 根据id物理删除派车单
     * @param paicheId
     * @return
     */
    @RequestMapping(value = "/del/{paicheId}",method = RequestMethod.PUT)
    @ResponseBody
    public Result delete(@PathVariable("paicheId") String paicheId){
        try {
            paiCheService.delete(paicheId);
            return new Result(true, StatusCode.OK,"ok");
        } catch (Exception e) {
            return new Result(false, StatusCode.ERROR,"error");
        }
    }

}
