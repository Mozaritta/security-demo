package com.security.demo.repository;

import com.security.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UserDetailsRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}
