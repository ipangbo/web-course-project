package cn.ipangbo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/panel")
public class PanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        if ("news".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/newscontrol.jsp").forward(req, resp);
            return;
        } else if ("notice".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/noticecontrol.jsp").forward(req, resp);
            return;
        } else if ("teachers".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/teacherscontrol.jsp").forward(req, resp);
            return;
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/panel.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
