package cn.ipangbo.dao;

import cn.ipangbo.entity.NewsArticle;

import java.util.Date;
import java.util.List;

public interface NewsDao {
    // 向数据库中添加新闻，成功返回0
    public int addNews(NewsArticle news);

    // 删除新闻，成功返回0
    public int deleteNews(int aid);

    // 用于回显数据，返回字符串的列表，第一项是content json，第二项是abstract json
    public List<String> getEchoNewsAPIData(int aid);

    // 用于回显数据，返回新闻对象
    public NewsArticle getEchoNewsData(int aid);

    // 用于在新闻网前台中查询数据
    public NewsArticle getNewsDetail(int aid);

    // 用于在后台中查询新闻的数量
    public int getNewsCount();

    // 用于在后台中查询新闻最后发表的时间
    public Date getNewsLastTime();

    // 用于在管理后台中列出所有的新闻
    public List<NewsArticle> listAllNewsForBackEnd();

    // 用于在管理后台中更改新闻的类别，成功返回0
    public int modifyNewsCategory(int aid, int category);

    // 用于在前台中列出所有的新闻
    public List<NewsArticle> listAllNewsForFrontEnd(int category);

    // 获取单个新闻的全部信息
    public NewsArticle querySingleNews(int aid);

    // 提交对新闻的更改，成功返回0
    public int submitNewsArticleModify(NewsArticle news);

    // 在查询首页的前五条新闻
    public List<NewsArticle> getTop5News();



}
