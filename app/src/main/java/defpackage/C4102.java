package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: RecyclerViewItemDecoration.java */
/* renamed from: ॐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4102 extends RecyclerView.ItemDecoration {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f14248;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f14249;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f14250;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f14251;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C4102(java.lang.String r4, int r5) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.f14248 = r0
            r3.f14249 = r0
            r3.f14250 = r0
            r3.f14251 = r0
            r4.hashCode()
            int r1 = r4.hashCode()
            r2 = -1
            switch(r1) {
                case -2127496380: goto L3a;
                case -1705970712: goto L2f;
                case -1602936141: goto L24;
                case 831755738: goto L19;
                default: goto L17;
            }
        L17:
            r0 = r2
            goto L43
        L19:
            java.lang.String r0 = "top_decoration"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L22
            goto L17
        L22:
            r0 = 3
            goto L43
        L24:
            java.lang.String r0 = "right_decoration"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L2d
            goto L17
        L2d:
            r0 = 2
            goto L43
        L2f:
            java.lang.String r0 = "left_decoration"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L38
            goto L17
        L38:
            r0 = 1
            goto L43
        L3a:
            java.lang.String r1 = "bottom_decoration"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L43
            goto L17
        L43:
            switch(r0) {
                case 0: goto L50;
                case 1: goto L4d;
                case 2: goto L4a;
                case 3: goto L47;
                default: goto L46;
            }
        L46:
            goto L52
        L47:
            r3.f14249 = r5
            goto L52
        L4a:
            r3.f14248 = r5
            goto L52
        L4d:
            r3.f14250 = r5
            goto L52
        L50:
            r3.f14251 = r5
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C4102.<init>(java.lang.String, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.top = this.f14249;
        rect.left = this.f14250;
        rect.bottom = this.f14251;
        if (recyclerView.getAdapter() == null || recyclerView.getChildLayoutPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
            rect.right = 0;
        } else {
            rect.right = this.f14248;
        }
    }
}
