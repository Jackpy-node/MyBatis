package com.kpy.mybatis.dao;

import com.kpy.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: com.kpy.mybatis.dao
 * @data: 2019-9-6 9:53
 * @discription: 创建UserMapper接口（对应原UserDao）
 **/
public interface UserMapper {

    /**
     * 登录（直接使用注解指定传入参数名称 @Param("username")指定参数名称必须和Mapper.xml中接收参数名称一致#{username}）
     * @param user_name
     * @param password
     * @return
     */
    User Login(@Param("user_name") String user_name, @Param("password") String password);

    /**
     * 根据表名查询用户信息
     * @param tableName
     * @return
     */
    List<User> SelectByTableName(@Param("tableName") String tableName);


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
