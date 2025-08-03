package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import com.zhiyun.sdk.device.Device;
import defpackage.AbstractC4975;

/* compiled from: SettingZhiyunViewHolder.java */
/* renamed from: උ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4779 extends AbstractC4956<C3760> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public TextView f16114;

    /* renamed from: ԯ, reason: contains not printable characters */
    public TextView f16115;

    /* renamed from: ՠ, reason: contains not printable characters */
    public View f16116;

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC4172 f16117;

    public C4779(View view, Context context, AbstractC4975.InterfaceC4977<C3760> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        this.f16117 = (InterfaceC4172) interfaceC4976;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int iM9442 = C2579.m9442(m10050());
        C2579.m9443(m10050());
        layoutParams.height = (int) (iM9442 * 0.10695187f);
        view.setLayoutParams(layoutParams);
        this.f16114 = (TextView) view.findViewById(R.id.tv_name);
        this.f16115 = (TextView) view.findViewById(R.id.tv_state);
        this.f16116 = view.findViewById(R.id.pb);
        this.f16114.setTextColor(-1);
        this.f16114.setTypeface(FilmApp.m404());
        this.f16114.setTextSize(0, C4792.m14375().m14379());
        this.f16115.setTextColor(-1);
        this.f16115.setTypeface(FilmApp.m404());
        this.f16115.setTextSize(0, C4792.m14375().m14379());
        this.f16115.setText(R.string.SETTINGS_ACCESORRIES_CONNECTED);
    }

    @Override // defpackage.AbstractC2769
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo3871(C3760 c3760, int i) {
        Device deviceM12042 = c3760.m12042();
        this.f16114.setText(deviceM12042.getModelName());
        this.f16115.setVisibility(8);
        this.f16116.setVisibility(8);
        if (c3760.m12043()) {
            this.f16116.setVisibility(0);
        } else if (deviceM12042.isConnected()) {
            this.f16115.setVisibility(0);
        }
    }
}
