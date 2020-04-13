package cn.qyd.vhr.controller.chat;

import cn.qyd.vhr.bean.ChatMessage;
import cn.qyd.vhr.bean.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author qiuyunduo
 * @date 2020/4/11 11:36
 * @descript the descript
 */
@Controller
public class WSChatController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void sendWsMessage(Authentication authentication, ChatMessage chatMessage) {
        Hr hr = (Hr) authentication.getPrincipal();
        chatMessage.setFrom(hr.getUsername());
        chatMessage.setFromNickName(hr.getName());
        simpMessagingTemplate.convertAndSendToUser(chatMessage.getTo(),"/queue/chat",chatMessage);
    }
}
