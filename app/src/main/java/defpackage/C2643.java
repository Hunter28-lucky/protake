package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* compiled from: ImageViewTargetFactory.java */
/* renamed from: ʁ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2643 {
    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public <Z> q7<ImageView, Z> m9748(@NonNull ImageView imageView, @NonNull Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new C3913(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new C2663(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
