package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.empty.ResponseResult;
import com.empty.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User>  {

    ResponseResult register(User user);

    ResponseResult add(User user);

    ResponseResult delete(User user);



}
