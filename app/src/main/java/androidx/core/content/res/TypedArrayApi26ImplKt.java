package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import defpackage.C3921;

/* compiled from: TypedArray.kt */
@RequiresApi(26)
/* loaded from: classes.dex */
final class TypedArrayApi26ImplKt {
    public static final TypedArrayApi26ImplKt INSTANCE = new TypedArrayApi26ImplKt();

    private TypedArrayApi26ImplKt() {
    }

    @DoNotInline
    public static final Typeface getFont(TypedArray typedArray, @StyleableRes int i) {
        C3921.m12666(typedArray, "typedArray");
        Typeface font = typedArray.getFont(i);
        C3921.m12664(font);
        return font;
    }
}
