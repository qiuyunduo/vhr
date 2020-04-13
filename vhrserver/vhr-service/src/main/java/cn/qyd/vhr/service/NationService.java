package cn.qyd.vhr.service;

import cn.qyd.vhr.bean.Nation;
import cn.qyd.vhr.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/7 20:12
 * @descript the descript
 */
@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
