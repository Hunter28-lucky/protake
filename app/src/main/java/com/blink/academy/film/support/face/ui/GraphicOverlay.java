package com.blink.academy.film.support.face.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import defpackage.C4638;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class GraphicOverlay extends View {

    /* renamed from: ނ, reason: contains not printable characters */
    public static final String f1555 = GraphicOverlay.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f1556;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Object f1557;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final List<AbstractC0788> f1558;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Matrix f1559;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f1560;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f1561;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f1562;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f1563;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f1564;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f1565;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f1566;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f1567;

    /* renamed from: com.blink.academy.film.support.face.ui.GraphicOverlay$Ϳ, reason: contains not printable characters */
    public static abstract class AbstractC0788 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public GraphicOverlay f1568;

        public AbstractC0788(GraphicOverlay graphicOverlay) {
            this.f1568 = graphicOverlay;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public abstract void mo1897(Canvas canvas);

        /* renamed from: Ԩ, reason: contains not printable characters */
        public float m1898(float f) {
            return f * this.f1568.f1562;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public float m1899(float f) {
            return this.f1568.f1565 ? this.f1568.getWidth() - (m1898(f) - this.f1568.f1563) : m1898(f) - this.f1568.f1563;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float m1900(float f) {
            return m1898(f) - this.f1568.f1564;
        }
    }

    public GraphicOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1556 = false;
        this.f1557 = new Object();
        this.f1558 = new ArrayList();
        this.f1559 = new Matrix();
        this.f1562 = 1.0f;
        this.f1566 = true;
        this.f1567 = false;
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ब
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f14215.m1891(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Ԯ, reason: contains not printable characters */
    public /* synthetic */ void m1891(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1566 = true;
    }

    public int getImageHeight() {
        return this.f1561;
    }

    public int getImageWidth() {
        return this.f1560;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1567) {
            synchronized (this.f1557) {
                m1896();
                Iterator<AbstractC0788> it = this.f1558.iterator();
                while (it.hasNext()) {
                    it.next().mo1897(canvas);
                }
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m1892(AbstractC0788 abstractC0788) {
        synchronized (this.f1557) {
            this.f1558.add(abstractC0788);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m1893() {
        synchronized (this.f1557) {
            this.f1558.clear();
        }
        postInvalidate();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public GraphicOverlay m1894(boolean z) {
        this.f1567 = z;
        return this;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m1895(int i, int i2, boolean z) {
        synchronized (this.f1557) {
            this.f1560 = i;
            this.f1561 = i2;
            this.f1565 = z;
            this.f1566 = true;
        }
        postInvalidate();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m1896() {
        if (!this.f1566 || this.f1560 <= 0 || this.f1561 <= 0) {
            return;
        }
        float width = getWidth() / getHeight();
        float f = this.f1560 / this.f1561;
        this.f1563 = 0.0f;
        this.f1564 = 0.0f;
        if (width > f) {
            this.f1562 = getWidth() / this.f1560;
            this.f1564 = ((getWidth() / f) - getHeight()) / 2.0f;
        } else {
            this.f1562 = getHeight() / this.f1561;
            this.f1563 = ((getHeight() * f) - getWidth()) / 2.0f;
        }
        if (this.f1556) {
            String str = f1555;
            C4638.m14099(str, String.format("view width : %s , height : %s ", Integer.valueOf(getWidth()), Integer.valueOf(getHeight())));
            C4638.m14099(str, String.format("image width : %s , height : %s ", Integer.valueOf(this.f1560), Integer.valueOf(this.f1561)));
            C4638.m14099(str, String.format("scaleFactor : %s  postScaleWidthOffset : %s , postScaleHeightOffset : %s ", Float.valueOf(this.f1562), Float.valueOf(this.f1563), Float.valueOf(this.f1564)));
        }
        this.f1559.reset();
        Matrix matrix = this.f1559;
        float f2 = this.f1562;
        matrix.setScale(f2, f2);
        this.f1559.postTranslate(-this.f1563, -this.f1564);
        if (this.f1565) {
            this.f1559.postScale(-1.0f, 1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        }
        this.f1566 = false;
    }
}
