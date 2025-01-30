package com.thefourthwall.admin.the_fourth_wall.dto;

public record UserRequest(String id,
                          String name,
                          String email,
                          String role) {
}
