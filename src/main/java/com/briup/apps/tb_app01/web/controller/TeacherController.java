package com.briup.apps.tb_app01.web.controller;

import com.briup.apps.tb_app01.bean.User;
import com.briup.apps.tb_app01.service.IUserService;
import com.briup.apps.tb_app01.utils.Message;
import com.briup.apps.tb_app01.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 教师控制器

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private IUserService userService;


    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
        if(user.getId() == null){
            user.setType("教师");
            user.setStatus("正常");
            user.setPassword("123456789");
        }
        userService.saveOrUpdate(user);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("findAll")
    public Message findAll(){
        String type="教师";
        List<User> list = userService.findAll();
        System.out.println(list);
        return MessageUtil.success(list);

    }

    @GetMapping("findType")
    public Message findType(String type){
        List<User> list = userService.findByType(type);
        System.out.println(list);
        return MessageUtil.success(list);

    }

    @GetMapping("deleteById")
    public Message deleteById(long id){
        userService.deleteById(id);
        return MessageUtil.success("删除成功！");
    }

    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody long[] ids){
        userService.batchDelete(ids);
        return MessageUtil.success("删除成功！");
    }

    @GetMapping("findById")
    public Message findById(long id){
        User user = userService.findById(id);
        return MessageUtil.success(user);
    }



}
