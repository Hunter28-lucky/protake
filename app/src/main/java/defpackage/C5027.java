package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import okhttp3.TlsVersion;

/* compiled from: ConnectionSpec.kt */
/* renamed from: ཊ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5027 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C2553[] f16791;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C2553[] f16792;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final C5027 f16793;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final C5027 f16794;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final C5027 f16795;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final C5027 f16796;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final C5029 f16797 = new C5029(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean f16798;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean f16799;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String[] f16800;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String[] f16801;

    /* compiled from: ConnectionSpec.kt */
    /* renamed from: ཊ$Ϳ, reason: contains not printable characters */
    public static final class C5028 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean f16802;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public String[] f16803;

        /* renamed from: ԩ, reason: contains not printable characters */
        public String[] f16804;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean f16805;

        public C5028(boolean z) {
            this.f16802 = z;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C5027 m14829() {
            return new C5027(this.f16802, this.f16805, this.f16803, this.f16804);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C5028 m14830(C2553... c2553Arr) {
            C3921.m12667(c2553Arr, "cipherSuites");
            if (!this.f16802) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(c2553Arr.length);
            for (C2553 c2553 : c2553Arr) {
                arrayList.add(c2553.m9402());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            return m14831((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C5028 m14831(String... strArr) throws CloneNotSupportedException {
            C3921.m12667(strArr, "cipherSuites");
            if (!this.f16802) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f16803 = (String[]) objClone;
            return this;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C5028 m14832(boolean z) {
            if (!this.f16802) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.f16805 = z;
            return this;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C5028 m14833(String... strArr) throws CloneNotSupportedException {
            C3921.m12667(strArr, "tlsVersions");
            if (!this.f16802) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f16804 = (String[]) objClone;
            return this;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C5028 m14834(TlsVersion... tlsVersionArr) {
            C3921.m12667(tlsVersionArr, "tlsVersions");
            if (!this.f16802) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(tlsVersionArr.length);
            for (TlsVersion tlsVersion : tlsVersionArr) {
                arrayList.add(tlsVersion.m7736());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            return m14833((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public C5028(C5027 c5027) {
            C3921.m12667(c5027, "connectionSpec");
            this.f16802 = c5027.m14825();
            this.f16803 = c5027.f16800;
            this.f16804 = c5027.f16801;
            this.f16805 = c5027.m14827();
        }
    }

    /* compiled from: ConnectionSpec.kt */
    /* renamed from: ཊ$Ԩ, reason: contains not printable characters */
    public static final class C5029 {
        public C5029() {
        }

        public /* synthetic */ C5029(C4184 c4184) {
            this();
        }
    }

    static {
        C2553 c2553 = C2553.f9546;
        C2553 c25532 = C2553.f9547;
        C2553 c25533 = C2553.f9548;
        C2553 c25534 = C2553.f9532;
        C2553 c25535 = C2553.f9536;
        C2553 c25536 = C2553.f9533;
        C2553 c25537 = C2553.f9537;
        C2553 c25538 = C2553.f9543;
        C2553 c25539 = C2553.f9542;
        C2553[] c2553Arr = {c2553, c25532, c25533, c25534, c25535, c25536, c25537, c25538, c25539};
        f16791 = c2553Arr;
        C2553[] c2553Arr2 = {c2553, c25532, c25533, c25534, c25535, c25536, c25537, c25538, c25539, C2553.f9517, C2553.f9518, C2553.f9489, C2553.f9490, C2553.f9461, C2553.f9465, C2553.f9439};
        f16792 = c2553Arr2;
        C5028 c5028M14830 = new C5028(true).m14830((C2553[]) Arrays.copyOf(c2553Arr, c2553Arr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f16793 = c5028M14830.m14834(tlsVersion, tlsVersion2).m14832(true).m14829();
        f16794 = new C5028(true).m14830((C2553[]) Arrays.copyOf(c2553Arr2, c2553Arr2.length)).m14834(tlsVersion, tlsVersion2).m14832(true).m14829();
        f16795 = new C5028(true).m14830((C2553[]) Arrays.copyOf(c2553Arr2, c2553Arr2.length)).m14834(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).m14832(true).m14829();
        f16796 = new C5028(false).m14829();
    }

    public C5027(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.f16798 = z;
        this.f16799 = z2;
        this.f16800 = strArr;
        this.f16801 = strArr2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5027)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z = this.f16798;
        C5027 c5027 = (C5027) obj;
        if (z != c5027.f16798) {
            return false;
        }
        return !z || (Arrays.equals(this.f16800, c5027.f16800) && Arrays.equals(this.f16801, c5027.f16801) && this.f16799 == c5027.f16799);
    }

    public int hashCode() {
        if (!this.f16798) {
            return 17;
        }
        String[] strArr = this.f16800;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f16801;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f16799 ? 1 : 0);
    }

    public String toString() {
        if (!this.f16798) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(m14823(), "[all enabled]") + ", tlsVersions=" + Objects.toString(m14828(), "[all enabled]") + ", supportsTlsExtensions=" + this.f16799 + ')';
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m14822(SSLSocket sSLSocket, boolean z) throws CloneNotSupportedException {
        C3921.m12667(sSLSocket, "sslSocket");
        C5027 c5027M14826 = m14826(sSLSocket, z);
        if (c5027M14826.m14828() != null) {
            sSLSocket.setEnabledProtocols(c5027M14826.f16801);
        }
        if (c5027M14826.m14823() != null) {
            sSLSocket.setEnabledCipherSuites(c5027M14826.f16800);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<C2553> m14823() {
        String[] strArr = this.f16800;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(C2553.f9551.m9405(str));
        }
        return C2543.m9382(arrayList);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean m14824(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "socket");
        if (!this.f16798) {
            return false;
        }
        String[] strArr = this.f16801;
        if (strArr != null && !i5.m6248(strArr, sSLSocket.getEnabledProtocols(), C5024.m14814())) {
            return false;
        }
        String[] strArr2 = this.f16800;
        return strArr2 == null || i5.m6248(strArr2, sSLSocket.getEnabledCipherSuites(), C2553.f9551.m9406());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m14825() {
        return this.f16798;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C5027 m14826(SSLSocket sSLSocket, boolean z) throws CloneNotSupportedException {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f16800 != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            C3921.m12663(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            enabledCipherSuites = i5.m6258(enabledCipherSuites2, this.f16800, C2553.f9551.m9406());
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f16801 != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            C3921.m12663(enabledProtocols2, "sslSocket.enabledProtocols");
            enabledProtocols = i5.m6258(enabledProtocols2, this.f16801, C5024.m14814());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        C3921.m12663(supportedCipherSuites, "supportedCipherSuites");
        int iM6251 = i5.m6251(supportedCipherSuites, "TLS_FALLBACK_SCSV", C2553.f9551.m9406());
        if (z && iM6251 != -1) {
            C3921.m12663(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[iM6251];
            C3921.m12663(str, "supportedCipherSuites[indexOfFallbackScsv]");
            enabledCipherSuites = i5.m6242(enabledCipherSuites, str);
        }
        C5028 c5028 = new C5028(this);
        C3921.m12663(enabledCipherSuites, "cipherSuitesIntersection");
        C5028 c5028M14831 = c5028.m14831((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        C3921.m12663(enabledProtocols, "tlsVersionsIntersection");
        return c5028M14831.m14833((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length)).m14829();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean m14827() {
        return this.f16799;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final List<TlsVersion> m14828() {
        String[] strArr = this.f16801;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(TlsVersion.f8127.m7737(str));
        }
        return C2543.m9382(arrayList);
    }
}
