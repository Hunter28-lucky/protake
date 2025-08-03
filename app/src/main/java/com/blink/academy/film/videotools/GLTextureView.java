package com.blink.academy.film.videotools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C3732;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, Choreographer.FrameCallback, Handler.Callback {
    public static int count;
    public static int id;
    public final String TAG;
    private boolean bInitialized;
    public boolean bSingleStep;
    public ArrayList<Runnable> backlog;
    public C3732 egl;
    private boolean isGLReady;
    public Choreographer mChoreographer;
    public EGLSurface mEGLSurface;
    private String mEglUser;
    private Thread mGLThread;
    public Handler mHandler;
    public int mHeight;
    public BlockingQueue<Integer> mReturnQueue;
    public long mStartTime;
    public Surface mSurface;
    public SurfaceTexture mSurfaceTexture;
    private boolean mWasPaused;
    public int mWidth;

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$Ϳ, reason: contains not printable characters */
    public class C0838 extends AbstractRunnableC0849 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ SurfaceTexture f1830;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f1831;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f1832;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0838(SurfaceTexture surfaceTexture, int i, int i2) {
            super();
            this.f1830 = surfaceTexture;
            this.f1831 = i;
            this.f1832 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView.this.setSurface(this.f1830, this.f1831, this.f1832);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$Ԩ, reason: contains not printable characters */
    public class C0839 extends AbstractRunnableC0849 {
        public C0839() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView.this.setSurface(null, 0, 0);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$Ԫ, reason: contains not printable characters */
    public class RunnableC0840 implements Runnable {
        public RunnableC0840() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView gLTextureView = GLTextureView.this;
            StringBuilder sb = new StringBuilder();
            sb.append(GLTextureView.this.mEglUser);
            int i = GLTextureView.count;
            GLTextureView.count = i + 1;
            sb.append(i);
            gLTextureView.threadEntry(sb.toString());
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$Ԭ, reason: contains not printable characters */
    public class RunnableC0841 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f1836;

        public RunnableC0841(Runnable runnable) {
            this.f1836 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1836.run();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$Ԯ, reason: contains not printable characters */
    public class RunnableC0842 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f1838;

        public RunnableC0842(Runnable runnable) {
            this.f1838 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView gLTextureView = GLTextureView.this;
            EGLSurface eGLSurface = gLTextureView.mEGLSurface;
            if (eGLSurface != null) {
                gLTextureView.egl.m11957(eGLSurface);
            } else {
                gLTextureView.egl.m11958();
            }
            this.f1838.run();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$ՠ, reason: contains not printable characters */
    public class RunnableC0843 implements Runnable {
        public RunnableC0843() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView.this.mReturnQueue.offer(1);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$ֈ, reason: contains not printable characters */
    public class RunnableC0844 implements Runnable {
        public RunnableC0844() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView.this.mReturnQueue.offer(1);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$֏, reason: contains not printable characters */
    public class RunnableC0845 implements Runnable {
        public RunnableC0845() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView.this.mReturnQueue.offer(1);
            Looper.myLooper().quitSafely();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$ׯ, reason: contains not printable characters */
    public class RunnableC0846 implements Runnable {
        public RunnableC0846() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView.this.onGLPause();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$ؠ, reason: contains not printable characters */
    public class RunnableC0847 implements Runnable {
        public RunnableC0847() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView.this.onGLResume();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$ހ, reason: contains not printable characters */
    public class C0848 extends AbstractRunnableC0849 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ SurfaceTexture f1845;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f1846;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f1847;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0848(SurfaceTexture surfaceTexture, int i, int i2) {
            super();
            this.f1845 = surfaceTexture;
            this.f1846 = i;
            this.f1847 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLTextureView gLTextureView = GLTextureView.this;
            gLTextureView.bSingleStep = false;
            gLTextureView.setSurface(this.f1845, this.f1846, this.f1847);
            GLTextureView.this.startChoreographer();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.GLTextureView$ށ, reason: contains not printable characters */
    public abstract class AbstractRunnableC0849 implements Runnable {
        public AbstractRunnableC0849() {
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.mWasPaused = true;
        this.isGLReady = true;
        StringBuilder sb = new StringBuilder();
        sb.append("GLTextureView:");
        int i = id;
        id = i + 1;
        sb.append(i);
        this.TAG = sb.toString();
        this.mReturnQueue = new ArrayBlockingQueue(1);
        this.backlog = new ArrayList<>();
        setSurfaceTextureListener(this);
    }

    private void drainQueue(String str) throws InterruptedException {
        long jNanoTime = System.nanoTime();
        queueRunnable(new RunnableC0843());
        long jNanoTime2 = System.nanoTime();
        try {
            this.mReturnQueue.take();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        long jNanoTime3 = System.nanoTime();
        Log.d(this.TAG, String.format("drained for %s, took %d ms", str, Long.valueOf((jNanoTime2 - jNanoTime) / 1000000)));
        Log.d(this.TAG, String.format("drained for %s, took %d ms", str, Long.valueOf((jNanoTime3 - jNanoTime2) / 1000000)));
    }

    private void startGLInternal() throws InterruptedException {
        Log.d(this.TAG, "starting thread");
        if (this.mGLThread == null) {
            Thread thread = new Thread(new RunnableC0840());
            this.mGLThread = thread;
            thread.setPriority(1);
            this.mGLThread.setName("GLTextureView:" + this.mEglUser);
            this.mGLThread.start();
            try {
                this.mReturnQueue.take();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            Log.d(this.TAG, "thread is ready");
        }
    }

    private synchronized void startLooper() {
        Log.d(this.TAG, "startLooper");
        if (this.mGLThread != null) {
            throw new RuntimeException("looper already going");
        }
        startGLInternal();
    }

    private synchronized void stopLooper() {
        Log.d(this.TAG, "stopLooper");
        queueRunnable(new RunnableC0845());
        try {
            this.mReturnQueue.take();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        try {
            this.mGLThread.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        this.mGLThread = null;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.mEGLSurface == null || !isGLReady()) {
            this.mChoreographer.postFrameCallback(this);
            return;
        }
        if (this.mWasPaused) {
            this.mStartTime = j;
            this.mWasPaused = false;
        }
        this.egl.m11957(this.mEGLSurface);
        C3732.m11943("before render");
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        GLES20.glScissor(0, 0, this.mWidth, this.mHeight);
        long j2 = (j - this.mStartTime) / 1000000;
        System.nanoTime();
        onGLRender(j2 / 1000.0d, j);
        System.nanoTime();
        C3732.m11943("after render");
        if (this.bSingleStep) {
            return;
        }
        this.mChoreographer.postFrameCallback(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        return false;
    }

    public boolean isGLReady() {
        return this.isGLReady;
    }

    public void onGLChangedSize(int i, int i2) {
    }

    public void onGLDestroy() {
    }

    public void onGLInit() {
    }

    public void onGLPause() {
        this.bSingleStep = true;
    }

    public void onGLRender(double d, long j) {
    }

    public void onGLResume() {
        this.bSingleStep = false;
        resumeChoreographer();
    }

    public void onPause() throws InterruptedException {
        Log.d(this.TAG, "onPause");
        queueRunnable(new RunnableC0846());
        drainQueue();
    }

    public void onResume() {
        Log.d(this.TAG, "onResume");
        queueRunnable(new RunnableC0847());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.d(this.TAG, "surfaceCreated");
        startLooper();
        queueRunnable(new C0848(surfaceTexture, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.d(this.TAG, "surfaceDestroyed");
        this.bSingleStep = true;
        queueRunnable(new C0839());
        stopLooper();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.d(this.TAG, "surfaceChanged:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
        queueRunnable(new C0838(surfaceTexture, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueRunnable(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler == null) {
            this.backlog.add(runnable);
        } else {
            handler.post(new RunnableC0841(runnable));
        }
    }

    public void queueRunnableDelayed(Runnable runnable, int i) {
        Handler handler = this.mHandler;
        if (handler == null) {
            Log.e(this.TAG, "queuing a runnable on a dead handler");
        } else {
            handler.postDelayed(new RunnableC0842(runnable), i);
        }
    }

    public synchronized void queueRunnableSync(String str, Runnable runnable) {
        if (this.mHandler == null) {
            Log.e(this.TAG, "queuing a queueRunnableSync runnable on a dead handler");
        } else {
            queueRunnable(runnable);
            drainQueue(str);
        }
    }

    public void resume() {
        onResume();
    }

    public void resumeChoreographer() {
        startChoreographer();
    }

    public void setGLReady(boolean z) {
        this.isGLReady = z;
    }

    public void setSurface(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.d(this.TAG, String.format("setSurface:%s", surfaceTexture));
        if (surfaceTexture == this.mSurfaceTexture) {
            if (i == this.mWidth && i2 == this.mHeight) {
                return;
            }
            this.mWidth = i;
            this.mHeight = i2;
            onGLChangedSize(i, i2);
            return;
        }
        EGLSurface eGLSurface = this.mEGLSurface;
        if (eGLSurface != null) {
            this.egl.m11953(eGLSurface);
            this.mEGLSurface = null;
            this.mWidth = -1;
            this.mHeight = -1;
        }
        if (surfaceTexture == null) {
            this.mSurfaceTexture = null;
            onGLDestroy();
            this.bInitialized = false;
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        this.mSurfaceTexture = surfaceTexture;
        EGLSurface eGLSurfaceM11951 = this.egl.m11951(surface);
        this.mEGLSurface = eGLSurfaceM11951;
        this.egl.m11957(eGLSurfaceM11951);
        this.mWidth = i;
        this.mHeight = i2;
        if (!this.bInitialized) {
            this.bInitialized = true;
            onGLInit();
        }
        onGLChangedSize(this.mWidth, this.mHeight);
    }

    public void startChoreographer() {
        Log.d(this.TAG, "startChreographer");
        this.mChoreographer.postFrameCallback(this);
    }

    public void startGL(String str) {
        this.mEglUser = str;
    }

    public void stop() {
    }

    public synchronized void stopChoreographer() {
        Log.d(this.TAG, "stopChreographer");
        this.mChoreographer.removeFrameCallback(this);
    }

    public void threadEntry(String str) {
        Log.d(this.TAG, "threadEntry");
        Looper.prepare();
        this.egl = C3732.m11944(str);
        this.mChoreographer = Choreographer.getInstance();
        this.mHandler = new Handler(this);
        this.mReturnQueue.offer(1);
        Iterator<Runnable> it = this.backlog.iterator();
        while (it.hasNext()) {
            queueRunnable(it.next());
        }
        this.backlog.clear();
        Looper.loop();
        onGLDestroy();
        this.egl.m11959();
        this.egl = null;
        this.mHandler = null;
        this.mChoreographer.removeFrameCallback(this);
        this.mChoreographer = null;
    }

    public void tryDrainQueue() throws InterruptedException {
        if (this.mGLThread == null) {
            return;
        }
        drainQueue();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWasPaused = true;
        this.isGLReady = true;
        StringBuilder sb = new StringBuilder();
        sb.append("GLTextureView:");
        int i = id;
        id = i + 1;
        sb.append(i);
        this.TAG = sb.toString();
        this.mReturnQueue = new ArrayBlockingQueue(1);
        this.backlog = new ArrayList<>();
        setSurfaceTextureListener(this);
    }

    public void drainQueue() throws InterruptedException {
        queueRunnable(new RunnableC0844());
        try {
            this.mReturnQueue.take();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        Log.d(this.TAG, "drained");
    }
}
