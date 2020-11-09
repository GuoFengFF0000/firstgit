package com.qf.service;

import com.qf.pojo.User;

import java.util.List;

public interface UserService {

    List<User> selectAll();

    User selectOne(int id);

    Boolean update(User user);

    Boolean del(int id);
}
