package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.entity.PanelStatData;
import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetPanelStatDataService {
    private NewsDao dao = new NewsDaoImpl();

    public int getPanelNewsCount() {
        return dao.getNewsCount();
    }

    public Date getPanelNewsLastTime() {
        return dao.getNewsLastTime();
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
