package com.hms.userms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.hms.userms.dto.Roles;
import com.hms.userms.dto.UserDTO;
import reactor.core.publisher.Mono;

@Service
public class ApiService {

    @Autowired
    private WebClient.Builder webClient;

    public Mono<Long> addProfile(UserDTO user){
        if(user.getRole().equals(Roles.DOCTOR)){
            return webClient.build().post().uri("http://localhost:9001/profile/doctor/add").bodyValue(user).retrieve().bodyToMono(Long.class);
        }else if(user.getRole().equals(Roles.PATIENT)){
            return webClient.build().post().uri("http://localhost:9001/profile/patient/add").bodyValue(user).retrieve().bodyToMono(Long.class);
        }

        return null;
    }

}
