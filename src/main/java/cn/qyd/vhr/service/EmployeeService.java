package cn.qyd.vhr.service;

import cn.qyd.vhr.enums.WorkStateEnum;
import cn.qyd.vhr.bean.Employee;
import cn.qyd.vhr.bean.RespPageBean;
import cn.qyd.vhr.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/7 13:12
 * @descript the descript
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public RespPageBean getEmployeesByPage(Integer page, Integer size, Employee employee,
                                           Date[] b2eDate) {
        if(page != null && size != null) {
            page = (page-1) * size;
        }
        Long totals = employeeMapper.getTotals(employee,b2eDate);
        List<Employee> employees = employeeMapper.getEmployeesByPage(page,size,employee,b2eDate);
        return new RespPageBean(totals,employees);
    }

    public Integer addEmployee(Employee employee) {
        employee.setWorkState(WorkStateEnum.WORKING.getState());
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        Double months = (Double.parseDouble(yearDateFormat.format(endContract)) - Double.parseDouble(yearDateFormat.format(beginContract))) * 12
                +(Double.parseDouble(monthDateFormat.format(endContract)) - Double.parseDouble(monthDateFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(months / 12)));
        return employeeMapper.insertSelective(employee);
    }

    public Long maxWorkId() {
        return employeeMapper.maxWorkId();
    }

    public Integer deleteEmpById(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }


    public Integer batchInsert(List<Employee> employees) {
        return employeeMapper.batchInsert(employees);
    }
}
