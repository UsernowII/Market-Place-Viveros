package com.viveros.marketplace.models;

import lombok.Getter;
import lombok.Setter;

public class Auth {

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String password;
}
