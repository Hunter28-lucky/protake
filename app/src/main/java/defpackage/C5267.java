package defpackage;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4975;
import java.util.List;

/* compiled from: SettingPresetViewHolder.java */
/* renamed from: ლ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5267 extends AbstractC4956<C4802> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public StrokeTextView f17425;

    /* renamed from: ԯ, reason: contains not printable characters */
    public EditText f17426;

    /* renamed from: ՠ, reason: contains not printable characters */
    public View f17427;

    /* renamed from: ֈ, reason: contains not printable characters */
    public View f17428;

    /* renamed from: ֏, reason: contains not printable characters */
    public View f17429;

    /* renamed from: ׯ, reason: contains not printable characters */
    public View f17430;

    /* renamed from: ؠ, reason: contains not printable characters */
    public View f17431;

    /* renamed from: ހ, reason: contains not printable characters */
    public View f17432;

    /* renamed from: ށ, reason: contains not printable characters */
    public View f17433;

    /* renamed from: ނ, reason: contains not printable characters */
    public View f17434;

    /* renamed from: ރ, reason: contains not printable characters */
    public View f17435;

    /* renamed from: ބ, reason: contains not printable characters */
    public View f17436;

    /* renamed from: ޅ, reason: contains not printable characters */
    public TextView f17437;

    /* renamed from: ކ, reason: contains not printable characters */
    public InterfaceC4172 f17438;

    /* compiled from: SettingPresetViewHolder.java */
    /* renamed from: ლ$Ϳ, reason: contains not printable characters */
    public class ViewOnTouchListenerC5268 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f17439;

        public ViewOnTouchListenerC5268(int i) {
            this.f17439 = i;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                List listMo11699 = C5267.this.f16734.mo11699();
                int i = -1;
                for (int i2 = 0; i2 < listMo11699.size(); i2++) {
                    if (((C4802) listMo11699.get(i2)).m14516()) {
                        i = i2;
                    }
                }
                C5267.this.f17438.mo1559(this.f17439, 5, Integer.valueOf(i));
                C5267.this.m15321();
            }
            return false;
        }
    }

    /* compiled from: SettingPresetViewHolder.java */
    /* renamed from: ლ$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC5269 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f17441;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ C4802 f17442;

        public ViewOnClickListenerC5269(int i, C4802 c4802) {
            this.f17441 = i;
            this.f17442 = c4802;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C5267.this.m15320(this.f17441)) {
                return;
            }
            this.f17442.m14518(true);
            C5267.this.m15318();
        }
    }

    /* compiled from: SettingPresetViewHolder.java */
    /* renamed from: ლ$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC5270 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f17444;

        public ViewOnClickListenerC5270(int i) {
            this.f17444 = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            List listMo11699 = C5267.this.f16734.mo11699();
            int i2 = -1;
            for (int i3 = 0; i3 < listMo11699.size(); i3++) {
                if (((C4802) listMo11699.get(i3)).m14516()) {
                    i2 = i3;
                }
            }
            if (i2 == -1 || i2 == (i = this.f17444)) {
                C5267.this.f17438.mo1559(this.f17444, 2, null);
            } else {
                C5267.this.f17438.mo1559(i, 5, Integer.valueOf(i2));
                C5267.this.m15321();
            }
        }
    }

    /* compiled from: SettingPresetViewHolder.java */
    /* renamed from: ლ$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC5271 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f17446;

        public ViewOnClickListenerC5271(int i) {
            this.f17446 = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            List listMo11699 = C5267.this.f16734.mo11699();
            int i2 = -1;
            for (int i3 = 0; i3 < listMo11699.size(); i3++) {
                if (((C4802) listMo11699.get(i3)).m14516()) {
                    i2 = i3;
                }
            }
            if (i2 == -1 || i2 == (i = this.f17446)) {
                C5267.this.f17438.mo1559(this.f17446, 3, null);
            } else {
                C5267.this.f17438.mo1559(i, 5, Integer.valueOf(i2));
                C5267.this.m15321();
            }
        }
    }

    /* compiled from: SettingPresetViewHolder.java */
    /* renamed from: ლ$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC5272 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f17448;

        public ViewOnClickListenerC5272(int i) {
            this.f17448 = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            List listMo11699 = C5267.this.f16734.mo11699();
            int i2 = -1;
            for (int i3 = 0; i3 < listMo11699.size(); i3++) {
                if (((C4802) listMo11699.get(i3)).m14516()) {
                    i2 = i3;
                }
            }
            if (i2 == -1 || i2 == (i = this.f17448)) {
                C5267.this.f17438.mo1559(this.f17448, 4, null);
            } else {
                C5267.this.f17438.mo1559(i, 5, Integer.valueOf(i2));
                C5267.this.m15321();
            }
        }
    }

    /* compiled from: SettingPresetViewHolder.java */
    /* renamed from: ლ$ՠ, reason: contains not printable characters */
    public class C5273 implements TextView.OnEditorActionListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f17450;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ C4802 f17451;

        public C5273(int i, C4802 c4802) {
            this.f17450 = i;
            this.f17451 = c4802;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 || !r1.m8143(C5267.this.f17426.getText().toString())) {
                return false;
            }
            C5267.this.m15323(this.f17450, this.f17451);
            C5267.this.f17438.mo1559(this.f17450, 1, null);
            return false;
        }
    }

    /* compiled from: SettingPresetViewHolder.java */
    /* renamed from: ლ$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC5274 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f17453;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ C4802 f17454;

        public ViewOnClickListenerC5274(int i, C4802 c4802) {
            this.f17453 = i;
            this.f17454 = c4802;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8143(C5267.this.f17426.getText().toString())) {
                C5267.this.m15323(this.f17453, this.f17454);
                C5267.this.f17438.mo1559(this.f17453, 1, null);
            }
        }
    }

    /* compiled from: SettingPresetViewHolder.java */
    /* renamed from: ლ$֏, reason: contains not printable characters */
    public class RunnableC5275 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f17456;

        public RunnableC5275(String str) {
            this.f17456 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5267.this.f17426.setSelection(this.f17456.length());
            C5267.this.f17426.requestFocus();
            C5267.this.f17426.selectAll();
            ((InputMethodManager) C5267.this.f17426.getContext().getSystemService("input_method")).showSoftInput(C5267.this.f17426, 0);
        }
    }

    /* compiled from: SettingPresetViewHolder.java */
    /* renamed from: ლ$ׯ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC5276 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f17458;

        /* compiled from: SettingPresetViewHolder.java */
        /* renamed from: ლ$ׯ$Ϳ, reason: contains not printable characters */
        public class RunnableC5277 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f17459;

            public RunnableC5277(View view) {
                this.f17459 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f17459.isEnabled()) {
                    ViewOnTouchListenerC5276.this.f17458.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC5276(View view) {
            this.f17458 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f17458.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC5277(view), 100L);
            return false;
        }
    }

    public C5267(View view, Context context, AbstractC4975.InterfaceC4977<C4802> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        this.f17438 = (InterfaceC4172) interfaceC4976;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int iM9440 = C2579.m9440(m10050());
        int iM94402 = C2579.m9440(m10050());
        float f = iM9440;
        layoutParams.height = (int) (0.16487935f * f);
        view.setLayoutParams(layoutParams);
        this.f17425 = (StrokeTextView) view.findViewById(R.id.tv_name);
        this.f17426 = (EditText) view.findViewById(R.id.et_rename);
        this.f17427 = view.findViewById(R.id.rl_rename);
        this.f17428 = view.findViewById(R.id.rl_show_qr);
        this.f17429 = view.findViewById(R.id.rl_reload);
        this.f17430 = view.findViewById(R.id.rl_delete);
        this.f17431 = view.findViewById(R.id.iv_rename);
        this.f17432 = view.findViewById(R.id.iv_show_qr);
        this.f17433 = view.findViewById(R.id.iv_reload);
        this.f17434 = view.findViewById(R.id.iv_delete);
        this.f17435 = view.findViewById(R.id.rl_save);
        this.f17436 = view.findViewById(R.id.save_view);
        this.f17437 = (TextView) view.findViewById(R.id.tv_save);
        this.f17425.setDrawBorder(false);
        C2579.m9438(44.0f);
        C2579.m9438(44.0f);
        int i = (int) (f * 0.049597856f);
        float f2 = iM94402;
        int i2 = (int) (0.03699137f * f2);
        int i3 = (int) ((0.043156598f * f2) / 2.0f);
        m15325(this.f17427, i3, i3);
        m15325(this.f17428, i3, i3);
        m15325(this.f17429, i3, i3);
        m15325(this.f17430, i3, 0);
        m15324(this.f17431, i, i, i2);
        m15324(this.f17432, i, i, i2);
        m15324(this.f17433, i, i, i2);
        m15324(this.f17434, i, i, 0);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f17436.getLayoutParams();
        int iM14384 = C4792.m14375().m14384();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = iM14384;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (iM14384 * 2.6875f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = C4792.m14375().m14386();
        this.f17436.setLayoutParams(layoutParams2);
        this.f17437.setTypeface(FilmApp.m404());
        this.f17437.setTextSize(0, C4792.m14375().m14397());
        this.f17437.getPaint().setFakeBoldText(true);
        this.f17437.setText(R.string.BUTTON_SAVE);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f17435.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
        this.f17435.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f17426.getLayoutParams();
        layoutParams4.width = (int) (f2 * 0.6596794f);
        this.f17426.setLayoutParams(layoutParams4);
        Paint.FontMetrics fontMetrics = this.f17426.getPaint().getFontMetrics();
        this.f17426.setPadding(0, 0, 0, (layoutParams.height - ((int) (fontMetrics.bottom - fontMetrics.top))) / 2);
        this.f17425.setContentTextColor(-1);
        this.f17425.m2562(0, C4792.m14375().m14381());
        this.f17425.setTypeface(FilmApp.m404());
        this.f17426.setTextColor(-1);
        this.f17426.setTextSize(0, C4792.m14375().m14381());
        this.f17426.setTypeface(FilmApp.m404());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m15318() {
        String string = this.f17425.getText().toString();
        this.f17426.setText(string);
        this.f17425.setVisibility(8);
        this.f17426.setVisibility(0);
        this.f17426.postDelayed(new RunnableC5275(string), 50L);
        this.f17430.setVisibility(8);
        this.f17429.setVisibility(8);
        this.f17428.setVisibility(8);
        this.f17427.setVisibility(8);
        this.f17431.setVisibility(8);
        this.f17433.setVisibility(8);
        this.f17432.setVisibility(8);
        this.f17434.setVisibility(8);
        this.f17435.setVisibility(0);
        this.f17436.setVisibility(0);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m15319() {
        this.f17425.setVisibility(0);
        this.f17426.setVisibility(8);
        this.f17430.setVisibility(0);
        this.f17429.setVisibility(0);
        this.f17428.setVisibility(0);
        this.f17427.setVisibility(0);
        this.f17431.setVisibility(0);
        this.f17433.setVisibility(0);
        this.f17432.setVisibility(0);
        this.f17434.setVisibility(0);
        this.f17435.setVisibility(8);
        this.f17436.setVisibility(8);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean m15320(int i) {
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
        this.f17438.mo1559(i, 5, Integer.valueOf(i2));
        m15321();
        return true;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m15321() {
        ((InputMethodManager) m10050().getSystemService("input_method")).hideSoftInputFromWindow(this.f17426.getWindowToken(), 0);
    }

    @Override // defpackage.AbstractC2769
    /* renamed from: ؠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo3871(C4802 c4802, int i) {
        this.f17425.setText(c4802.m14515().m12400());
        c4802.m14518(false);
        m15319();
        this.itemView.setOnTouchListener(new ViewOnTouchListenerC5268(i));
        this.f17427.setOnClickListener(new ViewOnClickListenerC5269(i, c4802));
        this.f17428.setOnClickListener(new ViewOnClickListenerC5270(i));
        this.f17429.setOnClickListener(new ViewOnClickListenerC5271(i));
        this.f17430.setOnClickListener(new ViewOnClickListenerC5272(i));
        this.f17426.setOnEditorActionListener(new C5273(i, c4802));
        this.f17435.setOnClickListener(new ViewOnClickListenerC5274(i, c4802));
        this.f17427.setOnTouchListener(new ViewOnTouchListenerC5276(this.f17431));
        this.f17428.setOnTouchListener(new ViewOnTouchListenerC5276(this.f17432));
        this.f17429.setOnTouchListener(new ViewOnTouchListenerC5276(this.f17433));
        this.f17430.setOnTouchListener(new ViewOnTouchListenerC5276(this.f17434));
        View view = this.f17435;
        view.setOnTouchListener(new ViewOnTouchListenerC5276(view));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m15323(int i, C4802 c4802) {
        c4802.m14518(false);
        m15321();
        this.f17425.setText(this.f17426.getText().toString());
        m15319();
        c4802.m14515().m12516(this.f17426.getText().toString());
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m15324(View view, int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m15325(View view, int i, int i2) {
        view.setPadding(i, 0, i2, 0);
    }
}
