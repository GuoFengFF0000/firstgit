package com.qf.dao;

import com.qf.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> selectAll();

    User selectOne(int id);

    Boolean update(User user);

    Boolean del(int id);

    int insert(User user);
}
