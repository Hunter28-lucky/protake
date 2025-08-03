package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.ACMonitorInfoBean;
import com.blink.academy.film.stream.LinkEntity;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.widgets.transmit.ConnectedDeviceItem;
import defpackage.AbstractC4975;

/* compiled from: ConnectedDeviceViewHolder.java */
/* renamed from: ڋ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3521 extends AbstractC4956<LinkEntity> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ConnectedDeviceItem f12310;

    /* renamed from: ԯ, reason: contains not printable characters */
    public AbstractC4975.InterfaceC4979 f12311;

    /* compiled from: ConnectedDeviceViewHolder.java */
    /* renamed from: ڋ$Ϳ, reason: contains not printable characters */
    public class C3522 implements ConnectedDeviceItem.InterfaceC1586 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4975.InterfaceC4979 f12312;

        public C3522(AbstractC4975.InterfaceC4979 interfaceC4979) {
            this.f12312 = interfaceC4979;
        }

        @Override // com.blink.academy.film.widgets.transmit.ConnectedDeviceItem.InterfaceC1586
        /* renamed from: Ϳ */
        public void mo4238() {
            AbstractC4975.InterfaceC4979 interfaceC4979 = this.f12312;
            if (interfaceC4979 != null) {
                interfaceC4979.mo4147(C3521.this.getBindingAdapterPosition());
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.ConnectedDeviceItem.InterfaceC1586
        /* renamed from: Ԩ */
        public void mo4239() {
            AbstractC4975.InterfaceC4979 interfaceC4979 = this.f12312;
            if (interfaceC4979 != null) {
                interfaceC4979.mo4148(C3521.this.getBindingAdapterPosition());
            }
        }
    }

    public C3521(View view, Context context, AbstractC4975.InterfaceC4977<LinkEntity> interfaceC4977, AbstractC4975.InterfaceC4979 interfaceC4979) {
        super(view, context, interfaceC4977, interfaceC4979);
        ConnectedDeviceItem connectedDeviceItem = (ConnectedDeviceItem) view;
        this.f12310 = connectedDeviceItem;
        this.f12311 = interfaceC4979;
        ViewGroup.LayoutParams layoutParams = connectedDeviceItem.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-1, -2) : layoutParams;
        layoutParams.width = -1;
        layoutParams.height = C4792.m14375().m14480(135.0f, C4792.m14375().m14471());
        this.f12310.setLayoutParams(layoutParams);
        this.f12310.setOnChangeListener(new C3522(interfaceC4979));
    }

    @Override // defpackage.AbstractC2769
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo3871(LinkEntity linkEntity, int i) {
        ACMonitorInfoBean acMonitorInfoBean = linkEntity.getAcMonitorInfoBean();
        int controlState = linkEntity.getControlState();
        if (linkEntity.isBanned()) {
            this.f12310.m4235();
        } else {
            this.f12310.m4236(ACHelper.getInstance().getWifiViewLevel(acMonitorInfoBean.getWifiStatus()), controlState);
        }
        this.f12310.setDeviceContent(TransmitHelper.getMessage(acMonitorInfoBean));
        String netType = acMonitorInfoBean.getNetType();
        if ("Wi-Fi".equals(netType) || !r1.m8143(netType)) {
            this.f12310.m4233(true);
        } else {
            this.f12310.m4233(false);
        }
    }
}
