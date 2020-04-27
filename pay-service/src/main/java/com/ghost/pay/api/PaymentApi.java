package com.ghost.pay.api;

import com.ghost.pay.service.PaymentService;
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
@RequestMapping("pay")
public class PaymentApi {

   private final PaymentService paymentService;

    public PaymentApi(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * <p>
     *  支付接口接口
     * </p>
     * @author luffy
     * @since 2020-03-26 16:31:02
     * @param info 消息体
     * @return java.lang.String
     */
    @PostMapping("call")
    public String callPay(@RequestParam String info){
        return paymentService.pay(info);
    }
}
