package com.xleone.server_oa.controller;


import com.xleone.server_oa.bean.NewsEntity;
import com.xleone.server_oa.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    NewsMapper newsMapper;

    @GetMapping("/news")
    public Map<String,List<NewsEntity>> getAllNews(){
        Map<String,List<NewsEntity>> map = new HashMap<>();
        map.put("news",newsMapper.getAllNews());
        return map;
    }
}
