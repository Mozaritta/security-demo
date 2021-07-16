package com.security.demo.service;

import com.security.demo.entity.User;
import com.security.demo.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDetailsRepository.findByUserName(s);
        if (user == null){
            throw new UsernameNotFoundException("User not found with username " + s);
        } else {
            return user;
        }
    }
}
