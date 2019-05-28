package com.briup.apps.tb_app01.service.impl;

import com.briup.apps.tb_app01.bean.StudentCourse;
import com.briup.apps.tb_app01.bean.StudentCourseExample;
import com.briup.apps.tb_app01.bean.extend.StudentCourseExtend;
import com.briup.apps.tb_app01.mapper.StudentCourseMapper;
import com.briup.apps.tb_app01.mapper.extend.StudentCourseExtendMapper;
import com.briup.apps.tb_app01.service.IStudentCourse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//选课service实现类

@Service
public class StudentCourseImpl implements IStudentCourse {
    @Resource
    private StudentCourseMapper studentCourseMapper;
    @Resource
    private StudentCourseExtendMapper studentCourseExtendMapper;

    @Override
    public List<StudentCourse> findAll() {
        //查询所有学生选课表
        return studentCourseMapper.selectByExample(new StudentCourseExample());
    }

    @Override
    public List<StudentCourseExtend> findAllWithStudentCourse() {
        // 查询所有选课表及和其关联的学生，课程
        return studentCourseExtendMapper.selectAll();
    }

    @Override
    public StudentCourse findStudentCourseById(Long id) {
        //根据id查询学生选课表
        return studentCourseMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(StudentCourse studentCourse) {
        // 保存或更改信息
        if(studentCourse.getId()!= null){
            studentCourseMapper.updateByPrimaryKey(studentCourse);
            System.out.println("更新");
        } else {
            studentCourseMapper.insert(studentCourse);
            System.out.println("保存");
        }

    }

    @Override
    public void deleteStudentCourseById(Long id) {
        // 根据id删除学生选课表
        studentCourseMapper.deleteByPrimaryKey(id);
    }
}
