package com.UniProject.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SignInRequest {
    private String email;
    private String password;
}
