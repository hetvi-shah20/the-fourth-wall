package com.thefourthwall.admin.the_fourth_wall.controller;


import com.thefourthwall.admin.the_fourth_wall.entities.Users;
import com.thefourthwall.admin.the_fourth_wall.service.SupabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final SupabaseService supabaseService;

    public UserController(SupabaseService supabaseService) {
        this.supabaseService = supabaseService;
    }

    @GetMapping("/")
    public List<Users> users(){
        return supabaseService.getUsers();
    }
}
