package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.blink.academy.protake.R;
import defpackage.AbstractC4975;
import java.util.List;

/* compiled from: FilmShutterShortcutAdapter.java */
/* renamed from: ദ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4720 extends AbstractC2366<C2798> {
    public C4720(Context context, List<C2798> list, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(context, list, interfaceC4976);
    }

    @Override // defpackage.AbstractC5158
    /* renamed from: Ԯ */
    public AbstractC2769<C2798> mo9386(ViewGroup viewGroup, int i) {
        return new C4842(m15082(R.layout.item_shuter_view, viewGroup), m15079(), this, this.f12579);
    }
}
