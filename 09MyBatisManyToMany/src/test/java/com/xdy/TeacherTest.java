package com.xdy;
import com.xdy.bean.Student;
import com.xdy.bean.Teacher;
import com.xdy.dao.TeacherDao;
import com.xdy.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TeacherTest {
    TeacherDao dao=null;
    SqlSession session=null;
    Logger log=Logger.getLogger(TeacherTest.class);

    /**
     * 在所有的test测试方法执行之前 都要执行的操作
     */
    @Before
    public void before(){
        //获取session
        session= SessionFactoryUtil.getSession();
        dao=session.getMapper(TeacherDao.class); //获取执行的类对象
    }

    @After
    public  void after(){
        if (session!=null){
            session.close();
        }
    }

    @Test
    public void testSelectBySid(){
        Student student=dao.selectTeachersBySid(2);
        log.debug(student);
    }

    @Test
    public void testSelectByTid(){
        Teacher teacher=dao.selectStudentsByTid(1);
        log.debug(teacher);
    }

}
