package defpackage;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;
import okio.BufferedSource;

/* compiled from: PushObserver.kt */
/* renamed from: ഐ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC4683 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C4684 f15901 = new C4684(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC4683 f15900 = new C4684.C4685();

    /* compiled from: PushObserver.kt */
    /* renamed from: ഐ$Ϳ, reason: contains not printable characters */
    public static final class C4684 {

        /* compiled from: PushObserver.kt */
        /* renamed from: ഐ$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class C4685 implements InterfaceC4683 {
            @Override // defpackage.InterfaceC4683
            /* renamed from: Ϳ */
            public boolean mo14193(int i, List<C3168> list) {
                C3921.m12667(list, "requestHeaders");
                return true;
            }

            @Override // defpackage.InterfaceC4683
            /* renamed from: Ԩ */
            public boolean mo14194(int i, List<C3168> list, boolean z) {
                C3921.m12667(list, "responseHeaders");
                return true;
            }

            @Override // defpackage.InterfaceC4683
            /* renamed from: ԩ */
            public void mo14195(int i, ErrorCode errorCode) {
                C3921.m12667(errorCode, "errorCode");
            }

            @Override // defpackage.InterfaceC4683
            /* renamed from: Ԫ */
            public boolean mo14196(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
                C3921.m12667(bufferedSource, "source");
                bufferedSource.skip(i2);
                return true;
            }
        }

        public C4684() {
        }

        public /* synthetic */ C4684(C4184 c4184) {
            this();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    boolean mo14193(int i, List<C3168> list);

    /* renamed from: Ԩ, reason: contains not printable characters */
    boolean mo14194(int i, List<C3168> list, boolean z);

    /* renamed from: ԩ, reason: contains not printable characters */
    void mo14195(int i, ErrorCode errorCode);

    /* renamed from: Ԫ, reason: contains not printable characters */
    boolean mo14196(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;
}
