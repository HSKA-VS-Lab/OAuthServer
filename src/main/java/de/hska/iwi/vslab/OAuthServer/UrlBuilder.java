package de.hska.iwi.vslab.OAuthServer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;


public class UrlBuilder {

    private String baseUrl_core_user;

    String getBaseUrl_core_user(){
        return baseUrl_core_user;
    }

    String getUserUrl(String username){return baseUrl_core_user+"/user/" + username;};

    public UrlBuilder(){
        LoadBalancerClient loadBalancer = BeanUtil.getBean(LoadBalancerClient.class);
        ServiceInstance si_core_user = loadBalancer.choose("core_user");
        this.baseUrl_core_user =  si_core_user.getUri().toString();
    }

}
