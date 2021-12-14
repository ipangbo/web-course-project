package cn.ipangbo.service;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListAllNewsService {
    public String listAllNews() {
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
        return jsonOutput;
    }
}
