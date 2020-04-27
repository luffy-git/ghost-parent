package com.ghost.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ghost.pay.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 *  消息业务实现接口类
 * </p>
 * @author luffy
 * @since 2020-03-26 15:43:35
 */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    /** 当前 服务端口  */
    @Value("${server.port}")
    private int port;

    /** 服务注册 */
    private final Registration registration;
    /** 获取当前实例信息 */
    private final DiscoveryClient client;

    public PaymentServiceImpl(DiscoveryClient client, @Qualifier("eurekaRegistration") Registration registration) {
        this.client = client;
        this.registration = registration;
    }

    @Override
    public String pay(String text) {
        ServiceInstance instance = localServiceInstance();
        JSONObject json = new JSONObject();
        json.put("service_id",instance.getServiceId());
        json.put("instance_id",instance.getInstanceId());
        json.put("service_host",instance.getHost());
        json.put("service_port",instance.getPort());
        json.put("service_uri",instance.getUri());
        json.put("metadata",instance.getMetadata());
        json.put("params",text);
        log.info("调用支付接口:" + json.toJSONString());
        return json.toJSONString();
    }

    /**
     * <p>
     *  获取本地 服务实例信息
     * </p>
     * @author luffy
     * @since 2020-03-26 16:23:34
     * @return org.springframework.cloud.client.ServiceInstance
     */
    public ServiceInstance localServiceInstance() {
       return Optional.ofNullable(client.getInstances(registration.getServiceId()))
                .orElseThrow(() -> new NullPointerException("注册中心没有该类新服务"))
                .stream()
                .filter(s -> s.getPort() == port)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("不存在的实例 or 端口错误"));

    }
}
