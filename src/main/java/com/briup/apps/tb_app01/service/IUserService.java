package com.briup.apps.tb_app01.service;

import com.briup.apps.tb_app01.bean.User;
import com.briup.apps.tb_app01.utils.PageVM;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {

    PageVM<User> pageQuery(int page, int pageSize);

    List<User> query(User user);

    List<User> findAll();


    // 通过类型查找用户
    List<User> findByType(String type);

    //保存或更新用户信息
    void saveOrUpdate(User user);
    
    //通过id查找
    User findById(long id);

    // 通过id删除
    void deleteById(long id);

    // 批量删除
    void batchDelete(long[] ids);

}
