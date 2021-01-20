package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.DataMapper;
import com.example.demo.vo.PagingVO;
import com.example.demo.vo.Post;

@Service
public class TableService {
	@Autowired
	DataMapper mapper;
	
	public void selectTest() {
		String result = mapper.selectTest();
		System.out.println(result);
	}
	
	public void insertPost(String title, String writer, String content) {
		mapper.insertPost(title, writer, content);
	}
	
	public List<Post> selectAllPost() {
		List<Post> result = mapper.selectAllPost();
		return result;
	}
	
	public Post selectOnePost(String id) {
		Post result = mapper.selectOnePost(id);
		return result;
	}
	
	public void deleteAllPost() {
		mapper.deleteAllPost();
	}
	
	public int countBoard() {
		return mapper.countBoard();
	}
	
	public List<Post> selectAllBoard(PagingVO vo){
		List<Post> result = mapper.selectAllBoard(vo.getStart()+"", vo.getEnd()+"");
		return result;
	}
	
	public void updatePost(Post post) {
		mapper.updatePost(post.getTitle(), post.getWriter(), post.getContent(), post.getId());
	}
	
	public void deleteOnePost(String id) {
		mapper.deleteOnePost(id);
	}
	
}
