package com.kavy.rookiespringbootshiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer type;
    private Date createtime;


}
