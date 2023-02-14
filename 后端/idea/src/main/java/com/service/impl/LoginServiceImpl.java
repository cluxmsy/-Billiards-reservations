package com.service.impl;

import com.empty.LoginUser;
import com.empty.ResponseResult;
import com.empty.User;
import com.service.LoginService;
import com.utils.JwtUtils;
import com.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
       //AuthenticationManager authenticate进行认证
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //如果认证没有通过，给出对应提示
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
        // 如果认证通过了，使用userid生成一个jwt jwt存入ResponseResult返回
        LoginUser loginUser=(LoginUser)authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = jwtUtils.generateToken(userid);
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        //把一个完整的用户信息存入redis userid作为key
        redisCache.setCacheObject("login"+userid,loginUser);
        return new ResponseResult(200,"登录成功",map);
    }

    @Override
    public ResponseResult logout() {
        //获得SecurityContextHolder中获取用户id
        Authentication authentication = (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userid=loginUser.getUser().getId();
        //删除redis的值
        redisCache.deleteObject("login:"+userid);

        return new ResponseResult(200,"注销成功");
    }
}
