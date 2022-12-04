package com.game.home.data.member;

import lombok.Data;

@Data
public class Member {
    private long unique;
    private String id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String lastLogin;
    private String firstLogin;


}
