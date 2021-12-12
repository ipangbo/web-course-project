package cn.ipangbo.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class NewsArticle {
    @JSONField(name = "id")
    private int aid;
    @JSONField(name = "title")
    private String aTitle;
    @JSONField(name = "author")
    private String aAuthor;
    @JSONField(name = "content-json")
    private String aContentJSON;
    @JSONField(name = "content-html")
    private String aContentHTML;
    @JSONField(name = "abstract-json")
    private String aAbstractJSON;
    @JSONField(name = "abstract-html")
    private String aAbstractHTML;
    @JSONField(name = "category")
    private int aCategory;
    @JSONField(name = "create-time", format = "yyyy-MM-dd")
    private Date aCreateTime;
    @JSONField(name = "modify-time", format = "yyyy-MM-dd")
    private Date aModifyTime;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getaAuthor() {
        return aAuthor;
    }

    public void setaAuthor(String aAuthor) {
        this.aAuthor = aAuthor;
    }

    public String getaContentJSON() {
        return aContentJSON;
    }

    public void setaContentJSON(String aContentJSON) {
        this.aContentJSON = aContentJSON;
    }

    public String getaContentHTML() {
        return aContentHTML;
    }

    public void setaContentHTML(String aContentHTML) {
        this.aContentHTML = aContentHTML;
    }

    public String getaAbstractJSON() {
        return aAbstractJSON;
    }

    public void setaAbstractJSON(String aAbstractJSON) {
        this.aAbstractJSON = aAbstractJSON;
    }

    public String getaAbstractHTML() {
        return aAbstractHTML;
    }

    public void setaAbstractHTML(String aAbstractHTML) {
        this.aAbstractHTML = aAbstractHTML;
    }

    public int getaCategory() {
        return aCategory;
    }

    public void setaCategory(int aCategory) {
        this.aCategory = aCategory;
    }

    public Date getaCreateTime() {
        return aCreateTime;
    }

    public void setaCreateTime(Date aCreateTime) {
        this.aCreateTime = aCreateTime;
    }

    public Date getaModifyTime() {
        return aModifyTime;
    }

    public void setaModifyTime(Date aModifyTime) {
        this.aModifyTime = aModifyTime;
    }
}
