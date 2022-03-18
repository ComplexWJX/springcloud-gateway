package com.asiainfo.aif.gateway.access;

import com.asiainfo.aif.gateway.service.FallbackService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;

/**
 * @author Koala
 * @description
 * @date 2019/12/31 0031
 */
@RestController
public class GatewayController {

    @Value("${remote.home}")
    private URI home;

    @Resource
    private FallbackService fallbackService;

    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just(fallbackService.fallback());
    }


    @RequestMapping("/dispatch")
    public String dispatch(){
        return "dispatch";
    }

    /*@GetMapping("/proxy/path/**")
    public ResponseEntity<?> proxyPath(ProxyExchange<byte[]> proxy) throws Exception {
        String path = proxy.path("/proxy/path/");
        return proxy.uri(home.toString() + "/foos/" + path).get();
    }*/
}
