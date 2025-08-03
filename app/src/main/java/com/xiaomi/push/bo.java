package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.af;
import com.xiaomi.push.bx;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class bo {
    private static volatile bo a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5623a;

    /* renamed from: a, reason: collision with other field name */
    private by f5625a;

    /* renamed from: a, reason: collision with other field name */
    private bz f5626a;

    /* renamed from: e, reason: collision with root package name */
    private String f17842e;
    private String f;

    /* renamed from: a, reason: collision with other field name */
    private final String f5627a = "push_stat_sp";

    /* renamed from: b, reason: collision with other field name */
    private final String f5628b = "upload_time";

    /* renamed from: c, reason: collision with other field name */
    private final String f5629c = "delete_time";
    private final String d = "check_time";

    /* renamed from: a, reason: collision with other field name */
    private af.a f5624a = new af.a() { // from class: com.xiaomi.push.bo.1
        @Override // com.xiaomi.push.af.a
        /* renamed from: a */
        public String mo5248a() {
            return "10052";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
            if (bo.this.f5626a != null) {
                bo.this.f5626a.a(bo.this.f5623a);
                bo.this.b("upload_time");
            }
        }
    };
    private af.a b = new af.a() { // from class: com.xiaomi.push.bo.2
        @Override // com.xiaomi.push.af.a
        /* renamed from: a */
        public String mo5248a() {
            return "10054";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
            bx.a(bo.this.f5623a).a(new bq(bo.this.c(), new WeakReference(bo.this.f5623a)));
            bo.this.b("check_time");
        }
    };
    private af.a c = new af.a() { // from class: com.xiaomi.push.bo.3
        @Override // com.xiaomi.push.af.a
        /* renamed from: a */
        public String mo5248a() {
            return "10053";
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bo.this.f5626a != null) {
                bo.this.f5626a.b(bo.this.f5623a);
                bo.this.b("delete_time");
            }
        }
    };

    private bo(Context context) {
        this.f5623a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor editorEdit = this.f5623a.getSharedPreferences("push_stat_sp", 0).edit();
        editorEdit.putLong(str, System.currentTimeMillis());
        p.a(editorEdit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f5623a.getDatabasePath(bp.f5631a).getAbsolutePath();
    }

    public static bo a(Context context) {
        if (a == null) {
            synchronized (bo.class) {
                if (a == null) {
                    a = new bo(context);
                }
            }
        }
        return a;
    }

    public String b() {
        return this.f;
    }

    private boolean a() {
        return com.xiaomi.push.service.ah.a(this.f5623a).a(gl.StatDataSwitch.a(), true);
    }

    public void a(bx.a aVar) {
        bx.a(this.f5623a).a(aVar);
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f5625a != null) {
            if (bool.booleanValue()) {
                this.f5625a.a(this.f5623a, str2, str);
            } else {
                this.f5625a.b(this.f5623a, str2, str);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5256a() {
        return this.f17842e;
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(ca.a(this.f5623a, str));
        }
    }

    public void a(gk gkVar) {
        if (a() && com.xiaomi.push.service.az.a(gkVar.e())) {
            a(bu.a(this.f5623a, c(), gkVar));
        }
    }
}
