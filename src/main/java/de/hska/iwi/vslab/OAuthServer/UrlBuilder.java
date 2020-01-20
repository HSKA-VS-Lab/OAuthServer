package de.hska.iwi.vslab.OAuthServer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;


public class UrlBuilder {

    private String baseUrl_core_user;

    String getBaseUrl_core_user(){
        return baseUrl_core_user;
    }

    String getUserUrl(){return baseUrl_core_user+"/user";};

    public UrlBuilder(){
        LoadBalancerClient loadBalancer = BeanUtil.getBean(LoadBalancerClient.class);
        ServiceInstance si_core_user = loadBalancer.choose("core_user");
        ServiceInstance si_comp_user_role = loadBalancer.choose("comp_user_role");
        this.baseUrl_core_user =  si_core_user.getUri().toString();
    }

    String getInputUrl(String input){
        return baseUrl_core_user+"/user/"+input;
    }

    String getSlashURL_core(){
        return baseUrl_core_user+"/";
    }


    String getUrlWithId_core(int id){
        return getUserUrl()+"/"+id;
    }

}
