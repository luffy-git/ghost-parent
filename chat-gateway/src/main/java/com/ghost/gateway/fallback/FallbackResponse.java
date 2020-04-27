package com.ghost.gateway.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 *  全局服务降级处理类
 * </p>
 * @author luffy
 * @since 2020-03-27 18:25:58
 */
public class FallbackResponse implements ClientHttpResponse {

    private String server;
    private HttpStatus status;

    public FallbackResponse(String server, Throwable cause) {
        this.server = server;
        //标记不同的异常为不同的http状态值
        if (cause instanceof HystrixTimeoutException) {
            this.status = HttpStatus.GATEWAY_TIMEOUT;
        } else {
            //可继续添加自定义异常类
            this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * 设置相关的header信息
     */
    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders header = new HttpHeaders();
        // 返回json数据
        MediaType mt = new MediaType("application", "json", StandardCharsets.UTF_8);
        header.setContentType(mt);
        return header;
    }

    /**
     * 设置响应的内容
     */
    @Override
    public InputStream getBody() {
        return new ByteArrayInputStream((this.server + "系统目前不可用,请于管理员联系!").getBytes());
    }

    /**
     * <p>
     * 返回状态码
     * </p>
     *
     * @author luffy
     * @since 2020-03-27 18:01:21
     */
    @Override
    public String getStatusText() {
        return this.getStatusCode().getReasonPhrase();
    }

    /**
     * <p>
     * 返回HTTP 状态码
     * </p>
     *
     * @author luffy
     * @since 2020-03-27 18:01:15
     */
    @Override
    public HttpStatus getStatusCode() {
        return status;
    }

    @Override
    public int getRawStatusCode() {
        return this.getStatusCode().value();
    }

    @Override
    public void close() {

    }
}
