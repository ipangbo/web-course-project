package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import com.alibaba.fastjson.JSON;

public class QuerySingleNewsAPIService {
    public String querySingleNews(int aid) {
        NewsDao dao = new NewsDaoImpl();

        String jsonOutput = JSON.toJSONString(dao.querySingleNews(aid));
        return jsonOutput;
    }
}
