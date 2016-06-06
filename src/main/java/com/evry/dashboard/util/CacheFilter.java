package com.evry.dashboard.util;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CacheFilter
 */
  @WebFilter(urlPatterns = {"*.xhtml"})
  public class CacheFilter implements Filter {

/**
 * Default constructor. 
 */
public CacheFilter() {
    // TODO Auto-generated constructor stub
}

/**
 * @see Filter#destroy()
 */
public void destroy() {
    // TODO Auto-generated method stub
}

/**
 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
 */

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    // apply no caching for all web pages except resources, you can customize that to be applied for specific pages
    if (!req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) { // Skip JSF resources (CSS/JS/Images/etc)
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        res.setDateHeader("Expires", 0); // Proxies.
    }

    chain.doFilter(request, response);
}
/**
 * @see Filter#init(FilterConfig)
 */
public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
}

}