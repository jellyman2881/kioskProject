package com.example.kioskproject.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
public class Users {

    @Id
    private Long userId;
    private String userLoginId;
    private String managerPw;
}
