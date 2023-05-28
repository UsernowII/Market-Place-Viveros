package com.viveros.marketplace.user.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @Email
    @NotEmpty
    @Getter @Setter @Column(name = "user_email")
    private String email;

    @NotEmpty
    @Getter @Setter @Column(name = "user_phone")
    private String phone;

    @Getter @Setter @Column(name = "user_password")
    private String password;

    @Getter @Setter
    private String repeatPassword;

}

