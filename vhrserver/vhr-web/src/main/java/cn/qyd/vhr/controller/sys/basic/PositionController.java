package cn.qyd.vhr.controller.sys.basic;

import cn.qyd.vhr.bean.Position;
import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiuyunduo
 * @date 2020/4/4 14:11
 * @descript the descript
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public RespBean getAllPositions() {
        return RespBean.ok(positionService.selectPosList());
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        int result = positionService.insertPos(position);
        if(result == 1) {
            return RespBean.ok("职位添加成功");
        }
        return RespBean.error("职位添加失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        int result = positionService.updatePos(position);
        if(result == 1) {
            return RespBean.ok("职位更新成功");
        }
        return RespBean.error("职位更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        int result = positionService.deletePos(id);
        if(result == 1) {
            return RespBean.ok("职位删除成功");
        }
        return RespBean.error("职位删除失败");
    }

    @DeleteMapping("/batch")
    public RespBean deletePositions( Integer[] ids) {
        int result = positionService.batchDelete(ids);
        if(result == ids.length) {
            return RespBean.ok("职位批量删除成功");
        }
        return RespBean.error("职位批量删除失败");
    }

}
