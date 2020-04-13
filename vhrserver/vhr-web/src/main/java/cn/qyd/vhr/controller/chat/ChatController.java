package cn.qyd.vhr.controller.chat;

import cn.qyd.vhr.bean.Hr;
import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/11 10:26
 * @descript the descript
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    HrService hrService;
    @GetMapping("/hrs")
    public RespBean getAllHrsNotSelf(String keyword) {
        List<Hr> allHrs = hrService.getAllHrs(keyword);
        return RespBean.ok(allHrs);
    }
}
