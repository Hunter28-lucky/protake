package defpackage;

import com.blink.academy.film.zxing.ViewfinderView;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* compiled from: ViewfinderResultPointCallback.java */
/* loaded from: classes.dex */
public final class s7 implements ResultPointCallback {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final ViewfinderView f8509;

    public s7(ViewfinderView viewfinderView) {
        this.f8509 = viewfinderView;
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.f8509.m4758(resultPoint);
    }
}
