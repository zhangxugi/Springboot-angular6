package com.example.demo.service;

import com.example.demo.mapper.EmplRepository;
import com.example.demo.mapper.UsersRepository;
import com.example.demo.pojo.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/10/30 0030.
 */
@Service
public class UserImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public Users login(String name,String password) {
        return usersRepository.findByNameAndPassword(name, password);

    }
}