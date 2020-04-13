package cn.qyd.vhr.service;

import cn.qyd.vhr.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/4 23:14
 * @descript the descript
 */
@Service
public class MenuRoleService {
    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Integer> getMenusByRid(Integer rid) {
        return menuRoleMapper.getMenusByRid(rid);
    }

    @Transactional
    public Boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        int result = 0;
        if(mids == null || mids.length == 0) {
            return true;
        } else {
            result = menuRoleMapper.batchInsertMenuRoles(rid,mids);
            return result == mids.length;
        }
    }
}
