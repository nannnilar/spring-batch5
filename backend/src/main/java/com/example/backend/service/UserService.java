package com.example.backend.service;

import com.example.backend.data.UserDto;
import com.example.backend.dto.CredentialsDto;
import com.example.backend.dto.SignupDto;
import com.example.backend.entities.User;
import com.example.backend.exception.AppException;
import com.example.backend.mappers.UserMapper;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto){
       var user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));
       if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.loginPassword()),
               user.getPassword())){
           return userMapper.toUserDto(user);
       } throw new AppException("Invalid Password",HttpStatus.BAD_REQUEST);
    }


    public UserDto register(SignupDto signupDto) {
        Optional<User> oUser = userRepository.findByLogin(signupDto.login());
        if (oUser.isPresent()){
            throw new AppException("Login Already Exist.",HttpStatus.BAD_REQUEST);
        }
        User user= toEntity(signupDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signupDto.password())));
        System.out.println("======================="+user);
        User savedUser = userRepository.save(user);

//        return userMapper.toUserDto(savedUser);
        return toDto(savedUser);
    }
    public static User toEntity(SignupDto signupDto){
        User user = new User();
        user.setLogin(signupDto.login());
        user.setFirstName(signupDto.firstName());
        user.setLastName(signupDto.lastName());
        return user;
    }

    public static UserDto toDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getLogin()
        );
    }
}
