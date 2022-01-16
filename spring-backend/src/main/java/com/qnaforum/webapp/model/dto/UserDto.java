package com.qnaforum.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String username;
    private String email;
    private String password;
    private String usernameOrEmail;

}
