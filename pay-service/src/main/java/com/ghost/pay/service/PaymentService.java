package com.ghost.pay.service;

/**
 * <p>
 *  消息业务接口
 * </p>
 * @author luffy
 * @since 2020-03-26 15:42:15
 */
public interface PaymentService {

    /**
     * <p>
     *  发送消息
     * </p>
     * @author luffy
     * @since 2020-03-26 15:42:48
     * @param info 支付内容
     * @return string
     */
    String pay(String info);
}
