package com.example.kioskproject.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "CATEGORY_SEQ_GENERATOR",
        sequenceName = "CATEGORY_SEQ",
        initialValue = 1, allocationSize = 1)
public class Category {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CATEGORY_SEQ_GENERATOR")
    private Long categoryId;
    private String categoryName;
    private int categorySortingNumber;


    @Builder
    public Category(Long categoryId, String categoryName, int categorySortingNumber) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categorySortingNumber = categorySortingNumber;
    }
}
