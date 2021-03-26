package com.cos.blog.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.reply.Reply;
import com.cos.blog.service.PostService;
import com.cos.blog.service.ReplyService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.reply.dto.ReplySaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReplyController {

	private final ReplyService replyService;
	private final PostService postService;
	
	@DeleteMapping("/reply/{id}")
	public @ResponseBody CMRespDto<?> deleteById(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails){
		// 모든 컨트롤러에 삭제하기, 수정하기는 무조건 동일인물이 로그인했는지 확인!!
		int result=replyService.삭제하기(id,principalDetails.getUser().getId());
		return new CMRespDto<>(result,null,null);
	}
	
	@PostMapping("/reply")
	public String save(int postId, String content,@AuthenticationPrincipal PrincipalDetails principalDetails){
		System.out.println("댓글 컨트롤러 실행");
		Post post=postService.상세보기(postId);
		
		ReplySaveReqDto dto=ReplySaveReqDto.builder()
				.content(content)
				.post(post)
				.user(principalDetails.getUser())
				.build();


		Reply reply=replyService.댓글쓰기(dto.toEntity());	
		if(reply == null) {
			return "/post/"+postId;
		}else {
			return "redirect:/post/"+postId;
		}
	}
}
