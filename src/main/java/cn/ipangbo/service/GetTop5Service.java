package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.entity.NoticeArticle;

import java.util.List;

public class GetTop5Service {
    public List<NewsArticle> getTop5News() {
        NewsDao dao = new NewsDaoImpl();
        return dao.getTop5News();
    }

    public List<NoticeArticle> getTop5Notice() {
        NoticeDao dao = new NoticeDaoImpl();
        return dao.getTop5Notice();
    }
}
