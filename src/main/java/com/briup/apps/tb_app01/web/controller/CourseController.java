package com.briup.apps.tb_app01.web.controller;

import com.briup.apps.tb_app01.bean.Course;
import com.briup.apps.tb_app01.bean.extend.CourseExtend;
import com.briup.apps.tb_app01.service.ICourseService;
import com.briup.apps.tb_app01.utils.Message;
import com.briup.apps.tb_app01.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//课程控制器类

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody Long[] ids){
        for(long id : ids){
            System.out.println(id);
        }
        //courseService.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("findAllWithTeacher")
    public Message findAllWithTeacher(){
        List<CourseExtend> list = courseService.findAllWithTeacher();
        return MessageUtil.success(list);
    }

    @GetMapping("findAll")
    public Message findAll(){
        List<Course> list = courseService.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        Course course = courseService.findById(id);
        return MessageUtil.success(course);
    }

    @PostMapping("saveCourse")
    public Message saveCourse(Course course){
        courseService.saveCourse(course);
        return MessageUtil.success("操作成功");
    }


    @GetMapping("updateCourse")
    public Message updateCourse(Course course){
        courseService.updateCourse(course);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteCourseById")
    public Message deleteCourseById(Long id){
        courseService.deleteCourseById(id);
        return MessageUtil.success("删除成功");
    }
}
