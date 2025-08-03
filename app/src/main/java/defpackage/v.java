package defpackage;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.InterfaceC4900;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class v<Data> implements InterfaceC4900<String, Data> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4900<Uri, Data> f8658;

    /* compiled from: StringLoader.java */
    /* renamed from: v$Ϳ, reason: contains not printable characters */
    public static final class C2299 implements InterfaceC5295<String, AssetFileDescriptor> {
        @Override // defpackage.InterfaceC5295
        /* renamed from: Ԩ */
        public InterfaceC4900<String, AssetFileDescriptor> mo12(C4057 c4057) {
            return new v(c4057.m12984(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: v$Ԩ, reason: contains not printable characters */
    public static class C2300 implements InterfaceC5295<String, ParcelFileDescriptor> {
        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<String, ParcelFileDescriptor> mo12(C4057 c4057) {
            return new v(c4057.m12984(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: v$Ԫ, reason: contains not printable characters */
    public static class C2301 implements InterfaceC5295<String, InputStream> {
        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<String, InputStream> mo12(C4057 c4057) {
            return new v(c4057.m12984(Uri.class, InputStream.class));
        }
    }

    public v(InterfaceC4900<Uri, Data> interfaceC4900) {
        this.f8658 = interfaceC4900;
    }

    @Nullable
    /* renamed from: ԫ, reason: contains not printable characters */
    public static Uri m8455(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return m8456(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? m8456(str) : uri;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static Uri m8456(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<Data> mo8(@NonNull String str, int i, int i2, @NonNull C3475 c3475) {
        Uri uriM8455 = m8455(str);
        if (uriM8455 == null) {
            return null;
        }
        return this.f8658.mo8(uriM8455, i, i2, c3475);
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull String str) {
        return true;
    }
}
