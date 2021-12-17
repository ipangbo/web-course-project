package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import cn.ipangbo.entity.NoticeArticle;
import com.alibaba.fastjson.JSONObject;

public class SubmitNoticeArticleModifyService {
    public int submitArticleModify(String json) {
//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        int aid = jb.getIntValue("aid");
        String articleTitle = jb.getString("article-title");
        String articleAuthor = jb.getString("article-author");
        String articleContentJSON = jb.getString("article-content-json");
        String articleContentHTML = jb.getString("article-content-html");
        String articleAbstractJSON = jb.getString("article-abstract-json");
        String articleAbstractHTML = jb.getString("article-abstract-html");

        NoticeArticle news = new NoticeArticle();
        news.setAid(aid);
        news.setaTitle(articleTitle);
        news.setaAuthor(articleAuthor);
        news.setaContentJSON(articleContentJSON);
        news.setaContentHTML(articleContentHTML);
        news.setaAbstractJSON(articleAbstractJSON);
        news.setaAbstractHTML(articleAbstractHTML);

        NoticeDao dao = new NoticeDaoImpl();
        return dao.submitNoticeArticleModify(news);
    }
}
