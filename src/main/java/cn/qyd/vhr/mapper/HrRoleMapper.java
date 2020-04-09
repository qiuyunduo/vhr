package cn.qyd.vhr.mapper;

import cn.qyd.vhr.bean.HrRole;
import org.apache.ibatis.annotations.Param;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    void deleteByHid(Integer hid);

    Integer insertHrRoles(@Param("hid") Integer hid, @Param("rids") Integer[] rids);
}