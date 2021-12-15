package cn.ipangbo.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class PanelStatData {
    @JSONField(name = "icon")
    private String icon;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "count")
    private int count;
    @JSONField(name = "last-date")
    private String lastDate;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
}
