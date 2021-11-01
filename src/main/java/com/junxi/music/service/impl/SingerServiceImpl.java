package com.junxi.music.service.impl;

import com.junxi.music.dao.SingerMapper;
import com.junxi.music.domain.Singer;
import com.junxi.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerMapper adminMapper;

    @Override
    public boolean insert(Singer singer) {
        return adminMapper.insert(singer)>0;
    }

    @Override
    public boolean update(Singer singer) {
        return adminMapper.update(singer)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return adminMapper.delete(id)>0;
    }

    @Override
    public Singer selectByPrimary(Integer id) {
        return adminMapper.selectByPrimary(id);
    }

    @Override
    public List<Singer> allSinger() {
        return adminMapper.allSinger();
    }

    @Override
    public List<Singer> singerOfName(String name) {
        return adminMapper.singerOfName(name);
    }

    @Override
    public List<Singer> singerOfSex(Integer sex) {
        return adminMapper.singerOfSex(sex);
    }
}
