package com.tinysoft.cn.controller;
import com.tinysoft.cn.service.OutProductPrintService;
import com.tinysoft.cn.util.DownloadUtil;
import com.tinysoft.cn.vo.OutProductPrintVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by 董乐强 on 2017/11/7.
 */
@Controller
public class OutProductPrintController {

    @Resource
    private OutProductPrintService outProductPrintService;


    //查看出货表，按月统计
    public String list(){

        return "";
    }


    //跳转到打印页面
    @RequestMapping("/cargo/contract/toprint.action")
    public String toprint(){
        return "/cargo/contract/jOutProduct.jsp";
    }

    //对数据进行打印
    @RequestMapping("/cargo/contract/print.action")
    public String  print(String inputDate, HttpServletResponse reponse){
        //得到的数据输出到excel
        List<OutProductPrintVO> dataList= outProductPrintService.find(inputDate);
        //创建一个工作簿
        Workbook workBook = new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workBook.createSheet();
        //创建样式和字体
        CellStyle cStyle = workBook.createCellStyle();
        Font curFont = workBook.createFont();

        //主标题，合并单元格
        //行
        Row nRow = null;
        //列
        Cell nCell = null;
        //行号
        int rowNo = 0;
        //列号
        int colNo=  1;

        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0,0,1,8));

        //设置列宽
        sheet.setColumnWidth(0,1*278);
        sheet.setColumnWidth(1,26*278);

        nRow = sheet.createRow(rowNo++);
        //设置行高
        nRow.setHeightInPoints(36);

        nCell = nRow.createCell(1);

        nCell.setCellStyle(bigTitleStyle(workBook));

        nCell.setCellValue(inputDate.replaceFirst("-","年")+"月份出货表");

        //表的标题
        String[] title = new String[]{"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};

        nRow =sheet.createRow(rowNo++);
        nRow.setHeightInPoints(36);

        for(int i = 0 ; i<title.length;i++){
            nCell = nRow.createCell(i+1);
            nCell.setCellValue(title[i]);
            nCell.setCellStyle(smallTitleStyle(workBook));
        }

        for(int j = 0 ; j<dataList.size();j++){
            //得到数据
            OutProductPrintVO outProductPrintVO = dataList.get(j);
            colNo=1;
            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24);
            nCell= nRow.createCell(colNo++);
            nCell.setCellValue(outProductPrintVO.getCustomName());
            nCell.setCellStyle(textStyle(workBook,cStyle,curFont));
            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProductPrintVO.getContractNo());
            nCell.setCellStyle(textStyle(workBook,cStyle,curFont));
            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProductPrintVO.getProductNo());
            nCell.setCellStyle(textStyle(workBook,cStyle,curFont));
            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProductPrintVO.getCnumber());
            nCell.setCellStyle(textStyle(workBook,cStyle,curFont));
            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProductPrintVO.getFactoryName());
            nCell.setCellStyle(textStyle(workBook,cStyle,curFont));
            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProductPrintVO.getDeliveryPeriod());
            nCell.setCellStyle(textStyle(workBook,cStyle,curFont));
            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProductPrintVO.getShipTime());
            nCell.setCellStyle(textStyle(workBook,cStyle,curFont));
            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProductPrintVO.getTradeTerms());
            nCell.setCellStyle(textStyle(workBook,cStyle,curFont));
        }
        try {
            //输出到本地
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            //保存到字节数组流
            workBook.write(os);
            DownloadUtil downloadUtil = new DownloadUtil();
            downloadUtil.download(os,reponse,"出货表.xls");
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //大标题样式
    private CellStyle bigTitleStyle(Workbook wb){
          CellStyle cellStyle = wb.createCellStyle();
          Font font = wb.createFont();
          font.setFontName("宋体");
          font.setFontHeightInPoints((short)16);
          font.setBoldweight(Font.BOLDWEIGHT_BOLD);
          cellStyle.setFont(font);
          cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
          cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
          return cellStyle;
    }

    //小标题样式
    private CellStyle smallTitleStyle(Workbook wb){
        CellStyle cellStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)12);
        cellStyle.setFont(font);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        return cellStyle;
    }

    //文字样式
    private CellStyle textStyle(Workbook wb, CellStyle curStyle, Font curFont){
        curFont.setFontName("Times New Roman");
        curFont.setFontHeightInPoints((short)10);
        curStyle.setFont(curFont);										//绑定字体
        curStyle.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
        curStyle.setBorderTop(CellStyle.BORDER_THIN);					//设置四周边线，细线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);
        curStyle.setBorderLeft(CellStyle.BORDER_THIN);
        curStyle.setBorderRight(CellStyle.BORDER_THIN);
        return curStyle;
    }

    //进行模版开发
    @RequestMapping("/cargo/contract/printHSSF.action")
    public String printHSSF(String inputDate, HttpServletRequest request,HttpServletResponse response){
         String path = request.getSession().getServletContext().getRealPath("/")+"/make/xlsprint/";
         FileInputStream is = null;
        try {
           is = new FileInputStream(new File(path+"tOUTPRODUCT.xls"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HSSFWorkbook wb=null;
        try {
            wb = new HSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到这个sheet
        Sheet sheet = wb.getSheetAt(0);
        Row nRow = null;
        Cell nCell = null;
        int rowNo=0;
        int colNo=1;

        //获取客户单元格的样式
        nRow = sheet.getRow(2);
        nCell = nRow.getCell(1);
        CellStyle customerNameStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(2);
        CellStyle orderStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(3);
        CellStyle productStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(4);
        CellStyle productNumStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(5);
        CellStyle factoryNameStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(6);
        CellStyle factoryTimeStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(7);
        CellStyle shipTimeStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(8);
        CellStyle tradeStyle = nCell.getCellStyle();

        //处理大标题
        nRow = sheet.getRow(rowNo++);
        nCell = nRow.getCell(colNo);
        nCell.setCellValue(inputDate.replace("-","年")+"月份出货表");

        rowNo++;

         List<OutProductPrintVO> dataList = outProductPrintService.find(inputDate);


         for(int j = 0 ; j<dataList.size();j++){
            OutProductPrintVO o = dataList.get(j);

            colNo=1;

            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(colNo++);
            nCell.setCellStyle(customerNameStyle);
            nCell.setCellValue(o.getCustomName());

             nCell = nRow.createCell(colNo++);
             nCell.setCellStyle(orderStyle);
             nCell.setCellValue(o.getContractNo());


             nCell = nRow.createCell(colNo++);
             nCell.setCellStyle(productStyle);
             nCell.setCellValue(o.getProductNo());


             nCell = nRow.createCell(colNo++);
             nCell.setCellStyle(productNumStyle);
             nCell.setCellValue(o.getCnumber());


             nCell = nRow.createCell(colNo++);
             nCell.setCellStyle(factoryNameStyle);
             nCell.setCellValue(o.getFactoryName());

             nCell = nRow.createCell(colNo++);
             nCell.setCellStyle(factoryTimeStyle);
             nCell.setCellValue(o.getTradeTerms());


             nCell = nRow.createCell(colNo++);
             nCell.setCellStyle(shipTimeStyle);
             nCell.setCellValue(o.getShipTime());


             nCell = nRow.createCell(colNo++);
             nCell.setCellStyle(tradeStyle);
             nCell.setCellValue(o.getTradeTerms());

         }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DownloadUtil downloadUtil = new DownloadUtil();				//直接弹出下载框，用户可以打开，可以保存
        try {
            downloadUtil.download(os, response, "出货表.xls");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }

















}



