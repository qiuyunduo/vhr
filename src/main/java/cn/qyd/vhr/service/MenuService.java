package cn.qyd.vhr.service;

import cn.qyd.vhr.bean.Hr;
import cn.qyd.vhr.bean.Menu;
import cn.qyd.vhr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/2 22:05
 * @descript the descript
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenusByHrId() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuMapper.getMenusByHrId(hr.getId());
    }

    @Cacheable(cacheNames = "vhr_c",keyGenerator = "myKeyGenerator")
    public List<Menu> getAllRolesWithMenu() {
        return menuMapper.getAllRolesWithMenu();
    }

    /**
     * 获取树形结构的资源路径集 Menus
     * @return
     */
    @Cacheable(cacheNames = "vhr_c",keyGenerator = "myKeyGenerator")
    public List<Menu> getTreeMenu() {
        return menuMapper.getTreeMenu();
    }
}
