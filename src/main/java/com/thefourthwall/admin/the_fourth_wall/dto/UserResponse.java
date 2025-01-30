package com.thefourthwall.admin.the_fourth_wall.dto;

public record UserResponse(
        String id,
         String created_at,
         String updated_at ,
         String name,
         String email,
         String role,
         String last_login
) {

}
