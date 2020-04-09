package cn.qyd.vhr.service;

import cn.qyd.vhr.bean.Department;
import cn.qyd.vhr.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/5 13:55
 * @descript the descript
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;


    public List<Department> getTreeDeps() {
        return departmentMapper.getDepartmentsByPid(-1);
    }

    public List<Department> getAllDeps() {
        return departmentMapper.getAllDeps();
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        dep.setIsParent(false);
        departmentMapper.addDep(dep);
    }

    public void deleteDep(Department department) {
        departmentMapper.deleteDep(department);
    }
}
