package com.empty;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private User user;

    private List<String> permissions;

    public LoginUser(User user, List<String> permissions){
        this.user=user;
        this.permissions=permissions;
    }


    @JSONField(serialize = false)//不对成员变量authorities进行序列化不存入redis
    //存储SpringSecurity所需要的权限信息集合
    private List<SimpleGrantedAuthority> authorities;

    //自定义了loginUser构造方法，包含了字符串形式的权限信息 所以需要重写权限获取方法
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authorities!=null){
            return authorities;
        }
        //把permissions中String类型的权限信息转换成SimpleGrantedAuthoruty对象
        // 并存入authorities中
        authorities = new ArrayList<>();
        for (String permission:permissions){
            SimpleGrantedAuthority authority=new SimpleGrantedAuthority(permission);
            authorities.add(authority);
        }

        //函数引用方法，作用同上
//        List<SimpleGrantedAuthority> authorities = permissions.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
