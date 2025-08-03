package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class am {
    private static am a;

    /* renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f6395a = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private List<a> f6394a = new ArrayList();

    public interface a {
        void a();
    }

    public static class b {

        /* renamed from: a, reason: collision with other field name */
        public Context f6396a;

        /* renamed from: a, reason: collision with other field name */
        public Messenger f6398a;

        /* renamed from: a, reason: collision with other field name */
        private XMPushService f6400a;

        /* renamed from: a, reason: collision with other field name */
        public h f6403a;

        /* renamed from: a, reason: collision with other field name */
        public String f6404a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f6406a;

        /* renamed from: b, reason: collision with other field name */
        public String f6407b;
        public String c;
        public String d;

        /* renamed from: e, reason: collision with root package name */
        public String f17900e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a, reason: collision with other field name */
        public c f6402a = c.unbind;
        private int a = 0;

        /* renamed from: a, reason: collision with other field name */
        private final CopyOnWriteArrayList<a> f6405a = new CopyOnWriteArrayList<>();
        public c b = null;

        /* renamed from: b, reason: collision with other field name */
        private boolean f6408b = false;

        /* renamed from: a, reason: collision with other field name */
        private XMPushService.c f6399a = new XMPushService.c(this);

        /* renamed from: a, reason: collision with other field name */
        public IBinder.DeathRecipient f6397a = null;

        /* renamed from: a, reason: collision with other field name */
        public final C1938b f6401a = new C1938b();

        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        public class c implements IBinder.DeathRecipient {
            public final Messenger a;

            /* renamed from: a, reason: collision with other field name */
            public final b f6411a;

            public c(b bVar, Messenger messenger) {
                this.f6411a = bVar;
                this.a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f6411a.g);
                int i = 0;
                b.this.f6400a.a(new XMPushService.j(i) { // from class: com.xiaomi.push.service.am.b.c.1
                    @Override // com.xiaomi.push.service.XMPushService.j
                    public String a() {
                        return "clear peer job";
                    }

                    @Override // com.xiaomi.push.service.XMPushService.j
                    /* renamed from: a */
                    public void mo5444a() {
                        c cVar = c.this;
                        if (cVar.a == cVar.f6411a.f6398a) {
                            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + c.this.f6411a.g);
                            c.this.f6411a.f6398a = null;
                        }
                    }
                }, 0L);
                if ("9".equals(this.f6411a.g) && "com.xiaomi.xmsf".equals(b.this.f6400a.getPackageName())) {
                    b.this.f6400a.a(new XMPushService.j(i) { // from class: com.xiaomi.push.service.am.b.c.2
                        @Override // com.xiaomi.push.service.XMPushService.j
                        public String a() {
                            return "check peer job";
                        }

                        @Override // com.xiaomi.push.service.XMPushService.j
                        /* renamed from: a */
                        public void mo5444a() {
                            am amVarA = am.a();
                            b bVar = c.this.f6411a;
                            if (amVarA.a(bVar.g, bVar.f6407b).f6398a == null) {
                                XMPushService xMPushService = b.this.f6400a;
                                b bVar2 = c.this.f6411a;
                                xMPushService.a(bVar2.g, bVar2.f6407b, 2, null, null);
                            }
                        }
                    }, 60000L);
                }
            }
        }

        public b() {
        }

        private boolean b(int i, int i2, String str) {
            if (i == 1) {
                return (this.f6402a == c.binded || !this.f6400a.m5734c() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
            }
            if (i == 2) {
                return this.f6400a.m5734c();
            }
            if (i != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        public String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: com.xiaomi.push.service.am$b$b, reason: collision with other inner class name */
        public class C1938b extends XMPushService.j {

            /* renamed from: a, reason: collision with other field name */
            public String f6409a;
            public int b;

            /* renamed from: b, reason: collision with other field name */
            public String f6410b;
            public int c;

            public C1938b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() throws RemoteException {
                if (b.this.a(this.b, this.c, this.f6410b)) {
                    b.this.a(this.b, this.c, this.f6409a, this.f6410b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f6410b = str2;
                this.f6409a = str;
                return this;
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m5765a() {
            try {
                Messenger messenger = this.f6398a;
                if (messenger != null && this.f6397a != null) {
                    messenger.getBinder().unlinkToDeath(this.f6397a, 0);
                }
            } catch (Exception unused) {
            }
            this.b = null;
        }

        public void b(a aVar) {
            this.f6405a.remove(aVar);
        }

        public void a(Messenger messenger) {
            m5765a();
            try {
                if (messenger != null) {
                    this.f6398a = messenger;
                    this.f6408b = true;
                    this.f6397a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f6397a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e2.getMessage());
                this.f6398a = null;
                this.f6408b = false;
            }
        }

        public b(XMPushService xMPushService) {
            this.f6400a = xMPushService;
            a(new a() { // from class: com.xiaomi.push.service.am.b.1
                @Override // com.xiaomi.push.service.am.b.a
                public void a(c cVar, c cVar2, int i) {
                    if (cVar2 == c.binding) {
                        b.this.f6400a.a(b.this.f6399a, 60000L);
                    } else {
                        b.this.f6400a.b(b.this.f6399a);
                    }
                }
            });
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            Iterator<a> it = this.f6405a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(this.f6402a, cVar, i2);
                }
            }
            c cVar2 = this.f6402a;
            int i3 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), an.a(i2), str, str2, this.g));
                this.f6402a = cVar;
            }
            if (this.f6403a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.b != null && (z = this.f6408b)) {
                i3 = (this.f6398a == null || !z) ? 10100 : 1000;
            }
            this.f6400a.b(this.f6401a);
            if (b(i, i2, str2)) {
                a(i, i2, str, str2);
            } else {
                this.f6400a.a(this.f6401a.a(i, i2, str, str2), i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) throws RemoteException {
            c cVar = this.f6402a;
            this.b = cVar;
            if (i == 2) {
                this.f6403a.a(this.f6396a, this, i2);
                return;
            }
            if (i == 3) {
                this.f6403a.a(this.f6396a, this, str2, str);
                return;
            }
            if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.a++;
                } else if (z) {
                    this.a = 0;
                    if (this.f6398a != null) {
                        try {
                            this.f6398a.send(Message.obtain(null, 16, this.f6400a.f6340a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f6403a.a(this.f6400a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            boolean z;
            c cVar = this.b;
            if (cVar == null || !(z = this.f6408b)) {
                return true;
            }
            if (cVar == this.f6402a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            }
            if (this.f6398a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.g);
            return false;
        }

        public void a(a aVar) {
            this.f6405a.add(aVar);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.a + 1) * 15)) * 1000;
        }

        public static String a(String str) {
            int iLastIndexOf;
            return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(iLastIndexOf + 1);
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    private am() {
    }

    public static synchronized am a() {
        if (a == null) {
            a = new am();
        }
        return a;
    }

    public synchronized void b() {
        this.f6394a.clear();
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> map = this.f6395a.get(bVar.g);
        if (map == null) {
            map = new HashMap<>();
            this.f6395a.put(bVar.g, map);
        }
        map.put(a(bVar.f6407b), bVar);
        com.xiaomi.channel.commonutils.logger.b.m5113a("add active client. " + bVar.f6404a);
        Iterator<a> it = this.f6394a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5763a(String str, String str2) {
        HashMap<String, b> map = this.f6395a.get(str);
        if (map != null) {
            b bVar = map.get(a(str2));
            if (bVar != null) {
                bVar.m5765a();
            }
            map.remove(a(str2));
            if (map.isEmpty()) {
                this.f6395a.remove(str);
            }
        }
        Iterator<a> it = this.f6394a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5762a(String str) {
        HashMap<String, b> map = this.f6395a.get(str);
        if (map != null) {
            Iterator<b> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().m5765a();
            }
            map.clear();
            this.f6395a.remove(str);
        }
        Iterator<a> it2 = this.f6394a.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized List<String> m5760a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it = this.f6395a.values().iterator();
        while (it.hasNext()) {
            for (b bVar : it.next().values()) {
                if (str.equals(bVar.f6404a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<b> m5758a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it = this.f6395a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Collection<b> m5759a(String str) {
        if (!this.f6395a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f6395a.get(str).clone()).values();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> map = this.f6395a.get(str);
        if (map == null) {
            return null;
        }
        return map.get(a(str2));
    }

    public synchronized void a(Context context, int i) {
        Iterator<HashMap<String, b>> it = this.f6395a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized int m5757a() {
        return this.f6395a.size();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5761a() {
        Iterator<b> it = m5758a().iterator();
        while (it.hasNext()) {
            it.next().m5765a();
        }
        this.f6395a.clear();
    }

    public synchronized void a(Context context) {
        Iterator<HashMap<String, b>> it = this.f6395a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("@");
        return iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
    }

    public synchronized void a(a aVar) {
        this.f6394a.add(aVar);
    }
}
