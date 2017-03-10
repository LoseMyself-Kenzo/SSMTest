package cn.zpf.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LoseMyself on 2017/3/9.
 */
public class SecondFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init========2");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("start-------doFilter");
        HttpServletRequest req =(HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse)response;
        //重定向 跳转的新的界面 把响应转发给相应的界面
//        ((HttpServletResponse) response).sendRedirect(req.getContextPath()+"/main.jsp");
        //转发 页面内转发 浏览器不知道 转发请求将请求给另一个界面
        req.getRequestDispatcher("main.jsp").forward(request,response);
//        chain.doFilter(request,response);
        System.out.println("end-------doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("destory=========2");
    }
}
