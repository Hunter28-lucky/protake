package com.blink.academy.film.stream;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blink.academy.film.custom.ABPointMessage;
import com.blink.academy.film.custom.WeakHandler;
import com.google.mlkit.common.MlKitException;
import defpackage.C4008;
import java.util.Timer;

/* loaded from: classes.dex */
public class ACWheelProgressView extends AppCompatImageView {
    private static final int CLICK_END_MAX = 1;
    private static final int CLICK_END_MIN = 2;
    private static final int CLICK_END_NOTHING = 0;
    private static final String TAG = ACWheelProgressView.class.getSimpleName();
    private static final float mNearDegree = 0.0f;
    private static final float mNearOffset = 0.0f;
    private ABPointMessage abPointMessage;
    private int clickEndRight;
    private Context context;
    private long downTimeMs;
    private float downX;
    private float downY;
    private boolean exposure;
    private ValueAnimator fixValueAnimator;
    private ValueAnimator gimbalAnimator;
    private boolean hasAuto;
    private Bitmap imageOriginal;
    private Bitmap imageScaled;
    private boolean isAnim;
    private boolean isValidDownArea;
    private long lastT;
    private Timer mAnimTimer;
    private float mAutoDegree;
    private float mCurrentDegree;
    private float mFactor;
    private WeakHandler mHandler;
    private float mMaxDegree;
    private float mMinDegree;
    private int mRejectTime;
    private Matrix matrix;
    private boolean needRotate;
    private float offsetDegree;
    private OnProChange onProChange;
    private OnTouchStateChange onTouchStateChange;
    private boolean rightView;
    private int top;
    private int wheelHeight;
    private int wheelWidth;

    public interface OnProChange {
        float getFocusP();

        void onChange(float f);
    }

    public interface OnTouchStateChange {
        void onAnimChange(boolean z);

        void onDown();

        void onUp();
    }

    public class WheelTouchListener implements View.OnTouchListener {
        private double startAngle;

