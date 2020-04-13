package cn.qyd.vhr.controller.emp;

import cn.qyd.vhr.bean.*;
import cn.qyd.vhr.service.*;
import cn.qyd.vhr.util.POIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/7 13:04
 * @descript the descript
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsStatusService politicsStatusService;
    @Autowired
    JobLevelService jobLevelService;

    @Autowired
    PositionService positionService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmployeesByPage(@RequestParam(defaultValue = "1")Integer page,
                                           @RequestParam(defaultValue = "10") Integer size,
                                           Employee employee,
                                           Date[] b2eDate) {
        return employeeService.getEmployeesByPage(page,size,employee,b2eDate);

    }

    @GetMapping("/nations")
    public RespBean getAllNations() {
        List<Nation> nations = nationService.getAllNations();
        return RespBean.ok(nations);
    }

    @GetMapping("/joblevels")
    public RespBean getAllJobLevels() {
        List<JobLevel> jobLevels = jobLevelService.selectAll();
        return RespBean.ok(jobLevels);
    }
    @GetMapping("/politicsStatus")
    public RespBean getAllPoliticsStatus() {
        List<PoliticsStatus> politicsStatus = politicsStatusService.getAllPoliticsStatus();
        return RespBean.ok(politicsStatus);
    }

    @GetMapping("/positions")
    public RespBean getAllPositions() {
        List<Position> positions = positionService.selectPosList();
        return RespBean.ok(positions);
    }

    @GetMapping("/departments")
    public RespBean getTreeDeps() {
        List<Department> deps = departmentService.getTreeDeps();
        return RespBean.ok(deps);
    }

    @GetMapping("/workID")
    public RespBean getWorkID() {
        Long maxId = employeeService.maxWorkId();
        return RespBean.build().setStatus(200).setObject(String.format("%08d",maxId+1));
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportEmployees() {
        List<Employee> employees = (List<Employee>) employeeService.getEmployeesByPage(null,null,null,null).getObjects();
        return POIUtil.employeeToExcel(employees);

    }

//    @GetMapping("/date")
//    //测试日期转换器是否起作用
//    public RespBean getDate(Date[] b2eDate) {
//        System.out.println(Arrays.toString(b2eDate));
//        return RespBean.ok("success");
//    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) {
//            file.transferTo(new File("D:\\qiuyunduo.xls"))
        List<Employee> employees = POIUtil.excel2Employees(file, nationService.getAllNations(), politicsStatusService.getAllPoliticsStatus()
                , positionService.selectPosList(), jobLevelService.selectAll(), departmentService.getAllDeps());
        Integer result = employeeService.batchInsert(employees);
        if(result == employees.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }

    @PostMapping("/")
    public RespBean addEmployee(@RequestBody Employee employee) {
        Integer result = employeeService.addEmployee(employee);
        if(result == 1) {
            return RespBean.ok("员工添加成功");
        }
        return RespBean.error("员工添加失败");
    }

    @PutMapping("/")
    public RespBean updateEmployee(@RequestBody Employee employee) {
        Integer result = employeeService.updateEmployee(employee);
        if(result == 1) {
            return RespBean.ok("员工信息更新成功");
        }
        return RespBean.error("员工信息更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmployee(@PathVariable Integer id) {
        Integer result = employeeService.deleteEmpById(id);
        if(result == 1) {
            return RespBean.ok("删除员工成功");
        }

        return RespBean.error("删除员工失败");
    }
}
