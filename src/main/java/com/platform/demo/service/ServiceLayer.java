package com.platform.demo.service;

import com.platform.demo.Util;
import com.platform.demo.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceLayer {

    private final String url = "https://api.test-sfx-hub.co.za/api/utility/province";
    private final RestTemplate restTemplate;
    HttpHeaders headers = new HttpHeaders();



    @Autowired
    public ServiceLayer(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> consumeAPI(){
        headers.set(Util.HEADER_NAME, MediaType.APPLICATION_JSON_VALUE);

        headers.setBasicAuth(Util.USER_NAME, Util.USER_PASSWD);
        HttpEntity<String> entity = new HttpEntity<>(headers);


        Province[] resultsObj = restTemplate.exchange(url, HttpMethod.GET, entity, Province[].class).getBody();

        if(resultsObj == null){
            throw new NullPointerException("No results available");
        }

        return ResponseEntity.ok(resultsObj);
    }
}
