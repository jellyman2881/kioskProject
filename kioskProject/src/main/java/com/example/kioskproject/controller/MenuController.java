package com.example.kioskproject.controller;
import com.example.kioskproject.dto.MenuDtoRequest;
import com.example.kioskproject.dto.MenuDtoResponse;
import com.example.kioskproject.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menu")
    public void addMenu(@RequestParam(value = "file", required = false) MultipartFile uploadFile, MenuDtoRequest menuDto) {
        System.out.println(menuDto);
         menuService.addMenu(uploadFile, menuDto);
    }

    @DeleteMapping("/menu")
    public void deleteMenu(@PathVariable Long menuId) {
        menuService.deleteMenu(menuId);
    }

    @PutMapping("/menu/{menuId}")
    public Long editMenu(@RequestParam(value = "file", required = false) MultipartFile uploadFile, @PathVariable Long menuId, MenuDtoRequest menuDto) {
        return menuService.editMenu(uploadFile,menuId, menuDto);
    }

    @GetMapping("/menuList/{categoryId}")
    public List<MenuDtoResponse> loadMenuList(@PathVariable Long categoryId) {
        return menuService.loadMenuList(categoryId);
    }

    @ResponseBody
    @GetMapping("/menuImg/{filename}")
    public Resource showImage(@PathVariable("filename") String filename) throws MalformedURLException {
        String requestPath = System.getProperty("user.dir") + "\\src\\frontend\\src\\assets\\" + filename;
        return new UrlResource("file:" + requestPath);
    }
}
