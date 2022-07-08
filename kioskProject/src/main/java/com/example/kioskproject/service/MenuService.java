package com.example.kioskproject.service;

import com.example.kioskproject.domain.Menu;
import com.example.kioskproject.dto.MenuDto;
import com.example.kioskproject.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public void addMenu(MultipartFile uploadFile, MenuDto menuDto) {

        try {
            String origFilename = uploadFile.getOriginalFilename();
            String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());
            String filename = now + "_" + origFilename;
            String savePath = System.getProperty("user.dir") + "\\src\\frontend\\src\\assets";
            if (!new File(savePath).exists()) {
                try {
                    new File(savePath).mkdir();
                }
                catch (Exception e) {
                    e.getStackTrace();
                }
            } String filePath = savePath + "\\" + filename;
            uploadFile.transferTo(new File(filePath));
            menuDto.setOrigFilename(origFilename);
            menuDto.setFilename(filename);
            menuDto.setFilePath("\\src\\frontend\\src\\assets\\"+ filename);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Menu menu = Menu.builder()
                .origFilename(menuDto.getOrigFilename())
                .filename(menuDto.getFilename())
                .filePath(menuDto.getFilePath())
                .menuName(menuDto.getMenuName())
                .menuPrice(menuDto.getMenuPrice())
                .menuState(menuDto.getMenuState())
                .build();
        menuRepository.save(menu);
    }

    public Long editMenu(MultipartFile uploadFile,Long menuId, MenuDto menuDto) {
        try {
            String origFilename = uploadFile.getOriginalFilename();
            String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());
            String filename = now + "_" + origFilename;
            String savePath = System.getProperty("user.dir") + "\\src\\frontend\\src\\assets";
            if (!new File(savePath).exists()) {
                try {
                    new File(savePath).mkdir();
                }
                catch (Exception e) {
                    e.getStackTrace();
                }
            } String filePath = savePath + "\\" + filename;
            uploadFile.transferTo(new File(filePath));
            menuDto.setOrigFilename(origFilename);
            menuDto.setFilename(filename);
            menuDto.setFilePath("\\src\\frontend\\src\\assets\\"+ filename);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Optional<Menu> menu = menuRepository.findById(menuId);
        Menu menuEntity = menu.orElse(null);
        if (menuEntity == null) return null;
        menuEntity.setMenuPrice(menuDto.getMenuPrice());
        menuEntity.setMenuStock(menuDto.getMenuStock());
        menuEntity.setMenuName(menuDto.getMenuName());
        menuEntity.setMenuState(menuDto.getMenuState());
        menuEntity.setFilename(menuDto.getFilename());
        menuEntity.setFilePath(menuDto.getFilePath());
        menuEntity.setOrigFilename(menuDto.getOrigFilename());
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
