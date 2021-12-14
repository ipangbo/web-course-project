package cn.ipangbo.service;

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

//        存入数据库
        String sql = "UPDATE NEWS SET ACATEGORY = ? WHERE AID = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, newcategory);
            st.setInt(2, aid);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
