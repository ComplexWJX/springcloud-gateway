package com.jaxon.gateway.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "paas-payment")
public interface FeignRest {

    @RequestMapping("/pay/save")
    Object pay(@RequestParam("serOrderId") String serOrderId);

}
