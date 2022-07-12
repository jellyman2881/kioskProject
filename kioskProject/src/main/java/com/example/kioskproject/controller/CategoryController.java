package com.example.kioskproject.controller;

import com.example.kioskproject.domain.Category;
import com.example.kioskproject.dto.CategoryDto;
import com.example.kioskproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/category")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/category/{categoryId}")
    public void editCategory(@PathVariable Long categoryId, @RequestBody CategoryDto categoryDto) {
        categoryService.editCategory(categoryId, categoryDto);
    }

    @GetMapping("/category")
    public List<CategoryDto> categoryList() {
        return categoryService.loadCategoryList();
    }
    @DeleteMapping("/category/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
}
