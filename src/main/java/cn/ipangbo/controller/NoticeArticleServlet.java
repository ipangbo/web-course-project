package cn.ipangbo.controller;

import cn.ipangbo.entity.NoticeArticle;
import cn.ipangbo.service.GetNoticeDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contents/notice/article")
public class NoticeArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int aid = Integer.parseInt(req.getParameter("aid"));

        GetNoticeDetailService service = new GetNoticeDetailService();
        NoticeArticle notice = service.getNoticeDetailService(aid);

        req.setAttribute("article", notice);
        req.getRequestDispatcher("/WEB-INF/jsp/notice.jsp").forward(req, resp);
    }
}
