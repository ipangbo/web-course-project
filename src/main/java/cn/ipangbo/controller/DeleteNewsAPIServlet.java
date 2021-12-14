package cn.ipangbo.controller;

import cn.ipangbo.service.DeleteNewsAPIService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/delete-news")
public class DeleteNewsAPIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
//        System.out.println(json);
        reader.close();

        DeleteNewsAPIService service = new DeleteNewsAPIService();
        if (service.deleteNews(json) == 1) {
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
