package com.UniProject.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserPlayer {
    private long uid;
    private long pid;
    private int point;
}
