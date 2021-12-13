package cn.ipangbo.controller;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/panel/modnews")
public class EditNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在panel请求编辑数据后的逻辑
        int aid = Integer.parseInt(req.getParameter("aid"));
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
        req.setAttribute("newsToEcho", news);
        req.setAttribute("action", "编辑文章");
        req.getRequestDispatcher("/WEB-INF/jsp/panel/editorecho.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在编辑界面提交更改后的逻辑
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
//        System.out.println(json);
        reader.close();

//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        int aid = jb.getIntValue("aid");
        String articleTitle = jb.getString("article-title");
        String articleAuthor = jb.getString("article-author");
        String articleContentJSON = jb.getString("article-content-json");
        String articleContentHTML = jb.getString("article-content-html");
        String articleAbstractJSON = jb.getString("article-abstract-json");
        String articleAbstractHTML = jb.getString("article-abstract-html");

//        存入数据库
        String sql = "UPDATE NEWS SET ATITLE=?, AAUTHOR=?, ACONTENTJSON=?, ACONTENTHTML=?, AABSTRACTJSON=?, AABSTRACTHTML=? WHERE AID=?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, articleTitle);
            st.setString(2, articleAuthor);
            st.setString(3, articleContentJSON);
            st.setString(4, articleContentHTML);
            st.setString(5, articleAbstractJSON);
            st.setString(6, articleAbstractHTML);
            st.setInt(7, aid);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        返回json
        PrintWriter out = resp.getWriter();
        out.write("{\"res\":\"ok\"}");
        out.close();
    }
}
