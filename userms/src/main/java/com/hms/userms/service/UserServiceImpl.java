package com.hms.userms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.userms.dto.UserDTO;
import com.hms.userms.entity.User;
import com.hms.userms.exception.HMSException;
import com.hms.userms.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApiService apiService;

    @Override
    public void registerUser(UserDTO userDTO) throws HMSException{
        Optional<User> opt =  userRepository.findByEmail(userDTO.getEmail());
        if(opt.isPresent()){
            throw new HMSException("USER_ALREADY_EXISTS");
        }

        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Long profileId = apiService.addProfile(userDTO).block();
        userDTO.setProfileId(profileId);
        userRepository.save(userDTO.toEntity());
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) throws HMSException{
       User user =   userRepository.findByEmail(userDTO.getEmail()).orElseThrow(() -> new HMSException("USER_NOT_FOUND"));
       if(!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())){
        throw new HMSException("INVALID_CREDENTIALS");
       }

       user.setPassword(null); // remove password from response
       return user.toDTO();
    }

    @Override
    public UserDTO getUserById(Long id) throws HMSException{
        return userRepository.findById(id).orElseThrow(() -> new HMSException("USER_NOT_FOUND")).toDTO();
    }

    @Override
    public UserDTO getUser(String email) throws HMSException{
        return userRepository.findByEmail(email).orElseThrow(() -> new HMSException("USER_NOT_FOUND")).toDTO();
    }
    
}
