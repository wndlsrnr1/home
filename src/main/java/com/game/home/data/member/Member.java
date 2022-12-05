package com.game.home.data.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Member {
    private long unique;
    private String id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String lastLogin;
    private String firstLogin;

    public Member(String id, String name, String password, String email, String address, String lastLogin, String firstLogin) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.lastLogin = lastLogin;
        this.firstLogin = firstLogin;
    }
}
