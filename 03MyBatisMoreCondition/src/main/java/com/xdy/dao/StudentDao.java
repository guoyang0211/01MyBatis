package com.xdy.dao;

import com.xdy.bean.Student;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    /**
     * 如果前台表单中给出的查询条件不能封装成一个对象的时候，我们可以使用两种方式来解决这个问题
     *
     * 第一种方式
     *      01.把查询条件 封装成map
     *          使用map 查询 姓名中带 小 并且年龄大于100的学生信息
     *
     *      02.使用map查询 姓名中 带 小的  ，年龄大于100 id大于小白id的学生信息
     */

    List<Student>selectStduentsByMap(Map<String,Object>map);


    /**
     * 第二种方式
     *  查询 姓名中带 小  并且年龄大于100的学生信息
     */
    List<Student>selectStduentsByCondition(String  name,int age);

}
