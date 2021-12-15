package cn.ipangbo.service;

import cn.ipangbo.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class GetPanelStatDataService {
    public int getPanelNewsCount() {
        int newsCount = 0;
        String sql = "SELECT COUNT(*) FROM NEWS";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                newsCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsCount;
    }

    public Date getPanelNewsLastTime() {
        Date lastDate = new Date();
        String sql = "SELECT AMODIFYTIME FROM NEWS ORDER BY AID DESC LIMIT 1";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                lastDate = rs.getTimestamp(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastDate;
    }
}
