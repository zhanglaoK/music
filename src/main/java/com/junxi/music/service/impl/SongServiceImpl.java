package com.junxi.music.service.impl;

import com.junxi.music.dao.SongMapper;
import com.junxi.music.domain.Song;
import com.junxi.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;

    @Override
    public boolean insert(Song song) {
        int insert = songMapper.insert(song);
        return insert >0;
    }

    @Override
    public boolean update(Song song) {
        return songMapper.update(song)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id)>0;
    }

    @Override
    public Song selectByPrimary(Integer id) {
        return songMapper.selectByPrimary(id);
    }

    @Override
    public List<Song> allSinger() {
        return songMapper.allSong();
    }

    @Override
    public List<Song> songOfName(String name) {
        return songMapper.songOfName(name);
    }

    @Override
    public List<Song> songOfSinger(Integer singerId) {
        return songMapper.songOfSingerId(singerId);
    }
}
