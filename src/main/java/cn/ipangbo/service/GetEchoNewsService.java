package cn.ipangbo.service;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEchoNewsService {
    public NewsArticle getEchoNews(int aid) {
        NewsArticle news = null;
        // 请求回显有关的所有数据，传递给视图editorecho.jsp
        // 然而，json相关需要单独的接口
        // 使用前后端分离重构项目时会全部整合在一个接口中
        String sql = "SELECT ATITLE, AAUTHOR FROM NEWS WHERE AID IN (?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    news = new NewsArticle();
                    news.setaTitle(rs.getString(1));
                    news.setaAuthor(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        news.setAid(aid);
        return news;
    }
}
