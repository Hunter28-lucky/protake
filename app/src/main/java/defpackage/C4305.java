package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* compiled from: Hpack.kt */
/* renamed from: ઈ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4305 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C3168[] f14755;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Map<ByteString, Integer> f14756;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C4305 f14757;

    static {
        C4305 c4305 = new C4305();
        f14757 = c4305;
        ByteString byteString = C3168.f11236;
        ByteString byteString2 = C3168.f11237;
        ByteString byteString3 = C3168.f11238;
        ByteString byteString4 = C3168.f11235;
        f14755 = new C3168[]{new C3168(C3168.f11239, ""), new C3168(byteString, "GET"), new C3168(byteString, "POST"), new C3168(byteString2, "/"), new C3168(byteString2, "/index.html"), new C3168(byteString3, "http"), new C3168(byteString3, "https"), new C3168(byteString4, "200"), new C3168(byteString4, "204"), new C3168(byteString4, "206"), new C3168(byteString4, "304"), new C3168(byteString4, "400"), new C3168(byteString4, "404"), new C3168(byteString4, "500"), new C3168("accept-charset", ""), new C3168("accept-encoding", HttpHeaders.HEAD_VALUE_ACCEPT_ENCODING), new C3168("accept-language", ""), new C3168("accept-ranges", ""), new C3168("accept", ""), new C3168("access-control-allow-origin", ""), new C3168("age", ""), new C3168("allow", ""), new C3168("authorization", ""), new C3168("cache-control", ""), new C3168("content-disposition", ""), new C3168("content-encoding", ""), new C3168("content-language", ""), new C3168("content-length", ""), new C3168("content-location", ""), new C3168("content-range", ""), new C3168("content-type", ""), new C3168("cookie", ""), new C3168("date", ""), new C3168("etag", ""), new C3168("expect", ""), new C3168("expires", ""), new C3168(TypedValues.TransitionType.S_FROM, ""), new C3168("host", ""), new C3168("if-match", ""), new C3168("if-modified-since", ""), new C3168("if-none-match", ""), new C3168("if-range", ""), new C3168("if-unmodified-since", ""), new C3168("last-modified", ""), new C3168("link", ""), new C3168("location", ""), new C3168("max-forwards", ""), new C3168("proxy-authenticate", ""), new C3168("proxy-authorization", ""), new C3168("range", ""), new C3168("referer", ""), new C3168("refresh", ""), new C3168("retry-after", ""), new C3168("server", ""), new C3168("set-cookie", ""), new C3168("strict-transport-security", ""), new C3168("transfer-encoding", ""), new C3168("user-agent", ""), new C3168("vary", ""), new C3168("via", ""), new C3168("www-authenticate", "")};
        f14756 = c4305.m13428();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final ByteString m13425(ByteString byteString) throws IOException {
        C3921.m12667(byteString, "name");
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b = (byte) 65;
            byte b2 = (byte) 90;
            byte b3 = byteString.getByte(i);
            if (b <= b3 && b2 >= b3) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Map<ByteString, Integer> m13426() {
        return f14756;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C3168[] m13427() {
        return f14755;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Map<ByteString, Integer> m13428() {
        C3168[] c3168Arr = f14755;
        LinkedHashMap linkedHashMap = new LinkedHashMap(c3168Arr.length);
        int length = c3168Arr.length;
        for (int i = 0; i < length; i++) {
            C3168[] c3168Arr2 = f14755;
            if (!linkedHashMap.containsKey(c3168Arr2[i].f11242)) {
                linkedHashMap.put(c3168Arr2[i].f11242, Integer.valueOf(i));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        C3921.m12663(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    /* compiled from: Hpack.kt */
    /* renamed from: ઈ$Ϳ, reason: contains not printable characters */
    public static final class C4306 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final List<C3168> f14758;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final BufferedSource f14759;

        /* renamed from: ԩ, reason: contains not printable characters */
        public C3168[] f14760;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public int f14761;

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f14762;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int f14763;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final int f14764;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public int f14765;

        public C4306(Source source, int i, int i2) {
            C3921.m12667(source, "source");
            this.f14764 = i;
            this.f14765 = i2;
            this.f14758 = new ArrayList();
            this.f14759 = Okio.buffer(source);
            this.f14760 = new C3168[8];
            this.f14761 = r2.length - 1;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m13429() {
            int i = this.f14765;
            int i2 = this.f14763;
            if (i < i2) {
                if (i == 0) {
                    m13430();
                } else {
                    m13432(i2 - i);
                }
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m13430() {
            C4955.m14733(this.f14760, null, 0, 0, 6, null);
            this.f14761 = this.f14760.length - 1;
            this.f14762 = 0;
            this.f14763 = 0;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final int m13431(int i) {
            return this.f14761 + 1 + i;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final int m13432(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f14760.length;
                while (true) {
                    length--;
                    i2 = this.f14761;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C3168 c3168 = this.f14760[length];
                    if (c3168 == null) {
                        C3921.m12675();
                    }
                    int i4 = c3168.f11241;
                    i -= i4;
                    this.f14763 -= i4;
                    this.f14762--;
                    i3++;
                }
                C3168[] c3168Arr = this.f14760;
                System.arraycopy(c3168Arr, i2 + 1, c3168Arr, i2 + 1 + i3, this.f14762);
                this.f14761 += i3;
            }
            return i3;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final List<C3168> m13433() {
            List<C3168> listM9382 = C2543.m9382(this.f14758);
            this.f14758.clear();
            return listM9382;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final ByteString m13434(int i) throws IOException {
            if (m13436(i)) {
                return C4305.f14757.m13427()[i].f11242;
            }
            int iM13431 = m13431(i - C4305.f14757.m13427().length);
            if (iM13431 >= 0) {
                C3168[] c3168Arr = this.f14760;
                if (iM13431 < c3168Arr.length) {
                    C3168 c3168 = c3168Arr[iM13431];
                    if (c3168 == null) {
                        C3921.m12675();
                    }
                    return c3168.f11242;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final void m13435(int i, C3168 c3168) {
            this.f14758.add(c3168);
            int i2 = c3168.f11241;
            if (i != -1) {
                C3168 c31682 = this.f14760[m13431(i)];
                if (c31682 == null) {
                    C3921.m12675();
                }
                i2 -= c31682.f11241;
            }
            int i3 = this.f14765;
            if (i2 > i3) {
                m13430();
                return;
            }
            int iM13432 = m13432((this.f14763 + i2) - i3);
            if (i == -1) {
                int i4 = this.f14762 + 1;
                C3168[] c3168Arr = this.f14760;
                if (i4 > c3168Arr.length) {
                    C3168[] c3168Arr2 = new C3168[c3168Arr.length * 2];
                    System.arraycopy(c3168Arr, 0, c3168Arr2, c3168Arr.length, c3168Arr.length);
                    this.f14761 = this.f14760.length - 1;
                    this.f14760 = c3168Arr2;
                }
                int i5 = this.f14761;
                this.f14761 = i5 - 1;
                this.f14760[i5] = c3168;
                this.f14762++;
            } else {
                this.f14760[i + m13431(i) + iM13432] = c3168;
            }
            this.f14763 += i2;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final boolean m13436(int i) {
            return i >= 0 && i <= C4305.f14757.m13427().length - 1;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final int m13437() throws IOException {
            return i5.m6232(this.f14759.readByte(), 255);
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final ByteString m13438() throws IOException {
            int iM13437 = m13437();
            boolean z = (iM13437 & 128) == 128;
            long jM13441 = m13441(iM13437, 127);
            if (!z) {
                return this.f14759.readByteString(jM13441);
            }
            Buffer buffer = new Buffer();
            C2322.f8832.m8723(this.f14759, jM13441, buffer);
            return buffer.readByteString();
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public final void m13439() throws IOException {
            while (!this.f14759.exhausted()) {
                int iM6232 = i5.m6232(this.f14759.readByte(), 255);
                if (iM6232 == 128) {
                    throw new IOException("index == 0");
                }
                if ((iM6232 & 128) == 128) {
                    m13440(m13441(iM6232, 127) - 1);
                } else if (iM6232 == 64) {
                    m13443();
                } else if ((iM6232 & 64) == 64) {
                    m13442(m13441(iM6232, 63) - 1);
                } else if ((iM6232 & 32) == 32) {
                    int iM13441 = m13441(iM6232, 31);
                    this.f14765 = iM13441;
                    if (iM13441 < 0 || iM13441 > this.f14764) {
                        throw new IOException("Invalid dynamic table size update " + this.f14765);
                    }
                    m13429();
                } else if (iM6232 == 16 || iM6232 == 0) {
                    m13445();
                } else {
                    m13444(m13441(iM6232, 15) - 1);
                }
            }
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public final void m13440(int i) throws IOException {
            if (m13436(i)) {
                this.f14758.add(C4305.f14757.m13427()[i]);
                return;
            }
            int iM13431 = m13431(i - C4305.f14757.m13427().length);
            if (iM13431 >= 0) {
                C3168[] c3168Arr = this.f14760;
                if (iM13431 < c3168Arr.length) {
                    List<C3168> list = this.f14758;
                    C3168 c3168 = c3168Arr[iM13431];
                    if (c3168 == null) {
                        C3921.m12675();
                    }
                    list.add(c3168);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public final int m13441(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iM13437 = m13437();
                if ((iM13437 & 128) == 0) {
                    return i2 + (iM13437 << i4);
                }
                i2 += (iM13437 & 127) << i4;
                i4 += 7;
            }
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public final void m13442(int i) throws IOException {
            m13435(-1, new C3168(m13434(i), m13438()));
        }

        /* renamed from: ހ, reason: contains not printable characters */
        public final void m13443() throws IOException {
            m13435(-1, new C3168(C4305.f14757.m13425(m13438()), m13438()));
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public final void m13444(int i) throws IOException {
            this.f14758.add(new C3168(m13434(i), m13438()));
        }

        /* renamed from: ނ, reason: contains not printable characters */
        public final void m13445() throws IOException {
            this.f14758.add(new C3168(C4305.f14757.m13425(m13438()), m13438()));
        }

        public /* synthetic */ C4306(Source source, int i, int i2, int i3, C4184 c4184) {
            this(source, i, (i3 & 4) != 0 ? i : i2);
        }
    }

    /* compiled from: Hpack.kt */
    /* renamed from: ઈ$Ԩ, reason: contains not printable characters */
    public static final class C4307 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public int f14766;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean f14767;

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f14768;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public C3168[] f14769;

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f14770;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int f14771;

        /* renamed from: ԭ, reason: contains not printable characters */
        public int f14772;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public int f14773;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean f14774;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final Buffer f14775;

        public C4307(int i, boolean z, Buffer buffer) {
            C3921.m12667(buffer, "out");
            this.f14773 = i;
            this.f14774 = z;
            this.f14775 = buffer;
            this.f14766 = Integer.MAX_VALUE;
            this.f14768 = i;
            this.f14769 = new C3168[8];
            this.f14770 = r2.length - 1;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m13446() {
            int i = this.f14768;
            int i2 = this.f14772;
            if (i < i2) {
                if (i == 0) {
                    m13447();
                } else {
                    m13448(i2 - i);
                }
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m13447() {
            C4955.m14733(this.f14769, null, 0, 0, 6, null);
            this.f14770 = this.f14769.length - 1;
            this.f14771 = 0;
            this.f14772 = 0;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final int m13448(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f14769.length;
                while (true) {
                    length--;
                    i2 = this.f14770;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C3168 c3168 = this.f14769[length];
                    if (c3168 == null) {
                        C3921.m12675();
                    }
                    i -= c3168.f11241;
                    int i4 = this.f14772;
                    C3168 c31682 = this.f14769[length];
                    if (c31682 == null) {
                        C3921.m12675();
                    }
                    this.f14772 = i4 - c31682.f11241;
                    this.f14771--;
                    i3++;
                }
                C3168[] c3168Arr = this.f14769;
                System.arraycopy(c3168Arr, i2 + 1, c3168Arr, i2 + 1 + i3, this.f14771);
                C3168[] c3168Arr2 = this.f14769;
                int i5 = this.f14770;
                Arrays.fill(c3168Arr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.f14770 += i3;
            }
            return i3;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m13449(C3168 c3168) {
            int i = c3168.f11241;
            int i2 = this.f14768;
            if (i > i2) {
                m13447();
                return;
            }
            m13448((this.f14772 + i) - i2);
            int i3 = this.f14771 + 1;
            C3168[] c3168Arr = this.f14769;
            if (i3 > c3168Arr.length) {
                C3168[] c3168Arr2 = new C3168[c3168Arr.length * 2];
                System.arraycopy(c3168Arr, 0, c3168Arr2, c3168Arr.length, c3168Arr.length);
                this.f14770 = this.f14769.length - 1;
                this.f14769 = c3168Arr2;
            }
            int i4 = this.f14770;
            this.f14770 = i4 - 1;
            this.f14769[i4] = c3168;
            this.f14771++;
            this.f14772 += i;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final void m13450(int i) {
            this.f14773 = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.f14768;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.f14766 = Math.min(this.f14766, iMin);
            }
            this.f14767 = true;
            this.f14768 = iMin;
            m13446();
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final void m13451(ByteString byteString) throws IOException {
            C3921.m12667(byteString, "data");
            if (this.f14774) {
                C2322 c2322 = C2322.f8832;
                if (c2322.m8725(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    c2322.m8724(byteString, buffer);
                    ByteString byteString2 = buffer.readByteString();
                    m13453(byteString2.size(), 127, 128);
                    this.f14775.write(byteString2);
                    return;
                }
            }
            m13453(byteString.size(), 127, 0);
            this.f14775.write(byteString);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
        /* renamed from: ԭ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m13452(java.util.List<defpackage.C3168> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 273
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C4305.C4307.m13452(java.util.List):void");
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final void m13453(int i, int i2, int i3) {
            if (i < i2) {
                this.f14775.writeByte(i | i3);
                return;
            }
            this.f14775.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f14775.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f14775.writeByte(i4);
        }

        public /* synthetic */ C4307(int i, boolean z, Buffer buffer, int i2, C4184 c4184) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, buffer);
        }
    }
}
