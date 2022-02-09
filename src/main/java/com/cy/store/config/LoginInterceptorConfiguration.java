package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jimmy
 */
@Configuration
public class LoginInterceptorConfiguration implements WebMvcConfigurer {

    private List<String> patterns = new ArrayList<>();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //白名单
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/login.html");
        patterns.add("/web/register.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");

        registry.addInterceptor(new LoginInterceptor())
                //全部的资源都需要拦截
                .addPathPatterns("/**")
                //一些资源需要排除，不需要拦截，比如登录界面，注册界面，图片css，首页等。
                .excludePathPatterns(patterns);
    }
}
