package com.xiaomi.push;

import com.xiaomi.push.en;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;

/* loaded from: classes2.dex */
class em implements am.b.a {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private fb f5850a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f5851a;

    /* renamed from: a, reason: collision with other field name */
    private am.b f5852a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f5854a = false;

    /* renamed from: a, reason: collision with other field name */
    private am.c f5853a = am.c.binding;

    /* renamed from: com.xiaomi.push.em$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[am.c.values().length];
            a = iArr;
            try {
                iArr[am.c.unbind.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[am.c.binding.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[am.c.binded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public em(XMPushService xMPushService, am.b bVar) {
        this.f5851a = xMPushService;
        this.f5852a = bVar;
    }

    private void b() {
        this.f5852a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f5854a && this.a != 11) {
            ek ekVarM5449a = ep.m5447a().m5449a();
            int i = AnonymousClass2.a[this.f5853a.ordinal()];
            if (i == 1) {
                int i2 = this.a;
                if (i2 == 17) {
                    ekVarM5449a.f5836a = ej.BIND_TCP_READ_TIMEOUT.a();
                } else if (i2 == 21) {
                    ekVarM5449a.f5836a = ej.BIND_TIMEOUT.a();
                } else {
                    try {
                        en.a aVarC = en.c(ep.a().a());
                        ekVarM5449a.f5836a = aVarC.a.a();
                        ekVarM5449a.c(aVarC.f5855a);
                    } catch (NullPointerException unused) {
                        ekVarM5449a = null;
                    }
                }
            } else if (i == 3) {
                ekVarM5449a.f5836a = ej.BIND_SUCCESS.a();
            }
            if (ekVarM5449a != null) {
                ekVarM5449a.b(this.f5850a.mo5479a());
                ekVarM5449a.d(this.f5852a.f6407b);
                ekVarM5449a.f5839b = 1;
                try {
                    ekVarM5449a.a((byte) Integer.parseInt(this.f5852a.g));
                } catch (NumberFormatException unused2) {
                }
                ep.m5447a().a(ekVarM5449a);
            }
        }
    }

    public void a() {
        this.f5852a.a(this);
        this.f5850a = this.f5851a.m5726a();
    }

    @Override // com.xiaomi.push.service.am.b.a
    public void a(am.c cVar, am.c cVar2, int i) {
        if (!this.f5854a && cVar == am.c.binding) {
            this.f5853a = cVar2;
            this.a = i;
            this.f5854a = true;
        }
        this.f5851a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.em.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Handling bind stats";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a, reason: collision with other method in class */
            public void mo5444a() {
                em.this.c();
            }
        });
    }
}
