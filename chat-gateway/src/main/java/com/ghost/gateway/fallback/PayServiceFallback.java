package com.ghost.gateway.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  支付系统 服务降级组件
 * </p>
 * @author luffy
 * @since 2020-03-27 17:59:25
 */
@Component
public class PayServiceFallback implements FallbackProvider {

    @Override
    public String getRoute() {
        return "pay-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        // 设置降级后给客户端响应的信息
        return new FallbackResponse(route,cause);
    }
}
