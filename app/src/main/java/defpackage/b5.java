package defpackage;

import androidx.annotation.NonNull;
import defpackage.InterfaceC4900;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class b5 implements InterfaceC4900<URL, InputStream> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4900<C4207, InputStream> f113;

    /* compiled from: UrlLoader.java */
    /* renamed from: b5$Ϳ, reason: contains not printable characters */
    public static class C0045 implements InterfaceC5295<URL, InputStream> {
        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<URL, InputStream> mo12(C4057 c4057) {
            return new b5(c4057.m12984(C4207.class, InputStream.class));
        }
    }

    public b5(InterfaceC4900<C4207, InputStream> interfaceC4900) {
        this.f113 = interfaceC4900;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<InputStream> mo8(@NonNull URL url, int i, int i2, @NonNull C3475 c3475) {
        return this.f113.mo8(new C4207(url), i, i2, c3475);
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull URL url) {
        return true;
    }
}
