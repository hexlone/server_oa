package com.xleone.server_oa.controller;


import com.xleone.server_oa.bean.*;

import com.xleone.server_oa.mapper.MainMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    MainMapper mainMapper;

    @GetMapping("/news")
    public Map<String, List<NewsEntity>> getAllNews() {
        Map<String, List<NewsEntity>> map = new HashMap<>();
        map.put("news", mainMapper.getAllNews());
        return map;
    }

    @GetMapping("/announcement")
    public Map<String, List<AnnoEntity>> getAnno() {
        Map<String, List<AnnoEntity>> map = new HashMap<>();
        map.put("announcement", mainMapper.getAnno());
        return map;
    }
    @GetMapping("/notice")
    public Map<String, List<NoticeEntity>> getNotice() {
        Map<String, List<NoticeEntity>> map = new HashMap<>();
        map.put("notice", mainMapper.getNotice());
        return map;
    }

    @GetMapping("/schedule")
    public Map<String, List<ScheEntity>> getSche(@RequestParam String type,@RequestParam String user_id) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        Map<String, List<ScheEntity>> map = new HashMap<>();
        if(type.equals("new")){
            map.put("schedule", mainMapper.getNewSche(date,user_id));
        }else if(type.equals("tom")){
            map.put("schedule", mainMapper.getTomSche(date,user_id));
        }else if(type.equals("old")){
            map.put("schedule", mainMapper.getOldSche(date,user_id));
        }


        return map;
    }

    @GetMapping("/login")
    public ResultBean login(@RequestParam String user_id, @RequestParam String user_pass){

        ResultBean resultBean = new ResultBean();
        UserEntity userEntity=new UserEntity();
        userEntity = mainMapper.login(user_id,user_pass);
        if(userEntity!=null){
            resultBean.setResultCode(101);
            resultBean.setUserEntity(userEntity);
        }else {
            resultBean.setResultCode(102);
            resultBean.setUserEntity(null);
        }
        return resultBean;
    }
}
