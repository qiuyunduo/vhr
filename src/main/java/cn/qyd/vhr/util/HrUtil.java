package cn.qyd.vhr.util;

import cn.qyd.vhr.bean.Hr;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author qiuyunduo
 * @date 2020/4/5 23:24
 * @descript the descript
 */
public class HrUtil {
    public static Hr getCurrentHr() {
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
