package com.kavy.rookiespringbootshiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivUser {
    private User user;
    private List<String> roles;
    private List<String> permissions;


}
