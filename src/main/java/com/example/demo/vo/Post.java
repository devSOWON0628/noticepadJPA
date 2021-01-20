package com.example.demo.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Post {
	private String id;
	private String title;
	private String writer;
	private String content;
	private String reg_time;

}
