package com.example.kioskproject.dto;

import com.example.kioskproject.domain.Category;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private int categorySortingNumber;

    public CategoryDto(Category category) {
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
        this.categorySortingNumber = category.getCategorySortingNumber();
    }
}
