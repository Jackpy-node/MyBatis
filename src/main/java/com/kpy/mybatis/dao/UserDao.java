package com.kpy.mybatis.dao;

import com.kpy.mybatis.pojo.User;

import java.util.List;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: com.kpy.mybatis.dao
 * @data: 2019-9-2 21:59
 * @discription: DAO接口
 **/
public interface UserDao {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User SelectOne(String id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> SelectAll();

    /**
     * 插入新用户
     * @param user
     */
    void Insert(User user);

    /**
     * 更新指定用户
     * @param user
     */
    void Update(User user);

    /**
     * 删除指定用户
     * @param id
     */
    void Delete(String id);

    /**
     * 查询最大序号
     * @return
     */
    String QueryMaxId();
}
