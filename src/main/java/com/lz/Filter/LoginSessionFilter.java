package com.lz.Filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@Order(1)
//重点  order 数值越小，越小执行
@WebFilter(filterName = "sessionFilter1", urlPatterns = "/*")
public class LoginSessionFilter implements Filter {

    FilterConfig config;
    @Value("${filter.loginStrings}")
    String loginStrings;        // 登录登陆页面
    @Value("${filter.includeStrings}")
    String includeStrings;    // 过滤资源后缀参数
    @Value("${filter.redirectPath}")
    String redirectPath;// 没有登陆转向页面
    @Value("${filter.disabletestfilter}")
    String disabletestfilter;// 过滤器是否有效
    public void destroy() {
        this.config = null;
    }

    public static boolean isContains(String container, String[] regx) {
        boolean result = false;
        for (int i = 0; i < regx.length; i++) {
            if (container.indexOf(regx[i]) != -1) {
                return true;
            }
        }
        return result;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
        System.out.println(hrequest.getRequestURI());

        if (disabletestfilter.toUpperCase().equals("Y")) {    // 过滤无效
            chain.doFilter(request, response);
            return;
        }
        String[] logonList = loginStrings.split(";");
        String[] includeList = includeStrings.split(";");

        if (this.isContains(hrequest.getRequestURI(), includeList)) {// 只对指定过滤参数后缀进行过滤
            chain.doFilter(request, response);
            return;
        }

        if (this.isContains(hrequest.getRequestURI(), logonList)) {// 对登录页面不进行过滤
            chain.doFilter(request, response);
            return;
        }

        String login = (String) hrequest.getSession().getAttribute("userlogin");//判断用户是否登录

        if (StringUtils.isNotBlank(login)) {
            chain.doFilter(request, response);
            return;
        } else {
            wrapper.sendRedirect(redirectPath);
            return;
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

}
