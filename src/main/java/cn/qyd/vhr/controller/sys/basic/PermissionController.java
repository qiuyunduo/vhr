package cn.qyd.vhr.controller.sys.basic;

import cn.qyd.vhr.bean.Menu;
import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.bean.Role;
import cn.qyd.vhr.service.MenuRoleService;
import cn.qyd.vhr.service.MenuService;
import cn.qyd.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/4 21:41
 * @descript the descript
 */
@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {
    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @Autowired
    MenuRoleService menuRoleService;

    @GetMapping("/")
    public RespBean getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return RespBean.ok(roles);
    }

    @GetMapping("/menus")
    public RespBean getTreeMenu() {
        List<Menu> menus = menuService.getTreeMenu();
        return RespBean.ok(menus);
    }

    @GetMapping("/{rid}")
    public RespBean getMenusByRid(@PathVariable Integer rid) {
        List<Integer> ids = menuRoleService.getMenusByRid(rid);
        return RespBean.ok(ids);
    }

    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role) {
        Integer result = roleService.addRole(role);
        if(result == 1) {
            return RespBean.ok("角色添加成功");
        }

        return RespBean.error("角色添加失败");
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids) {
        Boolean result = menuRoleService.updateMenuRole(rid,mids);
        if(result) {
            return RespBean.ok("角色对应资源更新成功");
        }
        return RespBean.error("角色对应资源更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteRole(@PathVariable Integer id) {
        Integer result = roleService.deleteRole(id);
        if(result == 1) {
            return RespBean.ok("角色删除成功");
        }

        return RespBean.error("角色删除失败");
    }
}
