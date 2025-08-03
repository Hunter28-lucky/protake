package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import defpackage.C2679;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Canvas.kt */
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(rect, "clipRect");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(matrix, "matrix");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, InterfaceC2392 interfaceC2392, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        C3921.m12666(canvas, "<this>");
        C3921.m12666(matrix, "matrix");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withRotation(Canvas canvas, float f, float f2, float f3, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f, float f2, float f3, InterfaceC2392 interfaceC2392, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withSave(Canvas canvas, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withScale(Canvas canvas, float f, float f2, float f3, float f4, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f, float f2, float f3, float f4, InterfaceC2392 interfaceC2392, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withSkew(Canvas canvas, float f, float f2, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.skew(f, f2);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f, float f2, InterfaceC2392 interfaceC2392, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.skew(f, f2);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withTranslation(Canvas canvas, float f, float f2, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f, float f2, InterfaceC2392 interfaceC2392, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(rectF, "clipRect");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withClip(Canvas canvas, int i, int i2, int i3, int i4, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withClip(Canvas canvas, float f, float f2, float f3, float f4, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.clipRect(f, f2, f3, f4);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }

    public static final void withClip(Canvas canvas, Path path, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(canvas, "<this>");
        C3921.m12666(path, "clipPath");
        C3921.m12666(interfaceC2392, "block");
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            interfaceC2392.invoke(canvas);
        } finally {
            C2679.m9826(1);
            canvas.restoreToCount(iSave);
            C2679.m9825(1);
        }
    }
}
