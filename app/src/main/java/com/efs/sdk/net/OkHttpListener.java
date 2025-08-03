package com.efs.sdk.net;

import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.net.a.a;
import com.efs.sdk.net.a.b;
import com.efs.sdk.net.a.c;
import defpackage.AbstractC3415;
import defpackage.C4539;
import defpackage.C4770;
import defpackage.InterfaceC5054;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Handshake;
import okhttp3.Protocol;

/* loaded from: classes.dex */
public class OkHttpListener extends AbstractC3415 {
    private static AtomicInteger a = new AtomicInteger(0);
    private String b;
    private boolean c;
    private List d = new ArrayList();

    private void a(String str) {
        Map<String, Long> map;
        try {
            c cVarC = a.a().c(this.b);
            if (cVarC == null || (map = cVarC.D) == null) {
                return;
            }
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        try {
            c cVarC = a.a().c(this.b);
            b bVarA = a.a().a(this.b);
            if (cVarC == null || bVarA == null) {
                return;
            }
            Map<String, Long> map = cVarC.D;
            Map<String, Long> map2 = cVarC.E;
            Log.i("NetTrace-Listener", bVarA.toString());
            if (TextUtils.isEmpty(cVarC.B)) {
                Log.d("NetTrace-Listener", "url is null.");
                return;
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog("netperf");
            if (map.containsKey(c.d)) {
                efsJSONLog.put("wd_dns", map.get(c.d));
            }
            if (map.containsKey(c.f17657e)) {
                efsJSONLog.put("wd_dnstm", map.get(c.f17657e));
            }
            if (map2.containsKey(c.t)) {
                efsJSONLog.put("wl_dns", map2.get(c.t));
            }
            if (map.containsKey(c.f)) {
                efsJSONLog.put("wd_tcp", map.get(c.f));
            }
            if (map.containsKey(c.i)) {
                efsJSONLog.put("wd_tcptm", map.get(c.i));
            }
            if (map2.containsKey(c.v)) {
                efsJSONLog.put("wl_tcp", map2.get(c.v));
            }
            if (map.containsKey(c.g)) {
                efsJSONLog.put("wd_ssl", map.get(c.g));
            }
            if (map.containsKey(c.h)) {
                efsJSONLog.put("wd_ssltm", map.get(c.h));
            }
            if (map2.containsKey(c.u)) {
                efsJSONLog.put("wl_ssl", map2.get(c.u));
            }
            if (map.containsKey(c.k)) {
                efsJSONLog.put("wd_ds", map.get(c.k));
            }
            if (map.containsKey(c.n)) {
                efsJSONLog.put("wd_dstm", map.get(c.n));
            }
            if (map2.containsKey(c.w) && map2.containsKey(c.x)) {
                efsJSONLog.put("wl_ds", Long.valueOf(map2.get(c.w).longValue() + map2.get(c.x).longValue()));
            }
            if (map.containsKey(c.o)) {
                efsJSONLog.put("wd_srt", map.get(c.o));
            }
            if (map.containsKey(c.r)) {
                efsJSONLog.put("wd_srttm", map.get(c.r));
            }
            if (map2.containsKey(c.y) && map2.containsKey(c.z)) {
                efsJSONLog.put("wl_srt", Long.valueOf(map2.get(c.y).longValue() + map2.get(c.z).longValue()));
            }
            String[] strArrSplit = cVarC.B.split("\\?");
            String str = strArrSplit != null ? strArrSplit[0] : null;
            List list = this.d;
            if (list == null || str == null || list.contains(str)) {
                efsJSONLog.put("wd_ttfb", 0);
                efsJSONLog.put("wd_ttfbtm", 0);
                efsJSONLog.put("wl_ttfb", 0);
            } else {
                this.d.add(str);
                if (map.containsKey(c.n)) {
                    efsJSONLog.put("wd_ttfb", map.get(c.n));
                } else if (map.containsKey(c.l)) {
                    efsJSONLog.put("wd_ttfb", map.get(c.l));
                }
                if (map.containsKey(c.o)) {
                    efsJSONLog.put("wd_ttfbtm", map.get(c.o));
                }
                if (map.containsKey(c.o)) {
                    if (map.containsKey(c.n)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(c.o).longValue() - map.get(c.n).longValue()));
                    } else if (map.containsKey(c.l)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(c.o).longValue() - map.get(c.l).longValue()));
                    }
                }
            }
            if (map.containsKey(c.a)) {
                efsJSONLog.put("wd_rt", map.get(c.a));
            }
            if (map.containsKey(c.b)) {
                efsJSONLog.put("wd_rttm", map.get(c.b));
            }
            if (map2.containsKey(c.s)) {
                efsJSONLog.put("wl_rt", map2.get(c.s));
            }
            efsJSONLog.put("wk_res", cVarC.B);
            efsJSONLog.put("wk_method", bVarA.f17656e);
            efsJSONLog.put("wk_rc", Integer.valueOf(bVarA.g));
            efsJSONLog.put("wl_up", Long.valueOf(bVarA.f));
            efsJSONLog.put("wl_down", Long.valueOf(bVarA.i));
            efsJSONLog.put("wl_total", Long.valueOf(bVarA.f + bVarA.i));
            EfsReporter reporter = NetManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
                a.a().d(this.b);
                a.a().b(this.b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static AbstractC3415.InterfaceC3418 get() {
        return new AbstractC3415.InterfaceC3418() { // from class: com.efs.sdk.net.OkHttpListener.1
            @Override // defpackage.AbstractC3415.InterfaceC3418
            public final AbstractC3415 create(InterfaceC5054 interfaceC5054) {
                return new OkHttpListener();
            }
        };
    }

    @Override // defpackage.AbstractC3415
    public void callEnd(InterfaceC5054 interfaceC5054) {
        super.callEnd(interfaceC5054);
        try {
            Log.d("NetTrace-Listener", "callEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callEnd net enable false.");
                return;
            }
            a(c.b);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void callFailed(InterfaceC5054 interfaceC5054, IOException iOException) {
        super.callFailed(interfaceC5054, iOException);
        try {
            Log.d("NetTrace-Listener", "callFailed");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callFailed net enable false.");
                return;
            }
            a(c.c);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void callStart(InterfaceC5054 interfaceC5054) {
        super.callStart(interfaceC5054);
        try {
            Log.d("NetTrace-Listener", "callStart");
            if (NetManager.getNetConfigManager() != null && NetManager.getNetConfigManager().enableTracer()) {
                this.c = true;
            }
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            this.b = String.valueOf(a.getAndIncrement());
            Log.i("NetTrace-Listener", "requestId is" + this.b);
            a(c.a);
            String string = interfaceC5054.request().m13925().toString();
            try {
                c cVarC = a.a().c(this.b);
                if (cVarC != null) {
                    cVarC.B = string;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void connectEnd(InterfaceC5054 interfaceC5054, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(interfaceC5054, inetSocketAddress, proxy, protocol);
        try {
            Log.d("NetTrace-Listener", "connectEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectEnd net enable false.");
                return;
            }
            a(c.i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void connectFailed(InterfaceC5054 interfaceC5054, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(interfaceC5054, inetSocketAddress, proxy, protocol, iOException);
        try {
            Log.d("NetTrace-Listener", "connectFailed");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectFailed net enable false.");
                return;
            }
            a(c.j);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void connectStart(InterfaceC5054 interfaceC5054, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(interfaceC5054, inetSocketAddress, proxy);
        try {
            Log.d("NetTrace-Listener", "connectStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectStart net enable false.");
                return;
            }
            a(c.f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void dnsEnd(InterfaceC5054 interfaceC5054, String str, List<InetAddress> list) {
        super.dnsEnd(interfaceC5054, str, list);
        try {
            Log.d("NetTrace-Listener", "dnsEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsEnd net enable false.");
                return;
            }
            a(c.f17657e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void dnsStart(InterfaceC5054 interfaceC5054, String str) {
        super.dnsStart(interfaceC5054, str);
        try {
            Log.d("NetTrace-Listener", "dnsStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsStart net enable false.");
                return;
            }
            a(c.d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void requestBodyEnd(InterfaceC5054 interfaceC5054, long j) {
        super.requestBodyEnd(interfaceC5054, j);
        try {
            Log.d("NetTrace-Listener", "requestBodyEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyEnd net enable false.");
                return;
            }
            a(c.n);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void requestBodyStart(InterfaceC5054 interfaceC5054) {
        super.requestBodyStart(interfaceC5054);
        try {
            Log.d("NetTrace-Listener", "requestBodyStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyStart net enable false.");
                return;
            }
            a(c.m);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void requestHeadersEnd(InterfaceC5054 interfaceC5054, C4539 c4539) {
        super.requestHeadersEnd(interfaceC5054, c4539);
        try {
            Log.d("NetTrace-Listener", "requestHeadersEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersEnd net enable false.");
                return;
            }
            a(c.l);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void requestHeadersStart(InterfaceC5054 interfaceC5054) {
        super.requestHeadersStart(interfaceC5054);
        try {
            Log.d("NetTrace-Listener", "requestHeadersStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersStart net enable false.");
                return;
            }
            a(c.k);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void responseBodyEnd(InterfaceC5054 interfaceC5054, long j) {
        super.responseBodyEnd(interfaceC5054, j);
        try {
            Log.d("NetTrace-Listener", "responseBodyEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyEnd net enable false.");
                return;
            }
            a(c.r);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void responseBodyStart(InterfaceC5054 interfaceC5054) {
        super.responseBodyStart(interfaceC5054);
        try {
            Log.d("NetTrace-Listener", "responseBodyStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyStart net enable false.");
                return;
            }
            a(c.q);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void responseHeadersEnd(InterfaceC5054 interfaceC5054, C4770 c4770) {
        super.responseHeadersEnd(interfaceC5054, c4770);
        try {
            Log.d("NetTrace-Listener", "responseHeadersEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersEnd net enable false.");
                return;
            }
            a(c.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void responseHeadersStart(InterfaceC5054 interfaceC5054) {
        super.responseHeadersStart(interfaceC5054);
        try {
            Log.d("NetTrace-Listener", "responseHeadersStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersStart net enable false.");
                return;
            }
            a(c.o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void secureConnectEnd(InterfaceC5054 interfaceC5054, Handshake handshake) {
        super.secureConnectEnd(interfaceC5054, handshake);
        try {
            Log.d("NetTrace-Listener", "secureConnectEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectEnd net enable false.");
                return;
            }
            a(c.h);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC3415
    public void secureConnectStart(InterfaceC5054 interfaceC5054) {
        super.secureConnectStart(interfaceC5054);
        try {
            Log.d("NetTrace-Listener", "secureConnectStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectStart net enable false.");
                return;
            }
            a(c.g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        try {
            c cVarC = a.a().c(this.b);
            if (cVarC != null) {
                Map<String, Long> map = cVarC.D;
                Map<String, Long> map2 = cVarC.E;
                map2.put(c.s, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.a, c.b)));
                map2.put(c.t, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.d, c.f17657e)));
                map2.put(c.u, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.g, c.h)));
                map2.put(c.v, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f, c.i)));
                map2.put(c.w, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.k, c.l)));
                map2.put(c.x, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.m, c.n)));
                map2.put(c.y, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.o, c.p)));
                map2.put(c.z, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.q, c.r)));
                b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
