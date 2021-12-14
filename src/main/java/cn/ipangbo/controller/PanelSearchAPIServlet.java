package cn.ipangbo.controller;

import cn.ipangbo.service.PanelSearchAPIService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/panel-search")
public class PanelSearchAPIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
//        System.out.println(json);
        reader.close();
        System.out.println(json);

        PanelSearchAPIService service = new PanelSearchAPIService();
        String jsonOutput = service.search(json);

        System.out.println(jsonOutput);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(jsonOutput);
        out.close();
        resp.setStatus(200);
    }
}
