package defpackage;

import android.content.Context;
import defpackage.AbstractC4975;
import defpackage.AbstractC4975.InterfaceC4976;
import defpackage.C5159;
import java.util.List;

/* compiled from: FilmBaseAdapter.java */
/* renamed from: ۆ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3625<T extends C5159, M extends AbstractC4975.InterfaceC4976> extends AbstractC5158<T> implements AbstractC4975.InterfaceC4977<T> {

    /* renamed from: ԩ, reason: contains not printable characters */
    public M f12579;

    public AbstractC3625(Context context, List<T> list, M m) {
        super(context, list);
        this.f12579 = m;
    }

    @Override // defpackage.AbstractC4975.InterfaceC4977
    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<T> mo11699() {
        return m15080();
    }

    @Override // defpackage.AbstractC5158
    /* renamed from: Ԩ, reason: contains not printable characters */
    public int mo11700(int i) {
        return m15080().get(i).getItemViewType();
    }
}
