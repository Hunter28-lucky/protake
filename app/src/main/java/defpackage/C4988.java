package defpackage;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import defpackage.InterfaceC4900;
import java.io.InputStream;

/* compiled from: AssetUriLoader.java */
/* renamed from: ຬ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4988<Data> implements InterfaceC4900<Uri, Data> {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final int f16741 = 22;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final AssetManager f16742;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4989<Data> f16743;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: ຬ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC4989<Data> {
        /* renamed from: Ϳ, reason: contains not printable characters */
        InterfaceC3129<Data> mo14784(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: ຬ$Ԩ, reason: contains not printable characters */
    public static class C4990 implements InterfaceC5295<Uri, ParcelFileDescriptor>, InterfaceC4989<ParcelFileDescriptor> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final AssetManager f16744;

        public C4990(AssetManager assetManager) {
            this.f16744 = assetManager;
        }

        @Override // defpackage.C4988.InterfaceC4989
        /* renamed from: Ϳ */
        public InterfaceC3129<ParcelFileDescriptor> mo14784(AssetManager assetManager, String str) {
            return new C4096(assetManager, str);
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Uri, ParcelFileDescriptor> mo12(C4057 c4057) {
            return new C4988(this.f16744, this);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: ຬ$Ԫ, reason: contains not printable characters */
    public static class C4991 implements InterfaceC5295<Uri, InputStream>, InterfaceC4989<InputStream> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final AssetManager f16745;

        public C4991(AssetManager assetManager) {
            this.f16745 = assetManager;
        }

        @Override // defpackage.C4988.InterfaceC4989
        /* renamed from: Ϳ */
        public InterfaceC3129<InputStream> mo14784(AssetManager assetManager, String str) {
            return new o(assetManager, str);
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Uri, InputStream> mo12(C4057 c4057) {
            return new C4988(this.f16745, this);
        }
    }

    public C4988(AssetManager assetManager, InterfaceC4989<Data> interfaceC4989) {
        this.f16742 = assetManager;
        this.f16743 = interfaceC4989;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<Data> mo8(@NonNull Uri uri, int i, int i2, @NonNull C3475 c3475) {
        return new InterfaceC4900.C4901<>(new C2969(uri), this.f16743.mo14784(this.f16742, uri.toString().substring(f16741)));
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
