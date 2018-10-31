package com.example.demo.pojo;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/30 0030.
 */
@Data
@Entity
@Table(name = "users")
public class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long uid;

    @Column(name = "name")
    private String name;
    @Column(name = "Password")
    private String password;
}
