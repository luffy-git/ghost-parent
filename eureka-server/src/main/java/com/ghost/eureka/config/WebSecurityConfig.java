package com.ghost.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <p>
 *  由于 Springboot 2.x 默认开启了防csrf攻击，所有的请求都必须携带 crsf 这个参数,但是 eurake 注册连接并没有,所以此处对 eurake 注册进行放行
 * </p>
 * @author luffy
 * @since 2020-03-25 17:41:55
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * <p>
     *  放行 eurake 注册请求
     * </p>
     * @author luffy
     * @since 2020-03-25 17:42:03
     * @param http http
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
