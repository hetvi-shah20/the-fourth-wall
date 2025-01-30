package com.thefourthwall.admin.the_fourth_wall.controller;


import com.thefourthwall.admin.the_fourth_wall.dto.UserResponse;
import com.thefourthwall.admin.the_fourth_wall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


   /* @GetMapping("/")
    public BaseResponse<List<UserResponse>> users(){
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public BaseResponse<List<UserResponse>> createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }*/

    @GetMapping("/")
    public List<UserResponse> users(){
        System.out.println("Below are users of the fourth wall");
        return List.of(new UserResponse(UUID.randomUUID().toString(), String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()), "Hetvi", "hetvi@test.com", "ADMIN", ""));
    }
}
