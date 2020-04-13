package cn.qyd.vhr.controller.salary;

import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.bean.Salary;
import cn.qyd.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/10 0:46
 * @descript the descript
 */
@RestController
@RequestMapping("/salary/sob")
public class SalarySobController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespBean getAllSalaries() {
        List<Salary> salaries = salaryService.getAllSalaries();
        return RespBean.ok(salaries);
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        Integer result = salaryService.addSalary(salary);
        if(result == 1) {
            return RespBean.ok("添加工资账套成功");
        }

        return RespBean.error("添加工资账套失败");
    }

    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary) {
        Integer result = salaryService.updateSalay(salary);
        if(result == 1) {
            return RespBean.ok("更新工资账套成功");
        }

        return RespBean.error("更新工资账套失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalaryById(@PathVariable Integer id) {
        Integer result = salaryService.deleteSalaryById(id);
        if(result == 1) {
            return RespBean.ok("删除工资账套成功");
        }

        return RespBean.error("删除工资账套失败");
    }
}
