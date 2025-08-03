package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import defpackage.C3921;
import defpackage.InterfaceC3697;
import defpackage.i4;
import java.io.IOException;

/* compiled from: ImageDecoder.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, final InterfaceC3697<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, i4> interfaceC3697) throws IOException {
        C3921.m12666(source, "<this>");
        C3921.m12666(interfaceC3697, "action");
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeBitmap.1
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                C3921.m12666(imageDecoder, "decoder");
                C3921.m12666(imageInfo, "info");
                C3921.m12666(source2, "source");
                interfaceC3697.m11844(imageDecoder, imageInfo, source2);
            }
        });
        C3921.m12665(bitmapDecodeBitmap, "crossinline action: Imag…ction(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, final InterfaceC3697<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, i4> interfaceC3697) throws IOException {
        C3921.m12666(source, "<this>");
        C3921.m12666(interfaceC3697, "action");
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeDrawable.1
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                C3921.m12666(imageDecoder, "decoder");
                C3921.m12666(imageInfo, "info");
                C3921.m12666(source2, "source");
                interfaceC3697.m11844(imageDecoder, imageInfo, source2);
            }
        });
        C3921.m12665(drawableDecodeDrawable, "crossinline action: Imag…ction(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
