package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.entity.NewsArticle;

public class GetNewsDetailService {
    public NewsArticle getNewsDetailService(int aid) {
        NewsDao dao = new NewsDaoImpl();
        return dao.getNewsDetail(aid);
    }
}
