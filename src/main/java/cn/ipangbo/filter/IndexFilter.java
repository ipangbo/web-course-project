package cn.ipangbo.filter;

import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.service.GetTop5Service;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/index.jsp")
public class IndexFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        GetTop5Service service = new GetTop5Service();

        req.setAttribute("top5News", service.getTop5News());
        chain.doFilter(req, res);
    }
}
