package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import cn.ipangbo.entity.NoticeArticle;

public class GetNoticeDetailService {
    public NoticeArticle getNoticeDetailService(int aid) {
        NoticeDao dao = new NoticeDaoImpl();
        return dao.getNoticeDetail(aid);
    }
}
