package defpackage;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;

/* compiled from: AudioMicro.java */
/* renamed from: ྌ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5080 extends C5159 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f16871;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f16872;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f16873;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f16874;

    public C5080(int i, String str, int i2) {
        this.f16871 = i;
        this.f16872 = str;
        this.f16873 = i2;
    }

    public int getType() {
        return this.f16871;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m14907() {
        return this.f16874;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m14908() {
        return this.f16872;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m14909() {
        return this.f16873;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C5080 m14910(String str) {
        this.f16874 = str.replaceAll(MyUTIL.white_space, "");
        return this;
    }

    public C5080() {
    }
}
