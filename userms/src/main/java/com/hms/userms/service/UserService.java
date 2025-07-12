package com.hms.userms.service;

import com.hms.userms.dto.UserDTO;
import com.hms.userms.exception.HMSException;

public interface UserService {
    public void registerUser(UserDTO userDTO) throws HMSException;
    public UserDTO loginUser(UserDTO userDTO) throws HMSException;
    public UserDTO getUserById(Long id) throws HMSException;
    public UserDTO getUser(String email) throws HMSException;
}
