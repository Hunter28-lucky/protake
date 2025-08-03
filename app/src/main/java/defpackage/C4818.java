package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.bean.socket.SocketAddressBean;
import com.blink.academy.film.bean.socket.SocketMessage;
import com.blink.academy.film.widgets.socket.SocketAddressItem;
import defpackage.AbstractC4975;

/* compiled from: SocketAddressViewHolder.java */
/* renamed from: ණ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4818 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public SocketAddressItem f16305;

    /* compiled from: SocketAddressViewHolder.java */
    /* renamed from: ණ$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC4819 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4975.InterfaceC4979 f16306;

        public ViewOnClickListenerC4819(AbstractC4975.InterfaceC4979 interfaceC4979) {
            this.f16306 = interfaceC4979;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16306.mo4149(C4818.this.getAdapterPosition());
        }
    }

    /* compiled from: SocketAddressViewHolder.java */
    /* renamed from: ණ$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC4820 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4975.InterfaceC4979 f16308;

        public ViewOnClickListenerC4820(AbstractC4975.InterfaceC4979 interfaceC4979) {
            this.f16308 = interfaceC4979;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16308.mo4149(C4818.this.getAdapterPosition());
        }
    }

    public C4818(View view, Context context, AbstractC4975.InterfaceC4977<C4196> interfaceC4977, AbstractC4975.InterfaceC4979 interfaceC4979) {
        super(view, context, interfaceC4977, interfaceC4979);
        SocketAddressItem socketAddressItem = (SocketAddressItem) view;
        this.f16305 = socketAddressItem;
        ViewGroup.LayoutParams layoutParams = socketAddressItem.getLayoutParams();
        this.f16305.setLayoutParams(layoutParams == null ? new ViewGroup.LayoutParams(-1, -2) : layoutParams);
        this.f16305.setOnConnectListener(new ViewOnClickListenerC4819(interfaceC4979));
        this.f16305.setOnClickListener(new ViewOnClickListenerC4820(interfaceC4979));
    }

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ */
    public void mo3871(C4196 c4196, int i) {
        SocketAddressBean socketAddressBeanM13234 = c4196.m13234();
        SocketMessage socketMessageM488 = socketAddressBeanM13234.m488();
        this.f16305.setAddress(String.format("%s\t\t%s\t\t%s", socketMessageM488.m496(), socketMessageM488.m494(), Integer.valueOf(socketAddressBeanM13234.m489())));
        this.f16305.m4152(true);
        m14543(socketAddressBeanM13234.m490());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m14543(boolean z) {
        if (z) {
            this.f16305.setConnectMsg("已连接");
        } else {
            this.f16305.setConnectMsg("连接");
        }
    }
}
