package com.xleone.server_oa.mapper;


import com.xleone.server_oa.bean.NewsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {

    @Select("select * from oa.news")
    public List<NewsEntity> getAllNews();
    //public List<NewsEntity> getAllNews();
}
