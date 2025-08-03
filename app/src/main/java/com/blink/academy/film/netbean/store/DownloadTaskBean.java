package com.blink.academy.film.netbean.store;

/* loaded from: classes.dex */
public class DownloadTaskBean {
    private String download_token;
    private String download_token_timeout;
    private String download_url;
    private long endMS;
    private long file_size;
    private String hashStr;
    private int id;
    private int retryCount;
    private long startMS;
    private int version_id;

    public String getDownload_token() {
        return this.download_token;
    }

    public String getDownload_token_timeout() {
        return this.download_token_timeout;
    }

    public String getDownload_url() {
        return this.download_url;
    }

    public long getEndMS() {
        return this.endMS;
    }

    public long getFile_size() {
        return this.file_size;
    }

    public String getHashStr() {
        return this.hashStr;
    }

    public int getId() {
        return this.id;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public long getStartMS() {
        return this.startMS;
    }

    public int getVersion_id() {
        return this.version_id;
    }

    public DownloadTaskBean setDownload_token(String str) {
        this.download_token = str;
        return this;
    }

    public DownloadTaskBean setDownload_token_timeout(String str) {
        this.download_token_timeout = str;
        return this;
    }

    public DownloadTaskBean setDownload_url(String str) {
        this.download_url = str;
        return this;
    }

    public DownloadTaskBean setEndMS(long j) {
        this.endMS = j;
        return this;
    }

    public DownloadTaskBean setFile_size(long j) {
        this.file_size = j;
        return this;
    }

    public DownloadTaskBean setHashStr(String str) {
        this.hashStr = str;
        return this;
    }

    public DownloadTaskBean setId(int i) {
        this.id = i;
        return this;
    }

    public DownloadTaskBean setRetryCount(int i) {
        this.retryCount = i;
        return this;
    }

    public DownloadTaskBean setStartMS(long j) {
        this.startMS = j;
        return this;
    }

    public DownloadTaskBean setVersion_id(int i) {
        this.version_id = i;
        return this;
    }
}
