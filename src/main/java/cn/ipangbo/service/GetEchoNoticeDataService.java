package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import cn.ipangbo.entity.NoticeArticle;

public class GetEchoNoticeDataService {
    public NoticeArticle getEchoNotice(int aid) {
        // 请求回显有关的所有数据，传递给视图editorecho.jsp
        // 然而，json相关需要单独的接口
        // 使用前后端分离重构项目时会全部整合在一个接口中
        NoticeDao dao = new NoticeDaoImpl();
        return dao.getEchoNoticeData(aid);
    }
}
