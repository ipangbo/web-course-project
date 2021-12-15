package cn.ipangbo.controller;

import cn.ipangbo.entity.PanelStatData;
import cn.ipangbo.service.GetPanelStatDataService;
import cn.ipangbo.service.QuerySingleNewsAPIService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/panel-stat-data")
public class GetPanelStatDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetPanelStatDataService service = new GetPanelStatDataService();
        String jsonOutput = service.getPanelStatData();

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(jsonOutput);
        out.close();
        resp.setStatus(200);
    }
}
