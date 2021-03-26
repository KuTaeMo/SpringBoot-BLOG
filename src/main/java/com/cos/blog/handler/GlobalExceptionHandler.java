package com.cos.blog.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.web.dto.CMRespDto;

@RestController // 데이터를 리턴할 수 있음
@ControllerAdvice // 모든 exception을 낚아챔.
public class GlobalExceptionHandler {

	// 그 중 IllegalArgumentException이 발생하면 해당 함수 실행됨.
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public CMRespDto<?> dataIntegrityViolation(Exception e){
		return new CMRespDto<>(-1,e.getMessage(),null);
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public CMRespDto<?> illegalArgument(Exception e){
		return new CMRespDto<>(-1,e.getMessage(),null);
	}
	
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public CMRespDto<?> emptyResultDataAccess(Exception e){
		return new CMRespDto<>(-1,e.getMessage(),null);
	}
	
	@ExceptionHandler(value = MyAuthenticationException.class)
	public CMRespDto<?> MyAuthentication(Exception e){
		return new CMRespDto<>(-1,"로그인 후 사용해주세요",null);
	}
}
