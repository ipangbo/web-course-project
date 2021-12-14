package cn.ipangbo.service;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PanelSearchAPIService {
    public String search(String json) {
        // 本方法返回所有符合条件的对象的列表的json字符串

        // 处理json
        JSONObject jb = JSONObject.parseObject(json);
        String key = jb.getString("search-key");
        int category = jb.getIntValue("category");
        boolean isSearchTitleOnly = jb.getBooleanValue("is-search-title-only");

        // 编写sql语句
        String sql = "";
        String tableName = "NEWS";
        switch (category) {
            case 0:
                tableName = "NEWS";
                break;
            case 1:
                tableName = "NEWS";
                break;
            case 2:
                tableName = "NOTICE";
                break;
            case 3:
                tableName = "TEACHERS";
                break;
        }
        if (isSearchTitleOnly) {
            sql = "SELECT AID, ATITLE, ACATEGORY FROM " + tableName + " WHERE ATITLE LIKE ?";
        } else {
            sql = "SELECT AID, ATITLE, ACATEGORY FROM " + tableName + " WHERE ATITLE LIKE ? OR ACONTENTJSON LIKE ?";
        }

        // 执行sql查询，完成业务逻辑
        NewsArticle news = null;
        List<NewsArticle> articleList = new ArrayList<>();
        String jsonOutput = "";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, "%" + key + "%");
            if (!isSearchTitleOnly) {
                st.setString(2, "%" + key + "%");
            }
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    news = new NewsArticle();
                    news.setAid(rs.getInt(1));
                    news.setaTitle(rs.getString(2));
                    news.setaCategory(rs.getInt(3));
                    articleList.add(news);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jsonOutput = JSON.toJSONString(articleList);
        return jsonOutput;
    }
}
