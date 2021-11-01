package com.junxi.music.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class SongList implements Serializable {

    private Integer id;
    private String title;
    private String pic;
    private String introduction;
    private String style;

}
