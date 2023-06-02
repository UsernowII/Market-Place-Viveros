package com.viveros.marketplace.user.entities;

import com.viveros.marketplace.base.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@ToString
public class User extends BaseEntity {

    @Getter @Setter @Column(name = "first_name")
    private String firstName;

    @Getter @Setter @Column(name = "last_name")
    private String lastName;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "phone")
    private String phone;

    @Getter @Setter @Column(name = "password")
    private String password;

    @Getter @Setter
    private String repeatPassword;

}

