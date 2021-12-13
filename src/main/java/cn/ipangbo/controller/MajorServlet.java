package cn.ipangbo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contents/major")
public class MajorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        if ("zyjj".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/major/zyjj.jsp").forward(req, resp);
        } else if ("fxjj".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/major/fxjj.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/major/index.jsp").forward(req, resp);
        }
    }
}
