package com.ghost.chat.gateway;

import com.ghost.chat.gateway.hystrix.MessageHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  消息控制器 fegin 接口 负载均衡
 * </p>
 * @author luffy
 * @since 2020-03-26 19:10:51
 */
@Service
@FeignClient(value = "chat-service",fallback = MessageHystrix.class)
public interface MessageFeign {

    /**
     * <p>
     *  发送消息
     * </p>
     * @author luffy
     * @since 2020-03-26 19:10:56
     * @param text text
     * @return java.lang.String
     */
    @PostMapping("/message/send")
    String sendMessage(@RequestParam String text);
}
