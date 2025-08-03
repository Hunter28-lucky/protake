package defpackage;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.InterfaceC4900;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader.java */
/* renamed from: ऄ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4021 implements InterfaceC4900<Uri, InputStream> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f13969;

    /* compiled from: MediaStoreVideoThumbLoader.java */
    /* renamed from: ऄ$Ϳ, reason: contains not printable characters */
    public static class C4022 implements InterfaceC5295<Uri, InputStream> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Context f13970;

        public C4022(Context context) {
            this.f13970 = context;
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Uri, InputStream> mo12(C4057 c4057) {
            return new C4021(this.f13970);
        }
    }

    public C4021(Context context) {
        this.f13969 = context.getApplicationContext();
    }

    @Override // defpackage.InterfaceC4900
    @Nullable
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<InputStream> mo8(@NonNull Uri uri, int i, int i2, @NonNull C3475 c3475) {
        if (C2551.m9394(i, i2) && m12897(c3475)) {
            return new InterfaceC4900.C4901<>(new C2969(uri), j2.m7074(this.f13969, uri));
        }
        return null;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull Uri uri) {
        return C2551.m9393(uri);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean m12897(C3475 c3475) {
        Long l = (Long) c3475.m11329(u5.f8615);
        return l != null && l.longValue() == -1;
    }
}
