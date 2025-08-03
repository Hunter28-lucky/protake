package jp.co.cyberagent.android.gpuimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.C4327;
import java.io.File;
import jp.co.cyberagent.android.gpuimage.GPUImage;

/* loaded from: classes2.dex */
public class GPUImageView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public GLSurfaceView f7768;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public GPUImage f7769;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4327 f7770;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f7771;

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImageView$Ϳ, reason: contains not printable characters */
    public class C2129 extends GLSurfaceView {
        public C2129(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.SurfaceView, android.view.View
        public void onMeasure(int i, int i2) {
            GPUImageView.this.getClass();
            super.onMeasure(i, i2);
        }
    }

    public GPUImageView(Context context) {
        super(context);
        this.f7771 = 0.0f;
        m7144(context, null);
    }

    public C4327 getFilter() {
        return this.f7770;
    }

    public GPUImage getGPUImage() {
        return this.f7769;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f7771 == 0.0f) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        float f = size;
        float f2 = this.f7771;
        float f3 = size2;
        if (f / f2 < f3) {
            size2 = Math.round(f / f2);
        } else {
            size = Math.round(f3 * f2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void setFilter(C4327 c4327) {
        this.f7770 = c4327;
        this.f7769.m7127(c4327);
        m7145();
    }

    public void setImage(Bitmap bitmap) {
        this.f7769.m7129(bitmap);
    }

    public void setRatio(float f) {
        this.f7771 = f;
        this.f7768.requestLayout();
        this.f7769.m7123();
    }

    public void setRotation(Rotation rotation) {
        this.f7769.m7132(rotation);
        m7145();
    }

    public void setScaleType(GPUImage.ScaleType scaleType) {
        this.f7769.m7133(scaleType);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m7144(Context context, AttributeSet attributeSet) {
        C2129 c2129 = new C2129(context, attributeSet);
        this.f7768 = c2129;
        addView(c2129);
        GPUImage gPUImage = new GPUImage(getContext());
        this.f7769 = gPUImage;
        gPUImage.m7128(this.f7768);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m7145() {
        this.f7768.requestRender();
    }

    public void setImage(Uri uri) {
        this.f7769.m7130(uri);
    }

    public void setImage(File file) {
        this.f7769.m7131(file);
    }

    public GPUImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7771 = 0.0f;
        m7144(context, attributeSet);
    }
}
