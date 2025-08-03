package com.blink.academy.film.widgets.iso;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.C4638;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class WheelProgressZoomView extends AppCompatImageView {

    /* renamed from: ޔ, reason: contains not printable characters */
    public static final String f3516 = WheelProgressZoomView.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public Bitmap f3517;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Bitmap f3518;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Matrix f3519;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3520;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3521;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Context f3522;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f3523;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f3524;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f3525;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f3526;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f3527;

    /* renamed from: ށ, reason: contains not printable characters */
    public ValueAnimator f3528;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f3529;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f3530;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f3531;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f3532;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f3533;

    /* renamed from: އ, reason: contains not printable characters */
    public long f3534;

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f3535;

    /* renamed from: މ, reason: contains not printable characters */
    public float f3536;

    /* renamed from: ފ, reason: contains not printable characters */
    public float f3537;

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean f3538;

    /* renamed from: ތ, reason: contains not printable characters */
    public Timer f3539;

    /* renamed from: ލ, reason: contains not printable characters */
    public Timer f3540;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f3541;

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean f3542;

    /* renamed from: ސ, reason: contains not printable characters */
    public InterfaceC1257 f3543;

    /* renamed from: ޑ, reason: contains not printable characters */
    public InterfaceC1258 f3544;

    /* renamed from: ޒ, reason: contains not printable characters */
    public AutoZoomWheelView f3545;

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean f3546;

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressZoomView$Ϳ, reason: contains not printable characters */
    public class C1254 implements ValueAnimator.AnimatorUpdateListener {
        public C1254() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WheelProgressZoomView.this.rotateWheel2(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressZoomView$Ԩ, reason: contains not printable characters */
    public class C1255 implements Animator.AnimatorListener {
        public C1255() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (WheelProgressZoomView.this.f3527 == 1) {
                WheelProgressZoomView wheelProgressZoomView = WheelProgressZoomView.this;
                wheelProgressZoomView.rotateWheel2(wheelProgressZoomView.getMaxDegree(false));
            } else if (WheelProgressZoomView.this.f3527 == 2) {
                WheelProgressZoomView wheelProgressZoomView2 = WheelProgressZoomView.this;
                wheelProgressZoomView2.rotateWheel2(wheelProgressZoomView2.getMinDegree(false));
            }
            WheelProgressZoomView.this.f3527 = 0;
            if (WheelProgressZoomView.this.f3540 != null) {
                WheelProgressZoomView.this.f3540.cancel();
            }
            WheelProgressZoomView.this.m3516();
            if (WheelProgressZoomView.this.f3544 != null) {
                WheelProgressZoomView.this.f3544.onAnimChange(false);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (WheelProgressZoomView.this.f3544 != null) {
                WheelProgressZoomView.this.f3544.onAnimChange(true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressZoomView$Ԫ, reason: contains not printable characters */
    public class C1256 extends TimerTask {
        public C1256() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (WheelProgressZoomView.this.f3544 != null) {
                WheelProgressZoomView.this.f3544.mo3235();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressZoomView$Ԭ, reason: contains not printable characters */
    public interface InterfaceC1257 {
        /* renamed from: Ϳ */
        void mo3230(float f, boolean z);
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressZoomView$Ԯ, reason: contains not printable characters */
    public interface InterfaceC1258 {
        void onAnimChange(boolean z);

        void onDown();

        /* renamed from: Ϳ */
        void mo3231(boolean z);

        /* renamed from: Ԩ */
        void mo3232();

        /* renamed from: ԩ */
        void mo3233(int i);

        /* renamed from: Ԫ */
        void mo3234();

        /* renamed from: ԫ */
        void mo3235();
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressZoomView$ՠ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1259 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public double f3550;

        /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressZoomView$ՠ$Ϳ, reason: contains not printable characters */
        public class C1260 extends TimerTask {
            public C1260() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (WheelProgressZoomView.this.f3544 != null) {
                    WheelProgressZoomView.this.f3544.mo3232();
                }
            }
        }

        public ViewOnTouchListenerC1259() {
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00c1  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
            /*
                Method dump skipped, instructions count: 548
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.WheelProgressZoomView.ViewOnTouchListenerC1259.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        public /* synthetic */ ViewOnTouchListenerC1259(WheelProgressZoomView wheelProgressZoomView, C1254 c1254) {
            this();
        }
    }

    public WheelProgressZoomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3523 = 0.0f;
        this.f3524 = 0.0f;
        this.f3525 = true;
        this.f3527 = 0;
        this.f3538 = true;
        this.f3539 = new Timer();
        this.f3540 = new Timer();
        this.f3541 = -1;
        this.f3542 = false;
        init(context);
    }

    private float getMatrixAngle() {
        float[] fArr = new float[9];
        this.f3519.getValues(fArr);
        float f = fArr[0];
        float f2 = fArr[3];
        Math.sqrt((f * f) + (f2 * f2));
        return (float) (Math.atan2(fArr[1], fArr[0]) * 57.29577951308232d);
    }

    public static int getQuadrant(double d, double d2) {
        return d >= 0.0d ? d2 >= 0.0d ? 1 : 4 : d2 >= 0.0d ? 2 : 3;
    }

    public Bitmap BITMAP_RESIZER(Bitmap bitmap, int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        float f = i;
        float width = f / bitmap.getWidth();
        float f2 = i2;
        float height = f2 / bitmap.getHeight();
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(width, height, f3, f4);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, f3 - (bitmap.getWidth() / 2), f4 - (bitmap.getHeight() / 2), new Paint(2));
        return bitmapCreateBitmap;
    }

    public void cancelClickMove() {
        ValueAnimator valueAnimator = this.f3528;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void checkValidDownArea(MotionEvent motionEvent) {
        motionEvent.getX();
        motionEvent.getY();
        this.f3538 = true;
    }

    public double getAngle(double d, double d2) {
        double d3 = 20.0d - (this.f3521 / 2.0d);
        int i = this.f3520;
        double d4 = (i - d2) - (i / 2.0d);
        int quadrant = getQuadrant(d3, d4);
        if (quadrant == 1) {
            return (Math.asin(d4 / Math.hypot(d3, d4)) * 180.0d) / 3.141592653589793d;
        }
        if (quadrant == 2) {
            return 180.0d - ((Math.asin(d4 / Math.hypot(d3, d4)) * 180.0d) / 3.141592653589793d);
        }
        if (quadrant == 3) {
            return (((Math.asin(d4 / Math.hypot(d3, d4)) * (-1.0d)) * 180.0d) / 3.141592653589793d) + 180.0d;
        }
        if (quadrant != 4) {
            return 0.0d;
        }
        return ((Math.asin(d4 / Math.hypot(d3, d4)) * 180.0d) / 3.141592653589793d) + 360.0d;
    }

    public float getCurrentDegree() {
        return this.f3529;
    }

    public float getDegreeFromPercent(float f) {
        if (f < 0.0f) {
            return getMinDegree(false);
        }
        if (f > 1.0f) {
            return getMaxDegree(false);
        }
        return getMinDegree(true) + ((getMaxDegree(true) - getMinDegree(true)) * f);
    }

    public final float getMaxDegree(boolean z) {
        return z ? this.f3531 : this.f3531 + this.f3533;
    }

    public final float getMinDegree(boolean z) {
        return z ? this.f3532 : this.f3532 + this.f3533;
    }

    public float getNowDegree() {
        return getMatrixAngle();
    }

    public float getProFromDegree(float f) {
        return (f - getMinDegree(true)) / (getMaxDegree(true) - getMinDegree(true));
    }

    public final void init(Context context) {
        this.f3522 = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = this.f3519;
        if (matrix == null) {
            this.f3519 = new Matrix();
        } else {
            matrix.reset();
        }
        setOnTouchListener(new ViewOnTouchListenerC1259(this, null));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f3520 == 0 || this.f3521 == 0) {
            this.f3520 = (i2 - getPaddingTop()) - getPaddingBottom();
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            this.f3521 = paddingLeft;
            this.f3518 = BITMAP_RESIZER(this.f3517, paddingLeft, this.f3520);
            this.f3519.postTranslate((this.f3521 / 2) - (r1.getWidth() / 2), (this.f3520 / 2) - (this.f3518.getHeight() / 2));
            if (this.f3530) {
                this.f3519.postRotate(-this.f3529, this.f3521 / 2, this.f3520 / 2);
                this.f3530 = false;
            }
            setImageBitmap(this.f3518);
            setImageMatrix(this.f3519);
        }
    }

    public void rotateWheel(float f) {
        this.f3519.postRotate(f, this.f3521 / 2, this.f3520 / 2);
        float matrixAngle = getMatrixAngle();
        if (matrixAngle > getMaxDegree(false)) {
            matrixAngle = getMaxDegree(false);
            this.f3519.reset();
            this.f3519.postRotate(-matrixAngle, this.f3521 / 2, this.f3520 / 2);
        } else if (matrixAngle < getMinDegree(false)) {
            matrixAngle = getMinDegree(false);
            this.f3519.reset();
            this.f3519.postRotate(-matrixAngle, this.f3521 / 2, this.f3520 / 2);
        }
        float f2 = this.f3529;
        if (matrixAngle != f2) {
            this.f3529 = matrixAngle;
            if (matrixAngle > getMaxDegree(true) || this.f3529 < getMinDegree(false)) {
                return;
            }
            int iM3512 = m3512(f2);
            if (this.f3525) {
                if (iM3512 != -1) {
                    float f3 = this.f3529;
                    if (f3 > f2) {
                        this.f3524 = 0.0f;
                        this.f3523 += 1.0f;
                        float f4 = iM3512;
                        if (Math.abs(f3 - f4) < 0.5f && this.f3523 < 10.0f) {
                            this.f3529 = f4;
                            this.f3519.reset();
                            this.f3519.postRotate(-f4, this.f3521 / 2, this.f3520 / 2);
                            setImageMatrix(this.f3519);
                            InterfaceC1257 interfaceC1257 = this.f3543;
                            if (interfaceC1257 != null) {
                                interfaceC1257.mo3230(getProFromDegree(f4), this.f3546);
                                return;
                            }
                            return;
                        }
                        this.f3523 = 0.0f;
                    } else {
                        this.f3523 = 0.0f;
                        this.f3524 += 1.0f;
                        float f5 = iM3512;
                        if (Math.abs(f3 - f5) < 0.5f && this.f3524 < 10.0f) {
                            this.f3529 = f5;
                            this.f3519.reset();
                            this.f3519.postRotate(-f5, this.f3521 / 2, this.f3520 / 2);
                            setImageMatrix(this.f3519);
                            InterfaceC1257 interfaceC12572 = this.f3543;
                            if (interfaceC12572 != null) {
                                interfaceC12572.mo3230(getProFromDegree(f5), this.f3546);
                                return;
                            }
                            return;
                        }
                        this.f3524 = 0.0f;
                    }
                } else if (!m3514(this.f3529, f2)) {
                    int i = (int) (f2 / 30.0f);
                    if (this.f3529 > f2) {
                        if (f2 > 0.0f) {
                            i++;
                        }
                    } else if (f2 < 0.0f) {
                        i--;
                    }
                    float fMax = Math.max(getMinDegree(false), Math.min(getMaxDegree(true), i * 30));
                    C4638.m14099("slim", "lastDegree:" + f2 + " mCurrentDegree:" + this.f3529 + " rAngle:" + fMax);
                    this.f3529 = fMax;
                    this.f3519.reset();
                    this.f3519.postRotate(-fMax, (float) (this.f3521 / 2), (float) (this.f3520 / 2));
                    setImageMatrix(this.f3519);
                    InterfaceC1257 interfaceC12573 = this.f3543;
                    if (interfaceC12573 != null) {
                        interfaceC12573.mo3230(getProFromDegree(fMax), this.f3546);
                        return;
                    }
                    return;
                }
            }
            InterfaceC1257 interfaceC12574 = this.f3543;
            if (interfaceC12574 != null) {
                interfaceC12574.mo3230(getProFromDegree(matrixAngle), this.f3546);
            }
            setImageMatrix(this.f3519);
        }
    }

    public final void rotateWheel2(float f) {
        float fMin = Math.min(Math.max(f, getMinDegree(false)), getMaxDegree(false));
        this.f3519.reset();
        this.f3519.postRotate(-fMin, this.f3521 / 2, this.f3520 / 2);
        if (fMin != this.f3529) {
            this.f3529 = fMin;
            InterfaceC1257 interfaceC1257 = this.f3543;
            if (interfaceC1257 != null) {
                interfaceC1257.mo3230(getProFromDegree(fMin), this.f3546);
            }
            setImageMatrix(this.f3519);
        }
    }

    public void setAutoZoomWheelView(AutoZoomWheelView autoZoomWheelView) {
        this.f3545 = autoZoomWheelView;
    }

    public void setDegrees(float f, float f2) {
        this.f3531 = f;
        this.f3532 = f2;
        this.f3533 = 0.0f;
    }

    public void setHighP(boolean z) {
        this.f3546 = z;
    }

    public void setNeedCheckMag(boolean z) {
        this.f3525 = z;
    }

    public void setOnProChange(InterfaceC1257 interfaceC1257) {
        this.f3543 = interfaceC1257;
    }

    public void setOnTouchStateChange(InterfaceC1258 interfaceC1258) {
        this.f3544 = interfaceC1258;
    }

    public void setPro(float f) {
        this.f3529 = getDegreeFromPercent(f);
        if (this.f3521 == 0 || this.f3520 == 0) {
            this.f3530 = true;
            return;
        }
        this.f3519.reset();
        this.f3519.postRotate(-this.f3529, this.f3521 / 2, this.f3520 / 2);
        setImageMatrix(this.f3519);
    }

    public void setRightView(boolean z) {
        this.f3526 = z;
    }

    public void setWheelImage(Bitmap bitmap) {
        int i;
        this.f3517 = bitmap;
        int i2 = this.f3520;
        if (i2 == 0 || (i = this.f3521) == 0) {
            this.f3530 = true;
            return;
        }
        this.f3518 = BITMAP_RESIZER(bitmap, i, i2);
        this.f3519.postTranslate((this.f3521 / 2) - (r4.getWidth() / 2), (this.f3520 / 2) - (this.f3518.getHeight() / 2));
        this.f3519.postRotate(-this.f3529, this.f3521 / 2, this.f3520 / 2);
        this.f3530 = false;
        setImageBitmap(this.f3518);
        setImageMatrix(this.f3519);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m3510() {
        Timer timer = this.f3540;
        if (timer != null) {
            timer.cancel();
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final boolean m3511(double d, MotionEvent motionEvent) {
        float f;
        if (!this.f3526) {
            return false;
        }
        cancelClickMove();
        boolean z = Math.abs(motionEvent.getRawX() - this.f3536) <= 3.0f && Math.abs(motionEvent.getRawY() - this.f3537) <= 3.0f;
        if (System.currentTimeMillis() - this.f3534 >= 200 || !z) {
            return false;
        }
        Timer timer = this.f3540;
        if (timer != null) {
            timer.cancel();
        }
        float matrixAngle = getMatrixAngle();
        float angle = (float) getAngle(motionEvent.getX(), motionEvent.getY());
        if (!this.f3526) {
            if ((angle < 0.0f || angle > 90.0f) && angle >= 270.0f) {
                f = 360.0f;
                if (angle <= 360.0f) {
                }
            }
            this.f3528 = ValueAnimator.ofFloat(matrixAngle, -(angle - matrixAngle));
            this.f3528.setDuration((int) ((Math.abs(r8 - matrixAngle) / (getMaxDegree(true) - getMinDegree(false))) * 2000.0f));
            this.f3528.addUpdateListener(new C1254());
            this.f3528.setInterpolator(new LinearInterpolator());
            this.f3528.addListener(new C1255());
            this.f3528.start();
            return true;
        }
        f = 180.0f;
        angle -= f;
        this.f3528 = ValueAnimator.ofFloat(matrixAngle, -(angle - matrixAngle));
        this.f3528.setDuration((int) ((Math.abs(r8 - matrixAngle) / (getMaxDegree(true) - getMinDegree(false))) * 2000.0f));
        this.f3528.addUpdateListener(new C1254());
        this.f3528.setInterpolator(new LinearInterpolator());
        this.f3528.addListener(new C1255());
        this.f3528.start();
        return true;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final int m3512(float f) {
        if (Math.abs(f - 0.0f) <= 0.001f) {
            return 0;
        }
        if (Math.abs(f - 30.0f) <= 0.001f) {
            return 30;
        }
        if (Math.abs(f - 60.0f) <= 0.001f) {
            return 60;
        }
        if (Math.abs(30.0f + f) <= 0.001f) {
            return -30;
        }
        return Math.abs(f + 60.0f) <= 0.001f ? -60 : -1;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean m3513() {
        return this.f3546;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final boolean m3514(float f, float f2) {
        return f * f2 >= 0.0f && Math.abs(f2 - f) < 30.0f && ((int) (f / 30.0f)) == ((int) (f2 / 30.0f));
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean m3515() {
        return this.f3542;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m3516() {
        Timer timer = new Timer();
        this.f3540 = timer;
        timer.schedule(new C1256(), 1000L);
    }
}
