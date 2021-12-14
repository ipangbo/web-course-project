package cn.ipangbo.service;

import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteNewsAPIService {
    public int deleteNews(String json) {
//        处理json
        JSONObject jb = JSONObject.parseObject(json);
        int aid = jb.getIntValue("aid");
//        存入数据库
        String sql = "DELETE FROM NEWS WHERE AID = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
