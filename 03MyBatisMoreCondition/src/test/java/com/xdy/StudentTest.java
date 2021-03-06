package com.xdy;

import com.xdy.bean.Student;
import com.xdy.dao.StudentDao;
import com.xdy.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
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

//使用map 查询  姓名中带 小 年龄 大于100 的学生信息

    @Test
    public void testMap(){
        //创建一个map
        Map<String,Object> map=new HashMap();
        map.put("stuName","小");
        map.put("stuAge",100);
        List<Student> students=dao.selectStduentsByMap(map);
        log.debug(students);
    }
    //使用map 查询 姓名中 带小 年龄大于100 并且 id 大于小白id的 学生信息

    @Test
    public void testMap2(){
        //创建一个Map
        Map<String,Object>map=new HashMap();
        map.put("stuName","小");
        map.put("stuAge",100);
        /**
         * id大于小白id
         * 模拟一个小白  应该是从数据库查询
         */
        Student stu=new Student();
        stu.setId(6);
        stu.setName("小白");
        map.put("student",stu);
        List<Student>  students=dao.selectStduentsByMap(map);
        log.debug(students);

    }
@Test
public  void  testCondition(){
    /**
     * 模拟从前台获取用户的输入
     * 小和100 都是 用户前台的输入
     */
    List<Student> students = dao.selectStduentsByCondition("小", 100);
    log.debug(students);
}

}
