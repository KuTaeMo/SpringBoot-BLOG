package com.cos.blog.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("USERNAME있는지 DB 확인");
		User principal=userRepository.findByUsername(username);
		
		if(principal==null) {
			return null;
		}else {
			System.out.println("있음");
			return new PrincipalDetails(principal);
		}
	}

}
