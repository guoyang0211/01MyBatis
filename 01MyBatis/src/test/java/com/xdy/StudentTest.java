package com.xdy;

import com.xdy.bean.Student;
import com.xdy.dao.StudentDao;
import com.xdy.dao.StudentDaoImpl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class StudentTest {
    StudentDao dao=null;
   Logger log= Logger.getLogger(StudentTest.class);
    @Before
    public void before(){
        dao=new StudentDaoImpl();
    }
    /**
     * 新增
     */
    @Test
    public void testAddStudent(){
        Student student=new Student(21,"阳阳");
        dao.addStudent(student);
    }


    /**
     * 新增同时获取Id
     */
    @Test
    public void addStudentByCache(){
        Student student=new Student(21,"阳阳");
        log.debug("insert之前学生的编号："+student.getId());
        dao.addStudentByCache(student);
        log.debug("insert之后学生的编号："+student.getId());//就会有值
    }


    /**
     * 删除
     */
    @Test
    public void deleteStudent(){
       dao.deleteStudent(1);
    }

    /**
     * 修改
     */
    @Test
    public void updateStudent(){
      Student student=new Student(2,2,"郭郭");
        dao.updateStudent(student);
    }


    /**
     * 查询所有返回list
     */
    @Test
    public void listStudent(){
        List<Student> students=dao.seleteAllStudents();
        log.debug(students);
    }


    /**
     * 查询所有返回map
     */
    @Test
    public void selectAllByMap(){
        Map<Student,Object>students=dao.selectAllByMap();
        log.debug(students);
    }

    /**
     * 根据ID查询指定
     */
    @Test
    public void selectStudentById(){
       Student student=dao.selectStudentById(2);
        log.debug(student);
    }


    /**
     * 根据姓名模糊查询
     */
    @Test
    public void selectByName(){
       List<Student> students=dao.selectByName("郭");
        log.debug(students);
    }


}
