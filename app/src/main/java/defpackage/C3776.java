package defpackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.C1814;
import defpackage.C3895;
import defpackage.C4024;
import defpackage.InterfaceC3238;
import java.util.Map;

/* compiled from: GlideBuilder.java */
/* renamed from: ݿ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3776 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C1814 f13033;

    /* renamed from: ԩ, reason: contains not printable characters */
    public InterfaceC2731 f13034;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public InterfaceC4950 f13035;

    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC3889 f13036;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public ExecutorServiceC2561 f13037;

    /* renamed from: ԭ, reason: contains not printable characters */
    public ExecutorServiceC2561 f13038;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC3238.InterfaceC3239 f13039;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C3895 f13040;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC2673 f13041;

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public C4024.InterfaceC4026 f13044;

    /* renamed from: ؠ, reason: contains not printable characters */
    public ExecutorServiceC2561 f13045;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f13046;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Map<Class<?>, n3<?, ?>> f13032 = new ArrayMap();

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f13042 = 4;

    /* renamed from: ֏, reason: contains not printable characters */
    public C3900 f13043 = new C3900();

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public ComponentCallbacks2C3498 m12080(@NonNull Context context) {
        if (this.f13037 == null) {
            this.f13037 = ExecutorServiceC2561.m9420();
        }
        if (this.f13038 == null) {
            this.f13038 = ExecutorServiceC2561.m9418();
        }
        if (this.f13045 == null) {
            this.f13045 = ExecutorServiceC2561.m9416();
        }
        if (this.f13040 == null) {
            this.f13040 = new C3895.C3896(context).m12572();
        }
        if (this.f13041 == null) {
            this.f13041 = new C5020();
        }
        if (this.f13034 == null) {
            int iM12569 = this.f13040.m12569();
            if (iM12569 > 0) {
                this.f13034 = new C5300(iM12569);
            } else {
                this.f13034 = new C3912();
            }
        }
        if (this.f13035 == null) {
            this.f13035 = new C2588(this.f13040.m12568());
        }
        if (this.f13036 == null) {
            this.f13036 = new C2620(this.f13040.m12570());
        }
        if (this.f13039 == null) {
            this.f13039 = new C5203(context);
        }
        if (this.f13033 == null) {
            this.f13033 = new C1814(this.f13036, this.f13039, this.f13038, this.f13037, ExecutorServiceC2561.m9422(), ExecutorServiceC2561.m9416(), this.f13046);
        }
        return new ComponentCallbacks2C3498(context, this.f13033, this.f13036, this.f13034, this.f13035, new C4024(this.f13044), this.f13041, this.f13042, this.f13043.m12616(), this.f13032);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m12081(@Nullable C4024.InterfaceC4026 interfaceC4026) {
        this.f13044 = interfaceC4026;
    }
}
