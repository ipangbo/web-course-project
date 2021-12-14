package cn.ipangbo.service;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetArticleDetailService {
    public NewsArticle getArticleDetailService(int aid) {
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
        return news;
    }
}
