package com.example.demo.mapper;

import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/10/29 0029.
 */
public interface EmplRepository extends JpaRepository<Employee, Long> {

}
