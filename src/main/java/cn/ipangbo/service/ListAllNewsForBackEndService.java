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
import java.util.ArrayList;
import java.util.List;

public class ListAllNewsForBackEndService {
    public String listAllNews() {
        NewsDao dao = new NewsDaoImpl();

        String jsonOutput = JSON.toJSONString(dao.listAllNewsForBackEnd());

        return jsonOutput;
    }
}
