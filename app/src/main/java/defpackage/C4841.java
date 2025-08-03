package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.blink.academy.protake.R;
import java.util.List;

/* compiled from: SettingProtakeFocusAdapter.java */
/* renamed from: ම, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4841 extends AbstractC2366<C3637> {
    public C4841(Context context, List<C3637> list, InterfaceC4172 interfaceC4172) {
        super(context, list, interfaceC4172);
    }

    @Override // defpackage.AbstractC5158
    /* renamed from: Ԯ */
    public AbstractC2769<C3637> mo9386(ViewGroup viewGroup, int i) {
        return new C4769(m15082(R.layout.item_setting_protake_focus, viewGroup), m15079(), this, this.f12579);
    }
}
