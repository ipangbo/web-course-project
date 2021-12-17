package cn.ipangbo.service;

import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import com.alibaba.fastjson.JSONObject;


public class ModifyNoticeCategoryAPIService {
    public int modifyNoticeCategory(String json) {
//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        int aid = jb.getIntValue("aid");
        int newcategory = jb.getIntValue("newcategory");

        NoticeDao dao = new NoticeDaoImpl();
        return dao.modifyNoticeCategory(aid, newcategory);
    }
}
