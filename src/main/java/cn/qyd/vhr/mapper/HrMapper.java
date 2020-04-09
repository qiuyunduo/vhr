package cn.qyd.vhr.mapper;

import cn.qyd.vhr.bean.Hr;
import cn.qyd.vhr.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrMapper {
    Hr loadUserByUsername(String username);

    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    List<Role> getRolesByHrId(Integer hrid);

    List<Hr> getAllHrs(@Param("id") Integer id, @Param("keyword") String keyword);
}