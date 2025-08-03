package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpConnectionImpl23 implements HttpConnection {
    private HttpURLConnection a;

    public HttpConnectionImpl23(HttpURLConnection httpURLConnection) {
        this.a = httpURLConnection;
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getErrorStream() throws IOException {
        return this.a.getErrorStream();
    }

    @Override // com.mob.tools.network.HttpConnection
    public Map<String, List<String>> getHeaderFields() throws IOException {
        return this.a.getHeaderFields();
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getInputStream() throws IOException {
        return this.a.getInputStream();
    }

    @Override // com.mob.tools.network.HttpConnection
    public int getResponseCode() throws IOException {
        return this.a.getResponseCode();
    }
}
