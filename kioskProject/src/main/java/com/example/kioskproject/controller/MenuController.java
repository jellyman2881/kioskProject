package com.example.kioskproject.controller;

import com.example.kioskproject.domain.Menu;
import com.example.kioskproject.dto.MenuDto;
import com.example.kioskproject.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menu")
    public void addMenu(@RequestParam(value = "file", required = false) MultipartFile uploadFile, MenuDto menuDto) {
        menuService.addMenu(uploadFile, menuDto);
    }

    @GetMapping("/menu")
    public Menu detailMenu(@PathVariable Long menuId) {
        return menuService.detailMenu(menuId);
    }

    @DeleteMapping("/menu")
    public void deleteMenu(@PathVariable Long menuId) {
        menuService.deleteMenu(menuId);
    }

    @PutMapping("/menu/{menuId}")
    public Long editMenu(@RequestParam(value = "file", required = false) MultipartFile uploadFile, @PathVariable Long menuId, MenuDto menuDto) {
        return menuService.editMenu(uploadFile,menuId, menuDto);
    }

    @GetMapping("/menuList")
    public List<Menu> loadMenuList() {
        return menuService.loadMenuList();
    }

    @ResponseBody
    @GetMapping("/menuImg/{filename}")
    public Resource showImage(@PathVariable("filename") String filename) throws MalformedURLException {
        String requestPath = System.getProperty("user.dir") + "\\src\\frontend\\src\\assets\\" + filename;
        return new UrlResource("file:" + requestPath);
    }
}
