package com.xdy;

import com.xdy.bean.Student;
import com.xdy.dao.StudentDao;
import com.xdy.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {
    StudentDao dao=null;
    SqlSession session=null;
    Logger log=Logger.getLogger(StudentTest.class);

    /**
     * 在所有的test测试方法之前  都要执行的操作
     */
    @Before
    public void before(){
        session= SessionFactoryUtil.getSession();
        dao=session.getMapper(StudentDao.class);
    }

    @After
    public void after(){
        if(session!=null){
            session.close();
        }
    }

    //使用map 查询 姓名中 带 小 ，年龄大于100 的学生 信息
@Test
    public void testIf(){
        Student student=new Student();
        //01.用户什么属性都没有赋值
        //02.用户传递name  Student.setName("小");
        //03.用户传递age Student.setAge(100);
        //04.name和age都进行了赋值
        student.setName("小");
        List<Student> studnets=dao.selectStudentsByIf(student);
        log.debug(studnets);
    }

    /**
     * 使用where
     */
    @Test
    public void testWhere(){
        Student student=new Student();
        //01.用户什么属性都没有赋值
        //02.用户传递name  Student.setName("小");
        //03.用户传递age Student.setAge(100);
        //04.name和age都进行了赋值
        student.setName("小");
        List<Student> studnets=dao.selectStudentsByIf(student);
        log.debug(studnets);
    }

/**
 * choose的使用
 */
@Test
    public void testChoose(){
    Student student=new Student();
    //01.name属性不为空 按照name查询 student.setName("小");
    //02. age属性不为空 按照age查询 student.setAge(555);
    //03.两个属性都有值  student.setName("小");    student.setAge(555);
    //04.两个属性都没有值
    List<Student>students=dao.selectStudentsByChoose(student);
    log.debug(students);
}

/**
 * foreach遍历数组
 */
@Test
    public void testArrayForeach(){
    Student student=new Student();
    int [] nums={14,11,12,9,8};
    List<Student>students=dao.selectStudentsByForeachArray(nums);
    log.debug(students);
}


/**
 * foreach 遍历List
 */
@Test
    public void testListForeach(){
    List<Integer>list=new ArrayList<Integer>();
    list.add(12);
    list.add(13);
    list.add(14);
    list.add(15);
    List<Student>students=dao.selectStudentsByForeachList(list);
    log.debug(students);
}

/**
 * foreach 遍历对象集合
 */
@Test
    public void testStudentForeach(){
    List<Student>list=new ArrayList<Student>();
    list.add(new Student(11));
    list.add(new Student(12));
    list.add(new Student(13));
    list.add(new Student(14));
    list.add(new Student(15));
    List<Student>students=dao.selectStudentsByForeachStudent(list);
    log.debug(students);
}

/**
 *foreach 遍历Map集合
 */
@Test
    public void testMapForeach(){
    Map<String,Object> map=new HashMap<String,Object>();
    map.put("2","object1");
    map.put("13","object2");
    map.put("14","object3");
    List<Student>students=dao.selectStudentsByForeachMap(map);
    log.debug(students);
}
}
