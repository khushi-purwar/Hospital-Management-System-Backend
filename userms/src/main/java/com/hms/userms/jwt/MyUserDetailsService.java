package com.hms.userms.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hms.userms.dto.UserDTO;
import com.hms.userms.exception.HMSException;
import com.hms.userms.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try{
            UserDTO dto = userService.getUser(email);
            return new CustomUserDetails(
                dto.getId(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getRole(),
                dto.getName(),
                dto.getEmail(),
                dto.getProfileId(),
                null
                
            );
        }catch(HMSException e){
            e.printStackTrace();
        }

        return null;
    }
    
}
