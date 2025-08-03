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
import com.blink.academy.film.home.HomeActivity;
import com.blink.academy.protake.R;
import com.zhiyun.sdk.device.Device;
import defpackage.AbstractC5237;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C3550;
import defpackage.C3760;
import defpackage.C4792;
import defpackage.C5101;
import defpackage.InterfaceC4172;
import defpackage.c9;
import defpackage.r1;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SettingGimbalDialog extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC5237 f2922;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public LinearLayoutManager f2923;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C3550 f2924;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public List<C3760> f2925;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f2926;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC1036 f2927;

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$Ϳ, reason: contains not printable characters */
    public class C1026 implements InterfaceC4172 {
        public C1026() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if (r1.m8144(SettingGimbalDialog.this.f2925)) {
                C3760 c3760 = (C3760) SettingGimbalDialog.this.f2925.get(i);
                Device deviceM12042 = c3760.m12042();
                Device deviceM120422 = null;
                int i2 = -1;
                for (int i3 = 0; i3 < SettingGimbalDialog.this.f2925.size(); i3++) {
                    C3760 c37602 = (C3760) SettingGimbalDialog.this.f2925.get(i3);
                    if (c3760.m12043()) {
                        i2 = i3;
                    } else if (c37602.m12042() != null && c37602.m12042().isConnected()) {
                        deviceM120422 = c37602.m12042();
                        i2 = i3;
                    }
                }
                if (i2 != -1) {
                    ((C3760) SettingGimbalDialog.this.f2925.get(i2)).m12044(false);
                    if (deviceM120422 != null) {
                        C2618.m9573("gimbal_his_sp", "");
                        deviceM120422.disconnect();
                        c9.m219().m231();
                    }
                    SettingGimbalDialog.this.f2922.f17361.setAlpha(0.2f);
                    SettingGimbalDialog.this.f2922.f17357.setEnabled(false);
                    SettingGimbalDialog.this.f2924.notifyDataSetChanged();
                    if (i2 == i) {
                        return;
                    }
                }
                if (deviceM12042 == null || deviceM12042.isConnected()) {
                    return;
                }
                c3760.m12044(true);
                SettingGimbalDialog.this.f2924.notifyDataSetChanged();
                c9.m219().m230(c3760, HomeActivity.m700());
                if (SettingGimbalDialog.this.f2927 != null) {
                    SettingGimbalDialog.this.f2927.mo1727();
                }
            }
        }

        @Override // defpackage.InterfaceC4172
        /* renamed from: ՠ */
        public void mo1559(int i, int i2, Object obj) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1027 implements View.OnClickListener {
        public ViewOnClickListenerC1027() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingGimbalDialog.this.f2922.f17356.performClick();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1028 implements View.OnClickListener {
        public ViewOnClickListenerC1028() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingGimbalDialog.this.f2927 != null) {
                SettingGimbalDialog.this.f2927.mo1728();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1029 implements View.OnClickListener {
        public ViewOnClickListenerC1029() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(SettingGimbalDialog.this.f2925)) {
                for (C3760 c3760 : SettingGimbalDialog.this.f2925) {
                    if (c3760.m12043()) {
                        c3760.m12044(false);
                        Device deviceM12042 = c3760.m12042();
                        if (deviceM12042 != null) {
                            deviceM12042.disconnect();
                            c9.m219().m231();
                        }
                        SettingGimbalDialog.this.f2924.notifyDataSetChanged();
                        return;
                    }
                }
            }
            if (SettingGimbalDialog.this.f2927 != null) {
                SettingGimbalDialog.this.f2927.mo1726();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$Ԯ, reason: contains not printable characters */
    public class RunnableC1030 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2932;

        public RunnableC1030(String str) {
            this.f2932 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingGimbalDialog.this.f2922.f17361.getPaint().measureText(this.f2932);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingGimbalDialog.this.f2922.f17361.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingGimbalDialog.this.f2922.f17361.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingGimbalDialog.this.f2922.f17357.getLayoutParams();
            int i = layoutParams.rightMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f) + layoutParams.bottomMargin;
            SettingGimbalDialog.this.f2922.f17357.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$ՠ, reason: contains not printable characters */
    public class RunnableC1031 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2934;

        public RunnableC1031(String str) {
            this.f2934 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingGimbalDialog.this.f2922.f17360.getPaint().measureText(this.f2934);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingGimbalDialog.this.f2922.f17360.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingGimbalDialog.this.f2922.f17360.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingGimbalDialog.this.f2922.f17356.getLayoutParams();
            int i = layoutParams.leftMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f) + layoutParams.bottomMargin;
            SettingGimbalDialog.this.f2922.f17356.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$ֈ, reason: contains not printable characters */
    public class RunnableC1032 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2936;

        public RunnableC1032(String str) {
            this.f2936 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingGimbalDialog.this.f2922.f17361.getPaint().measureText(this.f2936);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingGimbalDialog.this.f2922.f17361.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingGimbalDialog.this.f2922.f17361.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingGimbalDialog.this.f2922.f17357.getLayoutParams();
            int i = layoutParams.rightMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f) + layoutParams.bottomMargin;
            SettingGimbalDialog.this.f2922.f17357.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$֏, reason: contains not printable characters */
    public class RunnableC1033 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2938;

        public RunnableC1033(String str) {
            this.f2938 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingGimbalDialog.this.f2922.f17360.getPaint().measureText(this.f2938);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingGimbalDialog.this.f2922.f17360.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingGimbalDialog.this.f2922.f17360.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingGimbalDialog.this.f2922.f17356.getLayoutParams();
            int i = layoutParams.leftMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f) + layoutParams.bottomMargin;
            SettingGimbalDialog.this.f2922.f17356.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$ׯ, reason: contains not printable characters */
    public class C1034 implements c9.InterfaceC0056 {

        /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$ׯ$Ϳ, reason: contains not printable characters */
        public class RunnableC1035 implements Runnable {
            public RunnableC1035() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SettingGimbalDialog.this.f2924 != null) {
                    SettingGimbalDialog.this.f2924.notifyDataSetChanged();
                }
                SettingGimbalDialog.this.f2922.f17361.setAlpha(0.2f);
                SettingGimbalDialog.this.f2922.f17357.setEnabled(false);
                if (r1.m8144(SettingGimbalDialog.this.f2925)) {
                    Iterator it = SettingGimbalDialog.this.f2925.iterator();
                    while (it.hasNext()) {
                        Device deviceM12042 = ((C3760) it.next()).m12042();
                        if (deviceM12042 != null && deviceM12042.isConnected()) {
                            SettingGimbalDialog.this.f2922.f17361.setAlpha(1.0f);
                            SettingGimbalDialog.this.f2922.f17357.setEnabled(true);
                        }
                    }
                }
            }
        }

        public C1034() {
        }

        @Override // defpackage.c9.InterfaceC0056
        /* renamed from: Ԩ */
        public void mo259() {
            if (SettingGimbalDialog.this.f2927 != null) {
                SettingGimbalDialog.this.f2927.mo1725();
            }
        }

        @Override // defpackage.c9.InterfaceC0056
        /* renamed from: ԩ */
        public void mo260() {
            SettingGimbalDialog.this.post(new RunnableC1035());
        }

        @Override // defpackage.c9.InterfaceC0056
        /* renamed from: Ԫ */
        public void mo261() {
            if (SettingGimbalDialog.this.f2927 != null) {
                SettingGimbalDialog.this.f2927.mo1724();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingGimbalDialog$ؠ, reason: contains not printable characters */
    public interface InterfaceC1036 {
        /* renamed from: Ϳ */
        void mo1724();

        /* renamed from: Ԩ */
        void mo1725();

        /* renamed from: ԩ */
        void mo1726();

        /* renamed from: Ԫ */
        void mo1727();

        /* renamed from: ԫ */
        void mo1728();
    }

    public SettingGimbalDialog(Context context) {
        this(context, null);
    }

    public void setOnClickEvent(InterfaceC1036 interfaceC1036) {
        this.f2927 = interfaceC1036;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2888() {
        c9.m219().m233(null);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m2889() {
        this.f2922 = AbstractC5237.m15252(LayoutInflater.from(getContext()), this, true);
        m2891();
        m2893();
        m2892();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2890() {
        this.f2925 = c9.m219().m227();
        this.f2924 = new C3550(getContext(), this.f2925, new C1026());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m2891() {
        int iM9440 = C2579.m9440(getContext());
        C2579.m9444();
        float f = iM9440;
        int i = (int) (((int) (0.75567424f * f)) * 1.1996466f);
        ViewGroup.LayoutParams layoutParams = this.f2922.f17358.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = (int) (0.89750445f * f);
        this.f2922.f17358.setLayoutParams(layoutParams);
        this.f2922.f17361.setContentTextColor(-1);
        this.f2922.f17361.m2562(0, C4792.m14375().m14419());
        this.f2922.f17360.setContentTextColor(-1);
        this.f2922.f17360.m2562(0, C4792.m14375().m14419());
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2922.f17361.getLayoutParams();
        float f2 = i;
        int i2 = (int) (0.10309278f * f2);
        layoutParams2.rightMargin = i2;
        int i3 = (int) (0.08836524f * f2);
        layoutParams2.bottomMargin = i3;
        int i4 = (int) (f2 * 0.095729016f);
        layoutParams2.topMargin = i4;
        this.f2922.f17361.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2922.f17360.getLayoutParams();
        layoutParams3.leftMargin = i2;
        layoutParams3.bottomMargin = i3;
        layoutParams3.topMargin = i4;
        this.f2922.f17360.setLayoutParams(layoutParams3);
        this.f2922.f17359.setPadding(i2, 0, i2, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2922.f17359.getLayoutParams();
        layoutParams4.topMargin = (int) (0.053475935f * f);
        layoutParams4.height = (int) (f * 0.657754f);
        this.f2922.f17359.setLayoutParams(layoutParams4);
        String upperCase = getResources().getString(R.string.BUTTON_OK).toUpperCase();
        String upperCase2 = getResources().getString(R.string.BUTTON_CANCEL).toUpperCase();
        this.f2922.f17360.setText(upperCase2);
        this.f2922.f17361.setText(upperCase);
        this.f2922.f17361.post(new RunnableC1032(upperCase));
        this.f2922.f17360.post(new RunnableC1033(upperCase2));
        this.f2922.f17361.setDrawBorder(false);
        this.f2922.f17360.setDrawBorder(false);
        this.f2922.f17361.setAlpha(0.2f);
        this.f2922.f17357.setEnabled(false);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m2892() {
        setOnClickListener(new ViewOnClickListenerC1027());
        this.f2922.f17357.setOnClickListener(new ViewOnClickListenerC1028());
        this.f2922.f17356.setOnClickListener(new ViewOnClickListenerC1029());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m2893() {
        m2890();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.f2923 = linearLayoutManager;
        this.f2922.f17359.setLayoutManager(linearLayoutManager);
        this.f2922.f17359.setNestedScrollingEnabled(false);
        this.f2922.f17359.setAdapter(this.f2924);
        C5101 c5101 = new C5101(getContext(), 1);
        c5101.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.zhiyun_divider_item));
        this.f2922.f17359.addItemDecoration(c5101);
        this.f2922.f17359.setOverScrollMode(2);
        ((SimpleItemAnimator) this.f2922.f17359.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f2922.f17359.getItemAnimator().setChangeDuration(0L);
        this.f2922.f17359.setItemAnimator(null);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m2894(boolean z) {
        this.f2926 = z;
        int iM9445 = (int) (C2579.m9445() * 0.80515295f);
        ViewGroup.LayoutParams layoutParams = this.f2922.f17358.getLayoutParams();
        layoutParams.width = iM9445;
        float f = iM9445;
        layoutParams.height = (int) (0.67f * f);
        this.f2922.f17358.setLayoutParams(layoutParams);
        this.f2922.f17361.setContentTextColor(-1);
        this.f2922.f17361.m2562(0, C4792.m14375().m14419());
        this.f2922.f17360.setContentTextColor(-1);
        this.f2922.f17360.m2562(0, C4792.m14375().m14419());
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2922.f17361.getLayoutParams();
        int i = (int) (0.10309278f * f);
        layoutParams2.rightMargin = i;
        int i2 = (int) (0.08836524f * f);
        layoutParams2.bottomMargin = i2;
        int i3 = (int) (f * 0.095729016f);
        layoutParams2.topMargin = i3;
        this.f2922.f17361.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2922.f17360.getLayoutParams();
        layoutParams3.leftMargin = i;
        layoutParams3.bottomMargin = i2;
        layoutParams3.topMargin = i3;
        this.f2922.f17360.setLayoutParams(layoutParams3);
        this.f2922.f17359.setPadding(i, 0, i, 0);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2922.f17359.getLayoutParams();
        int i4 = layoutParams.height;
        layoutParams4.topMargin = (int) (i4 * 0.08955224f);
        layoutParams4.height = (int) (i4 * 0.58208954f);
        this.f2922.f17359.setLayoutParams(layoutParams4);
        String upperCase = getResources().getString(R.string.BUTTON_OK).toUpperCase();
        String upperCase2 = getResources().getString(R.string.BUTTON_CANCEL).toUpperCase();
        this.f2922.f17360.setText(upperCase2);
        this.f2922.f17361.setText(upperCase);
        this.f2922.f17361.post(new RunnableC1030(upperCase));
        this.f2922.f17360.post(new RunnableC1031(upperCase2));
        this.f2922.f17361.setDrawBorder(false);
        this.f2922.f17360.setDrawBorder(false);
        this.f2922.f17361.setAlpha(0.2f);
        this.f2922.f17357.setEnabled(false);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m2895() {
        boolean z;
        c9.m219().m233(new C1034());
        if (r1.m8144(this.f2925)) {
            Iterator<C3760> it = this.f2925.iterator();
            z = false;
            while (it.hasNext()) {
                if (it.next().m12042().isConnected()) {
                    z = true;
                }
            }
            this.f2924.notifyDataSetChanged();
        } else {
            z = false;
        }
        if (z) {
            this.f2922.f17361.setAlpha(1.0f);
            this.f2922.f17357.setEnabled(true);
        } else {
            this.f2922.f17361.setAlpha(0.2f);
            this.f2922.f17357.setEnabled(false);
        }
        c9.m219().m237();
    }

    public SettingGimbalDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingGimbalDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2889();
    }
}