        private WheelTouchListener() {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
            /*
                r5 = this;
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                boolean r6 = r6.isEnabled()
                if (r6 == 0) goto Lc0
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                boolean r6 = com.blink.academy.film.stream.ACWheelProgressView.access$800(r6)
                if (r6 == 0) goto L12
                goto Lc0
            L12:
                int r6 = r7.getAction()
                r0 = 1
                if (r6 == 0) goto L6e
                if (r6 == r0) goto L48
                r1 = 2
                if (r6 == r1) goto L23
                r1 = 3
                if (r6 == r1) goto L48
                goto Lbf
            L23:
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                boolean r6 = com.blink.academy.film.stream.ACWheelProgressView.access$1100(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                float r1 = r7.getX()
                double r1 = (double) r1
                float r7 = r7.getY()
                double r3 = (double) r7
                double r6 = r6.getAngle(r1, r3)
                com.blink.academy.film.stream.ACWheelProgressView r1 = com.blink.academy.film.stream.ACWheelProgressView.this
                double r2 = r5.startAngle
                double r2 = r2 - r6
                float r2 = (float) r2
                r1.rotateWheel(r2)
                r5.startAngle = r6
                goto Lbf
            L48:
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                boolean r6 = com.blink.academy.film.stream.ACWheelProgressView.access$1100(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                double r1 = r5.startAngle
                com.blink.academy.film.stream.ACWheelProgressView.access$1600(r6, r1, r7)
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                com.blink.academy.film.stream.ACWheelProgressView.access$1700(r6)
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                com.blink.academy.film.stream.ACWheelProgressView$OnTouchStateChange r6 = com.blink.academy.film.stream.ACWheelProgressView.access$1500(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                com.blink.academy.film.stream.ACWheelProgressView$OnTouchStateChange r6 = com.blink.academy.film.stream.ACWheelProgressView.access$1500(r6)
                r6.onUp()
                goto Lbf
            L6e:
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                r1 = 0
                com.blink.academy.film.stream.ACWheelProgressView.access$902(r6, r1)
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                com.blink.academy.film.stream.ACWheelProgressView.access$1000(r6, r7)
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                boolean r6 = com.blink.academy.film.stream.ACWheelProgressView.access$1100(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                float r1 = r7.getRawX()
                com.blink.academy.film.stream.ACWheelProgressView.access$1202(r6, r1)
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                float r1 = r7.getRawY()
                com.blink.academy.film.stream.ACWheelProgressView.access$1302(r6, r1)
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                long r1 = java.lang.System.currentTimeMillis()
                com.blink.academy.film.stream.ACWheelProgressView.access$1402(r6, r1)
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                float r1 = r7.getX()
                double r1 = (double) r1
                float r7 = r7.getY()
                double r3 = (double) r7
                double r6 = r6.getAngle(r1, r3)
                r5.startAngle = r6
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                com.blink.academy.film.stream.ACWheelProgressView$OnTouchStateChange r6 = com.blink.academy.film.stream.ACWheelProgressView.access$1500(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.stream.ACWheelProgressView r6 = com.blink.academy.film.stream.ACWheelProgressView.this
                com.blink.academy.film.stream.ACWheelProgressView$OnTouchStateChange r6 = com.blink.academy.film.stream.ACWheelProgressView.access$1500(r6)
                r6.onDown()
            Lbf:
                return r0
            Lc0:
                r6 = 0
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.stream.ACWheelProgressView.WheelTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public ACWheelProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRejectTime = 0;
        this.offsetDegree = 0.0f;
        this.exposure = false;
        this.clickEndRight = 0;
        this.isValidDownArea = true;
        init(context);
    }

    private void cancelFixMove() {
        ValueAnimator valueAnimator = this.fixValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void checkActionUpIsClick(double r10, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.stream.ACWheelProgressView.checkActionUpIsClick(double, android.view.MotionEvent):void");
    }

    private void checkIsInAuto() {
        if (this.hasAuto) {
            float matrixAngle = getMatrixAngle();
            boolean z = true;
            float maxDegree = getMaxDegree(true);
            float maxDegree2 = getMaxDegree(false);
            float minDegree = getMinDegree(true);
            float minDegree2 = getMinDegree(false);
            if (matrixAngle > maxDegree && matrixAngle < maxDegree2) {
                matrixAngle = matrixAngle - maxDegree >= this.mAutoDegree / 2.0f ? maxDegree2 : maxDegree;
            } else if (matrixAngle >= minDegree || matrixAngle <= minDegree2) {
                z = false;
            } else {
                matrixAngle = minDegree - matrixAngle >= this.mAutoDegree / 2.0f ? minDegree2 : minDegree;
            }
            if (z) {
                this.mCurrentDegree = matrixAngle;
                this.matrix.reset();
                this.matrix.postRotate(-this.mCurrentDegree, this.wheelWidth / 2, this.wheelHeight / 2);
                setImageMatrix(this.matrix);
                OnProChange onProChange = this.onProChange;
                if (onProChange != null) {
                    onProChange.onChange(getProFromDegree(this.mCurrentDegree));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkValidDownArea(MotionEvent motionEvent) {
        motionEvent.getX();
        motionEvent.getY();
        this.isValidDownArea = true;
    }

    private void doFixAutoAnim(float f, final float f2, int i) {
        int iAbs = (int) (((Math.abs(f2 - f) * 1.0f) / (this.mAutoDegree / 2.0f)) * i);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.fixValueAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(iAbs);
        this.fixValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blink.academy.film.stream.ACWheelProgressView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ACWheelProgressView.this.rotateWheel3(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.fixValueAnimator.setInterpolator(C4008.m12881());
        this.fixValueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.blink.academy.film.stream.ACWheelProgressView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ACWheelProgressView.this.onProChange != null) {
                    ACWheelProgressView.this.onProChange.onChange(ACWheelProgressView.this.getProFromDegree(f2));
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.fixValueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixActionUpForAuto() {
        float minDegree;
        if (this.hasAuto) {
            cancelFixMove();
            float matrixAngle = getMatrixAngle();
            if (matrixAngle > getMaxDegree(true)) {
                minDegree = matrixAngle - getMaxDegree(true) >= this.mAutoDegree / 2.0f ? getMaxDegree(false) : getMaxDegree(true);
            } else if (matrixAngle >= getMinDegree(true)) {
                return;
            } else {
                minDegree = getMinDegree(true) - matrixAngle >= this.mAutoDegree / 2.0f ? getMinDegree(false) : getMinDegree(true);
            }
            doFixAutoAnim(matrixAngle, minDegree, 200);
        }
    }

    private float getFixDegreeForAuto(float f, float f2, float f3) {
        float f4 = f2 - f;
        return Math.abs(f4) < 0.001f ? f : f + (f4 / 5.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float getFixDegreeForAuto2(float r4, float r5, float r6) {
        /*
            r3 = this;
            float r5 = r5 - r4
            float r0 = java.lang.Math.abs(r5)
            r1 = 981668463(0x3a83126f, float:0.001)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto Ld
            goto L11
        Ld:
            r0 = 1082130432(0x40800000, float:4.0)
            float r5 = r5 / r0
            float r4 = r4 + r5
        L11:
            float r5 = r6 - r4
            float r5 = java.lang.Math.abs(r5)
            float r0 = r3.mAutoDegree
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r0 = 0
            if (r5 > 0) goto L76
            r4 = 1
            float r4 = r3.getMaxDegree(r4)
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 != 0) goto L36
            float r4 = r3.mFactor
            float r4 = r4 + r0
            r3.mFactor = r4
            float r5 = r3.mAutoDegree
        L31:
            float r5 = r5 / r1
            float r5 = r5 + r6
            float r5 = r5 + r0
            float r5 = r5 - r4
            goto L64
        L36:
            r4 = 0
            float r5 = r3.getMaxDegree(r4)
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L4c
            float r4 = r3.mFactor
            float r4 = r4 + r0
            r3.mFactor = r4
            float r5 = r3.mAutoDegree
        L46:
            float r5 = r5 / r1
            float r5 = r6 - r5
            float r5 = r5 - r0
            float r5 = r5 + r4
            goto L64
        L4c:
            float r4 = r3.getMinDegree(r4)
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 != 0) goto L5c
            float r4 = r3.mFactor
            float r4 = r4 + r0
            r3.mFactor = r4
            float r5 = r3.mAutoDegree
            goto L31
        L5c:
            float r4 = r3.mFactor
            float r4 = r4 + r0
            r3.mFactor = r4
            float r5 = r3.mAutoDegree
            goto L46
        L64:
            float r4 = r6 - r5
            float r4 = java.lang.Math.abs(r4)
            float r2 = r3.mAutoDegree
            float r2 = r2 / r1
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 > 0) goto L74
            r3.mFactor = r0
            goto L79
        L74:
            r6 = r5
            goto L79
        L76:
            r3.mFactor = r0
            r6 = r4
        L79:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.stream.ACWheelProgressView.getFixDegreeForAuto2(float, float, float):float");
    }

    private float getMatrixAngle() {
        float[] fArr = new float[9];
        this.matrix.getValues(fArr);
        float f = fArr[0];
        float f2 = fArr[3];
        Math.sqrt((f * f) + (f2 * f2));
        return (float) (Math.atan2(fArr[1], fArr[0]) * 57.29577951308232d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMaxDegree(boolean z) {
        return z ? this.mMaxDegree : this.mMaxDegree + this.mAutoDegree;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMinDegree(boolean z) {
        return z ? this.mMinDegree : this.mMinDegree - this.mAutoDegree;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getProFromDegree(float f) {
        return (f - getMinDegree(true)) / (getMaxDegree(true) - getMinDegree(true));
    }

    private static int getQuadrant(double d, double d2) {
        return d >= 0.0d ? d2 >= 0.0d ? 1 : 4 : d2 >= 0.0d ? 2 : 3;
    }

    private boolean inCircle(float f, float f2) {
        int i = this.wheelWidth;
        return ((f - (((float) i) / 2.0f)) * (f - (((float) i) / 2.0f))) + ((f2 - (((float) i) / 2.0f)) * (f2 - (((float) i) / 2.0f))) <= (((((float) i) * 1164.0f) / 1280.0f) / 2.0f) * (((((float) i) * 1164.0f) / 1280.0f) / 2.0f);
    }

    private void init(Context context) {
        this.context = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = this.matrix;
        if (matrix == null) {
            this.matrix = new Matrix();
        } else {
            matrix.reset();
        }
        setOnTouchListener(new WheelTouchListener());
    }

    private void refreshBitmap() {
        this.imageScaled = BITMAP_RESIZER(this.imageOriginal, this.wheelWidth, this.wheelHeight);
        this.matrix.postTranslate((this.wheelWidth / 2) - (r0.getWidth() / 2), (this.wheelHeight / 2) - (this.imageScaled.getHeight() / 2));
        if (this.needRotate) {
            this.matrix.postRotate(-this.mCurrentDegree, this.wheelWidth / 2, this.wheelHeight / 2);
            this.needRotate = false;
        }
        setImageBitmap(this.imageScaled);
        setImageMatrix(this.matrix);
    }

    private void rotateWheel2(float f) {
        float fMin = Math.min(Math.max(f, getMinDegree(false)), getMaxDegree(false));
        this.matrix.reset();
        this.matrix.postRotate(-fMin, this.wheelWidth / 2, this.wheelHeight / 2);
        if (fMin != this.mCurrentDegree) {
            this.mCurrentDegree = fMin;
            setImageMatrix(this.matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateWheel3(float f) {
        float fMin = Math.min(Math.max(f, getMinDegree(false)), getMaxDegree(false));
        this.matrix.reset();
        this.matrix.postRotate(-fMin, this.wheelWidth / 2, this.wheelHeight / 2);
        if (fMin != this.mCurrentDegree) {
            this.mCurrentDegree = fMin;
            setImageMatrix(this.matrix);
        }
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
        this.mHandler.removeMessages(MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE);
        Timer timer = this.mAnimTimer;
        if (timer != null) {
            timer.cancel();
            this.mAnimTimer = null;
        }
        onAnimEnd();
    }

    public double getAngle(double d, double d2) {
        double d3 = d - (this.wheelWidth / 2.0d);
        int i = this.wheelHeight;
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
        return this.mCurrentDegree;
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

    public float getNowDegree() {
        return getMatrixAngle();
    }

    public void onAnimEnd() {
        ABPointMessage aBPointMessage = this.abPointMessage;
        if (aBPointMessage != null) {
            final float fMin = Math.min(Math.max(aBPointMessage.getEndFocusP(), getMinDegree(false)), getMaxDegree(false));
            int i = this.clickEndRight;
            if (i == 1) {
                fMin = getMaxDegree(false);
                rotateWheel2(getMaxDegree(false));
            } else if (i == 2) {
                fMin = getMinDegree(false);
                rotateWheel2(getMinDegree(false));
            }
            this.clickEndRight = 0;
            OnTouchStateChange onTouchStateChange = this.onTouchStateChange;
            if (onTouchStateChange != null) {
                onTouchStateChange.onAnimChange(false);
            }
            this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.stream.ACWheelProgressView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ACWheelProgressView.this.onProChange != null) {
                        ACWheelProgressView.this.onProChange.onChange(ACWheelProgressView.this.getProFromDegree(fMin));
                    }
                }
            });
            this.abPointMessage = null;
        }
    }

    public void onAnimValueChange(float f) {
        rotateWheel2(f);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.wheelHeight == 0 || this.wheelWidth == 0) {
            this.wheelHeight = (i2 - getPaddingTop()) - getPaddingBottom();
            this.wheelWidth = (i - getPaddingLeft()) - getPaddingRight();
            refreshBitmap();
        }
    }

    public void resetWheelBitmap(Bitmap bitmap) {
        this.imageOriginal = bitmap;
        if (this.wheelHeight == 0 || this.wheelWidth == 0) {
            return;
        }
        refreshBitmap();
    }

    public void rotateWheel(float f) {
        this.matrix.postRotate(f, this.wheelWidth / 2, this.wheelHeight / 2);
        float matrixAngle = getMatrixAngle();
        if (matrixAngle > getMaxDegree(false)) {
            matrixAngle = getMaxDegree(false);
            this.matrix.reset();
            this.matrix.postRotate(-matrixAngle, this.wheelWidth / 2, this.wheelHeight / 2);
        } else if (matrixAngle < getMinDegree(false)) {
            matrixAngle = getMinDegree(false);
            this.matrix.reset();
            this.matrix.postRotate(-matrixAngle, this.wheelWidth / 2, this.wheelHeight / 2);
        } else if (this.exposure && matrixAngle >= -1.0f && matrixAngle <= 1.0f && matrixAngle != 0.0f) {
            if (this.mRejectTime < 10) {
                this.matrix.reset();
                this.matrix.postRotate(-0.0f, this.wheelWidth / 2, this.wheelHeight / 2);
                this.mRejectTime++;
                matrixAngle = 0.0f;
            } else {
                this.mRejectTime = 0;
            }
        }
        float f2 = this.mCurrentDegree;
        if (matrixAngle != f2) {
            this.mCurrentDegree = matrixAngle;
            if (matrixAngle <= getMaxDegree(true) && this.mCurrentDegree >= getMinDegree(true)) {
                OnProChange onProChange = this.onProChange;
                if (onProChange != null) {
                    onProChange.onChange(getProFromDegree(matrixAngle));
                }
                setImageMatrix(this.matrix);
                return;
            }
            OnProChange onProChange2 = this.onProChange;
            float focusP = onProChange2 != null ? onProChange2.getFocusP() : 0.0f;
            float fixDegreeForAuto2 = getFixDegreeForAuto2(f2, matrixAngle, focusP > 1.0f ? getMaxDegree(true) : focusP < 0.0f ? getMinDegree(true) : (focusP < 0.0f || focusP >= 0.1f) ? getMaxDegree(false) : getMinDegree(false));
            this.mCurrentDegree = fixDegreeForAuto2;
            if (this.onProChange != null) {
                if (Math.abs(fixDegreeForAuto2 - getMinDegree(true)) <= 0.1f || Math.abs(fixDegreeForAuto2 - getMinDegree(false)) <= 0.1f || Math.abs(fixDegreeForAuto2 - getMaxDegree(true)) <= 0.1f || Math.abs(fixDegreeForAuto2 - getMaxDegree(false)) <= 0.1f) {
                    float fRound = Math.round(fixDegreeForAuto2);
                    this.mFactor = 0.0f;
                    cancelFixMove();
                    doFixAutoAnim(f2, fRound, 100);
                    return;
                }
            }
            this.matrix.reset();
            this.matrix.postRotate(-fixDegreeForAuto2, this.wheelWidth / 2, this.wheelHeight / 2);
            setImageMatrix(this.matrix);
        }
    }

    public void setDegrees(float f, float f2) {
        this.mMaxDegree = f;
        this.mMinDegree = f2;
        this.mAutoDegree = 0.0f;
    }

    public void setExposure(boolean z) {
        this.exposure = z;
    }

    public void setHandler(WeakHandler weakHandler) {
        this.mHandler = weakHandler;
    }

    public void setOnProChange(OnProChange onProChange) {
        this.onProChange = onProChange;
    }

    public void setOnTouchStateChange(OnTouchStateChange onTouchStateChange) {
        this.onTouchStateChange = onTouchStateChange;
    }

    public void setPro(float f) {
        this.mCurrentDegree = getDegreeFromPercent(f);
        if (this.wheelWidth == 0 || this.wheelHeight == 0) {
            this.needRotate = true;
            return;
        }
        this.matrix.reset();
        this.matrix.postRotate(-this.mCurrentDegree, this.wheelWidth / 2, this.wheelHeight / 2);
        setImageMatrix(this.matrix);
    }

    public void setRightView(boolean z) {
        this.rightView = z;
    }

    public void setWheelImage(int i) {
        this.imageOriginal = BitmapFactory.decodeResource(this.context.getResources(), i);
    }

    public void setWheelImage(Bitmap bitmap) {
        this.imageOriginal = bitmap;
    }

    public void setDegrees(float f, float f2, float f3) {
        this.mMaxDegree = f;
        this.mMinDegree = f2;
        this.mAutoDegree = f3;
        this.hasAuto = f3 != 0.0f;
    }
}
