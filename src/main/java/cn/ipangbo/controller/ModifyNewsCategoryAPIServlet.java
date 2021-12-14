package cn.ipangbo.controller;

import cn.ipangbo.service.ModifyNewsCategoryAPIService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/modify-news-category")
public class ModifyNewsCategoryAPIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
//        System.out.println(json);
        reader.close();

        ModifyNewsCategoryAPIService service = new ModifyNewsCategoryAPIService();
        if (service.modifyNewsCategory(json) == 1) {
            PrintWriter out = resp.getWriter();
            out.write("{\"res\":\"failed\"}");
            out.close();
            return;
        }

//        返回json
        PrintWriter out = resp.getWriter();
        out.write("{\"res\":\"ok\"}");
        out.close();
    }
}
