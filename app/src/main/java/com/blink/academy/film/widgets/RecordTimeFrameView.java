package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.TextureView;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.stream.ACHelper;
import defpackage.C4792;
import defpackage.o4;

/* loaded from: classes.dex */
public class RecordTimeFrameView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2455;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2456;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f2457;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2458;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f2459;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f2460;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f2461;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f2462;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f2463;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Handler f2464;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f2465;

    /* renamed from: com.blink.academy.film.widgets.RecordTimeFrameView$Ϳ, reason: contains not printable characters */
    public class RunnableC0942 implements Runnable {
        public RunnableC0942() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordTimeFrameView.this.m2512();
        }
    }

    public RecordTimeFrameView(Context context) {
        this(context, null);
    }

    public float getLayoutHeight() {
        return this.f2455.descent() - this.f2455.ascent();
    }

    public float getLayoutWidth() {
        return this.f2459;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Canvas canvasLockCanvas = null;
        try {
            canvasLockCanvas = lockCanvas(null);
            synchronized (surfaceTexture) {
                draw(canvasLockCanvas);
            }
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
                if (canvasLockCanvas != null) {
                    unlockCanvasAndPost(canvasLockCanvas);
                }
            } finally {
                if (canvasLockCanvas != null) {
                    unlockCanvasAndPost(canvasLockCanvas);
                }
            }
        }
        m2511(0L, 0, false);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setRecordMode(boolean z) {
        this.f2463 = z;
        if (z) {
            this.f2459 = this.f2455.measureText(String.format("%s:%s:%s", "00", "00", "00")) + C4792.f16138;
            this.f2460 = this.f2455.descent() + this.f2455.ascent();
        } else {
            this.f2459 = this.f2455.measureText(String.format("%s:%s:%s:%s", "00", "00", "00", "00")) + C4792.f16138;
            this.f2460 = this.f2455.descent() + this.f2455.ascent();
        }
        m2511(0L, 0, false);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2509(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.f2455);
        canvas.drawText(str, f, f2, this.f2456);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2510() {
        setSurfaceTextureListener(this);
        setOpaque(false);
        Paint paint = new Paint();
        this.f2456 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2456.setAntiAlias(true);
        this.f2456.setTextSize(C4792.m14375().m14384());
        Paint paint2 = new Paint();
        this.f2455 = paint2;
        paint2.setStrokeWidth(this.f2462);
        this.f2455.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2455.setStyle(Paint.Style.STROKE);
        this.f2455.setStrokeJoin(Paint.Join.ROUND);
        this.f2455.setStrokeCap(Paint.Cap.ROUND);
        this.f2455.setAntiAlias(true);
        this.f2455.setTextSize(C4792.m14375().m14384());
        this.f2456.setTypeface(FilmApp.m404());
        this.f2455.setTypeface(FilmApp.m404());
        this.f2459 = this.f2455.measureText(String.format("%s:%s:%s:%s", "00", "00", "00", "00")) + C4792.f16138;
        this.f2460 = this.f2455.descent() + this.f2455.ascent();
        HandlerThread handlerThread = new HandlerThread("RecordTimeFrameView");
        handlerThread.setPriority(1);
        handlerThread.start();
        this.f2464 = new Handler(handlerThread.getLooper());
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2511(long j, int i, boolean z) {
        this.f2457 = j;
        this.f2458 = i;
        this.f2461 = z;
        try {
            if (isAvailable()) {
                this.f2464.post(new RunnableC0942());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m2512() {
        String strM7687;
        String strM7689;
        String strM7685;
        String strM7686 = "00";
        if (this.f2457 == 0) {
            if (this.f2461) {
                this.f2456.setColor(this.f2465);
            } else {
                this.f2456.setColor(-1);
            }
            strM7687 = "00";
            strM7689 = strM7687;
            strM7685 = strM7689;
        } else {
            this.f2456.setColor(this.f2465);
            strM7686 = o4.m7686(this.f2457);
            strM7687 = o4.m7687(this.f2457);
            strM7689 = o4.m7689(this.f2457);
            int iRound = Math.round((o4.m7688(this.f2457) * this.f2458) / 100.0f);
            if (iRound >= this.f2458) {
                iRound = 0;
            }
            strM7685 = o4.m7685(iRound);
        }
        this.f2456.setAlpha(255);
        this.f2455.setAlpha(255);
        String str = this.f2463 ? String.format("%s:%s:%s", strM7686, strM7687, strM7689) : String.format("%s:%s:%s:%s", strM7686, strM7687, strM7689, strM7685);
        ACHelper.getInstance().setAlbumHomeTimelapseStr(str);
        int width = (int) (((getWidth() / 2.0f) - (this.f2459 / 2.0f)) + (this.f2462 / 2.0f));
        int height = (int) ((getHeight() / 2.0f) - (this.f2460 / 2.0f));
        try {
            Canvas canvasLockCanvas = lockCanvas(null);
            if (canvasLockCanvas != null) {
                canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                m2509(canvasLockCanvas, str, width, height);
            }
            if (isAvailable()) {
                unlockCanvasAndPost(canvasLockCanvas);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m2513(String str) {
        try {
            Canvas canvasLockCanvas = lockCanvas(null);
            if (canvasLockCanvas != null) {
                canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                m2509(canvasLockCanvas, str, (int) (this.f2462 / 2.0f), (int) ((getHeight() / 2.0f) - (this.f2460 / 2.0f)));
            }
            if (isAvailable()) {
                unlockCanvasAndPost(canvasLockCanvas);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public RecordTimeFrameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordTimeFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2462 = C4792.f16138;
        this.f2465 = -1;
        m2510();
    }
}
