package com.cos.blog.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.user.User;
import com.cos.blog.service.UserService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.user.dto.UserUpdateReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;
	
	// 403 뜸 : 인증 안 됨.
	@GetMapping("/user")
	public @ResponseBody String findAll(@AuthenticationPrincipal PrincipalDetails principalDetails) { // @Controller + @ResponseBody = @RestController
//		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//		PrincipalDetails principalDetails= (PrincipalDetails)authentication.getPrincipal();
//		System.out.println(principalDetails.getUser());
		System.out.println(principalDetails.getUsername());
		return "User";
	}
	
	@GetMapping("/user/{id}")
	public String updateForm(@PathVariable int id,Model model) {
		model.addAttribute("id",id);
		// security에 의해 aop처리되어 있으므로 인증안해도 됨
		return "user/updateForm";
	}
	
	@PutMapping("/user/{id}")
	public @ResponseBody CMRespDto<?> update(@PathVariable int id,@RequestBody UserUpdateReqDto userUdpateReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {		
		User userEntity=userService.회원수정(id, userUdpateReqDto);
		System.out.println("user:"+userEntity);
		// 세션변경
		// UsernamePasswordToken->Authentiacation 객체로 만들어서 SecurityContextHolder에 집어 넣으면 됨.
		principalDetails.setUser(userEntity);
		
//		Authentication authentication = 
//				new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword());
//		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new CMRespDto<>(1,null,null);
	}

}