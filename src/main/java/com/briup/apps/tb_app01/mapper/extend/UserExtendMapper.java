package com.briup.apps.tb_app01.mapper.extend;

import com.briup.apps.tb_app01.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tb_app01
 * @description: 用户拓展mapper
 * @author: charles
 * @create: 2019-05-24 11:12
 **/

public interface UserExtendMapper {
    List<User> pageQuery(
            @Param("page") int page,
            @Param("pageSize") int pageSize);
    long count();
}
