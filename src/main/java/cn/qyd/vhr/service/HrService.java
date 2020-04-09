package cn.qyd.vhr.service;

import cn.qyd.vhr.bean.Hr;
import cn.qyd.vhr.bean.HrRole;
import cn.qyd.vhr.bean.Role;
import cn.qyd.vhr.mapper.HrMapper;
import cn.qyd.vhr.mapper.HrRoleMapper;
import cn.qyd.vhr.util.HrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/2 9:45
 * @descript the descript
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    @Autowired
    HrRoleMapper hrRoleMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        if(hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<Role> roles = hrMapper.getRolesByHrId(hr.getId());
        hr.setRoles(roles);
        return hr;
    }

    public List<Hr> getAllHrs(String keyword) {
        return hrMapper.getAllHrs(HrUtil.getCurrentHr().getId(),keyword);
    }

    @Transactional
    public Integer deleteHr(Integer id) {
        hrRoleMapper.deleteByHid(id);
        return hrMapper.deleteByPrimaryKey(id);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }
}
