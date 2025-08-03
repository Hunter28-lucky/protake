package defpackage;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.util.Objects;

/* compiled from: VideoBitRate.java */
/* loaded from: classes.dex */
public class r5 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float f8469;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f8470;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f8471;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f8469 == ((r5) obj).f8469;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.f8469));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m8148() {
        return this.f8470;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public r5 m8149(float f) {
        this.f8469 = f;
        int i = (int) f;
        if (i == f) {
            m8151(MyUTIL.white_space + i + " Mbps");
        } else {
            m8151(MyUTIL.white_space + f + " Mbps");
        }
        return this;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public r5 m8150(boolean z) {
        this.f8471 = z;
        return this;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public r5 m8151(String str) {
        this.f8470 = str;
        return this;
    }
}
