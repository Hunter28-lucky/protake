package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget.java */
/* loaded from: classes.dex */
public abstract class q7<T extends View, Z> extends AbstractC5173<Z> {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static boolean f8427;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public static Integer f8428;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final T f8429;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C2245 f8430;

    /* renamed from: Ԫ, reason: contains not printable characters */
    @Nullable
    public View.OnAttachStateChangeListener f8431;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f8432;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f8433;

    /* compiled from: ViewTarget.java */
    @VisibleForTesting
    /* renamed from: q7$Ϳ, reason: contains not printable characters */
    public static final class C2245 {

        /* renamed from: ԫ, reason: contains not printable characters */
        @Nullable
        @VisibleForTesting
        public static Integer f8434;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final View f8435;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final List<InterfaceC4752> f8436 = new ArrayList();

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean f8437;

        /* renamed from: Ԫ, reason: contains not printable characters */
        @Nullable
        public ViewTreeObserverOnPreDrawListenerC2246 f8438;

        /* compiled from: ViewTarget.java */
        /* renamed from: q7$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class ViewTreeObserverOnPreDrawListenerC2246 implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final WeakReference<C2245> f8439;

            public ViewTreeObserverOnPreDrawListenerC2246(@NonNull C2245 c2245) {
                this.f8439 = new WeakReference<>(c2245);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                C2245 c2245 = this.f8439.get();
                if (c2245 == null) {
                    return true;
                }
                c2245.m8074();
                return true;
            }
        }

        public C2245(@NonNull View view) {
            this.f8435 = view;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public static int m8073(@NonNull Context context) {
            if (f8434 == null) {
                Display defaultDisplay = ((WindowManager) C4513.m13867((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f8434 = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f8434.intValue();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m8074() {
            if (this.f8436.isEmpty()) {
                return;
            }
            int iM8079 = m8079();
            int iM8078 = m8078();
            if (m8081(iM8079, iM8078)) {
                m8082(iM8079, iM8078);
                m8075();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m8075() {
            ViewTreeObserver viewTreeObserver = this.f8435.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f8438);
            }
            this.f8438 = null;
            this.f8436.clear();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m8076(@NonNull InterfaceC4752 interfaceC4752) {
            int iM8079 = m8079();
            int iM8078 = m8078();
            if (m8081(iM8079, iM8078)) {
                interfaceC4752.mo5029(iM8079, iM8078);
                return;
            }
            if (!this.f8436.contains(interfaceC4752)) {
                this.f8436.add(interfaceC4752);
            }
            if (this.f8438 == null) {
                ViewTreeObserver viewTreeObserver = this.f8435.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC2246 viewTreeObserverOnPreDrawListenerC2246 = new ViewTreeObserverOnPreDrawListenerC2246(this);
                this.f8438 = viewTreeObserverOnPreDrawListenerC2246;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC2246);
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int m8077(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f8437 && this.f8435.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f8435.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return m8073(this.f8435.getContext());
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int m8078() {
            int paddingTop = this.f8435.getPaddingTop() + this.f8435.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f8435.getLayoutParams();
            return m8077(this.f8435.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final int m8079() {
            int paddingLeft = this.f8435.getPaddingLeft() + this.f8435.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f8435.getLayoutParams();
            return m8077(this.f8435.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final boolean m8080(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean m8081(int i, int i2) {
            return m8080(i) && m8080(i2);
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final void m8082(int i, int i2) {
            Iterator it = new ArrayList(this.f8436).iterator();
            while (it.hasNext()) {
                ((InterfaceC4752) it.next()).mo5029(i, i2);
            }
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public void m8083(@NonNull InterfaceC4752 interfaceC4752) {
            this.f8436.remove(interfaceC4752);
        }
    }

    public q7(@NonNull T t) {
        this.f8429 = (T) C4513.m13867(t);
        this.f8430 = new C2245(t);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static void m8068(int i) {
        if (f8428 != null || f8427) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        f8428 = Integer.valueOf(i);
    }

    public String toString() {
        return "Target for: " + this.f8429;
    }

    @Override // defpackage.c1
    @CallSuper
    /* renamed from: Ϳ */
    public void mo175(@NonNull InterfaceC4752 interfaceC4752) {
        this.f8430.m8076(interfaceC4752);
    }

    @Override // defpackage.AbstractC5173, defpackage.c1
    /* renamed from: Ԩ */
    public void mo176(@Nullable InterfaceC3684 interfaceC3684) {
        m8072(interfaceC3684);
    }

    @Override // defpackage.c1
    @CallSuper
    /* renamed from: ԩ */
    public void mo177(@NonNull InterfaceC4752 interfaceC4752) {
        this.f8430.m8083(interfaceC4752);
    }

    @Override // defpackage.AbstractC5173, defpackage.c1
    @CallSuper
    /* renamed from: Ԭ */
    public void mo180(@Nullable Drawable drawable) {
        super.mo180(drawable);
        m8070();
    }

    @Override // defpackage.AbstractC5173, defpackage.c1
    @Nullable
    /* renamed from: ԭ */
    public InterfaceC3684 mo181() {
        Object objM8069 = m8069();
        if (objM8069 == null) {
            return null;
        }
        if (objM8069 instanceof InterfaceC3684) {
            return (InterfaceC3684) objM8069;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // defpackage.AbstractC5173, defpackage.c1
    @CallSuper
    /* renamed from: Ԯ */
    public void mo182(@Nullable Drawable drawable) {
        super.mo182(drawable);
        this.f8430.m8075();
        if (this.f8432) {
            return;
        }
        m8071();
    }

    @Nullable
    /* renamed from: ԯ, reason: contains not printable characters */
    public final Object m8069() {
        Integer num = f8428;
        return num == null ? this.f8429.getTag() : this.f8429.getTag(num.intValue());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m8070() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f8431;
        if (onAttachStateChangeListener == null || this.f8433) {
            return;
        }
        this.f8429.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f8433 = true;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m8071() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f8431;
        if (onAttachStateChangeListener == null || !this.f8433) {
            return;
        }
        this.f8429.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f8433 = false;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m8072(@Nullable Object obj) {
        Integer num = f8428;
        if (num != null) {
            this.f8429.setTag(num.intValue(), obj);
        } else {
            f8427 = true;
            this.f8429.setTag(obj);
        }
    }
}
