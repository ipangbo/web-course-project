package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import com.alibaba.fastjson.JSON;

import java.util.List;

public class GetEchoNoticeDataAPIService {
    public String getEchoData(int aid) {
        NoticeDao dao = new NoticeDaoImpl();

        List<String> resList = dao.getEchoNoticeAPIData(aid);

        String jsonOutput = JSON.toJSONString(resList);
        return jsonOutput;
    }
}
