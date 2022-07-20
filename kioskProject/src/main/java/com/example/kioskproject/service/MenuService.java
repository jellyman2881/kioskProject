package com.example.kioskproject.service;

import com.example.kioskproject.domain.Category;
import com.example.kioskproject.domain.Menu;
import com.example.kioskproject.dto.MenuDtoRequest;
import com.example.kioskproject.dto.MenuDtoResponse;
import com.example.kioskproject.dto.UploadFileDto;
import com.example.kioskproject.repository.CategoryRepository;
import com.example.kioskproject.repository.MenuRepository;
import com.example.kioskproject.util.FileStoreUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final FileStoreUtil fileStoreUtil;
    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    public void addMenu(MultipartFile uploadFile, MenuDtoRequest menuDto) throws IOException {

        UploadFileDto uploadFileDto = fileStoreUtil.storeFile(uploadFile);

        Optional<Category> category = categoryRepository.findById(menuDto.getCategoryDtoId());
        Category categoryEntity = category.orElse(null);
        if (categoryEntity == null) return;
        Menu menu = Menu.builder()
                .origFilename(uploadFileDto.upLoadFileName)
                .filename(uploadFileDto.storedFileName)
                .menuName(menuDto.getMenuName())
                .menuPrice(menuDto.getMenuPrice())
                .menuState(menuDto.getMenuState())
                .menuStock(menuDto.getMenuStock())
                .menuSortingNumber(menuDto.getMenuSortingNumber())
                .category(categoryEntity)
                .menuDouble(menuDto.getMenuDouble())
                .menuDoublePrice((menuDto.getMenuDoublePrice()))
                .build();
        menuRepository.save(menu);
    }

    public Long editMenu(MultipartFile uploadFile, Long menuId, MenuDtoRequest menuDto) throws IOException {


        Optional<Menu> menu = menuRepository.findById(menuId);
        Menu menuEntity = menu.orElse(null);
        if (menuEntity == null) return null;
        Optional<Category> category = categoryRepository.findById(menuDto.getCategoryDtoId());
        Category selectCategory = category.orElse(null);
        if (selectCategory == null) return null;

        menuEntity.setMenuPrice(menuDto.getMenuPrice());
        menuEntity.setMenuStock(menuDto.getMenuStock());
        menuEntity.setMenuName(menuDto.getMenuName());
        menuEntity.setMenuState(menuDto.getMenuState());
        menuEntity.setMenuSortingNumber((menuDto.getMenuSortingNumber()));
        menuEntity.setMenuDouble(menuDto.getMenuDouble());
        menuEntity.setMenuDoublePrice((menuDto.getMenuDoublePrice()));
        menuEntity.setCategory(selectCategory);


        if (uploadFile!=null) {
            String fullPath = fileStoreUtil.getFullPath(menuDto.getPastFileName());
            File file = new File(fullPath);
            file.delete();
            UploadFileDto uploadFileDto = fileStoreUtil.storeFile(uploadFile);
            menuEntity.setFilename(uploadFileDto.getStoredFileName());
            menuEntity.setOrigFilename(uploadFileDto.getUpLoadFileName());
        }

        return menuId;
    }

    public void deleteMenu(Long menuId) {
        Optional<Menu> menu = menuRepository.findById(menuId);
        if (menu.isEmpty()) return;
        menuRepository.deleteById(menuId);
    }

    public List<MenuDtoResponse> loadMenuList(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        Category categoryEntity = category.orElse(null);
        if (categoryEntity == null) return null;

        List<Menu> menuList = menuRepository.findByCategory_CategoryIdOrderByMenuSortingNumber(categoryEntity.getCategoryId());
        List<MenuDtoResponse> collect = menuList.stream().map(MenuDtoResponse::new).collect(Collectors.toList());

        return collect;
    }
}
