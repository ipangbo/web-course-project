package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.entity.NewsArticle;
import com.alibaba.fastjson.JSONObject;

public class AddNewsService {
    public int addNews(String json) {
//        添加新闻的服务，成功返回0， 失败返回1
//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        String articleTitle = jb.getString("article-title");
        String articleAuthor = jb.getString("article-author");
        String articleContentJSON = jb.getString("article-content-json");
        String articleContentHTML = jb.getString("article-content-html");
        String articleAbstractJSON = jb.getString("article-abstract-json");
        String articleAbstractHTML = jb.getString("article-abstract-html");

        NewsArticle news = new NewsArticle();
        news.setaTitle(articleTitle);
        news.setaAuthor(articleAuthor);
        news.setaContentJSON(articleContentJSON);
        news.setaContentHTML(articleContentHTML);
        news.setaAbstractJSON(articleAbstractJSON);
        news.setaAbstractHTML(articleAbstractHTML);

        NewsDao dao = new NewsDaoImpl();
        return dao.addNews(news);
    }
}
