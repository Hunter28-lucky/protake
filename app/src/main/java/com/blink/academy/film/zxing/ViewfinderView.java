package com.blink.academy.film.zxing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.R$styleable;
import com.blink.academy.protake.R;
import com.google.zxing.ResultPoint;
import defpackage.C4091;
import defpackage.C4792;
import defpackage.C5152;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ViewfinderView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public C4091 f4977;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Bitmap f4978;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<ResultPoint> f4979;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public List<ResultPoint> f4980;

    /* renamed from: ԯ, reason: contains not printable characters */
    public TextPaint f4981;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f4982;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f4983;

    /* renamed from: ֏, reason: contains not printable characters */
    public Rect f4984;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f4985;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f4986;

    /* renamed from: ހ, reason: contains not printable characters */
    public Paint f4987;

    /* renamed from: ށ, reason: contains not printable characters */
    public TextPaint f4988;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f4989;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f4990;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f4991;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f4992;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f4993;

    /* renamed from: އ, reason: contains not printable characters */
    public int f4994;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f4995;

    /* renamed from: މ, reason: contains not printable characters */
    public int f4996;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f4997;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f4998;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f4999;

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean f5000;

    /* renamed from: ގ, reason: contains not printable characters */
    public Drawable f5001;

    /* renamed from: ޏ, reason: contains not printable characters */
    public Bitmap f5002;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f5003;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f5004;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f5005;

    /* renamed from: ޓ, reason: contains not printable characters */
    public float f5006;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f5007;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f5008;

    /* renamed from: ޖ, reason: contains not printable characters */
    public boolean f5009;

    /* renamed from: ޗ, reason: contains not printable characters */
    public String f5010;

    /* renamed from: ޘ, reason: contains not printable characters */
    public String f5011;

    /* renamed from: ޙ, reason: contains not printable characters */
    public String f5012;

    /* renamed from: ޚ, reason: contains not printable characters */
    public int f5013;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f5014;

    /* renamed from: ޜ, reason: contains not printable characters */
    public boolean f5015;

    /* renamed from: ޝ, reason: contains not printable characters */
    public int f5016;

    /* renamed from: ޞ, reason: contains not printable characters */
    public boolean f5017;

    /* renamed from: ޟ, reason: contains not printable characters */
    public int f5018;

    /* renamed from: ޠ, reason: contains not printable characters */
    public boolean f5019;

    /* renamed from: ޡ, reason: contains not printable characters */
    public boolean f5020;

    /* renamed from: ޢ, reason: contains not printable characters */
    public boolean f5021;

    /* renamed from: ޣ, reason: contains not printable characters */
    public Drawable f5022;

    /* renamed from: ޤ, reason: contains not printable characters */
    public Bitmap f5023;

    /* renamed from: ޥ, reason: contains not printable characters */
    public float f5024;

    /* renamed from: ޱ, reason: contains not printable characters */
    public float f5025;

    /* renamed from: ߾, reason: contains not printable characters */
    public Bitmap f5026;

    /* renamed from: ߿, reason: contains not printable characters */
    public Bitmap f5027;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public Bitmap f5028;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public Bitmap f5029;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public float f5030;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public StaticLayout f5031;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public int f5032;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public boolean f5033;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public boolean f5034;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public boolean f5035;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getAnimTime() {
        return this.f5005;
    }

    public String getBarCodeTipText() {
        return this.f5011;
    }

    public int getBarcodeRectHeight() {
        return this.f4995;
    }

    public int getBorderColor() {
        return this.f5004;
    }

    public int getBorderSize() {
        return this.f5003;
    }

    public int getCornerColor() {
        return this.f4990;
    }

    public int getCornerLength() {
        return this.f4991;
    }

    public int getCornerSize() {
        return this.f4992;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.f5001;
    }

    public float getHalfCornerSize() {
        return this.f5030;
    }

    public boolean getIsBarcode() {
        return this.f5009;
    }

    public int getMaskColor() {
        return this.f4989;
    }

    public String getQRCodeTipText() {
        return this.f5010;
    }

    public int getRectHeight() {
        return this.f4994;
    }

    public int getRectWidth() {
        return this.f4993;
    }

    public Bitmap getScanLineBitmap() {
        return this.f5002;
    }

    public int getScanLineColor() {
        return this.f4998;
    }

    public int getScanLineMargin() {
        return this.f4999;
    }

    public int getScanLineSize() {
        return this.f4997;
    }

    public int getTipBackgroundColor() {
        return this.f5018;
    }

    public int getTipBackgroundRadius() {
        return this.f5032;
    }

    public String getTipText() {
        return this.f5012;
    }

    public int getTipTextColor() {
        return this.f5014;
    }

    public int getTipTextMargin() {
        return this.f5016;
    }

    public int getTipTextSize() {
        return this.f5013;
    }

    public StaticLayout getTipTextSl() {
        return this.f5031;
    }

    public int getToolbarHeight() {
        return this.f5008;
    }

    public int getTopOffset() {
        return this.f4996;
    }

    public float getVerticalBias() {
        return this.f5006;
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        C4091 c4091 = this.f4977;
        if (c4091 == null) {
            return;
        }
        Rect rectM13030 = c4091.m13030();
        Rect rectM13031 = this.f4977.m13031();
        if (rectM13030 == null || rectM13031 == null || this.f4984 == null) {
            return;
        }
        m4763(canvas);
        m4761(canvas);
        m4762(canvas);
        m4764(canvas);
        m4765(canvas);
        m4769();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m4760();
    }

    public void setAnimTime(int i) {
        this.f5005 = i;
        m4770();
    }

    public void setAutoZoom(boolean z) {
        this.f5035 = z;
    }

    public void setBarCodeTipText(String str) {
        this.f5011 = str;
        m4770();
    }

    public void setBarcodeRectHeight(int i) {
        this.f4995 = i;
        m4770();
    }

    public void setBorderColor(int i) {
        this.f5004 = i;
        m4770();
    }

    public void setBorderSize(int i) {
        this.f5003 = i;
        m4770();
    }

    public void setCameraManager(C4091 c4091) {
        this.f4977 = c4091;
    }

    public void setCornerColor(int i) {
        this.f4990 = i;
        m4770();
    }

    public void setCornerLength(int i) {
        this.f4991 = i;
        m4770();
    }

    public void setCornerSize(int i) {
        this.f4992 = i;
        m4770();
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.f5001 = drawable;
        m4770();
    }

    public void setHalfCornerSize(float f) {
        this.f5030 = f;
        m4770();
    }

    public void setIsBarcode(boolean z) {
        this.f5009 = z;
        m4770();
    }

    public void setMaskColor(int i) {
        this.f4989 = i;
        m4770();
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.f5033 = z;
        m4760();
    }

    public void setQRCodeTipText(String str) {
        this.f5010 = str;
        m4770();
    }

    public void setRectHeight(int i) {
        this.f4994 = i;
        m4770();
    }

    public void setRectWidth(int i) {
        this.f4993 = i;
        m4770();
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.f5002 = bitmap;
        m4770();
    }

    public void setScanLineColor(int i) {
        this.f4998 = i;
        m4770();
    }

    public void setScanLineMargin(int i) {
        this.f4999 = i;
        m4770();
    }

    public void setScanLineReverse(boolean z) {
        this.f5020 = z;
        m4770();
    }

    public void setScanLineSize(int i) {
        this.f4997 = i;
        m4770();
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.f5021 = z;
        m4770();
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.f5000 = z;
        m4770();
    }

    public void setShowLocationPoint(boolean z) {
        this.f5034 = z;
    }

    public void setShowTipBackground(boolean z) {
        this.f5019 = z;
        m4770();
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.f5017 = z;
        m4770();
    }

    public void setTipBackgroundColor(int i) {
        this.f5018 = i;
        m4770();
    }

    public void setTipBackgroundRadius(int i) {
        this.f5032 = i;
        m4770();
    }

    public void setTipText(String str) {
        if (this.f5009) {
            this.f5011 = str;
        } else {
            this.f5010 = str;
        }
        m4770();
    }

    public void setTipTextBelowRect(boolean z) {
        this.f5015 = z;
        m4770();
    }

    public void setTipTextColor(int i) {
        this.f5014 = i;
        this.f4988.setColor(i);
        m4770();
    }

    public void setTipTextMargin(int i) {
        this.f5016 = i;
        m4770();
    }

    public void setTipTextSize(int i) {
        this.f5013 = i;
        this.f4988.setTextSize(i);
        m4770();
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.f5031 = staticLayout;
        m4770();
    }

    public void setToolbarHeight(int i) {
        this.f5008 = i;
        m4770();
    }

    public void setTopOffset(int i) {
        this.f4996 = i;
        m4770();
    }

    public void setVerticalBias(float f) {
        this.f5006 = f;
        m4770();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4758(ResultPoint resultPoint) {
        List<ResultPoint> list = this.f4979;
        synchronized (list) {
            list.add(resultPoint);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4759() {
        Drawable drawable = this.f5022;
        if (drawable != null) {
            this.f5028 = ((BitmapDrawable) drawable).getBitmap();
        }
        if (this.f5028 == null) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.qrcode_default_grid_scan_line);
            this.f5028 = bitmapDecodeResource;
            this.f5028 = C5152.m15068(bitmapDecodeResource, this.f4998);
        }
        Bitmap bitmapM15064 = C5152.m15064(this.f5028, 90);
        this.f5029 = bitmapM15064;
        Bitmap bitmapM150642 = C5152.m15064(bitmapM15064, 90);
        this.f5029 = bitmapM150642;
        this.f5029 = C5152.m15064(bitmapM150642, 90);
        Drawable drawable2 = this.f5001;
        if (drawable2 != null) {
            this.f5026 = ((BitmapDrawable) drawable2).getBitmap();
        }
        if (this.f5026 == null) {
            Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.qrcode_default_scan_line);
            this.f5026 = bitmapDecodeResource2;
            this.f5026 = C5152.m15068(bitmapDecodeResource2, this.f4998);
        }
        this.f5027 = C5152.m15064(this.f5026, 90);
        this.f4996 += this.f5008;
        this.f5030 = (this.f4992 * 1.0f) / 2.0f;
        this.f4988.setTextSize(C4792.m14375().m14378());
        this.f4988.setColor(this.f5014);
        this.f4981.setTextSize(C4792.m14375().m14378());
        setIsBarcode(this.f5009);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4760() {
        int width = (getWidth() - this.f4993) / 2;
        this.f4996 = (((getHeight() - this.f4994) + this.f5016) + this.f5032) / 2;
        int i = this.f4996;
        this.f4984 = new Rect(width, i, this.f4993 + width, this.f4994 + i);
        if (this.f5009) {
            float f = r1.left + this.f5030 + 0.5f;
            this.f4986 = f;
            this.f5025 = f;
        } else {
            float f2 = r1.top + this.f5030 + 0.5f;
            this.f4985 = f2;
            this.f5024 = f2;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4761(Canvas canvas) {
        if (this.f5003 > 0) {
            this.f4987.setStyle(Paint.Style.STROKE);
            this.f4987.setColor(this.f5004);
            this.f4987.setStrokeWidth(this.f5003);
            canvas.drawRect(this.f4984, this.f4987);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4762(Canvas canvas) {
        if (this.f5030 > 0.0f) {
            this.f4987.setStyle(Paint.Style.STROKE);
            this.f4987.setColor(this.f4990);
            this.f4987.setStrokeWidth(this.f4992);
            int i = this.f5007;
            if (i == 1) {
                Rect rect = this.f4984;
                int i2 = rect.left;
                float f = this.f5030;
                int i3 = rect.top;
                canvas.drawLine(i2 - f, i3, (i2 - f) + this.f4991, i3, this.f4987);
                Rect rect2 = this.f4984;
                int i4 = rect2.left;
                int i5 = rect2.top;
                float f2 = this.f5030;
                canvas.drawLine(i4, i5 - f2, i4, (i5 - f2) + this.f4991, this.f4987);
                Rect rect3 = this.f4984;
                int i6 = rect3.right;
                float f3 = this.f5030;
                int i7 = rect3.top;
                canvas.drawLine(i6 + f3, i7, (i6 + f3) - this.f4991, i7, this.f4987);
                Rect rect4 = this.f4984;
                int i8 = rect4.right;
                int i9 = rect4.top;
                float f4 = this.f5030;
                canvas.drawLine(i8, i9 - f4, i8, (i9 - f4) + this.f4991, this.f4987);
                Rect rect5 = this.f4984;
                int i10 = rect5.left;
                float f5 = this.f5030;
                int i11 = rect5.bottom;
                canvas.drawLine(i10 - f5, i11, (i10 - f5) + this.f4991, i11, this.f4987);
                Rect rect6 = this.f4984;
                int i12 = rect6.left;
                int i13 = rect6.bottom;
                float f6 = this.f5030;
                canvas.drawLine(i12, i13 + f6, i12, (i13 + f6) - this.f4991, this.f4987);
                Rect rect7 = this.f4984;
                int i14 = rect7.right;
                float f7 = this.f5030;
                int i15 = rect7.bottom;
                canvas.drawLine(i14 + f7, i15, (i14 + f7) - this.f4991, i15, this.f4987);
                Rect rect8 = this.f4984;
                int i16 = rect8.right;
                int i17 = rect8.bottom;
                float f8 = this.f5030;
                canvas.drawLine(i16, i17 + f8, i16, (i17 + f8) - this.f4991, this.f4987);
                return;
            }
            if (i == 2) {
                Rect rect9 = this.f4984;
                int i18 = rect9.left;
                int i19 = rect9.top;
                float f9 = this.f5030;
                canvas.drawLine(i18, i19 + f9, i18 + this.f4991, i19 + f9, this.f4987);
                Rect rect10 = this.f4984;
                int i20 = rect10.left;
                float f10 = this.f5030;
                canvas.drawLine(i20 + f10, rect10.top, i20 + f10, r0 + this.f4991, this.f4987);
                Rect rect11 = this.f4984;
                int i21 = rect11.right;
                int i22 = rect11.top;
                float f11 = this.f5030;
                canvas.drawLine(i21, i22 + f11, i21 - this.f4991, i22 + f11, this.f4987);
                Rect rect12 = this.f4984;
                int i23 = rect12.right;
                float f12 = this.f5030;
                canvas.drawLine(i23 - f12, rect12.top, i23 - f12, r0 + this.f4991, this.f4987);
                Rect rect13 = this.f4984;
                int i24 = rect13.left;
                int i25 = rect13.bottom;
                float f13 = this.f5030;
                canvas.drawLine(i24, i25 - f13, i24 + this.f4991, i25 - f13, this.f4987);
                Rect rect14 = this.f4984;
                int i26 = rect14.left;
                float f14 = this.f5030;
                canvas.drawLine(i26 + f14, rect14.bottom, i26 + f14, r0 - this.f4991, this.f4987);
                Rect rect15 = this.f4984;
                int i27 = rect15.right;
                int i28 = rect15.bottom;
                float f15 = this.f5030;
                canvas.drawLine(i27, i28 - f15, i27 - this.f4991, i28 - f15, this.f4987);
                Rect rect16 = this.f4984;
                int i29 = rect16.right;
                float f16 = this.f5030;
                canvas.drawLine(i29 - f16, rect16.bottom, i29 - f16, r0 - this.f4991, this.f4987);
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4763(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.f4989 != 0) {
            this.f4987.setStyle(Paint.Style.FILL);
            this.f4987.setColor(this.f4989);
            float f = width;
            canvas.drawRect(0.0f, 0.0f, f, this.f4984.top, this.f4987);
            Rect rect = this.f4984;
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f4987);
            Rect rect2 = this.f4984;
            canvas.drawRect(rect2.right + 1, rect2.top, f, rect2.bottom + 1, this.f4987);
            canvas.drawRect(0.0f, this.f4984.bottom + 1, f, height, this.f4987);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4764(Canvas canvas) {
        if (this.f5009) {
            if (this.f5023 != null) {
                float f = this.f4984.left;
                float f2 = this.f5030;
                int i = this.f4999;
                RectF rectF = new RectF(f + f2 + 0.5f, r1.top + f2 + i, this.f5025, (r1.bottom - f2) - i);
                Rect rect = new Rect((int) (this.f5023.getWidth() - rectF.width()), 0, this.f5023.getWidth(), this.f5023.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.f5023, rect, rectF, this.f4987);
                return;
            }
            if (this.f5002 != null) {
                float f3 = this.f4986;
                canvas.drawBitmap(this.f5002, (Rect) null, new RectF(f3, this.f4984.top + this.f5030 + this.f4999, this.f5002.getWidth() + f3, (this.f4984.bottom - this.f5030) - this.f4999), this.f4987);
                return;
            }
            this.f4987.setStyle(Paint.Style.FILL);
            this.f4987.setColor(this.f4998);
            float f4 = this.f4986;
            float f5 = this.f4984.top;
            float f6 = this.f5030;
            int i2 = this.f4999;
            canvas.drawRect(f4, f5 + f6 + i2, this.f4997 + f4, (r0.bottom - f6) - i2, this.f4987);
            return;
        }
        if (this.f5023 != null) {
            float f7 = this.f4984.left;
            float f8 = this.f5030;
            int i3 = this.f4999;
            RectF rectF2 = new RectF(f7 + f8 + i3, r1.top + f8 + 0.5f, (r1.right - f8) - i3, this.f5024);
            Rect rect2 = new Rect(0, (int) (this.f5023.getHeight() - rectF2.height()), this.f5023.getWidth(), this.f5023.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            canvas.drawBitmap(this.f5023, rect2, rectF2, this.f4987);
            return;
        }
        if (this.f5002 != null) {
            float f9 = this.f4984.left;
            float f10 = this.f5030;
            int i4 = this.f4999;
            float f11 = this.f4985;
            canvas.drawBitmap(this.f5002, (Rect) null, new RectF(f9 + f10 + i4, f11, (r2.right - f10) - i4, this.f5002.getHeight() + f11), this.f4987);
            return;
        }
        this.f4987.setStyle(Paint.Style.FILL);
        this.f4987.setColor(this.f4998);
        float f12 = this.f4984.left;
        float f13 = this.f5030;
        int i5 = this.f4999;
        float f14 = this.f4985;
        canvas.drawRect(f12 + f13 + i5, f14, (r0.right - f13) - i5, f14 + this.f4997, this.f4987);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m4765(Canvas canvas) {
        if (TextUtils.isEmpty(this.f5012)) {
            return;
        }
        Rect rect = new Rect();
        TextPaint textPaint = this.f4988;
        String str = this.f5012;
        textPaint.getTextBounds(str, 0, str.length(), rect);
        float width = (canvas.getWidth() - rect.width()) / 2;
        canvas.drawText(this.f5012, width, (this.f4984.top - this.f5016) - this.f5032, this.f4981);
        canvas.drawText(this.f5012, width, (this.f4984.top - this.f5016) - this.f5032, this.f4988);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4766() {
        Bitmap bitmap = this.f4978;
        this.f4978 = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4767(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.QRCodeView);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            m4768(typedArrayObtainStyledAttributes.getIndex(i), typedArrayObtainStyledAttributes);
        }
        typedArrayObtainStyledAttributes.recycle();
        m4759();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m4768(int i, TypedArray typedArray) {
        if (i == 32) {
            this.f4996 = typedArray.getDimensionPixelSize(i, this.f4996);
            return;
        }
        if (i == 8) {
            this.f4992 = typedArray.getDimensionPixelSize(i, this.f4992);
            return;
        }
        if (i == 7) {
            this.f4991 = typedArray.getDimensionPixelSize(i, this.f4991);
            return;
        }
        if (i == 26) {
            this.f4997 = typedArray.getDimensionPixelSize(i, this.f4997);
            return;
        }
        if (i == 23) {
            this.f4993 = typedArray.getDimensionPixelSize(i, this.f4993);
            return;
        }
        if (i == 21) {
            this.f4989 = typedArray.getColor(i, this.f4989);
            return;
        }
        if (i == 5) {
            this.f4990 = typedArray.getColor(i, this.f4990);
            return;
        }
        if (i == 24) {
            this.f4998 = typedArray.getColor(i, this.f4998);
            return;
        }
        if (i == 25) {
            this.f4999 = typedArray.getDimensionPixelSize(i, this.f4999);
            return;
        }
        if (i == 16) {
            this.f5000 = typedArray.getBoolean(i, this.f5000);
            return;
        }
        if (i == 10) {
            this.f5001 = typedArray.getDrawable(i);
            return;
        }
        if (i == 4) {
            this.f5003 = typedArray.getDimensionPixelSize(i, this.f5003);
            return;
        }
        if (i == 3) {
            this.f5004 = typedArray.getColor(i, this.f5004);
            return;
        }
        if (i == 0) {
            this.f5005 = typedArray.getInteger(i, this.f5005);
            return;
        }
        if (i == 33) {
            this.f5006 = typedArray.getFloat(i, this.f5006);
            return;
        }
        if (i == 6) {
            this.f5007 = typedArray.getInteger(i, this.f5007);
            return;
        }
        if (i == 31) {
            this.f5008 = typedArray.getDimensionPixelSize(i, this.f5008);
            return;
        }
        if (i == 2) {
            this.f4995 = typedArray.getDimensionPixelSize(i, this.f4995);
            return;
        }
        if (i == 12) {
            this.f5009 = typedArray.getBoolean(i, this.f5009);
            return;
        }
        if (i == 1) {
            this.f5011 = typedArray.getString(i);
            return;
        }
        if (i == 22) {
            this.f5010 = typedArray.getString(i);
            return;
        }
        if (i == 30) {
            this.f5013 = typedArray.getDimensionPixelSize(i, this.f5013);
            return;
        }
        if (i == 28) {
            this.f5014 = typedArray.getColor(i, this.f5014);
            return;
        }
        if (i == 20) {
            this.f5015 = typedArray.getBoolean(i, this.f5015);
            return;
        }
        if (i == 29) {
            this.f5016 = typedArray.getDimensionPixelSize(i, this.f5016);
            return;
        }
        if (i == 19) {
            this.f5017 = typedArray.getBoolean(i, this.f5017);
            return;
        }
        if (i == 18) {
            this.f5019 = typedArray.getBoolean(i, this.f5019);
            return;
        }
        if (i == 27) {
            this.f5018 = typedArray.getColor(i, this.f5018);
            return;
        }
        if (i == 14) {
            this.f5020 = typedArray.getBoolean(i, this.f5020);
            return;
        }
        if (i == 15) {
            this.f5021 = typedArray.getBoolean(i, this.f5021);
            return;
        }
        if (i == 9) {
            this.f5022 = typedArray.getDrawable(i);
            return;
        }
        if (i == 13) {
            this.f5033 = typedArray.getBoolean(i, this.f5033);
        } else if (i == 17) {
            this.f5034 = typedArray.getBoolean(i, this.f5034);
        } else if (i == 11) {
            this.f5035 = typedArray.getBoolean(i, this.f5035);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m4769() {
        if (this.f5009) {
            if (this.f5023 == null) {
                this.f4986 += this.f4982;
                int width = this.f4997;
                Bitmap bitmap = this.f5002;
                if (bitmap != null) {
                    width = bitmap.getWidth();
                }
                if (this.f5020) {
                    float f = this.f4986;
                    float f2 = width + f;
                    float f3 = this.f4984.right;
                    float f4 = this.f5030;
                    if (f2 > f3 - f4 || f < r2.left + f4) {
                        this.f4982 = -this.f4982;
                    }
                } else {
                    float f5 = this.f4986 + width;
                    float f6 = this.f4984.right;
                    float f7 = this.f5030;
                    if (f5 > f6 - f7) {
                        this.f4986 = r0.left + f7 + 0.5f;
                    }
                }
            } else {
                float f8 = this.f5025 + this.f4982;
                this.f5025 = f8;
                float f9 = this.f4984.right;
                float f10 = this.f5030;
                if (f8 > f9 - f10) {
                    this.f5025 = r2.left + f10 + 0.5f;
                }
            }
        } else if (this.f5023 == null) {
            this.f4985 += this.f4982;
            int height = this.f4997;
            Bitmap bitmap2 = this.f5002;
            if (bitmap2 != null) {
                height = bitmap2.getHeight();
            }
            if (this.f5020) {
                float f11 = this.f4985;
                float f12 = height + f11;
                float f13 = this.f4984.bottom;
                float f14 = this.f5030;
                if (f12 > f13 - f14 || f11 < r2.top + f14) {
                    this.f4982 = -this.f4982;
                }
            } else {
                float f15 = this.f4985 + height;
                float f16 = this.f4984.bottom;
                float f17 = this.f5030;
                if (f15 > f16 - f17) {
                    this.f4985 = r0.top + f17 + 0.5f;
                }
            }
        } else {
            float f18 = this.f5024 + this.f4982;
            this.f5024 = f18;
            float f19 = this.f4984.bottom;
            float f20 = this.f5030;
            if (f18 > f19 - f20) {
                this.f5024 = r2.top + f20 + 0.5f;
            }
        }
        long j = this.f4983;
        Rect rect = this.f4984;
        postInvalidateDelayed(j, rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m4770() {
        if (this.f5022 != null || this.f5021) {
            if (this.f5009) {
                this.f5023 = this.f5029;
            } else {
                this.f5023 = this.f5028;
            }
        } else if (this.f5001 != null || this.f5000) {
            if (this.f5009) {
                this.f5002 = this.f5027;
            } else {
                this.f5002 = this.f5026;
            }
        }
        if (this.f5009) {
            this.f5012 = this.f5011;
            this.f4994 = this.f4995;
            this.f4983 = (int) (((this.f5005 * 1.0f) * this.f4982) / this.f4993);
        } else {
            this.f5012 = this.f5010;
            int i = this.f4993;
            this.f4994 = i;
            this.f4983 = (int) (((this.f5005 * 1.0f) * this.f4982) / i);
        }
        if (!TextUtils.isEmpty(this.f5012)) {
            if (this.f5017) {
                this.f5031 = new StaticLayout(this.f5012, this.f4988, C5152.m15066(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.f5031 = new StaticLayout(this.f5012, this.f4988, this.f4993 - (this.f5032 * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.f5006 != -1.0f) {
            int iM15067 = C5152.m15066(getContext()).y - C5152.m15067(getContext());
            int i2 = this.f5008;
            if (i2 == 0) {
                this.f4996 = (int) ((iM15067 * this.f5006) - (this.f4994 / 2));
            } else {
                this.f4996 = i2 + ((int) (((iM15067 - i2) * this.f5006) - (this.f4994 / 2)));
            }
        }
        m4760();
        postInvalidate();
    }

    public ViewfinderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4979 = new ArrayList(5);
        this.f4980 = null;
        Paint paint = new Paint();
        this.f4987 = paint;
        paint.setAntiAlias(true);
        this.f4989 = Color.parseColor("#80000000");
        this.f4990 = -1;
        this.f4991 = C5152.m15065(context, 20.0f);
        this.f4992 = C5152.m15065(context, 3.0f);
        this.f4997 = C5152.m15065(context, 1.0f);
        this.f4998 = -1;
        this.f4996 = C5152.m15065(context, 40.0f);
        this.f4993 = C5152.m15065(context, 200.0f);
        this.f4995 = C5152.m15065(context, 140.0f);
        this.f4999 = 0;
        this.f5000 = false;
        this.f5001 = null;
        this.f5002 = null;
        this.f5003 = C5152.m15065(context, 1.0f);
        this.f5004 = -1;
        this.f5005 = 1000;
        this.f5006 = -1.0f;
        this.f5007 = 1;
        this.f5008 = 0;
        this.f5009 = false;
        this.f4982 = C5152.m15065(context, 2.0f);
        this.f5012 = null;
        this.f5013 = C4792.m14375().m14380();
        this.f5014 = -1;
        this.f5015 = false;
        this.f5016 = C5152.m15065(context, 20.0f);
        this.f5017 = false;
        this.f5018 = Color.parseColor("#22000000");
        this.f5019 = false;
        this.f5020 = false;
        this.f5021 = false;
        TextPaint textPaint = new TextPaint();
        this.f4988 = textPaint;
        textPaint.setAntiAlias(true);
        this.f4988.setTypeface(FilmApp.m404());
        TextPaint textPaint2 = new TextPaint();
        this.f4981 = textPaint2;
        textPaint2.setStrokeWidth(C4792.f16138);
        this.f4981.setStyle(Paint.Style.STROKE);
        this.f4981.setStrokeJoin(Paint.Join.ROUND);
        this.f4981.setStrokeCap(Paint.Cap.ROUND);
        this.f4981.setColor(getResources().getColor(R.color.border_text));
        this.f4981.setTypeface(FilmApp.m404());
        this.f5032 = C5152.m15065(context, 4.0f);
        this.f5033 = false;
        this.f5034 = false;
        this.f5035 = false;
        m4767(attributeSet);
    }
}
