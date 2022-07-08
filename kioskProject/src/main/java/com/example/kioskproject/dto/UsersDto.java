package com.example.kioskproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersDto {
    private Long userId;
    private String userLoginId;
    private String userPw;
}
