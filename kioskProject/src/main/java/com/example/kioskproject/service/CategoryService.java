package com.example.kioskproject.service;

import com.example.kioskproject.domain.Category;
import com.example.kioskproject.dto.CategoryDto;
import com.example.kioskproject.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void editCategory(Long categoryId, CategoryDto category) {
        Optional<Category> selectedCategory = categoryRepository.findById(categoryId);
        Category categoryEntity = selectedCategory.orElse(null);
        if (categoryEntity == null) return;
        categoryEntity.setCategoryName(category.getCategoryName());
        categoryEntity.setCategorySortingNumber(category.getCategorySortingNumber());
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public List<CategoryDto> loadCategoryList() {
        List<Category> cateGoryList = categoryRepository.findAllByOrderByCategorySortingNumber();
        List<CategoryDto> categoryDtoList = cateGoryList.stream().map(CategoryDto::new).collect(Collectors.toList());
        return categoryDtoList;
    }
}
