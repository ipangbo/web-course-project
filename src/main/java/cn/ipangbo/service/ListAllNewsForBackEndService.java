package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import com.alibaba.fastjson.JSON;


public class ListAllNewsForBackEndService {
    public String listAllNews() {
        NewsDao dao = new NewsDaoImpl();

        String jsonOutput = JSON.toJSONString(dao.listAllNewsForBackEnd());

        return jsonOutput;
    }
}
