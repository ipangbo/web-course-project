package cn.ipangbo.controller;

import cn.ipangbo.service.ListAllNewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/query-all-news")
public class ListAllNewsAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListAllNewsService service = new ListAllNewsService();
        String jsonOutput = service.listAllNews();

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(jsonOutput);
        out.close();
        resp.setStatus(200);
    }
}
