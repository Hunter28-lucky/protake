package defpackage;

import android.content.Context;
import defpackage.C2795;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* renamed from: Ⴉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C5203 extends C2795 {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    /* renamed from: Ⴉ$Ϳ, reason: contains not printable characters */
    public class C5204 implements C2795.InterfaceC2796 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Context f17258;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f17259;

        public C5204(Context context, String str) {
            this.f17258 = context;
            this.f17259 = str;
        }

        @Override // defpackage.C2795.InterfaceC2796
        /* renamed from: Ϳ */
        public File mo10107() {
            File cacheDir = this.f17258.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f17259 != null ? new File(cacheDir, this.f17259) : cacheDir;
        }
    }

    public C5203(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public C5203(Context context, String str, long j) {
        super(new C5204(context, str), j);
    }
}
