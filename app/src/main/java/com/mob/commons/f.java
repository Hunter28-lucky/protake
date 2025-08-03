package com.mob.commons;

import android.os.Message;
import android.text.TextUtils;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes2.dex */
public class f {
    private static final String a = com.mob.commons.a.d.a("004LfmDiVejfe");
    private static f b;
    private NetCommunicator c;
    private String f;
    private Runnable h;
    private SimpleDateFormat d = new SimpleDateFormat(com.mob.commons.a.d.a("025XejejejejijhjhjijUii jdieieBgmmg+ghghfmfififijdhd"));

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Object> f17678e = new HashMap<>();
    private int g = -1;

    private f() {
        this.f = null;
        try {
            this.f = UUID.randomUUID().toString();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        this.h = new com.mob.tools.utils.e() { // from class: com.mob.commons.f.1
            @Override // com.mob.tools.utils.e
            public void a() {
                if (b.c()) {
                    f.this.c();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        boolean zA;
        File[] fileArrListFiles;
        if (this.f17678e.size() > 0) {
            zA = a(this.f17678e);
            if (!zA) {
                c(this.f17678e);
            }
            this.f17678e.clear();
        } else {
            zA = true;
        }
        if (zA) {
            File fileE = e();
            if (!fileE.exists() || !fileE.isDirectory() || (fileArrListFiles = fileE.listFiles()) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                if (a((HashMap<String, Object>) ResHelper.readObjectFromFile(file.getAbsolutePath())) && !file.delete()) {
                    file.delete();
                }
            }
        }
    }

    private void d() {
        if (this.c == null) {
            this.c = new NetCommunicator(1024, "ab0a0a6473d1891d388773574764b239d4ad80cb2fd3a83d81d03901c1548c13fee7c9692c326e6682b239d4c5d0021d1b607642c47ec29f10b0602908c3e6c9", "23c3c8cb41c47dd288cc7f4c218fbc7c839a34e0a0d1b2130e87b7914936b120a2d6570ee7ac66282328d50f2acfd82f2259957c89baea32547758db05de9cd7c6822304c8e45742f24bbbe41c1e12f09e18c6fab4d078065f2e5aaed94c900c66e8bbf8a120eefa7bd1fb52114d529250084f5f6f369ed4ce9645978dd30c51");
        }
    }

    private File e() {
        return new File(ResHelper.getDataCache(MobSDK.getContext()), a);
    }

    private synchronized int b() {
        return this.g;
    }

    public static synchronized f a() {
        if (b == null) {
            b = new f();
        }
        return b;
    }

    private boolean b(HashMap<String, Object> map) throws Throwable {
        if (map == null || map.isEmpty()) {
            return true;
        }
        HashMap<String, Object> mapF = q.f();
        mapF.put(com.mob.commons.a.d.a("006j2eieifdeigh"), map);
        d();
        String str = c.a(c.f) + com.mob.commons.a.d.a("004hiJeife");
        if ("1".equals(String.valueOf(map.get("saa")))) {
            str = c.a("sdrl") + "/sdrl";
        }
        HashMap map2 = (HashMap) this.c.requestSynchronized(mapF, str, false);
        return map2 == null || map2.isEmpty();
    }

    private void d(HashMap<String, Object> map) throws Throwable {
        File[] fileArrListFiles;
        File fileE = e();
        if (!fileE.exists() || !fileE.isDirectory()) {
            fileE.delete();
            fileE.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        String str = a;
        sb.append(str);
        sb.append("_");
        int i = 0;
        sb.append(0);
        File file = new File(fileE, sb.toString());
        if (file.exists() && (fileArrListFiles = fileE.listFiles()) != null && fileArrListFiles.length > 0) {
            file = new File(fileE, str + "_0");
            while (file.exists()) {
                i++;
                file = new File(fileE, a + "_" + i);
            }
        }
        ResHelper.saveObjectToFile(file.getPath(), map);
    }

    public synchronized void a(int i, Throwable th) {
        a(i, th, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized void a(int i, Throwable th, String str, boolean z) {
        if (th == null) {
            MobLog.getInstance().d(str, new Object[0]);
        } else {
            MobLog.getInstance().d(th);
        }
        if (e.a()) {
            return;
        }
        final Message message = new Message();
        message.what = 1;
        message.arg1 = z ? 1 : 0;
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        if (th == null) {
            th = str;
        }
        objArr[1] = th;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(b());
        message.obj = objArr;
        u.d.execute(new com.mob.tools.utils.e() { // from class: com.mob.commons.f.2
            @Override // com.mob.tools.utils.e
            public void a() {
                f.this.a(message);
            }
        });
    }

    private void c(HashMap<String, Object> map) {
        try {
            d(map);
        } catch (Throwable th) {
            try {
                d(map);
            } catch (Throwable unused) {
                MobLog.getInstance().d(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        String strValueOf;
        if (this.f17678e.size() > 10) {
            c(this.f17678e);
            this.f17678e.clear();
        }
        Object[] objArr = (Object[]) message.obj;
        this.f17678e.put("saa", Integer.valueOf(message.arg1));
        this.f17678e.put(com.mob.commons.a.d.a("0024ghCi"), this.f);
        ArrayList arrayList = (ArrayList) this.f17678e.get(com.mob.commons.a.d.a("004Sfeefgh3e"));
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        HashMap map = new HashMap();
        map.put(com.mob.commons.a.d.a("002 eh)e"), objArr[0]);
        Object obj = objArr[1];
        if (obj instanceof Throwable) {
            strValueOf = a((Throwable) obj);
        } else {
            strValueOf = String.valueOf(obj);
        }
        if (!TextUtils.isEmpty(strValueOf)) {
            strValueOf = strValueOf.replaceAll("\r\n\t", MyUTIL.white_space).replaceAll("\n\t", MyUTIL.white_space).replaceAll("\n", MyUTIL.white_space);
        }
        map.put(com.mob.commons.a.d.a("002m>gg"), "[" + this.d.format(objArr[0]) + "][" + objArr[2] + "][" + objArr[3] + "] " + strValueOf);
        map.put(com.mob.commons.a.d.a("002je"), objArr[2]);
        map.put(com.mob.commons.a.d.a("002f4fd"), objArr[3]);
        arrayList.add(map);
        this.f17678e.put(com.mob.commons.a.d.a("004<feefgh(e"), arrayList);
        if (e.a()) {
            return;
        }
        DH.requester(MobSDK.getContext()).checkNetworkAvailable().request(new DH.DHResponder() { // from class: com.mob.commons.f.3
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                com.mob.commons.a.d.a().b(!dHResponse.checkNetworkAvailable() ? 120L : 10L, f.this.h);
            }
        });
    }

    private boolean a(HashMap<String, Object> map) {
        try {
            return b(map);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            try {
                return b(map);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
                return false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #1 {all -> 0x0049, blocks: (B:18:0x002f, B:20:0x0033, B:24:0x003f), top: B:38:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f A[Catch: all -> 0x0049, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0049, blocks: (B:18:0x002f, B:20:0x0033, B:24:0x003f), top: B:38:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.Throwable r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            if (r5 != 0) goto L5
            return r0
        L5:
            r1 = 0
            r2 = r5
        L7:
            if (r2 == 0) goto L13
            boolean r3 = r2 instanceof java.net.UnknownHostException     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto Le
            return r0
        Le:
            java.lang.Throwable r2 = r2.getCause()     // Catch: java.lang.Throwable -> L2e
            goto L7
        L13:
            java.io.StringWriter r0 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L2e
            r0.<init>()     // Catch: java.lang.Throwable -> L2e
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L2b
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L2b
            r5.printStackTrace(r1)     // Catch: java.lang.Throwable -> L2b
            r1.flush()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L2b
            r0.close()     // Catch: java.lang.Throwable -> L2a
        L2a:
            return r5
        L2b:
            r5 = move-exception
            r1 = r0
            goto L2f
        L2e:
            r5 = move-exception
        L2f:
            boolean r0 = r5 instanceof java.lang.OutOfMemoryError     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L3f
            java.lang.String r5 = "023Mgg0je2fi?e>egehekfjeiegeh!j[fiIe7eiefelggjdfdfdFm"
            java.lang.String r5 = com.mob.commons.a.d.a(r5)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L3e
            r1.close()     // Catch: java.lang.Throwable -> L3e
        L3e:
            return r5
        L3f:
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Throwable -> L48
        L48:
            return r5
        L49:
            r5 = move-exception
            if (r1 == 0) goto L4f
            r1.close()     // Catch: java.lang.Throwable -> L4f
        L4f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.f.a(java.lang.Throwable):java.lang.String");
    }
}
