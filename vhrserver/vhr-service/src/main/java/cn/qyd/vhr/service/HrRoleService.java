package cn.qyd.vhr.service;

import cn.qyd.vhr.mapper.HrRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qiuyunduo
 * @date 2020/4/6 20:07
 * @descript the descript
 */
@Service
public class HrRoleService {
    @Autowired
    HrRoleMapper hrRoleMapper;

    @Transactional
    public Boolean updateHrRoles(Integer hid,Integer[] rids) {
        hrRoleMapper.deleteByHid(hid);
        if(rids == null || rids.length == 0) {
            return true;
        } else {
            return hrRoleMapper.insertHrRoles(hid, rids) == rids.length;
        }
    }


}
