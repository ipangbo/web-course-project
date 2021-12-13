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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/query-all-news")
public class ListAllNewsAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsArticle news = null;
        List<NewsArticle> articleList = new ArrayList<>();
        String jsonOutput = "";
        String sql = "SELECT AID, ATITLE, ACATEGORY FROM NEWS";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                news = new NewsArticle();
                news.setAid(rs.getInt(1));
                news.setaTitle(rs.getString(2));
                news.setaCategory(rs.getInt(3));
                articleList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jsonOutput = JSON.toJSONString(articleList);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(jsonOutput);
        out.close();
        resp.setStatus(200);
    }
}
