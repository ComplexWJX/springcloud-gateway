package com.jaxon.gateway.config;

import com.jaxon.gateway.filter.HostAddrKeyResolver;
import com.jaxon.gateway.filter.UriKeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author Koala
 * @description
 * @date 2019/12/31 0031
 */
@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, HttpConfigProperties httpConfigProperties) {

        /*
         * uri配置代表访问地址,支持http://xxx:xx/context以及远程调用lb://appName
         */
        return builder.routes()
                .route(p -> p
                        .path(httpConfigProperties.getRequestPath())
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpConfigProperties.getHttpUri()))
                /*.route(p ->p
                        .host("*")
                        .filters(f -> f.hystrix(config -> config
                        .setName("resolveFallback")
                        .setFallbackUri("forward:/fallback")))
                        .uri(httpConfigProperties.getHttpUri()))*/
                .build();
    }

    @Bean
    @Primary
    public HostAddrKeyResolver hostAddrKeyResolver(){
        return new HostAddrKeyResolver();
    }

    @Bean
    public UriKeyResolver uriKeyResolver(){
        return new UriKeyResolver();
    }
}
