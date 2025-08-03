package com.alipay.sdk.m.x;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import defpackage.pa;
import defpackage.pg;
import defpackage.ug;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class e extends LinearLayout {

    /* renamed from: ނ, reason: contains not printable characters */
    public static Handler f311 = new Handler(Looper.getMainLooper());

    /* renamed from: ԫ, reason: contains not printable characters */
    public ImageView f312;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public TextView f313;

    /* renamed from: ԭ, reason: contains not printable characters */
    public ImageView f314;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ProgressBar f315;

    /* renamed from: ԯ, reason: contains not printable characters */
    public WebView f316;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C0092 f317;

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC0093 f318;

    /* renamed from: ֏, reason: contains not printable characters */
    public InterfaceC0094 f319;

    /* renamed from: ׯ, reason: contains not printable characters */
    public InterfaceC0095 f320;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final pa f321;

    /* renamed from: ހ, reason: contains not printable characters */
    public View.OnClickListener f322;

    /* renamed from: ށ, reason: contains not printable characters */
    public final float f323;

    /* renamed from: com.alipay.sdk.m.x.e$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC0087 implements View.OnClickListener {

        /* renamed from: com.alipay.sdk.m.x.e$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC0088 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f325;

            public RunnableC0088(View view) {
                this.f325 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f325.setEnabled(true);
            }
        }

        public ViewOnClickListenerC0087() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC0095 interfaceC0095 = e.this.f320;
            if (interfaceC0095 != null) {
                view.setEnabled(false);
                e.f311.postDelayed(new RunnableC0088(view), 256L);
                if (view == e.this.f312) {
                    interfaceC0095.mo361(e.this);
                } else if (view == e.this.f314) {
                    interfaceC0095.mo360(e.this);
                }
            }
        }
    }

    /* renamed from: com.alipay.sdk.m.x.e$Ԩ, reason: contains not printable characters */
    public class C0089 implements DownloadListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Context f327;

        public C0089(Context context) {
            this.f327 = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                this.f327.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.alipay.sdk.m.x.e$Ԫ, reason: contains not printable characters */
    public class C0090 extends WebChromeClient {
        public C0090() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return e.this.f318.mo354(e.this, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (!e.this.f317.f332) {
                e.this.f315.setVisibility(8);
            } else {
                if (i > 90) {
                    e.this.f315.setVisibility(4);
                    return;
                }
                if (e.this.f315.getVisibility() == 4) {
                    e.this.f315.setVisibility(0);
                }
                e.this.f315.setProgress(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            e.this.f318.mo358(e.this, str);
        }
    }

    /* renamed from: com.alipay.sdk.m.x.e$Ԭ, reason: contains not printable characters */
    public class C0091 extends WebViewClient {
        public C0091() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (e.this.f319.mo353(e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (e.this.f319.mo356(e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (e.this.f319.mo359(e.this, i, str, str2)) {
                return;
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (e.this.f319.mo357(e.this, sslErrorHandler, sslError)) {
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (e.this.f319.mo355(e.this, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* renamed from: com.alipay.sdk.m.x.e$Ԯ, reason: contains not printable characters */
    public static final class C0092 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean f331;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean f332;

        public C0092(boolean z, boolean z2) {
            this.f331 = z;
            this.f332 = z2;
        }
    }

    /* renamed from: com.alipay.sdk.m.x.e$ՠ, reason: contains not printable characters */
    public interface InterfaceC0093 {
        /* renamed from: Ԩ */
        boolean mo354(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult);

        /* renamed from: Ԭ */
        void mo358(e eVar, String str);
    }

    /* renamed from: com.alipay.sdk.m.x.e$ֈ, reason: contains not printable characters */
    public interface InterfaceC0094 {
        /* renamed from: Ϳ */
        boolean mo353(e eVar, String str);

        /* renamed from: ԩ */
        boolean mo355(e eVar, String str);

        /* renamed from: Ԫ */
        boolean mo356(e eVar, String str);

        /* renamed from: ԫ */
        boolean mo357(e eVar, SslErrorHandler sslErrorHandler, SslError sslError);

        /* renamed from: ԭ */
        boolean mo359(e eVar, int i, String str, String str2);
    }

    /* renamed from: com.alipay.sdk.m.x.e$֏, reason: contains not printable characters */
    public interface InterfaceC0095 {
        /* renamed from: Ԯ */
        void mo360(e eVar);

        /* renamed from: ԯ */
        void mo361(e eVar);
    }

    public e(Context context, pa paVar, C0092 c0092) {
        this(context, null, paVar, c0092);
    }

    public ImageView getBackButton() {
        return this.f312;
    }

    public ProgressBar getProgressbar() {
        return this.f315;
    }

    public ImageView getRefreshButton() {
        return this.f314;
    }

    public TextView getTitle() {
        return this.f313;
    }

    public String getUrl() {
        return this.f316.getUrl();
    }

    public WebView getWebView() {
        return this.f316;
    }

    public void setChromeProxy(InterfaceC0093 interfaceC0093) {
        this.f318 = interfaceC0093;
        if (interfaceC0093 == null) {
            this.f316.setWebChromeClient(null);
        } else {
            this.f316.setWebChromeClient(new C0090());
        }
    }

    public void setWebClientProxy(InterfaceC0094 interfaceC0094) {
        this.f319 = interfaceC0094;
        if (interfaceC0094 == null) {
            this.f316.setWebViewClient(null);
        } else {
            this.f316.setWebViewClient(new C0091());
        }
    }

    public void setWebEventProxy(InterfaceC0095 interfaceC0095) {
        this.f320 = interfaceC0095;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m385(int i) {
        return (int) (i * this.f323);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m386() {
        removeAllViews();
        this.f316.removeAllViews();
        this.f316.setWebViewClient(null);
        this.f316.setWebChromeClient(null);
        this.f316.destroy();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m387(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(this.f317.f331 ? 0 : 8);
        ImageView imageView = new ImageView(context);
        this.f312 = imageView;
        imageView.setOnClickListener(this.f322);
        this.f312.setScaleType(ImageView.ScaleType.CENTER);
        this.f312.setImageDrawable(pg.m7980("iVBORw0KGgoAAAANSUhEUgAAAEgAAABIBAMAAACnw650AAAAFVBMVEUAAAARjusRkOkQjuoRkeoRj+oQjunya570AAAABnRSTlMAinWeSkk7CjRNAAAAZElEQVRIx+3MOw6AIBQF0YsrMDGx1obaLeGH/S9BQgkJ82rypp4ceTN1ilvyKizmZIAyU7FML0JVYig55BBAfQ2EU4V4CpZJ+2AiSj11C6rUoTannBpRn4W6xNQjLBSI2+TN0w/+3HT2wPClrQAAAABJRU5ErkJggg==", context));
        this.f312.setPadding(m385(12), 0, m385(12), 0);
        linearLayout.addView(this.f312, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(m385(1), m385(25)));
        TextView textView = new TextView(context);
        this.f313 = textView;
        textView.setTextColor(-15658735);
        this.f313.setTextSize(17.0f);
        this.f313.setMaxLines(1);
        this.f313.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(m385(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.f313, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.f314 = imageView2;
        imageView2.setOnClickListener(this.f322);
        this.f314.setScaleType(ImageView.ScaleType.CENTER);
        this.f314.setImageDrawable(pg.m7980("iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAAmVBMVEUAAAARj+oQjuoRkOsVk/AQj+oRjuoQj+oSkO3///8Rj+kRj+oQkOsTk+whm/8Qj+oRj+oQj+oSkus2p/8QjuoQj+oQj+oQj+oQj+oRj+oTkuwRj+oQj+oRj+oRj+oSkOsSkO0ZlfMbk+8XnPgQj+oRj+oQj+oQj+sSj+sRkOoSkescqv8Rj+oQj+oSj+sXku4Rj+kQjuoQjumXGBCVAAAAMnRSTlMAxPtPF8ry7CoB9npbGwe6lm0wBODazb1+aSejm5GEYjcTDwvls6uJc0g/CdWfRCF20AXrk5QAAAJqSURBVFjD7ZfXmpswEIUFphmDCxi3talurGvm/R8uYSDe5FNBwlzsxf6XmvFBmiaZ/PCdWDk9CWn61OhHCMAaXfoRAth7wx6EkMXnWyrho4yg4bDpquI8Jy78Q7eoj9cmUFijsaLM0JsD9CD0uQAa9aNdPuCFvbA7B9t/Becap8Pu6Q/2jcyH81VHc/WCHDQZXwbvtUhQ61iDlqadncU6Rp31yGkZIzOAu7AjtPpYGREzq/pY5DRFHS1siyO6HfkOKTrMjdb2qevV4zosK7MbkFY2LmYk55hL6juCIFWMOI2KGzblmho3b18EIbxL1hs6r5m2Q2WaEElwS3NW4xh6ZZJuzTtUsBKT4G0h35s4y1mNgkNoS6TZ8SKBXTZQGBNYdPTozXGYKoyLAmOasttjThT4xT6Ch+2qIjRhV9Ja3NC87Kyo5We1vCNEMW1T+j1VLZ9UhE54Q1DL52r5piJ0YxdegvWlHOwTu76uKkJX+MOTHno4YFSEbHYdhViojsLrCTg/MKnhKWaEYzvkZFM8aOkPH7iTSvoFZKD7jGEJbarkRaxQyOeWvGVIbsji152jK7TbDgRzcIuz7SGj89BFU8d30TqWeDtrILxyTkD1IXfvmHseuU3lVHDz607bw0f3xDqejm5ncd0j8VDwfoibRy8RcgTkWHBvocbDbMlJsQAkGnAOHwGy90kLmQY1Wkob07/GaCNRIzdoWK7/+6y/XkLDJCcynOGFuUrKIMuCMonNr9VpSOQoIxBgJ0SacGbzZNy4ICrkscvU2fpElYz+U3sd+aQThjfVmjNa5i15kLcojM3Gz8kP34jf4VaV3X55gNEAAAAASUVORK5CYII=", context));
        this.f314.setPadding(m385(12), 0, m385(12), 0);
        linearLayout.addView(this.f314, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, m385(48)));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m388(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        webView.getSettings().setUserAgentString(userAgentString + ug.m8446(context));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m389(String str) {
        this.f316.loadUrl(str);
        c.m345(this.f316);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m390(String str, byte[] bArr) {
        this.f316.postUrl(str, bArr);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m391(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        this.f315 = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_horizontal));
        this.f315.setMax(100);
        this.f315.setBackgroundColor(-218103809);
        addView(this.f315, new LinearLayout.LayoutParams(-1, m385(2)));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m392(Context context) {
        WebView webView = new WebView(context);
        this.f316 = webView;
        webView.setVerticalScrollbarOverlay(true);
        m388(this.f316, context);
        WebSettings settings = this.f316.getSettings();
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(false);
        this.f316.setVerticalScrollbarOverlay(true);
        this.f316.setDownloadListener(new C0089(context));
        try {
            try {
                this.f316.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f316.removeJavascriptInterface("accessibility");
                this.f316.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
            }
        } catch (Exception unused2) {
            Method method = this.f316.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (method != null) {
                method.invoke(this.f316, "searchBoxJavaBridge_");
                method.invoke(this.f316, "accessibility");
                method.invoke(this.f316, "accessibilityTraversal");
            }
        }
        c.m345(this.f316);
        addView(this.f316, new LinearLayout.LayoutParams(-1, -1));
    }

    public e(Context context, AttributeSet attributeSet, pa paVar, C0092 c0092) {
        super(context, attributeSet);
        this.f322 = new ViewOnClickListenerC0087();
        this.f317 = c0092 == null ? new C0092(false, false) : c0092;
        this.f321 = paVar;
        this.f323 = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        m387(context);
        m391(context);
        m392(context);
    }
}
