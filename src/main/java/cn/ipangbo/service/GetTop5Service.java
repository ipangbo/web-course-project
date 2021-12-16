package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.entity.NewsArticle;

import java.util.List;

public class GetTop5Service {
    public List<NewsArticle> getTop5News() {
        NewsDao dao = new NewsDaoImpl();
        return dao.getTop5News();
    }
}
