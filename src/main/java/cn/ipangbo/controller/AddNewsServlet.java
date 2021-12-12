package cn.ipangbo.controller;

import cn.ipangbo.utils.DataSourceUtils;
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
import java.sql.SQLException;

@WebServlet("/panel/addnews")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("type", "news");
        req.setAttribute("action", "新建文章");
        req.getRequestDispatcher("/WEB-INF/jsp/panel/editor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
//        System.out.println(json);
        reader.close();

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
        }

//        返回json
        PrintWriter out = resp.getWriter();
        out.write("{\"res\":\"ok\"}");
        out.close();
    }
}
