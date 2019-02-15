package com.wisely.contoller;

import com.wisely.Entity.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExportDemo
 * @Description 导出数据到计算机指定位置的excel
 * @Author NingKang
 * @Date 2019/2/14 10:13
 * @Version 1.0
 **/
@RestController
@RequestMapping(value="/export")
public class ExportController {
    public static List getUser() throws Exception{
        List<User> li = new ArrayList<User>();
            User u1 = new User("1", "中国制造", "2000-5-20");
            User u2 = new User("2", "中国智造", "2020-03-05");
            User u3 = new User("3", "中国AI","2030-06-15");
            li.add(u1);
            li.add(u2);
            li.add(u3);
            return li;
    }


    //逻辑：1、创建工作簿-->2、创建工作表-->3、创建行-->4、创建表格/cell-->5、写入数据-->6、设置储存路径
    @RequestMapping("/exportExcle")
    public static void exportExcle() throws Exception {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        //1、创建工作簿
        Workbook wb = new XSSFWorkbook();
        //1.1、设置表格的格式----居中
        CellStyle cs = wb.createCellStyle();
       /* HorizontalAlignment center = HorizontalAlignment.CENTER;
        cs.setAlignment(center);*/
        //2.1、创建工作表
        Sheet sheet = wb.createSheet("学生表格");
        //2.2、合并单元格
        sheet.addMergedRegion(new CellRangeAddress(4, 8, 5, 9));
        //3.1、创建行----表头行
        Row row=sheet.createRow(0);
        //4、创建格
        Cell cell = row.createCell(0);
        cell.setCellValue("我的列名");
        cell.setCellStyle(cs);
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell.setCellStyle(cs);
        cell = row.createCell(2);
        cell.setCellValue("时间");
        cell.setCellStyle(cs);

        //5、写入实体数据
        List<User> list = ExportController.getUser();
        for (int i = 0; i < list.size(); i++) {
            //3.2、创建行----内容行
            row = sheet.createRow(i+1);
            User us = (User)list.get(i);
            //第几行第几格  第一行第一格为“code”
            row.createCell(0).setCellValue(us.getCode());
            row.createCell(1).setCellValue(us.getName());
            row.createCell(2).setCellValue(us.getBirth());
        }

        //6、将文件储存到指定位置
        try {
            FileOutputStream fout = new FileOutputStream("E:\\newMy\\uu.xlsx");
            wb.write( response.getOutputStream());
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
