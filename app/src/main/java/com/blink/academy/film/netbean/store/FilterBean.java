package com.blink.academy.film.netbean.store;

/* loaded from: classes.dex */
public class FilterBean {
    private int created_at;
    private String download_url;
    private String file_hash;
    private int file_id;
    private long file_size;
    private int id;
    private boolean is_bnw;
    private int maximum_client_version;
    private int minimum_client_version;
    private boolean strength_adjustable;
    private int type;
    private int updated_at;
    private int version_id;

    public int getCreated_at() {
        return this.created_at;
    }

    public String getDownload_url() {
        return this.download_url;
    }

    public String getFile_hash() {
        return this.file_hash;
    }

    public int getFile_id() {
        return this.file_id;
    }

    public long getFile_size() {
        return this.file_size;
    }

    public int getId() {
        return this.id;
    }

    public int getMaximum_client_version() {
        return this.maximum_client_version;
    }

    public int getMinimum_client_version() {
        return this.minimum_client_version;
    }

    public int getType() {
        return this.type;
    }

    public int getUpdated_at() {
        return this.updated_at;
    }

    public int getVersion_id() {
        return this.version_id;
    }

    public boolean isIs_bnw() {
        return this.is_bnw;
    }

    public boolean isStrength_adjustable() {
        return this.strength_adjustable;
    }

    public FilterBean setCreated_at(int i) {
        this.created_at = i;
        return this;
    }

    public FilterBean setDownload_url(String str) {
        this.download_url = str;
        return this;
    }

    public FilterBean setFile_hash(String str) {
        this.file_hash = str;
        return this;
    }

    public FilterBean setFile_id(int i) {
        this.file_id = i;
        return this;
    }

    public FilterBean setFile_size(long j) {
        this.file_size = j;
        return this;
    }

    public FilterBean setId(int i) {
        this.id = i;
        return this;
    }

    public FilterBean setIs_bnw(boolean z) {
        this.is_bnw = z;
        return this;
    }

    public FilterBean setMaximum_client_version(int i) {
        this.maximum_client_version = i;
        return this;
    }

    public FilterBean setMinimum_client_version(int i) {
        this.minimum_client_version = i;
        return this;
    }

    public FilterBean setStrength_adjustable(boolean z) {
        this.strength_adjustable = z;
        return this;
    }

    public FilterBean setType(int i) {
        this.type = i;
        return this;
    }

    public FilterBean setUpdated_at(int i) {
        this.updated_at = i;
        return this;
    }

    public FilterBean setVersion_id(int i) {
        this.version_id = i;
        return this;
    }

    public String toString() {
        return "FilterBean{id=" + this.id + ", version_id=" + this.version_id + ", file_id=" + this.file_id + ", minimum_client_version=" + this.minimum_client_version + ", maximum_client_version=" + this.maximum_client_version + ", download_url='" + this.download_url + "', file_size=" + this.file_size + ", file_hash='" + this.file_hash + "', created_at=" + this.created_at + ", updated_at=" + this.updated_at + ", is_bnw=" + this.is_bnw + ", type=" + this.type + ", strength_adjustable=" + this.strength_adjustable + '}';
    }
}
