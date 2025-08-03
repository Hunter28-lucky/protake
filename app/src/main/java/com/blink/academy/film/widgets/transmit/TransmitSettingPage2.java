package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.srt.SRTConnectionCallbackEntity;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.LinkEntity;
import com.blink.academy.film.stream.PageSettingCheckBean;
import com.blink.academy.film.stream.ban.ACBanManager;
import com.blink.academy.film.support.socket.TransmitHelper;
import defpackage.AbstractC4869;
import defpackage.AbstractC4975;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.C4906;
import defpackage.n;
import defpackage.r1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TransmitSettingPage2 extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4869 f4313;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public List<LinkEntity> f4314;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4906 f4315;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public List<PageSettingCheckBean> f4316;

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPage2$Ϳ, reason: contains not printable characters */
    public class C1621 implements AbstractC4975.InterfaceC4979 {

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingPage2$Ϳ$Ϳ, reason: contains not printable characters */
        public class C1622 implements n.InterfaceC2189 {
            public C1622() {
            }

            @Override // defpackage.n.InterfaceC2189
            public void onFail(ApiException apiException) {
            }

            @Override // defpackage.n.InterfaceC2189
            public void onSuc(SRTConnectionCallbackEntity sRTConnectionCallbackEntity) {
            }
        }

        public C1621() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4979
        /* renamed from: ԫ */
        public void mo4147(int i) {
            if (i == -1) {
                return;
            }
            LinkEntity linkEntity = (LinkEntity) TransmitSettingPage2.this.f4314.get(i);
            if (linkEntity.isBanned()) {
                return;
            }
            String uuid = linkEntity.getAcMonitorInfoBean().getUuid();
            ACBanManager.getInstance().addToAlreadySetControl(uuid);
            if (linkEntity.getControlState() == 4) {
                ACBanManager.getInstance().enableControl(uuid);
                linkEntity.setControlState(5);
            } else {
                ACBanManager.getInstance().disableControl(uuid);
                linkEntity.setControlState(4);
            }
            TransmitSettingPage2.this.f4315.notifyItemChanged(i);
        }

        @Override // defpackage.AbstractC4975.InterfaceC4979
        /* renamed from: Ԭ */
        public void mo4148(int i) {
            if (i == -1) {
                return;
            }
            LinkEntity linkEntity = (LinkEntity) TransmitSettingPage2.this.f4314.get(i);
            if (linkEntity.isBanned()) {
                linkEntity.changeBanState(false);
                ACBanManager.getInstance().removeFromBanList(linkEntity.getUuid());
            } else {
                linkEntity.changeBanState(true);
                ACBanManager.getInstance().addToBanList(linkEntity.getUuid(), linkEntity.getAcMonitorInfoBean().getJob(), linkEntity.getAcMonitorInfoBean().getSuffix());
            }
            n.m7588().m7612(new C1622());
            TransmitSettingPage2.this.f4315.notifyItemChanged(i);
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4979
        /* renamed from: ԯ */
        public void mo4149(int i) {
        }
    }

    public TransmitSettingPage2(@NonNull Context context) {
        super(context);
        this.f4314 = new ArrayList();
        this.f4316 = new ArrayList();
        m4318();
    }

    public void setData(List<LinkEntity> list) {
        if ((list.size() == this.f4316.size() && list.size() > 0 && m4316(list)) ? false : true) {
            this.f4314.clear();
            this.f4314.addAll(list);
            this.f4316.clear();
            if (r1.m8144(this.f4314)) {
                for (LinkEntity linkEntity : this.f4314) {
                    PageSettingCheckBean pageSettingCheckBean = new PageSettingCheckBean();
                    pageSettingCheckBean.setBan(linkEntity.isBanned());
                    pageSettingCheckBean.setWifiLevel(ACHelper.getInstance().getWifiViewLevel(linkEntity.getAcMonitorInfoBean().getWifiStatus()));
                    pageSettingCheckBean.setControlState(linkEntity.getControlState());
                    pageSettingCheckBean.setMessage(TransmitHelper.getMessage(linkEntity.getAcMonitorInfoBean()));
                    this.f4316.add(pageSettingCheckBean);
                }
            }
            m4320();
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m4316(List<LinkEntity> list) {
        for (int i = 0; i < list.size(); i++) {
            PageSettingCheckBean pageSettingCheckBean = this.f4316.get(i);
            LinkEntity linkEntity = list.get(i);
            if (pageSettingCheckBean.isBan() != linkEntity.isBanned() || pageSettingCheckBean.getControlState() != linkEntity.getControlState() || !pageSettingCheckBean.getMessage().equals(TransmitHelper.getMessage(linkEntity.getAcMonitorInfoBean())) || pageSettingCheckBean.getWifiLevel() != ACHelper.getInstance().getWifiViewLevel(linkEntity.getAcMonitorInfoBean().getWifiStatus())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4317() {
        this.f4313.f16466.setLayoutManager(new GridLayoutManager(getContext(), 2));
        C4906 c4906 = new C4906(getContext(), this.f4314, new C1621());
        this.f4315 = c4906;
        this.f4313.f16466.setAdapter(c4906);
        ((SimpleItemAnimator) this.f4313.f16466.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f4313.f16466.getItemAnimator().setChangeDuration(0L);
        this.f4313.f16466.setItemAnimator(null);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4318() {
        this.f4313 = AbstractC4869.m14591(LayoutInflater.from(getContext()), this, true);
        m4319();
        m4317();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4319() {
        int iM14397 = (int) ((C4792.m14375().m14397() * C4792.m14375().m14471()) + 0.5f);
        int iM14468 = C4792.m14375().m14468();
        C2579.m9444();
        C2579.m9439(getContext());
        this.f4313.f16467.setContentTextColor(-1);
        this.f4313.f16467.m2562(0, iM14397);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4313.f16467.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = iM14468;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (C2579.m9440(getContext()) * 0.04021448f);
        this.f4313.f16467.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4313.f16466.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = iM14468;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = iM14468;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = C4792.m14375().m14480(25.0f, C4792.m14375().m14471());
        this.f4313.f16466.setLayoutParams(layoutParams2);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4320() {
        C4906 c4906 = this.f4315;
        if (c4906 != null) {
            c4906.notifyDataSetChanged();
        }
    }

    public TransmitSettingPage2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4314 = new ArrayList();
        this.f4316 = new ArrayList();
        m4318();
    }

    public TransmitSettingPage2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4314 = new ArrayList();
        this.f4316 = new ArrayList();
        m4318();
    }
}
