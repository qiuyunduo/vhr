package cn.qyd.vhr.mapper;

import cn.qyd.vhr.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getDepartmentsByPid(Integer pid);

    void addDep(Department dep);

    void deleteDep(Department department);

    List<Department> getAllDeps();
}