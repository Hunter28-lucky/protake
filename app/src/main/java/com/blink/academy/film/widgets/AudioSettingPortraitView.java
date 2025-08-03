package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.AudioSettingView;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.adapter.layout_manager.AutoLineFeedLayoutManager;
import com.blink.academy.protake.R;
import defpackage.AbstractC2644;
import defpackage.AbstractC4012;
import defpackage.AbstractC4975;
import defpackage.C2579;
import defpackage.C2685;
import defpackage.C3227;
import defpackage.C3444;
import defpackage.C3485;
import defpackage.C3502;
import defpackage.C3891;
import defpackage.C3947;
import defpackage.C4008;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4535;
import defpackage.C4734;
import defpackage.C4792;
import defpackage.C5075;
import defpackage.C5080;
import defpackage.r1;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;

/* loaded from: classes.dex */
public class AudioSettingPortraitView extends FrameLayout implements View.OnClickListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2644 f1932;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C3227 f1933;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1934;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4194 f1935;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<C2685> f1936;

    /* renamed from: ՠ, reason: contains not printable characters */
    public ArrayList<C4196> f1937;

    /* renamed from: ֈ, reason: contains not printable characters */
    public ArrayList<Integer> f1938;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f1939;

    /* renamed from: ׯ, reason: contains not printable characters */
    public ArrayList<String> f1940;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f1941;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f1942;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f1943;

    /* renamed from: ނ, reason: contains not printable characters */
    public AutoLineFeedLayoutManager f1944;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f1945;

    /* renamed from: ބ, reason: contains not printable characters */
    public boolean f1946;

    /* renamed from: ޅ, reason: contains not printable characters */
    public AudioSettingView.InterfaceC0870 f1947;

    /* renamed from: com.blink.academy.film.widgets.AudioSettingPortraitView$Ϳ, reason: contains not printable characters */
    public class C0856 implements SwitchButton.InterfaceC0969 {
        public C0856() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo2144(SwitchButton switchButton, boolean z) {
            AudioSettingView.InterfaceC0870 interfaceC0870;
            AudioSettingView.InterfaceC0870 interfaceC08702 = AudioSettingPortraitView.this.f1947;
            if ((interfaceC08702 == null || interfaceC08702.mo2178()) && (interfaceC0870 = AudioSettingPortraitView.this.f1947) != null) {
                interfaceC0870.mo2177(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingPortraitView$Ԩ, reason: contains not printable characters */
    public class C0857 implements FilmSeekBar.InterfaceC0896 {
        public C0857() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            AudioSettingView.InterfaceC0870 interfaceC0870 = AudioSettingPortraitView.this.f1947;
            if (interfaceC0870 == null || interfaceC0870.mo2178()) {
                AudioSettingPortraitView.this.f1932.f9841.m2326(f2 / 100.0f, false, Math.round(f2 / 10.0f) + "%");
                AudioSettingPortraitView.this.f1941 = (f2 * 1.0f) / 1000.0f;
                AudioSettingPortraitView audioSettingPortraitView = AudioSettingPortraitView.this;
                AudioSettingView.InterfaceC0870 interfaceC08702 = audioSettingPortraitView.f1947;
                if (interfaceC08702 != null) {
                    interfaceC08702.mo2179(audioSettingPortraitView.f1941);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingPortraitView$Ԫ, reason: contains not printable characters */
    public class C0858 implements FilmSeekBar.InterfaceC0897 {
        public C0858() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo2145() {
            AudioSettingView.InterfaceC0870 interfaceC0870 = AudioSettingPortraitView.this.f1947;
            if (interfaceC0870 != null) {
                interfaceC0870.mo2175();
            }
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo2146() {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingPortraitView$Ԭ, reason: contains not printable characters */
    public class C0859 implements FilmStopView.InterfaceC0908 {
        public C0859() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo2147() {
            return !AudioSettingPortraitView.this.f1932.f9849.m2303();
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo2148(int i) {
            AudioSettingView.InterfaceC0870 interfaceC0870 = AudioSettingPortraitView.this.f1947;
            if ((interfaceC0870 == null || interfaceC0870.mo2178()) && r1.m8144(AudioSettingPortraitView.this.f1940)) {
                int iIntValue = ((Integer) AudioSettingPortraitView.this.f1938.get(i)).intValue();
                AudioSettingPortraitView.this.f1932.f9841.setCurrentI(i);
                AudioSettingPortraitView.this.f1932.f9849.setValueAndUpdateUI(iIntValue * 10);
                AudioSettingPortraitView.this.f1941 = iIntValue / 100.0f;
                AudioSettingPortraitView audioSettingPortraitView = AudioSettingPortraitView.this;
                AudioSettingView.InterfaceC0870 interfaceC08702 = audioSettingPortraitView.f1947;
                if (interfaceC08702 != null) {
                    interfaceC08702.mo2179(audioSettingPortraitView.f1941);
                    AudioSettingPortraitView.this.f1947.mo2175();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingPortraitView$Ԯ, reason: contains not printable characters */
    public class C0860 implements AbstractC4975.InterfaceC4976 {
        public C0860() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) throws JSONException {
            C2685 c2685 = (C2685) AudioSettingPortraitView.this.f1936.get(i);
            if (c2685 == null || c2685.isSelected() || AudioSettingPortraitView.this.f1934 == i) {
                return;
            }
            ((C2685) AudioSettingPortraitView.this.f1936.get(AudioSettingPortraitView.this.f1934)).setSelected(false);
            ((C3502) AudioSettingPortraitView.this.f1932.f9842.findViewHolderForAdapterPosition(AudioSettingPortraitView.this.f1934)).m11440(false);
            c2685.setSelected(true);
            ((C3502) AudioSettingPortraitView.this.f1932.f9842.findViewHolderForAdapterPosition(i)).m11440(c2685.isSelected());
            AudioSettingPortraitView.this.setShowView(c2685.getType() == 0);
            AudioSettingPortraitView.this.f1934 = i;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingPortraitView$ՠ, reason: contains not printable characters */
    public class C0861 implements AbstractC4975.InterfaceC4976 {
        public C0861() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            AudioSettingView.InterfaceC0870 interfaceC0870 = AudioSettingPortraitView.this.f1947;
            if ((interfaceC0870 == null || interfaceC0870.mo2178()) && AudioSettingPortraitView.this.f1939 != i) {
                ((C4196) AudioSettingPortraitView.this.f1937.get(AudioSettingPortraitView.this.f1939)).setSelected(false);
                ((C4734) AudioSettingPortraitView.this.f1932.f9840.findViewHolderForAdapterPosition(AudioSettingPortraitView.this.f1939)).mo8729(false);
                C4196 c4196 = (C4196) AudioSettingPortraitView.this.f1937.get(i);
                c4196.setSelected(true);
                ((C4734) AudioSettingPortraitView.this.f1932.f9840.findViewHolderForAdapterPosition(i)).mo8729(true);
                C5080 c5080M13221 = c4196.m13221();
                AudioSettingView.InterfaceC0870 interfaceC08702 = AudioSettingPortraitView.this.f1947;
                if (interfaceC08702 != null) {
                    interfaceC08702.mo2180(c5080M13221.getType());
                }
                AudioSettingPortraitView.this.f1939 = i;
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingPortraitView$ֈ, reason: contains not printable characters */
    public class C0862 extends AbstractC4012 {
        public C0862() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) throws JSONException {
            super.onAnimationEnd(view);
            if (AudioSettingPortraitView.this.f1933 != null) {
                AudioSettingPortraitView.this.f1933.notifyDataSetChanged();
            }
            if (AudioSettingPortraitView.this.f1935 != null) {
                AudioSettingPortraitView.this.f1935.notifyDataSetChanged();
            }
            C3891 c3891M13890 = C4535.m13880().m13890();
            AudioSettingPortraitView.this.f1942 = c3891M13890.m12460() == 1;
            AudioSettingPortraitView.this.f1943 = c3891M13890.m12471() != 0;
            AudioSettingPortraitView audioSettingPortraitView = AudioSettingPortraitView.this;
            audioSettingPortraitView.setShowView(audioSettingPortraitView.f1934 == 0);
        }
    }

    public AudioSettingPortraitView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowView(boolean z) throws JSONException {
        float f = z ? 1.0f : 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        this.f1932.f9840.setAlpha(f);
        this.f1932.f9840.setEnabled(z);
        this.f1932.f9841.setAlpha(f2);
        this.f1932.f9841.setVisibility(z ? 8 : 0);
        this.f1932.f9839.setVisibility(z ? 8 : 0);
        if ((this.f1942 || this.f1943) && !z) {
            f2 = 0.2f;
        }
        this.f1932.f9849.setAlpha(f2);
        this.f1932.f9844.setAlpha(f2);
        this.f1932.f9839.setAlpha(f2);
        boolean z2 = (z || this.f1942 || this.f1943) ? false : true;
        this.f1932.f9849.setEnabled(z2);
        this.f1932.f9844.setEnabled(z2);
        this.f1932.f9839.setEnabled(z2);
        if (!z) {
            this.f1932.f9839.setEnabled(true);
            boolean zM11254 = C3444.m11227().m11254();
            C3485 c3485M12731 = C3947.m12727().m12731();
            if (c3485M12731 == null || !c3485M12731.m11381()) {
                this.f1932.f9843.setVisibility(8);
            } else {
                C3891 c3891M13890 = C4535.m13880().m13890();
                if (c3891M13890.m12460() == 1 || c3891M13890.m12471() != 0) {
                    this.f1932.f9839.m2630(false, false);
                    this.f1932.f9839.setEnabled(false);
                } else {
                    this.f1932.f9839.m2630(false, zM11254);
                    this.f1932.f9839.setEnabled(z2);
                }
            }
        }
        if (z) {
            m2139();
        } else {
            m2138();
        }
        this.f1932.f9841.setEnabled(true);
        if (z2) {
            this.f1932.f9841.m2320();
        } else {
            this.f1932.f9841.m2318();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1945 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f1946) {
            return;
        }
        m2132(0, null);
    }

    public void setAudioChangeListener(AudioSettingView.InterfaceC0870 interfaceC0870) {
        this.f1947 = interfaceC0870;
    }

    public void setPadding(int i) {
        LinearLayout linearLayout = this.f1932.f9845;
        if (linearLayout != null) {
            linearLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final int m2131(int i) {
        if (i == 0) {
            AudioSettingView.InterfaceC0870 interfaceC0870 = this.f1947;
            if (interfaceC0870 != null) {
                interfaceC0870.mo2176(0);
            }
        } else {
            if (i == 1) {
                if (!C5075.m14899().m14903()) {
                    if (C5075.m14899().m14902()) {
                        AudioSettingView.InterfaceC0870 interfaceC08702 = this.f1947;
                        if (interfaceC08702 != null) {
                            interfaceC08702.mo2176(2);
                        }
                        C3444.m11227().m11264(2);
                        return 2;
                    }
                    AudioSettingView.InterfaceC0870 interfaceC08703 = this.f1947;
                    if (interfaceC08703 != null) {
                        interfaceC08703.mo2176(0);
                    }
                    C3444.m11227().m11264(0);
                }
                return 1;
            }
            if (i == 2) {
                if (C5075.m14899().m14902()) {
                    return 2;
                }
                if (C5075.m14899().m14903()) {
                    AudioSettingView.InterfaceC0870 interfaceC08704 = this.f1947;
                    if (interfaceC08704 != null) {
                        interfaceC08704.mo2176(1);
                    }
                    C3444.m11227().m11264(1);
                    return 1;
                }
                AudioSettingView.InterfaceC0870 interfaceC08705 = this.f1947;
                if (interfaceC08705 != null) {
                    interfaceC08705.mo2176(0);
                }
                C3444.m11227().m11264(0);
            }
        }
        return 0;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m2132(int i, AbstractC4012 abstractC4012) {
        this.f1946 = false;
        C4008.m12886(this, 0.0f, this.f1945, i, abstractC4012);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m2133(Context context, AttributeSet attributeSet, int i) {
        AbstractC2644 abstractC2644 = (AbstractC2644) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_audio_portrait_setting, this, true);
        this.f1932 = abstractC2644;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) abstractC2644.f9847.getLayoutParams();
        layoutParams.bottomMargin = C4792.m14375().m14408();
        this.f1932.f9847.m2562(0, C4792.m14375().m14381());
        AbstractC2644 abstractC26442 = this.f1932;
        LinearLayout linearLayout = abstractC26442.f9845;
        layoutParams.width = (int) (abstractC26442.f9847.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_TITLE_AUDIO).toUpperCase()) + C4792.f16138);
        this.f1932.f9847.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        layoutParams2.height = C4792.m14375().m14412();
        setOnClickListener(this);
        this.f1932.f9844.setContentTextColor(-1);
        this.f1932.f9844.m2562(0, C4792.m14375().m14482());
        int iM14420 = C4792.m14375().m14420();
        ViewGroup.LayoutParams layoutParams3 = this.f1932.f9844.getLayoutParams();
        TextPaint paint = this.f1932.f9844.getPaint();
        layoutParams3.width = (int) (paint.measureText(context.getString(R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE_AUTO_GAIN).toUpperCase()) + iM14420 + C4792.f16138);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        layoutParams3.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f1932.f9844.setLayoutParams(layoutParams3);
        this.f1932.f9839.setTextSize(C4792.m14375().m14481());
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f1932.f9839.getLayoutParams();
        layoutParams4.width = C4792.m14375().m14410();
        layoutParams4.height = C4792.m14375().m14409();
        layoutParams4.topMargin = C4792.m14375().m14411();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f1932.f9842.getLayoutParams();
        layoutParams5.width = -2;
        this.f1932.f9842.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f1932.f9846.getLayoutParams();
        layoutParams6.topMargin = C4792.m14375().m14476(20);
        this.f1932.f9846.setLayoutParams(layoutParams6);
        ViewGroup.LayoutParams layoutParams7 = this.f1932.f9841.getLayoutParams();
        layoutParams7.height = C4792.m14375().m14476(100);
        layoutParams7.width = C4792.m14375().m14476(TypedValues.CycleType.TYPE_EASING);
        this.f1932.f9841.setLayoutParams(layoutParams7);
        this.f1932.f9841.setTextColor(-1);
        this.f1932.f9841.m2327(0, C4792.m14375().m14386());
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f1932.f9843.getLayoutParams();
        layoutParams8.topMargin = C4792.m14375().m14476(20);
        layoutParams8.leftMargin = C4792.m14375().m14476(90);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f1932.f9848.getLayoutParams();
        layoutParams9.height = C4792.m14375().m14405();
        this.f1932.f9848.setLayoutParams(layoutParams9);
        this.f1932.f9845.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f1932.f9849.getLayoutParams();
        layoutParams10.width = C4792.m14375().m14476(1000);
        layoutParams10.height = C4792.m14375().m14405();
        this.f1932.f9849.setLayoutParams(layoutParams10);
        m2134();
        m2135();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m2134() {
        this.f1933 = new C3227(getContext(), this.f1936, new C0860());
        this.f1935 = new C4194(getContext(), this.f1937, new C0861());
        this.f1932.f9842.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        AutoLineFeedLayoutManager autoLineFeedLayoutManager = new AutoLineFeedLayoutManager();
        this.f1944 = autoLineFeedLayoutManager;
        this.f1932.f9840.setLayoutManager(autoLineFeedLayoutManager);
        this.f1932.f9842.setAdapter(this.f1933);
        this.f1932.f9840.setAdapter(this.f1935);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m2135() {
        this.f1932.f9839.setOnCheckedChangeListener(new C0856());
        this.f1932.f9849.setOnProChange(new C0857());
        this.f1932.f9849.setOnTouchStateChange(new C0858());
        this.f1932.f9841.setOnStopClick(new C0859());
    }

    /* renamed from: އ, reason: contains not printable characters */
    public boolean m2136() {
        return this.f1946;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final float m2137() {
        float fMeasureText;
        int iM14386;
        Paint paint = new Paint();
        paint.setTextSize(C4792.m14375().m14386());
        paint.setTypeface(FilmApp.m404());
        Iterator<C4196> it = this.f1937.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            C4196 next = it.next();
            if (next.m13233() != 0) {
                fMeasureText = paint.measureText(FilmApp.m402().getResources().getString(next.m13233()));
                iM14386 = C4792.m14375().m14386();
            } else {
                fMeasureText = paint.measureText(next.m13232());
                iM14386 = C4792.m14375().m14386();
            }
            f += fMeasureText + (iM14386 * 2) + 2.0f;
        }
        float fM9438 = C2579.f9598 - (C2579.m9438(15.0f) * 2);
        if (f > fM9438) {
            return fM9438 / f;
        }
        return 1.0f;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m2138() {
        if (r1.m8144(this.f1938) && r1.m8144(this.f1940)) {
            C3444.m11227().m11263(C4535.m13880().m13890().m12377());
            float fM11237 = C3444.m11227().m11237();
            FilmSeekBar filmSeekBar = this.f1932.f9849;
            ArrayList<Integer> arrayList = this.f1938;
            filmSeekBar.setMax(arrayList.get(arrayList.size() - 1).intValue() * 10);
            this.f1932.f9849.setMin(0.0f);
            float f = 100.0f * fM11237;
            this.f1932.f9849.setValueAndUpdateUI(f * 10.0f);
            this.f1932.f9841.setStringDataList(this.f1940);
            this.f1932.f9841.m2326(fM11237 * 10.0f, false, Math.round(f) + "%");
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m2139() throws JSONException {
        this.f1937.clear();
        C5075.m14899().m14905();
        boolean zM14903 = C5075.m14899().m14903();
        boolean zM14902 = C5075.m14899().m14902();
        ArrayList<C5080> arrayListM11239 = C3444.m11227().m11239();
        int iM2131 = m2131(C3444.m11227().m11242());
        for (int i = 0; i < arrayListM11239.size(); i++) {
            C5080 c5080 = arrayListM11239.get(i);
            C4196 c4196 = new C4196();
            c4196.m13239(c5080);
            c4196.m13251(c5080.m14908());
            c4196.m13252(c5080.m14909());
            if (c5080.getType() == 1) {
                c4196.m13242(!zM14903);
            } else if (c5080.getType() == 2) {
                c4196.m13242(!zM14902);
            } else {
                c4196.m13242(false);
                if (!zM14903 && !zM14902) {
                    iM2131 = 0;
                }
            }
            c4196.setItemViewType(6);
            c4196.setSelected(c5080.getType() == iM2131);
            if (c5080.getType() == iM2131) {
                this.f1939 = iM2131;
            }
            this.f1937.add(c4196);
        }
        m2141();
        C4194 c4194 = this.f1935;
        if (c4194 != null) {
            c4194.notifyDataSetChanged();
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m2140() throws JSONException {
        this.f1936.clear();
        this.f1938.clear();
        this.f1940.clear();
        C2685 c2685 = new C2685(0, getContext().getString(R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE).toUpperCase(), R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE);
        c2685.setSelected(true);
        this.f1934 = 0;
        this.f1936.add(c2685);
        C2685 c26852 = new C2685(1, getContext().getString(R.string.RECORDING_SETTINGS_AUDIO_LEVEL).toUpperCase(), R.string.RECORDING_SETTINGS_AUDIO_LEVEL);
        c26852.setSelected(false);
        this.f1936.add(c26852);
        for (int i = 0; i <= 10; i++) {
            int i2 = i * 10;
            this.f1938.add(Integer.valueOf(i2));
            this.f1940.add(i2 + "%");
        }
        setShowView(true);
        C3227 c3227 = this.f1933;
        if (c3227 != null) {
            c3227.notifyDataSetChanged();
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m2141() {
        float fM2137 = m2137();
        Iterator<C4196> it = this.f1937.iterator();
        while (it.hasNext()) {
            C4196 next = it.next();
            next.m13243((int) (C4792.m14375().m14386() * fM2137));
            next.m13248((int) (C4792.m14375().m14386() * fM2137));
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m2142(int i) {
        this.f1946 = true;
        C4008.m12886(this, 0.0f, 0.0f, i, new C0862());
    }

    public AudioSettingPortraitView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudioSettingPortraitView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1936 = new ArrayList<>();
        this.f1937 = new ArrayList<>();
        this.f1938 = new ArrayList<>();
        this.f1940 = new ArrayList<>();
        m2133(context, attributeSet, i);
    }
}
