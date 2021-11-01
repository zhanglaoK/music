package com.junxi.music.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    public int verifyPassword(String username,String password);

}
