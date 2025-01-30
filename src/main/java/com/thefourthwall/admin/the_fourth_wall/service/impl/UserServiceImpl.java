package com.thefourthwall.admin.the_fourth_wall.service.impl;


import com.thefourthwall.admin.the_fourth_wall.config.Constants;
import com.thefourthwall.admin.the_fourth_wall.dto.BaseResponse;
import com.thefourthwall.admin.the_fourth_wall.dto.UserRequest;
import com.thefourthwall.admin.the_fourth_wall.dto.UserResponse;
import com.thefourthwall.admin.the_fourth_wall.entity.User;
import com.thefourthwall.admin.the_fourth_wall.mapper.UserMapper;
import com.thefourthwall.admin.the_fourth_wall.service.SupabaseService;
import com.thefourthwall.admin.the_fourth_wall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final SupabaseService supabaseService;
    private final UserMapper userMapper;

    public UserServiceImpl(SupabaseService supabaseService, UserMapper userMapper) {
        this.supabaseService = supabaseService;
        this.userMapper = userMapper;
    }

    @Override
    public BaseResponse<List<UserResponse>> getAllUsers() {
        List<User> users = supabaseService.getUsers();
        List<UserResponse> userResponseList;
        if(!users.isEmpty()){
            userResponseList   = users.stream().map(userMapper::entityToResponse).collect(Collectors.toList());
            return new BaseResponse<>(Constants.SUCCESS, userResponseList);
        }
        return new BaseResponse<>(Constants.NO_USER_FOUND);
    }

    @Override
    public BaseResponse<List<UserResponse>> createUser(UserRequest userRequest) {
        User user = supabaseService.createUser(userRequest);
        return null;
    }
}
