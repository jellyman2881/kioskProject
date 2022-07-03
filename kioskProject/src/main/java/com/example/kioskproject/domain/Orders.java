package com.example.kioskproject.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
public class Orders {

    @Id
    private Long orderId;
    private  int orderPrice;
    private LocalDateTime orderTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Users users;
}
