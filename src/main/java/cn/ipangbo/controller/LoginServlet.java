package cn.ipangbo.controller;

import cn.ipangbo.entity.User;
import cn.ipangbo.utils.LoginAuthUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/panel/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/panel/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String password = req.getParameter("password");
        if (LoginAuthUtils.check(uname, password)) {
            User user = new User();
            user.setUid(1);
            user.setUname(uname);
            user.setPassword(password);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/panel");
        } else {
            MessageModel msg = new MessageModel();
            msg.setMsg("登录失败，用户名或密码错误");
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/WEB-INF/jsp/panel/login.jsp").forward(req, resp);
        }
    }
}
