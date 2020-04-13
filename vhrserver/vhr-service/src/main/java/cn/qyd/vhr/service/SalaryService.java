package cn.qyd.vhr.service;

import cn.qyd.vhr.bean.Salary;
import cn.qyd.vhr.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/10 0:45
 * @descript the descript
 */
@Service
public class SalaryService {
    @Autowired
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalaries() {
        return salaryMapper.getAllSalaries();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());

        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalaryById(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalay(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }
}
