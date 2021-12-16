package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetNewsDetailService {
    public NewsArticle getNewsDetailService(int aid) {
        NewsDao dao = new NewsDaoImpl();
        return dao.getNewsDetail(aid);
    }
}
