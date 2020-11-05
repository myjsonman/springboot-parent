package com.kavy.rookiespringbootmybatis3.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String addr;
    private Integer age;
   private List<Phone> phoneList = new ArrayList<>();
}
