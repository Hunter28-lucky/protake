package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import defpackage.C2679;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Picture.kt */
/* loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i, int i2, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(picture, "<this>");
        C3921.m12666(interfaceC2392, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        C3921.m12665(canvasBeginRecording, "beginRecording(width, height)");
        try {
            interfaceC2392.invoke(canvasBeginRecording);
            return picture;
        } finally {
            C2679.m9826(1);
            picture.endRecording();
            C2679.m9825(1);
        }
    }
}
