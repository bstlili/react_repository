package com.briup.apps.tb_app01.mapper;

import com.briup.apps.tb_app01.bean.StudentCourse;
import com.briup.apps.tb_app01.bean.StudentCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentCourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    long countByExample(StudentCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int deleteByExample(StudentCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int insert(StudentCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int insertSelective(StudentCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    List<StudentCourse> selectByExample(StudentCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    StudentCourse selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int updateByExampleSelective(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int updateByExample(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int updateByPrimaryKeySelective(StudentCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_student_course
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int updateByPrimaryKey(StudentCourse record);
}