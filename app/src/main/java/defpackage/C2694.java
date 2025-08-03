package defpackage;

import defpackage.C4453;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

/* compiled from: ConscryptSocketAdapter.kt */
/* renamed from: ʡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2694 implements InterfaceC4233 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C2696 f9997 = new C2696(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C4453.InterfaceC4454 f9996 = new C2695();

    /* compiled from: ConscryptSocketAdapter.kt */
    /* renamed from: ʡ$Ϳ, reason: contains not printable characters */
    public static final class C2695 implements C4453.InterfaceC4454 {
        @Override // defpackage.C4453.InterfaceC4454
        /* renamed from: Ϳ */
        public boolean mo8822(SSLSocket sSLSocket) {
            C3921.m12667(sSLSocket, "sslSocket");
            return C3857.f13262.m12296() && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // defpackage.C4453.InterfaceC4454
        /* renamed from: Ԩ */
        public InterfaceC4233 mo8823(SSLSocket sSLSocket) {
            C3921.m12667(sSLSocket, "sslSocket");
            return new C2694();
        }
    }

    /* compiled from: ConscryptSocketAdapter.kt */
    /* renamed from: ʡ$Ԩ, reason: contains not printable characters */
    public static final class C2696 {
        public C2696() {
        }

        public /* synthetic */ C2696(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C4453.InterfaceC4454 m9922() {
            return C2694.f9996;
        }
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ϳ */
    public boolean mo8818(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ԩ */
    public boolean mo8819() {
        return C3857.f13262.m12296();
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: ԩ */
    public String mo8820(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        if (mo8818(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ԫ */
    public void mo8821(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        if (mo8818(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array = C2708.f10025.m9959(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
        }
    }
}
