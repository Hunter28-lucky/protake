package com.blink.academy.film.stream.secondscreen;

import android.app.Presentation;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.ViewGroup;
import com.blink.academy.film.stream.secondscreen.SecondScreenTextureView;
import defpackage.AbstractC3962;
import defpackage.C4638;
import org.jcodec.containers.dpx.DPXReader;

/* loaded from: classes.dex */
public class SecondScreenPresentation extends Presentation implements SecondScreenView {
    private static final String TAG = SecondScreenPresentation.class.getSimpleName();
    public static int maxLong = DPXReader.TVINFO_OFFSET;
    public static int maxShort = 1080;
    private float cameraRatio;
    private float inputRatio;
    private boolean isDrawing;
    private int mAlpha;
    private AbstractC3962 mBinding;
    private Handler mHandler;
    private int mScreenOrientation;

    public SecondScreenPresentation(Context context, Display display, int i) {
        this(context, display, 0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeContentView() {
        int i;
        int i2;
        Point point = new Point();
        getDisplay().getSize(point);
        String str = TAG;
        C4638.m14099(str, String.format("onCreate p : %s ", point));
        int i3 = point.x;
        int i4 = point.y;
        if (this.mScreenOrientation == 0) {
            int i5 = (i3 * 9) / 16;
            if (i5 <= i4) {
                i4 = i5;
            } else {
                i3 = (i4 * 16) / 9;
            }
            i = maxLong;
            i2 = maxShort;
        } else {
            int i6 = (i4 * 9) / 16;
            if (i6 <= i3) {
                i3 = i6;
            } else {
                i4 = (i3 * 16) / 9;
            }
            i = maxShort;
            i2 = maxLong;
        }
        float fMax = 1.0f;
        if (i3 > i || i4 > i2) {
            fMax = Math.max((i3 * 1.0f) / i, (i4 * 1.0f) / i2);
            i3 = i;
            i4 = i2;
        }
        int i7 = i3 + (i3 % 2);
        int i8 = i4 + (i4 % 2);
        ViewGroup.LayoutParams layoutParams = this.mBinding.f13789.getLayoutParams();
        layoutParams.width = i7;
        layoutParams.height = i8;
        this.mBinding.f13789.setLayoutParams(layoutParams);
        this.mBinding.f13789.setScaleX(fMax);
        this.mBinding.f13789.setScaleY(fMax);
        this.mBinding.f13789.m2417(i7, i8, true);
        this.mBinding.f13789.m2415(true);
        if (this.mBinding.f13789.getVisibility() != 0) {
            this.mBinding.f13789.setVisibility(0);
        }
        int i9 = this.mAlpha;
        if (i9 != -1) {
            this.mBinding.f13789.m2423(i9, 0L);
        }
        float f = this.cameraRatio;
        if (f != 0.0f || this.inputRatio != 0.0f) {
            this.mBinding.f13789.m2416(f, this.inputRatio, false);
        }
        C4638.m14099(str, String.format("mScreenOrientation : %s , w : %s , h : %s ", Integer.valueOf(this.mScreenOrientation), Integer.valueOf(i7), Integer.valueOf(i8)));
        C4638.m14099(str, String.format("mAlpha : %s , cameraRatio : %s , inputRatio : %s ", Integer.valueOf(this.mAlpha), Float.valueOf(this.cameraRatio), Float.valueOf(this.inputRatio)));
    }

    @Override // com.blink.academy.film.stream.secondscreen.SecondScreenView
    public void destroyFromOther() {
        AbstractC3962 abstractC3962 = this.mBinding;
        if (abstractC3962 != null) {
            abstractC3962.f13788.destroyFromOther();
        }
    }

    @Override // com.blink.academy.film.stream.secondscreen.SecondScreenView
    public void destroyPlayerBuffer() {
        AbstractC3962 abstractC3962 = this.mBinding;
        if (abstractC3962 != null) {
            abstractC3962.f13788.destroyPlayerCacheFrame();
        }
    }

    @Override // com.blink.academy.film.stream.secondscreen.SecondScreenView
    public void drawContent(int i, int i2, int i3) {
        AbstractC3962 abstractC3962 = this.mBinding;
        if (abstractC3962 != null) {
            abstractC3962.f13788.drawFrameToBuffer(i, i2, i3);
        }
    }

    @Override // com.blink.academy.film.stream.secondscreen.SecondScreenView
    public void drawPlayerContent(int i, int i2, int i3) {
        AbstractC3962 abstractC3962 = this.mBinding;
        if (abstractC3962 != null) {
            abstractC3962.f13788.drawPlayerFrameToBuffer(i, i2, i3);
        }
    }

    public int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    @Override // com.blink.academy.film.stream.secondscreen.SecondScreenView
    public int getSetScreenOrientation() {
        return this.mScreenOrientation;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBinding = AbstractC3962.m12807(getLayoutInflater());
        this.mHandler = new Handler();
        setContentView(this.mBinding.getRoot());
        this.mBinding.f13788.setDrawFrameCallback(new SecondScreenTextureView.DrawFrameCallback() { // from class: com.blink.academy.film.stream.secondscreen.SecondScreenPresentation.1
            @Override // com.blink.academy.film.stream.secondscreen.SecondScreenTextureView.DrawFrameCallback
            public void notOnDraw() {
                SecondScreenPresentation.this.isDrawing = false;
            }

            @Override // com.blink.academy.film.stream.secondscreen.SecondScreenTextureView.DrawFrameCallback
            public void onFirstFrameDrawn() {
                SecondScreenPresentation.this.isDrawing = true;
                SecondScreenPresentation.this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.stream.secondscreen.SecondScreenPresentation.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SecondScreenPresentation.this.resizeContentView();
                    }
                });
            }

            @Override // com.blink.academy.film.stream.secondscreen.SecondScreenTextureView.DrawFrameCallback
            public void onPlayerFirstFrameDrawn() {
                SecondScreenPresentation.this.isDrawing = true;
                SecondScreenPresentation.this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.stream.secondscreen.SecondScreenPresentation.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SecondScreenPresentation.this.mBinding.f13789.setVisibility(4);
                    }
                });
            }
        });
    }

    @Override // com.blink.academy.film.stream.secondscreen.SecondScreenView
    public void refreshContentOrientation(int i) {
        this.mScreenOrientation = i;
    }

    @Override // com.blink.academy.film.stream.secondscreen.SecondScreenView
    public void refreshViewOnFrameRatioChange(float f, float f2, boolean z) {
        AbstractC3962 abstractC3962;
        this.cameraRatio = f;
        this.inputRatio = f2;
        C4638.m14099(TAG, String.format("refreshViewOnFrameRatioChange cameraRatio : %s , inputRatio : %s ", Float.valueOf(f), Float.valueOf(this.inputRatio)));
        if (!this.isDrawing || (abstractC3962 = this.mBinding) == null) {
            return;
        }
        abstractC3962.f13789.m2416(f, f2, z);
    }

    @Override // com.blink.academy.film.stream.secondscreen.SecondScreenView
    public void resizeContentSize(int i, int i2) {
    }

    @Override // com.blink.academy.film.stream.secondscreen.SecondScreenView
    public void setHomeRatioCoverCropAlpha(int i) {
        AbstractC3962 abstractC3962;
        this.mAlpha = i;
        C4638.m14099(TAG, String.format("setHomeRatioCoverCropAlpha mAlpha : %s ", Integer.valueOf(i)));
        if (!this.isDrawing || (abstractC3962 = this.mBinding) == null) {
            return;
        }
        abstractC3962.f13789.m2422(i);
    }

    public SecondScreenPresentation(Context context, Display display, int i, int i2) {
        super(context, display, i);
        this.isDrawing = false;
        this.mAlpha = -1;
        this.cameraRatio = 0.0f;
        this.inputRatio = 0.0f;
        this.mScreenOrientation = i2;
    }
}
