package cn.qyd.vhr.mapper;

import cn.qyd.vhr.bean.MailSendLog;

public interface MailSendLogMapper {
    int insert(MailSendLog record);

    int insertSelective(MailSendLog record);
}