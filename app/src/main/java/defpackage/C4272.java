package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.blink.academy.protake.R;
import java.util.List;

/* compiled from: PlayListAdapter.java */
/* renamed from: ਯ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4272 extends AbstractC2366<C5202> {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f14646;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f14647;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f14648;

    public C4272(Context context, int i, int i2, List<C5202> list, InterfaceC4172 interfaceC4172) {
        super(context, list, interfaceC4172);
        this.f14646 = i;
        this.f14647 = i2;
    }

    @Override // defpackage.AbstractC5158
    /* renamed from: Ԯ */
    public AbstractC2769<C5202> mo9386(ViewGroup viewGroup, int i) {
        return new C4846(m15082(R.layout.item_play_list, viewGroup), m15079(), this, this.f12579, this.f14646, this.f14647, this);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean m13382() {
        return this.f14648;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m13383(boolean z) {
        this.f14648 = z;
    }
}
