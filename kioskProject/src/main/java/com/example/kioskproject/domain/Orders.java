package com.example.kioskproject.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "ORDERS_SEQ_GENERATOR",
        sequenceName = "ORDERS_SEQ",
        initialValue = 1, allocationSize = 1)

public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_SEQ_GENERATOR")
    private Long orderId;
    private  int orderPrice;
    private LocalDateTime orderTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Users users;

}
