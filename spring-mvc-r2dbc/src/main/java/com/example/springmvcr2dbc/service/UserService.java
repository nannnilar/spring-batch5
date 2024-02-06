package com.example.springmvcr2dbc.service;

import com.example.springmvcr2dbc.dto.UserDto;
import com.example.springmvcr2dbc.entity.User;
import com.example.springmvcr2dbc.repository.UserRepository;
import com.example.springmvcr2dbc.util.EntityDtoUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private UserRepository userRepository;
    public Mono<UserDto> createUser(Mono<UserDto> userDtoMono){
        return userDtoMono.map(EntityDtoUtil::toEntity)
                .flatMap(userRepository::save)
                .map(EntityDtoUtil::toDto);
    }
    public Mono<UserDto> updateUser(int id, Mono<UserDto> userDtoMono){
       return this.userRepository.findById(id)
                .flatMap(u -> userDtoMono.map(EntityDtoUtil::toEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(this.userRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<Void>  delete(int id){
       return this.userRepository.deleteById(id);
    }

    public Flux<UserDto> all(){
       return this.userRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }
    public Mono<UserDto> getUserById( final int userId){
        return this.userRepository.findById(userId)
                .map(EntityDtoUtil::toDto);
    }
}
