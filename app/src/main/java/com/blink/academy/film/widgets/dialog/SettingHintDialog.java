package com.blink.academy.film.widgets.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4261;
import defpackage.C2462;
import defpackage.C2579;
import defpackage.C3444;
import defpackage.C3485;
import defpackage.C3891;
import defpackage.C4320;
import defpackage.C4451;
import defpackage.C4792;
import defpackage.r1;
import java.util.List;

/* loaded from: classes.dex */
public class SettingHintDialog extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4261 f2942;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2943;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f2944;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f2945;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2946;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C3891 f2947;

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC1048 f2948;

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1037 implements View.OnClickListener {
        public ViewOnClickListenerC1037() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C4320.m13464(SettingHintDialog.this.getContext(), C4320.m13455(FilmApp.m405().m410()));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1038 implements View.OnClickListener {
        public ViewOnClickListenerC1038() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C4320.m13464(SettingHintDialog.this.getContext(), C4320.m13457(FilmApp.m405().m410()));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$Ԫ, reason: contains not printable characters */
    public class RunnableC1039 implements Runnable {
        public RunnableC1039() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingHintDialog.this.f2942.f14621.getPaint().measureText(SettingHintDialog.this.f2944.toUpperCase());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingHintDialog.this.f2942.f14621.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingHintDialog.this.f2942.f14621.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingHintDialog.this.f2942.f14616.getLayoutParams();
            int i = layoutParams.rightMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f);
            layoutParams2.topMargin = layoutParams.topMargin;
            SettingHintDialog.this.f2942.f14616.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1040 implements View.OnClickListener {
        public ViewOnClickListenerC1040() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingHintDialog.this.f2948 != null) {
                SettingHintDialog.this.f2948.mo1312(SettingHintDialog.this.f2943, SettingHintDialog.this.f2947);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1041 implements View.OnClickListener {
        public ViewOnClickListenerC1041() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingHintDialog.this.f2948 != null) {
                SettingHintDialog.this.f2948.mo1311(SettingHintDialog.this.f2943);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1042 implements View.OnClickListener {
        public ViewOnClickListenerC1042() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1043 implements View.OnClickListener {
        public ViewOnClickListenerC1043() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!SettingHintDialog.this.f2945 || SettingHintDialog.this.f2948 == null) {
                return;
            }
            SettingHintDialog.this.f2948.mo1311(SettingHintDialog.this.f2943);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$֏, reason: contains not printable characters */
    public class RunnableC1044 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2956;

        public RunnableC1044(String str) {
            this.f2956 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingHintDialog.this.f2942.f14621.getPaint().measureText(this.f2956);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingHintDialog.this.f2942.f14621.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingHintDialog.this.f2942.f14621.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingHintDialog.this.f2942.f14616.getLayoutParams();
            int i = layoutParams.rightMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f);
            layoutParams2.topMargin = layoutParams.topMargin;
            SettingHintDialog.this.f2942.f14616.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$ׯ, reason: contains not printable characters */
    public class RunnableC1045 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2958;

        public RunnableC1045(String str) {
            this.f2958 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingHintDialog.this.f2942.f14619.getPaint().measureText(this.f2958);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SettingHintDialog.this.f2942.f14619.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingHintDialog.this.f2942.f14619.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) SettingHintDialog.this.f2942.f14615.getLayoutParams();
            int i = layoutParams.leftMargin;
            layoutParams2.width = layoutParams.width + i + i;
            layoutParams2.height = C2579.m9438(44.0f);
            layoutParams2.topMargin = layoutParams.topMargin;
            SettingHintDialog.this.f2942.f14615.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$ؠ, reason: contains not printable characters */
    public class RunnableC1046 implements Runnable {
        public RunnableC1046() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingHintDialog.this.f2942.f14618.getPaint().measureText(SettingHintDialog.this.f2942.f14618.getText().toString());
            ViewGroup.LayoutParams layoutParams = SettingHintDialog.this.f2942.f14618.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingHintDialog.this.f2942.f14618.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$ހ, reason: contains not printable characters */
    public class RunnableC1047 implements Runnable {
        public RunnableC1047() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = SettingHintDialog.this.f2942.f14620.getPaint().measureText(SettingHintDialog.this.f2942.f14620.getText().toString());
            ViewGroup.LayoutParams layoutParams = SettingHintDialog.this.f2942.f14620.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            SettingHintDialog.this.f2942.f14620.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.SettingHintDialog$ށ, reason: contains not printable characters */
    public interface InterfaceC1048 {
        /* renamed from: Ϳ */
        void mo1311(int i);

        /* renamed from: Ԩ */
        void mo1312(int i, C3891 c3891);
    }

    public SettingHintDialog(Context context) {
        this(context, null);
    }

    private void setContent(String str) {
        this.f2942.f14620.setCustomText(str);
    }

    public void setOnButtonClick(InterfaceC1048 interfaceC1048) {
        this.f2948 = interfaceC1048;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2902() {
        this.f2942 = AbstractC4261.m13376(LayoutInflater.from(getContext()), this, true);
        m2903();
        this.f2942.f14616.setOnClickListener(new ViewOnClickListenerC1040());
        this.f2942.f14615.setOnClickListener(new ViewOnClickListenerC1041());
        this.f2942.f14617.setOnClickListener(new ViewOnClickListenerC1042());
        setOnClickListener(new ViewOnClickListenerC1043());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m2903() {
        int iM9440 = (int) (((int) (C2579.m9440(getContext()) * 0.75567424f)) * 1.1996466f);
        this.f2946 = iM9440;
        ViewGroup.LayoutParams layoutParams = this.f2942.f14617.getLayoutParams();
        layoutParams.width = iM9440;
        this.f2942.f14617.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2942.f14618.getLayoutParams();
        float f = iM9440;
        int i = (int) (0.095729016f * f);
        layoutParams2.topMargin = i;
        int i2 = (int) (0.10309278f * f);
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i2;
        this.f2942.f14618.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2942.f14620.getLayoutParams();
        layoutParams3.topMargin = C4792.m14375().m14384();
        layoutParams3.leftMargin = i2;
        layoutParams3.rightMargin = i2;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2942.f14621.getLayoutParams();
        layoutParams4.rightMargin = i2;
        int i3 = (int) (f * 0.08836524f);
        layoutParams4.bottomMargin = i3;
        layoutParams4.topMargin = i;
        this.f2942.f14621.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f2942.f14619.getLayoutParams();
        layoutParams5.leftMargin = i2;
        layoutParams5.bottomMargin = i3;
        layoutParams5.topMargin = i;
        this.f2942.f14619.setLayoutParams(layoutParams5);
        this.f2942.f14618.setContentTextColor(-1);
        this.f2942.f14618.m2562(0, C4792.m14375().m14381());
        this.f2942.f14620.setContentTextColor(-1);
        this.f2942.f14620.m2562(0, C4792.m14375().m14377());
        this.f2942.f14621.setContentTextColor(-1);
        this.f2942.f14621.m2562(0, C4792.m14375().m14419());
        this.f2942.f14619.setContentTextColor(-1);
        this.f2942.f14619.m2562(0, C4792.m14375().m14419());
        String upperCase = getResources().getString(R.string.BUTTON_OK).toUpperCase();
        String upperCase2 = getResources().getString(R.string.BUTTON_CANCEL).toUpperCase();
        this.f2942.f14619.setText(upperCase2);
        this.f2942.f14621.setText(upperCase);
        this.f2942.f14621.post(new RunnableC1044(upperCase));
        this.f2942.f14619.post(new RunnableC1045(upperCase2));
        this.f2942.f14618.setDrawBorder(false);
        this.f2942.f14620.setDrawBorder(false);
        this.f2942.f14621.setDrawBorder(false);
        this.f2942.f14619.setDrawBorder(false);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m2904() {
        StrokeTextView strokeTextView = this.f2942.f14621;
        if (strokeTextView == null) {
            return;
        }
        strokeTextView.post(new RunnableC1039());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public SettingHintDialog m2905(boolean z) {
        this.f2945 = z;
        return this;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public SettingHintDialog m2906(int i) {
        this.f2943 = i;
        if (i == 6) {
            this.f2942.f14619.setVisibility(8);
            this.f2942.f14615.setVisibility(8);
        }
        return this;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m2907(C3891 c3891, int i) throws Resources.NotFoundException {
        ViewGroup.LayoutParams layoutParams = this.f2942.f14617.getLayoutParams();
        layoutParams.width = this.f2946;
        this.f2942.f14617.setLayoutParams(layoutParams);
        this.f2942.f14620.setVisibility(8);
        this.f2942.f14619.setVisibility(0);
        this.f2942.f14615.setVisibility(0);
        String strM12400 = c3891 != null ? c3891.m12400() : "";
        String upperCase = getResources().getString(R.string.BUTTON_OK).toUpperCase();
        this.f2944 = upperCase;
        this.f2942.f14621.setText(upperCase);
        switch (this.f2943) {
            case 1:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_RESET_FILENAME);
                setContent(getResources().getString(R.string.POPUP_DESC_RESET_FILENAME));
                this.f2942.f14620.setVisibility(0);
                break;
            case 2:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_REMOVE_PRESET);
                setContent(getResources().getString(R.string.POPUP_DESC_REMOVE_PRESET, strM12400));
                this.f2942.f14620.setVisibility(0);
                break;
            case 3:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_UPDATE_PRESET);
                setContent(getResources().getString(R.string.POPUP_DESC_UPDATE_PRESET, strM12400));
                this.f2942.f14620.setVisibility(0);
                break;
            case 4:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_LOAD_PRESET);
                setContent(getResources().getString(R.string.POPUP_DESC_LOAD_PRESET, strM12400));
                this.f2942.f14620.setVisibility(0);
                break;
            case 5:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_DELETE_VIDEO);
                setContent(getResources().getString(R.string.POPUP_DESC_DELETE_VIDEO));
                this.f2942.f14620.setVisibility(0);
                break;
            case 6:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_CAMERA_ERROR);
                setContent(getResources().getString(R.string.POPUP_DESC_CAMERA_ERROR));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14615.setVisibility(8);
                break;
            case 7:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_CAMERA_DIRECT);
                setContent(getResources().getString(R.string.POPUP_DESC_CAMERA_DIRECT));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14615.setVisibility(8);
                break;
            case 8:
                this.f2942.f14618.setText(R.string.IOS_POPUP_TITLE_NO_CAMERA);
                setContent(getResources().getString(R.string.IOS_POPUP_DESC_NO_CAMERA));
                String string = getResources().getString(R.string.IOS_POPUP_BUTTON_OPEN_SETTINGS);
                this.f2944 = string;
                this.f2942.f14621.setText(string);
                this.f2942.f14620.setVisibility(0);
                if (FilmApp.m405().m426()) {
                    this.f2942.f14619.setVisibility(0);
                    this.f2942.f14615.setVisibility(0);
                } else {
                    this.f2942.f14619.setVisibility(8);
                    this.f2942.f14615.setVisibility(8);
                }
                this.f2942.f14621.setVisibility(0);
                break;
            case 9:
                this.f2942.f14618.setText(R.string.IOS_POPUP_TITLE_NO_MICROPHONE);
                setContent(getResources().getString(R.string.IOS_POPUP_DESC_NO_MICROPHONE));
                String string2 = getResources().getString(R.string.IOS_POPUP_BUTTON_OPEN_SETTINGS);
                this.f2944 = string2;
                this.f2942.f14621.setText(string2);
                this.f2942.f14620.setVisibility(0);
                if (FilmApp.m405().m426()) {
                    this.f2942.f14619.setVisibility(0);
                    this.f2942.f14615.setVisibility(0);
                } else {
                    this.f2942.f14619.setVisibility(8);
                    this.f2942.f14615.setVisibility(8);
                }
                this.f2942.f14621.setVisibility(0);
                break;
            case 10:
                this.f2942.f14618.setText(R.string.IOS_POPUP_TITLE_NO_PHOTOS);
                setContent(getResources().getString(R.string.IOS_POPUP_DESC_NO_PHOTOS));
                String string3 = getResources().getString(R.string.IOS_POPUP_BUTTON_OPEN_SETTINGS);
                this.f2944 = string3;
                this.f2942.f14621.setText(string3);
                this.f2942.f14620.setVisibility(0);
                if (FilmApp.m405().m426()) {
                    this.f2942.f14619.setVisibility(0);
                    this.f2942.f14615.setVisibility(0);
                } else {
                    this.f2942.f14619.setVisibility(8);
                    this.f2942.f14615.setVisibility(8);
                }
                this.f2942.f14621.setVisibility(0);
                break;
            case 11:
                this.f2942.f14618.setText(R.string.SETTINGS_LOCATION);
                setContent(getResources().getString(R.string.IOS_POPUP_DESC_LOCATION));
                String string4 = getResources().getString(R.string.IOS_POPUP_BUTTON_OPEN_SETTINGS);
                this.f2944 = string4;
                this.f2942.f14621.setText(string4);
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(0);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(0);
                break;
            case 12:
            case 31:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_ACCESS_REQUEST);
                setContent(getResources().getString(R.string.POPUP_DESC_ACCESS_REQUEST));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(0);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(0);
                break;
            case 13:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_DELETE_VIDEO);
                setContent(getResources().getString(R.string.POPUP_DESC_DELETE_VIDEO_MULTIPLE, Integer.valueOf(i)));
                this.f2942.f14620.setVisibility(0);
                break;
            case 14:
                this.f2942.f14618.setText("Camera Info");
                setContent(C3485.m11349().toString());
                this.f2942.f14620.setVisibility(0);
                break;
            case 15:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_FPS_INFO);
                setContent(String.format("%s\n\n%s", getResources().getString(R.string.POPUP_DESC_FPS_INFO_CONVERTED), getResources().getString(R.string.POPUP_DESC_FPS_INFO_DIRECT)));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 16:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_FPS_INFO);
                setContent(getResources().getString(R.string.POPUP_DESC_FPS_INFO_CONVERTED));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 17:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_FPS_INFO);
                setContent(getResources().getString(R.string.POPUP_DESC_FPS_INFO_DIRECT));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 18:
                this.f2942.f14618.setText(R.string.LABEL_SIGN_OUT);
                setContent(getResources().getString(R.string.TEXT_SIGN_OUT));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(0);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(0);
                break;
            case 19:
                this.f2942.f14618.setText(R.string.LABEL_CONNECT_INTERNET);
                setContent(getResources().getString(R.string.TEXT_CONNECT_INTERNET));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 20:
                this.f2942.f14618.setText(R.string.LABEL_SIGNED_OUT_INTERNET);
                setContent(getResources().getString(R.string.TEXT_SIGNED_OUT_INTERNET));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14615.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                break;
            case 21:
                this.f2942.f14618.setText(R.string.LABEL_SIGNED_OUT);
                setContent(getResources().getString(R.string.TEXT_SIGNED_OUT));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 22:
                this.f2942.f14618.setText(R.string.LABEL_SIGNED_OUT);
                setContent(getResources().getString(R.string.TEXT_SIGNED_OUT_2));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 23:
                this.f2942.f14618.setText(R.string.LABEL_SIGNED_OUT);
                setContent(getResources().getString(R.string.TEXT_SIGNED_OUT_3));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 24:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_ANDROID_STABLIZATION);
                setContent(getResources().getString(R.string.POPUP_DESC_ANDROID_STABLIZATION));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 25:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_DEVICE_LIMIT);
                String string5 = String.format(getResources().getString(R.string.POPUP_DESC_DEVICE_LIMIT), getResources().getString(R.string.RECORDING_SETTINGS_TITLE_LOOKS).toUpperCase()) + "\n\n";
                List<C3444.C3450> listM11246 = C3444.m11227().m11246();
                for (int i2 = 0; i2 < listM11246.size(); i2++) {
                    C3444.C3450 c3450 = listM11246.get(i2);
                    String strM11275 = c3450.m11275();
                    int iM11274 = c3450.m11274();
                    String strM9049 = C2462.m9035().m9049(strM11275);
                    StringBuilder sb = new StringBuilder(string5);
                    sb.append(i2 != listM11246.size() - 1 ? strM9049 + "\t\t" + iM11274 + "FPS\n" : strM9049 + "\t\t" + iM11274 + "FPS");
                    string5 = sb.toString();
                }
                setContent(string5);
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 26:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_DEVICE_LIMIT);
                String string6 = String.format(getResources().getString(R.string.POPUP_DESC_DEVICE_LIMIT), getResources().getString(R.string.RECORDING_SETTINGS_BEAUTY).toUpperCase()) + "\n\n";
                List<C3444.C3450> listM11245 = C3444.m11227().m11245();
                for (int i3 = 0; i3 < listM11245.size(); i3++) {
                    C3444.C3450 c34502 = listM11245.get(i3);
                    String strM112752 = c34502.m11275();
                    int iM112742 = c34502.m11274();
                    String strM90492 = C2462.m9035().m9049(strM112752);
                    StringBuilder sb2 = new StringBuilder(string6);
                    sb2.append(i3 != listM11245.size() - 1 ? strM90492 + "\t\t" + iM112742 + "FPS\n" : strM90492 + "\t\t" + iM112742 + "FPS");
                    string6 = sb2.toString();
                }
                setContent(string6);
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 27:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_CAMERA_ERROR);
                setContent(getResources().getString(R.string.POPUP_DESC_CAMERA_ERROR));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14615.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                break;
            case 28:
                this.f2942.f14618.setText("隐私政策");
                this.f2942.f14620.setMovementMethod(LinkMovementMethod.getInstance());
                this.f2942.f14620.setHighlightColor(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) "阅读并同意《");
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) "用户政策");
                int length2 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) "》和《");
                int length3 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) "隐私协议");
                int length4 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) "》");
                SpannableString spannableString = new SpannableString(spannableStringBuilder.toString());
                C4451.m13717(spannableString, new ViewOnClickListenerC1037(), length, length2);
                C4451.m13717(spannableString, new ViewOnClickListenerC1038(), length3, length4);
                this.f2942.f14621.setText("同意");
                this.f2942.f14620.setCustomText(spannableString);
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(0);
                this.f2942.f14621.setVisibility(0);
                layoutParams.width = C4792.m14375().m14438();
                if (C4792.m14375().m14498()) {
                    layoutParams.width = C2579.f9600 - C2579.m9438(50.0f);
                }
                this.f2942.f14617.setLayoutParams(layoutParams);
                break;
            case 29:
                this.f2942.f14618.setText(getResources().getString(R.string.LABEL_DEACTIVATE_ACCOUNT));
                setContent(getResources().getString(R.string.TEXT_DEACTIVATE_ACCOUNT));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(0);
                this.f2942.f14621.setVisibility(0);
                break;
            case 30:
            case 33:
                String strM12399 = c3891.m12399();
                String strM12483 = c3891.m12483();
                String strM124002 = c3891.m12400();
                String strM12380 = c3891.m12380();
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14618.setVisibility(0);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14618.setText(strM12399);
                this.f2942.f14620.setText(strM12483);
                if (r1.m8143(strM124002)) {
                    this.f2942.f14619.setVisibility(0);
                    this.f2942.f14615.setVisibility(0);
                    this.f2942.f14619.setText(strM124002);
                    float fMeasureText = this.f2942.f14619.getPaint().measureText(strM124002);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2942.f14619.getLayoutParams();
                    layoutParams2.width = (int) (fMeasureText + C4792.f16138);
                    this.f2942.f14619.setLayoutParams(layoutParams2);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2942.f14615.getLayoutParams();
                    int i4 = layoutParams2.leftMargin;
                    layoutParams3.width = layoutParams2.width + i4 + i4;
                    layoutParams3.height = C2579.m9438(44.0f);
                    layoutParams3.topMargin = layoutParams2.topMargin;
                    this.f2942.f14615.setLayoutParams(layoutParams3);
                } else {
                    this.f2942.f14619.setVisibility(8);
                    this.f2942.f14615.setVisibility(8);
                }
                if (r1.m8143(strM12380)) {
                    this.f2942.f14621.setVisibility(0);
                    this.f2942.f14616.setVisibility(0);
                    this.f2942.f14621.setText(strM12380);
                    this.f2944 = strM12380;
                    break;
                } else {
                    this.f2942.f14621.setVisibility(8);
                    this.f2942.f14616.setVisibility(8);
                    break;
                }
            case 32:
                this.f2942.f14618.setText(R.string.POPUP_TITLE_HDMI_PERFORMANCE);
                setContent(getResources().getString(R.string.POPUP_DESC_HDMI_PERFORMANCE));
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(8);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(8);
                break;
            case 34:
                this.f2942.f14618.setText(R.string.IOS_POPUP_TITLE_NO_CAMERA);
                setContent(getResources().getString(R.string.IOS_POPUP_DESC_CAMERA));
                String string7 = getResources().getString(R.string.BUTTON_OK);
                this.f2944 = string7;
                this.f2942.f14621.setText(string7);
                this.f2942.f14620.setVisibility(0);
                if (FilmApp.m405().m426()) {
                    this.f2942.f14619.setVisibility(0);
                    this.f2942.f14615.setVisibility(0);
                } else {
                    this.f2942.f14619.setVisibility(8);
                    this.f2942.f14615.setVisibility(8);
                }
                this.f2942.f14621.setVisibility(0);
                break;
            case 35:
                this.f2942.f14618.setText(R.string.IOS_POPUP_TITLE_NO_MICROPHONE);
                setContent(getResources().getString(R.string.IOS_POPUP_DESC_MICROPHONE));
                String string8 = getResources().getString(R.string.BUTTON_OK);
                this.f2944 = string8;
                this.f2942.f14621.setText(string8);
                this.f2942.f14620.setVisibility(0);
                if (FilmApp.m405().m426()) {
                    this.f2942.f14619.setVisibility(0);
                    this.f2942.f14615.setVisibility(0);
                } else {
                    this.f2942.f14619.setVisibility(8);
                    this.f2942.f14615.setVisibility(8);
                }
                this.f2942.f14621.setVisibility(0);
                break;
            case 36:
                this.f2942.f14618.setText(R.string.IOS_POPUP_TITLE_NO_PHOTOS);
                setContent(getResources().getString(R.string.IOS_POPUP_DESC_PHOTOS));
                String string9 = getResources().getString(R.string.BUTTON_OK);
                this.f2944 = string9;
                this.f2942.f14621.setText(string9);
                this.f2942.f14620.setVisibility(0);
                if (FilmApp.m405().m426()) {
                    this.f2942.f14619.setVisibility(0);
                    this.f2942.f14615.setVisibility(0);
                } else {
                    this.f2942.f14619.setVisibility(8);
                    this.f2942.f14615.setVisibility(8);
                }
                this.f2942.f14621.setVisibility(0);
                break;
            case 37:
                this.f2942.f14618.setText(R.string.IOS_POPUP_TITLE_NO_LOCATION);
                setContent(getResources().getString(R.string.IOS_POPUP_DESC_LOCATION));
                String string10 = getResources().getString(R.string.BUTTON_OK);
                this.f2944 = string10;
                this.f2942.f14621.setText(string10);
                this.f2942.f14620.setVisibility(0);
                if (FilmApp.m405().m426()) {
                    this.f2942.f14619.setVisibility(0);
                    this.f2942.f14615.setVisibility(0);
                } else {
                    this.f2942.f14619.setVisibility(8);
                    this.f2942.f14615.setVisibility(8);
                }
                this.f2942.f14621.setVisibility(0);
                break;
            case 38:
                this.f2942.f14618.setText(R.string.IOS_POPUP_TITLE_NO_BLUETOOTH);
                setContent(getResources().getString(R.string.PERMISSION_NEARBY_DEVICES));
                String string11 = getResources().getString(R.string.BUTTON_OK);
                this.f2944 = string11;
                this.f2942.f14621.setText(string11);
                this.f2942.f14620.setVisibility(0);
                if (FilmApp.m405().m426()) {
                    this.f2942.f14619.setVisibility(0);
                    this.f2942.f14615.setVisibility(0);
                } else {
                    this.f2942.f14619.setVisibility(8);
                    this.f2942.f14615.setVisibility(8);
                }
                this.f2942.f14621.setVisibility(0);
                break;
            case 39:
                this.f2942.f14618.setText(R.string.IOS_POPUP_TITLE_NO_BLUETOOTH);
                setContent(getResources().getString(R.string.PERMISSION_NEARBY_DEVICES));
                String string12 = getResources().getString(R.string.IOS_POPUP_BUTTON_OPEN_SETTINGS);
                this.f2944 = string12;
                this.f2942.f14621.setText(string12);
                this.f2942.f14620.setVisibility(0);
                this.f2942.f14619.setVisibility(0);
                this.f2942.f14621.setVisibility(0);
                this.f2942.f14615.setVisibility(0);
                break;
        }
        m2904();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m2908(int i, C3891 c3891) {
        m2909(i, c3891, 0);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m2909(int i, C3891 c3891, int i2) throws Resources.NotFoundException {
        this.f2943 = i;
        this.f2947 = c3891;
        m2907(c3891, i2);
        this.f2942.f14618.post(new RunnableC1046());
        this.f2942.f14620.post(new RunnableC1047());
    }

    public SettingHintDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingHintDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2945 = true;
        m2902();
    }
}
