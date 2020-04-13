package cn.qyd.vhr.util;

import cn.qyd.vhr.bean.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/8 18:41
 * @descript the descript
 */
public class POIUtil {
    /**
     * 根据Employee集合生成 Excel
     * @param employees
     * @return
     */
    public static ResponseEntity<byte[]> employeeToExcel(List<Employee> employees) {
        //1、创建一个Excel文档
        HSSFWorkbook sheets = new HSSFWorkbook();
        //2、创建文档摘要
        sheets.createInformationProperties();
        //3、获取并配置文档信息
        DocumentSummaryInformation dcInfomation = sheets.getDocumentSummaryInformation();
        //3.1文档类别
        dcInfomation.setCategory("员工信息");
        //3.2设置管理员
        dcInfomation.setManager("qiuyunduo");
        //3.3设置公司信息
        dcInfomation.setCompany("www.qiuyunduo.xyz");
        //4、获取并配置摘要信息
        SummaryInformation summInfo = sheets.getSummaryInformation();
        //文档标题
        summInfo.setTitle("员工信息表");
        //文档作者
        summInfo.setAuthor("qiuyunduo");
        //文档备注
        summInfo.setComments("本文档有qiuyunduo提供");

        //5、创建样式
        HSSFCellStyle hssfCellStyle = sheets.createCellStyle();
        //5、1创建标题行的样式
        hssfCellStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        hssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateFormatStyle = sheets.createCellStyle();
        dateFormatStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

        HSSFSheet sheet = sheets.createSheet("员工信息表");
        sheet.setColumnWidth(0,5*256);
        sheet.setColumnWidth(1,10*256);
        sheet.setColumnWidth(2,10*256);
        sheet.setColumnWidth(3,5*256);
        sheet.setColumnWidth(4,15*256);
        sheet.setColumnWidth(5,20*256);
        sheet.setColumnWidth(6,5*256);
        sheet.setColumnWidth(7,8*256);
        sheet.setColumnWidth(8,20*256);
        sheet.setColumnWidth(9,15*256);
        sheet.setColumnWidth(10,25*256);
        sheet.setColumnWidth(11,15*256);
        sheet.setColumnWidth(12,30*256);
        sheet.setColumnWidth(13,15*256);
        sheet.setColumnWidth(14,15*256);
        sheet.setColumnWidth(15,15*256);
        sheet.setColumnWidth(16,10*256);
        sheet.setColumnWidth(17,15*256);
        sheet.setColumnWidth(18,10*256);
        sheet.setColumnWidth(19,15*256);
        sheet.setColumnWidth(20,5*256);
        sheet.setColumnWidth(21,15*256);
        sheet.setColumnWidth(22,15*256);
        sheet.setColumnWidth(23,8*256);
        sheet.setColumnWidth(24,10*256);
        sheet.setColumnWidth(25,15*256);
        //6、创建标题行 第0行为标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(hssfCellStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(hssfCellStyle);
        c1.setCellValue("姓名");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(hssfCellStyle);
        c2.setCellValue("工号");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(hssfCellStyle);
        c3.setCellValue("性别");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(hssfCellStyle);
        c4.setCellValue("出生日期");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(hssfCellStyle);
        c5.setCellValue("身份证号码");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(hssfCellStyle);
        c6.setCellValue("婚姻状况");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(hssfCellStyle);
        c7.setCellValue("民族");
        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(hssfCellStyle);
        c8.setCellValue("籍贯");
        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(hssfCellStyle);
        c9.setCellValue("政治面貌");
        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(hssfCellStyle);
        c10.setCellValue("电子邮件");
        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(hssfCellStyle);
        c11.setCellValue("电话号码");
        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(hssfCellStyle);
        c12.setCellValue("联系地址");
        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(hssfCellStyle);
        c13.setCellValue("所属部门");
        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(hssfCellStyle);
        c14.setCellValue("职位");
        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(hssfCellStyle);
        c15.setCellValue("职称");
        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(hssfCellStyle);
        c16.setCellValue("聘用形式");
        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(hssfCellStyle);
        c17.setCellValue("毕业院校");
        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(hssfCellStyle);
        c18.setCellValue("专业");
        HSSFCell c19 = r0.createCell(19);
        c19.setCellStyle(hssfCellStyle);
        c19.setCellValue("入职日期");
        HSSFCell c20 = r0.createCell(20);
        c20.setCellStyle(hssfCellStyle);
        c20.setCellValue("在职状态");
        HSSFCell c21 = r0.createCell(21);
        c21.setCellStyle(hssfCellStyle);
        c21.setCellValue("合同起始日期");
        HSSFCell c22 = r0.createCell(22);
        c22.setCellStyle(hssfCellStyle);
        c22.setCellValue("合同截止日期");
        HSSFCell c23 = r0.createCell(23);
        c23.setCellStyle(hssfCellStyle);
        c23.setCellValue("合同期限(年");
        HSSFCell c24 = r0.createCell(24);
        c24.setCellStyle(hssfCellStyle);
        c24.setCellValue("最高学历");
        HSSFCell c25 = r0.createCell(25);
        c25.setCellStyle(hssfCellStyle);
        c25.setCellValue("转正日期");

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            HSSFRow row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getWorkID());
            row.createCell(3).setCellValue(employee.getGender());
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellStyle(dateFormatStyle);
            cell4.setCellValue(employee.getBirthday());
            row.createCell(5).setCellValue(employee.getIdCard());
            row.createCell(6).setCellValue(employee.getWedlock());
            row.createCell(7).setCellValue(employee.getNation().getName());
            row.createCell(8).setCellValue(employee.getNativePlace());
            row.createCell(9).setCellValue(employee.getPoliticsStatus().getName());
            row.createCell(10).setCellValue(employee.getEmail());
            row.createCell(11).setCellValue(employee.getPhone());
            row.createCell(12).setCellValue(employee.getAddress());
            row.createCell(13).setCellValue(employee.getDepartment().getName());
            row.createCell(14).setCellValue(employee.getPosition().getName());
            row.createCell(15).setCellValue(employee.getJobLevel().getName());
            row.createCell(16).setCellValue(employee.getEngageForm());
            row.createCell(17).setCellValue(employee.getSchool());
            row.createCell(18).setCellValue(employee.getSpecialty());
            HSSFCell cell19 = row.createCell(19);
            cell19.setCellStyle(dateFormatStyle);
            cell19.setCellValue(employee.getBeginDate());
            row.createCell(20).setCellValue(employee.getWorkState());
            HSSFCell cell21 = row.createCell(21);
            cell21.setCellStyle(dateFormatStyle);
            cell21.setCellValue(employee.getBeginContract());
            HSSFCell cell22 = row.createCell(22);
            cell22.setCellStyle(dateFormatStyle);
            cell22.setCellValue(employee.getEndContract());
            row.createCell(23).setCellValue(employee.getContractTerm());
            row.createCell(24).setCellValue(employee.getTiptopDegree());
            HSSFCell cell25 = row.createCell(25);
            /**
             * 开始因为数据库中conversionTime字段有NUll值，导致这里一直报空指针，
             * 做一个空判断，但其实是数据库数据不合理而已，该字段正常不可能是空的但是还做一个解决办法吧！
            */
            if(employee.getConversionTime() == null) {
                cell25.setCellValue("");
            }else  {
                cell25.setCellStyle(dateFormatStyle);
                cell25.setCellValue(employee.getConversionTime());
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment",new String("员工表.xls".getBytes("UTF-8"),"ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            sheets.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(outputStream.toByteArray(),headers, HttpStatus.CREATED);
    }

