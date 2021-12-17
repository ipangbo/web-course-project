package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import cn.ipangbo.entity.NoticeArticle;
import com.alibaba.fastjson.JSONObject;

public class AddNoticeService {
    public int addNotice(String json) {
//        添加新闻的服务，成功返回0， 失败返回1
//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        String articleTitle = jb.getString("article-title");
        String articleAuthor = jb.getString("article-author");
        String articleContentJSON = jb.getString("article-content-json");
        String articleContentHTML = jb.getString("article-content-html");
        String articleAbstractJSON = jb.getString("article-abstract-json");
        String articleAbstractHTML = jb.getString("article-abstract-html");

        NoticeArticle notice = new NoticeArticle();
        notice.setaTitle(articleTitle);
        notice.setaAuthor(articleAuthor);
        notice.setaContentJSON(articleContentJSON);
        notice.setaContentHTML(articleContentHTML);
        notice.setaAbstractJSON(articleAbstractJSON);
        notice.setaAbstractHTML(articleAbstractHTML);

        NoticeDao dao = new NoticeDaoImpl();
        return dao.addNotice(notice);
    }
}
