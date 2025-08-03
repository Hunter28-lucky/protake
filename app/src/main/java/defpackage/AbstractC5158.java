package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: BaseAdapter.java */
/* renamed from: ၝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5158<T> extends RecyclerView.Adapter<AbstractC2769<T>> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Context f17093;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public List<T> f17094;

    public AbstractC5158(Context context, List<T> list) {
        this.f17093 = context;
        this.f17094 = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.f17094;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return mo11700(i);
    }

    /* renamed from: Ԩ */
    public abstract int mo11700(int i);

    /* renamed from: ԩ, reason: contains not printable characters */
    public Context m15079() {
        return this.f17093;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public List<T> m15080() {
        return this.f17094;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public T m15081(int i) {
        return m15080().get(i);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public View m15082(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(m15079()).inflate(i, viewGroup, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC2769<T> abstractC2769, int i) {
        abstractC2769.mo3871(m15081(i), i);
    }

    /* renamed from: Ԯ */
    public abstract AbstractC2769<T> mo9386(ViewGroup viewGroup, int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public AbstractC2769<T> onCreateViewHolder(ViewGroup viewGroup, int i) {
        return mo9386(viewGroup, i);
    }
}
