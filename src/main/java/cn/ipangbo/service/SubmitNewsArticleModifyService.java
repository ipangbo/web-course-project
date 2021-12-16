package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubmitNewsArticleModifyService {
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

        NewsArticle news = new NewsArticle();
        news.setAid(aid);
        news.setaTitle(articleTitle);
        news.setaAuthor(articleAuthor);
        news.setaContentJSON(articleContentJSON);
        news.setaContentHTML(articleContentHTML);
        news.setaAbstractJSON(articleAbstractJSON);
        news.setaAbstractHTML(articleAbstractHTML);

        NewsDao dao = new NewsDaoImpl();
        return dao.submitNewsArticleModify(news);
    }
}
