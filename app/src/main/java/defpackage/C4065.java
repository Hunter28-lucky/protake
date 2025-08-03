package defpackage;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry.java */
/* renamed from: ङ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4065 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<ImageHeaderParser> f14112 = new ArrayList();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized void m12999(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f14112.add(imageHeaderParser);
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized List<ImageHeaderParser> m13000() {
        return this.f14112;
    }
}
