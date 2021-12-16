package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyNewsCategoryAPIService {
    public int modifyNewsCategory(String json) {
//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        int aid = jb.getIntValue("aid");
        int newcategory = jb.getIntValue("newcategory");

        NewsDao dao = new NewsDaoImpl();
        return dao.modifyNewsCategory(aid, newcategory);
    }
}
