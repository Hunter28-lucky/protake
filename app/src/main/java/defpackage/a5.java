package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import defpackage.InterfaceC4900;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public class a5<Data> implements InterfaceC4900<Uri, Data> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Set<String> f16 = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC0002<Data> f17;

    /* compiled from: UriLoader.java */
    /* renamed from: a5$Ϳ, reason: contains not printable characters */
    public static final class C0000 implements InterfaceC5295<Uri, AssetFileDescriptor>, InterfaceC0002<AssetFileDescriptor> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ContentResolver f18;

        public C0000(ContentResolver contentResolver) {
            this.f18 = contentResolver;
        }

        @Override // defpackage.a5.InterfaceC0002
        /* renamed from: Ϳ, reason: contains not printable characters */
        public InterfaceC3129<AssetFileDescriptor> mo11(Uri uri) {
            return new C4983(this.f18, uri);
        }

        @Override // defpackage.InterfaceC5295
        /* renamed from: Ԩ, reason: contains not printable characters */
        public InterfaceC4900<Uri, AssetFileDescriptor> mo12(C4057 c4057) {
            return new a5(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: a5$Ԩ, reason: contains not printable characters */
    public static class C0001 implements InterfaceC5295<Uri, ParcelFileDescriptor>, InterfaceC0002<ParcelFileDescriptor> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ContentResolver f19;

        public C0001(ContentResolver contentResolver) {
            this.f19 = contentResolver;
        }

        @Override // defpackage.a5.InterfaceC0002
        /* renamed from: Ϳ */
        public InterfaceC3129<ParcelFileDescriptor> mo11(Uri uri) {
            return new C3259(this.f19, uri);
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Uri, ParcelFileDescriptor> mo12(C4057 c4057) {
            return new a5(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: a5$Ԫ, reason: contains not printable characters */
    public interface InterfaceC0002<Data> {
        /* renamed from: Ϳ */
        InterfaceC3129<Data> mo11(Uri uri);
    }

    /* compiled from: UriLoader.java */
    /* renamed from: a5$Ԭ, reason: contains not printable characters */
    public static class C0003 implements InterfaceC5295<Uri, InputStream>, InterfaceC0002<InputStream> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ContentResolver f20;

        public C0003(ContentResolver contentResolver) {
            this.f20 = contentResolver;
        }

        @Override // defpackage.a5.InterfaceC0002
        /* renamed from: Ϳ */
        public InterfaceC3129<InputStream> mo11(Uri uri) {
            return new r(this.f20, uri);
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Uri, InputStream> mo12(C4057 c4057) {
            return new a5(this);
        }
    }

    public a5(InterfaceC0002<Data> interfaceC0002) {
        this.f17 = interfaceC0002;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<Data> mo8(@NonNull Uri uri, int i, int i2, @NonNull C3475 c3475) {
        return new InterfaceC4900.C4901<>(new C2969(uri), this.f17.mo11(uri));
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull Uri uri) {
        return f16.contains(uri.getScheme());
    }
}
