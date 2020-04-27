package com.ghost.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class PreLogFilter extends ZuulFilter {

    /**
     * <p>
     *  过滤器类型，有pre、routing、post、error四种
     * </p>
     * @author luffy
     * @since 2020-03-27 18:38:13
     * @return java.lang.String
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * <p>
     *  过滤器执行顺序，数值越小优先级越高
     * </p>
     * @author luffy
     * @since 2020-03-27 18:38:27
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * <p>
     *  是否进行过滤，返回true会执行过滤
     * </p>
     * @author luffy
     * @since 2020-03-27 18:38:47
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * <p>
     *  自定义的过滤器逻辑，当shouldFilter()返回true时会执行
     * </p>
     * @author luffy
     * @since 2020-03-27 18:39:05
     * @return java.lang.Object
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String remoteHost = request.getRemoteHost();
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        log.info("Remote host:{},method:{},uri:{}", remoteHost, method, requestURI);
        return null;
    }
}
