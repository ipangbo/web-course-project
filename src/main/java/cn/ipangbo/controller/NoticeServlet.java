package cn.ipangbo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contents/notice")
public class NoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        if ("jyjx".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/notice/jyjx.jsp").forward(req, resp);
        } else if ("hqbz".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/notice/hqbz.jsp").forward(req, resp);
        } else if ("xsdt".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/notice/xsdt.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/notice/index.jsp").forward(req, resp);
        }
    }
}
