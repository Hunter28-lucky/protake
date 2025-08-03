package com.mob.commons.cc;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class v {

    public static class a {
        public ArrayList<Object> a;
        public DataInputStream b;
        public int c;

        public void a() throws Throwable {
            this.b.readShort();
        }

        public <T> T b() throws Throwable {
            return (T) this.a.get(this.b.readShort());
        }

        public int c() {
            return this.c;
        }

        private a(ArrayList<Object> arrayList, DataInputStream dataInputStream, int i) {
            this.a = arrayList;
            this.b = dataInputStream;
            this.c = i;
        }

        public void a(w wVar) throws Throwable {
            wVar.b = (String) this.a.get(this.b.readShort());
            wVar.c = this.b.readShort();
        }
    }

    public static class b extends a {
        @Override // com.mob.commons.cc.v.a
        public void a() throws Throwable {
            this.b.readInt();
        }

        @Override // com.mob.commons.cc.v.a
        public <T> T b() throws Throwable {
            return (T) this.a.get(this.b.readInt());
        }

        private b(ArrayList<Object> arrayList, DataInputStream dataInputStream, int i) {
            super(arrayList, dataInputStream, i);
        }

        @Override // com.mob.commons.cc.v.a
        public void a(w wVar) throws Throwable {
            wVar.b = (String) this.a.get(this.b.readInt());
            wVar.c = this.b.readInt();
        }
    }

    public static class c {
        private d a;

        public c a(Object obj) {
            this.a.a(obj);
            return this;
        }

        private c(Object obj) {
            this.a = new d(obj);
        }

        public d a(String str, Object obj) {
            return this.a.a(str, obj);
        }

        public d a(String str, Class<?> cls) {
            return this.a.a(str, cls);
        }

        public void a() throws Throwable {
            this.a.a();
        }
    }

    public static class d {
        private ArrayList<Object> a;
        private ArrayList<Object> b;
        private HashMap<String, Object> c;
        private HashMap<String, Object> d;

        /* renamed from: e, reason: collision with root package name */
        private String f17672e;
        private HashMap<Class<?>, Class<? extends r<?>>> f;

        private d(Object obj) {
            ArrayList<Object> arrayList = new ArrayList<>();
            this.a = arrayList;
            arrayList.add(obj);
            this.b = new ArrayList<>();
            this.c = new HashMap<>();
            this.d = new HashMap<>();
            this.f = new HashMap<>();
            this.c.put("t_map", this.d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj) {
            this.a.add(obj);
        }

        public d a(String str, Object obj) {
            this.c.put(str, obj);
            return this;
        }

        public d a(String str, Class<?> cls) {
            u.a.put(str, cls);
            return this;
        }

        public d a(String str) {
            this.f17672e = str;
            return this;
        }

        public <T> d a(Class<T> cls, Class<? extends r<T>> cls2) {
            this.f.put(cls, cls2);
            return this;
        }

        public void a() throws Throwable {
            byte[] bytes;
            InputStream byteArrayInputStream;
            ArrayList<w> arrayList = new ArrayList<>();
            String str = this.f17672e;
            if (str != null) {
                bytes = str.getBytes(Platform.UTF_8);
                System.arraycopy(bytes, 0, new byte[16], 0, Math.min(bytes.length, 16));
            } else {
                bytes = null;
            }
            try {
                s sVar = new s();
                Iterator<Object> it = this.a.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof String) {
                        byteArrayInputStream = new FileInputStream((String) next);
                    } else if (next instanceof byte[]) {
                        byteArrayInputStream = new ByteArrayInputStream((byte[]) next);
                    } else {
                        throw new ClassCastException("program is not string or byte array");
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    a(byteArrayInputStream, arrayList, sVar);
                    this.d.put("l_t", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                }
                for (Map.Entry<Class<?>, Class<? extends r<?>>> entry : this.f.entrySet()) {
                    sVar.a(entry.getKey(), entry.getValue());
                }
                new u(arrayList, this.b).a(this.c, sVar);
            } catch (Throwable th) {
                th = th;
                if (bytes != null) {
                    String string = th.getMessage() == null ? th.getClass().toString() : th.getMessage();
                    if (th instanceof t) {
                        th = th.getCause();
                    }
                    throw new t(a(bytes, string + MyUTIL.white_space + a(th)), th);
                }
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x003e A[Catch: all -> 0x0048, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0048, blocks: (B:18:0x0032, B:24:0x003e), top: B:40:0x0032 }] */
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
                boolean r3 = r2 instanceof java.net.UnknownHostException     // Catch: java.lang.Throwable -> L31
                if (r3 == 0) goto Le
                return r0
            Le:
                java.lang.Throwable r2 = r2.getCause()     // Catch: java.lang.Throwable -> L31
                goto L7
            L13:
                java.io.StringWriter r0 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L31
                r0.<init>()     // Catch: java.lang.Throwable -> L31
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L2e
                r1.<init>(r0)     // Catch: java.lang.Throwable -> L2e
                r5.printStackTrace(r1)     // Catch: java.lang.Throwable -> L2e
                r1.flush()     // Catch: java.lang.Throwable -> L2e
                r1.close()     // Catch: java.lang.Throwable -> L2e
                java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L2e
                r0.close()     // Catch: java.lang.Throwable -> L2d
            L2d:
                return r5
            L2e:
                r5 = move-exception
                r1 = r0
                goto L32
            L31:
                r5 = move-exception
            L32:
                boolean r0 = r5 instanceof java.lang.OutOfMemoryError     // Catch: java.lang.Throwable -> L48
                if (r0 == 0) goto L3e
                java.lang.String r5 = "getStackTraceString oom"
                if (r1 == 0) goto L3d
                r1.close()     // Catch: java.lang.Throwable -> L3d
            L3d:
                return r5
            L3e:
                java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L48
                if (r1 == 0) goto L47
                r1.close()     // Catch: java.lang.Throwable -> L47
            L47:
                return r5
            L48:
                r5 = move-exception
                if (r1 == 0) goto L4e
                r1.close()     // Catch: java.lang.Throwable -> L4e
            L4e:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.v.d.a(java.lang.Throwable):java.lang.String");
        }

        private String a(byte[] bArr, String str) {
            Cipher cipher;
            if (bArr == null) {
                return str;
            }
            try {
                byte[] bytes = str.getBytes(Platform.UTF_8);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                StringBuilder sb = new StringBuilder();
                sb.append("AES");
                sb.append("/EC");
                sb.append("B/PKCS7P");
                sb.append("adding");
                Provider provider = Security.getProvider("BC");
                if (provider != null) {
                    cipher = Cipher.getInstance(sb.toString(), provider);
                } else {
                    cipher = Cipher.getInstance(sb.toString(), "BC");
                }
                cipher.init(1, secretKeySpec);
                byte[] bArr2 = new byte[cipher.getOutputSize(bytes.length)];
                cipher.doFinal(bArr2, cipher.update(bytes, 0, bytes.length, bArr2, 0));
                return new BigInteger(1, bArr2).toString(16);
            } catch (Throwable unused) {
                return "";
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:107:0x01ec A[Catch: all -> 0x01f3, TRY_ENTER, TryCatch #7 {all -> 0x01f3, blocks: (B:107:0x01ec, B:108:0x01f0), top: B:127:0x01ea }] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x01f0 A[Catch: all -> 0x01f3, TRY_LEAVE, TryCatch #7 {all -> 0x01f3, blocks: (B:107:0x01ec, B:108:0x01f0), top: B:127:0x01ea }] */
        /* JADX WARN: Type inference failed for: r2v1, types: [com.mob.commons.cc.v$1] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(java.io.InputStream r16, java.util.ArrayList<com.mob.commons.cc.w> r17, com.mob.commons.cc.s r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 500
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.v.d.a(java.io.InputStream, java.util.ArrayList, com.mob.commons.cc.s):void");
        }
    }

    private v() {
    }

    public static int a() {
        return 70;
    }

    public static c a(String... strArr) {
        return a((Object[]) strArr);
    }

    public static c a(byte[]... bArr) {
        return a((Object[]) bArr);
    }

    private static c a(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        c cVar = new c(objArr[0]);
        for (int i = 1; i < objArr.length; i++) {
            cVar.a(objArr[i]);
        }
        return cVar;
    }
}
