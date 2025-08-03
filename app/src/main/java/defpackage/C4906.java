package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.blink.academy.film.stream.LinkEntity;
import com.blink.academy.film.widgets.transmit.ConnectedDeviceItem;
import defpackage.AbstractC4975;
import java.util.List;

/* compiled from: ConnectedDeviceAdapter.java */
/* renamed from: ร, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4906 extends AbstractC2366<LinkEntity> {
    public C4906(Context context, List<LinkEntity> list, AbstractC4975.InterfaceC4979 interfaceC4979) {
        super(context, list, interfaceC4979);
    }

    @Override // defpackage.AbstractC5158
    /* renamed from: Ԯ */
    public AbstractC2769<LinkEntity> mo9386(ViewGroup viewGroup, int i) {
        return new C3521(new ConnectedDeviceItem(m15079()), m15079(), this, (AbstractC4975.InterfaceC4979) this.f12579);
    }
}
