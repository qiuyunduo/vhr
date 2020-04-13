package cn.qyd.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuyunduo
 * @date 2020/4/2 10:14
 * @descript the descript
 */@RestController
public class HelloController {
     @GetMapping("/hello")
     public String hello() {
         return "Hello";
     }

     @GetMapping("/employee/basic/hello")
     public String helloBasic() {
         return "Hello /employee/basic/**";
     }

    @GetMapping("/employee/advanced/hello")
    public String helloAdvanced() {
        return "Hello /employee/advanced/**";
    }


}
