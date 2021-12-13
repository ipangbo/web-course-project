package cn.ipangbo.controller;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/panel")
public class PanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        if ("news".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/newscontrol.jsp").forward(req, resp);
        } else if ("notice".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/noticecontrol.jsp").forward(req, resp);
        } else if ("teachers".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/teacherscontrol.jsp").forward(req, resp);
        } else if ("search".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/search.jsp").forward(req, resp);
        } else {
            int newsCount = 0;
            Date lastDate = new Date();
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
            sql = "SELECT AMODIFYTIME FROM NEWS ORDER BY AID DESC LIMIT 1";
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql);
                 ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    lastDate = rs.getTimestamp(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("newsCount", newsCount);
            req.setAttribute("lastDate", lastDate);
            req.getRequestDispatcher("/WEB-INF/jsp/panel/panel.jsp").forward(req, resp);
        }
    }
}
