package cn.qyd.vhr.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author qiuyunduo
 * @date 2020/4/11 11:39
 * @descript the descript
 */
@Data
public class ChatMessage {
    private String from;
    private String fromNickName;
    private String to;
    private String message;
    private Date date;
}
