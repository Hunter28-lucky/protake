package com.blink.academy.film.widgets.dialog.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC4413;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C4320;
import defpackage.C5213;

/* loaded from: classes.dex */
public class PrivacyWebView extends CardView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4413 f3024;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3025;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f3026;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC1095 f3027;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f3028;

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyWebView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1089 implements View.OnClickListener {
        public ViewOnClickListenerC1089() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PrivacyWebView.this.f3024.f15211.canGoBack()) {
                PrivacyWebView.this.f3024.f15211.goBack();
            } else if (PrivacyWebView.this.f3027 != null) {
                PrivacyWebView.this.f3027.onDisagree();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyWebView$Ԩ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1090 implements View.OnTouchListener {
        public ViewOnTouchListenerC1090() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            view.setAlpha(1.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyWebView$Ԫ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1091 implements View.OnTouchListener {
        public ViewOnTouchListenerC1091() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            view.setAlpha(1.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyWebView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1092 implements View.OnClickListener {
        public ViewOnClickListenerC1092() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PrivacyWebView.this.f3025 == 1) {
                C2618.m9570("terms_alert_sp", true);
            }
            if (PrivacyWebView.this.f3027 != null) {
                PrivacyWebView.this.f3027.mo1314(PrivacyWebView.this.f3025 == 0);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyWebView$Ԯ, reason: contains not printable characters */
    public class C1093 extends WebViewClient {

        /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyWebView$Ԯ$Ϳ, reason: contains not printable characters */
        public class RunnableC1094 implements Runnable {
            public RunnableC1094() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PrivacyWebView.this.f3024.f15211.setAlpha(1.0f);
                PrivacyWebView.this.f3024.f15201.setVisibility(8);
            }
        }

        public C1093() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            PrivacyWebView.this.m2983();
            if (PrivacyWebView.this.f3028) {
                PrivacyWebView.this.f3028 = false;
                PrivacyWebView.this.f3024.f15211.clearHistory();
            }
            super.onPageFinished(webView, str);
            FilmApp.m405().m428(new RunnableC1094(), 50L);
            if (PrivacyWebView.this.f3024.f15211.canGoBack()) {
                PrivacyWebView.this.f3024.f15208.setText(PrivacyWebView.this.getResources().getString(R.string.BUTTON_BACK));
            } else {
                PrivacyWebView.this.f3024.f15208.setText(PrivacyWebView.this.getResources().getString(R.string.LABEL_NOT_AGREE));
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            PrivacyWebView.this.getContext().startActivity(intent);
            return true;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyWebView$ՠ, reason: contains not printable characters */
    public interface InterfaceC1095 {
        void onDisagree();

        /* renamed from: Ϳ */
        void mo1314(boolean z);
    }

    public PrivacyWebView(@NonNull Context context) {
        this(context, null);
    }

    public void setShowType(int i) {
        this.f3025 = i;
    }

    public void setSplash(boolean z) {
        this.f3024.f15211.setAlpha(0.0f);
        if (this.f3025 == 1) {
            this.f3026 = C4320.m13455(FilmApp.m405().m410());
        } else {
            this.f3026 = C4320.m13457(FilmApp.m405().m410());
            if (C2618.m9566("privacy_remote_v_sp", 1) < 2 && C5213.m15210() && z) {
                this.f3026 = "file:///android_asset/protake_prompt_cn.html";
            }
        }
        this.f3028 = true;
        this.f3024.f15201.setVisibility(0);
        this.f3024.f15211.loadUrl(this.f3026);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2979() {
        this.f3024 = AbstractC4413.m13610(LayoutInflater.from(getContext()), this, true);
        m2981();
        m2980();
        setRadius(C2579.m9438(0.0f));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m2980() {
        this.f3024.f15206.setOnClickListener(new ViewOnClickListenerC1089());
        this.f3024.f15206.setOnTouchListener(new ViewOnTouchListenerC1090());
        this.f3024.f15205.setOnTouchListener(new ViewOnTouchListenerC1091());
        this.f3024.f15205.setOnClickListener(new ViewOnClickListenerC1092());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m2981() {
        m2982();
        this.f3024.f15208.setTypeface(FilmApp.m404());
        this.f3024.f15207.setTypeface(FilmApp.m404());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m2982() {
        WebSettings settings = this.f3024.f15211.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        this.f3024.f15211.setWebViewClient(new C1093());
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m2983() {
        try {
            this.f3024.f15211.loadUrl("javascript:(function() {let contentElements = document.getElementsByClassName('agreementpreview');if (contentElements) {    for (let i = 0; i < contentElements.length; i++) {        let pElements = contentElements[i].getElementsByTagName('p');        if (pElements) {            for (let j = 0; j < pElements.length; j++) {                pElements[j].style.fontSize='12px';            }        }    }}let titleElements = document.getElementsByClassName('title');if (titleElements) {    for (let i = 0; i < titleElements.length; i++) {        titleElements[i].style.marginTop='0px';    }}let indent1Elements = document.getElementsByClassName('indent1');if (indent1Elements) {    for (let i = 0; i < indent1Elements.length; i++) {        indent1Elements[i].style.paddingTop='0px';        indent1Elements[i].style.margin='0px';    }}let indent2Elements = document.getElementsByClassName('indent2');if (indent2Elements) {    for (let i = 0; i < indent2Elements.length; i++) {        indent2Elements[i].style.paddingTop='0px';        indent2Elements[i].style.margin='0px';    }}let indent3Elements = document.getElementsByClassName('indent3');if (indent3Elements) {   for (let i = 0; i < indent3Elements.length; i++) {        indent3Elements[i].style.paddingTop='0px';        indent3Elements[i].style.margin='0px';    } }})()");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m2984(int i, int i2) {
        int iM9438 = C2579.m9438(35.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3024.f15211.getLayoutParams();
        layoutParams.width = (int) (i * 0.95f);
        this.f3024.f15211.setLayoutParams(layoutParams);
        int iM94382 = C2579.m9438(15.0f);
        this.f3024.f15205.setPadding(iM9438, iM94382, iM9438, iM94382);
        this.f3024.f15206.setPadding(iM9438, iM94382, iM9438, iM94382);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3024.f15201.getLayoutParams();
        layoutParams2.topMargin = (i2 / 2) - C2579.m9438(25.0f);
        this.f3024.f15201.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f3024.f15209.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = ((int) this.f3024.f15207.getPaint().measureText(this.f3024.f15207.getText().toString())) + C2579.m9438(12.0f);
        this.f3024.f15209.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f3024.f15210.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = ((int) this.f3024.f15208.getPaint().measureText(this.f3024.f15208.getText().toString())) + C2579.m9438(12.0f);
        this.f3024.f15210.setLayoutParams(layoutParams4);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public PrivacyWebView m2985(InterfaceC1095 interfaceC1095) {
        return m2986(interfaceC1095, false);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public PrivacyWebView m2986(InterfaceC1095 interfaceC1095, boolean z) {
        this.f3027 = interfaceC1095;
        setSplash(z);
        return this;
    }

    public PrivacyWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrivacyWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3025 = 0;
        this.f3028 = false;
        m2979();
    }
}
