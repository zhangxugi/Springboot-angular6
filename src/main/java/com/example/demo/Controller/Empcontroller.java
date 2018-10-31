package com.example.demo.Controller;

import com.example.demo.mapper.EmplRepository;
import com.example.demo.mapper.UsersRepository;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Users;
import com.example.demo.service.UserImpl;
import com.example.demo.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Administrator on 2018/10/29 0029.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class Empcontroller {
    @Autowired
    private EmplRepository emplRepository;

    @Autowired
    private UserImpl usersService;

    @GetMapping("/empselect")
    public List<Employee> getUsers(){
        return emplRepository.findAll();

    }
    @GetMapping("/empselect/{id}")
    public Optional<Employee>  getUser(@PathVariable Long id){

        return emplRepository.findById(id);

    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Long id){
        emplRepository.deleteById(id);
        return true;

    }

    @PutMapping("/update")
    public Employee updateUser(@RequestBody Employee employee){

        return  emplRepository.save(employee);

    }
    @PostMapping("/add")
    public Employee createUser(@RequestBody Employee employee){

        return  emplRepository.save(employee);

    }

    @PostMapping("/login")

    public String login(@RequestBody Users users) {
        System.out.println(users.getName());
    Users user=usersService.login(users.getName(),users.getPassword());
    if (user.getUid()==0){
       return "失败";
    }else{
        return "成功";
    }


}
}
