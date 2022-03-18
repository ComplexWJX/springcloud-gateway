package com.asiainfo.aif.gateway.service;

import com.asiainfo.aif.gateway.rest.FeignRest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author Koala
 * @description
 * @date 2020/3/26 0026
 */
@Service
public class FallbackServiceImpl implements FallbackService {

    @Resource
    private FeignRest feignRest;

    @HystrixCommand(fallbackMethod = "resolveFallback",commandProperties = {
            //设置熔断
            @HystrixProperty(name = "fallback.enabled", value = "true"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "4000"),
            @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @Override
    public String fallback() {
        return feignRest.pay("11111111").toString();
    }

    public String resolveFallback(){
        return "sorry, the request is timeout";
    }
}
