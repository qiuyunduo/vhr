package cn.qyd.vhr.config;

import cn.qyd.vhr.bean.Menu;
import cn.qyd.vhr.bean.Role;
import cn.qyd.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/3 22:24
 * @descript the descript
 */
@Component
public class CustomSecurityFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation filter = (FilterInvocation)o;
        //通过getRequestUrl获取的则是例如：/hello
        String url = filter.getRequestUrl();
        //通过getRequest().getRequestUrl获取的完整请求路径，例如http://localhost:8080/hello
//        System.out.println(filter.getRequest().getRequestURL().toString());
        List<Menu> menus =  menuService.getAllRolesWithMenu();
        for (Menu menu : menus) {
            if(antPathMatcher.match(menu.getUrl(),url)) {
                List<Role> roles = menu.getRoles();
                String[] roleNames = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleNames[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleNames);

            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
