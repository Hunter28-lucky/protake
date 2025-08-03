package defpackage;

import okio.BufferedSource;

/* compiled from: RealResponseBody.kt */
/* renamed from: ධ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4829 extends AbstractC4809 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String f16328;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f16329;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final BufferedSource f16330;

    public C4829(String str, long j, BufferedSource bufferedSource) {
        C3921.m12667(bufferedSource, "source");
        this.f16328 = str;
        this.f16329 = j;
        this.f16330 = bufferedSource;
    }

    @Override // defpackage.AbstractC4809
    public long contentLength() {
        return this.f16329;
    }

    @Override // defpackage.AbstractC4809
    public C2314 contentType() {
        String str = this.f16328;
        if (str != null) {
            return C2314.f8797.m8689(str);
        }
        return null;
    }

    @Override // defpackage.AbstractC4809
    public BufferedSource source() {
        return this.f16330;
    }
}
