package defpackage;

import android.net.Uri;
import androidx.annotation.NonNull;
import defpackage.InterfaceC4900;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader.java */
/* renamed from: ઠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4344 implements InterfaceC4900<Uri, InputStream> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Set<String> f14894 = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4900<C4207, InputStream> f14895;

    /* compiled from: HttpUriLoader.java */
    /* renamed from: ઠ$Ϳ, reason: contains not printable characters */
    public static class C4345 implements InterfaceC5295<Uri, InputStream> {
        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Uri, InputStream> mo12(C4057 c4057) {
            return new C4344(c4057.m12984(C4207.class, InputStream.class));
        }
    }

    public C4344(InterfaceC4900<C4207, InputStream> interfaceC4900) {
        this.f14895 = interfaceC4900;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<InputStream> mo8(@NonNull Uri uri, int i, int i2, @NonNull C3475 c3475) {
        return this.f14895.mo8(new C4207(uri.toString()), i, i2, c3475);
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull Uri uri) {
        return f14894.contains(uri.getScheme());
    }
}
