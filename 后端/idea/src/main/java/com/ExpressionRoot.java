package com;

import com.empty.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义权限校验
 */

@Component("ex")
public class ExpressionRoot {

    public boolean  hasAuthority(String authority){
        //获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser longinUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = longinUser.getPermissions();
        //判断用户权限集合中是否有authority
        return permissions.contains(authority);

    }
}
