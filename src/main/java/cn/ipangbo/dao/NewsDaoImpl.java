package cn.ipangbo.dao;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDaoImpl implements NewsDao {
    @Override
    public int addNews(NewsArticle news) {
        String sql = "INSERT INTO NEWS(ATITLE, AAUTHOR, ACONTENTJSON, ACONTENTHTML, AABSTRACTJSON, AABSTRACTHTML) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, news.getaTitle());
            st.setString(2, news.getaAuthor());
            st.setString(3, news.getaContentJSON());
            st.setString(4, news.getaContentHTML());
            st.setString(5, news.getaAbstractJSON());
            st.setString(6, news.getaAbstractHTML());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteNews(int aid) {
        String sql = "DELETE FROM NEWS WHERE AID = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @Override
    public List<String> getEchoNewsAPIData(int aid) {
        List<String> resList = new ArrayList<>();
        String sql = "SELECT ACONTENTJSON, AABSTRACTJSON FROM NEWS WHERE AID IN (?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    resList.add(rs.getString(1));
                    resList.add(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resList;
    }

    @Override
    public NewsArticle getEchoNewsData(int aid) {
        NewsArticle news = null;
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
        assert news != null;
        news.setAid(aid);
        return news;
    }

    @Override
    public NewsArticle getNewsDetail(int aid) {
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

    @Override
    public int getNewsCount() {
        int newsCount = 0;
        String sql = "SELECT COUNT(*) FROM NEWS";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                newsCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsCount;
    }

    @Override
    public Date getNewsLastTime() {
        Date lastDate = new Date();
        String sql = "SELECT AMODIFYTIME FROM NEWS ORDER BY AID DESC LIMIT 1";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                lastDate = rs.getTimestamp(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastDate;
    }

    @Override
    public List<NewsArticle> listAllNewsForBackEnd() {
        NewsArticle news = null;
        List<NewsArticle> articleList = new ArrayList<>();
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
        return articleList;
    }

    @Override
    public int modifyNewsCategory(int aid, int category) {
        String sql = "UPDATE NEWS SET ACATEGORY = ? WHERE AID = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, category);
            st.setInt(2, aid);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @Override
    public List<NewsArticle> listAllNewsForFrontEnd(int category) {
        String sql = "";
        switch (category) {
            case 0:
                // 列出全部新闻
                sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS ORDER BY AID DESC";
                break;
            case 1:
                sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE ACATEGORY=1 ORDER BY AID DESC";
                break;
            case 2:
                sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE ACATEGORY=2 ORDER BY AID DESC";
                break;
            case 3:
                sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NEWS WHERE ACATEGORY=3 ORDER BY AID DESC";
                break;
        }
        List<NewsArticle> allNews = new ArrayList<>();
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

    @Override
    public List<NewsArticle> search(int category, String key, boolean isSearchTitleOnly) {
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
        return articleList;
    }

    @Override
    public NewsArticle querySingleNews(int aid) {
        NewsArticle news = null;
        String sql = "SELECT AID, ATITLE, AAUTHOR, ACONTENTJSON, ACONTENTHTML, AABSTRACTJSON, AABSTRACTHTML, ACATEGORY, ACREATETIME, AMODIFYTIME FROM NEWS WHERE AID IN (?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    news = new NewsArticle();
                    news.setAid(rs.getInt(1));
                    news.setaTitle(rs.getString(2));
                    news.setaAuthor(rs.getString(3));
                    news.setaContentJSON(rs.getString(4));
                    news.setaContentHTML(rs.getString(5));
                    news.setaAbstractJSON(rs.getString(6));
                    news.setaAbstractHTML(rs.getString(7));
                    news.setaCategory(rs.getInt(8));
                    news.setaCreateTime(rs.getDate(9));
                    news.setaModifyTime(rs.getDate(10));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public int submitNewsArticleModify(NewsArticle news) {
        String sql = "UPDATE NEWS SET ATITLE=?, AAUTHOR=?, ACONTENTJSON=?, ACONTENTHTML=?, AABSTRACTJSON=?, AABSTRACTHTML=? WHERE AID=?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, news.getaTitle());
            st.setString(2, news.getaAuthor());
            st.setString(3, news.getaContentJSON());
            st.setString(4, news.getaContentHTML());
            st.setString(5, news.getaAbstractJSON());
            st.setString(6, news.getaAbstractHTML());
            st.setInt(7, news.getAid());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @Override
    public List<NewsArticle> getTop5News() {
        List<NewsArticle> top5News = new ArrayList<>();
        NewsArticle news = null;
        String sql = "SELECT AID, ATITLE, ACATEGORY, ACREATETIME FROM NEWS ORDER BY AID DESC LIMIT 5";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                news = new NewsArticle();
                news.setAid(rs.getInt(1));
                news.setaTitle(rs.getString(2));
                news.setaCategory(rs.getInt(3));
                news.setaCreateTime(rs.getDate(4));
                top5News.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return top5News;
    }
}
