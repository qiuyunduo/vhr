package cn.qyd.vhr.controller.config;

import cn.qyd.vhr.bean.Menu;
import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/2 22:02
 * @descript the descript
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public RespBean getMenusByHrId() {
        List<Menu> menus = menuService.getMenusByHrId();
        return RespBean.ok(menus);
    }
}
