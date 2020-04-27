package com.ghost.chat.gateway.hystrix;

import com.ghost.chat.gateway.MessageFeign;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     消息网关 服务降级处理类
 *  Feign容错降级处理类，它并不是Spring的Service类，
 *  Feign会扫描标有@FeignClient注解的接口，生成代理
 *  HelloServiceImpl仅仅是被指定的降级处理类
 * </p>
 * @author luffy
 * @since 2020-03-26 20:21:26
 */
@Component
public class MessageHystrix implements MessageFeign {

    @Override
    public String sendMessage(String text) {
        return "请求错误,执行服务降级...";
    }
}
