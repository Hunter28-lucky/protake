package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.blink.academy.protake.R;
import java.util.List;

/* compiled from: SettingPresetAdapter.java */
/* renamed from: ઓ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4321 extends AbstractC2366<C4802> {
    public C4321(Context context, List<C4802> list, InterfaceC4172 interfaceC4172) {
        super(context, list, interfaceC4172);
    }

    @Override // defpackage.AbstractC5158
    /* renamed from: Ԯ */
    public AbstractC2769<C4802> mo9386(ViewGroup viewGroup, int i) {
        return new C5267(m15082(R.layout.item_setting_preset, viewGroup), m15079(), this, this.f12579);
    }
}
