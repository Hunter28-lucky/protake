package com.blink.academy.film.widgets.iso;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;
import defpackage.AbstractC3669;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C3947;
import defpackage.C4008;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.r1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ISOView extends ConstraintLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3669 f3307;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public List<Integer> f3308;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3309;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f3310;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f3311;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f3312;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3313;

    /* renamed from: ֏, reason: contains not printable characters */
    public InterfaceC1185 f3314;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f3315;

    /* renamed from: ؠ, reason: contains not printable characters */
    public InterfaceC1186 f3316;

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$Ϳ, reason: contains not printable characters */
    public class C1177 implements FilmSeekBar.InterfaceC0896 {
        public C1177() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            if (r1.m8144(ISOView.this.f3308)) {
                C3947.m12727().m12787(f2);
                int i = (int) f2;
                ISOView.this.m3297(i);
                ISOView.this.m3296(i);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$Ԩ, reason: contains not printable characters */
    public class C1178 implements FilmSeekBar.InterfaceC0897 {
        public C1178() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ϳ */
        public void mo2145() {
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ԩ */
        public void mo2146() {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$Ԫ, reason: contains not printable characters */
    public class C1179 implements FilmStopView.InterfaceC0908 {
        public C1179() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            if (r1.m8144(ISOView.this.f3308)) {
                int iIntValue = ((Integer) ISOView.this.f3308.get(i)).intValue();
                float f = iIntValue;
                ISOView.this.f3307.f12716.setValueAndUpdateUI(f);
                C3947.m12727().m12787(f);
                C4535.m13880().m13915();
                ISOView.this.m3296(iIntValue);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$Ԭ, reason: contains not printable characters */
    public class C1180 implements SwitchButton.InterfaceC0969 {
        public C1180() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12779(z);
            ISOView.this.m3289(z);
            if (ISOView.this.f3314 != null) {
                ISOView.this.f3314.mo3301();
            }
            if (z || !r1.m8144(ISOView.this.f3308)) {
                return;
            }
            int iM12738 = (int) C3947.m12727().m12738();
            if (iM12738 < ((Integer) ISOView.this.f3308.get(0)).intValue()) {
                iM12738 = ((Integer) ISOView.this.f3308.get(0)).intValue();
            }
            ISOView.this.f3307.f12716.setValueAndUpdateUI(iM12738);
            ISOView.this.m3297(iM12738);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1181 implements View.OnClickListener {
        public ViewOnClickListenerC1181() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$ՠ, reason: contains not printable characters */
    public class RunnableC1182 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3322;

        public RunnableC1182(String str) {
            this.f3322 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = ISOView.this.f3307.f12720.getPaint().measureText(this.f3322);
            ViewGroup.LayoutParams layoutParams = ISOView.this.f3307.f12720.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            ISOView.this.f3307.f12720.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$ֈ, reason: contains not printable characters */
    public class RunnableC1183 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3324;

        public RunnableC1183(String str) {
            this.f3324 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = ISOView.this.f3307.f12719.getPaint().measureText(this.f3324);
            ViewGroup.LayoutParams layoutParams = ISOView.this.f3307.f12719.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            ISOView.this.f3307.f12719.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$֏, reason: contains not printable characters */
    public class C1184 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f3326;

        public C1184(int i) {
            this.f3326 = i;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            ISOView.this.m3299();
            if (this.f3326 == 0 || ISOView.this.f3316 == null) {
                return;
            }
            ISOView.this.f3316.mo3302(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$ׯ, reason: contains not printable characters */
    public interface InterfaceC1185 {
        void onChange();

        /* renamed from: ֏, reason: contains not printable characters */
        void mo3301();
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ISOView$ؠ, reason: contains not printable characters */
    public interface InterfaceC1186 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo3302(boolean z);
    }

    public ISOView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3313 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f3315) {
            return;
        }
        m3291(0, null);
    }

    public void setIsoViewEnable(boolean z) {
        boolean zM12765 = C3947.m12727().m12765();
        if (z) {
            this.f3307.f12715.setAlpha(1.0f);
            this.f3307.f12715.setEnabled(true);
            this.f3307.f12715.m2630(false, zM12765);
            m3289(zM12765);
            return;
        }
        this.f3307.f12715.m2630(false, true);
        this.f3307.f12715.setEnabled(false);
        this.f3307.f12715.setAlpha(this.f3310);
        m3289(zM12765);
    }

    public void setOnISOChange(InterfaceC1185 interfaceC1185) {
        this.f3314 = interfaceC1185;
    }

    public void setOnVStateChange(InterfaceC1186 interfaceC1186) {
        this.f3316 = interfaceC1186;
    }

    public void setPadding(int i) {
        this.f3309 = i;
        ConstraintLayout constraintLayout = this.f3307.f12712;
        if (constraintLayout != null) {
            constraintLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m3289(boolean z) {
        if (z) {
            this.f3307.f12713.m2318();
            this.f3307.f12716.setEnabled(false);
            this.f3307.f12716.setPaintAlpha(this.f3310);
        } else {
            this.f3307.f12713.m2320();
            this.f3307.f12716.setEnabled(true);
            this.f3307.f12716.setPaintAlpha(1.0f);
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final float m3290(int i) {
        char c = 0;
        float f = 0.0f;
        if (r1.m8144(this.f3308)) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f3308.size()) {
                    break;
                }
                Integer num = this.f3308.get(i2);
                if (num.intValue() == i) {
                    f = i2;
                    c = 1;
                    break;
                }
                if (num.intValue() < i) {
                    f = i2;
                }
                if (num.intValue() > i) {
                    f = i2;
                    c = 2;
                    break;
                }
                i2++;
            }
        }
        if (c == 2) {
            f -= 0.5f;
        }
        if (!r1.m8144(this.f3308)) {
            return f;
        }
        List<Integer> list = this.f3308;
        return i > list.get(list.size() - 1).intValue() ? (this.f3308.size() - 1) + 0.5f : f;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3291(int i, AbstractC4012 abstractC4012) {
        InterfaceC1186 interfaceC1186;
        this.f3315 = false;
        C4008.m12886(this, 0.0f, this.f3313, i, abstractC4012);
        if (i == 0 || (interfaceC1186 = this.f3316) == null) {
            return;
        }
        interfaceC1186.mo3302(false);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m3292() {
        this.f3307 = AbstractC3669.m11780(LayoutInflater.from(getContext()), this, true);
        m3293();
        m3294();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m3293() {
        float fM14434 = C4792.m14375().m14434();
        boolean zM14498 = C4792.m14375().m14498();
        this.f3307.f12720.setContentTextColor(-1);
        this.f3307.f12720.m2562(0, C4792.m14375().m14381());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3307.f12712.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14408();
        this.f3307.f12719.setContentTextColor(-1);
        this.f3307.f12719.m2562(0, C4792.m14375().m14482());
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f3307.f12719.getLayoutParams())).topMargin = C4792.m14375().m14476(20);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f3307.f12715.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (C4792.m14375().m14409() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (C4792.m14375().m14410() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) (C4792.m14375().m14411() * fM14434);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f3307.f12713.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = C4792.m14375().m14476(100);
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = C4792.m14375().m14476(151);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = C4792.m14375().m14476(440);
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = C4792.m14375().m14476(40);
        this.f3307.f12713.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f3307.f12716.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = C4792.m14375().m14476(73);
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = C4792.m14375().m14476(870);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f3307.f12718.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = C4792.m14375().m14405();
        this.f3307.f12715.setTextSize(C4792.m14375().m14481());
        this.f3307.f12713.setTextColor(-1);
        this.f3307.f12713.m2327(0, C4792.m14375().m14386());
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f3307.f12717.getLayoutParams();
        if (zM14498) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = C4792.m14375().m14406();
            layoutParams5.leftToLeft = R.id.cl_content;
            layoutParams5.rightToRight = R.id.cl_content;
            this.f3307.f12718.setLayoutParams(layoutParams5);
            ((ViewGroup.MarginLayoutParams) layoutParams6).height = ((ViewGroup.MarginLayoutParams) layoutParams).height - ((ViewGroup.MarginLayoutParams) layoutParams5).height;
            layoutParams6.topToBottom = R.id.top_parent;
            layoutParams6.leftToLeft = R.id.cl_content;
            layoutParams6.rightToRight = R.id.cl_content;
            layoutParams4.topToTop = R.id.sb_parent;
            layoutParams4.bottomToBottom = R.id.sb_parent;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = C4792.m14375().m14405();
            layoutParams6.topToTop = R.id.top_parent;
            ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = (int) (((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((((ViewGroup.MarginLayoutParams) layoutParams3).height - ((ViewGroup.MarginLayoutParams) layoutParams4).height) / 2.0f));
            ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = C4792.m14375().m14476(130);
            layoutParams4.topToTop = R.id.sb_parent;
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = C4792.m14375().m14476(103);
            ((ViewGroup.MarginLayoutParams) layoutParams6).height = ((ViewGroup.MarginLayoutParams) layoutParams5).height;
        }
        this.f3307.f12717.setLayoutParams(layoutParams6);
        this.f3307.f12718.setLayoutParams(layoutParams5);
        this.f3307.f12715.setLayoutParams(layoutParams2);
        this.f3307.f12712.setLayoutParams(layoutParams);
        this.f3307.f12716.setLayoutParams(layoutParams4);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m3294() {
        this.f3307.f12716.setOnProChange(new C1177());
        this.f3307.f12716.setOnTouchStateChange(new C1178());
        this.f3307.f12713.setOnStopClick(new C1179());
        this.f3307.f12715.setOnCheckedChangeListener(new C1180());
        this.f3307.f12712.setOnClickListener(new ViewOnClickListenerC1181());
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean m3295() {
        return this.f3315;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m3296(int i) {
        InterfaceC1185 interfaceC1185 = this.f3314;
        if (interfaceC1185 != null) {
            interfaceC1185.onChange();
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m3297(int i) {
        if (r1.m8144(this.f3308)) {
            float fM3290 = m3290(i);
            this.f3307.f12713.m2326(fM3290, false, "" + ((int) C3947.m12727().m12738()));
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m3298() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f3312 < 30) {
            return;
        }
        this.f3312 = jCurrentTimeMillis;
        int iM12738 = (int) C3947.m12727().m12738();
        if (iM12738 < C3947.m12727().m12752()) {
            iM12738 = C3947.m12727().m12752();
        }
        this.f3307.f12716.setValueAndUpdateUI(iM12738);
        m3297(iM12738);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m3299() {
        String upperCase = getResources().getString(R.string.RECORDING_WHEELS_ISO).toUpperCase();
        this.f3307.f12720.setText(upperCase);
        this.f3307.f12720.post(new RunnableC1182(upperCase));
        List<Integer> listM12748 = C3947.m12727().m12748();
        this.f3308 = listM12748;
        if (!r1.m8144(listM12748)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("N/A");
            this.f3307.f12713.setStringDataList(arrayList);
            this.f3307.f12713.setCurrentI(0);
            this.f3307.f12713.m2318();
            return;
        }
        if (this.f3308.get(r0.size() - 1).intValue() < C3947.m12727().m12751()) {
            this.f3308.add(Integer.valueOf(C3947.m12727().m12751()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it = this.f3308.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next() + "");
        }
        this.f3307.f12713.setStringDataList(arrayList2);
        this.f3307.f12716.setMax(C3947.m12727().m12751());
        this.f3307.f12716.setMin(C3947.m12727().m12752());
        int iM12738 = (int) C3947.m12727().m12738();
        if (iM12738 < this.f3308.get(0).intValue()) {
            iM12738 = this.f3308.get(0).intValue();
        }
        this.f3307.f12716.setValueAndUpdateUI(iM12738);
        m3297(iM12738);
        boolean zM12765 = C3947.m12727().m12765();
        this.f3307.f12715.m2630(false, zM12765);
        m3289(zM12765);
        String upperCase2 = getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_AE).toUpperCase();
        this.f3307.f12719.m2561(upperCase2);
        this.f3307.f12719.post(new RunnableC1183(upperCase2));
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m3300(int i) {
        this.f3315 = true;
        C4008.m12886(this, 0.0f, 0.0f, i, new C1184(i));
    }

    public ISOView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ISOView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3310 = 0.2f;
        this.f3311 = 0.2f;
        m3292();
    }
}
