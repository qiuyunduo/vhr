package cn.qyd.vhr.controller.sys.hr;

import cn.qyd.vhr.bean.Hr;
import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.bean.Role;
import cn.qyd.vhr.service.HrRoleService;
import cn.qyd.vhr.service.HrService;
import cn.qyd.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/4 14:12
 * @descript the descript
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;

    @Autowired
    RoleService roleService;

    @Autowired
    HrRoleService hrRoleService;

    @GetMapping("/")
    public RespBean getAllHrs(String keyword) {
        List<Hr> hrs =  hrService.getAllHrs(keyword);
        return RespBean.ok(hrs);
    }

    @GetMapping("/role")
    public RespBean getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return RespBean.ok(roles);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        Integer result = hrService.updateHr(hr);
        if(result == 1) {
            return RespBean.ok("更新成功");
        }

        return RespBean.error("更新失败");
    }

    @PutMapping("/role")
    public RespBean updateHrRoles(Integer hid,Integer[] rids) {
        Boolean result = hrRoleService.updateHrRoles(hid,rids);
        if(result) {
            return RespBean.ok("用户角色更新成功");
        }

        return RespBean.error("用户角色更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHr(@PathVariable Integer id) {
        Integer result = hrService.deleteHr(id);
        if(result == 1) {
            return RespBean.ok("删除用户成功");
        }
        return RespBean.error("删除用户失败");
    }
}
