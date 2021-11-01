package com.junxi.music.service;

import com.junxi.music.domain.Song;

import java.util.List;

public interface SongService {

    public boolean insert(Song song);

    public boolean update(Song song);

    public boolean delete(Integer id);

    public Song selectByPrimary(Integer id);

    public List<Song> allSinger();

    public List<Song> songOfName(String name);

    public List<Song> songOfSinger(Integer singerId);
}
