package cn.qyd.vhr.service;

import cn.qyd.vhr.bean.Position;
import cn.qyd.vhr.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/4 13:57
 * @descript the descript
 */
@Service
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    public int insertPos(Position position) {
        position.setCreateDate(new Date());
        position.setEnabled(true);
        int result = positionMapper.insert(position);
        return result;
    }

    public int deletePos(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public int updatePos(Position pos) {
        return positionMapper.updateByPrimaryKeySelective(pos);
    }

    public List<Position> selectPosList() {
        List<Position> positions = positionMapper.selectAll();
        return positions;
    }

    public int batchDelete(Integer[] ids) {
        return positionMapper.batchDelete(ids);
    }
}
