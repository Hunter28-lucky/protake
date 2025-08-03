package defpackage;

import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.videotools.FrameRenderer;
import defpackage.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PreviewEncoder.java */
/* renamed from: ౚ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4575 {

    /* renamed from: ދ, reason: contains not printable characters */
    public static final Object f15633 = new Object();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public HandlerThread f15635;

    /* renamed from: ԩ, reason: contains not printable characters */
    public Handler f15636;

    /* renamed from: ԫ, reason: contains not printable characters */
    public C3158 f15638;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public DecoderParamsBean f15639;

    /* renamed from: ԭ, reason: contains not printable characters */
    public e.InterfaceC1958 f15640;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public u8 f15641;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C2377 f15642;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C3606 f15644;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f15650;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f15651;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f15652;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f15653;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f15654;

    /* renamed from: އ, reason: contains not printable characters */
    public int f15655;

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f15656;

    /* renamed from: މ, reason: contains not printable characters */
    public long f15657;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f15634 = false;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Object f15637 = new Object();

    /* renamed from: ՠ, reason: contains not printable characters */
    public FrameRenderer f15643 = null;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f15645 = -1;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f15646 = -1;

    /* renamed from: ؠ, reason: contains not printable characters */
    public EGLSurface f15647 = null;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f15648 = -1;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f15649 = -1;

    /* renamed from: ފ, reason: contains not printable characters */
    public Map<Long, String> f15658 = new HashMap();

    /* compiled from: PreviewEncoder.java */
    /* renamed from: ౚ$Ϳ, reason: contains not printable characters */
    public class RunnableC4576 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4584 f15659;

        /* compiled from: PreviewEncoder.java */
        /* renamed from: ౚ$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC4577 implements Runnable {

            /* compiled from: PreviewEncoder.java */
            /* renamed from: ౚ$Ϳ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC4578 implements Runnable {

                /* compiled from: PreviewEncoder.java */
                /* renamed from: ౚ$Ϳ$Ϳ$Ϳ$Ϳ, reason: contains not printable characters */
                public class RunnableC4579 implements Runnable {
                    public RunnableC4579() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        RunnableC4576.this.f15659.onStart();
                    }
                }

                public RunnableC4578() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C4575.this.f15636.post(new RunnableC4579());
                }
            }

            public RunnableC4577() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C4575.this.f15642 == null) {
                    return;
                }
                C4575.this.m14037();
                if (C4575.this.f15641 != null) {
                    C4575.this.f15641.m8365();
                }
                C4575 c4575 = C4575.this;
                c4575.f15641 = new u8(c4575.f15642, C4575.this.f15638.m10767(), true);
                C4575.this.f15638.m10772(new RunnableC4578(), RunnableC4576.this.f15659);
            }
        }

        public RunnableC4576(InterfaceC4584 interfaceC4584) {
            this.f15659 = interfaceC4584;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4575 c4575 = C4575.this;
            if (c4575.f15636 == null || c4575.f15642 == null) {
                return;
            }
            C4575.this.f15636.post(new RunnableC4577());
        }
    }

    /* compiled from: PreviewEncoder.java */
    /* renamed from: ౚ$Ԩ, reason: contains not printable characters */
    public class RunnableC4580 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4583 f15664;

        public RunnableC4580(InterfaceC4583 interfaceC4583) {
            this.f15664 = interfaceC4583;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4575 c4575 = C4575.this;
            c4575.m14044(c4575.f15639);
            InterfaceC4583 interfaceC4583 = this.f15664;
            if (interfaceC4583 != null) {
                interfaceC4583.onSuc();
            }
        }
    }

    /* compiled from: PreviewEncoder.java */
    /* renamed from: ౚ$Ԫ, reason: contains not printable characters */
    public class RunnableC4581 implements Runnable {
        public RunnableC4581() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4575.this.f15638.m10773();
            C4575.this.m14040();
        }
    }

    /* compiled from: PreviewEncoder.java */
    /* renamed from: ౚ$Ԭ, reason: contains not printable characters */
    public class RunnableC4582 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f15667;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f15668;

        public RunnableC4582(int i, int i2) {
            this.f15667 = i;
            this.f15668 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C4575.f15633) {
                C4575.this.m14046(this.f15667, this.f15668);
            }
        }
    }

    /* compiled from: PreviewEncoder.java */
    /* renamed from: ౚ$Ԯ, reason: contains not printable characters */
    public interface InterfaceC4583 {
        void onSuc();
    }

    /* compiled from: PreviewEncoder.java */
    /* renamed from: ౚ$ՠ, reason: contains not printable characters */
    public interface InterfaceC4584 {
        void onFail();

        void onStart();
    }

    public C4575(DecoderParamsBean decoderParamsBean, e.InterfaceC1958 interfaceC1958, InterfaceC4583 interfaceC4583) {
        this.f15640 = interfaceC1958;
        this.f15639 = decoderParamsBean;
        if (decoderParamsBean == null) {
            throw new RuntimeException("config cont null");
        }
        m14045();
        m14043(interfaceC4583);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m14037() {
        this.f15642.m8853(this.f15647);
        C3606 c3606 = new C3606();
        this.f15644 = c3606;
        c3606.m11636(new C4327());
        this.f15644.m13477();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m14038(int i) {
        m14042(System.nanoTime() - this.f15657, false, i);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m14039(int i, int i2) {
        this.f15636.post(new RunnableC4582(i, i2));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m14040() {
        EGLSurface eGLSurface;
        if (this.f15634) {
            C4638.m14101("PreviewEncoder", "PreviewEncoder exitThread ... ");
        }
        FrameRenderer frameRenderer = this.f15643;
        if (frameRenderer != null) {
            frameRenderer.m2049();
            this.f15643 = null;
        }
        C3606 c3606 = this.f15644;
        if (c3606 != null) {
            c3606.m13471();
            this.f15644.mo10877();
            this.f15644 = null;
        }
        u8 u8Var = this.f15641;
        if (u8Var != null) {
            u8Var.m8365();
            this.f15641 = null;
        }
        C4378.m13548(this.f15645);
        C2377 c2377 = this.f15642;
        if (c2377 != null && (eGLSurface = this.f15647) != null) {
            c2377.m8855(eGLSurface);
        }
        C3439.f11831.m11208();
        C2377 c23772 = this.f15642;
        if (c23772 != null) {
            c23772.m8854();
            this.f15642 = null;
        }
        synchronized (this.f15637) {
            HandlerThread handlerThread = this.f15635;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.f15635 = null;
            this.f15636 = null;
            this.f15656 = false;
            this.f15637.notify();
        }
        if (this.f15634) {
            C4638.m14101("PreviewEncoder", "PreviewEncoder exitThread 完毕... ");
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public Map<Long, String> m14041() {
        return this.f15658;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final boolean m14042(long j, boolean z, int i) {
        this.f15641.m8860();
        int i2 = this.f15646;
        int i3 = this.f15649;
        int i4 = this.f15648;
        int i5 = (int) (i3 / 1.0f);
        int i6 = i5 - (i5 % 2);
        int i7 = (i3 - i6) / 2;
        this.f15643.m2052(true, 0, 0, i7, i4, i6, 0, i7, i4, i6, this.f15644, i2, i4, i3, this.f15652, this.f15653);
        this.f15658.put(Long.valueOf(j / 1000), ACHelper.getInstance().getCameraAlbumSendString());
        this.f15641.m8862(j);
        this.f15641.m8863();
        this.f15638.m10768(z);
        return true;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m14043(InterfaceC4583 interfaceC4583) {
        if (this.f15656) {
            synchronized (this.f15637) {
                try {
                    this.f15637.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        synchronized (this.f15637) {
            HandlerThread handlerThread = new HandlerThread("PreviewEncoder");
            this.f15635 = handlerThread;
            handlerThread.setPriority(10);
            this.f15635.start();
            Handler handler = new Handler(this.f15635.getLooper());
            this.f15636 = handler;
            handler.post(new RunnableC4580(interfaceC4583));
        }
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m14044(DecoderParamsBean decoderParamsBean) {
        int iM475 = decoderParamsBean.m475();
        this.f15650 = iM475;
        this.f15650 = iM475 - (iM475 % 2);
        int iM473 = decoderParamsBean.m473();
        this.f15651 = iM473;
        int i = iM473 - (iM473 % 2);
        this.f15651 = i;
        int i2 = this.f15650;
        this.f15654 = i2;
        this.f15654 = i2 - (i2 % 2);
        this.f15655 = i;
        this.f15655 = i - (i % 2);
        this.f15648 = decoderParamsBean.m475();
        this.f15649 = decoderParamsBean.m473();
        this.f15652 = this.f15650;
        this.f15653 = this.f15651;
        if (this.f15634) {
            C4638.m14099("PreviewEncoder", String.format("mVideoWidth : %s , mVideoHeight : %s , texWidth : %s , textHeight : %s , captureWidth : %s , captureheight : %s , filterWidth : %s , filterHeight : %s ", Integer.valueOf(this.f15648), Integer.valueOf(this.f15649), Integer.valueOf(this.f15650), Integer.valueOf(this.f15651), Integer.valueOf(this.f15652), Integer.valueOf(this.f15653), Integer.valueOf(this.f15654), Integer.valueOf(this.f15655)));
        }
        C2377 c2377 = new C2377(C3732.m11945().m11954(), 1);
        this.f15642 = c2377;
        EGLSurface eGLSurfaceM8850 = c2377.m8850(16, 16);
        this.f15647 = eGLSurfaceM8850;
        this.f15642.m8853(eGLSurfaceM8850);
        int iM13547 = C4378.m13547();
        this.f15645 = iM13547;
        this.f15646 = iM13547;
        this.f15643 = new FrameRenderer();
        if (this.f15634) {
            C4638.m14099("PreviewEncoder", String.format("initGlContext  : %s ", decoderParamsBean));
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m14045() {
        this.f15638 = new C3158(this.f15639, this.f15640, this);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m14046(int i, int i2) {
        if (this.f15638 == null || this.f15641 == null) {
            return;
        }
        this.f15646 = i;
        if (this.f15657 == 0) {
            this.f15657 = System.nanoTime();
        }
        m14038(i2);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m14047() {
        Handler handler = this.f15636;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC4581());
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m14048(InterfaceC4584 interfaceC4584) {
        this.f15638.m10770(new RunnableC4576(interfaceC4584));
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m14049(int i) {
        if (this.f15638 != null) {
            this.f15639.m478(i);
            this.f15638.m10774(i);
        }
    }
}
