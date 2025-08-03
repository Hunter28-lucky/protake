package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.GridsTypeChooseView;
import com.blink.academy.film.widgets.TextWithPointChooseView;
import defpackage.AbstractC4975;
import java.util.List;

/* compiled from: FilmGridsAdapter.java */
/* renamed from: Ց, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3227 extends AbstractC2366<C2685> {
    public C3227(Context context, List<C2685> list, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(context, list, interfaceC4976);
    }

    @Override // defpackage.AbstractC5158
    /* renamed from: Ԯ */
    public AbstractC2769<C2685> mo9386(ViewGroup viewGroup, int i) {
        return i != 3 ? new C3502(new GridsTypeChooseView(viewGroup.getContext()), viewGroup.getContext(), this, this.f12579) : new C3133(new TextWithPointChooseView(viewGroup.getContext()), viewGroup.getContext(), this, this.f12579);
    }
}
