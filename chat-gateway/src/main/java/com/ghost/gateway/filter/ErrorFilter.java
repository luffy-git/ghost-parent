package com.ghost.gateway.filter;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  自定义异常过滤器
 * </p>
 * @author luffy
 * @since 2020-03-27 18:37:00
 */
@Slf4j
public class ErrorFilter extends SendErrorFilter {

    @Override
    public Object run() {
        String msg = "请求失败!";
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            msg += "error:" + exception.getErrorCause();
            HttpServletResponse response = ctx.getResponse();
            response.setCharacterEncoding("UTF-8");
            response.getOutputStream().write(msg.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return msg;
    }
}
