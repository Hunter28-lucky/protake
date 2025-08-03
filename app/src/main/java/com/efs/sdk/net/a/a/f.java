package com.efs.sdk.net.a.a;

import java.io.InputStream;

/* loaded from: classes.dex */
public interface f {

    public interface a extends b {
        String b();

        String c();

        byte[] d();
    }

    public interface b {
        String a();
    }

    public interface c extends d {
    }

    public interface d {
        String a();

        int b();
    }

    InputStream a(String str, String str2, String str3, InputStream inputStream);

    void a();

    void a(a aVar);

    void a(c cVar);

    String b();
}
