package defpackage;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;

/* compiled from: CookieJar.kt */
/* renamed from: х, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC2896 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C2897 f10574 = new C2897(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC2896 f10573 = new C2897.C2898();

    /* compiled from: CookieJar.kt */
    /* renamed from: х$Ϳ, reason: contains not printable characters */
    public static final class C2897 {

        /* compiled from: CookieJar.kt */
        /* renamed from: х$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class C2898 implements InterfaceC2896 {
            @Override // defpackage.InterfaceC2896
            public List<C2632> loadForRequest(C3573 c3573) {
                C3921.m12667(c3573, ImagesContract.URL);
                return C3131.m10712();
            }

            @Override // defpackage.InterfaceC2896
            public void saveFromResponse(C3573 c3573, List<C2632> list) {
                C3921.m12667(c3573, ImagesContract.URL);
                C3921.m12667(list, "cookies");
            }
        }

        public C2897() {
        }

        public /* synthetic */ C2897(C4184 c4184) {
            this();
        }
    }

    List<C2632> loadForRequest(C3573 c3573);

    void saveFromResponse(C3573 c3573, List<C2632> list);
}
