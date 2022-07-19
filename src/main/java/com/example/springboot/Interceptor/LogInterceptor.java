package com.example.springboot.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        logger.info("\n-------- LogInterception.preHandle --- ");
        logger.info("Request URL: " + request.getRequestURL());
        logger.info("Request UA: " + request.getHeader("User-Agent"));
        logger.info("Request headers: " + request.getHeaderNames());
        logger.info("Start Time: " + System.currentTimeMillis());

        request.setAttribute("startTime", startTime);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
                           Object handler, ModelAndView modelAndView) throws Exception {

        logger.info("\n-------- LogInterception.postHandle --- ");
        logger.info("Request URL: " + request.getRequestURL());

        // You can add attributes in the modelAndView
        // and use that in the view page
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
                                Object handler, Exception ex) throws Exception {
        logger.info("\n-------- LogInterception.afterCompletion --- ");

        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        logger.info("Request URL: " + request.getRequestURL());
        logger.info("End Time: " + endTime);

        logger.info("Time Taken: " + (endTime - startTime));
    }

}