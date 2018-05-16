package com.xdy.dao;

import com.xdy.bean.Student;
import com.xdy.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class StudentDaoImpl implements StudentDao{
    //公共的session对象
    //获取SqlSession

    SqlSession session = null;

    /**
     * 新增
     */
    @Override
    public void addStudent(Student student) {
        try {
            //获取SqlSession
            session= SessionFactoryUtil.getSession();
            session.insert("addStudent",student);  //新增用户
            //提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();  //回滚
        }finally {
            session.close();
        }
    }

    /**
     * 新增同时获取该ID
     * @param student
     */
    @Override
    public void addStudentByCache(Student student) {
        //获取session
        SqlSession session=null;
       try{
           session = SessionFactoryUtil.getSession();
           session.insert("addStudentByCache",student);
           //手动提交事务
           session.commit();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           session.close();
       }
    }

    @Override
    public void deleteStudent(Serializable id) {
        //获取session
        SqlSession session=null;
       try{
           session=SessionFactoryUtil.getSession();
           //删除操作
           session.delete("deleteStudent",id);
           //提交事务
           session.commit();
       }catch(Exception e){
           e.printStackTrace();
       }finally {
           session.close();
       }
    }

    @Override
    public void updateStudent(Student student) {
        //获取session
        SqlSession session=null;
       try{
           session=SessionFactoryUtil.getSession();
           //修改操作
           session.update("updateStudent",student);
           //提交事务
           session.commit();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           session.close();
       }
    }

    @Override
    public List<Student> seleteAllStudents() {
        //创建Student集合
        List<Student>student=null;
        //获取session
        SqlSession session =null;
       try{
           session=SessionFactoryUtil.getSession();
           //查询所有操作
           student= session.selectList("seleteAllStudents");
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           session.close();
       }
        return student;
    }

    @Override
    public Map<Student, Object> selectAllByMap() {
        //获取session
        SqlSession session=null;
        Map<Student,Object> students=null;

       try{
           session=SessionFactoryUtil.getSession();
           /**
            * 查询所有操作  返回map
            * s1：map集合中的key
            */
           students=session.selectMap("selectAllByMap","name");
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           session.close();
       }
        return students;
    }

    @Override
    public Student selectStudentById(Serializable id) {
        Student student=null;
        //获取session
        SqlSession session=null;
        try{
            session= SessionFactoryUtil.getSession();
            student= session.selectOne("selectStudentById",id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return student;
    }

    @Override
    public List<Student> selectByName(String name) {
        List<Student>students=null;
        //获取session
        SqlSession session =null;
       try{
           session=SessionFactoryUtil.getSession();
           students= session.selectList("selectByName",name);
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           session.close();
       }
        return students;
    }

}
