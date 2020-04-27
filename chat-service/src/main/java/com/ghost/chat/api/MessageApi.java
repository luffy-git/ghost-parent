package com.ghost.chat.api;

import com.ghost.chat.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 /**
  * <p>
  *  消息 API 层
  * </p>
  * @author luffy
  * @since 2020-03-26 16:26:19
  */
@RestController
@RequestMapping("message")
public class MessageApi {

    private final MessageService messageService;

     public MessageApi(MessageService messageService) {
         this.messageService = messageService;
     }

     /**
      * <p>
      *  发送消息接口
      * </p>
      * @author luffy
      * @since 2020-03-26 16:31:02
      * @param text 消息体
      * @return java.lang.String
      */
     @PostMapping("send")
     public String send(@RequestParam String text){
         return messageService.sendMessage(text);
     }
 }
