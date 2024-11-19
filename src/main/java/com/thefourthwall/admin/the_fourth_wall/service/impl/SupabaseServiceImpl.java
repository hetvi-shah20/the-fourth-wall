package com.thefourthwall.admin.the_fourth_wall.service.impl;


import com.thefourthwall.admin.the_fourth_wall.entities.Users;
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

@Service
public class SupabaseServiceImpl implements SupabaseService
{
    @Autowired
    private RestTemplate restTemplate;

    private final String supabaseUrl = "https://wfgicvviiforftouyyrp.supabase.co";
    private final String supabaseApiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6IndmZ2ljdnZpaWZvcmZ0b3V5eXJwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTAyODMwODksImV4cCI6MjAyNTg1OTA4OX0.xJBtDK7-vcSig2pGIPcOutqA94jq6EyNUR1ZplBlkvM";


    @Override
    public List<Users> getUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey",supabaseApiKey);
        headers.set("Authorization", "Bearer " + supabaseApiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Users>> response = restTemplate.exchange(
                supabaseUrl + "/rest/v1/users?select=*'",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }
}
