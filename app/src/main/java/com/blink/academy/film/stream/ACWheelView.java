package com.blink.academy.film.stream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.stream.ACWheelProgressView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4410;
import defpackage.C4008;
import defpackage.C4535;
import defpackage.C4792;

/* loaded from: classes.dex */
public class ACWheelView extends FrameLayout {
    private static final String TAG = ACWheelView.class.getSimpleName();
    private float currentFocusP;
    private boolean hasFocusAuto;
    private boolean isZoomMode;
    private long lastChangeTime;
    private int mAnimWidth;
    private AbstractC4410 mBinding;
    private Bitmap mBitmapWithAuto;
    private Bitmap mBitmapWithOutAuto;
    private OnValueChange onValueChange;
    private int showing;
    private int unSelectColor;

    public interface OnValueChange {
        void onAnimChange(boolean z);

        void onFocusChange(float f);

        void onHideAB();

        void onModeChange(boolean z);

        void onTouchChange(boolean z);

        void onTouchChange2(boolean z);

        void onZoomChange(float f);

        void onZoomEnableChange(boolean z);
    }

    public ACWheelView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeViewByMode() {
        if (this.isZoomMode) {
            this.mBinding.f15198.setContentTextColor(C4792.m14375().m14431());
            this.mBinding.f15196.setContentTextColor(this.unSelectColor);
            this.mBinding.f15192.setVisibility(8);
            this.mBinding.f15199.setVisibility(0);
            return;
        }
        this.mBinding.f15196.setContentTextColor(C4792.m14375().m14431());
        this.mBinding.f15198.setContentTextColor(this.unSelectColor);
        this.mBinding.f15192.setVisibility(0);
        this.mBinding.f15199.setVisibility(8);
    }

