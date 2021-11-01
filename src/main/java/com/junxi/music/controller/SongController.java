package com.junxi.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.junxi.music.domain.Song;
import com.junxi.music.service.SongService;
import com.junxi.music.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping("/add")
    public Object addSong(HttpServletRequest request,@RequestParam("file") MultipartFile mpFile){
        JSONObject jsonObject = new JSONObject();
        String singerId = request.getParameter("singerId").trim();
        String name = request.getParameter("name").trim();
        String introduction = request.getParameter("introduction").trim();
//        String pic = request.getParameter("pic").trim();
        String pic = "/img/songPic/hhh.jpg";
        String lynic = request.getParameter("lynic").trim();

        if(mpFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"文件上传失败");
        }
        String fileName = System.currentTimeMillis()+mpFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"song";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String dataPath = "/song/"+fileName;
        try {
            mpFile.transferTo(dest);
            Song song = Song.builder().singerId(Integer.valueOf(singerId))
                    .name(name)
                    .introduction(introduction)
                    .pic(pic)
                    .lynic(lynic)
                    .url(dataPath).build();
            boolean flag = songService.insert(song);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"添加成功");
                jsonObject.put("avator",dataPath);

            }else{
                jsonObject.put(Consts.CODE,0);
                jsonObject.put(Consts.MSG,"添加失败");
            }
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"保存失败"+e.getMessage());
            e.printStackTrace();
        }finally {
            return jsonObject;
        }
    }

    @GetMapping("/singer/detail")
    public Object songOfSingerId(HttpServletRequest request){
        String singerId = request.getParameter("singerId");
        return songService.songOfSinger(Integer.valueOf(singerId));
    }

    @PostMapping("/update")
    public Object updateSong(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String introduction = request.getParameter("introduction").trim();
        String lynic = request.getParameter("lynic").trim();
        Song song = Song.builder().id(Integer.valueOf(id))
                .name(name)
                .introduction(introduction)
                .lynic(lynic).build();
        boolean flag = songService.update(song);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
        }else{
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"修改失败");
        }
        return jsonObject;
    }

    @GetMapping("/delete")
    public Object deleteSinger(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        return songService.delete(Integer.valueOf(id));
    }

    @GetMapping("/selectByPrimary")
    public Object selectByPrimary(HttpServletRequest request){
        return null;
    }

    @GetMapping("/allSinger")
    public Object allSinger(HttpServletRequest request){
        return null;
    }

    @GetMapping("/singerOfName")
    public Object singerOfName(HttpServletRequest request){
        return null;
    }

    @GetMapping("/singerOfSex")
    public Object singerOfSex(HttpServletRequest request){
        return null;
    }

    @PostMapping("/updateSongPic")
    public Object updateSingerPic(@RequestParam("file") MultipartFile avatorFile,@RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"文件上传失败");
        }
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")
                +"img"+System.getProperty("file.separator")+"songPic";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String dataPath = "/img/songPic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Song singer = Song.builder().id(id).pic(dataPath).build();
            boolean flag = songService.update(singer);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"上传成功");
                jsonObject.put("pic",dataPath);
            }else{
                jsonObject.put(Consts.CODE,0);
                jsonObject.put(Consts.MSG,"上传失败");
            }
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
            e.printStackTrace();
        }finally {
            return jsonObject;
        }
    }

    @PostMapping("/updateSongUrl")
    public Object updateSongUrl(@RequestParam("file") MultipartFile avatorFile,@RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"文件上传失败");
        }
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"song";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String dataPath = "/song/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Song singer = Song.builder().id(id).url(dataPath).build();
            boolean flag = songService.update(singer);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"上传成功");
                jsonObject.put("avator",dataPath);
            }else{
                jsonObject.put(Consts.CODE,0);
                jsonObject.put(Consts.MSG,"上传失败");
            }
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
            e.printStackTrace();
        }finally {
            return jsonObject;
        }
    }

}
