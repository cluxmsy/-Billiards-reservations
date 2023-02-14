package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.empty.ResponseResult;
import com.empty.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

     @Autowired
    private  UserMapper userMapper;

    @Override
    public ResponseResult register(User user) {
        User user1 = userMapper.selectById(user.getId());
        if(user1!=null){
            throw new RuntimeException("用户名已存在！");
        }
        int insert = userMapper.insert(user);
        return ResponseResult.ok("注册成功");
    }

    @Override
    public ResponseResult add(User user) {
        User user1 = userMapper.selectById(user.getId());
        if(user1!=null){
            throw new RuntimeException("用户名已存在！");
        }
        int insert = userMapper.insert(user);
        return ResponseResult.ok("添加成功");
    }

    @Override
    public ResponseResult delete(User user) {
        return null;
    }


}
