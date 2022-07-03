package com.example.kioskproject.service;

import com.example.kioskproject.domain.Menu;
import com.example.kioskproject.dto.MenuDto;
import com.example.kioskproject.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public void addMenu(MenuDto menuDto) {
        Menu menu = Menu.builder()
                .menuImg(menuDto.getMenuImg())
                .menuName(menuDto.getMenuName())
                .menuPrice(menuDto.getMenuPrice())
                .menuState(menuDto.getMenuState())
                .build();
        menuRepository.save(menu);
    }

    public Long editMenu(Long menuId, MenuDto menuDto) {
        Optional<Menu> menu = menuRepository.findById(menuId);
        Menu menuEntity = menu.orElse(null);
        if (menuEntity == null) return null;
        menuEntity.setMenuPrice(menuDto.getMenuPrice());
        menuEntity.setMenuStock(menuDto.getMenuStock());
        menuEntity.setMenuName(menuDto.getMenuName());
        menuEntity.setMenuState(menuDto.getMenuState());
        return menuId;
    }

    public Menu detailMenu(Long menuId){
        Optional<Menu> menu = menuRepository.findById(menuId);
        if(menu.isEmpty()) return null;
        return menu.get();
    }

    public void deleteMenu(Long menuId){
        Optional<Menu> menu = menuRepository.findById(menuId);
        if(menu.isEmpty()) return;
        menuRepository.deleteById(menuId);
    }

    public List<Menu> loadMenuList(){
        List<Menu> menuList = menuRepository.findAll();
        return menuList;
    }
}
