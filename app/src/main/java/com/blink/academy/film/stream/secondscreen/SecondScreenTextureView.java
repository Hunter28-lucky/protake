package com.blink.academy.film.stream.secondscreen;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.AttributeSet;
import com.blink.academy.film.videotools.GLTextureView;
import com.blink.academy.filter.core.C1788;
import com.blink.academy.filter.core.C1793;
import com.blink.academy.filter.core.Drawable2d;
import defpackage.C2966;
import defpackage.C4638;

/* loaded from: classes.dex */
public class SecondScreenTextureView extends GLTextureView {
    private final float[] IDENTITY_MATRIX;
    private final Object frameLock;
    private boolean frameUpdated;
    private boolean hasDrawFirstFrame;
    private boolean hasDrawPlayerFirstFrame;
    private boolean isInit;
    private DrawFrameCallback mDrawFrameCallback;
    private Drawable2d mDrawable2d;
    private C1788 mFramebuffer;
    private C1788 mPlayerBuffer;
    private final float[] mSTMatrix;
    private C1793 mSimpleTexture2DProgram;
    private final float[] modelMatrix;
    private boolean playerFrameUpdated;
    private final float[] projectionMatrix;

    public interface DrawFrameCallback {
        void notOnDraw();

        void onFirstFrameDrawn();

        void onPlayerFirstFrameDrawn();
    }

    public SecondScreenTextureView(Context context) {
        super(context);
        this.frameLock = new Object();
        this.playerFrameUpdated = false;
        this.frameUpdated = false;
        this.mSTMatrix = new float[16];
        this.IDENTITY_MATRIX = new float[16];
        this.projectionMatrix = new float[16];
        this.modelMatrix = new float[16];
        this.isInit = false;
        this.hasDrawFirstFrame = false;
        this.hasDrawPlayerFirstFrame = false;
    }

    public void destroyFromOther() {
        synchronized (this.frameLock) {
            C1788 c1788 = this.mFramebuffer;
            if (c1788 != null) {
                c1788.m4789();
                this.mFramebuffer = null;
            }
        }
    }

    public void destroyPlayerCacheFrame() {
        synchronized (this.frameLock) {
            C1788 c1788 = this.mPlayerBuffer;
            if (c1788 != null) {
                c1788.m4789();
                this.mPlayerBuffer = null;
            }
        }
    }

    public void drawFrameToBuffer(int i, int i2, int i3) {
        if (this.isInit) {
            synchronized (this.frameLock) {
                C1788 c1788 = this.mFramebuffer;
                if (c1788 == null) {
                    this.mFramebuffer = new C1788(i2, i3);
                } else if (c1788.f5101 != i2 || c1788.f5102 != i3) {
                    c1788.m4789();
                    this.mFramebuffer = new C1788(i2, i3);
                }
                this.mFramebuffer.m4786();
                this.mSimpleTexture2DProgram.mo4809(i, this.mDrawable2d);
                this.mFramebuffer.m4793();
                this.frameUpdated = true;
            }
        }
    }

