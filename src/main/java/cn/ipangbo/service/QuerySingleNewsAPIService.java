package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuerySingleNewsAPIService {
    public String querySingleNews(int aid) {
        NewsDao dao = new NewsDaoImpl();

        String jsonOutput = JSON.toJSONString(dao.querySingleNews(aid));
        return jsonOutput;
    }
}
