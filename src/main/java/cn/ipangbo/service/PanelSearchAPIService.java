package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class PanelSearchAPIService {
    public String search(String json) {
        // 本方法返回所有符合条件的对象的列表的json字符串

        // 处理json
        JSONObject jb = JSONObject.parseObject(json);
        String key = jb.getString("search-key");
        int category = jb.getIntValue("category");
        boolean isSearchTitleOnly = jb.getBooleanValue("is-search-title-only");

        NewsDao dao = new NewsDaoImpl();
        String jsonOutput = JSON.toJSONString(dao.search(category, key, isSearchTitleOnly));
        return jsonOutput;
    }
}
