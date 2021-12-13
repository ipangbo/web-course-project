package cn.ipangbo.filter;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/index.jsp")
public class IndexFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
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
        req.setAttribute("top5News", top5News);
        chain.doFilter(req, res);
    }
}
