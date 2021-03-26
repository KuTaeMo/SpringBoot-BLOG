package com.cos.blog.web.post.dto;

import lombok.Data;

@Data
public class PostUpdateReqDto {
	private String title;
	private String content;
}

//toEntity 안만드는 이유는 더티체킹 할 것이기 때문!!
