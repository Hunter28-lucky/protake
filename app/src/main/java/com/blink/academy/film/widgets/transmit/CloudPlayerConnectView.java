package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.netbean.store.NvtInfoCallbackEntity;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.protake.R;
import defpackage.AbstractC4960;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.ViewOnTouchListenerC3426;
import defpackage.n;
import defpackage.r1;

/* loaded from: classes.dex */
public class CloudPlayerConnectView extends ConstraintLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4960 f4245;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f4246;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f4247;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC1583 f4248;

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudPlayerConnectView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1580 implements View.OnClickListener {
        public ViewOnClickListenerC1580() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudPlayerConnectView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1581 implements View.OnClickListener {
        public ViewOnClickListenerC1581() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CloudPlayerConnectView.this.f4248 != null) {
                CloudPlayerConnectView.this.f4248.mo4230();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudPlayerConnectView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1582 implements View.OnClickListener {
        public ViewOnClickListenerC1582() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CloudPlayerConnectView.this.f4248 != null) {
                CloudPlayerConnectView.this.f4248.mo4229();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudPlayerConnectView$Ԭ, reason: contains not printable characters */
    public interface InterfaceC1583 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo4229();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo4230();
    }

    public CloudPlayerConnectView(@NonNull Context context) {
        this(context, null);
    }

    public void setOnCloudConnectCallback(InterfaceC1583 interfaceC1583) {
        this.f4248 = interfaceC1583;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4224() {
        this.f4245 = AbstractC4960.m14734(LayoutInflater.from(getContext()), this, true);
        m4225();
        m4226();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4225() {
        if (C2579.m9451(getContext())) {
            this.f4245.f16676.setBackgroundResource(R.drawable.shap_bg_blue_6dp);
        } else {
            this.f4245.f16676.setBackgroundResource(R.drawable.shap_bg_blue_5dp);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4245.f16679.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = C4792.m14375().m14476(40);
        this.f4245.f16679.setLayoutParams(layoutParams);
        this.f4245.f16680.setTypeface(FilmApp.m403());
        this.f4245.f16680.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4245.f16680.setTextSize(0, C4792.m14375().m14378());
        int iM14476 = C4792.m14375().m14476(40);
        int iM144762 = C4792.m14375().m14476(20);
        this.f4245.f16680.setText(getResources().getString(R.string.DISCONNECT));
        this.f4245.f16680.setPadding(iM14476, iM144762, iM14476, iM144762);
        this.f4245.f16679.setContentTypeFace(FilmApp.m403());
        this.f4245.f16679.setTextColor(-1);
        this.f4245.f16679.m2562(0, C4792.m14375().m14377());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4245.f16677.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = C4792.m14375().m14476(40);
        this.f4245.f16677.setLayoutParams(layoutParams2);
        this.f4245.f16682.setContentTypeFace(FilmApp.m403());
        this.f4245.f16682.setTextColor(-1);
        this.f4245.f16682.m2562(0, C4792.m14375().m14377());
        this.f4245.f16681.setTypeface(FilmApp.m403());
        this.f4245.f16681.setTextSize(0, C4792.m14375().m14377());
        this.f4245.f16681.setText(R.string.BUTTON_EXTEND);
        TextPaint paint = this.f4245.f16682.getPaint();
        int iM144763 = C4792.m14375().m14476(15);
        int iM144764 = C4792.m14375().m14476(25);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = (int) (fontMetrics.descent - fontMetrics.ascent);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4245.f16678.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = C4792.m14375().m14479(30.0f, C4792.m14375().m14471());
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (paint.measureText(getContext().getString(R.string.BUTTON_EXTEND).toUpperCase()) + (iM144764 * 2));
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) (f + (iM144763 * 2));
        this.f4245.f16678.setLayoutParams(layoutParams3);
        this.f4245.f16677.setVisibility(0);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4226() {
        setOnClickListener(new ViewOnClickListenerC1580());
        this.f4245.f16676.setOnClickListener(new ViewOnClickListenerC1581());
        this.f4245.f16678.setOnClickListener(new ViewOnClickListenerC1582());
        RelativeLayout relativeLayout = this.f4245.f16676;
        relativeLayout.setOnTouchListener(new ViewOnTouchListenerC3426(relativeLayout));
        FrameLayout frameLayout = this.f4245.f16678;
        frameLayout.setOnTouchListener(new ViewOnTouchListenerC3426(frameLayout));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m4227(String str) throws Resources.NotFoundException {
        m4228();
        if (!r1.m8143(str)) {
            if ("".equals(this.f4246)) {
                return;
            }
            this.f4246 = "";
            this.f4245.f16679.setVisibility(8);
            this.f4245.f16679.m2561("");
            return;
        }
        if (this.f4246.equals(str)) {
            return;
        }
        this.f4246 = str;
        this.f4245.f16679.setVisibility(0);
        this.f4245.f16679.m2561(getResources().getString(R.string.CLOUD_CAMERA_CONNECTED) + MyUTIL.white_space + str);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4228() throws Resources.NotFoundException {
        String str;
        int iMax;
        this.f4245.f16677.setVisibility(0);
        NvtInfoCallbackEntity nvtInfoCallbackEntityM7595 = n.m7588().m7595();
        if (nvtInfoCallbackEntityM7595 != null) {
            iMax = (int) (Math.max(0L, nvtInfoCallbackEntityM7595.getBalance()) / 60);
            str = String.format(getResources().getString(R.string.MONITOR_TIME_LEFT_TIME2), "" + iMax);
        } else {
            str = String.format(getResources().getString(R.string.MONITOR_TIME_LEFT_TIME3), "N/A");
            iMax = -1;
        }
        if (str.equals(this.f4247)) {
            return;
        }
        this.f4247 = str;
        this.f4245.f16682.m2561(str);
        if (iMax < 0 || iMax >= 5) {
            this.f4245.f16682.setContentTextColor(-1);
        } else {
            this.f4245.f16682.setContentTextColor(getResources().getColor(R.color.colorRed, null));
        }
    }

    public CloudPlayerConnectView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloudPlayerConnectView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4246 = "";
        this.f4247 = "";
        m4224();
    }
}
