package androidx.core.content;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Context.kt */
/* loaded from: classes.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        C3921.m12666(context, "<this>");
        C3921.m12670(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, @AttrRes int i, @StyleRes int i2, InterfaceC2392<? super TypedArray, i4> interfaceC2392) {
        C3921.m12666(context, "<this>");
        C3921.m12666(iArr, "attrs");
        C3921.m12666(interfaceC2392, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        C3921.m12665(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        interfaceC2392.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, InterfaceC2392 interfaceC2392, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        C3921.m12666(context, "<this>");
        C3921.m12666(iArr, "attrs");
        C3921.m12666(interfaceC2392, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        C3921.m12665(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        interfaceC2392.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context context, @StyleRes int i, int[] iArr, InterfaceC2392<? super TypedArray, i4> interfaceC2392) throws Resources.NotFoundException {
        C3921.m12666(context, "<this>");
        C3921.m12666(iArr, "attrs");
        C3921.m12666(interfaceC2392, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, iArr);
        C3921.m12665(typedArrayObtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        interfaceC2392.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }
}
