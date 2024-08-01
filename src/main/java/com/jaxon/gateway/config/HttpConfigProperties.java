package com.jaxon.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Koala
 * @description
 * @date 2019/12/31 0031
 */
@ConfigurationProperties(prefix = "server")
@Component
public class HttpConfigProperties {
    //private String httpUri = "lb://paas-payment";
    private String httpUri = "http://localhost:8088";

//    private String requestPath = "/pay/save";
    private String requestPath = "/wh/workingHoursFill/queryWorkType";

    public String getHttpUri() {
        return httpUri;
    }

    public void setHttpUri(String httpUri) {
        this.httpUri = httpUri;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }
}
