package cn.ipangbo.service;

import cn.ipangbo.entity.PanelStatData;
import cn.ipangbo.utils.DataSourceUtils;
import com.alibaba.fastjson.JSON;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public String getPanelStatData() {
        List<PanelStatData> res = new ArrayList<>();
        PanelStatData data = null;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        data = new PanelStatData();
        data.setIcon("fiber_new");
        data.setName("新闻总数");
        data.setCount(getPanelNewsCount());
        data.setLastDate(sd.format(getPanelNewsLastTime()));

        res.add(data);

        String jsonOutput = JSON.toJSONString(res);
        return  jsonOutput;
    }
}
