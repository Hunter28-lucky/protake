package com.blink.academy.film.widgets.wheel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.blink.academy.film.R$styleable;
import defpackage.C2579;
import defpackage.C3484;
import defpackage.C4285;
import defpackage.C4464;
import defpackage.HandlerC5310;
import defpackage.InterfaceC3488;
import defpackage.InterfaceC3511;
import defpackage.a8;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class WheelView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public DividerType f4879;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Context f4880;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Handler f4881;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public GestureDetector f4882;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC3488 f4883;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f4884;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f4885;

    /* renamed from: ֏, reason: contains not printable characters */
    public ScheduledExecutorService f4886;

    /* renamed from: ׯ, reason: contains not printable characters */
    public ScheduledFuture<?> f4887;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Paint f4888;

    /* renamed from: ހ, reason: contains not printable characters */
    public Paint f4889;

    /* renamed from: ށ, reason: contains not printable characters */
    public Paint f4890;

    /* renamed from: ނ, reason: contains not printable characters */
    public a8 f4891;

    /* renamed from: ރ, reason: contains not printable characters */
    public String f4892;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f4893;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f4894;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f4895;

    /* renamed from: އ, reason: contains not printable characters */
    public int f4896;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f4897;

    /* renamed from: މ, reason: contains not printable characters */
    public Typeface f4898;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f4899;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f4900;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f4901;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f4902;

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean f4903;

    /* renamed from: ޏ, reason: contains not printable characters */
    public float f4904;

    /* renamed from: ސ, reason: contains not printable characters */
    public float f4905;

    /* renamed from: ޑ, reason: contains not printable characters */
    public float f4906;

    /* renamed from: ޒ, reason: contains not printable characters */
    public float f4907;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f4908;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f4909;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f4910;

    /* renamed from: ޖ, reason: contains not printable characters */
    public int f4911;

    /* renamed from: ޗ, reason: contains not printable characters */
    public int f4912;

    /* renamed from: ޘ, reason: contains not printable characters */
    public int f4913;

    /* renamed from: ޙ, reason: contains not printable characters */
    public int f4914;

    /* renamed from: ޚ, reason: contains not printable characters */
    public int f4915;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f4916;

    /* renamed from: ޜ, reason: contains not printable characters */
    public float f4917;

    /* renamed from: ޝ, reason: contains not printable characters */
    public long f4918;

    /* renamed from: ޞ, reason: contains not printable characters */
    public int f4919;

    /* renamed from: ޟ, reason: contains not printable characters */
    public int f4920;

    /* renamed from: ޠ, reason: contains not printable characters */
    public int f4921;

    /* renamed from: ޡ, reason: contains not printable characters */
    public int f4922;

    /* renamed from: ޢ, reason: contains not printable characters */
    public float f4923;

    /* renamed from: ޣ, reason: contains not printable characters */
    public final float f4924;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum DividerType {
        FILL,
        WRAP
    }

    /* renamed from: com.blink.academy.film.widgets.wheel.view.WheelView$Ϳ, reason: contains not printable characters */
    public class RunnableC1782 implements Runnable {
        public RunnableC1782() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelView.this.f4883.mo158(WheelView.this.getCurrentItem());
        }
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public final a8 getAdapter() {
        return this.f4891;
    }

    public final int getCurrentItem() {
        if (this.f4891 == null) {
            return 0;
        }
        return Math.max(0, Math.min(this.f4909, r0.mo15() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f4881;
    }

    public int getInitPosition() {
        return this.f4908;
    }

    public float getItemHeight() {
        return this.f4897;
    }

    public int getItemsCount() {
        a8 a8Var = this.f4891;
        if (a8Var != null) {
            return a8Var.mo15();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.f4907;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        boolean z2;
        String strM4715;
        if (this.f4891 == null) {
            return;
        }
        boolean z3 = false;
        int iMin = Math.min(Math.max(0, this.f4908), this.f4891.mo15() - 1);
        this.f4908 = iMin;
        Object[] objArr = new Object[this.f4912];
        int i = (int) (this.f4907 / this.f4897);
        this.f4911 = i;
        try {
            this.f4910 = iMin + (i % this.f4891.mo15());
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (this.f4903) {
            if (this.f4910 < 0) {
                this.f4910 = this.f4891.mo15() + this.f4910;
            }
            if (this.f4910 > this.f4891.mo15() - 1) {
                this.f4910 -= this.f4891.mo15();
            }
        } else {
            if (this.f4910 < 0) {
                this.f4910 = 0;
            }
            if (this.f4910 > this.f4891.mo15() - 1) {
                this.f4910 = this.f4891.mo15() - 1;
            }
        }
        float f = this.f4907 % this.f4897;
        int i2 = 0;
        while (true) {
            int i3 = this.f4912;
            if (i2 >= i3) {
                break;
            }
            int i4 = this.f4910 - ((i3 / 2) - i2);
            if (this.f4903) {
                objArr[i2] = this.f4891.getItem(m4716(i4));
            } else if (i4 < 0) {
                objArr[i2] = "";
            } else if (i4 > this.f4891.mo15() - 1) {
                objArr[i2] = "";
            } else {
                objArr[i2] = this.f4891.getItem(i4);
            }
            i2++;
        }
        boolean z4 = false;
        if (this.f4879 == DividerType.WRAP) {
            float f2 = (TextUtils.isEmpty(this.f4892) ? (this.f4914 - this.f4894) / 2 : (this.f4914 - this.f4894) / 4) - 12;
            if (f2 <= 0.0f) {
                f2 = 10.0f;
            }
            float f3 = f2;
            float f4 = this.f4914 - f3;
            float f5 = this.f4904;
            canvas.drawLine(f3, f5, f4, f5, this.f4890);
            float f6 = this.f4905;
            canvas.drawLine(f3, f6, f4, f6, this.f4890);
        } else {
            float f7 = this.f4904;
            canvas.drawLine(0.0f, f7, this.f4914, f7, this.f4890);
            float f8 = this.f4905;
            canvas.drawLine(0.0f, f8, this.f4914, f8, this.f4890);
        }
        if (!TextUtils.isEmpty(this.f4892) && this.f4885) {
            canvas.drawText(this.f4892, (this.f4914 - m4717(this.f4889, this.f4892)) - this.f4923, this.f4906, this.f4889);
        }
        int i5 = 0;
        while (i5 < this.f4912) {
            canvas.save();
            double d = ((this.f4897 * i5) - f) / this.f4915;
            float f9 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f9 >= 90.0f || f9 <= -90.0f) {
                z = z4;
                z2 = z3;
                canvas.restore();
            } else {
                float fPow = (float) Math.pow(Math.abs(f9) / 90.0f, 2.2d);
                if (this.f4885 || TextUtils.isEmpty(this.f4892) || TextUtils.isEmpty(m4715(objArr[i5]))) {
                    strM4715 = m4715(objArr[i5]);
                } else {
                    strM4715 = m4715(objArr[i5]) + this.f4892;
                }
                m4727(strM4715);
                m4724(strM4715);
                m4725(strM4715);
                float fCos = (float) ((this.f4915 - (Math.cos(d) * this.f4915)) - ((Math.sin(d) * this.f4895) / 2.0d));
                canvas.translate(0.0f, fCos);
                float f10 = this.f4904;
                if (fCos > f10 || this.f4895 + fCos < f10) {
                    float f11 = this.f4905;
                    if (fCos > f11 || this.f4895 + fCos < f11) {
                        if (fCos >= f10) {
                            int i6 = this.f4895;
                            if (i6 + fCos <= f11) {
                                canvas.clipRect(0, 0, this.f4914, i6);
                                canvas.drawText(strM4715, this.f4921, this.f4895 - this.f4923, this.f4889);
                                this.f4909 = this.f4910 - ((this.f4912 / 2) - i5);
                            }
                        }
                        canvas.save();
                        z2 = false;
                        canvas.clipRect(0, 0, this.f4914, (int) this.f4897);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.f4888;
                        int i7 = this.f4896;
                        z = false;
                        paint.setTextSkewX((i7 == 0 ? 0 : i7 > 0 ? 1 : -1) * (f9 <= 0.0f ? 1 : -1) * 0.5f * fPow);
                        this.f4888.setAlpha((int) ((1.0f - fPow) * 255.0f));
                        canvas.drawText(strM4715, this.f4922 + (this.f4896 * fPow), this.f4895, this.f4888);
                        canvas.restore();
                        canvas.restore();
                        this.f4889.setTextSize(this.f4893);
                    } else {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.f4914, this.f4905 - fCos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(strM4715, this.f4921, this.f4895 - this.f4923, this.f4889);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.f4905 - fCos, this.f4914, (int) this.f4897);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(strM4715, this.f4922, this.f4895, this.f4888);
                        canvas.restore();
                    }
                } else {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.f4914, this.f4904 - fCos);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                    canvas.drawText(strM4715, this.f4922, this.f4895, this.f4888);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.f4904 - fCos, this.f4914, (int) this.f4897);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(strM4715, this.f4921, this.f4895 - this.f4923, this.f4889);
                    canvas.restore();
                }
                z = false;
                z2 = false;
                canvas.restore();
                this.f4889.setTextSize(this.f4893);
            }
            i5++;
            z3 = z2;
            z4 = z;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.f4919 = i;
        m4728();
        setMeasuredDimension(this.f4914, this.f4913);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.f4882.onTouchEvent(motionEvent);
        float f = (-this.f4908) * this.f4897;
        float fMo15 = ((this.f4891.mo15() - 1) - this.f4908) * this.f4897;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.f4918 = System.currentTimeMillis();
            m4714();
            this.f4917 = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.f4917 - motionEvent.getRawY();
            this.f4917 = motionEvent.getRawY();
            float f2 = this.f4907 + rawY;
            this.f4907 = f2;
            if (!this.f4903) {
                float f3 = this.f4897;
                if ((f2 - (f3 * 0.25f) < f && rawY < 0.0f) || ((f3 * 0.25f) + f2 > fMo15 && rawY > 0.0f)) {
                    this.f4907 = f2 - rawY;
                    z = true;
                }
            }
        } else if (!zOnTouchEvent) {
            float y = motionEvent.getY();
            int i = this.f4915;
            double dAcos = Math.acos((i - y) / i) * this.f4915;
            float f4 = this.f4897;
            this.f4916 = (int) (((((int) ((dAcos + (f4 / 2.0f)) / f4)) - (this.f4912 / 2)) * f4) - (((this.f4907 % f4) + f4) % f4));
            if (System.currentTimeMillis() - this.f4918 > 120) {
                m4730(ACTION.DAGGLE);
            } else {
                m4730(ACTION.CLICK);
            }
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void setAdapter(a8 a8Var) {
        this.f4891 = a8Var;
        m4728();
        invalidate();
    }

    public final void setCurrentItem(int i) {
        this.f4909 = i;
        this.f4908 = i;
        this.f4907 = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.f4903 = z;
    }

    public void setDividerColor(int i) {
        this.f4901 = i;
        this.f4890.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.f4879 = dividerType;
    }

    public void setGravity(int i) {
        this.f4920 = i;
    }

    public void setIsOptions(boolean z) {
        this.f4884 = z;
    }

    public void setLabel(String str) {
        this.f4892 = str;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.f4902 = f;
            m4722();
        }
    }

    public final void setOnItemSelectedListener(InterfaceC3488 interfaceC3488) {
        this.f4883 = interfaceC3488;
    }

    public void setTextColorCenter(int i) {
        if (i != 0) {
            this.f4900 = i;
            this.f4889.setColor(i);
        }
    }

    public void setTextColorOut(int i) {
        if (i != 0) {
            this.f4899 = i;
            this.f4888.setColor(i);
        }
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int iM9438 = C2579.m9438(f);
            this.f4893 = iM9438;
            this.f4888.setTextSize(iM9438);
            this.f4889.setTextSize(this.f4893);
        }
    }

    public void setTextXOffset(int i) {
        this.f4896 = i;
        if (i != 0) {
            this.f4889.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f) {
        this.f4907 = f;
    }

    public final void setTypeface(Typeface typeface) {
        this.f4898 = typeface;
        this.f4888.setTypeface(typeface);
        this.f4889.setTypeface(this.f4898);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4714() {
        ScheduledFuture<?> scheduledFuture = this.f4887;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f4887.cancel(true);
        this.f4887 = null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m4715(Object obj) {
        return obj == null ? "" : obj instanceof InterfaceC3511 ? ((InterfaceC3511) obj).mo463() : obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m4716(int i) {
        return i < 0 ? m4716(i + this.f4891.mo15()) : i > this.f4891.mo15() + (-1) ? m4716(i - this.f4891.mo15()) : i;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m4717(Paint paint, String str) {
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

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4718(Context context) {
        this.f4880 = context;
        this.f4881 = new HandlerC5310(this);
        GestureDetector gestureDetector = new GestureDetector(context, new C4285(this));
        this.f4882 = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f4903 = true;
        this.f4907 = 0.0f;
        this.f4908 = -1;
        m4719();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4719() {
        Paint paint = new Paint();
        this.f4888 = paint;
        paint.setColor(this.f4899);
        this.f4888.setAntiAlias(true);
        this.f4888.setTypeface(this.f4898);
        this.f4888.setTextSize(this.f4893);
        Paint paint2 = new Paint();
        this.f4889 = paint2;
        paint2.setColor(this.f4900);
        this.f4889.setAntiAlias(true);
        this.f4889.setTextScaleX(1.1f);
        this.f4889.setTypeface(this.f4898);
        this.f4889.setTextSize(this.f4893);
        Paint paint3 = new Paint();
        this.f4890 = paint3;
        paint3.setColor(this.f4901);
        this.f4890.setAntiAlias(true);
        setLayerType(1, null);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m4720(boolean z) {
        this.f4885 = z;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean m4721() {
        return this.f4903;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m4722() {
        float f = this.f4902;
        if (f < 1.0f) {
            this.f4902 = 1.0f;
        } else if (f > 4.0f) {
            this.f4902 = 4.0f;
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m4723() {
        Rect rect = new Rect();
        for (int i = 0; i < this.f4891.mo15(); i++) {
            String strM4715 = m4715(this.f4891.getItem(i));
            this.f4889.getTextBounds(strM4715, 0, strM4715.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.f4894) {
                this.f4894 = iWidth;
            }
            this.f4889.getTextBounds("星期", 0, 2, rect);
            this.f4895 = rect.height() + 2;
        }
        this.f4897 = this.f4902 * this.f4895;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m4724(String str) {
        String str2;
        Rect rect = new Rect();
        this.f4889.getTextBounds(str, 0, str.length(), rect);
        int i = this.f4920;
        if (i == 3) {
            this.f4921 = 0;
            return;
        }
        if (i == 5) {
            this.f4921 = (this.f4914 - rect.width()) - ((int) this.f4923);
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.f4884 || (str2 = this.f4892) == null || str2.equals("") || !this.f4885) {
            this.f4921 = (int) ((this.f4914 - rect.width()) * 0.5d);
        } else {
            this.f4921 = (int) ((this.f4914 - rect.width()) * 0.25d);
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m4725(String str) {
        String str2;
        Rect rect = new Rect();
        this.f4888.getTextBounds(str, 0, str.length(), rect);
        int i = this.f4920;
        if (i == 3) {
            this.f4922 = 0;
            return;
        }
        if (i == 5) {
            this.f4922 = (this.f4914 - rect.width()) - ((int) this.f4923);
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.f4884 || (str2 = this.f4892) == null || str2.equals("") || !this.f4885) {
            this.f4922 = (int) ((this.f4914 - rect.width()) * 0.5d);
        } else {
            this.f4922 = (int) ((this.f4914 - rect.width()) * 0.25d);
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m4726() {
        if (this.f4883 != null) {
            postDelayed(new RunnableC1782(), 200L);
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m4727(String str) {
        Rect rect = new Rect();
        this.f4889.getTextBounds(str, 0, str.length(), rect);
        int i = this.f4893;
        for (int iWidth = rect.width(); iWidth > this.f4914; iWidth = rect.width()) {
            i--;
            this.f4889.setTextSize(i);
            this.f4889.getTextBounds(str, 0, str.length(), rect);
        }
        this.f4888.setTextSize(i);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m4728() {
        if (this.f4891 == null) {
            return;
        }
        m4723();
        int i = (int) (this.f4897 * (this.f4912 - 1));
        this.f4913 = (int) ((i * 2) / 3.141592653589793d);
        this.f4915 = (int) (i / 3.141592653589793d);
        this.f4914 = View.MeasureSpec.getSize(this.f4919);
        int i2 = this.f4913;
        float f = this.f4897;
        this.f4904 = (i2 - f) / 2.0f;
        float f2 = (i2 + f) / 2.0f;
        this.f4905 = f2;
        this.f4906 = (f2 - ((f - this.f4895) / 2.0f)) - this.f4923;
        if (this.f4908 == -1) {
            if (this.f4903) {
                this.f4908 = (this.f4891.mo15() + 1) / 2;
            } else {
                this.f4908 = 0;
            }
        }
        this.f4910 = this.f4908;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m4729(float f) {
        m4714();
        this.f4887 = this.f4886.scheduleWithFixedDelay(new C3484(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m4730(ACTION action) {
        m4714();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.f4907;
            float f2 = this.f4897;
            int i = (int) (((f % f2) + f2) % f2);
            this.f4916 = i;
            if (i > f2 / 2.0f) {
                this.f4916 = (int) (f2 - i);
            } else {
                this.f4916 = -i;
            }
        }
        this.f4887 = this.f4886.scheduleWithFixedDelay(new C4464(this, this.f4916), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4884 = false;
        this.f4885 = true;
        this.f4886 = Executors.newSingleThreadScheduledExecutor();
        this.f4898 = Typeface.MONOSPACE;
        this.f4902 = 1.6f;
        this.f4912 = 11;
        this.f4916 = 0;
        this.f4917 = 0.0f;
        this.f4918 = 0L;
        this.f4920 = 17;
        this.f4921 = 0;
        this.f4922 = 0;
        this.f4924 = 0.5f;
        this.f4893 = C2579.m9438(15.0f);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.f4923 = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.f4923 = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.f4923 = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.f4923 = 6.0f;
        } else if (f >= 3.0f) {
            this.f4923 = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.pickerview, 0, 0);
            this.f4920 = typedArrayObtainStyledAttributes.getInt(1, 17);
            this.f4899 = typedArrayObtainStyledAttributes.getColor(4, -5723992);
            this.f4900 = typedArrayObtainStyledAttributes.getColor(3, -14013910);
            this.f4901 = typedArrayObtainStyledAttributes.getColor(0, -2763307);
            this.f4893 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, this.f4893);
            this.f4902 = typedArrayObtainStyledAttributes.getFloat(2, this.f4902);
            typedArrayObtainStyledAttributes.recycle();
        }
        m4722();
        m4718(context);
    }
}
