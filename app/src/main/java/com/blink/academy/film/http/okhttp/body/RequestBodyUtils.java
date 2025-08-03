package com.blink.academy.film.http.okhttp.body;

import defpackage.AbstractC2613;
import defpackage.C2314;
import defpackage.i5;
import java.io.IOException;
import java.io.InputStream;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/* loaded from: classes.dex */
public class RequestBodyUtils {

    /* renamed from: com.blink.academy.film.http.okhttp.body.RequestBodyUtils$Ϳ, reason: contains not printable characters */
    public class C0366 extends AbstractC2613 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C2314 f911;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ InputStream f912;

        public C0366(C2314 c2314, InputStream inputStream) {
            this.f911 = c2314;
            this.f912 = inputStream;
        }

        @Override // defpackage.AbstractC2613
        public long contentLength() {
            try {
                return this.f912.available();
            } catch (IOException unused) {
                return 0L;
            }
        }

        @Override // defpackage.AbstractC2613
        public C2314 contentType() {
            return this.f911;
        }

        @Override // defpackage.AbstractC2613
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Source source = null;
            try {
                source = Okio.source(this.f912);
                bufferedSink.writeAll(source);
            } finally {
                i5.m6240(source);
            }
        }
    }

    public static AbstractC2613 create(C2314 c2314, InputStream inputStream) {
        return new C0366(c2314, inputStream);
    }
}
