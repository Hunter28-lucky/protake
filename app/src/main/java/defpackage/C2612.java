package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PlaylistItemDecoration.java */
/* renamed from: ɮ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2612 extends RecyclerView.ItemDecoration {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f9717;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f9718;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f9719;

    public C2612(int i, int i2, int i3) {
        this.f9717 = i;
        this.f9718 = i2;
        this.f9719 = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getAdapter() == null) {
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        rect.left = this.f9717;
        if (childAdapterPosition == 0) {
            rect.right = this.f9719;
        } else if (childAdapterPosition == recyclerView.getAdapter().getItemCount() - 1) {
            rect.left = this.f9719;
        }
    }
}
