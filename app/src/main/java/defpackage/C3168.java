package defpackage;

import com.xiaomi.mipush.sdk.Constants;
import okio.ByteString;

/* compiled from: Header.kt */
/* renamed from: ԥ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3168 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final ByteString f11234;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final ByteString f11235;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final ByteString f11236;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final ByteString f11237;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final ByteString f11238;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final ByteString f11239;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final C3169 f11240 = new C3169(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int f11241;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final ByteString f11242;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final ByteString f11243;

    /* compiled from: Header.kt */
    /* renamed from: ԥ$Ϳ, reason: contains not printable characters */
    public static final class C3169 {
        public C3169() {
        }

        public /* synthetic */ C3169(C4184 c4184) {
            this();
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        f11234 = companion.encodeUtf8(Constants.COLON_SEPARATOR);
        f11235 = companion.encodeUtf8(":status");
        f11236 = companion.encodeUtf8(":method");
        f11237 = companion.encodeUtf8(":path");
        f11238 = companion.encodeUtf8(":scheme");
        f11239 = companion.encodeUtf8(":authority");
    }

    public C3168(ByteString byteString, ByteString byteString2) {
        C3921.m12667(byteString, "name");
        C3921.m12667(byteString2, "value");
        this.f11242 = byteString;
        this.f11243 = byteString2;
        this.f11241 = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3168)) {
            return false;
        }
        C3168 c3168 = (C3168) obj;
        return C3921.m12662(this.f11242, c3168.f11242) && C3921.m12662(this.f11243, c3168.f11243);
    }

    public int hashCode() {
        ByteString byteString = this.f11242;
        int iHashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.f11243;
        return iHashCode + (byteString2 != null ? byteString2.hashCode() : 0);
    }

    public String toString() {
        return this.f11242.utf8() + ": " + this.f11243.utf8();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final ByteString m10775() {
        return this.f11242;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final ByteString m10776() {
        return this.f11243;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C3168(String str, String str2) {
        C3921.m12667(str, "name");
        C3921.m12667(str2, "value");
        ByteString.Companion companion = ByteString.Companion;
        this(companion.encodeUtf8(str), companion.encodeUtf8(str2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C3168(ByteString byteString, String str) {
        this(byteString, ByteString.Companion.encodeUtf8(str));
        C3921.m12667(byteString, "name");
        C3921.m12667(str, "value");
    }
}
