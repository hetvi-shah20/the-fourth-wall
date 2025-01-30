package com.thefourthwall.admin.the_fourth_wall.service;



import com.thefourthwall.admin.the_fourth_wall.dto.UserRequest;
import com.thefourthwall.admin.the_fourth_wall.entity.User;

import java.util.List;

public interface SupabaseService {
    List<User> getUsers();

    User createUser(UserRequest userRequest);
}
