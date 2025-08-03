package com.blink.academy.film.netbean.store;

/* loaded from: classes.dex */
public class FilterGroupBean {
    private String description_cn;
    private String description_en;
    private String description_ja;
    private String description_kr;
    private String description_th;
    private String description_zht;
    private int[] filters;
    private int id;
    private String name_cn;
    private String name_en;
    private String name_ja;
    private String name_kr;
    private String name_th;
    private String name_zht;
    private int[] preview_filters;
    private boolean purchase_required;

    public String getDescription_cn() {
        return this.description_cn;
    }

    public String getDescription_en() {
        return this.description_en;
    }

    public String getDescription_ja() {
        return this.description_ja;
    }

    public String getDescription_kr() {
        return this.description_kr;
    }

    public String getDescription_th() {
        return this.description_th;
    }

    public String getDescription_zht() {
        return this.description_zht;
    }

    public int[] getFilters() {
        return this.filters;
    }

    public int getId() {
        return this.id;
    }

    public String getName_cn() {
        return this.name_cn;
    }

    public String getName_en() {
        return this.name_en;
    }

    public String getName_ja() {
        return this.name_ja;
    }

    public String getName_kr() {
        return this.name_kr;
    }

    public String getName_th() {
        return this.name_th;
    }

    public String getName_zht() {
        return this.name_zht;
    }

    public int[] getPreview_filters() {
        return this.preview_filters;
    }

    public boolean isPurchase_required() {
        return this.purchase_required;
    }

    public FilterGroupBean setDescription_cn(String str) {
        this.description_cn = str;
        return this;
    }

    public FilterGroupBean setDescription_en(String str) {
        this.description_en = str;
        return this;
    }

    public FilterGroupBean setDescription_ja(String str) {
        this.description_ja = str;
        return this;
    }

    public FilterGroupBean setDescription_kr(String str) {
        this.description_kr = str;
        return this;
    }

    public FilterGroupBean setDescription_th(String str) {
        this.description_th = str;
        return this;
    }

    public FilterGroupBean setDescription_zht(String str) {
        this.description_zht = str;
        return this;
    }

    public FilterGroupBean setFilters(int[] iArr) {
        this.filters = iArr;
        return this;
    }

    public FilterGroupBean setId(int i) {
        this.id = i;
        return this;
    }

    public FilterGroupBean setName_cn(String str) {
        this.name_cn = str;
        return this;
    }

    public FilterGroupBean setName_en(String str) {
        this.name_en = str;
        return this;
    }

    public FilterGroupBean setName_ja(String str) {
        this.name_ja = str;
        return this;
    }

    public FilterGroupBean setName_kr(String str) {
        this.name_kr = str;
        return this;
    }

    public FilterGroupBean setName_th(String str) {
        this.name_th = str;
        return this;
    }

    public FilterGroupBean setName_zht(String str) {
        this.name_zht = str;
        return this;
    }

    public FilterGroupBean setPreview_filters(int[] iArr) {
        this.preview_filters = iArr;
        return this;
    }

    public FilterGroupBean setPurchase_required(boolean z) {
        this.purchase_required = z;
        return this;
    }
}
