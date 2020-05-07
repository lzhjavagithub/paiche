package com.qdyd.vehicle.controller;

import com.qdyd.vehicle.po.TDuty;
import com.qdyd.vehicle.po.entity.Result;
import com.qdyd.vehicle.po.entity.StatusCode;
import com.qdyd.vehicle.service.DutyService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DutyController {

    @Autowired
    private DutyService dutyService;
    @PostMapping(value = "/importDuty")
    @ResponseBody
    public Result importDuty(@RequestParam(name="file")MultipartFile file) throws Exception {
        //1.根据Excel文件创建工作簿
        Workbook wb = new XSSFWorkbook(file.getInputStream());
        //2.获取Sheet
        Sheet sheet = wb.getSheetAt(0);//参数：索引
        //3.获取Sheet中的每一行，和每一个单元格
        List<TDuty> list=new ArrayList<>();
        for (int rowNum = 1; rowNum<= sheet.getLastRowNum() ;rowNum ++) {
            Row row = sheet.getRow(rowNum);//根据索引获取每一个行
            Object[] values=new Object[row.getLastCellNum()];
            for(int cellNum=1;cellNum< row.getLastCellNum(); cellNum ++) {
                //根据索引获取每一个单元格
                Cell cell = row.getCell(cellNum);
                //获取每一个单元格的内容
                Object value = getCellValue(cell);
                values[cellNum]=value;
            }
            TDuty duty=new TDuty(values);
            list.add(duty);
        }
        dutyService.addDuty(list);
        return new Result(true, StatusCode.OK,"");
    }



    public static Object getCellValue(Cell cell) {
        //1.获取到单元格的属性类型
        CellType cellType = cell.getCellType();
        //2.根据单元格数据类型获取数据
        Object value = null;
        switch (cellType) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)) {
                    //日期格式
                    value = cell.getDateCellValue();
                }else{
                    //数字
                    value = cell.getNumericCellValue();
                }
                break;
            case FORMULA: //公式
                value = cell.getCellFormula();
                break;
            default:
                break;
        }
        return value;
    }

}
