package com.efs.sdk.net;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.efs.sdk.base.Constants;
import com.efs.sdk.net.a.a.e;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
import defpackage.AbstractC2613;
import defpackage.AbstractC4809;
import defpackage.C2314;
import defpackage.C4539;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import defpackage.InterfaceC5051;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterOutputStream;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes.dex */
public class OkHttpInterceptor implements InterfaceC2818 {
    private final f a = g.c();

    public static class a extends AbstractC4809 {
        private final AbstractC4809 a;
        private final BufferedSource b;

        public a(AbstractC4809 abstractC4809, InputStream inputStream) {
            this.a = abstractC4809;
            this.b = Okio.buffer(Okio.source(inputStream));
        }

        @Override // defpackage.AbstractC4809
        public final long contentLength() {
            return this.a.contentLength();
        }

        @Override // defpackage.AbstractC4809
        public final C2314 contentType() {
            return this.a.contentType();
        }

        @Override // defpackage.AbstractC4809
        public final BufferedSource source() {
            return this.b;
        }
    }

    public static class b implements f.a {
        private final String a;
        private final C4539 b;
        private h c;

        public b(String str, C4539 c4539, h hVar) {
            this.a = str;
            this.b = c4539;
            this.c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String a() {
            return this.a;
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b() {
            return this.b.m13925().toString();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String c() {
            return this.b.m13923();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final byte[] d() throws IOException {
            AbstractC2613 abstractC2613M13916 = this.b.m13916();
            if (abstractC2613M13916 == null) {
                return null;
            }
            h hVar = this.c;
            String strM13919 = this.b.m13919(HttpHeaders.HEAD_KEY_CONTENT_ENCODING);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.efs.sdk.net.a.a.a aVar = new com.efs.sdk.net.a.a.a(Constants.CP_GZIP.equals(strM13919) ? e.a(byteArrayOutputStream) : "deflate".equals(strM13919) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream);
            hVar.c = aVar;
            hVar.b = byteArrayOutputStream;
            BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(aVar));
            try {
                abstractC2613M13916.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                h hVar2 = this.c;
                hVar2.b();
                return hVar2.b.toByteArray();
            } catch (Throwable th) {
                bufferedSinkBuffer.close();
                throw th;
            }
        }
    }

    public static class c implements f.c {
        private final String a;
        private final C4539 b;
        private final C4770 c;
        private final InterfaceC5051 d;

        public c(String str, C4539 c4539, C4770 c4770, InterfaceC5051 interfaceC5051) {
            this.a = str;
            this.b = c4539;
            this.c = c4770;
            this.d = interfaceC5051;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final String a() {
            return this.a;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final int b() {
            return this.c.m14334();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:27:0x009d, B:33:0x00a8, B:35:0x00ae, B:36:0x00bb, B:38:0x00c1, B:40:0x00d1, B:42:0x00dc, B:44:0x00e0, B:45:0x00e4, B:47:0x00f7, B:48:0x010a, B:49:0x0111), top: B:54:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010a A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:27:0x009d, B:33:0x00a8, B:35:0x00ae, B:36:0x00bb, B:38:0x00c1, B:40:0x00d1, B:42:0x00dc, B:44:0x00e0, B:45:0x00e4, B:47:0x00f7, B:48:0x010a, B:49:0x0111), top: B:54:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // defpackage.InterfaceC2818
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public defpackage.C4770 intercept(defpackage.InterfaceC2818.InterfaceC2819 r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.net.OkHttpInterceptor.intercept(θ$Ϳ):අ");
    }
}
