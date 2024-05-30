package com.banturov.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.banturov.models.myUser;
import com.banturov.models.myUserDetails;

@Service
public class myUserDetailService implements UserDetailsService{

	@Autowired
	private userRepository rep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<myUser> user = rep.findByName(username); 
		return user.map(myUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
	}

}
