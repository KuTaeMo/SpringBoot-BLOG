package com.cos.blog.domain.reply;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false,length=200)
	private String content;
	
	// 외래키의 주인이 매핑 -> 순방향 매핑
	// 유저
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	// 포스트
	@ManyToOne
	@JoinColumn(name="postId")
	private Post post;
	
	
	@CreationTimestamp
	private LocalDateTime createDate;
}