    /**
     * Excel 解析成Employee集合
     * @param file
     * @param nations
     * @param politicsStatuses
     * @param positions
     * @param jobLevels
     * @param deps
     * @return
     */
    public static List<Employee> excel2Employees(MultipartFile file, List<Nation> nations, List<PoliticsStatus> politicsStatuses, List<Position> positions, List<JobLevel> jobLevels, List<Department> deps) {
        List<Employee> list = new ArrayList<>();
        Employee emp = null;
        try {
            //1、创建一个 workBook对象
            HSSFWorkbook sheets = new HSSFWorkbook(file.getInputStream());
            //2、获取workbook中表单的数量
            int numberOfSheets = sheets.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3、获取表单
                HSSFSheet sheet = sheets.getSheetAt(i);
                //4、获取表单中行数
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < numberOfRows; j++) {
                    //5、跳过标题行
                    if(j == 0) {
                        continue;
                    }
                    //6、获取行
                    HSSFRow row = sheet.getRow(j);
                    if(row == null) {
                        continue; //防止数据之间有空行
                    }
                    //7、获取行的列数
                    int numberOfCells = row.getPhysicalNumberOfCells();
                    emp = new Employee();
                    for (int k = 0; k < numberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 1:
                                        emp.setName(cellValue);
                                        break;
                                    case 2:
                                        emp.setWorkID(cellValue);
                                        break;
                                    case 3:
                                        emp.setGender(cellValue);
                                        break;
                                    case 5:
                                        emp.setIdCard(cellValue);
                                        break;
                                    case 6:
                                        emp.setWedlock(cellValue);
                                        break;
                                    case 7:
                                        emp.setNationId(nations.get(nations.indexOf(new Nation(cellValue))).getId());
                                        break;
                                    case 8:
                                        emp.setNativePlace(cellValue);
                                        break;
                                    case 9:
                                        emp.setPoliticId(politicsStatuses.get(politicsStatuses.indexOf(new PoliticsStatus(cellValue))).getId());
                                        break;
                                    case 10:
                                        emp.setEmail(cellValue);
                                        break;
                                    case 11:
                                        emp.setPhone(cellValue);
                                        break;
                                    case 12:
                                        emp.setAddress(cellValue);
                                        break;
                                    case 13:
                                        emp.setDepartmentId(deps.get(deps.indexOf(new Department(cellValue))).getId());
                                        break;
                                    case 14:
                                        emp.setPosId(positions.get(positions.indexOf(new Position(cellValue))).getId());
                                        break;
                                    case 15:
                                        emp.setJobLevelId(jobLevels.get(jobLevels.indexOf(new JobLevel(cellValue))).getId());
                                        break;
                                    case 16:
                                        emp.setEngageForm(cellValue);
                                        break;
                                    case 17:
                                        emp.setSchool(cellValue);
                                        break;
                                    case 18:
                                        emp.setSpecialty(cellValue);
                                        break;
                                    case 20:
                                        emp.setWorkState(cellValue);
                                        break;
                                    case 24:
                                        emp.setTiptopDegree(cellValue);
                                        break;
                                }
                                break;
                            default:
                                switch (k) {
                                    case 4:
                                        emp.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 19:
                                        emp.setBeginDate(cell.getDateCellValue());
                                        break;
                                    case 21:
                                        emp.setBeginContract(cell.getDateCellValue());
                                        break;
                                    case 22:
                                        emp.setEndContract(cell.getDateCellValue());
                                        break;
                                    case 23:
                                        emp.setContractTerm(cell.getNumericCellValue());
                                        break;
                                    case 25:
                                        emp.setConversionTime(cell.getDateCellValue());
                                        break;
                                }
                                break;
                        }
                    }
                    list.add(emp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
