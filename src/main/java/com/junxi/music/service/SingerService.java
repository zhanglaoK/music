package com.junxi.music.service;

import com.junxi.music.domain.Singer;

import java.util.List;

public interface SingerService {

    public boolean insert(Singer singer);

    public boolean update(Singer singer);

    public boolean delete(Integer id);

    public Singer selectByPrimary(Integer id);

    public List<Singer> allSinger();

    public List<Singer> singerOfName(String name);

    public List<Singer> singerOfSex(Integer sex);
}
