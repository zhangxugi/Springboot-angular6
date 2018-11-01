package com.example.demo.service;

import com.example.demo.mapper.EmplRepository;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeImpl implements EmployeeService{
    @Autowired private EmplRepository emplRepository;
    @Override
    public List<Employee> teacherinfor() {
        return emplRepository.teacherinfor();
    }

    @Override
    public void saveExcelList(List<Employee> typeLists) {
        for (Employee employee : typeLists) {
            //调用mapper的保存方法
            emplRepository.save(employee);
        }
    }
}
