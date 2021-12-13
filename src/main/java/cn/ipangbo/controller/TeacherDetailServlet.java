package cn.ipangbo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contents/teachers/detail")
public class TeacherDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // todo: ait替换成tid
        int tid = Integer.parseInt(req.getParameter("aid"));
        req.getRequestDispatcher("/WEB-INF/jsp/teacher.jsp").forward(req, resp);
    }
}
