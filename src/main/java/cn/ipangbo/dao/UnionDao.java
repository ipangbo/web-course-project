package cn.ipangbo.dao;

import cn.ipangbo.entity.Article;
import cn.ipangbo.entity.NewsArticle;

import java.util.List;

public interface UnionDao {
    public List<Article> search(int from, String key, boolean isSearchTitleOnly);
}
