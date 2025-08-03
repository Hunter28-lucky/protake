package defpackage;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GifFrameLoader.java */
/* renamed from: ߕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3830 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC3507 f13117;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Handler f13118;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final List<InterfaceC3832> f13119;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C4226 f13120;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2731 f13121;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f13122;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f13123;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f13124;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C4553<Bitmap> f13125;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C3831 f13126;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f13127;

    /* renamed from: ֏, reason: contains not printable characters */
    public C3831 f13128;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Bitmap f13129;

    /* renamed from: ؠ, reason: contains not printable characters */
    public a3<Bitmap> f13130;

    /* renamed from: ހ, reason: contains not printable characters */
    public C3831 f13131;

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public InterfaceC3834 f13132;

    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* renamed from: ߕ$Ϳ, reason: contains not printable characters */
    public static class C3831 extends AbstractC4502<Bitmap> {

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final Handler f13133;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int f13134;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f13135;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Bitmap f13136;

        public C3831(Handler handler, int i, long j) {
            this.f13133 = handler;
            this.f13134 = i;
            this.f13135 = j;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public Bitmap m12171() {
            return this.f13136;
        }

        @Override // defpackage.c1
        /* renamed from: ՠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo179(@NonNull Bitmap bitmap, @Nullable l3<? super Bitmap> l3Var) {
            this.f13136 = bitmap;
            this.f13133.sendMessageAtTime(this.f13133.obtainMessage(1, this), this.f13135);
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* renamed from: ߕ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC3832 {
        /* renamed from: Ϳ */
        void mo11284();
    }

    /* compiled from: GifFrameLoader.java */
    /* renamed from: ߕ$Ԫ, reason: contains not printable characters */
    public class C3833 implements Handler.Callback {
        public C3833() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                C3830.this.m12164((C3831) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            C3830.this.f13120.m13316((C3831) message.obj);
            return false;
        }
    }

    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* renamed from: ߕ$Ԭ, reason: contains not printable characters */
    public interface InterfaceC3834 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m12173();
    }

    public C3830(ComponentCallbacks2C3498 componentCallbacks2C3498, InterfaceC3507 interfaceC3507, int i, int i2, a3<Bitmap> a3Var, Bitmap bitmap) {
        this(componentCallbacks2C3498.m11428(), ComponentCallbacks2C3498.m11425(componentCallbacks2C3498.m11430()), interfaceC3507, null, m12152(ComponentCallbacks2C3498.m11425(componentCallbacks2C3498.m11430()), i, i2), a3Var, bitmap);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static InterfaceC3773 m12151() {
        return new C2969(Double.valueOf(Math.random()));
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static C4553<Bitmap> m12152(C4226 c4226, int i, int i2) {
        return c4226.m13314().m13956(C3900.m12576(AbstractC3541.f12340).m12635(true).m12630(true).m12622(i, i2));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m12153() {
        this.f13119.clear();
        m12165();
        m12168();
        C3831 c3831 = this.f13126;
        if (c3831 != null) {
            this.f13120.m13316(c3831);
            this.f13126 = null;
        }
        C3831 c38312 = this.f13128;
        if (c38312 != null) {
            this.f13120.m13316(c38312);
            this.f13128 = null;
        }
        C3831 c38313 = this.f13131;
        if (c38313 != null) {
            this.f13120.m13316(c38313);
            this.f13131 = null;
        }
        this.f13117.clear();
        this.f13127 = true;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public ByteBuffer m12154() {
        return this.f13117.mo6111().asReadOnlyBuffer();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public Bitmap m12155() {
        C3831 c3831 = this.f13126;
        return c3831 != null ? c3831.m12171() : this.f13129;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int m12156() {
        C3831 c3831 = this.f13126;
        if (c3831 != null) {
            return c3831.f13134;
        }
        return -1;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public Bitmap m12157() {
        return this.f13129;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m12158() {
        return this.f13117.mo6108();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int m12159() {
        return j5.m7089(m12155().getWidth(), m12155().getHeight(), m12155().getConfig());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int m12160() {
        return m12155().getHeight();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public int m12161() {
        return this.f13117.mo6114() + m12159();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public int m12162() {
        return m12155().getWidth();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m12163() {
        if (!this.f13122 || this.f13123) {
            return;
        }
        if (this.f13124) {
            C4513.m13864(this.f13131 == null, "Pending target must be null when starting from the first frame");
            this.f13117.mo6112();
            this.f13124 = false;
        }
        C3831 c3831 = this.f13131;
        if (c3831 != null) {
            this.f13131 = null;
            m12164(c3831);
            return;
        }
        this.f13123 = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.f13117.mo6109();
        this.f13117.mo6107();
        this.f13128 = new C3831(this.f13118, this.f13117.mo6113(), jUptimeMillis);
        this.f13125.m13956(C3900.m12578(m12151())).m13969(this.f13117).m13963(this.f13128);
    }

    @VisibleForTesting
    /* renamed from: ؠ, reason: contains not printable characters */
    public void m12164(C3831 c3831) {
        InterfaceC3834 interfaceC3834 = this.f13132;
        if (interfaceC3834 != null) {
            interfaceC3834.m12173();
        }
        this.f13123 = false;
        if (this.f13127) {
            this.f13118.obtainMessage(2, c3831).sendToTarget();
            return;
        }
        if (!this.f13122) {
            this.f13131 = c3831;
            return;
        }
        if (c3831.m12171() != null) {
            m12165();
            C3831 c38312 = this.f13126;
            this.f13126 = c3831;
            for (int size = this.f13119.size() - 1; size >= 0; size--) {
                this.f13119.get(size).mo11284();
            }
            if (c38312 != null) {
                this.f13118.obtainMessage(2, c38312).sendToTarget();
            }
        }
        m12163();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m12165() {
        Bitmap bitmap = this.f13129;
        if (bitmap != null) {
            this.f13121.mo9428(bitmap);
            this.f13129 = null;
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m12166(a3<Bitmap> a3Var, Bitmap bitmap) {
        this.f13130 = (a3) C4513.m13867(a3Var);
        this.f13129 = (Bitmap) C4513.m13867(bitmap);
        this.f13125 = this.f13125.m13956(new C3900().m12631(a3Var));
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m12167() {
        if (this.f13122) {
            return;
        }
        this.f13122 = true;
        this.f13127 = false;
        m12163();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m12168() {
        this.f13122 = false;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m12169(InterfaceC3832 interfaceC3832) {
        if (this.f13127) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f13119.contains(interfaceC3832)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f13119.isEmpty();
        this.f13119.add(interfaceC3832);
        if (zIsEmpty) {
            m12167();
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m12170(InterfaceC3832 interfaceC3832) {
        this.f13119.remove(interfaceC3832);
        if (this.f13119.isEmpty()) {
            m12168();
        }
    }

    public C3830(InterfaceC2731 interfaceC2731, C4226 c4226, InterfaceC3507 interfaceC3507, Handler handler, C4553<Bitmap> c4553, a3<Bitmap> a3Var, Bitmap bitmap) {
        this.f13119 = new ArrayList();
        this.f13120 = c4226;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new C3833()) : handler;
        this.f13121 = interfaceC2731;
        this.f13118 = handler;
        this.f13125 = c4553;
        this.f13117 = interfaceC3507;
        m12166(a3Var, bitmap);
    }
}
