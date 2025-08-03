package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import defpackage.C3921;

/* compiled from: Icon.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class IconKt {
    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        C3921.m12666(bitmap, "<this>");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        C3921.m12665(iconCreateWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Bitmap bitmap) {
        C3921.m12666(bitmap, "<this>");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        C3921.m12665(iconCreateWithBitmap, "createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Uri uri) {
        C3921.m12666(uri, "<this>");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        C3921.m12665(iconCreateWithContentUri, "createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @RequiresApi(26)
    public static final Icon toIcon(byte[] bArr) {
        C3921.m12666(bArr, "<this>");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        C3921.m12665(iconCreateWithData, "createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
