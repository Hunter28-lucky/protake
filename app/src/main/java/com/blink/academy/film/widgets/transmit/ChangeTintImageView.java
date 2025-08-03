package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.protake.R;
import defpackage.AbstractC4254;
import defpackage.C4792;
import defpackage.r1;

/* loaded from: classes.dex */
public class ChangeTintImageView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4254 f4183;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f4184;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4185;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f4186;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f4187;

    /* renamed from: ՠ, reason: contains not printable characters */
    public String f4188;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f4189;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f4190;

    public ChangeTintImageView(@NonNull Context context) {
        super(context);
        this.f4185 = 0;
        this.f4186 = -1;
        this.f4187 = "";
        this.f4188 = "";
        this.f4189 = 0;
        this.f4190 = 0;
        m4157();
    }

    private void setContentTextColor(int i) {
        this.f4183.f14606.setContentTextColor(getResources().getColor(i, null));
        this.f4183.f14607.setContentTextColor(getResources().getColor(i, null));
    }

    public void setCenterState(int i) {
        if (this.f4185 == i) {
            return;
        }
        this.f4185 = i;
        if (i == 1) {
            this.f4183.f14599.setAlpha(0.0f);
            this.f4183.f14600.setAlpha(0.0f);
            this.f4183.f14601.setAlpha(1.0f);
            this.f4183.f14602.setAlpha(1.0f);
            this.f4183.f14606.setAlpha(0.0f);
            return;
        }
        if (i == 2) {
            this.f4183.f14599.setAlpha(1.0f);
            this.f4183.f14600.setAlpha(1.0f);
            this.f4183.f14601.setAlpha(0.0f);
            this.f4183.f14602.setAlpha(0.0f);
            this.f4183.f14606.setAlpha(0.0f);
            return;
        }
        if (i != 3) {
            return;
        }
        this.f4183.f14599.setAlpha(0.0f);
        this.f4183.f14600.setAlpha(0.0f);
        this.f4183.f14601.setAlpha(0.0f);
        this.f4183.f14602.setAlpha(0.0f);
        this.f4183.f14606.setAlpha(1.0f);
    }

    public void setNeedBorder(boolean z) {
        this.f4183.f14606.setDrawBorder(z);
        this.f4183.f14606.setDrawBorder(z);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4157() {
        this.f4183 = AbstractC4254.m13366(LayoutInflater.from(getContext()), this, true);
        m4161();
        m4162();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4158() {
        this.f4183.f14594.setImageResource(R.drawable.icon_25_control);
        this.f4183.f14598.setImageResource(R.drawable.icon_25_control_disabled);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m4159(int i) {
        if (this.f4186 == i) {
            return;
        }
        this.f4186 = i;
        if (i == 1) {
            this.f4183.f14594.setImageResource(R.drawable.icon_36_frame_stroke36_frame_stroke);
            this.f4183.f14598.setImageResource(R.drawable.icon_36_frame);
            this.f4183.f14603.setImageResource(R.drawable.icon_36_cellular_1_stroke);
            this.f4183.f14604.setImageResource(R.drawable.icon_36_cellular_1);
            this.f4183.f14605.setImageResource(R.drawable.icon_36_cellular_2_stroke);
            this.f4183.f14595.setImageResource(R.drawable.icon_36_cellular_2);
            this.f4183.f14596.setImageResource(R.drawable.icon_36_cellular_3_stroke);
            this.f4183.f14597.setImageResource(R.drawable.icon_36_cellular_3);
            return;
        }
        this.f4183.f14594.setImageResource(R.drawable.icon_36_frame_stroke36_frame_stroke);
        this.f4183.f14598.setImageResource(R.drawable.icon_36_frame);
        this.f4183.f14599.setImageResource(R.drawable.icon_36_play_stroke);
        this.f4183.f14600.setImageResource(R.drawable.icon_36_play);
        this.f4183.f14601.setImageResource(R.drawable.icon_36_rec_stroke);
        this.f4183.f14602.setImageResource(R.drawable.icon_36_rec);
        this.f4183.f14603.setImageResource(R.drawable.icon_36_signal_1_stroke);
        this.f4183.f14604.setImageResource(R.drawable.icon_36_signal_1);
        this.f4183.f14605.setImageResource(R.drawable.icon_36_signal_2_stroke);
        this.f4183.f14595.setImageResource(R.drawable.icon_36_signal_2);
        this.f4183.f14596.setImageResource(R.drawable.icon_36_signal_3_stroke);
        this.f4183.f14597.setImageResource(R.drawable.icon_36_signal_3);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m4160() {
        this.f4183.f14596.setAlpha(1.0f);
        this.f4183.f14597.setAlpha(1.0f);
        this.f4183.f14605.setAlpha(1.0f);
        this.f4183.f14595.setAlpha(1.0f);
        this.f4183.f14603.setAlpha(1.0f);
        this.f4183.f14604.setAlpha(1.0f);
        setContentTextColor(R.color.colorTransmitGreen);
        this.f4183.f14598.setColorFilter(getResources().getColor(R.color.colorTransmitGreen, null));
        this.f4183.f14600.setColorFilter(getResources().getColor(R.color.colorTransmitGreen, null));
        this.f4183.f14602.setColorFilter(getResources().getColor(R.color.colorTransmitGreen, null));
        this.f4183.f14604.setColorFilter(getResources().getColor(R.color.colorTransmitGreen, null));
        this.f4183.f14595.setColorFilter(getResources().getColor(R.color.colorTransmitGreen, null));
        this.f4183.f14597.setColorFilter(getResources().getColor(R.color.colorTransmitGreen, null));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4161() {
        this.f4184 = C4792.m14375().m14434();
        this.f4183.f14606.m2562(0, (int) ((C4792.m14375().m14378() * this.f4184) + 0.5f));
        this.f4183.f14606.setContentTypeFace(FilmApp.m403());
        this.f4183.f14607.m2562(0, C4792.m14375().m14396());
        this.f4183.f14607.setContentTypeFace(FilmApp.m403());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4183.f14607.getLayoutParams();
        Paint.FontMetrics fontMetrics = this.f4183.f14606.getPaint().getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ((int) ((((fontMetrics.bottom - fontMetrics.top) - fontMetrics.descent) + fontMetrics.ascent) / 2.0f)) + C4792.m14375().m14476(10);
        this.f4183.f14607.setLayoutParams(layoutParams);
        TextPaint paint = this.f4183.f14606.getPaint();
        Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
        int i = (int) (fontMetrics2.bottom - fontMetrics2.top);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4183.f14606.getLayoutParams();
        float fMeasureText = paint.measureText(ExifInterface.LONGITUDE_WEST);
        float f = C4792.f16138;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (fMeasureText + f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (i + f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = (int) (((C4792.m14375().m14476(75) - i) / 2.0f) - C4792.f16138);
        this.f4183.f14606.setLayoutParams(layoutParams2);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4162() {
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4163(int i) {
        if (i == this.f4186) {
            return;
        }
        this.f4186 = i;
        this.f4183.f14594.setImageResource(R.drawable.icon_36_frame_stroke36_frame_stroke);
        this.f4183.f14598.setImageResource(R.drawable.icon_36_frame);
        if (i == 1) {
            this.f4183.f14603.setImageResource(R.drawable.icon_36_cellular_1_stroke);
            this.f4183.f14604.setImageResource(R.drawable.icon_36_cellular_1);
            this.f4183.f14605.setImageResource(R.drawable.icon_36_cellular_2_stroke);
            this.f4183.f14595.setImageResource(R.drawable.icon_36_cellular_2);
            this.f4183.f14596.setImageResource(R.drawable.icon_36_cellular_3_stroke);
            this.f4183.f14597.setImageResource(R.drawable.icon_36_cellular_3);
        } else {
            this.f4183.f14603.setImageResource(R.drawable.icon_36_signal_1_stroke);
            this.f4183.f14604.setImageResource(R.drawable.icon_36_signal_1);
            this.f4183.f14605.setImageResource(R.drawable.icon_36_signal_2_stroke);
            this.f4183.f14595.setImageResource(R.drawable.icon_36_signal_2);
            this.f4183.f14596.setImageResource(R.drawable.icon_36_signal_3_stroke);
            this.f4183.f14597.setImageResource(R.drawable.icon_36_signal_3);
        }
        this.f4183.f14607.setVisibility(0);
        this.f4183.f14607.m2561("Wi-Fi");
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m4164(int i) {
        if (i == this.f4186) {
            return;
        }
        this.f4186 = i;
        if (i == 1) {
            this.f4183.f14594.setImageResource(R.drawable.icon_25_cellular_0_stroke);
            this.f4183.f14598.setImageResource(R.drawable.icon_25_cellular_0);
            this.f4183.f14599.setImageResource(R.drawable.icon_25_cellular_1_stroke);
            this.f4183.f14600.setImageResource(R.drawable.icon_25_cellular_1);
            this.f4183.f14601.setImageResource(R.drawable.icon_25_cellular_2_stroke);
            this.f4183.f14602.setImageResource(R.drawable.icon_25_cellular_2);
            this.f4183.f14603.setImageResource(R.drawable.icon_25_cellular_3_stroke);
            this.f4183.f14604.setImageResource(R.drawable.icon_25_cellular_3);
            this.f4183.f14605.setImageResource(R.drawable.icon_25_cellular_disabled);
            return;
        }
        this.f4183.f14594.setImageResource(R.drawable.icon_25_signal_0_stroke);
        this.f4183.f14598.setImageResource(R.drawable.icon_25_signal_0);
        this.f4183.f14599.setImageResource(R.drawable.icon_25_signal_1_stroke);
        this.f4183.f14600.setImageResource(R.drawable.icon_25_signal_1);
        this.f4183.f14601.setImageResource(R.drawable.icon_25_signal_2_stroke);
        this.f4183.f14602.setImageResource(R.drawable.icon_25_signal_2);
        this.f4183.f14603.setImageResource(R.drawable.icon_25_signal_3_stroke);
        this.f4183.f14604.setImageResource(R.drawable.icon_25_signal_3);
        this.f4183.f14605.setImageResource(R.drawable.icon_25_signal_disabled);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4165(int i, String str) {
        if (this.f4188.equals(str)) {
            return;
        }
        this.f4188 = str;
        this.f4183.f14606.setVisibility(0);
        this.f4183.f14606.m2561(str);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4166(int i) {
        if (i == 4) {
            this.f4183.f14594.setAlpha(0.0f);
            this.f4183.f14598.setAlpha(1.0f);
        } else {
            this.f4183.f14594.setAlpha(1.0f);
            this.f4183.f14598.setAlpha(0.0f);
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m4167(String str) {
        if (this.f4187.equals(str)) {
            return;
        }
        if (!r1.m8143(str)) {
            str = "";
        }
        this.f4187 = str;
        this.f4183.f14607.setVisibility(0);
        this.f4183.f14607.m2561(this.f4187);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m4168(int i) {
        m4169(i, null);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m4169(int i, @Nullable ImageView imageView) {
        if (this.f4189 == i) {
            return;
        }
        this.f4189 = i;
        int i2 = R.color.colorWhite;
        if (i == 1) {
            this.f4183.f14596.setAlpha(1.0f);
            this.f4183.f14597.setAlpha(1.0f);
            this.f4183.f14605.setAlpha(1.0f);
            this.f4183.f14595.setAlpha(1.0f);
            this.f4183.f14603.setAlpha(1.0f);
            this.f4183.f14604.setAlpha(1.0f);
            i2 = R.color.colorTransmitGreen;
        } else if (i == 2) {
            i2 = R.color.colorTransmitYellow;
            this.f4183.f14596.setAlpha(0.0f);
            this.f4183.f14597.setAlpha(0.0f);
            this.f4183.f14605.setAlpha(1.0f);
            this.f4183.f14595.setAlpha(1.0f);
            this.f4183.f14603.setAlpha(1.0f);
            this.f4183.f14604.setAlpha(1.0f);
        } else if (i == 3) {
            i2 = R.color.colorTransmitButton;
            this.f4183.f14596.setAlpha(0.0f);
            this.f4183.f14597.setAlpha(0.0f);
            this.f4183.f14605.setAlpha(0.0f);
            this.f4183.f14595.setAlpha(0.0f);
            this.f4183.f14603.setAlpha(1.0f);
            this.f4183.f14604.setAlpha(1.0f);
        } else if (i == 4) {
            i2 = R.color.color30White;
        } else if (i == 5) {
            this.f4183.f14596.setAlpha(1.0f);
            this.f4183.f14597.setAlpha(1.0f);
            this.f4183.f14605.setAlpha(1.0f);
            this.f4183.f14595.setAlpha(1.0f);
            this.f4183.f14603.setAlpha(1.0f);
            this.f4183.f14604.setAlpha(1.0f);
        }
        setContentTextColor(i2);
        this.f4183.f14598.setColorFilter(getResources().getColor(i2, null));
        this.f4183.f14600.setColorFilter(getResources().getColor(i2, null));
        this.f4183.f14602.setColorFilter(getResources().getColor(i2, null));
        this.f4183.f14604.setColorFilter(getResources().getColor(i2, null));
        this.f4183.f14595.setColorFilter(getResources().getColor(i2, null));
        this.f4183.f14597.setColorFilter(getResources().getColor(i2, null));
        if (imageView != null) {
            imageView.setColorFilter(getResources().getColor(i2, null));
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m4170(float f, float f2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4183.f14593.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) f;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) f2;
        this.f4183.f14593.setLayoutParams(layoutParams);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m4171(int i) {
        if (this.f4190 == i) {
            return;
        }
        this.f4190 = i;
        int signalColor = TransmitHelper.getSignalColor(i);
        if (i == 4) {
            this.f4183.f14594.setAlpha(0.0f);
            this.f4183.f14598.setAlpha(0.0f);
            this.f4183.f14599.setAlpha(0.0f);
            this.f4183.f14600.setAlpha(0.0f);
            this.f4183.f14601.setAlpha(0.0f);
            this.f4183.f14602.setAlpha(0.0f);
            this.f4183.f14603.setAlpha(0.0f);
            this.f4183.f14604.setAlpha(0.0f);
            this.f4183.f14605.setAlpha(1.0f);
            return;
        }
        this.f4183.f14594.setAlpha(1.0f);
        this.f4183.f14598.setAlpha(1.0f);
        this.f4183.f14605.setAlpha(0.0f);
        if (i == 1) {
            this.f4183.f14599.setAlpha(1.0f);
            this.f4183.f14600.setAlpha(1.0f);
            this.f4183.f14601.setAlpha(1.0f);
            this.f4183.f14602.setAlpha(1.0f);
            this.f4183.f14603.setAlpha(1.0f);
            this.f4183.f14604.setAlpha(1.0f);
        } else if (i == 2) {
            this.f4183.f14599.setAlpha(1.0f);
            this.f4183.f14600.setAlpha(1.0f);
            this.f4183.f14601.setAlpha(1.0f);
            this.f4183.f14602.setAlpha(1.0f);
            this.f4183.f14603.setAlpha(0.0f);
            this.f4183.f14604.setAlpha(0.0f);
        } else if (i == 3) {
            this.f4183.f14599.setAlpha(1.0f);
            this.f4183.f14600.setAlpha(1.0f);
            this.f4183.f14601.setAlpha(0.0f);
            this.f4183.f14602.setAlpha(0.0f);
            this.f4183.f14603.setAlpha(0.0f);
            this.f4183.f14604.setAlpha(0.0f);
        }
        this.f4183.f14598.setColorFilter(getResources().getColor(signalColor, null));
        this.f4183.f14600.setColorFilter(getResources().getColor(signalColor, null));
        this.f4183.f14602.setColorFilter(getResources().getColor(signalColor, null));
        this.f4183.f14604.setColorFilter(getResources().getColor(signalColor, null));
    }

    public ChangeTintImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4185 = 0;
        this.f4186 = -1;
        this.f4187 = "";
        this.f4188 = "";
        this.f4189 = 0;
        this.f4190 = 0;
        m4157();
    }

    public ChangeTintImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4185 = 0;
        this.f4186 = -1;
        this.f4187 = "";
        this.f4188 = "";
        this.f4189 = 0;
        this.f4190 = 0;
        m4157();
    }
}
