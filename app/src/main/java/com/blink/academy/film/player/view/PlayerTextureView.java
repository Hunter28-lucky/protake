package com.blink.academy.film.player.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import com.blink.academy.film.home.HomeActivity;
import com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface;
import com.blink.academy.film.player.jz.cn.jzvd.JZTextureView;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.ConnectionManager;
import com.blink.academy.film.stream.secondscreen.SecondScreenPresenter;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.filter.core.C1788;
import com.blink.academy.filter.core.Drawable2d;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C3732;
import defpackage.C4378;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4874;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class PlayerTextureView extends JZTextureView implements TextureView.SurfaceTextureListener, Choreographer.FrameCallback, Handler.Callback {

    /* renamed from: ޘ, reason: contains not printable characters */
    public static int f1203;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f1204;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f1205;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f1206;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Handler f1207;

    /* renamed from: ԯ, reason: contains not printable characters */
    public JZMediaInterface f1208;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f1209;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f1210;

    /* renamed from: ֏, reason: contains not printable characters */
    public C4874 f1211;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Drawable2d f1212;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C1788 f1213;

    /* renamed from: ހ, reason: contains not printable characters */
    public final float[] f1214;

    /* renamed from: ށ, reason: contains not printable characters */
    public final float[] f1215;

    /* renamed from: ނ, reason: contains not printable characters */
    public final String f1216;

    /* renamed from: ރ, reason: contains not printable characters */
    public Thread f1217;

    /* renamed from: ބ, reason: contains not printable characters */
    public boolean f1218;

    /* renamed from: ޅ, reason: contains not printable characters */
    public boolean f1219;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f1220;

    /* renamed from: އ, reason: contains not printable characters */
    public int f1221;

    /* renamed from: ވ, reason: contains not printable characters */
    public Surface f1222;

    /* renamed from: މ, reason: contains not printable characters */
    public SurfaceTexture f1223;

    /* renamed from: ފ, reason: contains not printable characters */
    public C3732 f1224;

    /* renamed from: ދ, reason: contains not printable characters */
    public EGLSurface f1225;

    /* renamed from: ތ, reason: contains not printable characters */
    public Choreographer f1226;

    /* renamed from: ލ, reason: contains not printable characters */
    public BlockingQueue<Integer> f1227;

    /* renamed from: ގ, reason: contains not printable characters */
    public InterfaceC0592 f1228;

    /* renamed from: ޏ, reason: contains not printable characters */
    public String f1229;

    /* renamed from: ސ, reason: contains not printable characters */
    public ArrayList<Runnable> f1230;

    /* renamed from: ޑ, reason: contains not printable characters */
    public long f1231;

    /* renamed from: ޒ, reason: contains not printable characters */
    public C4378 f1232;

    /* renamed from: ޓ, reason: contains not printable characters */
    public SurfaceTexture.OnFrameAvailableListener f1233;

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean f1234;

    /* renamed from: ޕ, reason: contains not printable characters */
    public HandlerThread f1235;

    /* renamed from: ޖ, reason: contains not printable characters */
    public boolean f1236;

    /* renamed from: ޗ, reason: contains not printable characters */
    public boolean f1237;

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$Ϳ, reason: contains not printable characters */
    public class C0576 implements Handler.Callback {
        public C0576() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                if (PlayerTextureView.this.f1234) {
                    long jNanoTime = System.nanoTime();
                    message.getTarget().sendEmptyMessageDelayed(1, 33L);
                    PlayerTextureView.this.m1641();
                    long jNanoTime2 = System.nanoTime();
                    if (PlayerTextureView.this.f1204) {
                        C4638.m14099("TimeTest", String.format("startLoopSendFrame cost : %sms", Long.valueOf((jNanoTime2 - jNanoTime) / 1000000)));
                    }
                } else {
                    PlayerTextureView.this.f1235.quitSafely();
                    PlayerTextureView.this.f1235 = null;
                    if (PlayerTextureView.this.f1204) {
                        C4638.m14099("TimeTest", "startLoopSendFrame LoopThread quit");
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$Ԩ, reason: contains not printable characters */
    public class C0577 extends AbstractRunnableC0593 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ SurfaceTexture f1239;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f1240;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f1241;

        /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$Ԩ$Ϳ, reason: contains not printable characters */
        public class RunnableC0578 implements Runnable {
            public RunnableC0578() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerTextureView.this.f1208 == null || PlayerTextureView.this.f1232 == null) {
                    return;
                }
                PlayerTextureView.this.f1208.onSurfaceTextureAvailable(PlayerTextureView.this.f1232.m13551(), PlayerTextureView.this.f1209, PlayerTextureView.this.f1210);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0577(SurfaceTexture surfaceTexture, int i, int i2) {
            super();
            this.f1239 = surfaceTexture;
            this.f1240 = i;
            this.f1241 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTextureView playerTextureView = PlayerTextureView.this;
            playerTextureView.f1219 = false;
            playerTextureView.f1231 = 0L;
            PlayerTextureView.this.m1645(this.f1239, this.f1240, this.f1241);
            PlayerTextureView.this.m1647();
            if (PlayerTextureView.this.f1204) {
                PlayerTextureView playerTextureView2 = PlayerTextureView.this;
                Log.d(playerTextureView2.f1216, String.format("OESTexture w : %s , h : %s ", Integer.valueOf(playerTextureView2.f1209), Integer.valueOf(PlayerTextureView.this.f1210)));
            }
            PlayerTextureView playerTextureView3 = PlayerTextureView.this;
            playerTextureView3.f1232 = new C4378(playerTextureView3.f1209, PlayerTextureView.this.f1210, PlayerTextureView.this.f1233);
            PlayerTextureView.this.post(new RunnableC0578());
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$Ԫ, reason: contains not printable characters */
    public class C0579 extends AbstractRunnableC0593 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ SurfaceTexture f1244;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f1245;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f1246;

        /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC0580 implements Runnable {
            public RunnableC0580() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerTextureView.this.f1208 == null) {
                    return;
                }
                JZMediaInterface jZMediaInterface = PlayerTextureView.this.f1208;
                C0579 c0579 = C0579.this;
                jZMediaInterface.onSurfaceTextureSizeChanged(c0579.f1244, c0579.f1245, c0579.f1246);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0579(SurfaceTexture surfaceTexture, int i, int i2) {
            super();
            this.f1244 = surfaceTexture;
            this.f1245 = i;
            this.f1246 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTextureView.this.m1645(this.f1244, this.f1245, this.f1246);
            PlayerTextureView.this.post(new RunnableC0580());
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$Ԭ, reason: contains not printable characters */
    public class C0581 extends AbstractRunnableC0593 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ SurfaceTexture f1249;

        /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$Ԭ$Ϳ, reason: contains not printable characters */
        public class RunnableC0582 implements Runnable {
            public RunnableC0582() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerTextureView.this.f1208 == null) {
                    return;
                }
                PlayerTextureView.this.f1208.onSurfaceTextureDestroyed(C0581.this.f1249);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0581(SurfaceTexture surfaceTexture) {
            super();
            this.f1249 = surfaceTexture;
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTextureView.this.m1651();
            PlayerTextureView.this.m1645(null, 0, 0);
            PlayerTextureView.this.post(new RunnableC0582());
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$Ԯ, reason: contains not printable characters */
    public class RunnableC0583 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ SurfaceTexture f1252;

        /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$Ԯ$Ϳ, reason: contains not printable characters */
        public class RunnableC0584 implements Runnable {
            public RunnableC0584() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerTextureView.this.f1208 == null) {
                    return;
                }
                PlayerTextureView.this.f1208.onSurfaceTextureUpdated(RunnableC0583.this.f1252);
            }
        }

        public RunnableC0583(SurfaceTexture surfaceTexture) {
            this.f1252 = surfaceTexture;
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTextureView.this.post(new RunnableC0584());
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$ՠ, reason: contains not printable characters */
    public class RunnableC0585 implements Runnable {
        public RunnableC0585() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTextureView playerTextureView = PlayerTextureView.this;
            playerTextureView.m1653(playerTextureView.f1229);
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$ֈ, reason: contains not printable characters */
    public class RunnableC0586 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f1256;

        public RunnableC0586(Runnable runnable) {
            this.f1256 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1256.run();
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$֏, reason: contains not printable characters */
    public class RunnableC0587 implements Runnable {
        public RunnableC0587() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTextureView.this.f1227.offer(1);
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$ׯ, reason: contains not printable characters */
    public class RunnableC0588 implements Runnable {
        public RunnableC0588() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTextureView.this.f1227.offer(1);
            Looper.myLooper().quitSafely();
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$ؠ, reason: contains not printable characters */
    public class RunnableC0589 implements Runnable {
        public RunnableC0589() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTextureView.this.m1651();
            PlayerTextureView.this.m1634();
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$ހ, reason: contains not printable characters */
    public class RunnableC0590 implements Runnable {
        public RunnableC0590() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTextureView.this.m1636();
            PlayerTextureView.this.m1628();
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$ށ, reason: contains not printable characters */
    public class C0591 implements SurfaceTexture.OnFrameAvailableListener {
        public C0591() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            PlayerTextureView.this.m1640(surfaceTexture, true, 0.0d);
        }
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$ނ, reason: contains not printable characters */
    public interface InterfaceC0592 {
        /* renamed from: Ϳ */
        void mo1613();
    }

    /* renamed from: com.blink.academy.film.player.view.PlayerTextureView$ރ, reason: contains not printable characters */
    public abstract class AbstractRunnableC0593 implements Runnable {
        public AbstractRunnableC0593() {
        }
    }

    public PlayerTextureView(Context context) {
        super(context);
        this.f1204 = false;
        this.f1205 = true;
        this.f1214 = new float[16];
        this.f1215 = new float[16];
        StringBuilder sb = new StringBuilder();
        sb.append("PlayerTextureView:");
        int i = f1203;
        f1203 = i + 1;
        sb.append(i);
        this.f1216 = sb.toString();
        this.f1227 = new ArrayBlockingQueue(1);
        this.f1230 = new ArrayList<>();
        this.f1231 = 0L;
        this.f1233 = new C0591();
        this.f1236 = false;
        this.f1237 = false;
        setSurfaceTextureListener(this);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.f1225 == null || !m1630()) {
            this.f1226.postFrameCallback(this);
            return;
        }
        if (this.f1205) {
            this.f1206 = j;
            this.f1205 = false;
        }
        this.f1224.m11957(this.f1225);
        C3732.m11943("before render");
        GLES20.glViewport(0, 0, this.f1220, this.f1221);
        GLES20.glScissor(0, 0, this.f1220, this.f1221);
        long j2 = (j - this.f1206) / 1000000;
        System.nanoTime();
        m1635(j2 / 1000.0d, j);
        System.nanoTime();
        C3732.m11943("after render");
        if (this.f1219) {
            return;
        }
        this.f1226.postFrameCallback(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f1204) {
            Log.d(this.f1216, "surfaceCreated width : " + i + " height : " + i2);
        }
        m1650();
        m1639(new C0577(surfaceTexture, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.f1204) {
            Log.d(this.f1216, "surfaceDestroyed");
        }
        this.f1219 = true;
        m1639(new C0581(surfaceTexture));
        m1652();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f1204) {
            Log.d(this.f1216, "surfaceChanged:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
        }
        m1639(new C0579(surfaceTexture, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != this.f1223) {
            m1639(new RunnableC0583(surfaceTexture));
        }
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(@NonNull SurfaceTexture surfaceTexture) {
        super.setSurfaceTexture(surfaceTexture);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m1628() {
        if (this.f1234) {
            return;
        }
        this.f1234 = true;
        m1641();
        m1649();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m1629() throws InterruptedException {
        m1639(new RunnableC0587());
        try {
            this.f1227.take();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (this.f1204) {
            Log.d(this.f1216, "drained");
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean m1630() {
        return true;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m1631(int i, int i2) {
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m1632() {
        C4874 c4874 = this.f1211;
        if (c4874 != null) {
            c4874.mo4800();
            this.f1211 = null;
        }
        this.f1237 = false;
        C1788 c1788 = this.f1213;
        if (c1788 != null) {
            c1788.m4789();
            this.f1213 = null;
        }
        C4378 c4378 = this.f1232;
        if (c4378 != null) {
            c4378.m13549();
            this.f1232 = null;
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m1633() {
        Matrix.setIdentityM(this.f1215, 0);
        Matrix.setIdentityM(this.f1214, 0);
        this.f1211 = new C4874();
        this.f1212 = new Drawable2d();
        C1788 c1788 = new C1788(this.f1209, this.f1210);
        this.f1213 = c1788;
        c1788.m4793();
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m1634() {
        this.f1219 = true;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m1635(double d, long j) {
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m1636() {
        this.f1219 = false;
        m1642();
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m1637() throws InterruptedException {
        if (this.f1204) {
            Log.d(this.f1216, "onPause");
        }
        if (this.f1207 == null) {
            return;
        }
        m1639(new RunnableC0589());
        m1629();
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m1638() {
        if (this.f1204) {
            Log.d(this.f1216, "onResume");
        }
        m1650();
        m1639(new RunnableC0590());
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m1639(Runnable runnable) {
        Handler handler = this.f1207;
        if (handler == null) {
            this.f1230.add(runnable);
        } else {
            handler.post(new RunnableC0586(runnable));
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m1640(SurfaceTexture surfaceTexture, boolean z, double d) {
        InterfaceC0592 interfaceC0592;
        EGLSurface eGLSurface = this.f1225;
        if (eGLSurface == null) {
            return;
        }
        this.f1224.m11957(eGLSurface);
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.f1214);
        GLES20.glViewport(0, 0, this.f1220, this.f1221);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1211.mo4802(this.f1232.m13552(), this.f1215, this.f1214, this.f1212);
        EGLSurface eGLSurface2 = this.f1225;
        if (eGLSurface2 != null) {
            this.f1224.m11960(eGLSurface2);
        }
        long j = this.f1231 + 1;
        this.f1231 = j;
        if (j == 2 && (interfaceC0592 = this.f1228) != null) {
            interfaceC0592.mo1613();
        }
        this.f1213.m4786();
        this.f1211.mo4802(this.f1232.m13552(), this.f1215, this.f1214, this.f1212);
        this.f1213.m4793();
        this.f1237 = true;
        m1628();
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m1641() {
        if (this.f1237) {
            SecondScreenPresenter secondScreenPresenter = SecondScreenPresenter.getInstance(HomeActivity.m700(), C4535.m13880().m13902());
            if (secondScreenPresenter != null) {
                int iM4792 = this.f1213.m4792();
                C1788 c1788 = this.f1213;
                secondScreenPresenter.drawPlayerTex(iM4792, c1788.f5101, c1788.f5102);
            }
            if (TransmitHelper.getInstance().isStartCameraTransmit()) {
                long jNanoTime = System.nanoTime();
                if (ACHelper.getInstance().isCameraIsAlbumMode() && TransmitHelper.getInstance().isStartCameraTransmit()) {
                    ConnectionManager.getInstance().renderFrameEncoder(this.f1213.m4792(), 0);
                }
                long jNanoTime2 = System.nanoTime();
                if (this.f1204) {
                    long j = jNanoTime2 - jNanoTime;
                    C4638.m14099(this.f1216, String.format("cost : %s ns . %s ms", Long.valueOf(j), Long.valueOf(j / 1000000)));
                }
            }
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m1642() {
        m1647();
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public PlayerTextureView m1643(InterfaceC0592 interfaceC0592) {
        this.f1228 = interfaceC0592;
        return this;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public PlayerTextureView m1644(JZMediaInterface jZMediaInterface) {
        this.f1208 = jZMediaInterface;
        return this;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m1645(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f1204) {
            Log.d(this.f1216, String.format("setSurface:%s", surfaceTexture));
        }
        if (surfaceTexture == this.f1223) {
            if (i == this.f1220 && i2 == this.f1221) {
                return;
            }
            this.f1220 = i;
            this.f1221 = i2;
            m1631(i, i2);
            return;
        }
        EGLSurface eGLSurface = this.f1225;
        if (eGLSurface != null) {
            this.f1224.m11953(eGLSurface);
            this.f1225 = null;
            this.f1220 = -1;
            this.f1221 = -1;
        }
        if (surfaceTexture == null) {
            this.f1223 = null;
            m1632();
            this.f1218 = false;
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        this.f1222 = surface;
        this.f1223 = surfaceTexture;
        EGLSurface eGLSurfaceM11951 = this.f1224.m11951(surface);
        this.f1225 = eGLSurfaceM11951;
        this.f1224.m11957(eGLSurfaceM11951);
        this.f1220 = i;
        this.f1221 = i2;
        if (!this.f1218) {
            this.f1218 = true;
            m1633();
        }
        m1631(this.f1220, this.f1221);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m1646(int i, int i2) {
        if (this.f1204) {
            Log.d(this.f1216, String.format("setVideoWidthAndHeight w : %s , h : %s ", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        this.f1209 = i;
        this.f1210 = i2;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m1647() {
        if (this.f1204) {
            Log.d(this.f1216, "startChreographer");
        }
        this.f1226.postFrameCallback(this);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m1648() throws InterruptedException {
        if (this.f1204) {
            Log.d(this.f1216, "starting thread");
        }
        if (this.f1217 == null) {
            Thread thread = new Thread(new RunnableC0585());
            this.f1217 = thread;
            thread.setPriority(1);
            this.f1217.setName("GLTextureView:" + this.f1229);
            this.f1217.start();
            try {
                this.f1227.take();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (this.f1204) {
                Log.d(this.f1216, "thread is ready");
            }
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m1649() {
        HandlerThread handlerThread = this.f1235;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f1235 = null;
        }
        HandlerThread handlerThread2 = new HandlerThread("LoopThread");
        this.f1235 = handlerThread2;
        handlerThread2.start();
        new Handler(this.f1235.getLooper(), new C0576()).sendEmptyMessage(1);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final synchronized void m1650() {
        if (this.f1204) {
            Log.d(this.f1216, "startLooper");
        }
        if (this.f1217 != null) {
            return;
        }
        m1648();
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m1651() {
        this.f1234 = false;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final synchronized void m1652() {
        if (this.f1204) {
            Log.d(this.f1216, "stopLooper");
        }
        m1639(new RunnableC0588());
        try {
            this.f1227.take();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        try {
            this.f1217.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        this.f1217 = null;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public void m1653(String str) {
        if (this.f1204) {
            Log.d(this.f1216, "threadEntry");
        }
        Looper.prepare();
        this.f1224 = C3732.m11944(str);
        this.f1226 = Choreographer.getInstance();
        this.f1207 = new Handler(this);
        this.f1227.offer(1);
        Iterator<Runnable> it = this.f1230.iterator();
        while (it.hasNext()) {
            m1639(it.next());
        }
        this.f1230.clear();
        Looper.loop();
        m1632();
        this.f1224.m11959();
        this.f1224 = null;
        this.f1207 = null;
        this.f1226.removeFrameCallback(this);
        this.f1226 = null;
    }

    public PlayerTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1204 = false;
        this.f1205 = true;
        this.f1214 = new float[16];
        this.f1215 = new float[16];
        StringBuilder sb = new StringBuilder();
        sb.append("PlayerTextureView:");
        int i = f1203;
        f1203 = i + 1;
        sb.append(i);
        this.f1216 = sb.toString();
        this.f1227 = new ArrayBlockingQueue(1);
        this.f1230 = new ArrayList<>();
        this.f1231 = 0L;
        this.f1233 = new C0591();
        this.f1236 = false;
        this.f1237 = false;
        setSurfaceTextureListener(this);
    }
}
