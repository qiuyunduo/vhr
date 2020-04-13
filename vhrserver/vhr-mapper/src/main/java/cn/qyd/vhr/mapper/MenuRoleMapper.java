package cn.qyd.vhr.mapper;

import cn.qyd.vhr.bean.MenuRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    List<Integer> getMenusByRid(Integer rid);

    void deleteByRid(Integer rid);

    int batchInsertMenuRoles(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}