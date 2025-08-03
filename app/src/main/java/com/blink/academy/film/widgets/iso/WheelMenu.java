package com.blink.academy.film.widgets.iso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class WheelMenu extends ImageView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Bitmap f3452;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Bitmap f3453;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Matrix f3454;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3455;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3456;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3457;

    /* renamed from: ֈ, reason: contains not printable characters */
    public double f3458;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f3459;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f3460;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f3461;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f3462;

    /* renamed from: ށ, reason: contains not printable characters */
    public Context f3463;

    /* renamed from: ނ, reason: contains not printable characters */
    public InterfaceC1238 f3464;

    /* renamed from: com.blink.academy.film.widgets.iso.WheelMenu$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1238 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m3462(int i);
    }

    /* renamed from: com.blink.academy.film.widgets.iso.WheelMenu$Ԫ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1239 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public double f3465;

        public ViewOnTouchListenerC1239() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f3465 = WheelMenu.this.m3459(motionEvent.getX(), motionEvent.getY());
            } else if (action == 1) {
                WheelMenu.this.f3458 %= 360.0d;
                if (WheelMenu.this.f3458 < 0.0d) {
                    WheelMenu.this.f3458 += 360.0d;
                }
                int i = (int) (WheelMenu.this.f3458 / WheelMenu.this.f3460);
                WheelMenu wheelMenu = WheelMenu.this;
                wheelMenu.f3457 = ((wheelMenu.f3459 + WheelMenu.this.f3457) - i) % WheelMenu.this.f3459;
                WheelMenu.this.f3458 %= WheelMenu.this.f3460;
                if (WheelMenu.this.f3462) {
                    WheelMenu.this.m3461((float) ((WheelMenu.this.f3460 / 2) - WheelMenu.this.f3458));
                    WheelMenu.this.f3458 = r7.f3460 / 2;
                }
                if (WheelMenu.this.f3457 == 0) {
                    WheelMenu wheelMenu2 = WheelMenu.this;
                    wheelMenu2.f3461 = wheelMenu2.f3459 - 1;
                } else {
                    WheelMenu wheelMenu3 = WheelMenu.this;
                    wheelMenu3.f3461 = wheelMenu3.f3457 - 1;
                }
                if (WheelMenu.this.f3464 != null) {
                    WheelMenu.this.f3464.m3462(WheelMenu.this.f3461);
                }
            } else if (action == 2) {
                double dM3459 = WheelMenu.this.m3459(motionEvent.getX(), motionEvent.getY());
                WheelMenu.this.m3461((float) (this.f3465 - dM3459));
                this.f3465 = dM3459;
            }
            return true;
        }
    }

    public WheelMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3462 = true;
        m3460(context);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static int m3458(double d, double d2) {
        return d >= 0.0d ? d2 >= 0.0d ? 1 : 4 : d2 >= 0.0d ? 2 : 3;
    }

    public int getSelectedPosition() {
        return this.f3461;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f3455 == 0 || this.f3456 == 0) {
            this.f3455 = i2;
            this.f3456 = i;
            Matrix matrix = new Matrix();
            matrix.postScale(Math.min(this.f3456, this.f3455) / this.f3452.getWidth(), Math.min(this.f3456, this.f3455) / this.f3452.getHeight());
            Bitmap bitmap = this.f3452;
            this.f3453 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f3452.getHeight(), matrix, false);
            this.f3454.postTranslate((this.f3456 / 2) - (r8.getWidth() / 2), (this.f3455 / 2) - (this.f3453.getHeight() / 2));
            setImageBitmap(this.f3453);
            setImageMatrix(this.f3454);
        }
    }

    public void setAlternateTopDiv(int i) {
        if (i < 0 || i >= this.f3459) {
            return;
        }
        this.f3457 = i;
        this.f3461 = i;
    }

    public void setDivCount(int i) {
        this.f3459 = i;
        this.f3460 = 360 / i;
        this.f3458 = (r0 / 2) * (-1);
    }

    public void setSnapToCenterFlag(boolean z) {
        this.f3462 = z;
    }

    public void setWheelChangeListener(InterfaceC1238 interfaceC1238) {
        this.f3464 = interfaceC1238;
    }

    public void setWheelImage(int i) {
        this.f3452 = BitmapFactory.decodeResource(this.f3463.getResources(), i);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final double m3459(double d, double d2) {
        double d3 = d - (this.f3456 / 2.0d);
        int i = this.f3455;
        double d4 = (i - d2) - (i / 2.0d);
        int iM3458 = m3458(d3, d4);
        if (iM3458 == 1) {
            return (Math.asin(d4 / Math.hypot(d3, d4)) * 180.0d) / 3.141592653589793d;
        }
        if (iM3458 == 2) {
            return 180.0d - ((Math.asin(d4 / Math.hypot(d3, d4)) * 180.0d) / 3.141592653589793d);
        }
        if (iM3458 == 3) {
            return (((Math.asin(d4 / Math.hypot(d3, d4)) * (-1.0d)) * 180.0d) / 3.141592653589793d) + 180.0d;
        }
        if (iM3458 != 4) {
            return 0.0d;
        }
        return ((Math.asin(d4 / Math.hypot(d3, d4)) * 180.0d) / 3.141592653589793d) + 360.0d;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m3460(Context context) {
        this.f3463 = context;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f3461 = 0;
        Matrix matrix = this.f3454;
        if (matrix == null) {
            this.f3454 = new Matrix();
        } else {
            matrix.reset();
        }
        setOnTouchListener(new ViewOnTouchListenerC1239());
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m3461(float f) {
        this.f3454.postRotate(f, this.f3456 / 2, this.f3455 / 2);
        setImageMatrix(this.f3454);
        this.f3458 += f;
    }
}
