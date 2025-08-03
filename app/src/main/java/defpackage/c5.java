package defpackage;

import android.net.Uri;
import androidx.annotation.NonNull;
import defpackage.InterfaceC4900;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader.java */
/* loaded from: classes.dex */
public class c5<Data> implements InterfaceC4900<Uri, Data> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Set<String> f166 = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4900<C4207, Data> f167;

    /* compiled from: UrlUriLoader.java */
    /* renamed from: c5$Ϳ, reason: contains not printable characters */
    public static class C0051 implements InterfaceC5295<Uri, InputStream> {
        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Uri, InputStream> mo12(C4057 c4057) {
            return new c5(c4057.m12984(C4207.class, InputStream.class));
        }
    }

    public c5(InterfaceC4900<C4207, Data> interfaceC4900) {
        this.f167 = interfaceC4900;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<Data> mo8(@NonNull Uri uri, int i, int i2, @NonNull C3475 c3475) {
        return this.f167.mo8(new C4207(uri.toString()), i, i2, c3475);
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull Uri uri) {
        return f166.contains(uri.getScheme());
    }
}
