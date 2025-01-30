package com.thefourthwall.admin.the_fourth_wall.mapper.impl;

import com.thefourthwall.admin.the_fourth_wall.dto.UserResponse;
import com.thefourthwall.admin.the_fourth_wall.entity.User;
import com.thefourthwall.admin.the_fourth_wall.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponse entityToResponse(User user) {
        return new UserResponse(user.id, user.created_at, user.updated_at,user.name,user.email,user.role, user.last_login);
    }
}
