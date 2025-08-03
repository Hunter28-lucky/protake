package com.blink.academy.film.netbean.store;

/* loaded from: classes.dex */
public class PreviewBean {
    private String ave;
    private String desc_cn;
    private String desc_en;
    private int height;
    private String url;
    private int width;

    public String getAve() {
        return this.ave;
    }

    public String getDesc_cn() {
        return this.desc_cn;
    }

    public String getDesc_en() {
        return this.desc_en;
    }

    public int getHeight() {
        return this.height;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public PreviewBean setAve(String str) {
        this.ave = str;
        return this;
    }

    public PreviewBean setDesc_cn(String str) {
        this.desc_cn = str;
        return this;
    }

    public PreviewBean setDesc_en(String str) {
        this.desc_en = str;
        return this;
    }

    public PreviewBean setHeight(int i) {
        this.height = i;
        return this;
    }

    public PreviewBean setUrl(String str) {
        this.url = str;
        return this;
    }

    public PreviewBean setWidth(int i) {
        this.width = i;
        return this;
    }
}
