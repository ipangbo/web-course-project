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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/contents/news")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        NewsArticle news = null;
        List<NewsArticle> allNews = new ArrayList<>();
        if ("zhxw".equals(param)) {
            String sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE ACATEGORY=1 ORDER BY AID DESC";
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql);
                 ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    news = new NewsArticle();
                    news.setAid(rs.getInt(1));
                    news.setaTitle(rs.getString(2));
                    news.setaAbstractHTML(rs.getString(3));
                    news.setaCategory(rs.getInt(4));
                    news.setaCreateTime(rs.getDate(5));
                    allNews.add(news);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("allNews", allNews);
            req.getRequestDispatcher("/WEB-INF/jsp/news/zhxw.jsp").forward(req, resp);
        } else if ("dtsy".equals(param)) {
            String sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE ACATEGORY=2 ORDER BY AID DESC";
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql);
                 ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    news = new NewsArticle();
                    news.setAid(rs.getInt(1));
                    news.setaTitle(rs.getString(2));
                    news.setaAbstractHTML(rs.getString(3));
                    news.setaCategory(rs.getInt(4));
                    news.setaCreateTime(rs.getDate(5));
                    allNews.add(news);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("allNews", allNews);
            req.getRequestDispatcher("/WEB-INF/jsp/news/dtsy.jsp").forward(req, resp);
        } else if ("xmjx".equals(param)) {
            String sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE ACATEGORY=3 ORDER BY AID DESC";
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql);
                 ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    news = new NewsArticle();
                    news.setAid(rs.getInt(1));
                    news.setaTitle(rs.getString(2));
                    news.setaAbstractHTML(rs.getString(3));
                    news.setaCategory(rs.getInt(4));
                    news.setaCreateTime(rs.getDate(5));
                    allNews.add(news);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("allNews", allNews);
            req.getRequestDispatcher("/WEB-INF/jsp/news/xmjx.jsp").forward(req, resp);
        } else {
            String sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS ORDER BY AID DESC";
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql);
                 ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    news = new NewsArticle();
                    news.setAid(rs.getInt(1));
                    news.setaTitle(rs.getString(2));
                    news.setaAbstractHTML(rs.getString(3));
                    news.setaCategory(rs.getInt(4));
                    news.setaCreateTime(rs.getDate(5));
                    allNews.add(news);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("allNews", allNews);
            req.getRequestDispatcher("/WEB-INF/jsp/news/index.jsp").forward(req, resp);
        }
    }
}
