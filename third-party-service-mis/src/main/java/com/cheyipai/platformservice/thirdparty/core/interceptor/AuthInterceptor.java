package com.cheyipai.platformservice.thirdparty.core.interceptor;
import com.cheyipai.platformservice.thirdparty.entity.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthInterceptor extends HandlerInterceptorAdapter {
    @SuppressWarnings("unchecked")
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        HandlerMethod hm;
        if(handler instanceof HandlerMethod){
            hm = (HandlerMethod)handler;
        }else{
            return super.preHandle(request, response, handler);
        }
        String uri = request.getRequestURI();
        if(uri.startsWith("/login")||uri.startsWith("/captcha-image")){
            return super.preHandle(request, response, handler);
        }

        User user = (User)session.getAttribute("loginUser");
        if(user==null) {

            response.sendRedirect(request.getContextPath()+"/login/tologin");
            return false;
        } else {
            /*boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
            if(!isAdmin) {
                //不是超级管理人员，就需要判断是否有权限访问某些功能
                Set<String> actions = (Set<String>)session.getAttribute("allActions");
                String aname = hm.getMethod().getDeclaringClass().getName()+"."+hm.getMethod().getName();
                if(!actions.contains(aname)) throw new BusinessException(1,"没有权限访问该功能");
            }*/
        }
        return super.preHandle(request, response, handler);
    }
}
