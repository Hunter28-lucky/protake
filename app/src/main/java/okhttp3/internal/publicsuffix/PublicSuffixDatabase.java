package okhttp3.internal.publicsuffix;

import defpackage.C2543;
import defpackage.C2708;
import defpackage.C3131;
import defpackage.C3921;
import defpackage.C4119;
import defpackage.C4184;
import defpackage.C5064;
import defpackage.i5;
import io.jsonwebtoken.JwtParser;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: PublicSuffixDatabase.kt */
/* loaded from: classes2.dex */
public final class PublicSuffixDatabase {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final AtomicBoolean f8233 = new AtomicBoolean(false);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final CountDownLatch f8234 = new CountDownLatch(1);

    /* renamed from: ԩ, reason: contains not printable characters */
    public byte[] f8235;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public byte[] f8236;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final C2221 f8232 = new C2221(null);

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final byte[] f8229 = {(byte) 42};

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final List<String> f8230 = C5064.m14877("*");

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final PublicSuffixDatabase f8231 = new PublicSuffixDatabase();

    /* compiled from: PublicSuffixDatabase.kt */
    /* renamed from: okhttp3.internal.publicsuffix.PublicSuffixDatabase$Ϳ, reason: contains not printable characters */
    public static final class C2221 {
        public C2221() {
        }

