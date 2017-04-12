package com.tongkn.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tongkn on 2017/4/11.
 */
public class LogInterceptor implements HandlerInterceptor {
    Logger LOG = LogManager.getLogger(LogInterceptor.class);

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 用于记录性能log
        request.setAttribute("start_time", System.currentTimeMillis());

        return true;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        long end = System.currentTimeMillis();
        // 记log，用于vaquero对服务的监控
        doVaqueroLog("search.time=" +
                (end - (Long) request.getAttribute("start_time")));
        // 输出请求url
        String requestUrl = request.getRequestURL().toString();
        String params = request.getQueryString();
        if (params!=null&&!params.equals("")) {
            requestUrl += "?" + params;
        }
        LOG.info(requestUrl);
    }


    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    /**
     * analyzer日志格式
     * @param log
     */
    protected void doVaqueroLog(String log) {
        LOG.info("@@ANALYSIS@@ " + log);
    }
}
