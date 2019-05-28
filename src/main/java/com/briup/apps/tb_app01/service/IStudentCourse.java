package com.briup.apps.tb_app01.service;

import com.briup.apps.tb_app01.bean.StudentCourse;
import com.briup.apps.tb_app01.bean.extend.StudentCourseExtend;

import java.util.List;

//选课接口

public interface IStudentCourse {
    //查询所有学生选课表
    List<StudentCourse> findAll();
    //查询所有选课表及和其关联的学生，课程
    List<StudentCourseExtend> findAllWithStudentCourse();
    //根据id查询学生选课表
    StudentCourse findStudentCourseById(Long id);
    //保存或更改信息
    void saveOrUpdate(StudentCourse studentCourse);
    //根据id删除学生选课表
    void deleteStudentCourseById(Long id);
}
