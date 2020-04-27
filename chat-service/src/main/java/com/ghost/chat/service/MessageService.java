package com.ghost.chat.service;

/**
 * <p>
 *  消息业务接口
 * </p>
 * @author luffy
 * @since 2020-03-26 15:42:15
 */
public interface MessageService {

    /**
     * <p>
     *  发送消息
     * </p>
     * @author luffy
     * @since 2020-03-26 15:42:48
     * @param text 消息文本
     * @return string
     */
    String sendMessage(String text);
}
