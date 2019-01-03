package com.xleone.server_oa.mapper;

import com.xleone.server_oa.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainMapper {

    @Select("select * from oa.news")
    public List<NewsEntity> getAllNews();
    @Select("select * from oa.announcement")
    public List<AnnoEntity> getAnno();

    @Select("select * from oa.notice")
    public List<NoticeEntity> getNotice();

    @Select("select * from oa.admin where user_id=#{user_id} and user_pass=#{user_pass}")
    public UserEntity login(@Param("user_id")String user_id, @Param("user_pass")String user_pass);

    @Select("select * from oa.schedule where 1=1 and date_format(sche_time,'%Y-%m-%d')=#{date} and user_id=#{user_id}")
    public List<ScheEntity> getNewSche(@Param("date") String date,@Param("user_id") String user_id);

    @Select("select * from oa.schedule where 1=1 and date_format(sche_time,'%Y-%m-%d')>#{date} and user_id=#{user_id}")
    public List<ScheEntity> getTomSche(@Param("date")String date,@Param("user_id") String user_id);

    @Select("select * from oa.schedule where 1=1 and date_format(sche_time,'%Y-%m-%d')<#{date} and user_id=#{user_id}")
    public List<ScheEntity> getOldSche(@Param("date")String date,@Param("user_id") String user_id);


}