    public void drawPlayerFrameToBuffer(final int i, final int i2, final int i3) {
        queueRunnable(new Runnable() { // from class: com.blink.academy.film.stream.secondscreen.SecondScreenTextureView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SecondScreenTextureView.this.isInit) {
                    synchronized (SecondScreenTextureView.this.frameLock) {
                        if (SecondScreenTextureView.this.mPlayerBuffer == null) {
                            SecondScreenTextureView.this.mPlayerBuffer = new C1788(i2, i3);
                        } else if (SecondScreenTextureView.this.mPlayerBuffer.f5101 != i2 || SecondScreenTextureView.this.mPlayerBuffer.f5102 != i3) {
                            SecondScreenTextureView.this.mPlayerBuffer.m4789();
                            SecondScreenTextureView.this.mPlayerBuffer = new C1788(i2, i3);
                        }
                        SecondScreenTextureView.this.mPlayerBuffer.m4786();
                        SecondScreenTextureView.this.mSimpleTexture2DProgram.mo4809(i, SecondScreenTextureView.this.mDrawable2d);
                        SecondScreenTextureView.this.mPlayerBuffer.m4793();
                        SecondScreenTextureView.this.playerFrameUpdated = true;
                    }
                }
            }
        });
    }

    @Override // com.blink.academy.film.videotools.GLTextureView
    public boolean isGLReady() {
        return true;
    }

    @Override // com.blink.academy.film.videotools.GLTextureView
    public void onGLDestroy() {
        this.isInit = false;
        this.mSimpleTexture2DProgram.mo4800();
        destroyPlayerCacheFrame();
        super.onGLDestroy();
    }

    @Override // com.blink.academy.film.videotools.GLTextureView
    public void onGLInit() {
        super.onGLInit();
        this.mSimpleTexture2DProgram = new C1793();
        this.mDrawable2d = new Drawable2d();
        this.isInit = true;
        Matrix.setIdentityM(this.mSTMatrix, 0);
        Matrix.setIdentityM(this.IDENTITY_MATRIX, 0);
        Matrix.setIdentityM(this.projectionMatrix, 0);
        Matrix.setIdentityM(this.modelMatrix, 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        this.egl.m11960(this.mEGLSurface);
    }

    @Override // com.blink.academy.film.videotools.GLTextureView
    public void onGLRender(double d, long j) {
        super.onGLRender(d, j);
        synchronized (this.frameLock) {
            C1788 c1788 = this.mFramebuffer;
            if (c1788 == null && this.mPlayerBuffer == null) {
                this.hasDrawFirstFrame = false;
                this.hasDrawPlayerFirstFrame = false;
                DrawFrameCallback drawFrameCallback = this.mDrawFrameCallback;
                if (drawFrameCallback != null) {
                    drawFrameCallback.notOnDraw();
                }
            } else if (c1788 != null && this.frameUpdated) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                Matrix.setIdentityM(this.mSTMatrix, 0);
                Matrix.setIdentityM(this.projectionMatrix, 0);
                Matrix.setIdentityM(this.modelMatrix, 0);
                float[] fArr = this.projectionMatrix;
                C1788 c17882 = this.mFramebuffer;
                C2966.m10378(fArr, c17882.f5101, c17882.f5102, this.mWidth, this.mHeight);
                Matrix.multiplyMM(this.mSTMatrix, 0, this.projectionMatrix, 0, this.modelMatrix, 0);
                this.mSimpleTexture2DProgram.mo4802(this.mFramebuffer.m4792(), this.mSTMatrix, this.IDENTITY_MATRIX, this.mDrawable2d);
                this.egl.m11960(this.mEGLSurface);
                this.frameUpdated = false;
                this.hasDrawPlayerFirstFrame = false;
                if (!this.hasDrawFirstFrame) {
                    this.hasDrawFirstFrame = true;
                    C4638.m14099("onFirstFrameDrawn", String.format("w : %s , h : %s ", Integer.valueOf(this.mFramebuffer.f5101), Integer.valueOf(this.mFramebuffer.f5102)));
                    DrawFrameCallback drawFrameCallback2 = this.mDrawFrameCallback;
                    if (drawFrameCallback2 != null) {
                        drawFrameCallback2.onFirstFrameDrawn();
                    }
                }
            } else if (this.mPlayerBuffer != null && this.playerFrameUpdated) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                Matrix.setIdentityM(this.mSTMatrix, 0);
                Matrix.setIdentityM(this.projectionMatrix, 0);
                Matrix.setIdentityM(this.modelMatrix, 0);
                float[] fArr2 = this.projectionMatrix;
                C1788 c17883 = this.mPlayerBuffer;
                C2966.m10378(fArr2, c17883.f5101, c17883.f5102, this.mWidth, this.mHeight);
                Matrix.multiplyMM(this.mSTMatrix, 0, this.projectionMatrix, 0, this.modelMatrix, 0);
                this.mSimpleTexture2DProgram.mo4802(this.mPlayerBuffer.m4792(), this.mSTMatrix, this.IDENTITY_MATRIX, this.mDrawable2d);
                this.egl.m11960(this.mEGLSurface);
                this.playerFrameUpdated = false;
                this.hasDrawFirstFrame = false;
                if (!this.hasDrawPlayerFirstFrame) {
                    this.hasDrawPlayerFirstFrame = true;
                    C4638.m14099("onFirstFrameDrawn", String.format("w : %s , h : %s ", Integer.valueOf(this.mPlayerBuffer.f5101), Integer.valueOf(this.mPlayerBuffer.f5102)));
                    DrawFrameCallback drawFrameCallback3 = this.mDrawFrameCallback;
                    if (drawFrameCallback3 != null) {
                        drawFrameCallback3.onPlayerFirstFrameDrawn();
                    }
                }
            } else if (c1788 == null) {
                this.hasDrawFirstFrame = false;
                DrawFrameCallback drawFrameCallback4 = this.mDrawFrameCallback;
                if (drawFrameCallback4 != null) {
                    drawFrameCallback4.notOnDraw();
                }
            }
        }
    }

    public SecondScreenTextureView setDrawFrameCallback(DrawFrameCallback drawFrameCallback) {
        this.mDrawFrameCallback = drawFrameCallback;
        return this;
    }

    public SecondScreenTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.frameLock = new Object();
        this.playerFrameUpdated = false;
        this.frameUpdated = false;
        this.mSTMatrix = new float[16];
        this.IDENTITY_MATRIX = new float[16];
        this.projectionMatrix = new float[16];
        this.modelMatrix = new float[16];
        this.isInit = false;
        this.hasDrawFirstFrame = false;
        this.hasDrawPlayerFirstFrame = false;
    }
}
