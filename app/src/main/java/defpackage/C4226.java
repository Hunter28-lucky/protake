package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Priority;
import defpackage.InterfaceC4346;
import java.util.Iterator;

/* compiled from: RequestManager.java */
/* renamed from: ਆ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4226 implements InterfaceC2405 {

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final C3900 f14524 = C3900.m12575(Bitmap.class).m12616();

    /* renamed from: ֏, reason: contains not printable characters */
    public static final C3900 f14525 = C3900.m12575(C3465.class).m12616();

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final C3900 f14526 = C3900.m12576(AbstractC3541.f12341).m12623(Priority.LOW).m12630(true);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final ComponentCallbacks2C3498 f14527;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Context f14528;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC4970 f14529;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C3946 f14530;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC4598 f14531;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final e1 f14532;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Runnable f14533;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Handler f14534;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC4346 f14535;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C3900 f14536;

    /* compiled from: RequestManager.java */
    /* renamed from: ਆ$Ϳ, reason: contains not printable characters */
    public class RunnableC4227 implements Runnable {
        public RunnableC4227() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4226 c4226 = C4226.this;
            c4226.f14529.mo12322(c4226);
        }
    }

    /* compiled from: RequestManager.java */
    /* renamed from: ਆ$Ԩ, reason: contains not printable characters */
    public class RunnableC4228 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ c1 f14538;

        public RunnableC4228(c1 c1Var) {
            this.f14538 = c1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4226.this.m13316(this.f14538);
        }
    }

    /* compiled from: RequestManager.java */
    /* renamed from: ਆ$Ԫ, reason: contains not printable characters */
    public static class C4229 implements InterfaceC4346.InterfaceC4347 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C3946 f14540;

        public C4229(@NonNull C3946 c3946) {
            this.f14540 = c3946;
        }

        @Override // defpackage.InterfaceC4346.InterfaceC4347
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo13327(boolean z) {
            if (z) {
                this.f14540.m12723();
            }
        }
    }

    public C4226(@NonNull ComponentCallbacks2C3498 componentCallbacks2C3498, @NonNull InterfaceC4970 interfaceC4970, @NonNull InterfaceC4598 interfaceC4598, @NonNull Context context) {
        this(componentCallbacks2C3498, interfaceC4970, interfaceC4598, new C3946(), componentCallbacks2C3498.m11429(), context);
    }

    @Override // defpackage.InterfaceC2405
    public void onDestroy() {
        this.f14532.onDestroy();
        Iterator<c1<?>> it = this.f14532.m5982().iterator();
        while (it.hasNext()) {
            m13316(it.next());
        }
        this.f14532.m5981();
        this.f14530.m12721();
        this.f14529.mo12321(this);
        this.f14529.mo12321(this.f14535);
        this.f14534.removeCallbacks(this.f14533);
        this.f14527.m11437(this);
    }

    @Override // defpackage.InterfaceC2405
    public void onStart() {
        m13322();
        this.f14532.onStart();
    }

    @Override // defpackage.InterfaceC2405
    public void onStop() {
        m13321();
        this.f14532.onStop();
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.f14530 + ", treeNode=" + this.f14531 + "}";
    }

    @NonNull
    @CheckResult
    /* renamed from: ԯ, reason: contains not printable characters */
    public <ResourceType> C4553<ResourceType> m13313(@NonNull Class<ResourceType> cls) {
        return new C4553<>(this.f14527, this, cls, this.f14528);
    }

    @NonNull
    @CheckResult
    /* renamed from: ՠ, reason: contains not printable characters */
    public C4553<Bitmap> m13314() {
        return m13313(Bitmap.class).m13956(f14524);
    }

    @NonNull
    @CheckResult
    /* renamed from: ֈ, reason: contains not printable characters */
    public C4553<Drawable> m13315() {
        return m13313(Drawable.class);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m13316(@Nullable c1<?> c1Var) {
        if (c1Var == null) {
            return;
        }
        if (j5.m7099()) {
            m13326(c1Var);
        } else {
            this.f14534.post(new RunnableC4228(c1Var));
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public C3900 m13317() {
        return this.f14536;
    }

    @NonNull
    /* renamed from: ؠ, reason: contains not printable characters */
    public <T> n3<?, T> m13318(Class<T> cls) {
        return this.f14527.m11431().m10374(cls);
    }

    @NonNull
    @CheckResult
    /* renamed from: ހ, reason: contains not printable characters */
    public C4553<Drawable> m13319(@Nullable @DrawableRes @RawRes Integer num) {
        return m13315().m13968(num);
    }

    @NonNull
    @CheckResult
    /* renamed from: ށ, reason: contains not printable characters */
    public C4553<Drawable> m13320(@Nullable String str) {
        return m13315().m13970(str);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m13321() {
        j5.m7084();
        this.f14530.m12722();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m13322() {
        j5.m7084();
        this.f14530.m12724();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m13323(@NonNull C3900 c3900) {
        this.f14536 = c3900.clone().m12580();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m13324(@NonNull c1<?> c1Var, @NonNull InterfaceC3684 interfaceC3684) {
        this.f14532.m5983(c1Var);
        this.f14530.m12725(interfaceC3684);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean m13325(@NonNull c1<?> c1Var) {
        InterfaceC3684 interfaceC3684Mo181 = c1Var.mo181();
        if (interfaceC3684Mo181 == null) {
            return true;
        }
        if (!this.f14530.m12720(interfaceC3684Mo181)) {
            return false;
        }
        this.f14532.m5984(c1Var);
        c1Var.mo176(null);
        return true;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m13326(@NonNull c1<?> c1Var) {
        if (m13325(c1Var) || this.f14527.m11435(c1Var) || c1Var.mo181() == null) {
            return;
        }
        InterfaceC3684 interfaceC3684Mo181 = c1Var.mo181();
        c1Var.mo176(null);
        interfaceC3684Mo181.clear();
    }

    public C4226(ComponentCallbacks2C3498 componentCallbacks2C3498, InterfaceC4970 interfaceC4970, InterfaceC4598 interfaceC4598, C3946 c3946, InterfaceC2673 interfaceC2673, Context context) {
        this.f14532 = new e1();
        RunnableC4227 runnableC4227 = new RunnableC4227();
        this.f14533 = runnableC4227;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f14534 = handler;
        this.f14527 = componentCallbacks2C3498;
        this.f14529 = interfaceC4970;
        this.f14531 = interfaceC4598;
        this.f14530 = c3946;
        this.f14528 = context;
        InterfaceC4346 interfaceC4346Mo9815 = interfaceC2673.mo9815(context.getApplicationContext(), new C4229(c3946));
        this.f14535 = interfaceC4346Mo9815;
        if (j5.m7098()) {
            handler.post(runnableC4227);
        } else {
            interfaceC4970.mo12322(this);
        }
        interfaceC4970.mo12322(interfaceC4346Mo9815);
        m13323(componentCallbacks2C3498.m11431().m10373());
        componentCallbacks2C3498.m11434(this);
    }
}
