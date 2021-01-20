package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.TableService;
import com.example.demo.vo.PagingVO;
import com.example.demo.vo.Post;

//홈화면 
@RestController
public class MainController {
		
	@Autowired TableService service;
	
	@GetMapping("")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("write");
		mv.addObject("post",service.selectAllPost());
		return mv;
	}
	
	// post 저장 ajax
	@PostMapping("/insert/post")
	public void insertPost(Post post) {
		service.insertPost(post.getTitle(), post.getWriter(), post.getContent());
		//service.insertPostImage(post);
	}
	
	@DeleteMapping("/delete/post")
	public void deleteAllPost() {
		service.deleteAllPost();
	}
	
	@GetMapping("/home")
	public ModelAndView boardList(PagingVO vo, @RequestParam(defaultValue="1", required=false)String nowPage) {		
		ModelAndView mv = new ModelAndView("main");
		vo = new PagingVO(service.countBoard(), Integer.parseInt(nowPage), 10); // 전체 개수, 현재 페이지, 한페이지당 보여줄 아이템수로 페이징정보 객체 생성 
		mv.addObject("paging", vo); 						   		// 페이징 정보
		mv.addObject("all", service.selectAllBoard(vo));			// 내용
		return mv;
	}
	
	@GetMapping("/read")
	public ModelAndView postDetail(@RequestParam("num")String num) {
		ModelAndView mv = new ModelAndView("postDetail");
		mv.addObject("post",service.selectOnePost(num));
		return mv;
	}

	
	@PutMapping("/update/post")
	public void updatePost(Post post) {
		service.updatePost(post);
	}
	
	@DeleteMapping("/delete/post/one")
	public void deletePost(@RequestParam("num")String num) {
		service.deleteOnePost(num);
	}
	
}
