package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class g extends Handler implements e {
    private final ConcurrentHashMap<String, a> a;
    private com.efs.sdk.base.core.e.a.d b;
    private com.efs.sdk.base.core.e.a.c c;

    public static class a extends FileOutputStream {
        public long a;
        public File b;

        public a(@NonNull File file) {
            super(file);
            this.b = file;
            this.a = System.currentTimeMillis();
        }
    }

    public g() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        this.a = new ConcurrentHashMap<>();
        this.b = new com.efs.sdk.base.core.e.a.d();
        this.c = new com.efs.sdk.base.core.e.a.c();
    }

    private static long b(String str) {
        Map<String, String> mapC = com.efs.sdk.base.core.config.a.c.a().c();
        String strConcat = "record_accumulation_time_".concat(String.valueOf(str));
        if (!mapC.containsKey(strConcat)) {
            return 60000L;
        }
        String str2 = mapC.get(strConcat);
        if (TextUtils.isEmpty(str2)) {
            return 60000L;
        }
        try {
            return Math.max(Long.parseLong(str2) * 1000, 1000L);
        } catch (Throwable th) {
            Log.e("efs.cache", "get cache interval error", th);
            return 60000L;
        }
    }

    private void c(String str) {
        a aVar;
        if (this.a.containsKey(str) && (aVar = this.a.get(str)) != null) {
            try {
                aVar.flush();
                com.efs.sdk.base.core.util.b.a(aVar);
                a(aVar.b);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    this.a.remove(str);
                    if ("wa".equalsIgnoreCase(str)) {
                        return;
                    }
                    f.a.a.c.c();
                } finally {
                    this.a.remove(str);
                    if (!"wa".equalsIgnoreCase(str)) {
                        f.a.a.c.c();
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = bVar;
        messageObtain.what = 0;
        sendMessage(messageObtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                c(obj.toString());
                return;
            }
            return;
        }
        com.efs.sdk.base.core.d.b bVar = (com.efs.sdk.base.core.d.b) message.obj;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                a aVarB = b(bVar);
                if (aVarB == null) {
                    Log.w("efs.cache", "writer is null for type " + bVar.a.a);
                    return;
                }
                if (aVarB.getChannel().position() + bVar.c.length > 819200) {
                    c(bVar.a.a);
                    aVarB = b(bVar);
                    if (aVarB == null) {
                        Log.w("efs.cache", "writer is null for type " + bVar.a.a);
                        return;
                    }
                }
                aVarB.write(Base64.encode(bVar.c, 11));
                aVarB.write("\n".getBytes());
                return;
            } catch (Throwable th) {
                Log.e("efs.cache", "cache file error", th);
            }
        }
    }

    @Override // com.efs.sdk.base.core.b.e
    public final boolean a(File file, com.efs.sdk.base.core.d.b bVar) {
        if (!bVar.b()) {
            a(file);
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        bVar.d = file;
        bVar.c();
        bVar.b(1);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.efs.sdk.base.core.b.g.a b(com.efs.sdk.base.core.d.b r6) {
        /*
            r5 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.b.g$a> r0 = r5.a
            com.efs.sdk.base.core.d.a r1 = r6.a
            java.lang.String r1 = r1.a
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L19
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.b.g$a> r0 = r5.a
            com.efs.sdk.base.core.d.a r6 = r6.a
            java.lang.String r6 = r6.a
            java.lang.Object r6 = r0.get(r6)
            com.efs.sdk.base.core.b.g$a r6 = (com.efs.sdk.base.core.b.g.a) r6
            return r6
        L19:
            java.lang.String r0 = com.efs.sdk.base.core.util.b.a(r6)
            java.io.File r1 = new java.io.File
            com.efs.sdk.base.core.config.GlobalEnvStruct r2 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            android.content.Context r2 = r2.mAppContext
            com.efs.sdk.base.core.config.GlobalEnvStruct r3 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            java.lang.String r3 = r3.getAppid()
            java.io.File r2 = com.efs.sdk.base.core.util.a.e(r2, r3)
            r1.<init>(r2, r0)
            r0 = 0
            com.efs.sdk.base.core.b.g$a r2 = new com.efs.sdk.base.core.b.g$a     // Catch: java.lang.Throwable -> L66
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L66
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.b.g$a> r0 = r5.a     // Catch: java.lang.Throwable -> L64
            com.efs.sdk.base.core.d.a r3 = r6.a     // Catch: java.lang.Throwable -> L64
            java.lang.String r3 = r3.a     // Catch: java.lang.Throwable -> L64
            java.lang.Object r0 = r0.putIfAbsent(r3, r2)     // Catch: java.lang.Throwable -> L64
            com.efs.sdk.base.core.b.g$a r0 = (com.efs.sdk.base.core.b.g.a) r0     // Catch: java.lang.Throwable -> L64
            if (r0 == 0) goto L4f
            com.efs.sdk.base.core.util.b.a(r2)     // Catch: java.lang.Throwable -> L64
            com.efs.sdk.base.core.util.b.b(r1)     // Catch: java.lang.Throwable -> L64
            return r0
        L4f:
            android.os.Message r0 = android.os.Message.obtain()     // Catch: java.lang.Throwable -> L64
            com.efs.sdk.base.core.d.a r1 = r6.a     // Catch: java.lang.Throwable -> L64
            java.lang.String r1 = r1.a     // Catch: java.lang.Throwable -> L64
            r0.obj = r1     // Catch: java.lang.Throwable -> L64
            r3 = 1
            r0.what = r3     // Catch: java.lang.Throwable -> L64
            long r3 = b(r1)     // Catch: java.lang.Throwable -> L64
            r5.sendMessageDelayed(r0, r3)     // Catch: java.lang.Throwable -> L64
            goto L6c
        L64:
            r0 = move-exception
            goto L69
        L66:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L69:
            r0.printStackTrace()
        L6c:
            com.efs.sdk.base.core.d.a r6 = r6.a
            java.lang.String r6 = r6.a
            java.lang.String r0 = "wa"
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 != 0) goto L81
            com.efs.sdk.base.core.f.f r6 = com.efs.sdk.base.core.f.f.a.a()
            com.efs.sdk.base.core.f.d r6 = r6.c
            r6.b()
        L81:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.b.g.b(com.efs.sdk.base.core.d.b):com.efs.sdk.base.core.b.g$a");
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = str;
        messageObtain.what = 1;
        sendMessage(messageObtain);
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(File file) {
        byte[] bArr;
        com.efs.sdk.base.core.d.b bVarB = com.efs.sdk.base.core.util.b.b(file.getName());
        if (bVarB == null) {
            com.efs.sdk.base.core.b.a unused = a.b.a;
            com.efs.sdk.base.core.b.a.b(file);
        } else if (!a(bVarB, file) || (bArr = bVarB.c) == null || bArr.length <= 0) {
            com.efs.sdk.base.core.b.a unused2 = a.b.a;
            com.efs.sdk.base.core.b.a.b(file);
        } else {
            com.efs.sdk.base.core.util.b.a(new File(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), com.efs.sdk.base.core.util.b.a(bVarB)), bVarB.c);
            com.efs.sdk.base.core.util.b.b(file);
        }
    }

    private boolean a(com.efs.sdk.base.core.d.b bVar, File file) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        String strB = com.efs.sdk.base.core.util.b.b.b(line.getBytes());
                        if (!TextUtils.isEmpty(strB)) {
                            sb.append(strB);
                            sb.append("\n");
                        }
                    }
                    bVar.a(sb.toString().getBytes());
                    bVar.c();
                    this.c.a(bVar);
                    bVar.d = file;
                    com.efs.sdk.base.core.util.b.a(bufferedReader);
                    com.efs.sdk.base.core.util.b.a(fileReader2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    try {
                        Log.e("efs.cache", "local decode error", th);
                        com.efs.sdk.base.core.util.b.a(bufferedReader);
                        com.efs.sdk.base.core.util.b.a(fileReader);
                        return false;
                    } catch (Throwable th2) {
                        com.efs.sdk.base.core.util.b.a(bufferedReader);
                        com.efs.sdk.base.core.util.b.a(fileReader);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }
}
