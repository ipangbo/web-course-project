package cn.ipangbo.controller;

import cn.ipangbo.service.ListAllNoticeForBackEndService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/query-all-notice")
public class ListAllNoticeAPIForBackEndServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListAllNoticeForBackEndService service = new ListAllNoticeForBackEndService();
        String jsonOutput = service.listAllNotice();

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(jsonOutput);
        out.close();
        resp.setStatus(200);
    }
}
