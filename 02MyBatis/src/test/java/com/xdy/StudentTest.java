package com.xdy;

import com.xdy.bean.Student;
import com.xdy.dao.StudentDao;
import com.xdy.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class StudentTest {
    StudentDao dao=null;
    SqlSession session=null;
    Logger log = Logger.getLogger(StudentTest.class);

    /**
     * 在所有的test测试方法执行之前 都要执行的操作
     */
    @Before
    public void before(){
        //获取session
        session= SessionFactoryUtil.getSession();
        dao= session.getMapper(StudentDao.class);
    }

    @After
    public void after(){
        if(session!=null){
            session.close();
        }
    }

    /**
     * 新增学生信息到数据库
     */
@Test
    public void testAddStudent(){
    Student student=new Student(10,"大花猫");
    dao.addStudent(student);
    session.commit();
    }

    /**
     * 我们需要新增对象之后，接着对这个对象进行操作
     * 上面的新增方法能实现吗？
     * 怎么办？
     * 有一种方式  是在insert节点中新增一个selectkey节点
     * 在我们新增完对象之后，连接没有立即放回连接池中，
     * 而是接着查询数据库中 刚刚插入数据的ID
     * 这样ID我们就能获取了
     */
@Test
    public void addStudentByCache(){
    Student student=new Student(12,"加菲猫");
    dao.addStudentByCache(student);
    log.debug("新增学生的id====》"+student.getId());
    session.commit();
}

/**
 * 删除
 */
@Test
    public void delStudent(){
    dao.deleteStudent(2);
    session.commit();
}

/**
 * 修改
 */
@Test
    public void updateStudent(){
    Student student=new Student(3,18,"乐乐");
    dao.updateStudent(student);
    log.debug("修改之后的学生信息是："+student);
    session.commit();
}
/**
 * 查询所有 返回list
 */
@Test
    public void listStudent(){
    List<Student>students=dao.selectAllStudents();
    log.debug(students);
}

/**
 * 查询所有 返回maop
 */
@Test
    public void mapStudent(){
   List<Map<String, Object>> studentMaps=dao.selectAllByMap();
}

    /**
     * 查询指定的student 返回Student对象
     */
    @Test
    public void selectStudentById(){
        log.debug(dao.selectStudentById(8));
    }
    /**
     * 根据姓名模糊查询
     */
    @Test
    public void selectStudentByName(){
        List<Student> students = dao.selectByName("猫");
        log.debug(students);
    }

}
