package cn.ipangbo.service;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsService {
    private final List<NewsArticle> allNews = new ArrayList<>();

    private List<NewsArticle> getNewsArticles(String sql) {
        allNews.clear();
        NewsArticle news = null;
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
        return allNews;
    }

    public List<NewsArticle> getAllZHXWArticles() {
        String sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE ACATEGORY=1 ORDER BY AID DESC";
        return getNewsArticles(sql);
    }

    public List<NewsArticle> getAllDTSYArticles() {
        String sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE ACATEGORY=2 ORDER BY AID DESC";
        return getNewsArticles(sql);
    }

    public List<NewsArticle> getAllXMJXArticles() {
        String sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE ACATEGORY=3 ORDER BY AID DESC";
        return getNewsArticles(sql);
    }

    public List<NewsArticle> getAllArticles() {
        String sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS ORDER BY AID DESC";
        return getNewsArticles(sql);
    }


}
