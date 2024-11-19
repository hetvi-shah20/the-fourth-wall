package com.thefourthwall.admin.the_fourth_wall.service;



import com.thefourthwall.admin.the_fourth_wall.entities.Users;

import java.util.List;

public interface SupabaseService {
    List<Users> getUsers();
}
