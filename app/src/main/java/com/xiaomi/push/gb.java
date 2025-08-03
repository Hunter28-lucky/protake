package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* loaded from: classes2.dex */
public class gb implements XMPushService.n {
    private static boolean a = false;

    /* renamed from: a, reason: collision with other field name */
    private int f5960a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5961a;
    private boolean b;

    public gb(Context context) {
        this.f5961a = context;
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a, reason: collision with other method in class */
    public void mo5522a() {
        a(this.f5961a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            gf gfVarA = ge.a(this.f5961a).a();
            if (a(gfVarA)) {
                a = true;
                gc.a(this.f5961a, gfVarA);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m5113a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ah.a(context).a(gl.TinyDataUploadSwitch.a(), true);
        int iA = com.xiaomi.push.service.ah.a(context).a(gl.TinyDataUploadFrequency.a(), 7200);
        this.f5960a = iA;
        this.f5960a = Math.max(60, iA);
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f5961a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f5960a);
    }

    private boolean a(gf gfVar) {
        if (!av.m5216a(this.f5961a) || gfVar == null || TextUtils.isEmpty(a(this.f5961a.getPackageName())) || !new File(this.f5961a.getFilesDir(), "tiny_data.data").exists() || a) {
            return false;
        }
        return !com.xiaomi.push.service.ah.a(this.f5961a).a(gl.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m5681a(this.f5961a) || i.m5684b(this.f5961a);
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f5961a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    public static void a(boolean z) {
        a = z;
    }
}
