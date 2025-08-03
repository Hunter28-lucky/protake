package defpackage;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Objects;

/* compiled from: CropRatio.java */
/* renamed from: ռ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3255 extends C5159 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float f11435;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public float f11436;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f11437;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f11438;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f11439;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f11440;

    public C3255(float f, float f2) {
        this.f11435 = f;
        this.f11436 = f2;
        this.f11440 = f / f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3255 c3255 = (C3255) obj;
        return Float.compare(c3255.f11435, this.f11435) == 0 && Float.compare(c3255.f11436, this.f11436) == 0;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.f11435), Float.valueOf(this.f11436));
    }

    public String toString() {
        return this.f11435 + Constants.COLON_SEPARATOR + this.f11436;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m10919() {
        return this.f11439;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public float m10920() {
        return this.f11436;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public float m10921() {
        return this.f11440;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m10922() {
        return this.f11437;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m10923() {
        return this.f11438;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float m10924() {
        return this.f11435;
    }

    public C3255(float f, float f2, String str, int i) {
        this.f11435 = f;
        this.f11436 = f2;
        this.f11440 = f / f2;
        this.f11437 = str;
        this.f11439 = i;
    }

    public C3255(float f, float f2, String str, int i, int i2) {
        this.f11435 = f;
        this.f11436 = f2;
        this.f11440 = f / f2;
        this.f11437 = str;
        this.f11438 = i;
        this.f11439 = i2;
    }
}
