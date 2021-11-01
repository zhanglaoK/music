package com.junxi.music.dao;

import com.junxi.music.domain.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper {

    public int insert(Song song);

    public int update(Song song);

    public int delete(Integer id);

    public Song selectByPrimary(Integer id);

    public List<Song> allSong();

    public List<Song> songOfName(String name);

    public List<Song> songOfSingerId(Integer SingerId);

}
