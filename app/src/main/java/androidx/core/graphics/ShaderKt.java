package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Shader.kt */
/* loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(Shader shader, InterfaceC2392<? super Matrix, i4> interfaceC2392) {
        C3921.m12666(shader, "<this>");
        C3921.m12666(interfaceC2392, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        interfaceC2392.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
