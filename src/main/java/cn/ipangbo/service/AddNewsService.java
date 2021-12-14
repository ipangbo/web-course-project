package cn.ipangbo.service;

import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewsService {
    public int addNews(String json) {
//        添加新闻的服务，成功返回0， 失败返回1
//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        String articleTitle = jb.getString("article-title");
        String articleAuthor = jb.getString("article-author");
        String articleContentJSON = jb.getString("article-content-json");
        String articleContentHTML = jb.getString("article-content-html");
        String articleAbstractJSON = jb.getString("article-abstract-json");
        String articleAbstractHTML = jb.getString("article-abstract-html");

//        存入数据库
        String sql = "INSERT INTO NEWS(ATITLE, AAUTHOR, ACONTENTJSON, ACONTENTHTML, AABSTRACTJSON, AABSTRACTHTML) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, articleTitle);
            st.setString(2, articleAuthor);
            st.setString(3, articleContentJSON);
            st.setString(4, articleContentHTML);
            st.setString(5, articleAbstractJSON);
            st.setString(6, articleAbstractHTML);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
