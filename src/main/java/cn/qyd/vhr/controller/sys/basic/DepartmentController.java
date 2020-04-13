package cn.qyd.vhr.controller.sys.basic;

import cn.qyd.vhr.bean.Department;
import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/5 13:54
 * @descript the descript
 */
@RestController
@RequestMapping("/system/basic/dep")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespBean getTreeDepartment() {
        List<Department> departments =  departmentService.getTreeDeps();
        return RespBean.ok(departments);
    }

    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department dep) {
        departmentService.addDep(dep);
        if(dep.getResult() == 1) {
            return RespBean.ok("添加部门成功",dep);
        }

        return RespBean.error("添加部门失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepartment(@PathVariable Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentService.deleteDep(department);
        if(department.getResult() == -2) {
            return RespBean.error("该部门下有子部门，删除失败");
        } else if(department.getResult() == -1) {
            return RespBean.error("该部门下有员工，删除失败");
        } else if (department.getResult() == 1) {
            return RespBean.ok("删除部门成功",department);
        }

        return RespBean.error("删除部门失败");
    }
}
