package com.blink.academy.film.http.okhttp.request;

import com.blink.academy.film.http.okhttp.body.ProgressResponseCallBack;
import com.blink.academy.film.http.okhttp.body.RequestBodyUtils;
import com.blink.academy.film.http.okhttp.body.UploadProgressRequestBody;
import com.blink.academy.film.http.okhttp.model.HttpParams;
import com.blink.academy.film.http.okhttp.request.BaseBodyRequest;
import com.blink.academy.film.http.okhttp.utils.Utils;
import defpackage.AbstractC2613;
import defpackage.AbstractC4262;
import defpackage.AbstractC4809;
import defpackage.C2314;
import defpackage.C3577;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;

/* loaded from: classes.dex */
public abstract class BaseBodyRequest<R extends BaseBodyRequest> extends BaseRequest<R> {
    public byte[] bs;
    private UploadType currentUploadType;
    public String json;
    public C2314 mediaType;
    public Object object;
    public AbstractC2613 requestBody;
    public String string;

    public enum UploadType {
        PART,
        BODY
    }

    public BaseBodyRequest(String str) {
        super(str);
        this.currentUploadType = UploadType.PART;
    }

    private C3577.C3580 addFile(String str, HttpParams.FileWrapper fileWrapper) {
        AbstractC2613 requestBody = getRequestBody(fileWrapper);
        Utils.checkNotNull(requestBody, "requestBody==null fileWrapper.file must is File/InputStream/byte[]");
        if (fileWrapper.responseCallBack == null) {
            return C3577.C3580.m11600(str, fileWrapper.fileName, requestBody);
        }
        return C3577.C3580.m11600(str, fileWrapper.fileName, new UploadProgressRequestBody(requestBody, fileWrapper.responseCallBack));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AbstractC2613 getRequestBody(HttpParams.FileWrapper fileWrapper) {
        T t = fileWrapper.file;
        if (t instanceof File) {
            return AbstractC2613.create(fileWrapper.contentType, (File) t);
        }
        if (t instanceof InputStream) {
            return RequestBodyUtils.create(fileWrapper.contentType, (InputStream) t);
        }
        if (t instanceof byte[]) {
            return AbstractC2613.create(fileWrapper.contentType, (byte[]) t);
        }
        return null;
    }

    public R addFileParams(String str, List<File> list, ProgressResponseCallBack progressResponseCallBack) {
        this.params.putFileParams(str, list, progressResponseCallBack);
        return this;
    }

    public R addFileWrapperParams(String str, List<HttpParams.FileWrapper> list) {
        this.params.putFileWrapperParams(str, list);
        return this;
    }

    @Override // com.blink.academy.film.http.okhttp.request.BaseRequest
    public AbstractC4262<AbstractC4809> generateRequest() {
        AbstractC2613 abstractC2613 = this.requestBody;
        if (abstractC2613 != null) {
            return this.apiManager.postBody(this.url, abstractC2613);
        }
        if (this.json != null) {
            return this.apiManager.postJson(this.url, AbstractC2613.create(C2314.m8683("application/json; charset=utf-8"), this.json));
        }
        Object obj = this.object;
        if (obj != null) {
            return this.apiManager.postBody(this.url, obj);
        }
        String str = this.string;
        if (str != null) {
            return this.apiManager.postBody(this.url, AbstractC2613.create(this.mediaType, str));
        }
        if (this.bs != null) {
            return this.apiManager.postBody(this.url, AbstractC2613.create(C2314.m8683("application/octet-stream"), this.bs));
        }
        return this.params.fileParamsMap.isEmpty() ? this.apiManager.post(this.url, this.params.urlParamsMap) : this.currentUploadType == UploadType.PART ? uploadFilesWithParts() : uploadFilesWithBodys();
    }

    public R params(String str, File file, ProgressResponseCallBack progressResponseCallBack) {
        this.params.put(str, file, progressResponseCallBack);
        return this;
    }

    public R requestBody(AbstractC2613 abstractC2613) {
        this.requestBody = abstractC2613;
        return this;
    }

    public R upBytes(byte[] bArr) {
        this.bs = bArr;
        return this;
    }

    public R upJson(String str) {
        this.json = str;
        return this;
    }

    public R upObject(@Body Object obj) {
        this.object = obj;
        return this;
    }

    public R upString(String str) {
        this.string = str;
        this.mediaType = C2314.m8683("text/plain");
        return this;
    }

    public AbstractC4262<AbstractC4809> uploadFilesWithBodys() {
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : this.params.urlParamsMap.entrySet()) {
            map.put(entry.getKey(), AbstractC2613.create(C2314.m8683("text/plain"), entry.getValue()));
        }
        for (Map.Entry<String, List<HttpParams.FileWrapper>> entry2 : this.params.fileParamsMap.entrySet()) {
            for (HttpParams.FileWrapper fileWrapper : entry2.getValue()) {
                map.put(entry2.getKey(), new UploadProgressRequestBody(getRequestBody(fileWrapper), fileWrapper.responseCallBack));
            }
        }
        return this.apiManager.uploadFiles(this.url, map);
    }

    public AbstractC4262<AbstractC4809> uploadFilesWithParts() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.params.urlParamsMap.entrySet()) {
            arrayList.add(C3577.C3580.m11599(entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<String, List<HttpParams.FileWrapper>> entry2 : this.params.fileParamsMap.entrySet()) {
            Iterator<HttpParams.FileWrapper> it = entry2.getValue().iterator();
            while (it.hasNext()) {
                arrayList.add(addFile(entry2.getKey(), it.next()));
            }
        }
        return this.apiManager.uploadFiles(this.url, arrayList);
    }

    public <T> R uploadType(UploadType uploadType) {
        this.currentUploadType = uploadType;
        return this;
    }

    public R params(String str, InputStream inputStream, String str2, ProgressResponseCallBack progressResponseCallBack) {
        this.params.put(str, (String) inputStream, str2, progressResponseCallBack);
        return this;
    }

    public R params(String str, byte[] bArr, String str2, ProgressResponseCallBack progressResponseCallBack) {
        this.params.put(str, bArr, str2, progressResponseCallBack);
        return this;
    }

    public R upString(String str, String str2) {
        this.string = str;
        Utils.checkNotNull(str2, "mediaType==null");
        this.mediaType = C2314.m8683(str2);
        return this;
    }

    public R params(String str, File file, String str2, ProgressResponseCallBack progressResponseCallBack) {
        this.params.put(str, (String) file, str2, progressResponseCallBack);
        return this;
    }

    public <T> R params(String str, T t, String str2, C2314 c2314, ProgressResponseCallBack progressResponseCallBack) {
        this.params.put(str, t, str2, c2314, progressResponseCallBack);
        return this;
    }
}
