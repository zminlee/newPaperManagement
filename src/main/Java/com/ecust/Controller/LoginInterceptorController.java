package com.ecust.Controller;

import com.ecust.Entity.User.UserRole;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by DoveXL on 2017/10/28.
 */
public class LoginInterceptorController extends HandlerInterceptorAdapter {



    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }


    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){  //加入当前时间
            modelAndView.addObject("var", "测试postHandle");
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI(); //请求完整路径，可用于登陆后跳转
        String contextPath = request.getContextPath();  //项目下完整路径
        String url = requestUri.substring(contextPath.length()); //请求页面
        System.out.print("发生拦截...");
        System.out.println("来自：" + requestUri + "的请求");
        UserRole userRole= (UserRole) request.getSession().getAttribute("LoginUser");
        System.out.println(userRole);
            if (userRole == null) {  //判断用户是否存在，不存在返回登录界面，继续拦截，存在通过拦截，放行到访问页面
                if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                    System.out.print("发生ajax请求...");
                    PrintWriter out = response.getWriter();
                    out.print("loseSession");//session失效
                    out.flush();
                    return false;
                } else {
                    System.out.print("返回主页...");
                    response.sendRedirect(request.getContextPath() + "/login/index.do");
                }
                return false;
            }
            else
                return true;
    }
}
