package com.asiainfo.aif.gateway.filter.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.http.HttpStatus;

/**
 * @author Koala
 * @description
 * @date 2020/1/3 0003
 */
public class RateLimiterGatewayFilterFactory extends AbstractGatewayFilterFactory<RateLimiterGatewayFilterFactory.Config> {

    public RateLimiterGatewayFilterFactory(Class<Config> configClass) {
        super(configClass);
    }

    @Override
    public GatewayFilter apply(Config config) {
        //TODO
        return null;
    }

    class Config{
        private KeyResolver keyResolver;

        private HttpStatus statusCode = HttpStatus.TOO_MANY_REQUESTS;


        public KeyResolver getKeyResolver() {
            return keyResolver;
        }

        public Config setKeyResolver(KeyResolver keyResolver) {
            this.keyResolver = keyResolver;
            return this;
        }

        public HttpStatus getStatusCode() {
            return statusCode;
        }

        public Config setStatusCode(HttpStatus statusCode) {
            this.statusCode = statusCode;
            return this;
        }
    }
}
