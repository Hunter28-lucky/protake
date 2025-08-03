package com.blink.academy.film.netbean.store;

import java.util.Objects;

/* loaded from: classes.dex */
public class NvtProductItem {
    private long amount;
    private String google_id;
    private String ios_id;
    private String name_cn;
    private String name_cn_traditional;
    private String name_en;
    private String origin_price_cny;
    private String origin_price_usd;
    private String price_cny;
    private String price_usd;
    private String product_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NvtProductItem nvtProductItem = (NvtProductItem) obj;
        return this.amount == nvtProductItem.amount && Objects.equals(this.product_id, nvtProductItem.product_id) && Objects.equals(this.name_cn, nvtProductItem.name_cn) && Objects.equals(this.name_en, nvtProductItem.name_en) && Objects.equals(this.name_cn_traditional, nvtProductItem.name_cn_traditional) && Objects.equals(this.price_cny, nvtProductItem.price_cny) && Objects.equals(this.origin_price_cny, nvtProductItem.origin_price_cny) && Objects.equals(this.price_usd, nvtProductItem.price_usd) && Objects.equals(this.origin_price_usd, nvtProductItem.origin_price_usd) && Objects.equals(this.ios_id, nvtProductItem.ios_id) && Objects.equals(this.google_id, nvtProductItem.google_id);
    }

    public long getAmount() {
        return this.amount;
    }

    public String getGoogle_id() {
        return this.google_id;
    }

    public String getIos_id() {
        return this.ios_id;
    }

    public String getName_cn() {
        return this.name_cn;
    }

    public String getName_cn_traditional() {
        return this.name_cn_traditional;
    }

    public String getName_en() {
        return this.name_en;
    }

    public String getOrigin_price_cny() {
        return this.origin_price_cny;
    }

    public String getOrigin_price_usd() {
        return this.origin_price_usd;
    }

    public String getPrice_cny() {
        return this.price_cny;
    }

    public String getPrice_usd() {
        return this.price_usd;
    }

    public String getProduct_id() {
        return this.product_id;
    }

    public int hashCode() {
        return Objects.hash(this.product_id, this.name_cn, this.name_en, this.name_cn_traditional, this.price_cny, this.origin_price_cny, this.price_usd, this.origin_price_usd, this.ios_id, this.google_id, Long.valueOf(this.amount));
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setGoogle_id(String str) {
        this.google_id = str;
    }

    public void setIos_id(String str) {
        this.ios_id = str;
    }

    public void setName_cn(String str) {
        this.name_cn = str;
    }

    public void setName_cn_traditional(String str) {
        this.name_cn_traditional = str;
    }

    public void setName_en(String str) {
        this.name_en = str;
    }

    public void setOrigin_price_cny(String str) {
        this.origin_price_cny = str;
    }

    public void setOrigin_price_usd(String str) {
        this.origin_price_usd = str;
    }

    public void setPrice_cny(String str) {
        this.price_cny = str;
    }

    public void setPrice_usd(String str) {
        this.price_usd = str;
    }

    public void setProduct_id(String str) {
        this.product_id = str;
    }

    public String toString() {
        return "NvtProductItem{product_id='" + this.product_id + "', name_cn='" + this.name_cn + "', name_en='" + this.name_en + "', name_cn_traditional='" + this.name_cn_traditional + "', price_cny='" + this.price_cny + "', origin_price_cny='" + this.origin_price_cny + "', price_usd='" + this.price_usd + "', origin_price_usd='" + this.origin_price_usd + "', ios_id='" + this.ios_id + "', google_id='" + this.google_id + "', amount=" + this.amount + '}';
    }
}
