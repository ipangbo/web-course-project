package cn.ipangbo.dao;

import cn.ipangbo.entity.NoticeArticle;

import java.util.Date;
import java.util.List;

public interface NoticeDao {
    // 向数据库中添加新闻，成功返回0
    public int addNotice(NoticeArticle news);

    // 删除新闻，成功返回0
    public int deleteNotice(int aid);

    // 用于回显数据，返回字符串的列表，第一项是content json，第二项是abstract json
    public List<String> getEchoNoticeAPIData(int aid);

    // 用于回显数据，返回新闻对象
    public NoticeArticle getEchoNoticeData(int aid);

    // 用于在新闻网前台中查询数据
    public NoticeArticle getNoticeDetail(int aid);

    // 用于在后台中查询新闻的数量
    public int getNoticeCount();

    // 用于在后台中查询新闻最后发表的时间
    public Date getNoticeLastTime();

    // 用于在管理后台中列出所有的新闻
    public List<NoticeArticle> listAllNoticeForBackEnd();

    // 用于在管理后台中更改新闻的类别，成功返回0
    public int modifyNoticeCategory(int aid, int category);

    // 用于在前台中列出所有的新闻
    public List<NoticeArticle> listAllNoticeForFrontEnd(int category);

    // 用于在后台搜索
    public List<NoticeArticle> search(int category, String key, boolean isSearchTitleOnly);

    // 获取单个新闻的全部信息
    public NoticeArticle querySingleNotice(int aid);

    // 提交对新闻的更改，成功返回0
    public int submitNoticeArticleModify(NoticeArticle news);

    // 在查询首页的前五条新闻
    public List<NoticeArticle> getTop5Notice();



}
