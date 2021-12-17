package cn.ipangbo.controller;

import cn.ipangbo.service.GetEchoNoticeDataAPIService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/get-notice-echo-data")
public class GetNoticeEchoDataAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int aid = Integer.parseInt(req.getParameter("aid"));

        GetEchoNoticeDataAPIService service = new GetEchoNoticeDataAPIService();
        String jsonOutput = service.getEchoData(aid);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(jsonOutput);
        out.close();
        resp.setStatus(200);
    }
}
