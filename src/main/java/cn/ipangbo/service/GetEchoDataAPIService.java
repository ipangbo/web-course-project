package cn.ipangbo.service;

import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetEchoDataAPIService {
    public String getEchoData(int aid) {
        List<String> resList = new ArrayList<>();
        String sql = "SELECT ACONTENTJSON, AABSTRACTJSON FROM NEWS WHERE AID IN (?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, aid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    resList.add(rs.getString(1));
                    resList.add(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String jsonOutput = JSON.toJSONString(resList);
        return jsonOutput;
    }
}
