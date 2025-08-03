package com.blink.academy.film.http.okhttp.model;

import com.blink.academy.film.http.okhttp.body.ProgressResponseCallBack;
import defpackage.C2314;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpParams implements Serializable {
    public LinkedHashMap<String, List<FileWrapper>> fileParamsMap;
    public LinkedHashMap<String, String> urlParamsMap;

    public static class FileWrapper<T> {
        public C2314 contentType;
        public T file;
        public String fileName;
        public long fileSize;
        public ProgressResponseCallBack responseCallBack;

        /* JADX WARN: Multi-variable type inference failed */
        public FileWrapper(T t, String str, C2314 c2314, ProgressResponseCallBack progressResponseCallBack) {
            this.file = t;
            this.fileName = str;
            this.contentType = c2314;
            if (t instanceof File) {
                this.fileSize = ((File) t).length();
            } else if (t instanceof byte[]) {
                this.fileSize = ((byte[]) t).length;
            }
            this.responseCallBack = progressResponseCallBack;
        }

        public String toString() {
            return "FileWrapper{countent=" + this.file + ", fileName='" + this.fileName + ", contentType=" + this.contentType + ", fileSize=" + this.fileSize + '}';
        }
    }

    public HttpParams() {
        init();
    }

    private C2314 guessMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.replace("#", ""));
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return C2314.m8683(contentTypeFor);
    }

    private void init() {
        this.urlParamsMap = new LinkedHashMap<>();
        this.fileParamsMap = new LinkedHashMap<>();
    }

    public void clear() {
        this.urlParamsMap.clear();
        this.fileParamsMap.clear();
    }

    public void put(HttpParams httpParams) {
        if (httpParams != null) {
            LinkedHashMap<String, String> linkedHashMap = httpParams.urlParamsMap;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                this.urlParamsMap.putAll(httpParams.urlParamsMap);
            }
            LinkedHashMap<String, List<FileWrapper>> linkedHashMap2 = httpParams.fileParamsMap;
            if (linkedHashMap2 == null || linkedHashMap2.isEmpty()) {
                return;
            }
            this.fileParamsMap.putAll(httpParams.fileParamsMap);
        }
    }

    public <T extends File> void putFileParams(String str, List<T> list, ProgressResponseCallBack progressResponseCallBack) {
        if (str == null || list == null || list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            put(str, it.next(), progressResponseCallBack);
        }
    }

    public void putFileWrapperParams(String str, List<FileWrapper> list) {
        if (str == null || list == null || list.isEmpty()) {
            return;
        }
        Iterator<FileWrapper> it = list.iterator();
        while (it.hasNext()) {
            put(str, it.next());
        }
    }

    public void remove(String str) {
        removeUrl(str);
        removeFile(str);
    }

    public void removeFile(String str) {
        this.fileParamsMap.remove(str);
    }

    public void removeUrl(String str) {
        this.urlParamsMap.remove(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.urlParamsMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, List<FileWrapper>> entry2 : this.fileParamsMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append(entry2.getValue());
        }
        return sb.toString();
    }

    public HttpParams(String str, String str2) {
        init();
        put(str, str2);
    }

    public void put(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.urlParamsMap.putAll(map);
    }

    public void put(String str, String str2) {
        this.urlParamsMap.put(str, str2);
    }

    public <T extends File> void put(String str, T t, ProgressResponseCallBack progressResponseCallBack) {
        put(str, (String) t, t.getName(), progressResponseCallBack);
    }

    public <T extends File> void put(String str, T t, String str2, ProgressResponseCallBack progressResponseCallBack) {
        put(str, t, str2, guessMimeType(str2), progressResponseCallBack);
    }

    public <T extends InputStream> void put(String str, T t, String str2, ProgressResponseCallBack progressResponseCallBack) {
        put(str, t, str2, guessMimeType(str2), progressResponseCallBack);
    }

    public void put(String str, byte[] bArr, String str2, ProgressResponseCallBack progressResponseCallBack) {
        put(str, bArr, str2, guessMimeType(str2), progressResponseCallBack);
    }

    public void put(String str, FileWrapper fileWrapper) {
        if (str == null || fileWrapper == null) {
            return;
        }
        put(str, fileWrapper.file, fileWrapper.fileName, fileWrapper.contentType, fileWrapper.responseCallBack);
    }

    public <T> void put(String str, T t, String str2, C2314 c2314, ProgressResponseCallBack progressResponseCallBack) {
        if (str != null) {
            List<FileWrapper> arrayList = this.fileParamsMap.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.fileParamsMap.put(str, arrayList);
            }
            arrayList.add(new FileWrapper(t, str2, c2314, progressResponseCallBack));
        }
    }
}
