package com.viveros.marketplace.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String firstName;

    private String lastName;

    @NotNull
    @Email
    @NotEmpty
    private String email;

    @Pattern(regexp = "[0-9+]+")
    private String phone;
}
