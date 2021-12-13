package cn.ipangbo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contents/lab")
public class LabServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        if ("923".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/lab/923.jsp").forward(req, resp);
        } else if ("925".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/lab/925.jsp").forward(req, resp);
        } else if ("999".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/lab/999.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/lab/index.jsp").forward(req, resp);
        }
    }
}
