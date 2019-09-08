package com.kpy.mybatis.mybatis;

import com.kpy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: com.kpy.mybatis.mybatis
 * @data: 2019-9-3 11:45
 * @discription:
 **/
public class Mybatis {

    private static Logger logger= LoggerFactory.getLogger(Mybatis.class);

    public static void main(String[] args) throws IOException {
        //指定全局配置文件
        String resource="mybatis-config.xml";
        //读取配置文件
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession();

        try{
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            User user=sqlSession.selectOne("UserDao.SelectUser", "1");
            logger.debug("User:{}", user.toString());

            String id=sqlSession.selectOne("UserDao.QueryMaxId");
            logger.debug("id:{}", Long.parseLong(id)+1);
        }
        finally {
            sqlSession.close();
        }
    }
}
