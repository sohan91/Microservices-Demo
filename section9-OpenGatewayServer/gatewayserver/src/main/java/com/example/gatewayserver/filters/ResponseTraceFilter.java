package com.example.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.FilterReader;


@Configuration
public class ResponseTraceFilter{

    private static final Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);

    @Autowired
    FilterUtility filterUtility;

    @Bean
    public GlobalFilter postGlobalFilter()
    {
        return ((exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(()->
                    {
HttpHeaders requestHeader = exchange.getRequest().getHeaders();
String correlationId = filterUtility.getCorrelationId(requestHeader);
logger.debug("Updated the correlation id to outbound headers : {}",correlationId);
exchange.getResponse().getHeaders().add(filterUtility.CORRELATION_ID,correlationId);
                    }));
        });
    }
}
