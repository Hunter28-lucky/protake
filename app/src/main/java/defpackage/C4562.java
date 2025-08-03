package defpackage;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import defpackage.InterfaceC4900;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader.java */
/* renamed from: స, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4562 implements InterfaceC4900<Uri, InputStream> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f15600;

    /* compiled from: MediaStoreImageThumbLoader.java */
    /* renamed from: స$Ϳ, reason: contains not printable characters */
    public static class C4563 implements InterfaceC5295<Uri, InputStream> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Context f15601;

        public C4563(Context context) {
            this.f15601 = context;
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Uri, InputStream> mo12(C4057 c4057) {
            return new C4562(this.f15601);
        }
    }

    public C4562(Context context) {
        this.f15600 = context.getApplicationContext();
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<InputStream> mo8(@NonNull Uri uri, int i, int i2, @NonNull C3475 c3475) {
        if (C2551.m9394(i, i2)) {
            return new InterfaceC4900.C4901<>(new C2969(uri), j2.m7073(this.f15600, uri));
        }
        return null;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull Uri uri) {
        return C2551.m9391(uri);
    }
}
