package com.bos.code.challenge.config;

import com.bos.code.challenge.manager.OrderBookManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Atul on 6/7/19.
 */
@Configuration
public class AppConfig {

    public static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public OrderBookManager orderBookManager(){
        return new OrderBookManager();
    }
}
