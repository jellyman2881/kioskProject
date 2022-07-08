package com.example.kioskproject.controller;


import com.example.kioskproject.dto.UsersDto;
import com.example.kioskproject.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/login")
    public Boolean checkLogin(@RequestBody UsersDto usersDto){
        return usersService.loginCheck(usersDto);
    }
}
