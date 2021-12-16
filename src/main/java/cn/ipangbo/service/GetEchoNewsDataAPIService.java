package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import com.alibaba.fastjson.JSON;

import java.util.List;

public class GetEchoNewsDataAPIService {
    public String getEchoData(int aid) {
        NewsDao dao = new NewsDaoImpl();

        List<String> resList = dao.getEchoNewsAPIData(aid);

        String jsonOutput = JSON.toJSONString(resList);
        return jsonOutput;
    }
}
