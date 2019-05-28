package com.briup.apps.tb_app01.bean.extend;

import com.briup.apps.tb_app01.bean.Course;
import com.briup.apps.tb_app01.bean.User;

/**
 * @program: tb_app01
 * @description: 课程拓展类
 * @author: charles
 * @create: 2019-04-30 16:34
 **/

public class CourseExtend extends Course {
    private User teacher;

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
