package com.example.kioskproject.service;

import com.example.kioskproject.domain.Users;
import com.example.kioskproject.dto.UsersDto;
import com.example.kioskproject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public Boolean loginCheck(UsersDto usersDto){
        Optional<Users> user = usersRepository.findByUserLoginId(usersDto.getUserLoginId());
        if(user.isEmpty()) return false;
        if(user.get().getUserPw().equals(usersDto.getUserPw()))return true;
        else return false;
    }


}
