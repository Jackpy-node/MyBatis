package com.kpy.mybatis.daoimpl;

import com.kpy.mybatis.dao.UserDao;
import com.kpy.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: com.kpy.mybatis.daoimpl
 * @data: 2019-9-2 22:00
 * @discription: DAO实现类
 **/
public class UserDaoImpl implements UserDao {

    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User SelectOne(String id) {
        User user=sqlSession.selectOne("UserDaoMapper.SelectOne", id);
        return user;
    }

    @Override
    public List<User> SelectAll() {
        return sqlSession.selectList("UserDaoMapper.SelectOne");
    }

    @Override
    public void Insert(User user) {
        sqlSession.insert("UserDaoMapper.SelectAll", user);
    }

    @Override
    public void Update(User user) {

    }

    @Override
    public void Delete(String id) {
        sqlSession.delete("UserDaoMapper.Delete", id);
    }

    @Override
    public String QueryMaxId() {
        String id=sqlSession.selectOne("UserDaoMapper.QueryMaxId");
        String max_id=String.valueOf(Long.parseLong(id)+1);
        return max_id;
    }
}
