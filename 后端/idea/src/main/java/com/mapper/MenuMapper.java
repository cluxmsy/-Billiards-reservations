package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.empty.Menu;

import java.util.List;


public interface MenuMapper extends BaseMapper<Menu> {

        List<String> selectPermsByUserId(Integer id);
}
