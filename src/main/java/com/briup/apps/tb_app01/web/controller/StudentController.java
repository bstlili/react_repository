package com.briup.apps.tb_app01.web.controller;

import com.briup.apps.tb_app01.bean.User;
import com.briup.apps.tb_app01.service.IUserService;
import com.briup.apps.tb_app01.utils.ExcelUtils;
import com.briup.apps.tb_app01.utils.Message;
import com.briup.apps.tb_app01.utils.MessageUtil;
import com.briup.apps.tb_app01.utils.PageVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 学生控制器

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IUserService userService;

    @GetMapping("download")
    public void download(HttpServletResponse response) throws Exception{
        List<User> list = userService.findByType("学生");
        //2. 将excel导出
        //2.1 excel头部数据
        String[] headList = new String[]{"ID","姓名","用户名","性别","头像","状态"};
        //2.2 属性
        String[] fieldList = new String[]{"id","realname","username","gender","photo","status"};
        //2.3 数据列，需要转化
        List<Map<String,Object>> dataList = new ArrayList<>();
        for(User buvm :list){
            Map<String,Object> map = new HashMap<>();
            map.put("id",buvm.getId());
            map.put("realname",buvm.getRealname());
            map.put("username",buvm.getUsername());
            map.put("gender",buvm.getGender());
            map.put("photo",buvm.getPhoto());
            map.put("status",buvm.getStatus());
            dataList.add(map);
        }
        //2.4 导出文件名
        String excelName = "student";
        //3. 调用工具方法导出Excel
        ExcelUtils.createExcel(response,excelName,headList,fieldList,dataList);

    }

    @GetMapping("pageQuery")
    public Message pageQuery(int page,int pageSize){
        PageVM<User> pageVM = userService.pageQuery(page,pageSize);
        return MessageUtil.success(pageVM);
    }

    @GetMapping("query")
    public Message query(
            String username,
            String realname,
            String gender,
            String type){
        User user = new User();
        user.setUsername(username);
        user.setRealname(realname);
        user.setGender(gender);
        user.setType(type);
        List<User> list = userService.query(user);
        return MessageUtil.success(list);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
        if(user.getId() == null){
            user.setType("学生");
            user.setStatus("正常");
            user.setPassword("123456789");
        }
        userService.saveOrUpdate(user);
        return MessageUtil.success("操作成功");
    }


    @GetMapping("findAll")
    public Message findAll(){
        String type="学生";
        List<User> list = userService.findAll();
        System.out.println(list);
        return MessageUtil.success(list);

    }

    @GetMapping("findType")
    public Message findType(String type){
        List<User> list = userService.findByType(type);
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
