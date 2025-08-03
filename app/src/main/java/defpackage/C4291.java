package defpackage;

import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC4975;
import java.util.List;

/* compiled from: SettingPresetPortraitViewHolder.java */
/* renamed from: ੴ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4291 extends AbstractC4956<C4802> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public TextView f14704;

    /* renamed from: ԯ, reason: contains not printable characters */
    public EditText f14705;

    /* renamed from: ՠ, reason: contains not printable characters */
    public View f14706;

    /* renamed from: ֈ, reason: contains not printable characters */
    public View f14707;

    /* renamed from: ֏, reason: contains not printable characters */
    public View f14708;

    /* renamed from: ׯ, reason: contains not printable characters */
    public View f14709;

    /* renamed from: ؠ, reason: contains not printable characters */
    public View f14710;

    /* renamed from: ހ, reason: contains not printable characters */
    public View f14711;

    /* renamed from: ށ, reason: contains not printable characters */
    public View f14712;

    /* renamed from: ނ, reason: contains not printable characters */
    public View f14713;

    /* renamed from: ރ, reason: contains not printable characters */
    public View f14714;

    /* renamed from: ބ, reason: contains not printable characters */
    public View f14715;

    /* renamed from: ޅ, reason: contains not printable characters */
    public TextView f14716;

    /* renamed from: ކ, reason: contains not printable characters */
    public InterfaceC4172 f14717;

    /* compiled from: SettingPresetPortraitViewHolder.java */
    /* renamed from: ੴ$Ϳ, reason: contains not printable characters */
    public class ViewOnTouchListenerC4292 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14718;

        public ViewOnTouchListenerC4292(int i) {
            this.f14718 = i;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                List listMo11699 = C4291.this.f16734.mo11699();
                int i = -1;
                for (int i2 = 0; i2 < listMo11699.size(); i2++) {
                    if (((C4802) listMo11699.get(i2)).m14516()) {
                        i = i2;
                    }
                }
                C4291.this.f14717.mo1559(this.f14718, 5, Integer.valueOf(i));
                C4291.this.m13415();
            }
            return false;
        }
    }

    /* compiled from: SettingPresetPortraitViewHolder.java */
    /* renamed from: ੴ$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC4293 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14720;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ C4802 f14721;

        public ViewOnClickListenerC4293(int i, C4802 c4802) {
            this.f14720 = i;
            this.f14721 = c4802;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C4291.this.m13414(this.f14720)) {
                return;
            }
            this.f14721.m14518(true);
            C4291.this.m13412();
        }
    }

    /* compiled from: SettingPresetPortraitViewHolder.java */
    /* renamed from: ੴ$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC4294 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14723;

        public ViewOnClickListenerC4294(int i) {
            this.f14723 = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            List listMo11699 = C4291.this.f16734.mo11699();
            int i2 = -1;
            for (int i3 = 0; i3 < listMo11699.size(); i3++) {
                if (((C4802) listMo11699.get(i3)).m14516()) {
                    i2 = i3;
                }
            }
            if (i2 == -1 || i2 == (i = this.f14723)) {
                C4291.this.f14717.mo1559(this.f14723, 2, null);
            } else {
                C4291.this.f14717.mo1559(i, 5, Integer.valueOf(i2));
                C4291.this.m13415();
            }
        }
    }

    /* compiled from: SettingPresetPortraitViewHolder.java */
    /* renamed from: ੴ$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC4295 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14725;

        public ViewOnClickListenerC4295(int i) {
            this.f14725 = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            List listMo11699 = C4291.this.f16734.mo11699();
            int i2 = -1;
            for (int i3 = 0; i3 < listMo11699.size(); i3++) {
                if (((C4802) listMo11699.get(i3)).m14516()) {
                    i2 = i3;
                }
            }
            if (i2 == -1 || i2 == (i = this.f14725)) {
                C4291.this.f14717.mo1559(this.f14725, 3, null);
            } else {
                C4291.this.f14717.mo1559(i, 5, Integer.valueOf(i2));
                C4291.this.m13415();
            }
        }
    }

    /* compiled from: SettingPresetPortraitViewHolder.java */
    /* renamed from: ੴ$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC4296 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14727;

        public ViewOnClickListenerC4296(int i) {
            this.f14727 = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            List listMo11699 = C4291.this.f16734.mo11699();
            int i2 = -1;
            for (int i3 = 0; i3 < listMo11699.size(); i3++) {
                if (((C4802) listMo11699.get(i3)).m14516()) {
                    i2 = i3;
                }
            }
            if (i2 == -1 || i2 == (i = this.f14727)) {
                C4291.this.f14717.mo1559(this.f14727, 4, null);
            } else {
                C4291.this.f14717.mo1559(i, 5, Integer.valueOf(i2));
                C4291.this.m13415();
            }
        }
    }

    /* compiled from: SettingPresetPortraitViewHolder.java */
    /* renamed from: ੴ$ՠ, reason: contains not printable characters */
    public class C4297 implements TextView.OnEditorActionListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f14729;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ C4802 f14730;

        public C4297(int i, C4802 c4802) {
            this.f14729 = i;
            this.f14730 = c4802;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 || !r1.m8143(C4291.this.f14705.getText().toString())) {
                return false;
            }
            C4291.this.m13417(this.f14729, this.f14730);
            C4291.this.f14717.mo1559(this.f14729, 1, null);
            return false;
        }
    }

    /* compiled from: SettingPresetPortraitViewHolder.java */
    /* renamed from: ੴ$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC4298 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14732;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ C4802 f14733;

        public ViewOnClickListenerC4298(int i, C4802 c4802) {
            this.f14732 = i;
            this.f14733 = c4802;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8143(C4291.this.f14705.getText().toString())) {
                C4291.this.m13417(this.f14732, this.f14733);
                C4291.this.f14717.mo1559(this.f14732, 1, null);
            }
        }
    }

    /* compiled from: SettingPresetPortraitViewHolder.java */
    /* renamed from: ੴ$֏, reason: contains not printable characters */
    public class RunnableC4299 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f14735;

        public RunnableC4299(String str) {
            this.f14735 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4291.this.f14705.setSelection(this.f14735.length());
            C4291.this.f14705.requestFocus();
            C4291.this.f14705.selectAll();
            ((InputMethodManager) C4291.this.f14705.getContext().getSystemService("input_method")).showSoftInput(C4291.this.f14705, 0);
        }
    }

    /* compiled from: SettingPresetPortraitViewHolder.java */
    /* renamed from: ੴ$ׯ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC4300 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f14737;

        /* compiled from: SettingPresetPortraitViewHolder.java */
        /* renamed from: ੴ$ׯ$Ϳ, reason: contains not printable characters */
        public class RunnableC4301 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f14738;

            public RunnableC4301(View view) {
                this.f14738 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f14738.isEnabled()) {
                    ViewOnTouchListenerC4300.this.f14737.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC4300(View view) {
            this.f14737 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f14737.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC4301(view), 100L);
            return false;
        }
    }

    public C4291(View view, Context context, AbstractC4975.InterfaceC4977<C4802> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        this.f14717 = (InterfaceC4172) interfaceC4976;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        float fM9440 = C2579.m9440(m10050());
        layoutParams.height = (int) (0.34621578f * fM9440);
        view.setLayoutParams(layoutParams);
        this.f14704 = (TextView) view.findViewById(R.id.tv_name);
        this.f14705 = (EditText) view.findViewById(R.id.et_rename);
        this.f14706 = view.findViewById(R.id.rl_rename);
        this.f14707 = view.findViewById(R.id.rl_show_qr);
        this.f14708 = view.findViewById(R.id.rl_reload);
        this.f14709 = view.findViewById(R.id.rl_delete);
        this.f14710 = view.findViewById(R.id.iv_rename);
        this.f14711 = view.findViewById(R.id.iv_show_qr);
        this.f14712 = view.findViewById(R.id.iv_reload);
        this.f14713 = view.findViewById(R.id.iv_delete);
        this.f14714 = view.findViewById(R.id.rl_save);
        this.f14715 = view.findViewById(R.id.save_view);
        this.f14716 = (TextView) view.findViewById(R.id.tv_save);
        int iM14476 = C4792.m14375().m14476(54);
        int iM144762 = C4792.m14375().m14476(54);
        int iM144763 = C4792.m14375().m14476(86) / 2;
        m13419(this.f14706, 0, iM144763);
        m13419(this.f14707, iM144763, iM144763);
        m13419(this.f14708, iM144763, iM144763);
        m13419(this.f14709, iM144763, iM144763);
        int i = ((int) (0.056360707f * fM9440)) / 2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f14704.getLayoutParams();
        layoutParams2.bottomMargin = i;
        this.f14704.setLayoutParams(layoutParams2);
        m13418(this.f14710, iM14476, iM144762, i);
        m13418(this.f14711, iM14476, iM144762, i);
        m13418(this.f14712, iM14476, iM144762, i);
        m13418(this.f14713, iM14476, iM144762, i);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f14715.getLayoutParams();
        int iM14386 = C4792.m14375().m14386();
        layoutParams3.height = iM14386;
        layoutParams3.width = (int) (iM14386 * 2.6875f);
        layoutParams3.topMargin = i;
        this.f14715.setLayoutParams(layoutParams3);
        this.f14716.setTypeface(FilmApp.m404());
        this.f14716.setTextSize(0, C4792.m14375().m14378());
        this.f14716.getPaint().setFakeBoldText(true);
        this.f14716.setText(R.string.BUTTON_SAVE);
        this.f14716.setLayoutParams((RelativeLayout.LayoutParams) this.f14716.getLayoutParams());
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f14714.getLayoutParams();
        layoutParams4.width = layoutParams3.width;
        int iM9438 = C2579.m9438(44.0f);
        layoutParams4.height = iM9438;
        layoutParams4.topMargin = layoutParams3.topMargin - ((iM9438 - layoutParams3.height) / 2);
        this.f14714.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = this.f14705.getLayoutParams();
        layoutParams5.width = (int) (fM9440 * 0.6596794f);
        this.f14705.setLayoutParams(layoutParams5);
        this.f14705.setPadding(0, 0, 0, (layoutParams.height / 2) + i);
        this.f14704.setTextColor(-1);
        this.f14704.setTextSize(0, C4792.m14375().m14383());
        this.f14705.setTextColor(-1);
        this.f14705.setTextSize(0, C4792.m14375().m14383());
        this.f14705.setTypeface(FilmApp.m404());
        this.f14704.setTypeface(FilmApp.m404());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m13412() {
        String string = this.f14704.getText().toString();
        this.f14705.setText(string);
        this.f14704.setVisibility(8);
        this.f14705.setVisibility(0);
        this.f14705.postDelayed(new RunnableC4299(string), 50L);
        this.f14709.setVisibility(8);
        this.f14708.setVisibility(8);
        this.f14707.setVisibility(8);
        this.f14706.setVisibility(8);
        this.f14710.setVisibility(8);
        this.f14712.setVisibility(8);
        this.f14711.setVisibility(8);
        this.f14713.setVisibility(8);
        this.f14714.setVisibility(0);
        this.f14715.setVisibility(0);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m13413() {
        this.f14704.setVisibility(0);
        this.f14705.setVisibility(8);
        this.f14709.setVisibility(0);
        this.f14708.setVisibility(0);
        this.f14707.setVisibility(0);
        this.f14706.setVisibility(0);
        this.f14710.setVisibility(0);
        this.f14712.setVisibility(0);
        this.f14711.setVisibility(0);
        this.f14713.setVisibility(0);
        this.f14714.setVisibility(8);
        this.f14715.setVisibility(8);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean m13414(int i) {
        List listMo11699 = this.f16734.mo11699();
        int i2 = -1;
        for (int i3 = 0; i3 < listMo11699.size(); i3++) {
            if (((C4802) listMo11699.get(i3)).m14516()) {
                i2 = i3;
            }
        }
        if (i2 == -1 || i2 == i) {
            return false;
        }
        this.f14717.mo1559(i, 5, Integer.valueOf(i2));
        m13415();
        return true;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m13415() {
        ((InputMethodManager) m10050().getSystemService("input_method")).hideSoftInputFromWindow(this.f14705.getWindowToken(), 0);
    }

    @Override // defpackage.AbstractC2769
    /* renamed from: ؠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo3871(C4802 c4802, int i) {
        this.f14704.setText(c4802.m14515().m12400());
        c4802.m14518(false);
        m13413();
        this.itemView.setOnTouchListener(new ViewOnTouchListenerC4292(i));
        this.f14706.setOnClickListener(new ViewOnClickListenerC4293(i, c4802));
        this.f14707.setOnClickListener(new ViewOnClickListenerC4294(i));
        this.f14708.setOnClickListener(new ViewOnClickListenerC4295(i));
        this.f14709.setOnClickListener(new ViewOnClickListenerC4296(i));
        this.f14705.setOnEditorActionListener(new C4297(i, c4802));
        this.f14714.setOnClickListener(new ViewOnClickListenerC4298(i, c4802));
        this.f14706.setOnTouchListener(new ViewOnTouchListenerC4300(this.f14710));
        this.f14707.setOnTouchListener(new ViewOnTouchListenerC4300(this.f14711));
        this.f14708.setOnTouchListener(new ViewOnTouchListenerC4300(this.f14712));
        this.f14709.setOnTouchListener(new ViewOnTouchListenerC4300(this.f14713));
        View view = this.f14714;
        view.setOnTouchListener(new ViewOnTouchListenerC4300(view));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m13417(int i, C4802 c4802) {
        c4802.m14518(false);
        m13415();
        this.f14704.setText(this.f14705.getText().toString());
        m13413();
        c4802.m14515().m12516(this.f14705.getText().toString());
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m13418(View view, int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.topMargin = i3;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m13419(View view, int i, int i2) {
        view.setPadding(i, 0, i2, 0);
    }
}
