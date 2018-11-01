package com.example.demo.service;

import com.example.demo.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    //导出
    public List<Employee> teacherinfor();
    //导入
    void saveExcelList(List<Employee> typeLists);
}
