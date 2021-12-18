package cn.ipangbo.dao;

import cn.ipangbo.entity.NoticeArticle;
import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeDaoImpl implements NoticeDao{
    @Override
    public int addNotice(NoticeArticle notice) {
        String sql = "INSERT INTO NOTICE(ATITLE, AAUTHOR, ACONTENTJSON, ACONTENTHTML, AABSTRACTJSON, AABSTRACTHTML) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, notice.getaTitle());
            st.setString(2, notice.getaAuthor());
            st.setString(3, notice.getaContentJSON());
            st.setString(4, notice.getaContentHTML());
            st.setString(5, notice.getaAbstractJSON());
            st.setString(6, notice.getaAbstractHTML());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteNotice(int aid) {
        String sql = "DELETE FROM NOTICE WHERE AID = ?";
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
    public List<String> getEchoNoticeAPIData(int aid) {
        List<String> resList = new ArrayList<>();
        String sql = "SELECT ACONTENTJSON, AABSTRACTJSON FROM NOTICE WHERE AID IN (?)";
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
    public NoticeArticle getEchoNoticeData(int aid) {
        NoticeArticle notice = null;
        String sql = "SELECT ATITLE, AAUTHOR FROM NOTICE WHERE AID IN (?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    notice = new NoticeArticle();
                    notice.setaTitle(rs.getString(1));
                    notice.setaAuthor(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert notice != null;
        notice.setAid(aid);
        return notice;
    }

    @Override
    public NoticeArticle getNoticeDetail(int aid) {
        NoticeArticle notice = null;
        String sql = "SELECT ATITLE, AAUTHOR, ACONTENTHTML, ACATEGORY, ACREATETIME FROM NOTICE WHERE AID IN (?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    notice = new NoticeArticle();
                    notice.setAid(aid);
                    notice.setaTitle(rs.getString(1));
                    notice.setaAuthor(rs.getString(2));
                    notice.setaContentHTML(rs.getString(3));
                    notice.setaCategory(rs.getInt(4));
                    notice.setaCreateTime(rs.getDate(5));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }

    @Override
    public int getNoticeCount() {
        int noticeCount = 0;
        String sql = "SELECT COUNT(*) FROM NOTICE";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                noticeCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noticeCount;
    }

    @Override
    public Date getNoticeLastTime() {
        Date lastDate = new Date();
        String sql = "SELECT AMODIFYTIME FROM NOTICE ORDER BY AID DESC LIMIT 1";
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
    public List<NoticeArticle> listAllNoticeForBackEnd() {
        NoticeArticle notice = null;
        List<NoticeArticle> articleList = new ArrayList<>();
        String sql = "SELECT AID, ATITLE, ACATEGORY FROM NOTICE";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                notice = new NoticeArticle();
                notice.setAid(rs.getInt(1));
                notice.setaTitle(rs.getString(2));
                notice.setaCategory(rs.getInt(3));
                articleList.add(notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articleList;
    }

    @Override
    public int modifyNoticeCategory(int aid, int category) {
        String sql = "UPDATE NOTICE SET ACATEGORY = ? WHERE AID = ?";
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
    public List<NoticeArticle> listAllNoticeForFrontEnd(int category) {
        String sql = "";
        switch (category) {
            case 0:
                // 列出全部新闻
                sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NOTICE ORDER BY AID DESC";
                break;
            case 1:
                sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NOTICE WHERE ACATEGORY=1 ORDER BY AID DESC";
                break;
            case 2:
                sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NOTICE WHERE ACATEGORY=2 ORDER BY AID DESC";
                break;
            case 3:
                sql = "SELECT AID, ATITLE, AABSTRACTHTML, ACATEGORY, ACREATETIME FROM NOTICE WHERE ACATEGORY=3 ORDER BY AID DESC";
                break;
        }
        List<NoticeArticle> allNotice = new ArrayList<>();
        NoticeArticle notice = null;
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                notice = new NoticeArticle();
                notice.setAid(rs.getInt(1));
                notice.setaTitle(rs.getString(2));
                notice.setaAbstractHTML(rs.getString(3));
                notice.setaCategory(rs.getInt(4));
                notice.setaCreateTime(rs.getDate(5));
                allNotice.add(notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allNotice;
    }

    @Override
    public NoticeArticle querySingleNotice(int aid) {
        NoticeArticle notice = null;
        String sql = "SELECT AID, ATITLE, AAUTHOR, ACONTENTJSON, ACONTENTHTML, AABSTRACTJSON, AABSTRACTHTML, ACATEGORY, ACREATETIME, AMODIFYTIME FROM NOTICE WHERE AID IN (?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    notice = new NoticeArticle();
                    notice.setAid(rs.getInt(1));
                    notice.setaTitle(rs.getString(2));
                    notice.setaAuthor(rs.getString(3));
                    notice.setaContentJSON(rs.getString(4));
                    notice.setaContentHTML(rs.getString(5));
                    notice.setaAbstractJSON(rs.getString(6));
                    notice.setaAbstractHTML(rs.getString(7));
                    notice.setaCategory(rs.getInt(8));
                    notice.setaCreateTime(rs.getDate(9));
                    notice.setaModifyTime(rs.getDate(10));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }

    @Override
    public int submitNoticeArticleModify(NoticeArticle notice) {
        String sql = "UPDATE NOTICE SET ATITLE=?, AAUTHOR=?, ACONTENTJSON=?, ACONTENTHTML=?, AABSTRACTJSON=?, AABSTRACTHTML=? WHERE AID=?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, notice.getaTitle());
            st.setString(2, notice.getaAuthor());
            st.setString(3, notice.getaContentJSON());
            st.setString(4, notice.getaContentHTML());
            st.setString(5, notice.getaAbstractJSON());
            st.setString(6, notice.getaAbstractHTML());
            st.setInt(7, notice.getAid());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @Override
    public List<NoticeArticle> getTop5Notice() {
        List<NoticeArticle> top5Notice = new ArrayList<>();
        NoticeArticle notice = null;
        String sql = "SELECT AID, ATITLE, ACATEGORY, ACREATETIME FROM NOTICE ORDER BY AID DESC LIMIT 5";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                notice = new NoticeArticle();
                notice.setAid(rs.getInt(1));
                notice.setaTitle(rs.getString(2));
                notice.setaCategory(rs.getInt(3));
                notice.setaCreateTime(rs.getDate(4));
                top5Notice.add(notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return top5Notice;
    }
}
