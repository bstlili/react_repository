package com.briup.apps.tb_app01.service;

import com.briup.apps.tb_app01.bean.Course;
import com.briup.apps.tb_app01.bean.extend.CourseExtend;

import java.util.List;

public interface ICourseService {

    // 批量删除课程信息
    void batchDelete(Long[] ids);

    //查询所有课程级联教师
    List<CourseExtend> findAllWithTeacher();

    // 查询所有
    List<Course> findAll();

    //通过id查找
    Course findById(long id);

    // 保存或者更新
    //void saveOrUpdate(Course course);

    void saveCourse(Course course);

    void updateCourse(Course course);

    void deleteCourseById(Long id);

}
