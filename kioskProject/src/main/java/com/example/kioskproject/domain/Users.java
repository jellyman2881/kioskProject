package com.example.kioskproject.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "USERS_GENERATOR",
        sequenceName = "USERS_SEQ",
        initialValue = 1, allocationSize = 1)
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_GENERATOR")
    private Long userId;
    private String userLoginId;
    private String userPw;
}
