package cn.qyd.vhr.controller.salary;

import cn.qyd.vhr.bean.Employee;
import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.bean.RespPageBean;
import cn.qyd.vhr.bean.Salary;
import cn.qyd.vhr.service.EmployeeService;
import cn.qyd.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/10 20:04
 * @descript the descript
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class SalarySobCfgController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeesWithSalary(@RequestParam(defaultValue = "1")Integer page,
                                               @RequestParam(defaultValue = "10")Integer size) {
        return employeeService.getEmployeesWithSalary(page,size);
    }

    @GetMapping("/salaries")
    public RespBean getSalaries() {
        List<Salary> allSalaries = salaryService.getAllSalaries();
        return RespBean.ok(allSalaries);
    }

    @PutMapping("/")
    public RespBean updateEmployeeSalaryById(Integer eid, Integer sid) {
        Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
        /** 两种可能
         * 1.对应的eid在数据库中不存在，只需要进行插入操作，result=1
         * 2.对应的eid在数据库中存在先进行删除操作后插入，result=2
         * 两种可能都是成功的
         */
        if(result == 1 || result == 2) {
            return RespBean.ok("员工账套更新成功");
        }
        return RespBean.error("员工账套更新失败");
    }
}
