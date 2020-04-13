package cn.qyd.vhr.mapper;

import cn.qyd.vhr.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Long getTotals(@Param("employee")Employee employee,
                   @Param("b2eDate")Date[] b2eDate);

    List<Employee> getEmployeesByPage(@Param("page") Integer page,
                                      @Param("size")Integer size,
                                      @Param("employee")Employee employee,
                                      @Param("b2eDate")Date[] b2eDate);

    Long maxWorkId();

    Integer batchInsert(@Param("employees") List<Employee> employees);

    Employee getEmployeeById(Integer id);

    List<Employee> getEmployeesWithSalary(@Param("page") Integer page, @Param("size") Integer size);

    Integer updateEmployeeSalaryById(@Param("eid") Integer eid, @Param("sid")Integer sid);
}