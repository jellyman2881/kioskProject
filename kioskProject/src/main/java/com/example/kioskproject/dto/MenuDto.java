package com.example.kioskproject.dto;

import com.example.kioskproject.domain.Menu;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuDto {
    private String menuName;
    private int menuPrice;
    private int menuStock;
    private char menuState;
    private String origFilename;
    private String filename;
    private String filePath;
}
