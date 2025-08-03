package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* renamed from: স, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4207 implements InterfaceC3773 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC3734 f14494;

    /* renamed from: ԩ, reason: contains not printable characters */
    @Nullable
    public final URL f14495;

    /* renamed from: Ԫ, reason: contains not printable characters */
    @Nullable
    public final String f14496;

    /* renamed from: ԫ, reason: contains not printable characters */
    @Nullable
    public String f14497;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @Nullable
    public URL f14498;

    /* renamed from: ԭ, reason: contains not printable characters */
    @Nullable
    public volatile byte[] f14499;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f14500;

    public C4207(URL url) {
        this(url, InterfaceC3734.f12942);
    }

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        if (!(obj instanceof C4207)) {
            return false;
        }
        C4207 c4207 = (C4207) obj;
        return m13283().equals(c4207.m13283()) && this.f14494.equals(c4207.f14494);
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        if (this.f14500 == 0) {
            int iHashCode = m13283().hashCode();
            this.f14500 = iHashCode;
            this.f14500 = (iHashCode * 31) + this.f14494.hashCode();
        }
        return this.f14500;
    }

    public String toString() {
        return m13283();
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        messageDigest.update(m13284());
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public String m13283() {
        String str = this.f14496;
        return str != null ? str : ((URL) C4513.m13867(this.f14495)).toString();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final byte[] m13284() {
        if (this.f14499 == null) {
            this.f14499 = m13283().getBytes(InterfaceC3773.f13027);
        }
        return this.f14499;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public Map<String, String> m13285() {
        return this.f14494.mo11967();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String m13286() {
        if (TextUtils.isEmpty(this.f14497)) {
            String string = this.f14496;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) C4513.m13867(this.f14495)).toString();
            }
            this.f14497 = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f14497;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final URL m13287() throws MalformedURLException {
        if (this.f14498 == null) {
            this.f14498 = new URL(m13286());
        }
        return this.f14498;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public URL m13288() throws MalformedURLException {
        return m13287();
    }

    public C4207(String str) {
        this(str, InterfaceC3734.f12942);
    }

    public C4207(URL url, InterfaceC3734 interfaceC3734) {
        this.f14495 = (URL) C4513.m13867(url);
        this.f14496 = null;
        this.f14494 = (InterfaceC3734) C4513.m13867(interfaceC3734);
    }

    public C4207(String str, InterfaceC3734 interfaceC3734) {
        this.f14495 = null;
        this.f14496 = C4513.m13865(str);
        this.f14494 = (InterfaceC3734) C4513.m13867(interfaceC3734);
    }
}
