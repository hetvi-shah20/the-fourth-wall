package com.thefourthwall.admin.the_fourth_wall.service.impl;


import com.thefourthwall.admin.the_fourth_wall.entities.Users;
import com.thefourthwall.admin.the_fourth_wall.service.SupabaseService;
import com.thefourthwall.admin.the_fourth_wall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final SupabaseService supabaseService;

    public UserServiceImpl(SupabaseService supabaseService) {
        this.supabaseService = supabaseService;
    }

    @Override
    public List<Users> getAllUsers() {
        return supabaseService.getUsers();
    }
}
