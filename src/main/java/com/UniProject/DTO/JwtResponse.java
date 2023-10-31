package com.UniProject.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JwtResponse {
    private String token;
    private String refreshToken;
}
