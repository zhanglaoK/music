package com.junxi.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.junxi.music.dao")
public class MusicApplication {

    /**
     * 1.热更新，热加载，ctrl-shift-a-->找到registry....,然后compiler.automake.allow.when.runtime.找到找个勾选
     * 2.执行快捷键ctrl+f9，进行热加载
     */

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class,args);
    }

}
