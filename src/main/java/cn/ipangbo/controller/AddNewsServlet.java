package cn.ipangbo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/panel/addnews")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("type", "news");
        req.setAttribute("action", "新建文章");
        req.getRequestDispatcher("/WEB-INF/jsp/panel/editor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
        System.out.println(json);
        reader.close();

        /**
         * 返回json
         */
        PrintWriter out = resp.getWriter();
        out.write("{\"res\":\"ok\"}");
        out.close();
    }
}
