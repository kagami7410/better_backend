package com.better.backend_app.service;

import com.better.backend_app.models.MyUserDetails;
import com.better.backend_app.models.User;
import com.better.backend_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;




public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Bean
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not Found " + username));

        return user.map(MyUserDetails::new).get();
    }


}
