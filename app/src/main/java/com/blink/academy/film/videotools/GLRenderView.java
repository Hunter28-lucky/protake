package com.blink.academy.film.videotools;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C3439;
import defpackage.C3732;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class GLRenderView extends SurfaceView implements SurfaceHolder.Callback, Choreographer.FrameCallback, Handler.Callback {

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f1799;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public long f1800;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Handler f1801;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Thread f1802;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f1803;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f1804;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f1805;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f1806;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f1807;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Surface f1808;

    /* renamed from: ހ, reason: contains not printable characters */
    public C3732 f1809;

    /* renamed from: ށ, reason: contains not printable characters */
    public EGLSurface f1810;

    /* renamed from: ނ, reason: contains not printable characters */
    public Choreographer f1811;

    /* renamed from: ރ, reason: contains not printable characters */
    public String f1812;

    /* renamed from: ބ, reason: contains not printable characters */
    public BlockingQueue<Integer> f1813;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f1814;

    /* renamed from: ކ, reason: contains not printable characters */
    public Object f1815;

    /* renamed from: com.blink.academy.film.videotools.GLRenderView$Ϳ, reason: contains not printable characters */
    public class RunnableC0829 implements Runnable {
        public RunnableC0829() {
        }

        @Override // java.lang.Runnable
        @TargetApi(18)
        public void run() {
            GLRenderView.this.m2067(null, 0, 0);
            GLRenderView.this.f1813.offer(1);
            Looper.myLooper().quitSafely();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLRenderView$Ԩ, reason: contains not printable characters */
    public class RunnableC0830 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f1817;

        public RunnableC0830(Runnable runnable) {
            this.f1817 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLRenderView gLRenderView = GLRenderView.this;
            EGLSurface eGLSurface = gLRenderView.f1810;
            if (eGLSurface != null) {
                gLRenderView.f1809.m11957(eGLSurface);
            } else {
                gLRenderView.f1809.m11958();
            }
            this.f1817.run();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLRenderView$Ԫ, reason: contains not printable characters */
    public class RunnableC0831 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f1819;

        public RunnableC0831(Runnable runnable) {
            this.f1819 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLRenderView gLRenderView = GLRenderView.this;
            EGLSurface eGLSurface = gLRenderView.f1810;
            if (eGLSurface != null) {
                gLRenderView.f1809.m11957(eGLSurface);
            } else {
                gLRenderView.f1809.m11958();
            }
            this.f1819.run();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLRenderView$Ԭ, reason: contains not printable characters */
    public class RunnableC0832 implements Runnable {
        public RunnableC0832() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLRenderView.this.f1813.offer(1);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLRenderView$Ԯ, reason: contains not printable characters */
    public class RunnableC0833 implements Runnable {
        public RunnableC0833() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLRenderView.this.f1805 = true;
            GLRenderView.this.mo1964();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLRenderView$ՠ, reason: contains not printable characters */
    public class RunnableC0834 implements Runnable {
        public RunnableC0834() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLRenderView.this.f1805 = false;
            GLRenderView.this.mo1966();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLRenderView$ֈ, reason: contains not printable characters */
    public class C0835 extends AbstractRunnableC0837 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ SurfaceHolder f1824;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f1825;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f1826;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0835(SurfaceHolder surfaceHolder, int i, int i2) {
            super();
            this.f1824 = surfaceHolder;
            this.f1825 = i;
            this.f1826 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLRenderView.this.m2067(this.f1824.getSurface(), this.f1825, this.f1826);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLRenderView$֏, reason: contains not printable characters */
    public class RunnableC0836 implements Runnable {
        public RunnableC0836() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLRenderView.this.m2067(null, 0, 0);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLRenderView$ׯ, reason: contains not printable characters */
    public abstract class AbstractRunnableC0837 implements Runnable {
        public AbstractRunnableC0837() {
        }
    }

    public GLRenderView(Context context) {
        super(context);
        this.f1799 = true;
        this.f1805 = false;
        this.f1813 = new ArrayBlockingQueue(1);
        this.f1814 = 0;
        this.f1815 = new Object();
        getHolder().addCallback(this);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.f1810 == null || this.f1805 || !mo1960()) {
            this.f1811.postFrameCallback(this);
            return;
        }
        if (this.f1799) {
            this.f1800 = j;
            this.f1799 = false;
        }
        this.f1809.m11957(this.f1810);
        C3732.m11943("doFrame before render");
        GLES20.glViewport(0, 0, this.f1806, this.f1807);
        GLES20.glScissor(0, 0, this.f1806, this.f1807);
        long j2 = (j - this.f1800) / 1000000;
        System.nanoTime();
        m2063(j2 / 1000.0d, j);
        System.nanoTime();
        C3439.f11831.m11210();
        C3732.m11943("after render");
        synchronized (this.f1815) {
            this.f1814++;
            this.f1815.notifyAll();
        }
        if (this.f1804) {
            return;
        }
        this.f1811.postFrameCallback(this);
    }

    public boolean handleMessage(@NonNull Message message) {
        return false;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() throws InterruptedException {
        m2071();
        super.onDetachedFromWindow();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.d("GLRenderView", "surfaceChanged:" + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i3);
        m2064(new C0835(surfaceHolder, i2, i3));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d("GLRenderView", "surfaceCreated");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) throws InterruptedException {
        Log.d("GLRenderView", "surfaceDestroyed");
        m2066("surfaceDestroyed", new RunnableC0836());
        m2071();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2062(String str) throws InterruptedException {
        long jNanoTime = System.nanoTime();
        m2064(new RunnableC0832());
        long jNanoTime2 = System.nanoTime();
        try {
            this.f1813.take();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        long jNanoTime3 = System.nanoTime();
        Log.d("GLRenderView", String.format("drained for %s, took %d ms", str, Long.valueOf((jNanoTime2 - jNanoTime) / 1000000)));
        Log.d("GLRenderView", String.format("drained for %s, took %d ms", str, Long.valueOf((jNanoTime3 - jNanoTime2) / 1000000)));
    }

    /* renamed from: ԩ */
    public boolean mo1960() {
        return true;
    }

    /* renamed from: Ԫ */
    public void mo1961(int i, int i2) {
    }

    /* renamed from: ԫ */
    public void mo1962() {
    }

    /* renamed from: Ԭ */
    public void mo1963() {
    }

    /* renamed from: ԭ */
    public void mo1964() {
    }

    /* renamed from: Ԯ */
    public void mo1965(double d) {
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m2063(double d, long j) {
        mo1965(d);
    }

    /* renamed from: ՠ */
    public void mo1966() {
    }

    /* renamed from: ֈ */
    public void mo1967() {
        m2064(new RunnableC0833());
    }

    /* renamed from: ֏ */
    public void mo1968() throws InterruptedException {
        m2069(this.f1812);
        m2064(new RunnableC0834());
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean m2064(Runnable runnable) {
        Handler handler = this.f1801;
        if (handler == null) {
            Log.e("GLRenderView", "queuing a runnable on a dead handler");
            return false;
        }
        handler.post(new RunnableC0830(runnable));
        return true;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m2065(Runnable runnable, int i) {
        Handler handler = this.f1801;
        if (handler == null) {
            Log.e("GLRenderView", "queuing a runnable on a dead handler");
        } else {
            handler.postDelayed(new RunnableC0831(runnable), i);
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public synchronized void m2066(String str, Runnable runnable) {
        if (this.f1801 == null) {
            Log.e("GLRenderView", "queuing a queueRunnableSync runnable on a dead handler");
        } else {
            if (m2064(runnable)) {
                m2062(str);
            }
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m2067(Surface surface, int i, int i2) {
        m2070();
        Surface surface2 = this.f1808;
        if (surface == surface2) {
            if (surface2 == null) {
                mo1962();
                this.f1803 = false;
                return;
            }
            if (i == this.f1806 && i2 == this.f1807) {
                return;
            }
            this.f1809.m11957(this.f1810);
            this.f1806 = i;
            this.f1807 = i2;
            mo1961(i, i2);
            if (!this.f1803) {
                this.f1803 = true;
                this.f1809.m11949("fresh init (safely ignore)");
                mo1963();
            }
            if (this.f1804) {
                return;
            }
            m2068();
            return;
        }
        EGLSurface eGLSurface = this.f1810;
        if (eGLSurface != null) {
            this.f1809.m11953(eGLSurface);
            this.f1810 = null;
            this.f1806 = 0;
            this.f1807 = 0;
        }
        this.f1808 = surface;
        if (surface == null) {
            mo1962();
            this.f1803 = false;
            return;
        }
        EGLSurface eGLSurfaceM11951 = this.f1809.m11951(surface);
        this.f1810 = eGLSurfaceM11951;
        this.f1809.m11957(eGLSurfaceM11951);
        this.f1809.m11949("fresh init (safely ignore)");
        this.f1806 = i;
        this.f1807 = i2;
        if (!this.f1803) {
            this.f1803 = true;
            mo1963();
        }
        mo1961(this.f1806, this.f1807);
        if (this.f1804) {
            return;
        }
        m2068();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m2068() {
        this.f1811.postFrameCallback(this);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m2069(String str) throws InterruptedException {
        this.f1812 = str;
        if (TextUtils.isEmpty(str)) {
            this.f1812 = "filmcamera";
        }
        if (this.f1802 == null) {
            Thread thread = new Thread(new Runnable() { // from class: ű
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8951.m2072();
                }
            });
            this.f1802 = thread;
            thread.setName("GLRenderView:" + str);
            this.f1802.start();
            try {
                this.f1813.take();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            Log.d("GLRenderView", "thread is ready");
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m2070() {
        this.f1811.removeFrameCallback(this);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m2071() throws InterruptedException {
        if (this.f1802 != null) {
            Log.d("GLRenderView", "stopGL");
            if (this.f1801 != null) {
                m2064(new RunnableC0829());
                try {
                    this.f1813.take();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                this.f1802.join();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            this.f1802 = null;
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m2072() {
        Looper.prepare();
        this.f1809 = C3732.m11944(this.f1812);
        this.f1811 = Choreographer.getInstance();
        this.f1801 = new Handler(this);
        this.f1813.offer(1);
        Looper.loop();
        this.f1801 = null;
        mo1962();
        this.f1809.m11959();
    }

    public GLRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1799 = true;
        this.f1805 = false;
        this.f1813 = new ArrayBlockingQueue(1);
        this.f1814 = 0;
        this.f1815 = new Object();
        getHolder().addCallback(this);
    }
}
