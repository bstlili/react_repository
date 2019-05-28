package com.briup.apps.tb_app01.bean.extend;

import com.briup.apps.tb_app01.bean.Course;
import com.briup.apps.tb_app01.bean.StudentCourse;
import com.briup.apps.tb_app01.bean.User;

//选课表拓展

public class StudentCourseExtend extends StudentCourse {
    private User student;
    private Course course;

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
