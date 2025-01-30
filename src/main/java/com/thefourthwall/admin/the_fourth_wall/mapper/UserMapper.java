package com.thefourthwall.admin.the_fourth_wall.mapper;

import com.thefourthwall.admin.the_fourth_wall.dto.UserResponse;
import com.thefourthwall.admin.the_fourth_wall.entity.User;

public interface UserMapper {

    UserResponse entityToResponse(User user);
}
