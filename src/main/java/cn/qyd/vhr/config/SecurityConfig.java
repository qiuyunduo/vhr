package cn.qyd.vhr.config;

import cn.qyd.vhr.bean.Hr;
import cn.qyd.vhr.bean.RespBean;
import cn.qyd.vhr.service.HrService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author qiuyunduo
 * @date 2020/4/2 10:11
 * @descript the descript
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final HrService hrService;
    final CustomAccessManage customAccessManage;
    final CustomSecurityFilter customSecurityFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O fi) {
                        fi.setAccessDecisionManager(customAccessManage);
                        fi.setSecurityMetadataSource(customSecurityFilter);
                        return fi;
                    }
                })
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = resp.getWriter();
                        Hr hr = (Hr)auth.getPrincipal();
                        hr.setPassword(null);
                        RespBean respBean = RespBean.ok("登录成功", hr);
                        String s = new ObjectMapper().writeValueAsString(respBean);
                        writer.write(s);
                        writer.flush();
                        writer.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = resp.getWriter();
                        RespBean respBean = RespBean.error("登录失败");
                        if(e instanceof LockedException) {
                            respBean.setMsg("账户已被锁定，请联系管理员");
                        } else if(e instanceof DisabledException) {
                            respBean.setMsg("账户已被禁用，请联系管理员");
                        } else if(e instanceof CredentialsExpiredException) {
                            respBean.setMsg("密码过期");
                        } else if(e instanceof AccountExpiredException) {
                            respBean.setMsg("账户过期");
                        } else if(e instanceof BadCredentialsException) {
                            respBean.setMsg("用户名或密码错误，请重新登录");
                        }
                        String s = new ObjectMapper().writeValueAsString(respBean);
                        writer.write(s);
                        writer.flush();
                        writer.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = resp.getWriter();
                        writer.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功")));
                        writer.flush();
                        writer.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable()
                /*解决前端在未登录时请求后因未登录重定向到/login页面，因此直接请求http://localhost:8080/login
                    ,不经过前端配置的nodejs代理，导致产生跨域问题。
                    解决方法：在这里设置在未登录时接受请求后返回一个错误请求响应信息，而不是重定向。
                 */
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        resp.setStatus(401); //设置http响应码为401后到前端处理直接跳向登录页面
                        PrintWriter writer = resp.getWriter();
                        RespBean respBean = RespBean.error("错误的访问");
                        if(e instanceof InsufficientAuthenticationException) {
                            respBean.setMsg("访问失败，请联系管理员 ");
                        }
                        String s = new ObjectMapper().writeValueAsString(respBean);
                        writer.write(s);
                        writer.flush();
                        writer.close();
                    }
                });
    }
}
