package com.xiaomi.push.service;

import android.text.TextUtils;
import com.blink.academy.film.stream.FinderManager;
import com.xiaomi.push.gf;
import com.xiaomi.push.gg;
import com.xiaomi.push.gk;
import com.xiaomi.push.gt;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class o implements gf {
    private final XMPushService a;

    public o(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.gf
    public void a(final List<gk> list, final String str, final String str2) {
        this.a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.o.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Send tiny data.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() throws NumberFormatException {
                String strA = o.this.a(str);
                ArrayList<hf> arrayListA = az.a(list, str, strA, 32768);
                if (arrayListA == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
                    return;
                }
                Iterator<hf> it = arrayListA.iterator();
                while (it.hasNext()) {
                    hf next = it.next();
                    next.a("uploadWay", "longXMPushService");
                    hc hcVarA = w.a(str, strA, next, gg.Notification);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
                        if (hcVarA.m5593a() == null) {
                            gt gtVar = new gt();
                            gtVar.a(FinderManager.MACHINE_NOT_VALID);
                            hcVarA.a(gtVar);
                        }
                        hcVarA.m5593a().b("ext_traffic_source_pkg", str2);
                    }
                    o.this.a.a(str, hq.a(hcVarA), true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }
}
