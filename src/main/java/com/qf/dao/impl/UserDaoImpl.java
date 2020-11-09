package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection conn = null;
    private Statement state = null;
    private ResultSet rs = null;

    @Override
    public List<User> selectAll() {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //获得连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop","root","root");

            //创建连接对象
            state = conn.createStatement();

            //sql语句编写
            String sql = "select u_id id, u_name name, u_gender gender, u_email email from users where flag = 0";

            //获取结果集
            rs = state.executeQuery(sql);

            //遍历结果集
            List list = new ArrayList();

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));

                list.add(user);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                state.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User selectOne(int id) {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //获得连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop","root","root");

            //创建连接对象
            state = conn.createStatement();

            //sql语句编写
            String sql = "select u_id id, u_name name, u_gender gender, u_email email from users where u_id="+id;

            //获取结果集
            rs = state.executeQuery(sql);

            //遍历结果集
            User user = new User();

            while (rs.next()){

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));

            }
            return user;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                state.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Boolean update(User user) {
        Connection conn =null;
        //执行sql
        PreparedStatement ps =null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop?useUnicode=true&characterEncoding=utf8", "root", "root");
            //创建连接对象
            //statement  = connection.createStatement();
            //sql的编写
            String sql = "update users set u_name = ? ,u_gender = ?, u_email =?  where u_id = ?";

            ps = conn.prepareStatement(sql);
            //给占位符进行赋值
            ps.setObject(1, user.getName());
            ps.setObject(2, user.getGender());
            ps.setObject(3, user.getEmail());
            ps.setObject(4, user.getId());
            //执行sql
            int i = ps.executeUpdate();
            //解析返回值
            if (i > 0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Boolean del(int id) {
        Connection conn =null;
        //执行sql
        PreparedStatement ps =null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop?useUnicode=true&characterEncoding=utf8", "root", "root");
            //创建连接对象
            //statement  = connection.createStatement();
            //sql的编写
            String sql = "delete from users where u_id = ?";

            ps = conn.prepareStatement(sql);
            //给占位符进行赋值
            ps.setObject(1, id);
            //执行sql
            int i = ps.executeUpdate();
            //解析返回值
            if (i > 0){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
