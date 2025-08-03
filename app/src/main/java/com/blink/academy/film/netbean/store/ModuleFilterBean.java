package com.blink.academy.film.netbean.store;

/* loaded from: classes.dex */
public class ModuleFilterBean {
    private String download_url;
    private String file_hash;
    private int file_id;
    private int file_size;
    private int maximum_client_version;
    private int minimum_client_version;
    private String name;
    private int updated_at;
    private int version_id;

    public String getDownload_url() {
        return this.download_url;
    }

    public String getFile_hash() {
        return this.file_hash;
    }

    public int getFile_id() {
        return this.file_id;
    }

    public int getFile_size() {
        return this.file_size;
    }

    public int getMaximum_client_version() {
        return this.maximum_client_version;
    }

    public int getMinimum_client_version() {
        return this.minimum_client_version;
    }

    public String getName() {
        return this.name;
    }

    public int getUpdated_at() {
        return this.updated_at;
    }

    public int getVersion_id() {
        return this.version_id;
    }

    public ModuleFilterBean setDownload_url(String str) {
        this.download_url = str;
        return this;
    }

    public ModuleFilterBean setFile_hash(String str) {
        this.file_hash = str;
        return this;
    }

    public ModuleFilterBean setFile_id(int i) {
        this.file_id = i;
        return this;
    }

    public ModuleFilterBean setFile_size(int i) {
        this.file_size = i;
        return this;
    }

    public ModuleFilterBean setMaximum_client_version(int i) {
        this.maximum_client_version = i;
        return this;
    }

    public ModuleFilterBean setMinimum_client_version(int i) {
        this.minimum_client_version = i;
        return this;
    }

    public ModuleFilterBean setName(String str) {
        this.name = str;
        return this;
    }

    public ModuleFilterBean setUpdated_at(int i) {
        this.updated_at = i;
        return this;
    }

    public ModuleFilterBean setVersion_id(int i) {
        this.version_id = i;
        return this;
    }
}
