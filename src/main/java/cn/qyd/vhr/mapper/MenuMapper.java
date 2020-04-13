package cn.qyd.vhr.mapper;

import cn.qyd.vhr.bean.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> getMenusByHrId(Integer hrid);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getAllRolesWithMenu();

    List<Menu> getTreeMenu();
}