package cn.ipangbo.controller;

import cn.ipangbo.utils.DataSourceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/testdr")
public class TestDataSourceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = DataSourceUtils.getConnection()) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("success");
    }
}
