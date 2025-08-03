package defpackage;

import com.blink.academy.film.support.douyin.C0786;
import com.blink.academy.film.support.douyin.C0787;
import com.blink.academy.filter.core.TextureFormat;

/* compiled from: ProgramManager.java */
/* renamed from: ਗ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4243 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C0786 f14574;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C0787 f14575;

    /* compiled from: ProgramManager.java */
    /* renamed from: ਗ$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C4244 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f14576;

        static {
            int[] iArr = new int[TextureFormat.values().length];
            f14576 = iArr;
            try {
                iArr[TextureFormat.f5094.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14576[TextureFormat.f5095.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public AbstractC4527 m13347(TextureFormat textureFormat) {
        int i = C4244.f14576[textureFormat.ordinal()];
        if (i == 1) {
            if (this.f14574 == null) {
                this.f14574 = new C0786();
            }
            return this.f14574;
        }
        if (i != 2) {
            return null;
        }
        if (this.f14575 == null) {
            this.f14575 = new C0787();
        }
        return this.f14575;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m13348() {
        C0786 c0786 = this.f14574;
        if (c0786 != null) {
            c0786.m13872();
            this.f14574 = null;
        }
        C0787 c0787 = this.f14575;
        if (c0787 != null) {
            c0787.m13872();
            this.f14575 = null;
        }
    }
}
