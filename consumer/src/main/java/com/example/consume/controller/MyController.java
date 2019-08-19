package com.example.consume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/remote")
    public String getSay(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("pp");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getsay";

        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }
}
