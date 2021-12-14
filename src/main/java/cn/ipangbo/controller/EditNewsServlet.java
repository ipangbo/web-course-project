package cn.ipangbo.controller;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.service.GetEchoNewsService;
import cn.ipangbo.service.SubmitArticleModifyService;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/panel/modnews")
public class EditNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在panel请求编辑数据后的逻辑
        int aid = Integer.parseInt(req.getParameter("aid"));

        GetEchoNewsService service = new GetEchoNewsService();
        NewsArticle news = service.getEchoNews(aid);

        req.setAttribute("newsToEcho", news);
        req.setAttribute("action", "编辑文章");
        req.getRequestDispatcher("/WEB-INF/jsp/panel/editorecho.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在编辑界面提交更改后的逻辑
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
//        System.out.println(json);
        reader.close();

        SubmitArticleModifyService service = new SubmitArticleModifyService();
        if (service.submitArticleModify(json) == 1) {
            PrintWriter out = resp.getWriter();
            out.write("{\"res\":\"failed\"}");
            out.close();
        }

//        返回json
        PrintWriter out = resp.getWriter();
        out.write("{\"res\":\"ok\"}");
        out.close();
    }
}
