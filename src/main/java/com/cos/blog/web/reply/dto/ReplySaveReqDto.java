package com.cos.blog.web.reply.dto;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.reply.Reply;
import com.cos.blog.domain.user.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReplySaveReqDto {
	private String content;
	private User user;
	private Post post;
	
	public Reply toEntity() {
		return Reply.builder()
				.content(content)
				.user(user)
				.post(post)
				.build();
	}
}
