package com.kpy.mybatis.test;

import com.kpy.mybatis.dao.UserDao;
import com.kpy.mybatis.daoimpl.UserDaoImpl;
import com.kpy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: com.kpy.mybatis.test
 * @data: 2019-9-3 18:48
 * @discription: 测试类
 **/
public class UserDaoMapperTest {
    public static Logger logger= LoggerFactory.getLogger(UserDaoMapperTest.class);
    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void SetUp() throws IOException {
        //指定全局配置文件
        String resource="mybatis-config.xml";
        //读取配置文件
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        sqlSession=sqlSessionFactory.openSession();
        userDao=new UserDaoImpl(sqlSession);
    }

    @Test
    public void Insert() throws ParseException {
        User user = new User();
        user.setId(userDao.QueryMaxId());
        user.setAge(16);
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1991-01-01"));
        user.setName("大鹏");
        user.setPassword("123456");
        user.setSex(1);
        user.setUser_name("evan");
        logger.debug("User{}", user.toString());
        userDao.Insert(user);
        sqlSession.commit();
    }

    @Test
    public void Update() throws ParseException {
        User user=new User();
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1991-01-01"));
        user.setName("静鹏");
        user.setPassword("654321");
        user.setSex(1);
        user.setUser_name("jackson");
        user.setId("1");
        userDao.Update(user);
        sqlSession.commit();
    }

    @Test
    public void SelectOne(){
        User user=userDao.SelectOne("1");
        //sqlSession.clearCache();
        logger.debug("User:{}", user.toString());
        user=userDao.SelectOne("1");
        sqlSession.clearCache();
        logger.debug("User:{}", user.toString());
    }

    @Test
    public void SelectAll(){
        List<User> userList=userDao.SelectAll();
        for(User user: userList){
            logger.debug("user:{}", user.toString());
        }
    }

    @Test
    public void Delete(){
        userDao.Delete("1");
    }
}
