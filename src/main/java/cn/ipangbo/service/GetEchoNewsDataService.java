package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.entity.NewsArticle;
import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEchoNewsDataService {
    public NewsArticle getEchoNews(int aid) {
        // 请求回显有关的所有数据，传递给视图editorecho.jsp
        // 然而，json相关需要单独的接口
        // 使用前后端分离重构项目时会全部整合在一个接口中
        NewsDao dao = new NewsDaoImpl();
        return dao.getEchoNewsData(aid);
    }
}
