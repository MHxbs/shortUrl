package team.redrock.shorturl1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import team.redrock.shorturl1.mapper.UrlMapper;
import team.redrock.shorturl1.service.ShortUrlService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;


@WebFilter(filterName = "filter" ,urlPatterns = "/*")
public class PasswordFilter implements Filter {


    @Autowired
    private ShortUrlService shortUrlService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String uri=request.getRequestURI();
        String id="";
        if (uri.contains("?")) {
            id = uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('?'));
        }else {
            id=uri.substring(uri.lastIndexOf('/') + 1);
        }
        System.out.println(id);
        String pattern="[A-Za-z0-9]{6}";
        if (Pattern.matches(pattern,id)){
            if (request.getParameter("password")==null) {
                response.sendRedirect("/shorturl/password?id="+id);
                //request.getRequestDispatcher("/password?id=" + id).forward(servletRequest, servletResponse);
            }else {
                filterChain.doFilter(request,response);
            }
        }else {

            filterChain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
