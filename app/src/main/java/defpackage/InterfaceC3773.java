package defpackage;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import org.jcodec.platform.Platform;

/* compiled from: Key.java */
/* renamed from: ݼ, reason: contains not printable characters */
/* loaded from: classes.dex */
public interface InterfaceC3773 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Charset f13027 = Charset.forName(Platform.UTF_8);

    boolean equals(Object obj);

    int hashCode();

    /* renamed from: Ԩ */
    void mo7626(@NonNull MessageDigest messageDigest);
}
