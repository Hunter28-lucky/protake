package defpackage;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ABRecyclerViewHolder.java */
/* renamed from: Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC2769<T> extends RecyclerView.ViewHolder {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Context f10126;

    public AbstractC2769(View view, Context context) {
        super(view);
        this.f10126 = context;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Context m10050() {
        return this.f10126;
    }

    /* renamed from: Ԩ */
    public abstract void mo3871(T t, int i);
}
