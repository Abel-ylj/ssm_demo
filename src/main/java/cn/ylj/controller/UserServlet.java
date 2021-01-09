package cn.ylj.controller;

import cn.ylj.service.impl.UserServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "UserServlet")
//public class UserServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取容器
//        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
//        UserServiceImpl us = ctx.getBean(UserServiceImpl.class);
//        us.save();
//    }
//}
