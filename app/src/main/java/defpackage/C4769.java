package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC4975;

/* compiled from: SettingProtakeFocusViewHolder.java */
/* renamed from: ൿ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4769 extends AbstractC4956<C3637> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public TextView f16067;

    /* renamed from: ԯ, reason: contains not printable characters */
    public TextView f16068;

    /* renamed from: ՠ, reason: contains not printable characters */
    public View f16069;

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC4172 f16070;

    public C4769(View view, Context context, AbstractC4975.InterfaceC4977<C3637> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        this.f16070 = (InterfaceC4172) interfaceC4976;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int iM9442 = C2579.m9442(m10050());
        C2579.m9443(m10050());
        layoutParams.height = (int) (iM9442 * 0.10695187f);
        view.setLayoutParams(layoutParams);
        this.f16067 = (TextView) view.findViewById(R.id.tv_name);
        this.f16068 = (TextView) view.findViewById(R.id.tv_state);
        this.f16069 = view.findViewById(R.id.pb);
        this.f16067.setTextColor(-1);
        this.f16067.setTypeface(FilmApp.m404());
        this.f16067.setTextSize(0, C4792.m14375().m14379());
        this.f16068.setTextColor(-1);
        this.f16068.setTypeface(FilmApp.m404());
        this.f16068.setTextSize(0, C4792.m14375().m14379());
        this.f16068.setText(R.string.SETTINGS_ACCESORRIES_CONNECTED);
    }

    @Override // defpackage.AbstractC2769
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo3871(C3637 c3637, int i) {
        C4489 c4489M11702 = c3637.m11702();
        this.f16067.setText(c4489M11702.m13769());
        this.f16068.setVisibility(8);
        this.f16069.setVisibility(8);
        if (c3637.m11703()) {
            this.f16069.setVisibility(0);
        } else if (c4489M11702.m13774()) {
            this.f16068.setVisibility(0);
        }
    }
}
