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
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4414;
import defpackage.AbstractC4975;
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
import org.json.JSONException;

/* loaded from: classes.dex */
public class AudioSettingView extends FrameLayout implements View.OnClickListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4414 f1955;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C3227 f1956;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1957;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4194 f1958;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<C2685> f1959;

    /* renamed from: ՠ, reason: contains not printable characters */
    public ArrayList<C4196> f1960;

    /* renamed from: ֈ, reason: contains not printable characters */
    public ArrayList<Integer> f1961;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f1962;

    /* renamed from: ׯ, reason: contains not printable characters */
    public ArrayList<String> f1963;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f1964;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f1965;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f1966;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f1967;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f1968;

    /* renamed from: ބ, reason: contains not printable characters */
    public InterfaceC0870 f1969;

    /* renamed from: com.blink.academy.film.widgets.AudioSettingView$Ϳ, reason: contains not printable characters */
    public class C0863 implements SwitchButton.InterfaceC0969 {
        public C0863() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            InterfaceC0870 interfaceC0870;
            InterfaceC0870 interfaceC08702 = AudioSettingView.this.f1969;
            if ((interfaceC08702 == null || interfaceC08702.mo2178()) && (interfaceC0870 = AudioSettingView.this.f1969) != null) {
                interfaceC0870.mo2177(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingView$Ԩ, reason: contains not printable characters */
    public class C0864 implements FilmSeekBar.InterfaceC0896 {
        public C0864() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            InterfaceC0870 interfaceC0870 = AudioSettingView.this.f1969;
            if (interfaceC0870 == null || interfaceC0870.mo2178()) {
                AudioSettingView.this.f1955.f15214.m2326(f2 / 100.0f, false, Math.round(f2 / 10.0f) + "%");
                AudioSettingView.this.f1964 = (f2 * 1.0f) / 1000.0f;
                AudioSettingView audioSettingView = AudioSettingView.this;
                InterfaceC0870 interfaceC08702 = audioSettingView.f1969;
                if (interfaceC08702 != null) {
                    interfaceC08702.mo2179(audioSettingView.f1964);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingView$Ԫ, reason: contains not printable characters */
    public class C0865 implements FilmSeekBar.InterfaceC0897 {
        public C0865() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ϳ */
        public void mo2145() {
            InterfaceC0870 interfaceC0870 = AudioSettingView.this.f1969;
            if (interfaceC0870 != null) {
                interfaceC0870.mo2175();
            }
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ԩ */
        public void mo2146() {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingView$Ԭ, reason: contains not printable characters */
    public class C0866 implements FilmStopView.InterfaceC0908 {
        public C0866() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return !AudioSettingView.this.f1955.f15221.m2303();
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            InterfaceC0870 interfaceC0870 = AudioSettingView.this.f1969;
            if ((interfaceC0870 == null || interfaceC0870.mo2178()) && r1.m8144(AudioSettingView.this.f1963)) {
                int iIntValue = ((Integer) AudioSettingView.this.f1961.get(i)).intValue();
                AudioSettingView.this.f1955.f15214.setCurrentI(i);
                AudioSettingView.this.f1955.f15221.setValueAndUpdateUI(iIntValue * 10);
                AudioSettingView.this.f1964 = iIntValue / 100.0f;
                AudioSettingView audioSettingView = AudioSettingView.this;
                InterfaceC0870 interfaceC08702 = audioSettingView.f1969;
                if (interfaceC08702 != null) {
                    interfaceC08702.mo2179(audioSettingView.f1964);
                    AudioSettingView.this.f1969.mo2175();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingView$Ԯ, reason: contains not printable characters */
    public class C0867 implements AbstractC4975.InterfaceC4976 {
        public C0867() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) throws JSONException {
            C2685 c2685 = (C2685) AudioSettingView.this.f1959.get(i);
            if (c2685 == null || c2685.isSelected() || AudioSettingView.this.f1957 == i) {
                return;
            }
            ((C2685) AudioSettingView.this.f1959.get(AudioSettingView.this.f1957)).setSelected(false);
            ((C3502) AudioSettingView.this.f1955.f15215.findViewHolderForAdapterPosition(AudioSettingView.this.f1957)).m11440(false);
            c2685.setSelected(true);
            ((C3502) AudioSettingView.this.f1955.f15215.findViewHolderForAdapterPosition(i)).m11440(c2685.isSelected());
            AudioSettingView.this.setShowView(c2685.getType() == 0);
            AudioSettingView.this.f1957 = i;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingView$ՠ, reason: contains not printable characters */
    public class C0868 implements AbstractC4975.InterfaceC4976 {
        public C0868() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            InterfaceC0870 interfaceC0870 = AudioSettingView.this.f1969;
            if ((interfaceC0870 == null || interfaceC0870.mo2178()) && AudioSettingView.this.f1962 != i) {
                ((C4196) AudioSettingView.this.f1960.get(AudioSettingView.this.f1962)).setSelected(false);
                ((C4734) AudioSettingView.this.f1955.f15213.findViewHolderForAdapterPosition(AudioSettingView.this.f1962)).mo8729(false);
                C4196 c4196 = (C4196) AudioSettingView.this.f1960.get(i);
                c4196.setSelected(true);
                ((C4734) AudioSettingView.this.f1955.f15213.findViewHolderForAdapterPosition(i)).mo8729(true);
                C5080 c5080M13221 = c4196.m13221();
                InterfaceC0870 interfaceC08702 = AudioSettingView.this.f1969;
                if (interfaceC08702 != null) {
                    interfaceC08702.mo2180(c5080M13221.getType());
                }
                AudioSettingView.this.f1962 = i;
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingView$ֈ, reason: contains not printable characters */
    public class C0869 extends AbstractC4012 {
        public C0869() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) throws JSONException {
            super.onAnimationEnd(view);
            if (AudioSettingView.this.f1956 != null) {
                AudioSettingView.this.f1956.notifyDataSetChanged();
            }
            if (AudioSettingView.this.f1958 != null) {
                AudioSettingView.this.f1958.notifyDataSetChanged();
            }
            C3891 c3891M13890 = C4535.m13880().m13890();
            AudioSettingView.this.f1965 = c3891M13890.m12460() == 1;
            AudioSettingView.this.f1966 = c3891M13890.m12471() != 0;
            AudioSettingView audioSettingView = AudioSettingView.this;
            audioSettingView.setShowView(audioSettingView.f1957 == 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.AudioSettingView$֏, reason: contains not printable characters */
    public interface InterfaceC0870 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo2175();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo2176(int i);

        /* renamed from: ނ, reason: contains not printable characters */
        void mo2177(boolean z);

        /* renamed from: ވ, reason: contains not printable characters */
        boolean mo2178();

        /* renamed from: ފ, reason: contains not printable characters */
        void mo2179(float f);

        /* renamed from: ތ, reason: contains not printable characters */
        void mo2180(int i);
    }

    public AudioSettingView(@NonNull Context context) {
        this(context, null);
    }

    private void setEnable(boolean z) {
        float f = z ? 0.2f : 1.0f;
        if (z) {
            this.f1955.f15214.m2318();
        } else {
            this.f1955.f15214.m2320();
        }
        this.f1955.f15221.setAlpha(f);
        this.f1955.f15221.setEnabled(!z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowView(boolean z) throws JSONException {
        float f = z ? 1.0f : 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        this.f1955.f15213.setAlpha(f);
        this.f1955.f15213.setEnabled(z);
        this.f1955.f15214.setAlpha(f2);
        if ((this.f1965 || this.f1966) && !z) {
            f2 = 0.2f;
        }
        this.f1955.f15221.setAlpha(f2);
        this.f1955.f15217.setAlpha(f2);
        this.f1955.f15212.setAlpha(f2);
        boolean z2 = (z || this.f1965 || this.f1966) ? false : true;
        this.f1955.f15221.setEnabled(z2);
        this.f1955.f15217.setEnabled(z2);
        this.f1955.f15212.setEnabled(z2);
        if (!z) {
            this.f1955.f15212.setEnabled(true);
            boolean zM11254 = C3444.m11227().m11254();
            C3485 c3485M12731 = C3947.m12727().m12731();
            if (c3485M12731 == null || !c3485M12731.m11381()) {
                this.f1955.f15212.setVisibility(8);
                this.f1955.f15217.setVisibility(8);
            } else {
                C3891 c3891M13890 = C4535.m13880().m13890();
                if (c3891M13890.m12460() == 1 || c3891M13890.m12471() != 0) {
                    this.f1955.f15212.m2630(false, false);
                    this.f1955.f15212.setEnabled(false);
                } else {
                    this.f1955.f15212.m2630(false, zM11254);
                    this.f1955.f15212.setEnabled(z2);
                }
            }
        }
        if (z) {
            m2172();
        } else {
            m2171();
        }
        this.f1955.f15214.setEnabled(true);
        if (z2) {
            this.f1955.f15214.m2320();
        } else {
            this.f1955.f15214.m2318();
        }
    }

    public int getAudioSettingHeight() {
        return (C4792.m14375().m14406() + C4792.m14375().m14408()) - C4792.m14375().m14476(35);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1967 = i2;
        if (this.f1968) {
            return;
        }
        m2166(0, null);
    }

    public void setAudioChangeListener(InterfaceC0870 interfaceC0870) {
        this.f1969 = interfaceC0870;
    }

    public void setPadding(int i) {
        LinearLayout linearLayout = this.f1955.f15218;
        if (linearLayout != null) {
            linearLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final int m2165(int i) {
        if (i == 0) {
            InterfaceC0870 interfaceC0870 = this.f1969;
            if (interfaceC0870 != null) {
                interfaceC0870.mo2176(0);
            }
        } else {
            if (i == 1) {
                if (!C5075.m14899().m14903()) {
                    if (C5075.m14899().m14902()) {
                        InterfaceC0870 interfaceC08702 = this.f1969;
                        if (interfaceC08702 != null) {
                            interfaceC08702.mo2176(2);
                        }
                        C3444.m11227().m11264(2);
                        return 2;
                    }
                    InterfaceC0870 interfaceC08703 = this.f1969;
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
                    InterfaceC0870 interfaceC08704 = this.f1969;
                    if (interfaceC08704 != null) {
                        interfaceC08704.mo2176(1);
                    }
                    C3444.m11227().m11264(1);
                    return 1;
                }
                InterfaceC0870 interfaceC08705 = this.f1969;
                if (interfaceC08705 != null) {
                    interfaceC08705.mo2176(0);
                }
                C3444.m11227().m11264(0);
            }
        }
        return 0;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m2166(int i, AbstractC4012 abstractC4012) {
        this.f1968 = false;
        C4008.m12886(this, 0.0f, this.f1967, i, abstractC4012);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m2167(Context context, AttributeSet attributeSet, int i) {
        AbstractC4414 abstractC4414 = (AbstractC4414) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_audio_setting, this, true);
        this.f1955 = abstractC4414;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) abstractC4414.f15220.getLayoutParams();
        layoutParams.bottomMargin = C4792.m14375().m14408();
        this.f1955.f15220.m2562(0, C4792.m14375().m14381());
        AbstractC4414 abstractC44142 = this.f1955;
        LinearLayout linearLayout = abstractC44142.f15218;
        layoutParams.width = (int) (abstractC44142.f15220.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_TITLE_AUDIO).toUpperCase()) + C4792.f16138);
        this.f1955.f15220.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        layoutParams2.height = C4792.m14375().m14406();
        this.f1955.f15218.setLayoutParams(layoutParams2);
        setOnClickListener(this);
        this.f1955.f15217.setContentTextColor(-1);
        this.f1955.f15217.m2562(0, C4792.m14375().m14482());
        int iM14420 = C4792.m14375().m14420();
        ViewGroup.LayoutParams layoutParams3 = this.f1955.f15217.getLayoutParams();
        TextPaint paint = this.f1955.f15217.getPaint();
        layoutParams3.width = (int) (paint.measureText(context.getString(R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE_AUTO_GAIN).toUpperCase()) + iM14420 + C4792.f16138);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        layoutParams3.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f1955.f15217.setLayoutParams(layoutParams3);
        this.f1955.f15212.setTextSize(C4792.m14375().m14481());
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f1955.f15212.getLayoutParams();
        layoutParams4.width = C4792.m14375().m14410();
        layoutParams4.height = C4792.m14375().m14409();
        layoutParams4.topMargin = C4792.m14375().m14411();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f1955.f15215.getLayoutParams();
        layoutParams5.width = -2;
        this.f1955.f15215.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f1955.f15219.getLayoutParams();
        layoutParams6.topMargin = C4792.m14375().m14476(20);
        this.f1955.f15219.setLayoutParams(layoutParams6);
        ViewGroup.LayoutParams layoutParams7 = this.f1955.f15214.getLayoutParams();
        layoutParams7.height = C4792.m14375().m14476(100);
        layoutParams7.width = C4792.m14375().m14476(TypedValues.CycleType.TYPE_EASING);
        this.f1955.f15214.setLayoutParams(layoutParams7);
        this.f1955.f15214.setTextColor(-1);
        this.f1955.f15214.m2327(0, C4792.m14375().m14386());
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f1955.f15216.getLayoutParams();
        layoutParams8.topMargin = C4792.m14375().m14476(20);
        layoutParams8.leftMargin = C4792.m14375().m14476(90);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f1955.f15221.getLayoutParams();
        layoutParams9.width = C4792.m14375().m14476(1000);
        layoutParams9.leftMargin = C4792.m14375().m14476(70);
        this.f1955.f15221.setLayoutParams(layoutParams9);
        m2168();
        m2169();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m2168() {
        this.f1956 = new C3227(getContext(), this.f1959, new C0867());
        this.f1958 = new C4194(getContext(), this.f1960, new C0868());
        this.f1955.f15215.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f1955.f15213.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f1955.f15215.setAdapter(this.f1956);
        this.f1955.f15213.setAdapter(this.f1958);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m2169() {
        this.f1955.f15212.setOnCheckedChangeListener(new C0863());
        this.f1955.f15221.setOnProChange(new C0864());
        this.f1955.f15221.setOnTouchStateChange(new C0865());
        this.f1955.f15214.setOnStopClick(new C0866());
    }

    /* renamed from: އ, reason: contains not printable characters */
    public boolean m2170() {
        return this.f1968;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m2171() {
        if (r1.m8144(this.f1961) && r1.m8144(this.f1963)) {
            C3444.m11227().m11263(C4535.m13880().m13890().m12377());
            float fM11237 = C3444.m11227().m11237();
            FilmSeekBar filmSeekBar = this.f1955.f15221;
            ArrayList<Integer> arrayList = this.f1961;
            filmSeekBar.setMax(arrayList.get(arrayList.size() - 1).intValue() * 10);
            this.f1955.f15221.setMin(0.0f);
            float f = 100.0f * fM11237;
            this.f1955.f15221.setValueAndUpdateUI(f * 10.0f);
            this.f1955.f15214.setStringDataList(this.f1963);
            this.f1955.f15214.m2326(fM11237 * 10.0f, false, Math.round(f) + "%");
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m2172() throws JSONException {
        this.f1960.clear();
        C5075.m14899().m14905();
        boolean zM14903 = C5075.m14899().m14903();
        boolean zM14902 = C5075.m14899().m14902();
        ArrayList<C5080> arrayListM11239 = C3444.m11227().m11239();
        int iM2165 = m2165(C3444.m11227().m11242());
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
                    iM2165 = 0;
                }
            }
            c4196.setSelected(c5080.getType() == iM2165);
            if (c5080.getType() == iM2165) {
                this.f1962 = iM2165;
            }
            this.f1960.add(c4196);
        }
        C4194 c4194 = this.f1958;
        if (c4194 != null) {
            c4194.notifyDataSetChanged();
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m2173() throws JSONException {
        this.f1959.clear();
        this.f1961.clear();
        this.f1963.clear();
        C2685 c2685 = new C2685(0, getContext().getString(R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE).toUpperCase(), R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE);
        c2685.setSelected(true);
        this.f1957 = 0;
        this.f1959.add(c2685);
        C2685 c26852 = new C2685(1, getContext().getString(R.string.RECORDING_SETTINGS_AUDIO_LEVEL).toUpperCase(), R.string.RECORDING_SETTINGS_AUDIO_LEVEL);
        c26852.setSelected(false);
        this.f1959.add(c26852);
        for (int i = 0; i <= 10; i++) {
            int i2 = i * 10;
            this.f1961.add(Integer.valueOf(i2));
            this.f1963.add(i2 + "%");
        }
        setShowView(true);
        C3227 c3227 = this.f1956;
        if (c3227 != null) {
            c3227.notifyDataSetChanged();
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m2174(int i) {
        this.f1968 = true;
        C4008.m12886(this, 0.0f, 0.0f, i, new C0869());
    }

    public AudioSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudioSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1959 = new ArrayList<>();
        this.f1960 = new ArrayList<>();
        this.f1961 = new ArrayList<>();
        this.f1963 = new ArrayList<>();
        m2167(context, attributeSet, i);
    }
}
