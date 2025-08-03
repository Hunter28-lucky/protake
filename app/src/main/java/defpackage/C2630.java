package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.InterfaceC4900;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader.java */
/* renamed from: ɻ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2630 implements InterfaceC4900<C4207, InputStream> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C4238<Integer> f9787 = C4238.m13342("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: Ϳ, reason: contains not printable characters */
    @Nullable
    public final C5107<C4207, C4207> f9788;

    /* compiled from: HttpGlideUrlLoader.java */
    /* renamed from: ɻ$Ϳ, reason: contains not printable characters */
    public static class C2631 implements InterfaceC5295<C4207, InputStream> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C5107<C4207, C4207> f9789 = new C5107<>(500);

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<C4207, InputStream> mo12(C4057 c4057) {
            return new C2630(this.f9789);
        }
    }

    public C2630(@Nullable C5107<C4207, C4207> c5107) {
        this.f9788 = c5107;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<InputStream> mo8(@NonNull C4207 c4207, int i, int i2, @NonNull C3475 c3475) {
        C5107<C4207, C4207> c5107 = this.f9788;
        if (c5107 != null) {
            C4207 c4207M14931 = c5107.m14931(c4207, 0, 0);
            if (c4207M14931 == null) {
                this.f9788.m14932(c4207, 0, 0, c4207);
            } else {
                c4207 = c4207M14931;
            }
        }
        return new InterfaceC4900.C4901<>(c4207, new C2845(c4207, ((Integer) c3475.m11329(f9787)).intValue()));
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull C4207 c4207) {
        return true;
    }
}
