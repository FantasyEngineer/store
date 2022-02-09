package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * 功能：让没有登录的页面跳回到登录页面
 *
 * @author jimmy
 */
public class LoginInterceptor implements HandlerInterceptor {

    public static final String uid = "uid";

    /**
     * 该方法是在请求处理之前被调用
     *
     * @param request
     * @param response
     * @param handler
     * @return true，继续执行，false，停止执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果session中没有uid，说明没有登录，没有登录则需要登录,当前请求需要结束
        if (request.getSession().getAttribute(uid) == null) {
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }


    /**
     * 该方法是在当前请求进行处理之后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


    /**
     * 当前整个请求结束之后，用于资源的清理工作。
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


}
