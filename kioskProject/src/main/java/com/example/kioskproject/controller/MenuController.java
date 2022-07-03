package com.example.kioskproject.controller;

import com.example.kioskproject.domain.Menu;
import com.example.kioskproject.dto.MenuDto;
import com.example.kioskproject.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menu")
    public void addMenu(@RequestBody MenuDto menuDto){
        menuService.addMenu(menuDto);
    }
    @GetMapping("/menu")
    public Menu detailMenu(@PathVariable Long menuId){
       return menuService.detailMenu(menuId);
    }
    @DeleteMapping("/menu")
    public void deleteMenu(@PathVariable Long menuId){
        menuService.deleteMenu(menuId);
    }
    @PutMapping("/menu")
    public Long editMenu(@PathVariable Long menuId, @RequestBody MenuDto menuDto){
        return menuService.editMenu(menuId,menuDto);
    }
    @GetMapping("/menuList")
    public List<Menu> loadMenuList(){
        return menuService.loadMenuList();
    }

}
