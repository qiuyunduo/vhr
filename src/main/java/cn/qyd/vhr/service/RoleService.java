package cn.qyd.vhr.service;

import cn.qyd.vhr.bean.Role;
import cn.qyd.vhr.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/4 21:40
 * @descript the descript
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        role.setName("ROLE_"+role.getName());
        return roleMapper.insert(role);
    }

    public Integer deleteRole(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

}
