package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import com.alibaba.fastjson.JSONObject;

public class DeleteNewsAPIService {
    public int deleteNews(String json) {
//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        int aid = jb.getIntValue("aid");

        NewsDao dao = new NewsDaoImpl();
        return dao.deleteNews(aid);
    }
}
