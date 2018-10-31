package com.example.demo.mapper;

import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/10/30 0030.
 */
public interface UsersRepository extends JpaRepository<Users, Long> {
    // 通过名字和密码进行查找
    Users findByNameAndPassword(String name,String password);
}
