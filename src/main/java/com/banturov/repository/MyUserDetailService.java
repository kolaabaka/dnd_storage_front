package com.banturov.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.banturov.models.MyUser;
import com.banturov.models.MyUserDetails;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository rep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser> user = rep.findByName(username);
		return user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
	}

	public void save(MyUser user) {
		user.setPassword(encoder.encode(user.getPassword()));
		rep.save(user);

	}

}
