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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/contents/news/article")
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int aid = Integer.parseInt(req.getParameter("aid"));
        NewsArticle news = null;
        String sql = "SELECT ATITLE, AAUTHOR, ACONTENTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE AID IN (?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    news = new NewsArticle();
                    news.setAid(aid);
                    news.setaTitle(rs.getString(1));
                    news.setaAuthor(rs.getString(2));
                    news.setaContentHTML(rs.getString(3));
                    news.setaCategory(rs.getInt(4));
                    news.setaCreateTime(rs.getDate(5));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("article", news);
        req.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(req, resp);
    }
}
