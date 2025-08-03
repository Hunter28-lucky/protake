package defpackage;

import android.opengl.EGLContext;
import android.os.Handler;

/* compiled from: TextureMovieEncoder.java */
/* loaded from: classes.dex */
public class a2 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f0;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f1;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f2;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final EGLContext f3;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f4;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f5;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final String f6;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final Handler f8;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int f9;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int f10;

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean f11;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final float f12;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final boolean f13;

    /* renamed from: ހ, reason: contains not printable characters */
    public final int f14;

    /* renamed from: ށ, reason: contains not printable characters */
    public final boolean f15;

    public a2(int i, int i2, int i3, int i4, int i5, int i6, String str, Handler handler, EGLContext eGLContext, int i7, int i8, boolean z, float f, boolean z2, int i9, boolean z3) {
        this.f0 = i;
        this.f1 = i2;
        this.f2 = i3;
        this.f4 = i4;
        this.f5 = i5;
        this.f7 = i6;
        this.f6 = str;
        this.f8 = handler;
        this.f3 = eGLContext;
        this.f9 = i7;
        this.f10 = i8;
        this.f11 = z;
        this.f12 = f;
        this.f13 = z2;
        this.f14 = i9;
        this.f15 = z3;
    }

    public String toString() {
        return "EncoderConfig{mWidth=" + this.f0 + ", mHeight=" + this.f1 + ", mBitRate=" + this.f2 + ", mEglContext=" + this.f3 + ", mTargetPreviewFps=" + this.f4 + ", mTargetVideoFps=" + this.f5 + ", mVideoMime='" + this.f6 + "', mTimeLapseTimeMs=" + this.f7 + ", mCameraHandler=" + this.f8 + ", mPreviewWidth=" + this.f9 + ", mPreviewHeight=" + this.f10 + ", mAnamorphic=" + this.f11 + ", mIsPortrait=" + this.f13 + ", mCameraOrientation=" + this.f14 + ", mIsMirrorSelfie=" + this.f15 + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4(int i, int i2, int i3) {
        this.f0 = i;
        this.f1 = i2;
        this.f2 = i3;
    }
}
