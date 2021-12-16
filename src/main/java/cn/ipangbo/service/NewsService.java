package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsService {
    private NewsDao dao = new NewsDaoImpl();

    public List<NewsArticle> getAllZHXWArticles() {
        return dao.listAllNewsForFrontEnd(1);
    }

    public List<NewsArticle> getAllDTSYArticles() {
        return dao.listAllNewsForFrontEnd(2);
    }

    public List<NewsArticle> getAllXMJXArticles() {
        return dao.listAllNewsForFrontEnd(3);
    }

    public List<NewsArticle> getAllArticles() {
        return dao.listAllNewsForFrontEnd(0);
    }


}
