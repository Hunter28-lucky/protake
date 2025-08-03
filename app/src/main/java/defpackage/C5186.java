package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.beauty.BeautyItemView;
import defpackage.AbstractC4975;

/* compiled from: BeautyTypeViewHolder.java */
/* renamed from: ႀ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5186 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public BeautyItemView f17206;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f17207;

    /* compiled from: BeautyTypeViewHolder.java */
    /* renamed from: ႀ$Ϳ, reason: contains not printable characters */
    public class ViewOnLongClickListenerC5187 implements View.OnLongClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4975.InterfaceC4978 f17208;

        public ViewOnLongClickListenerC5187(AbstractC4975.InterfaceC4978 interfaceC4978) {
            this.f17208 = interfaceC4978;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.f17208 != null) {
                C5186.this.f17207 = true;
                this.f17208.mo2829(C5186.this.getAdapterPosition());
            }
            return true;
        }
    }

    /* compiled from: BeautyTypeViewHolder.java */
    /* renamed from: ႀ$Ԩ, reason: contains not printable characters */
    public class ViewOnTouchListenerC5188 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4975.InterfaceC4978 f17210;

        public ViewOnTouchListenerC5188(AbstractC4975.InterfaceC4978 interfaceC4978) {
            this.f17210 = interfaceC4978;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && C5186.this.f17207) {
                C5186.this.f17207 = false;
                AbstractC4975.InterfaceC4978 interfaceC4978 = this.f17210;
                if (interfaceC4978 != null) {
                    interfaceC4978.mo2828(C5186.this.getAdapterPosition());
                    return true;
                }
            }
            return false;
        }
    }

    public C5186(View view, Context context, AbstractC4975.InterfaceC4977<C4196> interfaceC4977, AbstractC4975.InterfaceC4978 interfaceC4978) {
        super(view, context, interfaceC4977, interfaceC4978);
        BeautyItemView beautyItemView = (BeautyItemView) view;
        this.f17206 = beautyItemView;
        ViewGroup.LayoutParams layoutParams = beautyItemView.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
        layoutParams.width = -2;
        layoutParams.height = -1;
        this.f17206.setLayoutParams(layoutParams);
        int iM14381 = C4792.m14375().m14498() ? C4792.m14375().m14381() - this.f17206.getHalfLevelWidth() : C4792.m14375().m14386() - this.f17206.getHalfLevelWidth();
        this.f17206.setPadding(iM14381, 0, iM14381, 0);
        this.f17206.setOnLongClickListener(new ViewOnLongClickListenerC5187(interfaceC4978));
        this.f17206.setOnTouchListener(new ViewOnTouchListenerC5188(interfaceC4978));
    }

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ */
    public void mo3871(C4196 c4196, int i) {
        C5183 c5183M13222 = c4196.m13222();
        this.f17206.setImageRes(c5183M13222.m15144());
        this.f17206.setBeautyName(FilmApp.m402().getResources().getString(c5183M13222.m15146()));
        m15159(c5183M13222.m15143());
        if (c4196.m13229() != 0) {
            this.f17206.setPadding(c4196.m13229(), 0, c4196.m13229(), 0);
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m15159(int i) {
        BeautyItemView beautyItemView = this.f17206;
        if (beautyItemView != null) {
            if (i == 0) {
                beautyItemView.m2775();
                return;
            }
            beautyItemView.m2777();
            this.f17206.setBeautyLevel(i + "");
        }
    }
}
