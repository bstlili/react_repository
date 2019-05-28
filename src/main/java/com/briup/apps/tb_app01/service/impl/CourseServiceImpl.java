package com.briup.apps.tb_app01.service.impl;

import com.briup.apps.tb_app01.bean.Course;
import com.briup.apps.tb_app01.bean.CourseExample;
import com.briup.apps.tb_app01.bean.extend.CourseExtend;
import com.briup.apps.tb_app01.mapper.CourseMapper;
import com.briup.apps.tb_app01.mapper.extend.CourseExtendMapper;
import com.briup.apps.tb_app01.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// 课程实现类

@Service
public class CourseServiceImpl implements ICourseService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private CourseExtendMapper courseExtendMapper;

    @Override
    public void batchDelete(Long[] ids) {
        for(Long id:ids){
            courseMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<CourseExtend> findAllWithTeacher() {
        return courseExtendMapper.selectAll();
    }

    @Override
    public List<Course> findAll() {
        CourseExample example = new CourseExample();
        return courseMapper.selectByExample(example);
    }

    @Override
    public Course findById(long id) {

        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteCourseById(Long id) {
        CourseExample example=new CourseExample();
        example.createCriteria().andIdEqualTo(id);
        courseMapper.deleteByExample(example);
    }


//    @Override
//    public void saveOrUpdate(Course course) {
//        if(course.getId()!=null){
//            Course db_course=findById(course.getId());
//            db_course.setName(course.getName());
//            db_course.setDescription(course.getDescription());
//            db_course.setCredit(course.getCredit());
//            db_course.setTeacherId(course.getTeacherId());
//            courseMapper.updateByPrimaryKey(db_course);
//        }
//        courseMapper.insert(course);
//    }

    @Override
    public void updateCourse(Course course) {
        if(course.getId()!=null){
            Course db_course=findById(course.getId());
            db_course.setName(course.getName());
            db_course.setDescription(course.getDescription());
            db_course.setCredit(course.getCredit());
            db_course.setTeacherId(course.getTeacherId());
            courseMapper.updateByPrimaryKey(db_course);
        }
    }

    @Override
    public void saveCourse(Course course) {
        courseMapper.insert(course);
    }
}
