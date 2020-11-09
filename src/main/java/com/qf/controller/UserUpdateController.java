package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UserUpdateController extends HttpServlet {

    private UserService us = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id  = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setGender(gender);
        user.setEmail(email);

        Boolean b = us.update(user);
        if(b){
            resp.sendRedirect("/user");
        }
    }
}
