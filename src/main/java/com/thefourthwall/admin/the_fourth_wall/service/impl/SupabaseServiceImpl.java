package com.thefourthwall.admin.the_fourth_wall.service.impl;


import com.thefourthwall.admin.the_fourth_wall.config.Constants;
import com.thefourthwall.admin.the_fourth_wall.dto.UserRequest;
import com.thefourthwall.admin.the_fourth_wall.entity.User;
import com.thefourthwall.admin.the_fourth_wall.service.SupabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class SupabaseServiceImpl implements SupabaseService
{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> getUsers() {
        HttpHeaders headers = getAPiHeaders();

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<User>> response = restTemplate.exchange(
                Constants.SUPABASE_URL + Constants.SUPABASE_USER_BASE_URL + "?select=*",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    @Override
    public User createUser(UserRequest userRequest) {
        System.out.println("user request " + userRequest.toString());

        User user = new User();
        user.id = userRequest.id();
        user.email = userRequest.email();
        user.name = userRequest.name();
        user.role = userRequest.role();


        System.out.println("user" + user.toString());

        HttpHeaders headers = getAPiHeaders();
        HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);

        ResponseEntity<User> response = restTemplate.exchange(Constants.SUPABASE_URL + Constants.SUPABASE_USER_BASE_URL, HttpMethod.POST, requestEntity, User.class);
        System.out.println("RESPONSE " + response.toString());
        System.out.println("BODY " + response.getBody());
        return response.getBody();
    }

    private HttpHeaders getAPiHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", Constants.SUPABASE_API_KEY);
        headers.set("Authorization", "Bearer " + Constants.SUPABASE_API_KEY);
        return headers;
    }
}
