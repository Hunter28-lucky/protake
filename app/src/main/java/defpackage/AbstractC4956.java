package defpackage;

import android.content.Context;
import android.view.View;
import defpackage.AbstractC4975;
import defpackage.C5159;

/* compiled from: FilmSimpleViewHolder.java */
/* renamed from: ດ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4956<T extends C5159> extends AbstractC4975<T, AbstractC4975.InterfaceC4976, AbstractC4975.InterfaceC4977<T>> {

    /* compiled from: FilmSimpleViewHolder.java */
    /* renamed from: ດ$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC4957 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4975.InterfaceC4976 f16672;

        public ViewOnClickListenerC4957(AbstractC4975.InterfaceC4976 interfaceC4976) {
            this.f16672 = interfaceC4976;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbstractC4975.InterfaceC4976 interfaceC4976 = this.f16672;
            if (interfaceC4976 != null) {
                interfaceC4976.mo1558(AbstractC4956.this.getAdapterPosition());
            }
        }
    }

    /* compiled from: FilmSimpleViewHolder.java */
    /* renamed from: ດ$Ԩ, reason: contains not printable characters */
    public class ViewOnLongClickListenerC4958 implements View.OnLongClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4975.InterfaceC4976 f16674;

        public ViewOnLongClickListenerC4958(AbstractC4975.InterfaceC4976 interfaceC4976) {
            this.f16674 = interfaceC4976;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AbstractC4975.InterfaceC4976 interfaceC4976 = this.f16674;
            if (interfaceC4976 == null) {
                return false;
            }
            interfaceC4976.mo1557(AbstractC4956.this.getAdapterPosition());
            return false;
        }
    }

    public AbstractC4956(View view, Context context, AbstractC4975.InterfaceC4977<T> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        view.setOnClickListener(new ViewOnClickListenerC4957(interfaceC4976));
        view.setOnLongClickListener(new ViewOnLongClickListenerC4958(interfaceC4976));
    }
}
