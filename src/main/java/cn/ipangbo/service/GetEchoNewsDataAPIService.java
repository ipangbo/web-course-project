package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetEchoNewsDataAPIService {
    public String getEchoData(int aid) {
        NewsDao dao = new NewsDaoImpl();

        List<String> resList = dao.getEchoNewsAPIData(aid);

        String jsonOutput = JSON.toJSONString(resList);
        return jsonOutput;
    }
}
