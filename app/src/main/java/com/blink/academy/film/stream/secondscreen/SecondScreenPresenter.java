package com.blink.academy.film.stream.secondscreen;

import android.app.Activity;
import android.view.Display;
import com.blink.academy.film.stream.secondscreen.SecondScreenInteractor;
import defpackage.C2579;
import defpackage.C4638;

/* loaded from: classes.dex */
public class SecondScreenPresenter {
    private static final String TAG = "SecondScreenPresenter";
    private static SecondScreenPresenter sSecondScreenPresenter;
    private int cacheAlpha;
    private float cacheCameraRatio;
    private float cacheInputRatio;
    private boolean enable;
    private int mScreenOrientation;
    private SecondScreenInteractor mSecondScreenInteractor;
    private SecondScreenView mSecondScreenView;

    private SecondScreenPresenter() {
        this.enable = false;
        this.mScreenOrientation = 0;
        this.cacheAlpha = -1;
    }

    public static SecondScreenPresenter getInstance(Activity activity, boolean z) {
        if (activity == null) {
            return null;
        }
        if (sSecondScreenPresenter == null) {
            synchronized (SecondScreenPresenter.class) {
                if (sSecondScreenPresenter == null) {
                    sSecondScreenPresenter = new SecondScreenPresenter(activity, z);
                }
            }
        }
        return sSecondScreenPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseSecondScreenView() {
        SecondScreenView secondScreenView = this.mSecondScreenView;
        if (secondScreenView != null) {
            secondScreenView.dismiss();
        }
        this.mSecondScreenView = null;
    }

    public void destroyFromOther() {
        SecondScreenView secondScreenView = this.mSecondScreenView;
        if (secondScreenView != null) {
            secondScreenView.destroyFromOther();
        }
    }

    public void destroyPlayerBuffer() {
        SecondScreenView secondScreenView = this.mSecondScreenView;
        if (secondScreenView != null) {
            secondScreenView.destroyPlayerBuffer();
        }
    }

    public void drawPlayerTex(int i, int i2, int i3) {
        SecondScreenView secondScreenView = this.mSecondScreenView;
        if (secondScreenView != null) {
            secondScreenView.drawPlayerContent(i, i2, i3);
        }
    }

    public void drawTex(int i, int i2, int i3) {
        SecondScreenView secondScreenView = this.mSecondScreenView;
        if (secondScreenView != null) {
            secondScreenView.drawContent(i, i2, i3);
        }
    }

    public void onPause() {
        this.mSecondScreenInteractor.onPause();
    }

    public void onResume() {
        this.mSecondScreenInteractor.onResume();
    }

    public void refreshViewOnFrameRatioChange(float f, float f2) {
        refreshViewOnFrameRatioChange(f, f2, false);
    }

    public void release() {
        this.mSecondScreenInteractor.release();
        sSecondScreenPresenter = null;
    }

    public SecondScreenPresenter setEnable(boolean z) {
        this.enable = z;
        if (!z) {
            releaseSecondScreenView();
        }
        return this;
    }

    public void setHomeRatioCoverCropAlpha(int i) {
        this.cacheAlpha = i;
        SecondScreenView secondScreenView = this.mSecondScreenView;
        if (secondScreenView != null) {
            this.cacheAlpha = -1;
            secondScreenView.setHomeRatioCoverCropAlpha(i);
        }
    }

    public void setScreenOrientation(int i) {
        int setScreenOrientation;
        this.mScreenOrientation = i;
        SecondScreenView secondScreenView = this.mSecondScreenView;
        if (secondScreenView == null || (setScreenOrientation = secondScreenView.getSetScreenOrientation()) == this.mScreenOrientation) {
            return;
        }
        C4638.m14099(TAG, String.format("screenOrientation : %s , setScreenOrientation : %s", Integer.valueOf(i), Integer.valueOf(setScreenOrientation)));
        this.mSecondScreenView.refreshContentOrientation(this.mScreenOrientation);
    }

    public void refreshViewOnFrameRatioChange(float f, float f2, boolean z) {
        if (!z) {
            this.cacheCameraRatio = f;
            this.cacheInputRatio = f2;
        }
        SecondScreenView secondScreenView = this.mSecondScreenView;
        if (secondScreenView != null) {
            this.cacheCameraRatio = 0.0f;
            this.cacheInputRatio = 0.0f;
            secondScreenView.refreshViewOnFrameRatioChange(f, f2, z);
        }
    }

    private SecondScreenPresenter(final Activity activity, boolean z) {
        this.mScreenOrientation = 0;
        this.cacheAlpha = -1;
        this.enable = z;
        this.mSecondScreenInteractor = new SecondScreenInteractor(activity, new SecondScreenInteractor.SecondScreenListener() { // from class: com.blink.academy.film.stream.secondscreen.SecondScreenPresenter.1
            @Override // com.blink.academy.film.stream.secondscreen.SecondScreenInteractor.SecondScreenListener
            public void onSecondScreenReady(Display display) {
                SecondScreenPresenter.this.mScreenOrientation = C2579.m9446(activity);
                C4638.m14099(SecondScreenPresenter.TAG, "onSecondScreenReady orientation : " + SecondScreenPresenter.this.mScreenOrientation);
                if (SecondScreenPresenter.this.enable) {
                    C4638.m14099(SecondScreenPresenter.TAG, String.format("onSecondScreenReady : %s ", display.toString()));
                    SecondScreenPresenter.this.mSecondScreenView = new SecondScreenPresentation(activity, display, SecondScreenPresenter.this.mScreenOrientation);
                    if (SecondScreenPresenter.this.cacheAlpha != -1) {
                        SecondScreenPresenter secondScreenPresenter = SecondScreenPresenter.this;
                        secondScreenPresenter.setHomeRatioCoverCropAlpha(secondScreenPresenter.cacheAlpha);
                    }
                    if (SecondScreenPresenter.this.cacheCameraRatio != 0.0f || SecondScreenPresenter.this.cacheInputRatio != 0.0f) {
                        SecondScreenPresenter secondScreenPresenter2 = SecondScreenPresenter.this;
                        secondScreenPresenter2.refreshViewOnFrameRatioChange(secondScreenPresenter2.cacheCameraRatio, SecondScreenPresenter.this.cacheInputRatio, false);
                    }
                    SecondScreenPresenter.this.mSecondScreenView.show();
                }
            }

            @Override // com.blink.academy.film.stream.secondscreen.SecondScreenInteractor.SecondScreenListener
            public void onSecondScreenRemove() {
                C4638.m14099(SecondScreenPresenter.TAG, "onSecondScreenRemove");
                SecondScreenPresenter.this.releaseSecondScreenView();
            }
        });
        this.mScreenOrientation = C2579.m9446(activity);
        C4638.m14099(TAG, "orientation : " + this.mScreenOrientation);
    }
}
