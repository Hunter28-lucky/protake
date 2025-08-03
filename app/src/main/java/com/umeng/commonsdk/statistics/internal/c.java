package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: NetworkHelper.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f17814e = false;
    private static boolean f = false;
    private static boolean g = false;
    private String a = "10.0.0.172";
    private int b = 80;
    private Context c;
    private b d;

    public c(Context context) {
        this.c = context;
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_p", "");
        String strImprintProperty4 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(strImprintProperty3);
        }
        if (!TextUtils.isEmpty(strImprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(strImprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (g) {
            return;
        }
        ImprintHandler.getImprintService(this.c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.b()) {
                    FieldManager.a().a(c.this.c, str2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(c.this.c, com.umeng.commonsdk.internal.a.w, com.umeng.commonsdk.internal.b.a(c.this.c).a(), null);
                }
            }
        });
        g = true;
    }

    private void d() {
        if (f) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.c);
                UMWorkDispatch.sendEvent(c.this.c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.c).a(), null);
                ImprintHandler.getImprintService(c.this.c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.c, str2);
                UMWorkDispatch.sendEvent(c.this.c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.c).a(), null);
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(c.this.c, o.a.D, CoreProtocol.getInstance(c.this.c), null, 0L);
                    }
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    l.a(c.this.c).b(c.this.c);
                }
                ImprintHandler.getImprintService(c.this.c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f = true;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    public byte[] a(byte[] bArr, boolean z, boolean z2, String str) throws IOException {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        int i = 0;
        byte[] bArrA = null;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i >= strArr.length) {
                break;
            }
            String str2 = strArr[i];
            if (z2) {
                d();
            } else {
                c();
            }
            bArrA = a(bArr, str2 + File.separator + str);
            if (bArrA != null) {
                b bVar = this.d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z);
                }
            } else {
                b bVar2 = this.d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i++;
            }
        }
        return bArrA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x015e: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:84:0x016a, block:B:79:0x015e */
    public byte[] a(byte[] bArr, String str) throws IOException {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z;
        try {
            try {
                b bVar = this.d;
                if (bVar != null) {
                    bVar.onRequestStart();
                }
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    z = true;
                    if (!f17814e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        f17814e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", a.a(this.c).b());
                    httpsURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_TYPE, a.a(this.c).a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                } catch (UnknownHostException unused) {
                    outputStream = null;
                } catch (SSLHandshakeException unused2) {
                    outputStream = null;
                } catch (Throwable unused3) {
                    outputStream = null;
                }
                try {
                    outputStream.write(bArr);
                    outputStream.flush();
                    httpsURLConnection.connect();
                    b bVar2 = this.d;
                    if (bVar2 != null) {
                        bVar2.onRequestEnd();
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    String headerField = httpsURLConnection.getHeaderField(HttpHeaders.HEAD_KEY_CONTENT_TYPE);
                    if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                        z = false;
                    }
                    String str2 = AnalyticsConstants.OS;
                    if (responseCode == 200 && z) {
                        InputStream inputStream = httpsURLConnection.getInputStream();
                        try {
                            byte[] streamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                            try {
                                outputStream.close();
                            } catch (Exception e2) {
                                UMCrashManager.reportCrash(this.c, e2);
                            }
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused4) {
                            }
                            httpsURLConnection.disconnect();
                            return streamToByteArray;
                        } finally {
                            HelperUtils.safeClose(inputStream);
                        }
                    }
                    try {
                        outputStream.close();
                    } catch (Exception e3) {
                        UMCrashManager.reportCrash(this.c, e3);
                    }
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused5) {
                    }
                    httpsURLConnection.disconnect();
                    return null;
                } catch (UnknownHostException unused6) {
                    UMLog.aq("A_10200", 2, "\\|");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e4) {
                            UMCrashManager.reportCrash(this.c, e4);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused7) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return null;
                } catch (SSLHandshakeException unused8) {
                    UMLog.aq("A_10201", 2, "\\|");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e5) {
                            UMCrashManager.reportCrash(this.c, e5);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused9) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable unused10) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e6) {
                            UMCrashManager.reportCrash(this.c, e6);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused11) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return null;
                }
            } catch (UnknownHostException unused12) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (SSLHandshakeException unused13) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (Throwable unused14) {
                httpsURLConnection = null;
                outputStream = null;
            }
        } catch (Throwable th) {
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception e7) {
                    UMCrashManager.reportCrash(this.c, e7);
                }
            }
            if (str == 0) {
                throw th;
            }
            try {
                str.getInputStream().close();
            } catch (IOException unused15) {
            }
            str.disconnect();
            throw th;
        }
    }
}
