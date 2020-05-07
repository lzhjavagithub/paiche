package com.qdyd.vehicle.controller;

import com.qdyd.vehicle.po.*;

import com.qdyd.vehicle.po.entity.LayPage;
import com.qdyd.vehicle.po.entity.Result;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.service.PaicheRecordService;
import com.qdyd.vehicle.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PaicheRecordController {

    @Autowired
    private PaicheRecordService paicheRecordService;

    /**
     * 查询某个部门所有的员工
     * @param deptId
     * @return
     */
    @GetMapping(value = "/selectManByDept")
    @ResponseBody
    public Result selectAllByDept(String deptId){
        List<TDriverUseMan> useManList=paicheRecordService.selectAllByDept(deptId);
        return new Result(true,StatusCode.OK,"",useManList);
    }

    /**
     * 取消派车单
     * @param paicheNo
     * @return
     */
    @GetMapping(value = "/quxiaoPaiche")
    @ResponseBody
    public Result quxiaoPaiche(String paicheNo,String carNo){
        paicheRecordService.quxiaoPaiche(paicheNo,carNo);
        return new Result(true,StatusCode.OK,"",null);
    }

    /**
     * 删除派车单
     * @param paicheNo
     */
    @GetMapping(value = "/deletePaiche")
    @ResponseBody
    public void deletePaiche(String paicheNo,String carNo){
        paicheRecordService.deletePaiche(paicheNo,carNo);
    }

    /**
     * 派车单查询
     * @param mp
     * @param session
     * @param paiCheDeptId
     * @param paicheuseManId
     * @param paichecarId
     * @param paichedriverId
     * @param paichestartTime
     * @param paicheendTime
     * @param limit
     * @param page
     * @return
     */
    @PostMapping(value = "/paicheSelectRecords")
    @ResponseBody
    public LayPage<PaicheRecord> selectRecords(ModelMap mp, HttpSession session, String paiCheDeptId, String paicheuseManId, String paichecarId, String paichedriverId,
                                               String paichestartTime, String paicheendTime,int limit,int page){
        System.out.println("limit"+limit);
        System.out.println("page"+page);
        session.removeAttribute("paiCheDeptId");
        session.removeAttribute("paicheuseManId");
        session.removeAttribute("paichecarId");
        session.removeAttribute("paichedriverId");
        session.removeAttribute("paichestartTime");
        session.removeAttribute("paicheendTime");
        List<PaicheRecord> lists=paicheRecordService.selectRecords(paiCheDeptId,paicheuseManId,paichecarId,paichedriverId,paichestartTime,paicheendTime,limit,page);
        List<PaicheRecord> list=paicheRecordService.selectRecords(paiCheDeptId,paicheuseManId,paichecarId,paichedriverId,paichestartTime,paicheendTime,0,0);
        if(paiCheDeptId!=null){
            session.setAttribute("paiCheDeptId",paiCheDeptId);
        }
        if(paicheuseManId!=null){
            session.setAttribute("paicheuseManId",paicheuseManId);
        }
        if(paichecarId!=null){
            session.setAttribute("paichecarId",paichecarId);
        }
        if(paichedriverId!=null){
            session.setAttribute("paichedriverId",paichedriverId);
        }
        if(paichestartTime!=null){
            session.setAttribute("paichestartTime",paichestartTime);
        }
        if(paicheendTime!=null){
            session.setAttribute("paicheendTime",paicheendTime);
        }
        int count=list.size();

        return new LayPage<PaicheRecord>(lists,count,0,"");
    }

    /**
     * 出车单查询
     * @param mp
     * @param session
     * @param chuCheDeptId
     * @param chucheuseManId
     * @param chuchecarId
     * @param chuchedriverId
     * @param chuchestartTime
     * @param chucheendTime
     * @param limit
     * @param page
     * @return
     */
    @PostMapping(value = "/chucheSelectRecords")
    @ResponseBody
    public LayPage<PaicheRecord> checheSelectRecords(ModelMap mp, HttpSession session, String chuCheDeptId, String chucheuseManId, String chuchecarId, String chuchedriverId,
                                                     String chuchestartTime, String chucheendTime,int limit,int page){
        List<PaicheRecord> lists=paicheRecordService.selectchucheRecords(chuCheDeptId,chucheuseManId,chuchecarId,chuchedriverId,chuchestartTime,chucheendTime,limit,page);
        List<PaicheRecord> list=paicheRecordService.selectchucheRecords(chuCheDeptId,chucheuseManId,chuchecarId,chuchedriverId,chuchestartTime,chucheendTime,0,0);
        int count=list.size();

        return new LayPage<PaicheRecord>(lists,count,0,"");
    }

    /**
     *
     * @param paicheNo
     * @return
     */
    @GetMapping(value = "/paicheByNo")
    public String  selectPaicheRecordById(String paicheNo,ModelMap mp){
       PaicheRecord paicheRecord= paicheRecordService.selectPaicheRecordById(paicheNo);
       mp.addAttribute("paicheRecord",paicheRecord);
       return "page/order/order-paiche-print";
    }

    /**
     * 派车单下载
     * @param request
     * @param response
     */
    @GetMapping(value = "/paicheExport")
    public void exportGWDataManageList(HttpServletRequest request, HttpServletResponse response){

        try{
            String paiCheDeptId=(String)request.getSession().getAttribute("paiCheDeptId");
            String paicheuseManId=(String)request.getSession().getAttribute("paicheuseManId");
            String paichecarId=(String)request.getSession().getAttribute("paichecarId");
            String paichedriverId=(String)request.getSession().getAttribute("paichedriverId");
            String paichestartTime=(String)request.getSession().getAttribute("paichestartTime");
            String paicheendTime=(String)request.getSession().getAttribute("paicheendTime");
            List<PaicheRecord> lists=paicheRecordService.selectRecords(paiCheDeptId,paicheuseManId,paichecarId,paichedriverId,paichestartTime,paicheendTime,0,0);

            String[] headerName = { "派车单号","开单日期","用车部门", "用车人", "用车事由","人数","载重","目的地","车牌号", "车辆类型", "驾驶员"};
            String[] headerKey = { "paicheno","paichedate","department", "useMan", "cause","man","weight","destination","carNo", "carType", "driverName"};
            HSSFWorkbook wb = ExcelUtil.createExcel(headerName, headerKey, "派车日志", lists);
            if (wb == null) {
                return;
            }
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String str = sdf.format(date);
            String fileName = "派车统计" + str;
            response.setHeader("Content-disposition",
                    "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO-8859-1") + ".xls");
            OutputStream ouputStream = response.getOutputStream();
            ouputStream.flush();
            wb.write(ouputStream);
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据统技下载
     * @param request
     * @param response
     */
    @GetMapping(value = "/chucheExport")
    public void exportGWDataManageList1(HttpServletRequest request, HttpServletResponse response){

        try{
            String chuCheDeptId=request.getParameter("chuCheDeptId");
            String chucheuseManId=request.getParameter("chucheuseManId");
            String chuchecarId=request.getParameter("chuchecarId");
            String chuchedriverId=request.getParameter("chuchedriverId");
            String chuchestartTime=request.getParameter("chuchestartTime");
            String chucheendTime=request.getParameter("chucheendTime");
            List<PaicheRecord> lists=paicheRecordService.selectchucheRecords(chuCheDeptId,chucheuseManId,chuchecarId,chuchedriverId,chuchestartTime,chucheendTime,0,0);

            String[] headerName = {"车牌号","车辆类型","用车人","驾驶员","目的地","任务内容","实际出厂时间","实际回厂时间"};
            String[] headerKey = { "carNo","carType","useMan","driverName","destination","cause","storageTime","returnTime"};
            HSSFWorkbook wb = ExcelUtil.createExcel(headerName, headerKey, "派车日志", lists);
            if (wb == null) {
                return;
            }
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String str = sdf.format(date);
            String fileName = "出车统计" + str;
            response.setHeader("Content-disposition",
                    "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO-8859-1") + ".xls");
            OutputStream ouputStream = response.getOutputStream();
            ouputStream.flush();
            wb.write(ouputStream);
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
