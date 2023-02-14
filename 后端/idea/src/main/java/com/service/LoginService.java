package com.service;

import com.empty.ResponseResult;
import com.empty.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();

}
