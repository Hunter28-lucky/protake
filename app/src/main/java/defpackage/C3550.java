package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.blink.academy.protake.R;
import java.util.List;

/* compiled from: SettingZhiyunAdapter.java */
/* renamed from: ڝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3550 extends AbstractC2366<C3760> {
    public C3550(Context context, List<C3760> list, InterfaceC4172 interfaceC4172) {
        super(context, list, interfaceC4172);
    }

    @Override // defpackage.AbstractC5158
    /* renamed from: Ԯ */
    public AbstractC2769<C3760> mo9386(ViewGroup viewGroup, int i) {
        return new C4779(m15082(R.layout.item_setting_zhiyun, viewGroup), m15079(), this, this.f12579);
    }
}
