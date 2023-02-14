package com.controller;

import com.empty.ResponseResult;
import com.empty.User;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
//    @PreAuthorize("@ex.hasAuthority('background')")
//    @PreAuthorize("hasAuthority('test')")//通过注解设置所需权限为test
    public ResponseResult login(@RequestBody User user){
        //登录
        return loginService.login(user);
    }

    @RequestMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
