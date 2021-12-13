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

@WebServlet("/api/modify-news-category")
public class ModifyNewsCategoryAPIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
//        System.out.println(json);
        reader.close();

//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        int aid = jb.getIntValue("aid");
        int newcategory = jb.getIntValue("newcategory");

//        存入数据库
        String sql = "UPDATE NEWS SET ACATEGORY = ? WHERE AID = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, newcategory);
            st.setInt(2, aid);
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
