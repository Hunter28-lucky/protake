package defpackage;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSink;
import okio.Okio;

/* compiled from: CallServerInterceptor.kt */
/* renamed from: າ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4998 implements InterfaceC2818 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean f16753;

    public C4998(boolean z) {
        this.f16753 = z;
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        C4770.C4771 c4771M10971;
        boolean z;
        C3921.m12667(interfaceC2819, "chain");
        C3739 c3739 = (C3739) interfaceC2819;
        C3282 c3282M11978 = c3739.m11978();
        if (c3282M11978 == null) {
            C3921.m12675();
        }
        C4539 c4539M11980 = c3739.m11980();
        AbstractC2613 abstractC2613M13916 = c4539M11980.m13916();
        long jCurrentTimeMillis = System.currentTimeMillis();
        c3282M11978.m10975(c4539M11980);
        if (!C3737.m11969(c4539M11980.m13923()) || abstractC2613M13916 == null) {
            c3282M11978.m10969();
            c4771M10971 = null;
            z = true;
        } else {
            if (e0.m5967("100-continue", c4539M11980.m13919("Expect"), true)) {
                c3282M11978.m10961();
                c4771M10971 = c3282M11978.m10971(true);
                c3282M11978.m10973();
                z = false;
            } else {
                c4771M10971 = null;
                z = true;
            }
            if (c4771M10971 != null) {
                c3282M11978.m10969();
                if (!c3282M11978.m10963().m7819()) {
                    c3282M11978.m10968();
                }
            } else if (abstractC2613M13916.isDuplex()) {
                c3282M11978.m10961();
                abstractC2613M13916.writeTo(Okio.buffer(c3282M11978.m10958(c4539M11980, true)));
            } else {
                BufferedSink bufferedSinkBuffer = Okio.buffer(c3282M11978.m10958(c4539M11980, false));
                abstractC2613M13916.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            }
        }
        if (abstractC2613M13916 == null || !abstractC2613M13916.isDuplex()) {
            c3282M11978.m10960();
        }
        if (c4771M10971 == null) {
            c4771M10971 = c3282M11978.m10971(false);
            if (c4771M10971 == null) {
                C3921.m12675();
            }
            if (z) {
                c3282M11978.m10973();
                z = false;
            }
        }
        C4770 c4770M14351 = c4771M10971.m14367(c4539M11980).m14357(c3282M11978.m10963().m7815()).m14368(jCurrentTimeMillis).m14365(System.currentTimeMillis()).m14351();
        int iM14334 = c4770M14351.m14334();
        if (iM14334 == 100) {
            C4770.C4771 c4771M109712 = c3282M11978.m10971(false);
            if (c4771M109712 == null) {
                C3921.m12675();
            }
            if (z) {
                c3282M11978.m10973();
            }
            c4770M14351 = c4771M109712.m14367(c4539M11980).m14357(c3282M11978.m10963().m7815()).m14368(jCurrentTimeMillis).m14365(System.currentTimeMillis()).m14351();
            iM14334 = c4770M14351.m14334();
        }
        c3282M11978.m10972(c4770M14351);
        C4770 c4770M143512 = (this.f16753 && iM14334 == 101) ? c4770M14351.m14343().m14350(i5.f6765).m14351() : c4770M14351.m14343().m14350(c3282M11978.m10970(c4770M14351)).m14351();
        if (e0.m5967(HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, c4770M143512.m14347().m13919(HttpHeaders.HEAD_KEY_CONNECTION), true) || e0.m5967(HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, C4770.m14329(c4770M143512, HttpHeaders.HEAD_KEY_CONNECTION, null, 2, null), true)) {
            c3282M11978.m10968();
        }
        if (iM14334 == 204 || iM14334 == 205) {
            AbstractC4809 abstractC4809M14330 = c4770M143512.m14330();
            if ((abstractC4809M14330 != null ? abstractC4809M14330.contentLength() : -1L) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(iM14334);
                sb.append(" had non-zero Content-Length: ");
                AbstractC4809 abstractC4809M143302 = c4770M143512.m14330();
                sb.append(abstractC4809M143302 != null ? Long.valueOf(abstractC4809M143302.contentLength()) : null);
                throw new ProtocolException(sb.toString());
            }
        }
        return c4770M143512;
    }
}
