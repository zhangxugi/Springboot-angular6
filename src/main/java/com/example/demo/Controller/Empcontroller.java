package com.example.demo.Controller;

import com.example.demo.mapper.EmplRepository;
import com.example.demo.mapper.UsersRepository;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Users;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.UserImpl;
import com.example.demo.service.UsersService;
import org.apache.catalina.User;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Administrator on 2018/10/29 0029.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class Empcontroller {
    @Autowired
    private EmplRepository emplRepository;
@Autowired
private EmployeeService employeeService;
    @Autowired
    private UserImpl usersService;

    @GetMapping("/empselect")
    public List<Employee> getUsers(){
        return emplRepository.findAll();

    }
    @GetMapping("/empselect/{id}")
    public Optional<Employee>  getUser(@PathVariable Long id){

        return emplRepository.findById(id);

    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Long id){
        emplRepository.deleteById(id);
        return true;

    }

    @PutMapping("/update")
    public Employee updateUser(@RequestBody Employee employee){

        return  emplRepository.save(employee);

    }
    @PostMapping("/add")
    public Employee createUser(@RequestBody Employee employee){

        return  emplRepository.save(employee);

    }

    @PostMapping("/login")

    public String login(@RequestBody Users users) {
        System.out.println(users.getName());
        Users user = usersService.login(users.getName(), users.getPassword());
        if (user.getUid() == 0) {
            return "失败";
        } else {
            return "成功";
        }
    }
        @RequestMapping(value = "UserExcelDownloads", method = RequestMethod.GET)
        public void downloadAllClassmate(HttpServletResponse response) throws IOException {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("信息表");

            List<Employee> classmateList = employeeService.teacherinfor();

            String fileName = "Employee"  + ".xls";//设置要导出的文件的名字
            //新增数据行，并且设置单元格数据

            int rowNum = 1;

            String[] headers = { "ID", "姓名", "姓氏", "性别","出生日期","部门"};
            //headers表示excel表中第一行的表头

            HSSFRow row = sheet.createRow(0);
            //在excel表中添加表头

            for(int i=0;i<headers.length;i++){
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            //在表中存放查询到的数据放入对应的列
            for (Employee teacher : classmateList) {
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(teacher.getEmployeeId());
                row1.createCell(1).setCellValue(teacher.getFirstName());
                row1.createCell(2).setCellValue(teacher.getLastName());
                row1.createCell(3).setCellValue(teacher.getGender());
                row1.createCell(4).setCellValue(teacher.getDob());
                row1.createCell(5).setCellValue(teacher.getDepartment());
                rowNum++;
            }

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        }

        //导入

        @RequestMapping("Excelfile")

        public  String upload(MultipartFile file, HttpServletRequest request) {
            try {
                List<Employee> typeLists = new ArrayList<Employee>();

                System.out.println("开始");
                //使用POI解析Excel文件
                //如果是xls，使用HSSFWorkbook；2003年的excel  如果是xlsx，使用XSSFWorkbook  2007年excel
                HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
                //根据名称获得指定Sheet对象
                HSSFSheet hssfSheet = workbook.getSheetAt(0);
                for (Row row : hssfSheet) {
                    Employee Type = new Employee();
                    int rowNum = row.getRowNum();
                    if(rowNum == 0){//跳出第一行   一般第一行都是表头没有数据意义
                        continue;
                    }
                    if(row.getCell(0)!=null){//第1列数据
                        row.getCell(0).setCellType(CellType.STRING);
                        Type.setEmployeeId(Long.parseLong(row.getCell(0).getStringCellValue()));
                    }
                    if(row.getCell(1)!=null){//第2列数据
                        row.getCell(1).setCellType(CellType.STRING);
                        Type.setFirstName(row.getCell(1).getStringCellValue());
                    }
                    if(row.getCell(2)!=null){//第3列
                        row.getCell(2).setCellType(CellType.STRING);
                        Type.setLastName(row.getCell(2).getStringCellValue());
                    }

//	    		 转换为Integer类型
                    if(row.getCell(3)!=null){//第4列
                        row.getCell(3).setCellType(CellType.STRING);
                        //Type.setAdduserid(Integer.parseInt(row.getCell(3).getStringCellValue()));
                        Type.setGender(row.getCell(3).getStringCellValue());
                    }
                    if(row.getCell(4)!=null){//第3列
                        row.getCell(4).setCellType(CellType.STRING);
                        Type.setDob(row.getCell(4).getStringCellValue());
                    }
                    if(row.getCell(5)!=null){//第3列
                        row.getCell(5).setCellType(CellType.STRING);
                        Type.setDepartment(row.getCell(5).getStringCellValue());
                    }
                    //  转换为日期类型
               /* if(row.getCell(4)!=null){//第5列
                    row.getCell(4).setCellType(Cell.CELL_TYPE_NUMERIC);
                    Type.setAddtime( HSSFDateUtil.getJavaDate(row.getCell(4).getNumericCellValue()));
                }*/

                    typeLists.add(Type);
                }
                //调用service执行保存typeLists的方法
                employeeService.saveExcelList(typeLists);
            }catch(Exception e){
                e.printStackTrace();
            }
            return "导入成功";
        }

}
