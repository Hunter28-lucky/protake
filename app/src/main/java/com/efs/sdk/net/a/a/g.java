package com.efs.sdk.net.a.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.a.a.f;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class g implements f {
    private static AtomicInteger a = new AtomicInteger(0);
    private static g c;
    private b b = new b();

    private g() {
    }

    public static g c() {
        if (c == null) {
            c = new g();
        }
        return c;
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.a aVar) {
        Log.d("NetTrace-Interceptor", "request will be sent");
        b bVar = this.b;
        try {
            String strA = aVar.a();
            bVar.a.put(aVar.a(), Long.valueOf(System.currentTimeMillis()));
            Log.i("NetTrace-Interceptor", "save request");
            com.efs.sdk.net.a.b bVarA = com.efs.sdk.net.a.a.a().a(strA);
            String strB = aVar.b();
            if (!TextUtils.isEmpty(strB)) {
                bVarA.d = strB;
            }
            bVarA.f17656e = aVar.c();
            bVarA.f = b.a(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final String b() {
        Log.d("NetTrace-Interceptor", "next request id");
        return String.valueOf(a.getAndIncrement());
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.c cVar) {
        Log.d("NetTrace-Interceptor", "response headers received");
        b bVar = this.b;
        Log.i("NetTrace-Interceptor", "save response");
        String strA = cVar.a();
        if (bVar.a != null) {
            com.efs.sdk.net.a.a.a().a(strA).g = cVar.b();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.d("NetTrace-Interceptor", "interpret response stream");
        return b.a(str, str2, str3, inputStream);
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a() {
        Log.d("NetTrace-Interceptor", "data sent");
    }
}
