package defpackage;

import java.util.Locale;

/* loaded from: classes.dex */
public final class kd {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f7825;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f7826 = ug.m8404(24);

    public kd(boolean z) {
        this.f7825 = z;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m7192(String str) {
        return Integer.parseInt(str);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m7193(int i) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static byte[] m7194(String str, String str2) {
        return le.m7505(str, str2);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static byte[] m7195(String str, byte[] bArr, String str2) {
        return nf.m7654(str, bArr, str2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:60|7|58|8|(8:52|9|(1:11)|62|12|54|13|14)|56|30|31) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* renamed from: ԭ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] m7196(byte[]... r7) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r7 == 0) goto L5f
            int r1 = r7.length
            if (r1 != 0) goto L7
            goto L5f
        L7:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            r1.<init>()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3b
            int r3 = r7.length     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L52
            r4 = 0
        L13:
            if (r4 >= r3) goto L29
            r5 = r7[r4]     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L52
            int r6 = r5.length     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L52
            java.lang.String r6 = m7193(r6)     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L52
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L52
            r2.write(r6)     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L52
            r2.write(r5)     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L52
            int r4 = r4 + 1
            goto L13
        L29:
            r2.flush()     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L52
            byte[] r7 = r1.toByteArray()     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L52
            r1.close()     // Catch: java.lang.Exception -> L33
        L33:
            r0 = r7
            goto L4e
        L35:
            r7 = move-exception
            goto L44
        L37:
            r7 = move-exception
            r2 = r0
        L39:
            r0 = r1
            goto L54
        L3b:
            r7 = move-exception
            r2 = r0
            goto L44
        L3e:
            r7 = move-exception
            r2 = r0
            goto L54
        L41:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L44:
            defpackage.hf.m6205(r7)     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L4c
            r1.close()     // Catch: java.lang.Exception -> L4c
        L4c:
            if (r2 == 0) goto L51
        L4e:
            r2.close()     // Catch: java.lang.Exception -> L51
        L51:
            return r0
        L52:
            r7 = move-exception
            goto L39
        L54:
            if (r0 == 0) goto L59
            r0.close()     // Catch: java.lang.Exception -> L59
        L59:
            if (r2 == 0) goto L5e
            r2.close()     // Catch: java.lang.Exception -> L5e
        L5e:
            throw r7
        L5f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kd.m7196(byte[][]):byte[]");
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static byte[] m7197(String str, byte[] bArr, String str2) {
        return nf.m7656(str, bArr, str2);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0076: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:119), block:B:37:0x0076 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: Ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public defpackage.ic m7198(defpackage.ne r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            byte[] r2 = r6.m7646()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r2 = 5
            byte[] r3 = new byte[r2]     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L75
            r1.read(r3)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L75
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L75
            r4.<init>(r3)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L75
            int r3 = m7192(r4)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L75
            byte[] r3 = new byte[r3]     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L75
            r1.read(r3)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L75
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L75
            r4.<init>(r3)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L75
            byte[] r2 = new byte[r2]     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            r1.read(r2)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            r3.<init>(r2)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            int r2 = m7192(r3)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            if (r2 <= 0) goto L52
            byte[] r2 = new byte[r2]     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            r1.read(r2)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            boolean r3 = r5.f7825     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            if (r3 == 0) goto L42
            java.lang.String r3 = r5.f7826     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            byte[] r2 = m7195(r3, r2, r7)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
        L42:
            boolean r6 = r6.m7647()     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            if (r6 == 0) goto L4c
            byte[] r2 = defpackage.fc.m6068(r2)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
        L4c:
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            r6.<init>(r2)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L75
            goto L53
        L52:
            r6 = r0
        L53:
            r1.close()     // Catch: java.lang.Exception -> L6a
            goto L6a
        L57:
            r6 = move-exception
            goto L61
        L59:
            r6 = move-exception
            r4 = r0
            goto L61
        L5c:
            r6 = move-exception
            goto L77
        L5e:
            r6 = move-exception
            r1 = r0
            r4 = r1
        L61:
            defpackage.hf.m6205(r6)     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.lang.Exception -> L69
        L69:
            r6 = r0
        L6a:
            if (r4 != 0) goto L6f
            if (r6 != 0) goto L6f
            return r0
        L6f:
            ic r7 = new ic
            r7.<init>(r4, r6)
            return r7
        L75:
            r6 = move-exception
            r0 = r1
        L77:
            if (r0 == 0) goto L7c
            r0.close()     // Catch: java.lang.Exception -> L7c
        L7c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kd.m7198(ne, java.lang.String):ic");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public ne m7199(ic icVar, boolean z, String str) {
        if (icVar == null) {
            return null;
        }
        byte[] bytes = icVar.m6288().getBytes();
        byte[] bytes2 = icVar.m6287().getBytes();
        if (z) {
            try {
                bytes2 = fc.m6067(bytes2);
            } catch (Exception unused) {
                z = false;
            }
        }
        return new ne(z, this.f7825 ? m7196(bytes, m7194(this.f7826, ea.f6608), m7197(this.f7826, bytes2, str)) : m7196(bytes, bytes2));
    }
}
