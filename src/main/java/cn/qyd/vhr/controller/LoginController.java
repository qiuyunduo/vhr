package cn.qyd.vhr.controller;

import cn.qyd.vhr.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuyunduo
 * @date 2020/4/2 11:10
 * @descript the descript
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录");
    }
}
