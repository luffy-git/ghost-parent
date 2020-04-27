package com.ghost.gateway.config;

import com.ghost.gateway.filter.ErrorFilter;
import com.ghost.gateway.filter.PreLogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *  过滤器配置类
 * </p>
 * @author luffy
 * @since 2020-03-27 18:40:39
 */
@Configuration
public class FilterConfig {

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }

    @Bean
    public PreLogFilter preLogFilter(){
        return new PreLogFilter();
    }
}
