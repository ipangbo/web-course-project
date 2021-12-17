package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import com.alibaba.fastjson.JSON;


public class ListAllNoticeForBackEndService {
    public String listAllNotice() {
        NoticeDao dao = new NoticeDaoImpl();

        String jsonOutput = JSON.toJSONString(dao.listAllNoticeForBackEnd());

        return jsonOutput;
    }
}
