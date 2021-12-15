package cn.ipangbo.controller;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.service.GetArticleDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contents/notice/detail")
public class NoticeArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int aid = Integer.parseInt(req.getParameter("aid"));

        req.getRequestDispatcher("/WEB-INF/jsp/notice.jsp").forward(req, resp);
    }
}
