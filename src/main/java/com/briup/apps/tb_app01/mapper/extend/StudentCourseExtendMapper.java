package com.briup.apps.tb_app01.mapper.extend;

import com.briup.apps.tb_app01.bean.extend.StudentCourseExtend;

import java.util.List;

//选课表拓展接口
public interface StudentCourseExtendMapper {
    List<StudentCourseExtend> selectAll();
}
