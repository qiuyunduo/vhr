package cn.qyd.vhr.service;

import cn.qyd.vhr.bean.JobLevel;
import cn.qyd.vhr.mapper.JobLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/4 17:52
 * @descript the descript
 */
@Service
public class JobLevelService {
    @Autowired
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> selectAll() {
        return jobLevelMapper.selectAll();
    }

    public int insertJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insert(jobLevel);
    }

    public int updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public int deleteJobLevel(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public int batchDeleteJobLevel(Integer[] ids) {
        return jobLevelMapper.batchDeleteJobLevel(ids);
    }
}
