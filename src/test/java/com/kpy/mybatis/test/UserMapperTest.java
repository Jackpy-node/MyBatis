package com.kpy.mybatis.test;

import com.kpy.mybatis.dao.UserMapper;
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
import java.util.List;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: com.kpy.mybatis.test
 * @data: 2019-9-6 10:21
 * @discription:
 **/
public class UserMapperTest {
    public static Logger logger= LoggerFactory.getLogger(UserMapperTest.class);
    public UserMapper userMapper;
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
        sqlSession=sqlSessionFactory.openSession(true);

        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        userMapper= sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void SelectByTableName(){
        List<User> userList=userMapper.SelectByTableName("t_user");
        for(User user: userList){
            logger.debug("user:{}", user.toString());
        }
    }

    @Test
    public void Login(){
        User user=userMapper.Login("evan", "123456");
        logger.debug("user:{}", user.toString());
    }

    @Test
    public void Update(){

        //userMapper.Update();
    }
}
