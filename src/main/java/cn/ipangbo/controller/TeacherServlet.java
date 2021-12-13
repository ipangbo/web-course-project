package cn.ipangbo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contents/teachers")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        if ("js".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/teachers/js.jsp").forward(req, resp);
            return;
        } else if ("fjs".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/teachers/fjs.jsp").forward(req, resp);
            return;
        } else if ("jiangshi".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/teachers/jiangshi.jsp").forward(req, resp);
            return;
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/teachers/index.jsp").forward(req, resp);
            return;
        }    }
}
