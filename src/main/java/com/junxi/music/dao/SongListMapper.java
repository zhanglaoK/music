package com.junxi.music.dao;

import com.junxi.music.domain.Song;
import com.junxi.music.domain.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongListMapper {

    public int insert(SongList songList);

    public int update(SongList songList);

    public int delete(Integer id);

    public SongList selectByPrimary(Integer id);

    public List<SongList> allSongList();

    public List<SongList> songListOfTitle(String title);

    public List<SongList> listTitle(String title);

    public List<SongList> listStyle(String style);

}
