package cn.ipangbo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contents/job")
public class JobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        if ("zpzx".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/job/zpzx.jsp").forward(req, resp);
        } else if ("cxcy".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/job/cxcy.jsp").forward(req, resp);
        } else if ("gjhz".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/job/gjhz.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/job/index.jsp").forward(req, resp);
        }
    }
}
