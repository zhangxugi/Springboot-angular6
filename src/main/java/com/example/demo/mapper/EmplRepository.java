package com.example.demo.mapper;

import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2018/10/29 0029.
 */
public interface EmplRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select * from employee",nativeQuery = true)
    List<Employee> teacherinfor();

    Employee save(Employee employee);
}
