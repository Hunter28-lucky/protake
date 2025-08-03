package com.blink.academy.film.widgets.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blink.academy.protake.R;
import defpackage.AbstractC4140;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C3637;
import defpackage.C4489;
import defpackage.C4567;
import defpackage.C4792;
import defpackage.C4841;
import defpackage.C5101;
import defpackage.InterfaceC4172;
import defpackage.r1;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SettingProtakeFocusDialog extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4140 f2962;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f2963;

    /* renamed from: ԭ, reason: contains not printable characters */
    public LinearLayoutManager f2964;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4841 f2965;

    /* renamed from: ԯ, reason: contains not printable characters */
    public List<C3637> f2966;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC1059 f2967;

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$Ϳ, reason: contains not printable characters */
    public class RunnableC1049 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2968;

        public RunnableC1049(String str) {
            this.f2968 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingProtakeFocusDialog.this.f2962.f14340.getPaint().measureText(this.f2968);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingProtakeFocusDialog.this.f2962.f14340.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingProtakeFocusDialog.this.f2962.f14340.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingProtakeFocusDialog.this.f2962.f14336.getLayoutParams();
            int i = layoutParams.rightMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f) + layoutParams.bottomMargin;
            SettingProtakeFocusDialog.this.f2962.f14336.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$Ԩ, reason: contains not printable characters */
    public class RunnableC1050 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2970;

        public RunnableC1050(String str) {
            this.f2970 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingProtakeFocusDialog.this.f2962.f14339.getPaint().measureText(this.f2970);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingProtakeFocusDialog.this.f2962.f14339.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingProtakeFocusDialog.this.f2962.f14339.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingProtakeFocusDialog.this.f2962.f14335.getLayoutParams();
            int i = layoutParams.leftMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f) + layoutParams.bottomMargin;
            SettingProtakeFocusDialog.this.f2962.f14335.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$Ԫ, reason: contains not printable characters */
    public class RunnableC1051 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2972;

        public RunnableC1051(String str) {
            this.f2972 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingProtakeFocusDialog.this.f2962.f14340.getPaint().measureText(this.f2972);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingProtakeFocusDialog.this.f2962.f14340.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingProtakeFocusDialog.this.f2962.f14340.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingProtakeFocusDialog.this.f2962.f14336.getLayoutParams();
            int i = layoutParams.rightMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f) + layoutParams.bottomMargin;
            SettingProtakeFocusDialog.this.f2962.f14336.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$Ԭ, reason: contains not printable characters */
    public class RunnableC1052 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2974;

        public RunnableC1052(String str) {
            this.f2974 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingProtakeFocusDialog.this.f2962.f14339.getPaint().measureText(this.f2974);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingProtakeFocusDialog.this.f2962.f14339.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingProtakeFocusDialog.this.f2962.f14339.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingProtakeFocusDialog.this.f2962.f14335.getLayoutParams();
            int i = layoutParams.leftMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f) + layoutParams.bottomMargin;
            SettingProtakeFocusDialog.this.f2962.f14335.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$Ԯ, reason: contains not printable characters */
    public class C1053 implements InterfaceC4172 {
        public C1053() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if (r1.m8144(SettingProtakeFocusDialog.this.f2966)) {
                C3637 c3637 = (C3637) SettingProtakeFocusDialog.this.f2966.get(i);
                C4489 c4489M11702 = c3637.m11702();
                C4489 c4489M117022 = null;
                int i2 = -1;
                for (int i3 = 0; i3 < SettingProtakeFocusDialog.this.f2966.size(); i3++) {
                    C3637 c36372 = (C3637) SettingProtakeFocusDialog.this.f2966.get(i3);
                    if (c3637.m11703()) {
                        i2 = i3;
                    } else if (c36372.m11702() != null && c36372.m11702().m13774()) {
                        c4489M117022 = c36372.m11702();
                        i2 = i3;
                    }
                }
                if (i2 != -1) {
                    ((C3637) SettingProtakeFocusDialog.this.f2966.get(i2)).m11704(false);
                    if (c4489M117022 != null) {
                        C2618.m9573("protake_focus_his_sp", "");
                        c4489M117022.m13767();
                        C4567.m14006().m14017();
                    }
                    SettingProtakeFocusDialog.this.f2962.f14340.setAlpha(0.2f);
                    SettingProtakeFocusDialog.this.f2962.f14336.setEnabled(false);
                    SettingProtakeFocusDialog.this.f2965.notifyDataSetChanged();
                    if (i2 == i) {
                        return;
                    }
                }
                if (c4489M11702 == null || c4489M11702.m13774()) {
                    return;
                }
                c3637.m11704(true);
                SettingProtakeFocusDialog.this.f2965.notifyDataSetChanged();
                C4567.m14006().m14016(c3637);
                if (SettingProtakeFocusDialog.this.f2967 != null) {
                    SettingProtakeFocusDialog.this.f2967.mo1732();
                }
            }
        }

        @Override // defpackage.InterfaceC4172
        /* renamed from: ՠ */
        public void mo1559(int i, int i2, Object obj) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1054 implements View.OnClickListener {
        public ViewOnClickListenerC1054() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingProtakeFocusDialog.this.f2962.f14335.performClick();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1055 implements View.OnClickListener {
        public ViewOnClickListenerC1055() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingProtakeFocusDialog.this.f2967 != null) {
                SettingProtakeFocusDialog.this.f2967.mo1733();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC1056 implements View.OnClickListener {
        public ViewOnClickListenerC1056() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(SettingProtakeFocusDialog.this.f2966)) {
                for (C3637 c3637 : SettingProtakeFocusDialog.this.f2966) {
                    if (c3637.m11703()) {
                        c3637.m11704(false);
                        C4489 c4489M11702 = c3637.m11702();
                        if (c4489M11702 != null) {
                            c4489M11702.m13767();
                            C4567.m14006().m14017();
                        }
                        SettingProtakeFocusDialog.this.f2965.notifyDataSetChanged();
                        return;
                    }
                }
            }
            if (SettingProtakeFocusDialog.this.f2967 != null) {
                SettingProtakeFocusDialog.this.f2967.mo1731();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$ׯ, reason: contains not printable characters */
    public class C1057 implements C4567.InterfaceC4573 {

        /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$ׯ$Ϳ, reason: contains not printable characters */
        public class RunnableC1058 implements Runnable {
            public RunnableC1058() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SettingProtakeFocusDialog.this.f2965 != null) {
                    SettingProtakeFocusDialog.this.f2965.notifyDataSetChanged();
                }
                SettingProtakeFocusDialog.this.f2962.f14340.setAlpha(0.2f);
                SettingProtakeFocusDialog.this.f2962.f14336.setEnabled(false);
                if (r1.m8144(SettingProtakeFocusDialog.this.f2966)) {
                    Iterator it = SettingProtakeFocusDialog.this.f2966.iterator();
                    while (it.hasNext()) {
                        C4489 c4489M11702 = ((C3637) it.next()).m11702();
                        if (c4489M11702 != null && c4489M11702.m13774()) {
                            SettingProtakeFocusDialog.this.f2962.f14340.setAlpha(1.0f);
                            SettingProtakeFocusDialog.this.f2962.f14336.setEnabled(true);
                        }
                    }
                }
            }
        }

        public C1057() {
        }

        @Override // defpackage.C4567.InterfaceC4573
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo2922() {
            if (SettingProtakeFocusDialog.this.f2967 != null) {
                SettingProtakeFocusDialog.this.f2967.mo1730();
            }
        }

        @Override // defpackage.C4567.InterfaceC4573
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo2923() {
            SettingProtakeFocusDialog.this.post(new RunnableC1058());
        }

        @Override // defpackage.C4567.InterfaceC4573
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo2924() {
            if (SettingProtakeFocusDialog.this.f2967 != null) {
                SettingProtakeFocusDialog.this.f2967.mo1729();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog$ؠ, reason: contains not printable characters */
    public interface InterfaceC1059 {
        /* renamed from: Ϳ */
        void mo1729();

        /* renamed from: Ԩ */
        void mo1730();

        /* renamed from: ԩ */
        void mo1731();

        /* renamed from: Ԫ */
        void mo1732();

        /* renamed from: ԫ */
        void mo1733();
    }

    public SettingProtakeFocusDialog(Context context) {
        this(context, null);
    }

    public void setOnCallback(InterfaceC1059 interfaceC1059) {
        this.f2967 = interfaceC1059;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2914() {
        C4567.m14006().m14020(null);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m2915() {
        this.f2962 = AbstractC4140.m13117(LayoutInflater.from(getContext()), this, true);
        m2917();
        m2919();
        m2918();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2916() {
        this.f2966 = C4567.m14006().m14014();
        this.f2965 = new C4841(getContext(), this.f2966, new C1053());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m2917() {
        int iM9440 = C2579.m9440(getContext());
        C2579.m9444();
        float f = iM9440;
        int i = (int) (((int) (0.75567424f * f)) * 1.1996466f);
        ViewGroup.LayoutParams layoutParams = this.f2962.f14337.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = (int) (0.89750445f * f);
        this.f2962.f14337.setLayoutParams(layoutParams);
        this.f2962.f14340.setContentTextColor(-1);
        this.f2962.f14340.m2562(0, C4792.m14375().m14419());
        this.f2962.f14339.setContentTextColor(-1);
        this.f2962.f14339.m2562(0, C4792.m14375().m14419());
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2962.f14340.getLayoutParams();
        float f2 = i;
        int i2 = (int) (0.10309278f * f2);
        layoutParams2.rightMargin = i2;
        int i3 = (int) (0.08836524f * f2);
        layoutParams2.bottomMargin = i3;
        int i4 = (int) (f2 * 0.095729016f);
        layoutParams2.topMargin = i4;
        this.f2962.f14340.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2962.f14339.getLayoutParams();
        layoutParams3.leftMargin = i2;
        layoutParams3.bottomMargin = i3;
        layoutParams3.topMargin = i4;
        this.f2962.f14339.setLayoutParams(layoutParams3);
        this.f2962.f14338.setPadding(i2, 0, i2, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2962.f14338.getLayoutParams();
        layoutParams4.topMargin = (int) (0.053475935f * f);
        layoutParams4.height = (int) (f * 0.657754f);
        this.f2962.f14338.setLayoutParams(layoutParams4);
        String upperCase = getResources().getString(R.string.BUTTON_OK).toUpperCase();
        String upperCase2 = getResources().getString(R.string.BUTTON_CANCEL).toUpperCase();
        this.f2962.f14339.setText(upperCase2);
        this.f2962.f14340.setText(upperCase);
        this.f2962.f14340.post(new RunnableC1051(upperCase));
        this.f2962.f14339.post(new RunnableC1052(upperCase2));
        this.f2962.f14340.setDrawBorder(false);
        this.f2962.f14339.setDrawBorder(false);
        this.f2962.f14340.setAlpha(0.2f);
        this.f2962.f14336.setEnabled(false);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m2918() {
        setOnClickListener(new ViewOnClickListenerC1054());
        this.f2962.f14336.setOnClickListener(new ViewOnClickListenerC1055());
        this.f2962.f14335.setOnClickListener(new ViewOnClickListenerC1056());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m2919() {
        m2916();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.f2964 = linearLayoutManager;
        this.f2962.f14338.setLayoutManager(linearLayoutManager);
        this.f2962.f14338.setNestedScrollingEnabled(false);
        this.f2962.f14338.setAdapter(this.f2965);
        C5101 c5101 = new C5101(getContext(), 1);
        c5101.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.zhiyun_divider_item));
        this.f2962.f14338.addItemDecoration(c5101);
        this.f2962.f14338.setOverScrollMode(2);
        ((SimpleItemAnimator) this.f2962.f14338.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f2962.f14338.getItemAnimator().setChangeDuration(0L);
        this.f2962.f14338.setItemAnimator(null);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m2920(boolean z) {
        this.f2963 = z;
        int iM9445 = (int) (C2579.m9445() * 0.80515295f);
        ViewGroup.LayoutParams layoutParams = this.f2962.f14337.getLayoutParams();
        layoutParams.width = iM9445;
        float f = iM9445;
        layoutParams.height = (int) (0.67f * f);
        this.f2962.f14337.setLayoutParams(layoutParams);
        this.f2962.f14340.setContentTextColor(-1);
        this.f2962.f14340.m2562(0, C4792.m14375().m14419());
        this.f2962.f14339.setContentTextColor(-1);
        this.f2962.f14339.m2562(0, C4792.m14375().m14419());
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2962.f14340.getLayoutParams();
        int i = (int) (0.10309278f * f);
        layoutParams2.rightMargin = i;
        int i2 = (int) (0.08836524f * f);
        layoutParams2.bottomMargin = i2;
        int i3 = (int) (f * 0.095729016f);
        layoutParams2.topMargin = i3;
        this.f2962.f14340.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2962.f14339.getLayoutParams();
        layoutParams3.leftMargin = i;
        layoutParams3.bottomMargin = i2;
        layoutParams3.topMargin = i3;
        this.f2962.f14339.setLayoutParams(layoutParams3);
        this.f2962.f14338.setPadding(i, 0, i, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2962.f14338.getLayoutParams();
        int i4 = layoutParams.height;
        layoutParams4.topMargin = (int) (i4 * 0.08955224f);
        layoutParams4.height = (int) (i4 * 0.58208954f);
        this.f2962.f14338.setLayoutParams(layoutParams4);
        String upperCase = getResources().getString(R.string.BUTTON_OK).toUpperCase();
        String upperCase2 = getResources().getString(R.string.BUTTON_CANCEL).toUpperCase();
        this.f2962.f14339.setText(upperCase2);
        this.f2962.f14340.setText(upperCase);
        this.f2962.f14340.post(new RunnableC1049(upperCase));
        this.f2962.f14339.post(new RunnableC1050(upperCase2));
        this.f2962.f14340.setDrawBorder(false);
        this.f2962.f14339.setDrawBorder(false);
        this.f2962.f14340.setAlpha(0.2f);
        this.f2962.f14336.setEnabled(false);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m2921() {
        boolean z;
        C4567.m14006().m14020(new C1057());
        if (r1.m8144(this.f2966)) {
            Iterator<C3637> it = this.f2966.iterator();
            z = false;
            while (it.hasNext()) {
                if (it.next().m11702().m13774()) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.f2965.notifyDataSetChanged();
        if (z) {
            this.f2962.f14340.setAlpha(1.0f);
            this.f2962.f14336.setEnabled(true);
        } else {
            this.f2962.f14340.setAlpha(0.2f);
            this.f2962.f14336.setEnabled(false);
        }
        C4567.m14006().m14023();
    }

    public SettingProtakeFocusDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingProtakeFocusDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2915();
    }
}
