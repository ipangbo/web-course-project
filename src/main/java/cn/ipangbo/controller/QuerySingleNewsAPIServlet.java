package cn.ipangbo.controller;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/api/query-single-news")
public class QuerySingleNewsAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsArticle news = null;
        int aid = Integer.parseInt(req.getParameter("aid"));
        String jsonOutput = "";
        String sql = "SELECT AID, ATITLE, AAUTHOR, ACONTENTJSON, ACONTENTHTML, AABSTRACTJSON, AABSTRACTHTML, ACATEGORY, ACREATETIME, AMODIFYTIME FROM NEWS WHERE AID IN (?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    news = new NewsArticle();
                    news.setAid(rs.getInt(1));
                    news.setaTitle(rs.getString(2));
                    news.setaAuthor(rs.getString(3));
                    news.setaContentJSON(rs.getString(4));
                    news.setaContentHTML(rs.getString(5));
                    news.setaAbstractJSON(rs.getString(6));
                    news.setaAbstractHTML(rs.getString(7));
                    news.setaCategory(rs.getInt(8));
                    news.setaCreateTime(rs.getDate(9));
                    news.setaModifyTime(rs.getDate(10));

                    jsonOutput = JSON.toJSONString(news);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(jsonOutput);
        out.close();
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
