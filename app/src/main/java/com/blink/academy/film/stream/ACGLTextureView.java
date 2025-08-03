package com.blink.academy.film.stream;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.videotools.GLTextureView;
import com.blink.academy.filter.core.TextureFormat;
import defpackage.AbstractC4012;
import defpackage.C2870;
import defpackage.C3439;
import defpackage.C3483;
import defpackage.C4008;
import defpackage.C4041;
import defpackage.C4327;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ACGLTextureView extends GLTextureView {
    private boolean canRender;
    private boolean canShow;
    private int decoderHeight;
    private int decoderWidth;
    private C2870.InterfaceC2871 faceDetectCallback;
    private boolean faceDetectEnable;
    private C2870 faceDetectEngine;
    private C4327 gpuImageFilter;
    private boolean isAnim;
    private int linkIndex;
    private FloatBuffer mGLCubeBuffer;
    private FloatBuffer mGLTextureBuffer;
    private long mLastRenderTime;
    public float[] mRenderMatrix;
    private int mTexId;
    private OnRenderFinish onRenderFinish;
    public int outHeight;
    public int outWidth;
    public int outX;
    public int outY;
    private int pixelFormat;
    private boolean single;
    private boolean skipOverrideRender;
    private int streamType;

    public interface OnRenderFinish {
        void onFinish();
    }

    public ACGLTextureView(@NonNull Context context) {
        this(context, null);
    }

    private void clearFaceData() {
        C2870.InterfaceC2871 interfaceC2871 = this.faceDetectCallback;
        if (interfaceC2871 != null) {
            interfaceC2871.onFaceDetected(new ArrayList(), 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRender() {
        try {
            if (getAlpha() == 0.0f) {
                clearFaceData();
                return;
            }
            this.mLastRenderTime = System.currentTimeMillis();
            clearAnimation();
            setAlpha(0.0f);
            this.isAnim = false;
            this.mTexId = -1;
            this.egl.m11957(this.mEGLSurface);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            GLES20.glScissor(0, 0, this.mWidth, this.mHeight);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            this.egl.m11960(this.mEGLSurface);
            if (this.single) {
                C4041.m12950();
            }
            clearFaceData();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFaceDetectEngine() {
        if (this.faceDetectEngine == null) {
            C2870 c2870 = new C2870(EGL14.eglGetCurrentContext());
            this.faceDetectEngine = c2870;
            c2870.m10223(new C2870.InterfaceC2871() { // from class: com.blink.academy.film.stream.ACGLTextureView.2
                @Override // defpackage.C2870.InterfaceC2871
                public void onFaceDetected(List<C3483> list, int i, int i2) {
                    if (ACGLTextureView.this.faceDetectCallback != null) {
                        ACGLTextureView.this.faceDetectCallback.onFaceDetected(list, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performDraw() {
        int i;
        this.egl.m11957(this.mEGLSurface);
        this.outX = 0;
        int i2 = this.mWidth;
        this.outWidth = i2;
        int i3 = this.mHeight;
        int i4 = (int) (i3 / 1.0f);
        this.outHeight = i4;
        int i5 = i4 - (i4 % 2);
        this.outHeight = i5;
        this.outY = (i3 - i5) / 2;
        int i6 = this.decoderHeight;
        if (i6 != 0 && (i = this.decoderWidth) != 0) {
            float f = (i * 1.0f) / i6;
            this.outHeight = i3;
            int i7 = (int) (i3 * f);
            this.outWidth = i7;
            int i8 = i7 - (i7 % 2);
            this.outWidth = i8;
            if (i8 > i2) {
                this.outWidth = i2;
                int i9 = (int) (i2 / f);
                this.outHeight = i9;
                this.outHeight = i9 - (i9 % 2);
            }
            this.outX = (i2 - this.outWidth) / 2;
            int i10 = this.outHeight;
            this.outY = (i3 - i10) / 2;
            if (i > i6) {
                int i11 = this.streamType;
                float f2 = i11 == 1 ? 1.3333334f : i11 == 2 ? 1.55f : 1.0f;
                if (f2 != 1.0f) {
                    int i12 = (int) (i10 / f2);
                    this.outHeight = i12;
                    int i13 = i12 - (i12 % 2);
                    this.outHeight = i13;
                    this.outY = (i3 - i13) / 2;
                }
            }
        }
        GLES20.glViewport(this.outX, this.outY, this.outWidth, this.outHeight);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.gpuImageFilter.m13479(this.mTexId, this.mGLCubeBuffer, this.mGLTextureBuffer);
        C2870 c2870 = this.faceDetectEngine;
        if (c2870 != null) {
            c2870.m10221(this.mTexId, TextureFormat.f5094, this.decoderWidth, this.decoderHeight, false, false);
        }
        GLES20.glFinish();
        C3439.f11831.m11210();
        this.egl.m11960(this.mEGLSurface);
        if (this.single) {
            C4041.m12964(this.mTexId, false, false, false, 0);
            C4041.m12960();
        }
        OnRenderFinish onRenderFinish = this.onRenderFinish;
        if (onRenderFinish != null) {
            onRenderFinish.onFinish();
        }
        this.mLastRenderTime = System.currentTimeMillis();
        if (getAlpha() == 0.0f && !this.isAnim && this.canShow) {
            this.isAnim = true;
            post(new Runnable() { // from class: com.blink.academy.film.stream.ACGLTextureView.5
                @Override // java.lang.Runnable
                public void run() {
                    C4008.m12876(ACGLTextureView.this, 1.0f, 200, new AbstractC4012() { // from class: com.blink.academy.film.stream.ACGLTextureView.5.1
                        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
                        public void onAnimationEnd(View view) {
                            ACGLTextureView.this.isAnim = false;
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseFaceDetectEngine() {
        C2870 c2870 = this.faceDetectEngine;
        if (c2870 != null) {
            c2870.m10222();
            this.faceDetectEngine = null;
        }
        clearFaceData();
    }

    public void clearCallback() {
        this.onRenderFinish = null;
    }

    public void doDraw() {
        queueRunnable(new Runnable() { // from class: com.blink.academy.film.stream.ACGLTextureView.4
            @Override // java.lang.Runnable
            public void run() {
                if (!ACGLTextureView.this.canRender) {
                    ACGLTextureView.this.clearRender();
                } else {
                    if (ACGLTextureView.this.mTexId < 0) {
                        return;
                    }
                    ACGLTextureView.this.performDraw();
                }
            }
        });
    }

    public void enableFaceDetectEngine(boolean z) {
        this.faceDetectEnable = z;
        queueRunnable(new Runnable() { // from class: com.blink.academy.film.stream.ACGLTextureView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ACGLTextureView.this.faceDetectEnable) {
                    ACGLTextureView.this.initFaceDetectEngine();
                } else {
                    ACGLTextureView.this.releaseFaceDetectEngine();
                }
            }
        });
    }

    public int getTexId() {
        return this.mTexId;
    }

    public boolean isCanRender() {
        return this.canRender;
    }

    @Override // com.blink.academy.film.videotools.GLTextureView
    public void onGLChangedSize(int i, int i2) {
        super.onGLChangedSize(i, i2);
    }

    @Override // com.blink.academy.film.videotools.GLTextureView
    public void onGLDestroy() {
        super.onGLDestroy();
        C4041.m12963();
        releaseFaceDetectEngine();
    }

    @Override // com.blink.academy.film.videotools.GLTextureView
    public void onGLInit() {
        super.onGLInit();
        C4327 c4327 = new C4327();
        this.gpuImageFilter = c4327;
        c4327.m13477();
        float[] fArr = new float[16];
        this.mRenderMatrix = fArr;
        Matrix.setIdentityM(fArr, 0);
        this.mGLCubeBuffer.clear();
        this.mGLCubeBuffer.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f}).position(0);
        this.mGLTextureBuffer.clear();
        this.mGLTextureBuffer.put(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f}).position(0);
        if (this.faceDetectEnable) {
            initFaceDetectEngine();
        }
    }

    @Override // com.blink.academy.film.videotools.GLTextureView
    public void onGLRender(double d, long j) {
        super.onGLRender(d, j);
        if (this.mLastRenderTime == 0 || System.currentTimeMillis() - this.mLastRenderTime <= 3000) {
            return;
        }
        clearRender();
    }

    public void setCanRender(boolean z) {
        this.canRender = z;
    }

    public void setCanShow(boolean z) {
        this.canShow = z;
    }

    public void setDecoderSize(int i, int i2) {
        this.decoderWidth = i;
        this.decoderHeight = i2;
    }

    public void setDrawData(int i, int i2, OnRenderFinish onRenderFinish, int i3, int i4) {
        this.onRenderFinish = onRenderFinish;
        this.streamType = i3;
        this.pixelFormat = i4;
        if (this.linkIndex == i2) {
            this.mTexId = i;
        }
        if (this.mTexId == -1) {
            queueRunnable(new Runnable() { // from class: com.blink.academy.film.stream.ACGLTextureView.3
                @Override // java.lang.Runnable
                public void run() {
                    ACGLTextureView.this.clearRender();
                }
            });
        } else {
            doDraw();
        }
    }

    public void setFaceDetectCallback(C2870.InterfaceC2871 interfaceC2871) {
        this.faceDetectCallback = interfaceC2871;
    }

    public void setLinkIndex(int i) {
        this.linkIndex = i;
        setGLReady(i != -1);
    }

    public void setSingle(final boolean z) {
        queueRunnable(new Runnable() { // from class: com.blink.academy.film.stream.ACGLTextureView.6
            @Override // java.lang.Runnable
            public void run() {
                if (ACGLTextureView.this.single) {
                    C4041.m12963();
                }
                ACGLTextureView.this.single = z;
            }
        });
    }

    public void setSkipOverrideRender(boolean z) {
        this.skipOverrideRender = z;
    }

    public ACGLTextureView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGLCubeBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.faceDetectEnable = false;
        this.mTexId = -1;
        this.skipOverrideRender = true;
        this.isAnim = false;
        this.canShow = false;
    }
}
