package cn.qyd.vhr.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author qiuyunduo
 * @date 2020/4/4 12:55
 * @descript the descript
 */
@Component
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return method.getName() + Arrays.toString(objects);
    }
}
