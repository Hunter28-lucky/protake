package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.blink.academy.protake.R;

/* compiled from: BasePickerView.java */
/* renamed from: ၰ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5166 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Context f17102;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public ViewGroup f17103;

    /* renamed from: ԭ, reason: contains not printable characters */
    public ViewGroup f17104;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ViewGroup f17105;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C5303 f17106;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC2717 f17107;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f17108;

    /* renamed from: ֏, reason: contains not printable characters */
    public Animation f17109;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Animation f17110;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f17111;

    /* renamed from: ށ, reason: contains not printable characters */
    public Dialog f17113;

    /* renamed from: ނ, reason: contains not printable characters */
    public View f17114;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f17112 = 80;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f17115 = true;

    /* renamed from: ބ, reason: contains not printable characters */
    public View.OnKeyListener f17116 = new ViewOnKeyListenerC5170();

    /* renamed from: ޅ, reason: contains not printable characters */
    public final View.OnTouchListener f17117 = new ViewOnTouchListenerC5171();

    /* compiled from: BasePickerView.java */
    /* renamed from: ၰ$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC5167 implements View.OnClickListener {
        public ViewOnClickListenerC5167() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C5166.this.m15098();
        }
    }

    /* compiled from: BasePickerView.java */
    /* renamed from: ၰ$Ԩ, reason: contains not printable characters */
    public class AnimationAnimationListenerC5168 implements Animation.AnimationListener {
        public AnimationAnimationListenerC5168() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            C5166.this.m15100();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: BasePickerView.java */
    /* renamed from: ၰ$Ԫ, reason: contains not printable characters */
    public class RunnableC5169 implements Runnable {
        public RunnableC5169() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5166 c5166 = C5166.this;
            c5166.f17106.f17524.removeView(c5166.f17104);
            C5166.this.f17111 = false;
            C5166.this.f17108 = false;
            if (C5166.this.f17107 != null) {
                C5166.this.f17107.mo9973(C5166.this);
            }
        }
    }

    /* compiled from: BasePickerView.java */
    /* renamed from: ၰ$Ԭ, reason: contains not printable characters */
    public class ViewOnKeyListenerC5170 implements View.OnKeyListener {
        public ViewOnKeyListenerC5170() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0 || !C5166.this.m15109()) {
                return false;
            }
            C5166.this.m15098();
            return true;
        }
    }

    /* compiled from: BasePickerView.java */
    /* renamed from: ၰ$Ԯ, reason: contains not printable characters */
    public class ViewOnTouchListenerC5171 implements View.OnTouchListener {
        public ViewOnTouchListenerC5171() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            C5166.this.m15098();
            return false;
        }
    }

    /* compiled from: BasePickerView.java */
    /* renamed from: ၰ$ՠ, reason: contains not printable characters */
    public class DialogInterfaceOnDismissListenerC5172 implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC5172() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (C5166.this.f17107 != null) {
                C5166.this.f17107.mo9973(C5166.this);
            }
        }
    }

    public C5166(Context context) {
        this.f17102 = context;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m15097() {
        if (this.f17105 != null) {
            Dialog dialog = new Dialog(this.f17102, R.style.custom_dialog2);
            this.f17113 = dialog;
            dialog.setCancelable(this.f17106.f17546);
            this.f17113.setContentView(this.f17105);
            Window window = this.f17113.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.f17113.setOnDismissListener(new DialogInterfaceOnDismissListenerC5172());
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m15098() {
        if (mo13332()) {
            m15099();
            return;
        }
        if (this.f17108) {
            return;
        }
        if (this.f17115) {
            this.f17109.setAnimationListener(new AnimationAnimationListenerC5168());
            this.f17103.startAnimation(this.f17109);
        } else {
            m15100();
        }
        this.f17108 = true;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m15099() {
        Dialog dialog = this.f17113;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m15100() {
        this.f17106.f17524.post(new RunnableC5169());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public View m15101(int i) {
        return this.f17103.findViewById(i);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public Dialog m15102() {
        return this.f17113;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public ViewGroup m15103() {
        return this.f17103;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final Animation m15104() {
        return AnimationUtils.loadAnimation(this.f17102, C4601.m14059(this.f17112, true));
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final Animation m15105() {
        return AnimationUtils.loadAnimation(this.f17102, C4601.m14059(this.f17112, false));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m15106() {
        this.f17110 = m15104();
        this.f17109 = m15105();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m15107() {
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m15108() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f17102);
        if (mo13332()) {
            ViewGroup viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f17105 = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f17105.findViewById(R.id.content_container);
            this.f17103 = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            m15097();
            this.f17105.setOnClickListener(new ViewOnClickListenerC5167());
        } else {
            C5303 c5303 = this.f17106;
            if (c5303.f17524 == null) {
                c5303.f17524 = (ViewGroup) ((Activity) this.f17102).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) layoutInflaterFrom.inflate(R.layout.layout_basepickerview, this.f17106.f17524, false);
            this.f17104 = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i = this.f17106.f17541;
            if (i != -1) {
                this.f17104.setBackgroundColor(i);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.f17104.findViewById(R.id.content_container);
            this.f17103 = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        m15112(true);
    }

    /* renamed from: ނ */
    public boolean mo13332() {
        throw null;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean m15109() {
        if (mo13332()) {
            return false;
        }
        return this.f17104.getParent() != null || this.f17111;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m15110(View view) {
        this.f17106.f17524.addView(view);
        if (this.f17115) {
            this.f17103.startAnimation(this.f17110);
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m15111() {
        Dialog dialog = this.f17113;
        if (dialog != null) {
            dialog.setCancelable(this.f17106.f17546);
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m15112(boolean z) {
        ViewGroup viewGroup = mo13332() ? this.f17105 : this.f17104;
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.f17116);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public C5166 m15113(InterfaceC2717 interfaceC2717) {
        this.f17107 = interfaceC2717;
        return this;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public C5166 m15114(boolean z) {
        ViewGroup viewGroup = this.f17104;
        if (viewGroup != null) {
            View viewFindViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z) {
                viewFindViewById.setOnTouchListener(this.f17117);
            } else {
                viewFindViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m15115() {
        if (mo13332()) {
            m15116();
        } else {
            if (m15109()) {
                return;
            }
            this.f17111 = true;
            m15110(this.f17104);
            this.f17104.requestFocus();
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m15116() {
        Dialog dialog = this.f17113;
        if (dialog != null) {
            dialog.show();
        }
    }
}
