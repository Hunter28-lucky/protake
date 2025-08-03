package defpackage;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import okio.Buffer;
import okio.ByteString;

/* compiled from: HttpHeaders.kt */
/* renamed from: ত, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4186 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final ByteString f14446;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final ByteString f14447;

    static {
        ByteString.Companion companion = ByteString.Companion;
        f14446 = companion.encodeUtf8("\"\\");
        f14447 = companion.encodeUtf8("\t ,=");
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final boolean m13203(C4770 c4770) {
        C3921.m12667(c4770, "response");
        return m13205(c4770);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final List<C2671> m13204(C5207 c5207, String str) {
        C3921.m12667(c5207, "$this$parseChallenges");
        C3921.m12667(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = c5207.size();
        for (int i = 0; i < size; i++) {
            if (e0.m5967(str, c5207.m15183(i), true)) {
                try {
                    m13206(new Buffer().writeUtf8(c5207.m15185(i)), arrayList);
                } catch (EOFException e2) {
                    C2708.f10025.m9964().m9955("Unable to parse challenge", 5, e2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final boolean m13205(C4770 c4770) {
        C3921.m12667(c4770, "$this$promisesBody");
        if (C3921.m12662(c4770.m14347().m13923(), "HEAD")) {
            return false;
        }
        int iM14334 = c4770.m14334();
        return (((iM14334 >= 100 && iM14334 < 200) || iM14334 == 204 || iM14334 == 304) && i5.m6249(c4770) == -1 && !e0.m5967("chunked", C4770.m14329(c4770, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0085, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0085, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* renamed from: Ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m13206(okio.Buffer r7, java.util.List<defpackage.C2671> r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            m13210(r7)
            java.lang.String r1 = m13208(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = m13210(r7)
            java.lang.String r3 = m13208(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.exhausted()
            if (r7 != 0) goto L1f
            return
        L1f:
            ʔ r7 = new ʔ
            java.util.Map r0 = kotlin.collections.C2138.m7235()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            byte r4 = (byte) r4
            int r5 = defpackage.i5.m6264(r7, r4)
            boolean r6 = m13210(r7)
            if (r2 != 0) goto L68
            if (r6 != 0) goto L41
            boolean r2 = r7.exhausted()
            if (r2 == 0) goto L68
        L41:
            ʔ r2 = new ʔ
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "="
            java.lang.String r3 = defpackage.e0.m5972(r3, r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "Collections.singletonMap…ek + \"=\".repeat(eqCount))"
            defpackage.C3921.m12663(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L68:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = defpackage.i5.m6264(r7, r4)
            int r5 = r5 + r6
        L72:
            if (r3 != 0) goto L83
            java.lang.String r3 = m13208(r7)
            boolean r5 = m13210(r7)
            if (r5 == 0) goto L7f
            goto L85
        L7f:
            int r5 = defpackage.i5.m6264(r7, r4)
        L83:
            if (r5 != 0) goto L90
        L85:
            ʔ r4 = new ʔ
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L90:
            r6 = 1
            if (r5 <= r6) goto L94
            return
        L94:
            boolean r6 = m13210(r7)
            if (r6 == 0) goto L9b
            return
        L9b:
            r6 = 34
            byte r6 = (byte) r6
            boolean r6 = m13211(r7, r6)
            if (r6 == 0) goto La9
            java.lang.String r6 = m13207(r7)
            goto Lad
        La9:
            java.lang.String r6 = m13208(r7)
        Lad:
            if (r6 == 0) goto Lc7
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lb8
            return
        Lb8:
            boolean r3 = m13210(r7)
            if (r3 != 0) goto Lc5
            boolean r3 = r7.exhausted()
            if (r3 != 0) goto Lc5
            return
        Lc5:
            r3 = r0
            goto L72
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C4186.m13206(okio.Buffer, java.util.List):void");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final String m13207(Buffer buffer) throws EOFException {
        byte b = (byte) 34;
        if (!(buffer.readByte() == b)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long jIndexOfElement = buffer.indexOfElement(f14446);
            if (jIndexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(jIndexOfElement) == b) {
                buffer2.write(buffer, jIndexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            }
            if (buffer.size() == jIndexOfElement + 1) {
                return null;
            }
            buffer2.write(buffer, jIndexOfElement);
            buffer.readByte();
            buffer2.write(buffer, 1L);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final String m13208(Buffer buffer) {
        long jIndexOfElement = buffer.indexOfElement(f14447);
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        if (jIndexOfElement != 0) {
            return buffer.readUtf8(jIndexOfElement);
        }
        return null;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final void m13209(InterfaceC2896 interfaceC2896, C3573 c3573, C5207 c5207) {
        C3921.m12667(interfaceC2896, "$this$receiveHeaders");
        C3921.m12667(c3573, ImagesContract.URL);
        C3921.m12667(c5207, "headers");
        if (interfaceC2896 == InterfaceC2896.f10573) {
            return;
        }
        List<C2632> listM9716 = C2632.f9794.m9716(c3573, c5207);
        if (listM9716.isEmpty()) {
            return;
        }
        interfaceC2896.saveFromResponse(c3573, listM9716);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final boolean m13210(Buffer buffer) throws EOFException {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b = buffer.getByte(0L);
            if (b == 9 || b == 32) {
                buffer.readByte();
            } else {
                if (b != 44) {
                    break;
                }
                buffer.readByte();
                z = true;
            }
        }
        return z;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final boolean m13211(Buffer buffer, byte b) {
        return !buffer.exhausted() && buffer.getByte(0L) == b;
    }
}