    private Bitmap decodeResource(Resources resources, int i) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        resources.openRawResource(i, typedValue);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inTargetDensity = typedValue.density;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    private int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i = 0; i < length; i++) {
            iCeil += (int) Math.ceil(r2[i]);
        }
        return iCeil;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x027b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap getWheelBitmap(int r34, int r35, int r36) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 722
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.stream.ACWheelView.getWheelBitmap(int, int, int):android.graphics.Bitmap");
    }

    private void init() {
        this.mBinding = AbstractC4410.m13607(LayoutInflater.from(getContext()), this, true);
        initLayout();
        initView();
        initListener();
    }

    private void initLayout() {
        float fM14434 = C4792.m14375().m14434();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mBinding.f15193.getLayoutParams();
        layoutParams.width = (int) (((C4792.m14375().m14476(33) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        int iM14476 = (int) (((C4792.m14375().m14476(20) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        layoutParams.height = iM14476;
        layoutParams.height = iM14476 + (iM14476 % 2);
        layoutParams.leftMargin = (int) (((C4792.m14375().m14476(161) + C4792.m14375().m14443()) * fM14434) + 0.5f);
        this.mBinding.f15193.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mBinding.f15197.getLayoutParams();
        layoutParams2.leftMargin = (int) (((C4792.m14375().m14476(26) + layoutParams.width + layoutParams.leftMargin) * fM14434) + 0.5f);
        layoutParams2.width = (int) ((C4792.m14375().m14476(88) * fM14434) + 0.5f);
        layoutParams2.height = (int) ((C4792.m14375().m14476(325) * fM14434) + 0.5f);
        this.mBinding.f15197.setLayoutParams(layoutParams2);
        this.mBinding.f15192.setDegrees(60.0f, -60.0f, 30.0f);
        this.mBinding.f15199.setDegrees(60.0f, -60.0f);
        this.mBinding.f15199.setRightView(true);
        this.mBinding.f15192.setRightView(true);
    }

    private void initListener() {
        this.mBinding.f15199.setOnProChange(new ACWheelProgressView.OnProChange() { // from class: com.blink.academy.film.stream.ACWheelView.1
            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnProChange
            public float getFocusP() {
                return 0.0f;
            }

            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnProChange
            public void onChange(float f) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (ACWheelView.this.onValueChange != null) {
                    ACWheelView.this.onValueChange.onZoomChange(f);
                }
                ACWheelView.this.lastChangeTime = jCurrentTimeMillis;
            }
        });
        this.mBinding.f15192.setOnProChange(new ACWheelProgressView.OnProChange() { // from class: com.blink.academy.film.stream.ACWheelView.2
            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnProChange
            public float getFocusP() {
                return ACWheelView.this.currentFocusP;
            }

            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnProChange
            public void onChange(float f) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                ACWheelView.this.currentFocusP = f;
                if (ACWheelView.this.onValueChange != null) {
                    ACWheelView.this.onValueChange.onFocusChange(f);
                }
                ACWheelView.this.lastChangeTime = jCurrentTimeMillis;
            }
        });
        this.mBinding.f15194.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.ACWheelView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ACWheelView.this.isZoomMode) {
                    ACWheelView.this.isZoomMode = false;
                    ACWheelView.this.changeViewByMode();
                    if (ACWheelView.this.onValueChange != null) {
                        ACWheelView.this.onValueChange.onTouchChange(true);
                        ACWheelView.this.onValueChange.onModeChange(ACWheelView.this.isZoomMode);
                    }
                }
            }
        });
        this.mBinding.f15195.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.ACWheelView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ACWheelView.this.isZoomMode) {
                    return;
                }
                ACWheelView.this.isZoomMode = true;
                ACWheelView.this.changeViewByMode();
                if (ACWheelView.this.onValueChange != null) {
                    ACWheelView.this.onValueChange.onTouchChange(true);
                    ACWheelView.this.onValueChange.onModeChange(ACWheelView.this.isZoomMode);
                }
            }
        });
        this.mBinding.f15192.setOnTouchStateChange(new ACWheelProgressView.OnTouchStateChange() { // from class: com.blink.academy.film.stream.ACWheelView.5
            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnTouchStateChange
            public void onAnimChange(boolean z) {
                if (ACWheelView.this.onValueChange != null) {
                    ACWheelView.this.onValueChange.onAnimChange(z);
                }
            }

            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnTouchStateChange
            public void onDown() {
                if (ACWheelView.this.onValueChange != null) {
                    ACWheelView.this.onValueChange.onTouchChange(true);
                    ACWheelView.this.onValueChange.onTouchChange2(true);
                }
            }

            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnTouchStateChange
            public void onUp() {
                if (ACWheelView.this.onValueChange != null) {
                    ACWheelView.this.onValueChange.onTouchChange(false);
                    ACWheelView.this.onValueChange.onTouchChange2(false);
                }
                C4535.m13880().m13915();
            }
        });
        this.mBinding.f15199.setOnTouchStateChange(new ACWheelProgressView.OnTouchStateChange() { // from class: com.blink.academy.film.stream.ACWheelView.6
            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnTouchStateChange
            public void onAnimChange(boolean z) {
                if (ACWheelView.this.onValueChange != null) {
                    ACWheelView.this.onValueChange.onAnimChange(z);
                }
            }

            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnTouchStateChange
            public void onDown() {
                if (ACWheelView.this.onValueChange != null) {
                    ACWheelView.this.onValueChange.onTouchChange2(true);
                }
            }

            @Override // com.blink.academy.film.stream.ACWheelProgressView.OnTouchStateChange
            public void onUp() {
                if (ACWheelView.this.onValueChange != null) {
                    ACWheelView.this.onValueChange.onTouchChange2(false);
                }
                C4535.m13880().m13915();
            }
        });
    }

    private void initView() {
        final float fM14434 = C4792.m14375().m14434();
        this.mBitmapWithAuto = getWheelBitmap(60, -60, 30);
        this.mBitmapWithOutAuto = getWheelBitmap(60, -60, 0);
        this.mBinding.f15192.setWheelImage(this.mBitmapWithAuto);
        this.mBinding.f15199.setWheelImage(getWheelBitmap(60, -60, 0));
        final String upperCase = getResources().getString(R.string.RECORDING_WHEELS_FOCUS).toUpperCase();
        this.mBinding.f15198.setText(R.string.RECORDING_WHEELS_ZOOM);
        this.mBinding.f15196.setText(upperCase);
        this.mBinding.f15196.m2562(0, C4792.m14375().m14377() * fM14434);
        this.mBinding.f15198.m2562(0, C4792.m14375().m14377() * fM14434);
        this.mBinding.f15196.post(new Runnable() { // from class: com.blink.academy.film.stream.ACWheelView.7
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ACWheelView.this.mBinding.f15193.getLayoutParams();
                float fMeasureText = ACWheelView.this.mBinding.f15196.getPaint().measureText(upperCase);
                int iMeasureText = ((int) ACWheelView.this.mBinding.f15198.getPaint().measureText(ACWheelView.this.getResources().getString(R.string.RECORDING_WHEELS_ZOOM).toUpperCase())) / 2;
                int i = ((int) fMeasureText) / 2;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) ACWheelView.this.mBinding.f15197.getLayoutParams();
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) ACWheelView.this.mBinding.f15198.getLayoutParams();
                layoutParams3.width = (int) (C4792.f16138 + fMeasureText);
                layoutParams3.height = layoutParams2.width;
                layoutParams3.leftMargin = (int) (((layoutParams.leftMargin + layoutParams.width) - (fMeasureText / 2.0f)) + (C4792.m14375().m14476(65) * fM14434) + 0.5f);
                int i2 = (iMeasureText - i) / 2;
                layoutParams3.topMargin = ((-iMeasureText) + i2) - C4792.m14375().m14476(30);
                ACWheelView.this.mBinding.f15198.setLayoutParams(layoutParams3);
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) ACWheelView.this.mBinding.f15196.getLayoutParams();
                layoutParams4.width = (int) (fMeasureText + C4792.f16138);
                layoutParams4.leftMargin = layoutParams3.leftMargin;
                layoutParams4.height = layoutParams2.width;
                layoutParams4.topMargin = i + i2 + C4792.m14375().m14476(30);
                ACWheelView.this.mBinding.f15196.setLayoutParams(layoutParams4);
            }
        });
    }

    public void cancelClick() {
        this.mBinding.f15199.cancelClickMove();
        this.mBinding.f15192.cancelClickMove();
    }

    public void disableOnBanned() {
        setFocusEnable(false, true);
        setZoomEnable(false, true);
    }

    public void endAnim() {
        this.mBinding.f15192.cancelClickMove();
        this.mBinding.f15199.cancelClickMove();
    }

    public float getCurrentDegree(boolean z) {
        return z ? this.mBinding.f15199.getNowDegree() : this.mBinding.f15192.getNowDegree();
    }

    public float getCurrentFocusP() {
        return this.currentFocusP;
    }

    public void hide(int i) {
        if (this.showing == 0) {
            return;
        }
        this.showing = 0;
        C4008.m12876(this, 0.0f, i, new AbstractC4012() { // from class: com.blink.academy.film.stream.ACWheelView.8
            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                ACWheelView.this.setVisibility(8);
            }
        });
    }

    public void refreshFocusWheel(float f) {
        this.mBinding.f15192.setPro(f);
    }

    public void refreshLayout(float f, float f2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.mBinding.f15192.setPro(f);
        this.mBinding.f15199.setPro(f2);
        this.isZoomMode = z;
        setFocusEnable(z2, z4);
        setZoomEnable(z3, z4);
        changeViewByMode();
    }

    public void refreshMode(boolean z) {
        this.isZoomMode = z;
        changeViewByMode();
    }

    public void refreshZoomWheel(float f) {
        this.mBinding.f15199.setPro(f);
    }

    public void setCardWidth(int i) {
        this.mAnimWidth = i;
    }

    public void setCurrentFocusP(float f) {
        this.currentFocusP = f;
    }

    public void setFocusEnable(boolean z, boolean z2) {
        this.mBinding.f15192.setEnabled(z);
        this.mBinding.f15194.setEnabled(z);
        if (z) {
            this.mBinding.f15196.setAlpha(1.0f);
            this.mBinding.f15193.setAlpha(1.0f);
            return;
        }
        if (!this.isZoomMode && z2) {
            this.isZoomMode = true;
            changeViewByMode();
            OnValueChange onValueChange = this.onValueChange;
            if (onValueChange != null) {
                onValueChange.onModeChange(this.isZoomMode);
            }
        }
        this.mBinding.f15196.setAlpha(0.2f);
    }

    public void setHandler(WeakHandler weakHandler) {
        this.mBinding.f15192.setHandler(weakHandler);
        this.mBinding.f15199.setHandler(weakHandler);
    }

    public void setHasFocusAuto(boolean z) {
        if (z != this.hasFocusAuto) {
            this.hasFocusAuto = z;
            if (z) {
                Bitmap bitmap = this.mBitmapWithAuto;
                if (bitmap == null || bitmap.isRecycled()) {
                    this.mBitmapWithAuto = getWheelBitmap(60, -60, 30);
                }
                this.mBinding.f15192.setDegrees(60.0f, -60.0f, 30.0f);
                this.mBinding.f15192.resetWheelBitmap(this.mBitmapWithAuto);
                return;
            }
            Bitmap bitmap2 = this.mBitmapWithOutAuto;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.mBitmapWithOutAuto = getWheelBitmap(60, -60, 0);
            }
            this.mBinding.f15192.setDegrees(60.0f, -60.0f, 0.0f);
            this.mBinding.f15192.resetWheelBitmap(this.mBitmapWithOutAuto);
        }
    }

    public void setMessageP(boolean z, float f) {
        if (z) {
            this.mBinding.f15192.onAnimValueChange(f);
        } else {
            this.mBinding.f15199.onAnimValueChange(f);
        }
    }

    public void setOnValueChange(OnValueChange onValueChange) {
        this.onValueChange = onValueChange;
    }

    public void setZoomEnable(boolean z, boolean z2) {
        this.mBinding.f15199.setEnabled(z);
        this.mBinding.f15195.setEnabled(z);
        if (z) {
            this.mBinding.f15198.setAlpha(1.0f);
            this.mBinding.f15193.setAlpha(1.0f);
            this.mBinding.f15199.setAlpha(1.0f);
        } else {
            if (!this.mBinding.f15192.isEnabled() || !z2) {
                this.mBinding.f15199.setAlpha(0.2f);
                this.mBinding.f15193.setAlpha(0.2f);
            } else if (this.isZoomMode) {
                this.isZoomMode = false;
                changeViewByMode();
                OnValueChange onValueChange = this.onValueChange;
                if (onValueChange != null) {
                    onValueChange.onModeChange(this.isZoomMode);
                }
            }
            this.mBinding.f15198.setAlpha(0.2f);
        }
        OnValueChange onValueChange2 = this.onValueChange;
        if (onValueChange2 != null) {
            onValueChange2.onZoomEnableChange(this.mBinding.f15199.isEnabled());
        }
    }

    public void show(int i) {
        if (this.showing == 1) {
            return;
        }
        this.showing = 1;
        setVisibility(0);
        C4008.m12876(this, 1.0f, i, null);
    }

    public void switchMode() {
        if (this.isZoomMode) {
            if (this.mBinding.f15194.isEnabled()) {
                this.mBinding.f15194.performClick();
            }
        } else if (this.mBinding.f15195.isEnabled()) {
            this.mBinding.f15195.performClick();
        }
    }

    public ACWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ACWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.showing = -1;
        this.hasFocusAuto = true;
        this.unSelectColor = Color.parseColor("#ffffff");
        init();
    }
}
