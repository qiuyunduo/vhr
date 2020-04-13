package cn.qyd.vhr.controller.sys.basic;

import cn.qyd.vhr.bean.JobLevel;
import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiuyunduo
 * @date 2020/4/4 17:49
 * @descript the descript
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public RespBean getAllJobLevels() {
        return RespBean.ok(jobLevelService.selectAll());
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        int result = jobLevelService.insertJobLevel(jobLevel);
        if(result == 1) {
            return RespBean.ok("职称添加成功");
        }

        return RespBean.error("职称添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        int result = jobLevelService.updateJobLevel(jobLevel);
        if(result == 1) {
            return RespBean.ok("职称更新成功");
        }

        return RespBean.error("职称更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean addJobLevel(@PathVariable Integer id) {
        int result = jobLevelService.deleteJobLevel(id);
        if(result == 1) {
            return RespBean.ok("职称删除成功");
        }

        return RespBean.error("职称删除失败");
    }

    @DeleteMapping("/batch")
    public RespBean addJobLevel(Integer[] ids) {
        int result = jobLevelService.batchDeleteJobLevel(ids);
        if(result == ids.length) {
            return RespBean.ok("职称批量删除成功");
        }

        return RespBean.error("职称批量删除失败");
    }



}
