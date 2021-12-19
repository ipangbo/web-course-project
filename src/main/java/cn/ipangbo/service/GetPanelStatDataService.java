package cn.ipangbo.service;

import cn.ipangbo.dao.NewsDao;
import cn.ipangbo.dao.NewsDaoImpl;
import cn.ipangbo.dao.NoticeDao;
import cn.ipangbo.dao.NoticeDaoImpl;
import cn.ipangbo.entity.PanelStatData;
import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetPanelStatDataService {
    private NewsDao newsDao = new NewsDaoImpl();
    private NoticeDao noticeDao = new NoticeDaoImpl();

    public int getPanelNewsCount() {
        return newsDao.getNewsCount();
    }

    public Date getPanelNewsLastTime() {
        return newsDao.getNewsLastTime();
    }

    public int getPanelNoticeCount() {
        return noticeDao.getNoticeCount();
    }

    public Date getPanelNoticeLastTime() {
        return noticeDao.getNoticeLastTime();
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

        data = new PanelStatData();
        data.setIcon("notifications");
        data.setName("公告总数");
        data.setCount(getPanelNoticeCount());
        data.setLastDate(sd.format(getPanelNoticeLastTime()));

        res.add(data);

        String jsonOutput = JSON.toJSONString(res);
        return jsonOutput;
    }
}
