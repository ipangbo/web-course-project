package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import com.alibaba.fastjson.JSON;

public class QuerySingleNoticeAPIService {
    public String querySingleNotice(int aid) {
        NoticeDao dao = new NoticeDaoImpl();

        String jsonOutput = JSON.toJSONString(dao.querySingleNotice(aid));
        return jsonOutput;
    }
}
