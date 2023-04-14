package com.viveros.marketplace.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "user_id")
    private long id;

    @Getter @Setter @Column(name = "user_name")
    private String userName;

    @Getter @Setter @Column(name = "last_name")
    private String lastName;
    @Getter @Setter @Column(name = "user_email")
    private String email;

    @Getter @Setter @Column(name = "user_phone")
    private String phone;

    @Getter @Setter @Column(name = "user_password")
    private String password;

    @Getter @Setter
    private String repeatPassword;

}

