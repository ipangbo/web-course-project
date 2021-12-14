package cn.ipangbo.controller;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.service.GetArticleDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contents/news/article")
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int aid = Integer.parseInt(req.getParameter("aid"));

        GetArticleDetailService service = new GetArticleDetailService();
        NewsArticle news = service.getArticleDetailService(aid);

        req.setAttribute("article", news);
        req.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(req, resp);
    }
}
