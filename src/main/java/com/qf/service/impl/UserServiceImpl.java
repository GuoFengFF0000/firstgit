package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import com.qf.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao ud = new UserDaoImpl();

    @Override
    public List<User> selectAll() {
        return ud.selectAll();
    }

    @Override
    public User selectOne(int id) {
        return ud.selectOne(id);
    }

    @Override
    public Boolean update(User user) {
        return ud.update(user);
    }

    @Override
    public Boolean del(int id) {
        return ud.del(id);
    }

    @Override
    public int insert(User user) {
        return ud.insert(user);
    }
}
