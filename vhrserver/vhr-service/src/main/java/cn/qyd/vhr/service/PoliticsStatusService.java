package cn.qyd.vhr.service;

import cn.qyd.vhr.bean.PoliticsStatus;
import cn.qyd.vhr.mapper.PoliticsStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/7 20:16
 * @descript the descript
 */
@Service
public class PoliticsStatusService {
    @Autowired
    PoliticsStatusMapper politicsStatusMapper;

    public List<PoliticsStatus> getAllPoliticsStatus() {
        return politicsStatusMapper.getAllPoliticsStatus();
    }
}
