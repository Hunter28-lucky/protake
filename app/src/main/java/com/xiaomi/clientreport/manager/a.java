package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.af;
import com.xiaomi.push.bc;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bl;
import com.xiaomi.push.bm;
import com.xiaomi.push.bn;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class a {
    private static final int a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile a f5473a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5474a;

    /* renamed from: a, reason: collision with other field name */
    private Config f5475a;

    /* renamed from: a, reason: collision with other field name */
    private IEventProcessor f5476a;

    /* renamed from: a, reason: collision with other field name */
    private IPerfProcessor f5477a;

    /* renamed from: a, reason: collision with other field name */
    private String f5478a;

    /* renamed from: a, reason: collision with other field name */
    private ExecutorService f5480a = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f5479a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    static {
        a = j.m5689a() ? 30 : 10;
    }

    private a(Context context) {
        this.f5474a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f5476a.b();
        } catch (Exception e2) {
            b.d("we: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f5477a.b();
        } catch (Exception e2) {
            b.d("wp: " + e2.getMessage());
        }
    }

    private void f() {
        if (a(this.f5474a).m5122a().isEventUploadSwitchOpen()) {
            final bj bjVar = new bj(this.f5474a);
            int eventUploadFrequency = (int) a(this.f5474a).m5122a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bn.a(this.f5474a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                af.a(this.f5474a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        bjVar.run();
                    }
                }, 10);
            }
            synchronized (a.class) {
                if (!af.a(this.f5474a).a((af.a) bjVar, eventUploadFrequency)) {
                    af.a(this.f5474a).m5196a("100886");
                    af.a(this.f5474a).a((af.a) bjVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        if (a(this.f5474a).m5122a().isPerfUploadSwitchOpen()) {
            final bk bkVar = new bk(this.f5474a);
            int perfUploadFrequency = (int) a(this.f5474a).m5122a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bn.a(this.f5474a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                af.a(this.f5474a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        bkVar.run();
                    }
                }, 15);
            }
            synchronized (a.class) {
                if (!af.a(this.f5474a).a((af.a) bkVar, perfUploadFrequency)) {
                    af.a(this.f5474a).m5196a("100887");
                    af.a(this.f5474a).a((af.a) bkVar, perfUploadFrequency);
                }
            }
        }
    }

    public void c() {
        if (m5122a().isPerfUploadSwitchOpen()) {
            bl blVar = new bl();
            blVar.a(this.f5477a);
            blVar.a(this.f5474a);
            this.f5480a.execute(blVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f5476a;
        if (iEventProcessor != null) {
            iEventProcessor.mo5125a(eventClientReport);
            if (a() >= 10) {
                d();
                af.a(this.f5474a).m5196a("100888");
            } else {
                a(new af.a() { // from class: com.xiaomi.clientreport.manager.a.3
                    @Override // com.xiaomi.push.af.a
                    /* renamed from: a */
                    public String mo5248a() {
                        return "100888";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.a() > 0) {
                            a.this.f5480a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.d();
                                }
                            });
                        }
                    }
                }, a);
            }
        }
    }

    public static a a(Context context) {
        if (f5473a == null) {
            synchronized (a.class) {
                if (f5473a == null) {
                    f5473a = new a(context);
                }
            }
        }
        return f5473a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f5477a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo5125a(perfClientReport);
            if (b() >= 10) {
                e();
                af.a(this.f5474a).m5196a("100889");
            } else {
                a(new af.a() { // from class: com.xiaomi.clientreport.manager.a.4
                    @Override // com.xiaomi.push.af.a
                    /* renamed from: a */
                    public String mo5248a() {
                        return "100889";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.b() > 0) {
                            a.this.f5480a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.e();
                                }
                            });
                        }
                    }
                }, a);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Config m5122a() {
        if (this.f5475a == null) {
            this.f5475a = Config.defaultConfig(this.f5474a);
        }
        return this.f5475a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> map = this.f5479a;
        int i = 0;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, com.xiaomi.clientreport.data.a> map2 = this.f5479a.get(it.next());
                if (map2 != null) {
                    Iterator<String> it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        com.xiaomi.clientreport.data.a aVar = map2.get(it2.next());
                        if (aVar instanceof PerfClientReport) {
                            i = (int) (i + ((PerfClientReport) aVar).perfCounts);
                        }
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5123a() {
        a(this.f5474a).f();
        a(this.f5474a).g();
    }

    public void a(String str) {
        this.f5478a = str;
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f5475a = config;
        this.f5476a = iEventProcessor;
        this.f5477a = iPerfProcessor;
        iEventProcessor.setEventMap(this.b);
        this.f5477a.setPerfMap(this.f5479a);
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f5475a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f5475a.isPerfUploadSwitchOpen() && j == this.f5475a.getEventUploadFrequency() && j2 == this.f5475a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f5475a.getEventUploadFrequency();
            long perfUploadFrequency = this.f5475a.getPerfUploadFrequency();
            Config configBuild = Config.getBuilder().setAESKey(bm.a(this.f5474a)).setEventEncrypted(this.f5475a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f5474a);
            this.f5475a = configBuild;
            if (!configBuild.isEventUploadSwitchOpen()) {
                af.a(this.f5474a).m5196a("100886");
            } else if (eventUploadFrequency != configBuild.getEventUploadFrequency()) {
                b.c(this.f5474a.getPackageName() + "reset event job " + configBuild.getEventUploadFrequency());
                f();
            }
            if (!this.f5475a.isPerfUploadSwitchOpen()) {
                af.a(this.f5474a).m5196a("100887");
                return;
            }
            if (perfUploadFrequency != configBuild.getPerfUploadFrequency()) {
                b.c(this.f5474a.getPackageName() + " reset perf job " + configBuild.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5124b() {
        if (m5122a().isEventUploadSwitchOpen()) {
            bl blVar = new bl();
            blVar.a(this.f5474a);
            blVar.a(this.f5476a);
            this.f5480a.execute(blVar);
        }
    }

    private void a(af.a aVar, int i) {
        af.a(this.f5474a).b(aVar, i);
    }

    public void a(final EventClientReport eventClientReport) {
        if (m5122a().isEventUploadSwitchOpen()) {
            this.f5480a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(eventClientReport);
                }
            });
        }
    }

    public void a(final PerfClientReport perfClientReport) {
        if (m5122a().isPerfUploadSwitchOpen()) {
            this.f5480a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(perfClientReport);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map = this.b;
        if (map == null) {
            return 0;
        }
        Iterator<String> it = map.keySet().iterator();
        int size = 0;
        while (it.hasNext()) {
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.b.get(it.next());
            size += arrayList != null ? arrayList.size() : 0;
        }
        return size;
    }

    public EventClientReport a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = bc.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f5474a.getPackageName());
        eventClientReport.setSdkVersion(this.f5478a);
        return eventClientReport;
    }
}
