package cn.zpf.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;

/**
 * Created by LoseMyself on 2017/3/9.
 */
public class FirstFilter implements javax.servlet.Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Start=====================");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Start....doFilter");
        HttpServletRequest req =(HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse)response;

        req.getRequestDispatcher("main.jsp").forward(request,response);
        System.out.println("End...doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy===================");
    }
}
