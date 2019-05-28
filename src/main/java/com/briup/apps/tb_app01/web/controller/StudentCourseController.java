package com.briup.apps.tb_app01.web.controller;

import com.briup.apps.tb_app01.bean.StudentCourse;
import com.briup.apps.tb_app01.bean.extend.StudentCourseExtend;
import com.briup.apps.tb_app01.service.IStudentCourse;
import com.briup.apps.tb_app01.utils.Message;
import com.briup.apps.tb_app01.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//学生选课控制器类

@RestController
@RequestMapping("/sc")
public class StudentCourseController {
    @Autowired
    private IStudentCourse iStudentCourse;

    @GetMapping("findAll")
    public Message findAll(){
        // 查询所有学生选课表

        List<StudentCourse> list = iStudentCourse.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findStudentCourseById")
    public Message findStudentCourseById(Long id){
        // 根据id查询学生选课表

        StudentCourse studentCourse = iStudentCourse.findStudentCourseById(id);
        return MessageUtil.success(studentCourse);
    }

    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(StudentCourse studentCourse){
        // 保存或更改信息
        iStudentCourse.saveOrUpdate(studentCourse);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteStudentCourseById")
    public Message deleteStudentCourseById(Long id){
        // 根据id删除学生选课表

        iStudentCourse.deleteStudentCourseById(id);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("findAllWithStudentCourse")
    public Message findAllWithStudentCourse(){
        //查询所有选课表及和其关联的学生，课程

        List<StudentCourseExtend> list = iStudentCourse.findAllWithStudentCourse();
        return MessageUtil.success(list);
    }



}
