package com.xdy.dao;

import com.xdy.bean.Student;
import com.xdy.bean.Teacher;

import java.io.Serializable;

public interface TeacherDao {
    /**
     * 根据学生的编号 查询出对应的所有老师信息
     */
    Student selectTeachersBySid(Serializable id);
    /**
     * 根据老师的编号 查询出对应的所有学生信息
     */
    Teacher selectStudentsByTid(Serializable id);

}
