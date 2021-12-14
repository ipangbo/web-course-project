package cn.ipangbo.controller;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.service.NewsService;
import cn.ipangbo.utils.DataSourceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/contents/news")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        NewsService service = new NewsService();

        if ("zhxw".equals(param)) {
            req.setAttribute("allNews", service.getAllZHXWArticles());
            req.getRequestDispatcher("/WEB-INF/jsp/news/zhxw.jsp").forward(req, resp);
        } else if ("dtsy".equals(param)) {
            req.setAttribute("allNews", service.getAllDTSYArticles());
            req.getRequestDispatcher("/WEB-INF/jsp/news/dtsy.jsp").forward(req, resp);
        } else if ("xmjx".equals(param)) {
            req.setAttribute("allNews", service.getAllXMJXArticles());
            req.getRequestDispatcher("/WEB-INF/jsp/news/xmjx.jsp").forward(req, resp);
        } else {
            req.setAttribute("allNews", service.getAllArticles());
            req.getRequestDispatcher("/WEB-INF/jsp/news/index.jsp").forward(req, resp);
        }
    }
}
