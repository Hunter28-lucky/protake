package defpackage;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.InterfaceC4900;
import java.io.InputStream;

/* compiled from: ResourceLoader.java */
/* renamed from: ໜ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5009<Data> implements InterfaceC4900<Integer, Data> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4900<Uri, Data> f16771;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Resources f16772;

    /* compiled from: ResourceLoader.java */
    /* renamed from: ໜ$Ϳ, reason: contains not printable characters */
    public static final class C5010 implements InterfaceC5295<Integer, AssetFileDescriptor> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Resources f16773;

        public C5010(Resources resources) {
            this.f16773 = resources;
        }

        @Override // defpackage.InterfaceC5295
        /* renamed from: Ԩ */
        public InterfaceC4900<Integer, AssetFileDescriptor> mo12(C4057 c4057) {
            return new C5009(this.f16773, c4057.m12984(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: ໜ$Ԩ, reason: contains not printable characters */
    public static class C5011 implements InterfaceC5295<Integer, ParcelFileDescriptor> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Resources f16774;

        public C5011(Resources resources) {
            this.f16774 = resources;
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Integer, ParcelFileDescriptor> mo12(C4057 c4057) {
            return new C5009(this.f16774, c4057.m12984(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: ໜ$Ԫ, reason: contains not printable characters */
    public static class C5012 implements InterfaceC5295<Integer, InputStream> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Resources f16775;

        public C5012(Resources resources) {
            this.f16775 = resources;
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Integer, InputStream> mo12(C4057 c4057) {
            return new C5009(this.f16775, c4057.m12984(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: ໜ$Ԭ, reason: contains not printable characters */
    public static class C5013 implements InterfaceC5295<Integer, Uri> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Resources f16776;

        public C5013(Resources resources) {
            this.f16776 = resources;
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Integer, Uri> mo12(C4057 c4057) {
            return new C5009(this.f16776, l4.m7484());
        }
    }

    public C5009(Resources resources, InterfaceC4900<Uri, Data> interfaceC4900) {
        this.f16772 = resources;
        this.f16771 = interfaceC4900;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<Data> mo8(@NonNull Integer num, int i, int i2, @NonNull C3475 c3475) {
        Uri uriM14799 = m14799(num);
        if (uriM14799 == null) {
            return null;
        }
        return this.f16771.mo8(uriM14799, i, i2, c3475);
    }

    @Nullable
    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Uri m14799(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f16772.getResourcePackageName(num.intValue()) + '/' + this.f16772.getResourceTypeName(num.intValue()) + '/' + this.f16772.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull Integer num) {
        return true;
    }
}
