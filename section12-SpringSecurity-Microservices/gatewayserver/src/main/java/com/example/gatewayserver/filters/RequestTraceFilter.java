package com.example.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    @Autowired
    FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        HttpHeaders requestHeader = exchange.getRequest().getHeaders();
        if(isCorrelationIdPresent(requestHeader))
        {
            logger.debug("eazyBank-correlation-id found in Request TraceFilter : {}",
                    filterUtility.getCorrelationId(requestHeader));
        }
        else {
            String correlatioID = generateCorrelationId();
            exchange = filterUtility.setCorrelationId(exchange,correlatioID);
            logger.debug("eazyBank-correlation-id generate in Request TraceFilter : {}",correlatioID);

        }
        return chain.filter(exchange);
    }
    private boolean isCorrelationIdPresent(HttpHeaders requestHeader)
    {
        if(filterUtility.getCorrelationId(requestHeader)!=null)
        {
            return true;
        }
        else {
            return false;
        }
    }
    private String generateCorrelationId()
    {
        return java.util.UUID.randomUUID()
                .toString();    }
}
