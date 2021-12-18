package cn.ipangbo.dao;

import cn.ipangbo.entity.Article;
import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnionDaoImpl implements UnionDao{
    @Override
    public List<Article> search(int from, String key, boolean isSearchTitleOnly) {
        // category: 0是全部，1是新闻网，2是通知公告
//        String tableName = "";
//        switch (category) {
//            case 0:
//                tableName = "NEWS, NOTICE";
//                break;
//            case 1:
//                tableName = "NEWS";
//                break;
//            case 2:
//                tableName = "NOTICE";
//                break;
//            case 3:
//                tableName = "TEACHER";
//                break;
//        }
        String sql = "";
        Article article = null;
        List<Article> articleList = null;
        if (from == 1 && isSearchTitleOnly) {
            sql = "SELECT AID, ATITLE, ACATEGORY FROM NEWS WHERE ATITLE LIKE ? ORDER BY AID DESC ";
            
            articleList = new ArrayList<>();
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + key + "%");
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        article = new Article();
                        article.setAid(rs.getInt(1));
                        article.setaTitle(rs.getString(2));
                        article.setaCategory(rs.getInt(3));
                        article.setFrom(1);
                        articleList.add(article);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (from == 1){
            sql = "SELECT AID, ATITLE, ACATEGORY FROM NEWS WHERE ATITLE LIKE ? OR ACONTENTJSON LIKE ? ORDER BY AID DESC ";
            
            articleList = new ArrayList<>();
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + key + "%");
                st.setString(2, "%" + key + "%");
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        article = new Article();
                        article.setAid(rs.getInt(1));
                        article.setaTitle(rs.getString(2));
                        article.setaCategory(rs.getInt(3));
                        article.setFrom(1);
                        articleList.add(article);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (from == 2 && isSearchTitleOnly) {
            sql = "SELECT AID, ATITLE, ACATEGORY FROM NOTICE WHERE ATITLE LIKE ? ORDER BY AID DESC ";
            
            articleList = new ArrayList<>();
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + key + "%");
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        article = new Article();
                        article.setAid(rs.getInt(1));
                        article.setaTitle(rs.getString(2));
                        article.setaCategory(rs.getInt(3));
                        article.setFrom(2);
                        articleList.add(article);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (from == 2) {
            sql = "SELECT AID, ATITLE, ACATEGORY FROM NOTICE WHERE ATITLE LIKE ? OR ACONTENTJSON LIKE ? ORDER BY AID DESC ";
            
            articleList = new ArrayList<>();
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + key + "%");
                st.setString(2, "%" + key + "%");
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        article = new Article();
                        article.setAid(rs.getInt(1));
                        article.setaTitle(rs.getString(2));
                        article.setaCategory(rs.getInt(3));
                        article.setFrom(2);
                        articleList.add(article);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (from == 0 && isSearchTitleOnly) {
            sql = "SELECT T.AID, T.ATITLE, T.ACATEGORY, T.AMODIFYTIME, T.AFROM FROM (SELECT AID, ATITLE, ACATEGORY, AMODIFYTIME, AFROM FROM NEWS WHERE ATITLE LIKE ? UNION SELECT AID, ATITLE, ACATEGORY, AMODIFYTIME, AFROM FROM NOTICE WHERE ATITLE LIKE ?) T ORDER BY AMODIFYTIME DESC";
            articleList = new ArrayList<>();
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + key + "%");
                st.setString(2, "%" + key + "%");
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        article = new Article();
                        article.setAid(rs.getInt(1));
                        article.setaTitle(rs.getString(2));
                        article.setaCategory(rs.getInt(3));
                        article.setFrom(rs.getInt(5));
                        articleList.add(article);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (from == 0) {
            sql = "SELECT T.AID, T.ATITLE, T.ACATEGORY, T.AMODIFYTIME, T.AFROM FROM (SELECT AID, ATITLE, ACATEGORY, AMODIFYTIME, AFROM FROM NEWS WHERE ATITLE LIKE ? OR ACONTENTJSON LIKE ? UNION SELECT AID, ATITLE, ACATEGORY, AMODIFYTIME, AFROM FROM NOTICE WHERE ATITLE LIKE ? OR ACONTENTJSON LIKE ?) T ORDER BY AMODIFYTIME DESC";
            
            articleList = new ArrayList<>();
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + key + "%");
                st.setString(2, "%" + key + "%");
                st.setString(3, "%" + key + "%");
                st.setString(4, "%" + key + "%");
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        article = new Article();
                        article.setAid(rs.getInt(1));
                        article.setaTitle(rs.getString(2));
                        article.setaCategory(rs.getInt(3));
                        article.setFrom(rs.getInt(5));
                        articleList.add(article);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return articleList;
    }
}
