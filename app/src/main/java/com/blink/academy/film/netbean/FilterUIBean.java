package com.blink.academy.film.netbean;

import com.blink.academy.film.netbean.store.FilterBean;

/* loaded from: classes.dex */
public class FilterUIBean {
    private FilterBean filterBean;
    private String real_path;
    private String save_path;

    public FilterBean getFilterBean() {
        return this.filterBean;
    }

    public String getReal_path() {
        return this.real_path;
    }

    public String getSave_path() {
        return this.save_path;
    }

    public FilterUIBean setFilterBean(FilterBean filterBean) {
        this.filterBean = filterBean;
        return this;
    }

    public void setReal_path(String str) {
        this.real_path = str;
    }

    public FilterUIBean setSave_path(String str) {
        this.save_path = str;
        return this;
    }

    public String toString() {
        return "FilterUIBean{filterBean=" + this.filterBean + ", save_path='" + this.save_path + "', real_path='" + this.real_path + "'}";
    }
}
