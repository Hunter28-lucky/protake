package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gl;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class e implements AbstractPushManager {
    private static volatile e a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5524a;

    /* renamed from: a, reason: collision with other field name */
    private PushConfiguration f5525a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f5527a = false;

    /* renamed from: a, reason: collision with other field name */
    private Map<d, AbstractPushManager> f5526a = new HashMap();

    /* renamed from: com.xiaomi.mipush.sdk.e$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private e(Context context) {
        this.f5524a = context.getApplicationContext();
    }

    public boolean b(d dVar) {
        int i = AnonymousClass2.a[dVar.ordinal()];
        boolean openCOSPush = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f5525a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        }
        if (i == 2) {
            PushConfiguration pushConfiguration2 = this.f5525a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        }
        if (i == 3) {
            PushConfiguration pushConfiguration3 = this.f5525a;
            if (pushConfiguration3 != null) {
                openCOSPush = pushConfiguration3.getOpenCOSPush();
            }
        } else if (i != 4) {
            return false;
        }
        PushConfiguration pushConfiguration4 = this.f5525a;
        return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : openCOSPush;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m5113a("ASSEMBLE_PUSH : assemble push register");
        if (this.f5526a.size() <= 0) {
            a();
        }
        if (this.f5526a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f5526a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            f.m5160a(this.f5524a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m5113a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f5526a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f5526a.clear();
    }

    public static e a(Context context) {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(context);
                }
            }
        }
        return a;
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f5525a = pushConfiguration;
        this.f5527a = ah.a(this.f5524a).a(gl.AggregatePushSwitch.a(), true);
        if (this.f5525a.getOpenHmsPush() || this.f5525a.getOpenFCMPush() || this.f5525a.getOpenCOSPush() || this.f5525a.getOpenFTOSPush()) {
            ah.a(this.f5524a).a(new ah.a(101, "assemblePush") { // from class: com.xiaomi.mipush.sdk.e.1
                @Override // com.xiaomi.push.service.ah.a
                public void onCallback() {
                    boolean zA = ah.a(e.this.f5524a).a(gl.AggregatePushSwitch.a(), true);
                    if (e.this.f5527a != zA) {
                        e.this.f5527a = zA;
                        f.b(e.this.f5524a);
                    }
                }
            });
        }
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f5526a.containsKey(dVar)) {
                this.f5526a.remove(dVar);
            }
            this.f5526a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5157a(d dVar) {
        this.f5526a.remove(dVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5158a(d dVar) {
        return this.f5526a.containsKey(dVar);
    }

    public AbstractPushManager a(d dVar) {
        return this.f5526a.get(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.e.a():void");
    }
}
