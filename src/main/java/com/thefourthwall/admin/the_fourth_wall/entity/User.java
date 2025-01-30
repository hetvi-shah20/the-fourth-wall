package com.thefourthwall.admin.the_fourth_wall.entity;

import lombok.Data;

@Data
public class User {

    public String id;
    public String created_at;
    public String updated_at ;
    public String name;
    public String email;
    public String role;
    public String last_login;

}
