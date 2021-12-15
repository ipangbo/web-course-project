package cn.ipangbo.controller;

import cn.ipangbo.service.GetPanelStatDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/panel")
public class PanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("page");
        if ("news".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/newscontrol.jsp").forward(req, resp);
        } else if ("notice".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/noticecontrol.jsp").forward(req, resp);
        } else if ("teachers".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/teacherscontrol.jsp").forward(req, resp);
        } else if ("search".equals(param)) {
            req.getRequestDispatcher("/WEB-INF/jsp/panel/search.jsp").forward(req, resp);
        } else {
            GetPanelStatDataService service = new GetPanelStatDataService();
            req.setAttribute("newsCount", service.getPanelNewsCount());
            req.setAttribute("lastDate", service.getPanelNewsLastTime());
            req.getRequestDispatcher("/WEB-INF/jsp/panel/panel.jsp").forward(req, resp);
        }
    }
}
