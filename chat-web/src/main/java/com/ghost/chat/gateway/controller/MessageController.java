package com.ghost.chat.gateway.controller;

import com.ghost.chat.gateway.MessageFeign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  消息控制器
 * </p>
 * @author luffy
 * @since 2020-03-26 19:10:45
 */
@RequestMapping("message")
@RestController
public class MessageController {

    private final MessageFeign messageFeign;

    public MessageController(MessageFeign messageFeign) {
        this.messageFeign = messageFeign;
    }

    @PostMapping("send")
    public String sendMessage(@RequestParam String text){
        return messageFeign.sendMessage(text);
    }

}
