package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blink.academy.protake.R;
import java.util.List;

/* compiled from: OptionsPickerView.java */
/* renamed from: ਐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class ViewOnClickListenerC4235<T> extends C5166 implements View.OnClickListener {

    /* renamed from: ކ, reason: contains not printable characters */
    public b8 f14558;

    public ViewOnClickListenerC4235(C5303 c5303) {
        super(c5303.f17526);
        this.f17106 = c5303;
        m13333(c5303.f17526);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            m13335();
        }
        m15098();
    }

    @Override // defpackage.C5166
    /* renamed from: ނ, reason: contains not printable characters */
    public boolean mo13332() {
        return this.f17106.f17545;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m13333(Context context) {
        m15111();
        m15108();
        m15106();
        m15107();
        InterfaceC2539 interfaceC2539 = this.f17106.f17506;
        if (interfaceC2539 == null) {
            LayoutInflater.from(context).inflate(this.f17106.f17523, this.f17103);
            TextView textView = (TextView) m15101(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) m15101(R.id.rv_topbar);
            Button button = (Button) m15101(R.id.btnSubmit);
            Button button2 = (Button) m15101(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.f17106.f17527) ? "" : this.f17106.f17527);
            button2.setText(TextUtils.isEmpty(this.f17106.f17528) ? "" : this.f17106.f17528);
            textView.setText(TextUtils.isEmpty(this.f17106.f17529) ? "" : this.f17106.f17529);
            button.setTextColor(this.f17106.f17530);
            button2.setTextColor(this.f17106.f17531);
            textView.setTextColor(this.f17106.f17532);
            relativeLayout.setBackgroundColor(this.f17106.f17534);
            button.setTextSize(this.f17106.f17535);
            button2.setTextSize(this.f17106.f17535);
            textView.setTextSize(this.f17106.f17536);
        } else {
            interfaceC2539.mo9357(LayoutInflater.from(context).inflate(this.f17106.f17523, this.f17103));
        }
        LinearLayout linearLayout = (LinearLayout) m15101(R.id.optionspicker);
        linearLayout.setBackgroundColor(this.f17106.f17533);
        b8 b8Var = new b8(linearLayout, this.f17106.f17519);
        this.f14558 = b8Var;
        InterfaceC3632 interfaceC3632 = this.f17106.f17505;
        if (interfaceC3632 != null) {
            b8Var.m149(interfaceC3632);
        }
        this.f14558.m155(this.f17106.f17537);
        b8 b8Var2 = this.f14558;
        C5303 c5303 = this.f17106;
        b8Var2.m146(c5303.f17507, c5303.f17508, c5303.f17509);
        b8 b8Var3 = this.f14558;
        C5303 c53032 = this.f17106;
        b8Var3.m156(c53032.f17513, c53032.f17514, c53032.f17515);
        b8 b8Var4 = this.f14558;
        C5303 c53033 = this.f17106;
        b8Var4.m141(c53033.f17516, c53033.f17517, c53033.f17518);
        this.f14558.m157(this.f17106.f17548);
        m15114(this.f17106.f17546);
        this.f14558.m143(this.f17106.f17540);
        this.f14558.m145(this.f17106.f17549);
        this.f14558.m148(this.f17106.f17544);
        this.f14558.m154(this.f17106.f17538);
        this.f14558.m152(this.f17106.f17539);
        this.f14558.m138(this.f17106.f17547);
        C5303 c53034 = this.f17106;
        linearLayout.setPadding(0, c53034.f17542, 0, c53034.f17543);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m13334() {
        b8 b8Var = this.f14558;
        if (b8Var != null) {
            C5303 c5303 = this.f17106;
            b8Var.m140(c5303.f17510, c5303.f17511, c5303.f17512);
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m13335() {
        if (this.f17106.f17504 != null) {
            int[] iArrM137 = this.f14558.m137();
            this.f17106.f17504.mo3091(iArrM137[0], iArrM137[1], iArrM137[2], this.f17114);
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m13336(int i) {
        b8 b8Var = this.f14558;
        if (b8Var != null) {
            b8Var.m140(i, i, i);
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m13337(List<T> list) {
        m13338(list, null, null);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m13338(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f14558.m150(list, list2, list3);
        m13334();
    }
}
