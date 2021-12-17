package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import cn.ipangbo.entity.NoticeArticle;

import java.util.List;

public class NoticeService {
    private NoticeDao dao = new NoticeDaoImpl();

    public List<NoticeArticle> getAllZHXWArticles() {
        return dao.listAllNoticeForFrontEnd(1);
    }

    public List<NoticeArticle> getAllDTSYArticles() {
        return dao.listAllNoticeForFrontEnd(2);
    }

    public List<NoticeArticle> getAllXMJXArticles() {
        return dao.listAllNoticeForFrontEnd(3);
    }

    public List<NoticeArticle> getAllArticles() {
        return dao.listAllNoticeForFrontEnd(0);
    }


}