        public /* synthetic */ C2221(C4184 c4184) {
            this();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final String m7857(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z;
            int iM6232;
            int iM62322;
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = (i3 + length) / 2;
                while (i4 > -1 && bArr[i4] != ((byte) 10)) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (bArr[i2] == ((byte) 10)) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        iM6232 = 46;
                        z = false;
                    } else {
                        z = z2;
                        iM6232 = i5.m6232(bArr2[i8][i9], 255);
                    }
                    iM62322 = iM6232 - i5.m6232(bArr[i5 + i10], 255);
                    if (iM62322 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    }
                    if (bArr2[i8].length != i9) {
                        z2 = z;
                    } else {
                        if (i8 == bArr2.length - 1) {
                            break;
                        }
                        i8++;
                        i9 = -1;
                        z2 = true;
                    }
                }
                if (iM62322 >= 0) {
                    if (iM62322 <= 0) {
                        int i11 = i7 - i10;
                        int length2 = bArr2[i8].length - i9;
                        int length3 = bArr2.length;
                        for (int i12 = i8 + 1; i12 < length3; i12++) {
                            length2 += bArr2[i12].length;
                        }
                        if (length2 >= i11) {
                            if (length2 <= i11) {
                                Charset charset = StandardCharsets.UTF_8;
                                C3921.m12663(charset, "UTF_8");
                                return new String(bArr, i5, i7, charset);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                length = i5 - 1;
            }
            return null;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final PublicSuffixDatabase m7858() {
            return PublicSuffixDatabase.f8231;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<String> m7851(List<String> list) throws InterruptedException {
        String str;
        String strM7857;
        String str2;
        List<String> listM10712;
        List<String> listM107122;
        if (this.f8233.get() || !this.f8233.compareAndSet(false, true)) {
            try {
                this.f8234.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            m7854();
        }
        if (!(this.f8235 != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i < size; i++) {
            String str3 = list.get(i);
            Charset charset = StandardCharsets.UTF_8;
            C3921.m12663(charset, "UTF_8");
            if (str3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str3.getBytes(charset);
            C3921.m12663(bytes, "(this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= size) {
                strM7857 = null;
                break;
            }
            C2221 c2221 = f8232;
            byte[] bArr2 = this.f8235;
            if (bArr2 == null) {
                C3921.m12681("publicSuffixListBytes");
            }
            strM7857 = c2221.m7857(bArr2, bArr, i2);
            if (strM7857 != null) {
                break;
            }
            i2++;
        }
        if (size > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            for (int i3 = 0; i3 < length; i3++) {
                bArr3[i3] = f8229;
                C2221 c22212 = f8232;
                byte[] bArr4 = this.f8235;
                if (bArr4 == null) {
                    C3921.m12681("publicSuffixListBytes");
                }
                String strM78572 = c22212.m7857(bArr4, bArr3, i3);
                if (strM78572 != null) {
                    str2 = strM78572;
                    break;
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            int i4 = size - 1;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    break;
                }
                C2221 c22213 = f8232;
                byte[] bArr5 = this.f8236;
                if (bArr5 == null) {
                    C3921.m12681("publicSuffixExceptionListBytes");
                }
                String strM78573 = c22213.m7857(bArr5, bArr, i5);
                if (strM78573 != null) {
                    str = strM78573;
                    break;
                }
                i5++;
            }
        }
        if (str != null) {
            return StringsKt__StringsKt.m7305('!' + str, new char[]{JwtParser.SEPARATOR_CHAR}, false, 0, 6, null);
        }
        if (strM7857 == null && str2 == null) {
            return f8230;
        }
        if (strM7857 == null || (listM10712 = StringsKt__StringsKt.m7305(strM7857, new char[]{JwtParser.SEPARATOR_CHAR}, false, 0, 6, null)) == null) {
            listM10712 = C3131.m10712();
        }
        if (str2 == null || (listM107122 = StringsKt__StringsKt.m7305(str2, new char[]{JwtParser.SEPARATOR_CHAR}, false, 0, 6, null)) == null) {
            listM107122 = C3131.m10712();
        }
        return listM10712.size() > listM107122.size() ? listM10712 : listM107122;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m7852(String str) throws InterruptedException {
        int size;
        int size2;
        C3921.m12667(str, "domain");
        String unicode = IDN.toUnicode(str);
        C3921.m12663(unicode, "unicodeDomain");
        List<String> listM7855 = m7855(unicode);
        List<String> listM7851 = m7851(listM7855);
        if (listM7855.size() == listM7851.size() && listM7851.get(0).charAt(0) != '!') {
            return null;
        }
        if (listM7851.get(0).charAt(0) == '!') {
            size = listM7855.size();
            size2 = listM7851.size();
        } else {
            size = listM7855.size();
            size2 = listM7851.size() + 1;
        }
        return C4119.m13077(C4119.m13074(C2543.m9367(m7855(str)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: all -> 0x0045, TryCatch #0 {, blocks: (B:9:0x0032, B:10:0x0035, B:12:0x0039, B:13:0x003c), top: B:26:0x0032 }] */
    /* renamed from: Ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m7853() throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r5 = this;
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            if (r0 == 0) goto L4f
            okio.GzipSource r1 = new okio.GzipSource
            okio.Source r0 = okio.Okio.source(r0)
            r1.<init>(r0)
            okio.BufferedSource r0 = okio.Okio.buffer(r1)
            r1 = 0
            int r2 = r0.readInt()     // Catch: java.lang.Throwable -> L48
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L48
            byte[] r2 = r0.readByteArray(r2)     // Catch: java.lang.Throwable -> L48
            int r3 = r0.readInt()     // Catch: java.lang.Throwable -> L48
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L48
            byte[] r3 = r0.readByteArray(r3)     // Catch: java.lang.Throwable -> L48
            i4 r4 = defpackage.i4.f6762     // Catch: java.lang.Throwable -> L48
            defpackage.C3494.m11412(r0, r1)
            monitor-enter(r5)
            if (r2 != 0) goto L35
            defpackage.C3921.m12675()     // Catch: java.lang.Throwable -> L45
        L35:
            r5.f8235 = r2     // Catch: java.lang.Throwable -> L45
            if (r3 != 0) goto L3c
            defpackage.C3921.m12675()     // Catch: java.lang.Throwable -> L45
        L3c:
            r5.f8236 = r3     // Catch: java.lang.Throwable -> L45
            monitor-exit(r5)
            java.util.concurrent.CountDownLatch r0 = r5.f8234
            r0.countDown()
            return
        L45:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L48:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L4a
        L4a:
            r2 = move-exception
            defpackage.C3494.m11412(r0, r1)
            throw r2
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.m7853():void");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m7854() {
        boolean z = false;
        while (true) {
            try {
                try {
                    m7853();
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e2) {
                    C2708.f10025.m9964().m9955("Failed to read public suffix list", 5, e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final List<String> m7855(String str) {
        List<String> listM7305 = StringsKt__StringsKt.m7305(str, new char[]{JwtParser.SEPARATOR_CHAR}, false, 0, 6, null);
        return C3921.m12662((String) C2543.m9375(listM7305), "") ? C2543.m9368(listM7305, 1) : listM7305;
    }
}
