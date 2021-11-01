package com.junxi.music.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    private Integer id;
    private String name;
    private String password;

}
