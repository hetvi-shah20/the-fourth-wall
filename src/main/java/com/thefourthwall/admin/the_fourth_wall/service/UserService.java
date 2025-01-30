package com.thefourthwall.admin.the_fourth_wall.service;


import com.thefourthwall.admin.the_fourth_wall.dto.BaseResponse;
import com.thefourthwall.admin.the_fourth_wall.dto.UserRequest;
import com.thefourthwall.admin.the_fourth_wall.dto.UserResponse;

import java.util.List;

public interface UserService {
    BaseResponse<List<UserResponse>> getAllUsers();

    BaseResponse<List<UserResponse>> createUser(UserRequest userRequest);
}
