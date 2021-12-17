package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import com.alibaba.fastjson.JSONObject;

public class DeleteNoticeAPIService {
    public int deleteNotice(String json) {
//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        int aid = jb.getIntValue("aid");

        NoticeDao dao = new NoticeDaoImpl();
        return dao.deleteNotice(aid);
    }
}
