package com.example.demo.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.Post;


@Mapper
public interface DataMapper {
  String selectTest();
  
  void insertPost(@Param("title") String title, @Param("writer")String writer, @Param("content")String content);
  
  List<Post> selectAllPost();
  
  Post selectOnePost(@Param("id") String id);
  
  void deleteAllPost();
  
  // XX
  void saveImage(@Param("img") Map<String, Object> hmap)throws SQLException;
  
  int countBoard();
  
  List<Post> selectAllBoard(@Param("start")String start, @Param("end")String end);
  
  void updatePost(@Param("title") String title, @Param("writer")String writer, @Param("content")String content,@Param("id")String id);
  
  void deleteOnePost(@Param("id") String id);
  
}
