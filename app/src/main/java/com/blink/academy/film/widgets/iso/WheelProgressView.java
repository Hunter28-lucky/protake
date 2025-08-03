package com.blink.academy.film.widgets.iso;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blink.academy.film.custom.ABPointMessage;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.widgets.iso.FocusZoomWheelView;
import com.google.mlkit.common.MlKitException;
import defpackage.C3947;
import defpackage.C4008;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class WheelProgressView extends AppCompatImageView {

    /* renamed from: ޗ, reason: contains not printable characters */
    public static final String f3467 = WheelProgressView.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public Bitmap f3468;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Bitmap f3469;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Matrix f3470;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3471;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3472;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Context f3473;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f3474;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f3475;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f3476;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f3477;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f3478;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f3479;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f3480;

    /* renamed from: ރ, reason: contains not printable characters */
    public ABPointMessage f3481;

    /* renamed from: ބ, reason: contains not printable characters */
    public Timer f3482;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f3483;

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean f3484;

    /* renamed from: އ, reason: contains not printable characters */
    public float f3485;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f3486;

    /* renamed from: މ, reason: contains not printable characters */
    public float f3487;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f3488;

    /* renamed from: ދ, reason: contains not printable characters */
    public long f3489;

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean f3490;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f3491;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f3492;

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean f3493;

    /* renamed from: ސ, reason: contains not printable characters */
    public ValueAnimator f3494;

    /* renamed from: ޑ, reason: contains not printable characters */
    public ValueAnimator f3495;

    /* renamed from: ޒ, reason: contains not printable characters */
    public boolean f3496;

    /* renamed from: ޓ, reason: contains not printable characters */
    public InterfaceC1251 f3497;

    /* renamed from: ޔ, reason: contains not printable characters */
    public InterfaceC1250 f3498;

    /* renamed from: ޕ, reason: contains not printable characters */
    public InterfaceC1252 f3499;

    /* renamed from: ޖ, reason: contains not printable characters */
    public WeakHandler f3500;

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$Ϳ, reason: contains not printable characters */
    public class C1240 extends TimerTask {

        /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC1241 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ float f3502;

            public RunnableC1241(float f) {
                this.f3502 = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WheelProgressView.this.f3497 != null) {
                    WheelProgressView.this.f3497.onChange(WheelProgressView.this.getProFromDegree(this.f3502));
                }
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$Ϳ$Ԩ, reason: contains not printable characters */
        public class RunnableC1242 implements Runnable {
            public RunnableC1242() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WheelProgressView.this.cancelClickMove();
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$Ϳ$Ԫ, reason: contains not printable characters */
        public class RunnableC1243 implements Runnable {
            public RunnableC1243() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WheelProgressView.this.cancelClickMove();
            }
        }

        public C1240() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (WheelProgressView.this.f3481 == null) {
                WheelProgressView.this.f3500.post(new RunnableC1243());
                return;
            }
            int iMin = Math.min(C3947.m12727().m12747(), 60);
            int i = iMin != 0 ? iMin : 60;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis >= WheelProgressView.this.f3481.getStartMs() + WheelProgressView.this.f3481.getTotalMs()) {
                WheelProgressView.this.f3500.post(new RunnableC1242());
                return;
            }
            long totalMs = WheelProgressView.this.f3481.getTotalMs();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - WheelProgressView.this.f3481.getStartMs();
            float startFocusP = WheelProgressView.this.f3481.getStartFocusP();
            WheelProgressView.this.f3500.post(new RunnableC1241(Math.min(Math.max(startFocusP + (((jCurrentTimeMillis2 * 1.0f) / totalMs) * (WheelProgressView.this.f3481.getEndFocusP() - startFocusP)), WheelProgressView.this.getMinDegree(false)), WheelProgressView.this.getMaxDegree(false))));
            WheelProgressView.this.f3474 = jCurrentTimeMillis;
            Message messageObtain = Message.obtain();
            messageObtain.obj = WheelProgressView.this.f3481;
            messageObtain.what = MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE;
            WheelProgressView.this.f3500.sendMessageDelayed(messageObtain, (1 / i) * 1000);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$Ԩ, reason: contains not printable characters */
    public class RunnableC1244 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float f3506;

        public RunnableC1244(float f) {
            this.f3506 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WheelProgressView.this.f3497 != null) {
                WheelProgressView.this.f3497.onChange(WheelProgressView.this.getProFromDegree(this.f3506));
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$Ԫ, reason: contains not printable characters */
    public class C1245 implements ValueAnimator.AnimatorUpdateListener {
        public C1245() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WheelProgressView.this.rotateWheel3(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$Ԭ, reason: contains not printable characters */
    public class C1246 implements Animator.AnimatorListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ float f3509;

        public C1246(float f) {
            this.f3509 = f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (WheelProgressView.this.f3497 != null) {
                WheelProgressView.this.f3497.onChange(WheelProgressView.this.getProFromDegree(this.f3509));
            }
            WheelProgressView.this.f3496 = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$Ԯ, reason: contains not printable characters */
    public class C1247 implements ValueAnimator.AnimatorUpdateListener {
        public C1247() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WheelProgressView.this.rotateWheel3(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$ՠ, reason: contains not printable characters */
    public class C1248 implements Animator.AnimatorListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ FocusZoomWheelView.InterfaceC1175 f3512;

        public C1248(FocusZoomWheelView.InterfaceC1175 interfaceC1175) {
            this.f3512 = interfaceC1175;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FocusZoomWheelView.InterfaceC1175 interfaceC1175 = this.f3512;
            if (interfaceC1175 != null) {
                interfaceC1175.mo1325();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$ֈ, reason: contains not printable characters */
    public interface InterfaceC1249 {
        /* renamed from: Ϳ */
        void mo3281();
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$֏, reason: contains not printable characters */
    public interface InterfaceC1250 {
        /* renamed from: Ϳ */
        void mo3282();
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$ׯ, reason: contains not printable characters */
    public interface InterfaceC1251 {
        void onChange(float f);
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$ؠ, reason: contains not printable characters */
    public interface InterfaceC1252 {
        void onAnimChange(boolean z);

        void onDown();

        void onUp();
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelProgressView$ހ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1253 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public double f3514;

        public ViewOnTouchListenerC1253() {
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
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                boolean r6 = r6.isEnabled()
                if (r6 == 0) goto Lc0
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                boolean r6 = com.blink.academy.film.widgets.iso.WheelProgressView.m3480(r6)
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
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                boolean r6 = com.blink.academy.film.widgets.iso.WheelProgressView.m3465(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                float r1 = r7.getX()
                double r1 = (double) r1
                float r7 = r7.getY()
                double r3 = (double) r7
                double r6 = r6.getAngle(r1, r3)
                com.blink.academy.film.widgets.iso.WheelProgressView r1 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                double r2 = r5.f3514
                double r2 = r2 - r6
                float r2 = (float) r2
                r1.rotateWheel(r2)
                r5.f3514 = r6
                goto Lbf
            L48:
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                boolean r6 = com.blink.academy.film.widgets.iso.WheelProgressView.m3465(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                double r1 = r5.f3514
                com.blink.academy.film.widgets.iso.WheelProgressView.m3470(r6, r1, r7)
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                com.blink.academy.film.widgets.iso.WheelProgressView.m3471(r6)
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                com.blink.academy.film.widgets.iso.WheelProgressView$ؠ r6 = com.blink.academy.film.widgets.iso.WheelProgressView.m3469(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                com.blink.academy.film.widgets.iso.WheelProgressView$ؠ r6 = com.blink.academy.film.widgets.iso.WheelProgressView.m3469(r6)
                r6.onUp()
                goto Lbf
            L6e:
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                r1 = 0
                com.blink.academy.film.widgets.iso.WheelProgressView.m3481(r6, r1)
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                com.blink.academy.film.widgets.iso.WheelProgressView.m3464(r6, r7)
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                boolean r6 = com.blink.academy.film.widgets.iso.WheelProgressView.m3465(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                float r1 = r7.getRawX()
                com.blink.academy.film.widgets.iso.WheelProgressView.m3466(r6, r1)
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                float r1 = r7.getRawY()
                com.blink.academy.film.widgets.iso.WheelProgressView.m3467(r6, r1)
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                long r1 = java.lang.System.currentTimeMillis()
                com.blink.academy.film.widgets.iso.WheelProgressView.m3468(r6, r1)
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                float r1 = r7.getX()
                double r1 = (double) r1
                float r7 = r7.getY()
                double r3 = (double) r7
                double r6 = r6.getAngle(r1, r3)
                r5.f3514 = r6
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                com.blink.academy.film.widgets.iso.WheelProgressView$ؠ r6 = com.blink.academy.film.widgets.iso.WheelProgressView.m3469(r6)
                if (r6 == 0) goto Lbf
                com.blink.academy.film.widgets.iso.WheelProgressView r6 = com.blink.academy.film.widgets.iso.WheelProgressView.this
                com.blink.academy.film.widgets.iso.WheelProgressView$ؠ r6 = com.blink.academy.film.widgets.iso.WheelProgressView.m3469(r6)
                r6.onDown()
            Lbf:
                return r0
            Lc0:
                r6 = 0
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.WheelProgressView.ViewOnTouchListenerC1253.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        public /* synthetic */ ViewOnTouchListenerC1253(WheelProgressView wheelProgressView, C1240 c1240) {
            this();
        }
    }

    public WheelProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3475 = 0;
        this.f3476 = 0.0f;
        this.f3478 = false;
        this.f3480 = 0;
        this.f3493 = true;
        this.f3496 = false;
        init(context);
    }

    private float getMatrixAngle() {
        float[] fArr = new float[9];
        this.f3470.getValues(fArr);
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
        this.f3500.removeMessages(MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE);
        Timer timer = this.f3482;
        if (timer != null) {
            timer.cancel();
            this.f3482 = null;
        }
        onAnimEnd();
    }

    public final void cancelFixMove() {
        ValueAnimator valueAnimator = this.f3494;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkActionUpIsClick(double r10, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.WheelProgressView.checkActionUpIsClick(double, android.view.MotionEvent):void");
    }

    public final void checkValidDownArea(MotionEvent motionEvent) {
        motionEvent.getX();
        motionEvent.getY();
        this.f3493 = true;
    }

    public final void doFixAutoAnim(float f, float f2, int i) {
        this.f3496 = true;
        int iAbs = (int) (((Math.abs(f2 - f) * 1.0f) / (this.f3487 / 2.0f)) * i);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.f3494 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(iAbs);
        this.f3494.addUpdateListener(new C1245());
        this.f3494.setInterpolator(C4008.m12881());
        this.f3494.addListener(new C1246(f2));
        this.f3494.start();
    }

    public final void fixActionUpForAuto() {
        float minDegree;
        if (this.f3488) {
            cancelFixMove();
            float matrixAngle = getMatrixAngle();
            if (matrixAngle > getMaxDegree(true)) {
                minDegree = matrixAngle - getMaxDegree(true) >= this.f3487 / 2.0f ? getMaxDegree(false) : getMaxDegree(true);
            } else if (matrixAngle >= getMinDegree(true)) {
                return;
            } else {
                minDegree = getMinDegree(true) - matrixAngle >= this.f3487 / 2.0f ? getMinDegree(false) : getMinDegree(true);
            }
            doFixAutoAnim(matrixAngle, minDegree, 200);
        }
    }

    public double getAngle(double d, double d2) {
        double d3 = d - (this.f3472 / 2.0d);
        int i = this.f3471;
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
        return this.f3483;
    }

    public float getCurrentPro() {
        return getProFromDegree(this.f3483);
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float getFixDegreeForAuto2(float r4, float r5, float r6) {
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
            float r0 = r3.f3487
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r0 = 0
            if (r5 > 0) goto L76
            r4 = 1
            float r4 = r3.getMaxDegree(r4)
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 != 0) goto L36
            float r4 = r3.f3477
            float r4 = r4 + r0
            r3.f3477 = r4
            float r5 = r3.f3487
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
            float r4 = r3.f3477
            float r4 = r4 + r0
            r3.f3477 = r4
            float r5 = r3.f3487
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
            float r4 = r3.f3477
            float r4 = r4 + r0
            r3.f3477 = r4
            float r5 = r3.f3487
            goto L31
        L5c:
            float r4 = r3.f3477
            float r4 = r4 + r0
            r3.f3477 = r4
            float r5 = r3.f3487
            goto L46
        L64:
            float r4 = r6 - r5
            float r4 = java.lang.Math.abs(r4)
            float r2 = r3.f3487
            float r2 = r2 / r1
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 > 0) goto L74
            r3.f3477 = r0
            goto L79
        L74:
            r6 = r5
            goto L79
        L76:
            r3.f3477 = r0
            r6 = r4
        L79:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.WheelProgressView.getFixDegreeForAuto2(float, float, float):float");
    }

    public final float getMaxDegree(boolean z) {
        return z ? this.f3485 : this.f3485 + this.f3487;
    }

    public final float getMinDegree(boolean z) {
        return z ? this.f3486 : this.f3486 - this.f3487;
    }

    public float getNowDegree() {
        return getMatrixAngle();
    }

    public final float getProFromDegree(float f) {
        return (f - getMinDegree(true)) / (getMaxDegree(true) - getMinDegree(true));
    }

    public final void init(Context context) {
        this.f3473 = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = this.f3470;
        if (matrix == null) {
            this.f3470 = new Matrix();
        } else {
            matrix.reset();
        }
        setOnTouchListener(new ViewOnTouchListenerC1253(this, null));
    }

    public void onAnimEnd() {
        ABPointMessage aBPointMessage = this.f3481;
        if (aBPointMessage != null) {
            float fMin = Math.min(Math.max(aBPointMessage.getEndFocusP(), getMinDegree(false)), getMaxDegree(false));
            int i = this.f3480;
            if (i == 1) {
                fMin = getMaxDegree(false);
                rotateWheel2(getMaxDegree(false));
            } else if (i == 2) {
                fMin = getMinDegree(false);
                rotateWheel2(getMinDegree(false));
            }
            this.f3480 = 0;
            InterfaceC1252 interfaceC1252 = this.f3499;
            if (interfaceC1252 != null) {
                interfaceC1252.onAnimChange(false);
            }
            this.f3500.post(new RunnableC1244(fMin));
            this.f3481 = null;
        }
    }

    public void onAnimValueChange(float f) {
        rotateWheel2(f);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f3471 == 0 || this.f3472 == 0) {
            this.f3471 = (i2 - getPaddingTop()) - getPaddingBottom();
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            this.f3472 = paddingLeft;
            this.f3469 = BITMAP_RESIZER(this.f3468, paddingLeft, this.f3471);
            this.f3470.postTranslate((this.f3472 / 2) - (r1.getWidth() / 2), (this.f3471 / 2) - (this.f3469.getHeight() / 2));
            if (this.f3484) {
                this.f3470.postRotate(-this.f3483, this.f3472 / 2, this.f3471 / 2);
                this.f3484 = false;
            }
            setImageBitmap(this.f3469);
            setImageMatrix(this.f3470);
        }
    }

    public void rotateWheel(float f) {
        this.f3470.postRotate(f, this.f3472 / 2, this.f3471 / 2);
        float matrixAngle = getMatrixAngle();
        if (matrixAngle > getMaxDegree(false)) {
            matrixAngle = getMaxDegree(false);
            this.f3470.reset();
            this.f3470.postRotate(-matrixAngle, this.f3472 / 2, this.f3471 / 2);
        } else if (matrixAngle < getMinDegree(false)) {
            matrixAngle = getMinDegree(false);
            this.f3470.reset();
            this.f3470.postRotate(-matrixAngle, this.f3472 / 2, this.f3471 / 2);
        } else if (this.f3478 && matrixAngle >= -1.0f && matrixAngle <= 1.0f && matrixAngle != 0.0f) {
            if (this.f3475 < 10) {
                this.f3470.reset();
                this.f3470.postRotate(-0.0f, this.f3472 / 2, this.f3471 / 2);
                this.f3475++;
                matrixAngle = 0.0f;
            } else {
                this.f3475 = 0;
            }
        }
        float f2 = this.f3483;
        if (matrixAngle != f2) {
            this.f3483 = matrixAngle;
            if (matrixAngle <= getMaxDegree(true) && this.f3483 >= getMinDegree(true)) {
                InterfaceC1251 interfaceC1251 = this.f3497;
                if (interfaceC1251 != null) {
                    interfaceC1251.onChange(getProFromDegree(matrixAngle));
                }
                setImageMatrix(this.f3470);
                return;
            }
            float fM12736 = C3947.m12727().m12736();
            float fixDegreeForAuto2 = getFixDegreeForAuto2(f2, matrixAngle, fM12736 > 1.0f ? getMaxDegree(true) : fM12736 < 0.0f ? getMinDegree(true) : (fM12736 < 0.0f || fM12736 >= 0.1f) ? getMaxDegree(false) : getMinDegree(false));
            this.f3483 = fixDegreeForAuto2;
            InterfaceC1250 interfaceC1250 = this.f3498;
            if (interfaceC1250 != null) {
                interfaceC1250.mo3282();
            }
            if (this.f3497 != null) {
                if (Math.abs(fixDegreeForAuto2 - getMinDegree(true)) <= 0.1f || Math.abs(fixDegreeForAuto2 - getMinDegree(false)) <= 0.1f || Math.abs(fixDegreeForAuto2 - getMaxDegree(true)) <= 0.1f || Math.abs(fixDegreeForAuto2 - getMaxDegree(false)) <= 0.1f) {
                    float fRound = Math.round(fixDegreeForAuto2);
                    this.f3477 = 0.0f;
                    cancelFixMove();
                    doFixAutoAnim(f2, fRound, 100);
                    return;
                }
            }
            this.f3470.reset();
            this.f3470.postRotate(-fixDegreeForAuto2, this.f3472 / 2, this.f3471 / 2);
            setImageMatrix(this.f3470);
        }
    }

    public final void rotateWheel2(float f) {
        float fMin = Math.min(Math.max(f, getMinDegree(false)), getMaxDegree(false));
        this.f3470.reset();
        this.f3470.postRotate(-fMin, this.f3472 / 2, this.f3471 / 2);
        if (fMin != this.f3483) {
            this.f3483 = fMin;
            setImageMatrix(this.f3470);
        }
    }

    public final void rotateWheel3(float f) {
        float fMin = Math.min(Math.max(f, getMinDegree(false)), getMaxDegree(false));
        this.f3470.reset();
        this.f3470.postRotate(-fMin, this.f3472 / 2, this.f3471 / 2);
        if (fMin != this.f3483) {
            this.f3483 = fMin;
            setImageMatrix(this.f3470);
        }
    }

    public void setDegrees(float f, float f2) {
        this.f3485 = f;
        this.f3486 = f2;
        this.f3487 = 0.0f;
    }

    public void setExposure(boolean z) {
        this.f3478 = z;
    }

    public void setHandler(WeakHandler weakHandler) {
        this.f3500 = weakHandler;
    }

    public void setOnProChange(InterfaceC1251 interfaceC1251) {
        this.f3497 = interfaceC1251;
    }

    public void setOnTouchStateChange(InterfaceC1252 interfaceC1252) {
        this.f3499 = interfaceC1252;
    }

    public void setPro(float f) {
        this.f3483 = getDegreeFromPercent(f);
        if (this.f3472 == 0 || this.f3471 == 0) {
            this.f3484 = true;
            return;
        }
        this.f3470.reset();
        this.f3470.postRotate(-this.f3483, this.f3472 / 2, this.f3471 / 2);
        setImageMatrix(this.f3470);
    }

    public void setRightView(boolean z) {
        this.f3479 = z;
    }

    public void setWheelImage(int i) {
        this.f3468 = BitmapFactory.decodeResource(this.f3473.getResources(), i);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m3482() {
        fixActionUpForAuto();
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m3483(float f, float f2, InterfaceC1249 interfaceC1249) {
        if (!this.f3496) {
            rotateWheel(-f);
        } else {
            if (interfaceC1249 == null || Math.abs(this.f3483 - f2) > this.f3487 / 2.0f) {
                return;
            }
            interfaceC1249.mo3281();
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m3484(int i, FocusZoomWheelView.InterfaceC1175 interfaceC1175) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getMatrixAngle(), i == 1 ? getMaxDegree(false) : i == 2 ? getMaxDegree(true) : i == 3 ? getMinDegree(true) : getMinDegree(false));
        this.f3495 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.f3495.addUpdateListener(new C1247());
        this.f3495.setInterpolator(C4008.m12881());
        this.f3495.addListener(new C1248(interfaceC1175));
        this.f3495.start();
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public WheelProgressView m3485(InterfaceC1250 interfaceC1250) {
        this.f3498 = interfaceC1250;
        return this;
    }

    public void setWheelImage(Bitmap bitmap) {
        this.f3468 = bitmap;
    }

    public void setDegrees(float f, float f2, float f3) {
        this.f3485 = f;
        this.f3486 = f2;
        this.f3487 = f3;
        this.f3488 = f3 != 0.0f;
    }
}
