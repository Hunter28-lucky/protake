package defpackage;

import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.polidea.rxandroidble2.ClientComponent;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import defpackage.AbstractC2918;
import defpackage.AbstractC3415;
import defpackage.C2708;
import defpackage.InterfaceC5054;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import okhttp3.CertificatePinner;
import okhttp3.Protocol;

/* compiled from: OkHttpClient.kt */
/* renamed from: လ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5121 implements Cloneable, InterfaceC5054.InterfaceC5055 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C2319 f16972;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C5198 f16973;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final List<InterfaceC2818> f16974;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final List<InterfaceC2818> f16975;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC3415.InterfaceC3418 f16976;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean f16977;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final InterfaceC5130 f16978;

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean f16979;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final boolean f16980;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final InterfaceC2896 f16981;

    /* renamed from: ހ, reason: contains not printable characters */
    public final C3661 f16982;

    /* renamed from: ށ, reason: contains not printable characters */
    public final InterfaceC3113 f16983;

    /* renamed from: ނ, reason: contains not printable characters */
    public final Proxy f16984;

    /* renamed from: ރ, reason: contains not printable characters */
    public final ProxySelector f16985;

    /* renamed from: ބ, reason: contains not printable characters */
    public final InterfaceC5130 f16986;

    /* renamed from: ޅ, reason: contains not printable characters */
    public final SocketFactory f16987;

    /* renamed from: ކ, reason: contains not printable characters */
    public final SSLSocketFactory f16988;

    /* renamed from: އ, reason: contains not printable characters */
    public final X509TrustManager f16989;

    /* renamed from: ވ, reason: contains not printable characters */
    public final List<C5027> f16990;

    /* renamed from: މ, reason: contains not printable characters */
    public final List<Protocol> f16991;

    /* renamed from: ފ, reason: contains not printable characters */
    public final HostnameVerifier f16992;

    /* renamed from: ދ, reason: contains not printable characters */
    public final CertificatePinner f16993;

    /* renamed from: ތ, reason: contains not printable characters */
    public final AbstractC2918 f16994;

    /* renamed from: ލ, reason: contains not printable characters */
    public final int f16995;

    /* renamed from: ގ, reason: contains not printable characters */
    public final int f16996;

    /* renamed from: ޏ, reason: contains not printable characters */
    public final int f16997;

    /* renamed from: ސ, reason: contains not printable characters */
    public final int f16998;

    /* renamed from: ޑ, reason: contains not printable characters */
    public final int f16999;

    /* renamed from: ޒ, reason: contains not printable characters */
    public final long f17000;

    /* renamed from: ޓ, reason: contains not printable characters */
    public final C4488 f17001;

    /* renamed from: ޖ, reason: contains not printable characters */
    public static final C5123 f16971 = new C5123(null);

    /* renamed from: ޔ, reason: contains not printable characters */
    public static final List<Protocol> f16969 = i5.m6250(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* renamed from: ޕ, reason: contains not printable characters */
    public static final List<C5027> f16970 = i5.m6250(C5027.f16794, C5027.f16796);

    /* compiled from: OkHttpClient.kt */
    /* renamed from: လ$Ԩ, reason: contains not printable characters */
    public static final class C5123 {
        public C5123() {
        }

        public /* synthetic */ C5123(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final List<C5027> m15028() {
            return C5121.f16970;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final List<Protocol> m15029() {
            return C5121.f16969;
        }
    }

    public C5121(C5122 c5122) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelectorM15014;
        C3921.m12667(c5122, "builder");
        this.f16972 = c5122.m15001();
        this.f16973 = c5122.m14998();
        this.f16974 = i5.m6271(c5122.m15007());
        this.f16975 = i5.m6271(c5122.m15009());
        this.f16976 = c5122.m15003();
        this.f16977 = c5122.m15016();
        this.f16978 = c5122.m14992();
        this.f16979 = c5122.m15004();
        this.f16980 = c5122.m15005();
        this.f16981 = c5122.m15000();
        this.f16982 = c5122.m14993();
        this.f16983 = c5122.m15002();
        this.f16984 = c5122.m15012();
        if (c5122.m15012() != null) {
            proxySelectorM15014 = C4487.f15394;
        } else {
            proxySelectorM15014 = c5122.m15014();
            proxySelectorM15014 = proxySelectorM15014 == null ? ProxySelector.getDefault() : proxySelectorM15014;
            if (proxySelectorM15014 == null) {
                proxySelectorM15014 = C4487.f15394;
            }
        }
        this.f16985 = proxySelectorM15014;
        this.f16986 = c5122.m15013();
        this.f16987 = c5122.m15018();
        List<C5027> listM14999 = c5122.m14999();
        this.f16990 = listM14999;
        this.f16991 = c5122.m15011();
        this.f16992 = c5122.m15006();
        this.f16995 = c5122.m14994();
        this.f16996 = c5122.m14997();
        this.f16997 = c5122.m15015();
        this.f16998 = c5122.m15020();
        this.f16999 = c5122.m15010();
        this.f17000 = c5122.m15008();
        C4488 c4488M15017 = c5122.m15017();
        this.f17001 = c4488M15017 == null ? new C4488() : c4488M15017;
        boolean z = true;
        if (!(listM14999 instanceof Collection) || !listM14999.isEmpty()) {
            Iterator<T> it = listM14999.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((C5027) it.next()).m14825()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            this.f16988 = null;
            this.f16994 = null;
            this.f16989 = null;
            this.f16993 = CertificatePinner.f8100;
        } else if (c5122.m15019() != null) {
            this.f16988 = c5122.m15019();
            AbstractC2918 abstractC2918M14995 = c5122.m14995();
            if (abstractC2918M14995 == null) {
                C3921.m12675();
            }
            this.f16994 = abstractC2918M14995;
            X509TrustManager x509TrustManagerM15021 = c5122.m15021();
            if (x509TrustManagerM15021 == null) {
                C3921.m12675();
            }
            this.f16989 = x509TrustManagerM15021;
            CertificatePinner certificatePinnerM14996 = c5122.m14996();
            if (abstractC2918M14995 == null) {
                C3921.m12675();
            }
            this.f16993 = certificatePinnerM14996.m7715(abstractC2918M14995);
        } else {
            C2708.C2709 c2709 = C2708.f10025;
            X509TrustManager x509TrustManagerMo8814 = c2709.m9964().mo8814();
            this.f16989 = x509TrustManagerMo8814;
            C2708 c2708M9964 = c2709.m9964();
            if (x509TrustManagerMo8814 == null) {
                C3921.m12675();
            }
            this.f16988 = c2708M9964.mo9957(x509TrustManagerMo8814);
            AbstractC2918.C2919 c2919 = AbstractC2918.f10624;
            if (x509TrustManagerMo8814 == null) {
                C3921.m12675();
            }
            AbstractC2918 abstractC2918M10312 = c2919.m10312(x509TrustManagerMo8814);
            this.f16994 = abstractC2918M10312;
            CertificatePinner certificatePinnerM149962 = c5122.m14996();
            if (abstractC2918M10312 == null) {
                C3921.m12675();
            }
            this.f16993 = certificatePinnerM149962.m7715(abstractC2918M10312);
        }
        m14981();
    }

    public Object clone() {
        return super.clone();
    }

    @Override // defpackage.InterfaceC5054.InterfaceC5055
    /* renamed from: Ϳ */
    public InterfaceC5054 mo14869(C4539 c4539) {
        C3921.m12667(c4539, "request");
        return new C2503(this, c4539, false);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5130 m14952() {
        return this.f16978;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C3661 m14953() {
        return this.f16982;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int m14954() {
        return this.f16995;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC2918 m14955() {
        return this.f16994;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final CertificatePinner m14956() {
        return this.f16993;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int m14957() {
        return this.f16996;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final C5198 m14958() {
        return this.f16973;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final List<C5027> m14959() {
        return this.f16990;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final InterfaceC2896 m14960() {
        return this.f16981;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final C2319 m14961() {
        return this.f16972;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final InterfaceC3113 m14962() {
        return this.f16983;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final AbstractC3415.InterfaceC3418 m14963() {
        return this.f16976;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final boolean m14964() {
        return this.f16979;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final boolean m14965() {
        return this.f16980;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final C4488 m14966() {
        return this.f17001;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final HostnameVerifier m14967() {
        return this.f16992;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final List<InterfaceC2818> m14968() {
        return this.f16974;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final long m14969() {
        return this.f17000;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final List<InterfaceC2818> m14970() {
        return this.f16975;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public C5122 m14971() {
        return new C5122(this);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final int m14972() {
        return this.f16999;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final List<Protocol> m14973() {
        return this.f16991;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final Proxy m14974() {
        return this.f16984;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final InterfaceC5130 m14975() {
        return this.f16986;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final ProxySelector m14976() {
        return this.f16985;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final int m14977() {
        return this.f16997;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final boolean m14978() {
        return this.f16977;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final SocketFactory m14979() {
        return this.f16987;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final SSLSocketFactory m14980() {
        SSLSocketFactory sSLSocketFactory = this.f16988;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m14981() {
        boolean z;
        if (this.f16974 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r0.contains(null))) {
            throw new IllegalStateException(("Null interceptor: " + this.f16974).toString());
        }
        if (this.f16975 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r0.contains(null))) {
            throw new IllegalStateException(("Null network interceptor: " + this.f16975).toString());
        }
        List<C5027> list = this.f16990;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = true;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((C5027) it.next()).m14825()) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (!z) {
            if (this.f16988 == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.f16994 == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.f16989 == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.f16988 == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f16994 == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f16989 == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!C3921.m12662(this.f16993, CertificatePinner.f8100)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final int m14982() {
        return this.f16998;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final X509TrustManager m14983() {
        return this.f16989;
    }

    /* compiled from: OkHttpClient.kt */
    /* renamed from: လ$Ϳ, reason: contains not printable characters */
    public static final class C5122 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C2319 f17002;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C5198 f17003;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final List<InterfaceC2818> f17004;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final List<InterfaceC2818> f17005;

        /* renamed from: ԫ, reason: contains not printable characters */
        public AbstractC3415.InterfaceC3418 f17006;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f17007;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC5130 f17008;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f17009;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f17010;

        /* renamed from: ՠ, reason: contains not printable characters */
        public InterfaceC2896 f17011;

        /* renamed from: ֈ, reason: contains not printable characters */
        public C3661 f17012;

        /* renamed from: ֏, reason: contains not printable characters */
        public InterfaceC3113 f17013;

        /* renamed from: ׯ, reason: contains not printable characters */
        public Proxy f17014;

        /* renamed from: ؠ, reason: contains not printable characters */
        public ProxySelector f17015;

        /* renamed from: ހ, reason: contains not printable characters */
        public InterfaceC5130 f17016;

        /* renamed from: ށ, reason: contains not printable characters */
        public SocketFactory f17017;

        /* renamed from: ނ, reason: contains not printable characters */
        public SSLSocketFactory f17018;

        /* renamed from: ރ, reason: contains not printable characters */
        public X509TrustManager f17019;

        /* renamed from: ބ, reason: contains not printable characters */
        public List<C5027> f17020;

        /* renamed from: ޅ, reason: contains not printable characters */
        public List<? extends Protocol> f17021;

        /* renamed from: ކ, reason: contains not printable characters */
        public HostnameVerifier f17022;

        /* renamed from: އ, reason: contains not printable characters */
        public CertificatePinner f17023;

        /* renamed from: ވ, reason: contains not printable characters */
        public AbstractC2918 f17024;

        /* renamed from: މ, reason: contains not printable characters */
        public int f17025;

        /* renamed from: ފ, reason: contains not printable characters */
        public int f17026;

        /* renamed from: ދ, reason: contains not printable characters */
        public int f17027;

        /* renamed from: ތ, reason: contains not printable characters */
        public int f17028;

        /* renamed from: ލ, reason: contains not printable characters */
        public int f17029;

        /* renamed from: ގ, reason: contains not printable characters */
        public long f17030;

        /* renamed from: ޏ, reason: contains not printable characters */
        public C4488 f17031;

        public C5122() {
            this.f17002 = new C2319();
            this.f17003 = new C5198();
            this.f17004 = new ArrayList();
            this.f17005 = new ArrayList();
            this.f17006 = i5.m6235(AbstractC3415.NONE);
            this.f17007 = true;
            InterfaceC5130 interfaceC5130 = InterfaceC5130.f17044;
            this.f17008 = interfaceC5130;
            this.f17009 = true;
            this.f17010 = true;
            this.f17011 = InterfaceC2896.f10573;
            this.f17013 = InterfaceC3113.f11070;
            this.f17016 = interfaceC5130;
            SocketFactory socketFactory = SocketFactory.getDefault();
            C3921.m12663(socketFactory, "SocketFactory.getDefault()");
            this.f17017 = socketFactory;
            C5123 c5123 = C5121.f16971;
            this.f17020 = c5123.m15028();
            this.f17021 = c5123.m15029();
            this.f17022 = C4718.f15983;
            this.f17023 = CertificatePinner.f8100;
            this.f17026 = ModuleDescriptor.MODULE_VERSION;
            this.f17027 = ModuleDescriptor.MODULE_VERSION;
            this.f17028 = ModuleDescriptor.MODULE_VERSION;
            this.f17030 = ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C5122 m14984(InterfaceC2818 interfaceC2818) {
            C3921.m12667(interfaceC2818, "interceptor");
            this.f17004.add(interfaceC2818);
            return this;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C5122 m14985(InterfaceC2818 interfaceC2818) {
            C3921.m12667(interfaceC2818, "interceptor");
            this.f17005.add(interfaceC2818);
            return this;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C5121 m14986() {
            return new C5121(this);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C5122 m14987(C3661 c3661) {
            this.f17012 = c3661;
            return this;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C5122 m14988(long j, TimeUnit timeUnit) {
            C3921.m12667(timeUnit, "unit");
            this.f17026 = i5.m6238(ClientComponent.NamedSchedulers.TIMEOUT, j, timeUnit);
            return this;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C5122 m14989(C5198 c5198) {
            C3921.m12667(c5198, "connectionPool");
            this.f17003 = c5198;
            return this;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C5122 m14990(InterfaceC2896 interfaceC2896) {
            C3921.m12667(interfaceC2896, "cookieJar");
            this.f17011 = interfaceC2896;
            return this;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final C5122 m14991(AbstractC3415.InterfaceC3418 interfaceC3418) {
            C3921.m12667(interfaceC3418, "eventListenerFactory");
            this.f17006 = interfaceC3418;
            return this;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final InterfaceC5130 m14992() {
            return this.f17008;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final C3661 m14993() {
            return this.f17012;
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public final int m14994() {
            return this.f17025;
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public final AbstractC2918 m14995() {
            return this.f17024;
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public final CertificatePinner m14996() {
            return this.f17023;
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public final int m14997() {
            return this.f17026;
        }

        /* renamed from: ހ, reason: contains not printable characters */
        public final C5198 m14998() {
            return this.f17003;
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public final List<C5027> m14999() {
            return this.f17020;
        }

        /* renamed from: ނ, reason: contains not printable characters */
        public final InterfaceC2896 m15000() {
            return this.f17011;
        }

        /* renamed from: ރ, reason: contains not printable characters */
        public final C2319 m15001() {
            return this.f17002;
        }

        /* renamed from: ބ, reason: contains not printable characters */
        public final InterfaceC3113 m15002() {
            return this.f17013;
        }

        /* renamed from: ޅ, reason: contains not printable characters */
        public final AbstractC3415.InterfaceC3418 m15003() {
            return this.f17006;
        }

        /* renamed from: ކ, reason: contains not printable characters */
        public final boolean m15004() {
            return this.f17009;
        }

        /* renamed from: އ, reason: contains not printable characters */
        public final boolean m15005() {
            return this.f17010;
        }

        /* renamed from: ވ, reason: contains not printable characters */
        public final HostnameVerifier m15006() {
            return this.f17022;
        }

        /* renamed from: މ, reason: contains not printable characters */
        public final List<InterfaceC2818> m15007() {
            return this.f17004;
        }

        /* renamed from: ފ, reason: contains not printable characters */
        public final long m15008() {
            return this.f17030;
        }

        /* renamed from: ދ, reason: contains not printable characters */
        public final List<InterfaceC2818> m15009() {
            return this.f17005;
        }

        /* renamed from: ތ, reason: contains not printable characters */
        public final int m15010() {
            return this.f17029;
        }

        /* renamed from: ލ, reason: contains not printable characters */
        public final List<Protocol> m15011() {
            return this.f17021;
        }

        /* renamed from: ގ, reason: contains not printable characters */
        public final Proxy m15012() {
            return this.f17014;
        }

        /* renamed from: ޏ, reason: contains not printable characters */
        public final InterfaceC5130 m15013() {
            return this.f17016;
        }

        /* renamed from: ސ, reason: contains not printable characters */
        public final ProxySelector m15014() {
            return this.f17015;
        }

        /* renamed from: ޑ, reason: contains not printable characters */
        public final int m15015() {
            return this.f17027;
        }

        /* renamed from: ޒ, reason: contains not printable characters */
        public final boolean m15016() {
            return this.f17007;
        }

        /* renamed from: ޓ, reason: contains not printable characters */
        public final C4488 m15017() {
            return this.f17031;
        }

        /* renamed from: ޔ, reason: contains not printable characters */
        public final SocketFactory m15018() {
            return this.f17017;
        }

        /* renamed from: ޕ, reason: contains not printable characters */
        public final SSLSocketFactory m15019() {
            return this.f17018;
        }

        /* renamed from: ޖ, reason: contains not printable characters */
        public final int m15020() {
            return this.f17028;
        }

        /* renamed from: ޗ, reason: contains not printable characters */
        public final X509TrustManager m15021() {
            return this.f17019;
        }

        /* renamed from: ޘ, reason: contains not printable characters */
        public final C5122 m15022(HostnameVerifier hostnameVerifier) {
            C3921.m12667(hostnameVerifier, "hostnameVerifier");
            if (!C3921.m12662(hostnameVerifier, this.f17022)) {
                this.f17031 = null;
            }
            this.f17022 = hostnameVerifier;
            return this;
        }

        /* renamed from: ޙ, reason: contains not printable characters */
        public final List<InterfaceC2818> m15023() {
            return this.f17004;
        }

        /* renamed from: ޚ, reason: contains not printable characters */
        public final C5122 m15024(Proxy proxy) {
            if (!C3921.m12662(proxy, this.f17014)) {
                this.f17031 = null;
            }
            this.f17014 = proxy;
            return this;
        }

        /* renamed from: ޛ, reason: contains not printable characters */
        public final C5122 m15025(long j, TimeUnit timeUnit) {
            C3921.m12667(timeUnit, "unit");
            this.f17027 = i5.m6238(ClientComponent.NamedSchedulers.TIMEOUT, j, timeUnit);
            return this;
        }

        /* renamed from: ޜ, reason: contains not printable characters */
        public final C5122 m15026(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            C3921.m12667(sSLSocketFactory, "sslSocketFactory");
            C3921.m12667(x509TrustManager, "trustManager");
            if ((!C3921.m12662(sSLSocketFactory, this.f17018)) || (!C3921.m12662(x509TrustManager, this.f17019))) {
                this.f17031 = null;
            }
            this.f17018 = sSLSocketFactory;
            this.f17024 = AbstractC2918.f10624.m10312(x509TrustManager);
            this.f17019 = x509TrustManager;
            return this;
        }

        /* renamed from: ޝ, reason: contains not printable characters */
        public final C5122 m15027(long j, TimeUnit timeUnit) {
            C3921.m12667(timeUnit, "unit");
            this.f17028 = i5.m6238(ClientComponent.NamedSchedulers.TIMEOUT, j, timeUnit);
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C5122(C5121 c5121) {
            this();
            C3921.m12667(c5121, "okHttpClient");
            this.f17002 = c5121.m14961();
            this.f17003 = c5121.m14958();
            C3864.m12311(this.f17004, c5121.m14968());
            C3864.m12311(this.f17005, c5121.m14970());
            this.f17006 = c5121.m14963();
            this.f17007 = c5121.m14978();
            this.f17008 = c5121.m14952();
            this.f17009 = c5121.m14964();
            this.f17010 = c5121.m14965();
            this.f17011 = c5121.m14960();
            this.f17012 = c5121.m14953();
            this.f17013 = c5121.m14962();
            this.f17014 = c5121.m14974();
            this.f17015 = c5121.m14976();
            this.f17016 = c5121.m14975();
            this.f17017 = c5121.m14979();
            this.f17018 = c5121.f16988;
            this.f17019 = c5121.m14983();
            this.f17020 = c5121.m14959();
            this.f17021 = c5121.m14973();
            this.f17022 = c5121.m14967();
            this.f17023 = c5121.m14956();
            this.f17024 = c5121.m14955();
            this.f17025 = c5121.m14954();
            this.f17026 = c5121.m14957();
            this.f17027 = c5121.m14977();
            this.f17028 = c5121.m14982();
            this.f17029 = c5121.m14972();
            this.f17030 = c5121.m14969();
            this.f17031 = c5121.m14966();
        }
    }

    public C5121() {
        this(new C5122());
    }
}
