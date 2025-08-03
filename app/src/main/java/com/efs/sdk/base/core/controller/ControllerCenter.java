package com.efs.sdk.base.core.controller;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.a.c;
import com.efs.sdk.base.core.config.b;
import com.efs.sdk.base.core.controller.a.a;
import com.efs.sdk.base.core.e.d;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.umeng.umcrash.UMCrash;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class ControllerCenter implements Handler.Callback {
    private static GlobalEnvStruct h;
    private int a = 0;
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;

    /* renamed from: e, reason: collision with root package name */
    private final int f17645e = 3;
    private volatile boolean f = false;
    private a g;
    private Handler i;

    public ControllerCenter(EfsReporter.Builder builder) {
        h = builder.getGlobalEnvStruct();
        Handler handler = new Handler(com.efs.sdk.base.core.util.concurrent.a.a.getLooper(), this);
        this.i = handler;
        handler.sendEmptyMessage(0);
    }

    private void a() {
        if (this.g == null) {
            this.g = new a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            h.mAppContext.registerReceiver(this.g, intentFilter);
        } catch (Throwable th) {
            Log.w("efs.base", "register network change receiver error", th);
            int i = this.a + 1;
            this.a = i;
            if (i < 3) {
                this.i.sendEmptyMessageDelayed(3, 6000L);
            }
        }
    }

    private void b(final ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.controller.ControllerCenter.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    iLogProtocol.insertGlobal(b.a.a.a);
                    if (!"wa".equalsIgnoreCase(iLogProtocol.getLogType())) {
                        ControllerCenter.a(iLogProtocol);
                    }
                    if (ControllerCenter.getGlobalEnvStruct().isEnableSendLog()) {
                        final com.efs.sdk.base.core.d.b bVarA = com.efs.sdk.base.core.d.b.a(iLogProtocol);
                        final d dVar = d.a.a;
                        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.e.d.1
                            public final /* synthetic */ com.efs.sdk.base.core.d.b a;

                            public AnonymousClass1(final com.efs.sdk.base.core.d.b bVarA2) {
                                bVar = bVarA2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                d.this.a.a(bVar);
                            }
                        });
                    }
                } catch (Throwable th) {
                    Log.e("efs.base", "log send error", th);
                }
            }
        });
    }

    @NonNull
    public static GlobalEnvStruct getGlobalEnvStruct() {
        return h;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == 0) {
            b bVar = b.a.a;
            com.efs.sdk.base.core.config.a aVar = new com.efs.sdk.base.core.config.a();
            bVar.a = aVar;
            aVar.a("appid", getGlobalEnvStruct().getAppid());
            int iMyPid = ProcessUtil.myPid();
            bVar.a.a("pid", Integer.valueOf(iMyPid));
            bVar.a.a("ps", ProcessUtil.getProcessName(iMyPid));
            String strA = com.efs.sdk.base.core.util.d.a(bVar.b);
            bVar.a.a("wid", strA);
            if (TextUtils.isEmpty(getGlobalEnvStruct().getUid())) {
                bVar.a.a("uid", strA);
            } else {
                bVar.a.a("uid", getGlobalEnvStruct().getUid());
            }
            com.efs.sdk.base.core.config.a aVar2 = bVar.a;
            com.efs.sdk.base.core.a.a.a();
            aVar2.a("stime", Long.valueOf(com.efs.sdk.base.core.a.a.b() - Process.getElapsedCpuTime()));
            bVar.a.a("pkg", PackageUtil.getPackageName(bVar.b));
            bVar.a.a("ver", PackageUtil.getAppVersionName(bVar.b));
            bVar.a.a("vcode", PackageUtil.getAppVersionCode(bVar.b));
            bVar.a.a("sdk_ver", BuildConfig.VERSION_NAME);
            bVar.a.a(Constants.PHONE_BRAND, Build.BRAND.toLowerCase());
            com.efs.sdk.base.core.config.a aVar3 = bVar.a;
            String str = Build.MODEL;
            aVar3.a("model", str == null ? "unknown" : str.replace(MyUTIL.white_space, Constants.ACCEPT_TIME_SEPARATOR_SERVER).replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER).toLowerCase());
            bVar.a.a("build_model", str);
            DisplayMetrics displayMetrics = bVar.b.getResources().getDisplayMetrics();
            bVar.a.a("dsp_w", Integer.valueOf(displayMetrics.widthPixels));
            bVar.a.a("dsp_h", Integer.valueOf(displayMetrics.heightPixels));
            bVar.a.a("fr", "android");
            bVar.a.a("rom", Build.VERSION.RELEASE);
            bVar.a.a("sdk", Integer.valueOf(Build.VERSION.SDK_INT));
            bVar.a.a("lang", Locale.getDefault().getLanguage());
            bVar.a.a("tzone", TimeZone.getDefault().getID());
            bVar.a.a("net", NetworkUtil.getNetworkType(bVar.b));
            try {
                String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(bVar.b);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    bVar.a.a(UMCrash.KEY_HEADER_ACCESS, NetworkUtil.NETWORK_TYPE_WIFI);
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    bVar.a.a(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
                } else {
                    bVar.a.a(UMCrash.KEY_HEADER_ACCESS, "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    bVar.a.a(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
                }
                bVar.a.a(UMCrash.KEY_HEADER_NETWORK_TYPE, Integer.valueOf(NetworkUtil.getNetworkTypeUmeng(bVar.b)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f unused = f.a.a;
            c.a().b();
            a();
            com.efs.sdk.base.core.f.f fVar = f.a.a;
            boolean zIsIntl = h.isIntl();
            com.efs.sdk.base.core.f.c cVar = fVar.a;
            if (zIsIntl) {
                cVar.a = "https://errnewlogos.umeng.com/api/crashsdk/logcollect";
                cVar.b = "4ea4e41a3993";
            } else {
                cVar.a = "https://errnewlog.umeng.com/api/crashsdk/logcollect";
                cVar.b = "28ef1713347d";
            }
            fVar.b = this;
            fVar.c.a = this;
            fVar.d.a = this;
            this.f = true;
            com.efs.sdk.base.core.c.d.a().sendEmptyMessageDelayed(0, h.getLogSendDelayMills());
            com.efs.sdk.base.core.f.f fVar2 = f.a.a;
            if (fVar2.b != null && getGlobalEnvStruct().isEnableWaStat()) {
                fVar2.b.send(new com.efs.sdk.base.core.f.b("efs_core", "pvuv", fVar2.a.c));
            }
        } else if (i == 1) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof ILogProtocol)) {
                b((ILogProtocol) obj);
            }
        } else if (i == 3) {
            a();
        }
        return true;
    }

    public void send(ILogProtocol iLogProtocol) {
        if (this.f) {
            b(iLogProtocol);
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = iLogProtocol;
        this.i.sendMessage(messageObtain);
    }

    @Nullable
    public HttpResponse sendSyncImmediately(String str, int i, String str2, boolean z, File file) {
        com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b(str, (byte) 2);
        bVar.b(1);
        bVar.d = file;
        bVar.a(str2);
        bVar.a(i);
        bVar.b.b = z;
        bVar.c();
        d.a.a.a.a(bVar);
        return bVar.b.c;
    }

    public static /* synthetic */ void a(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : getGlobalEnvStruct().getCallback(9)) {
            HashMap map = new HashMap(4);
            map.put("log_type", iLogProtocol.getLogType());
            map.put("log_data", iLogProtocol.generateString());
            map.put("link_key", iLogProtocol.getLinkKey());
            map.put("link_id", iLogProtocol.getLinkId());
            Message messageObtain = Message.obtain(null, 9, map);
            Message messageObtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(messageObtain, messageObtain2));
            messageObtain.recycle();
            messageObtain2.recycle();
        }
    }
}
