package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import defpackage.C3921;
import defpackage.C4709;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4590;
import defpackage.i4;
import kotlin.sequences.SequencesKt__SequencesKt;

/* compiled from: View.kt */
/* loaded from: classes.dex */
public final class ViewKt {
    public static final void doOnAttach(final View view, final InterfaceC2392<? super View, i4> interfaceC2392) {
        C3921.m12666(view, "<this>");
        C3921.m12666(interfaceC2392, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            interfaceC2392.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt.doOnAttach.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    C3921.m12666(view2, "view");
                    view.removeOnAttachStateChangeListener(this);
                    interfaceC2392.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    C3921.m12666(view2, "view");
                }
            });
        }
    }

    public static final void doOnDetach(final View view, final InterfaceC2392<? super View, i4> interfaceC2392) {
        C3921.m12666(view, "<this>");
        C3921.m12666(interfaceC2392, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt.doOnDetach.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    C3921.m12666(view2, "view");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    C3921.m12666(view2, "view");
                    view.removeOnAttachStateChangeListener(this);
                    interfaceC2392.invoke(view2);
                }
            });
        } else {
            interfaceC2392.invoke(view);
        }
    }

    public static final void doOnLayout(View view, final InterfaceC2392<? super View, i4> interfaceC2392) {
        C3921.m12666(view, "<this>");
        C3921.m12666(interfaceC2392, "action");
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    C3921.m12666(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    interfaceC2392.invoke(view2);
                }
            });
        } else {
            interfaceC2392.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, final InterfaceC2392<? super View, i4> interfaceC2392) {
        C3921.m12666(view, "<this>");
        C3921.m12666(interfaceC2392, "action");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt.doOnNextLayout.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                C3921.m12666(view2, "view");
                view2.removeOnLayoutChangeListener(this);
                interfaceC2392.invoke(view2);
            }
        });
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View view, final InterfaceC2392<? super View, i4> interfaceC2392) {
        C3921.m12666(view, "<this>");
        C3921.m12666(interfaceC2392, "action");
        OneShotPreDrawListener oneShotPreDrawListenerAdd = OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.ViewKt.doOnPreDraw.1
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC2392.invoke(view);
            }
        });
        C3921.m12665(oneShotPreDrawListenerAdd, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return oneShotPreDrawListenerAdd;
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        C3921.m12666(view, "<this>");
        C3921.m12666(config, "config");
        if (!ViewCompat.isLaidOut(view)) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        C3921.m12665(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final InterfaceC4590<View> getAllViews(View view) {
        C3921.m12666(view, "<this>");
        return C4709.m14248(new ViewKt$allViews$1(view, null));
    }

    public static final InterfaceC4590<ViewParent> getAncestors(View view) {
        C3921.m12666(view, "<this>");
        return SequencesKt__SequencesKt.m7262(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View view) {
        C3921.m12666(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(View view) {
        C3921.m12666(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        C3921.m12666(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View view) {
        C3921.m12666(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View view) {
        C3921.m12666(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        C3921.m12666(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(View view) {
        C3921.m12666(view, "<this>");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view) {
        C3921.m12666(view, "<this>");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(View view) {
        C3921.m12666(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final Runnable postDelayed(View view, long j, final InterfaceC4090<i4> interfaceC4090) {
        C3921.m12666(view, "<this>");
        C3921.m12666(interfaceC4090, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC4090.invoke();
            }
        };
        view.postDelayed(runnable, j);
        return runnable;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View view, long j, final InterfaceC4090<i4> interfaceC4090) {
        C3921.m12666(view, "<this>");
        C3921.m12666(interfaceC4090, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC4090.invoke();
            }
        };
        view.postOnAnimationDelayed(runnable, j);
        return runnable;
    }

    public static final void setGone(View view, boolean z) {
        C3921.m12666(view, "<this>");
        view.setVisibility(z ? 8 : 0);
    }

    public static final void setInvisible(View view, boolean z) {
        C3921.m12666(view, "<this>");
        view.setVisibility(z ? 4 : 0);
    }

    public static final void setPadding(View view, @Px int i) {
        C3921.m12666(view, "<this>");
        view.setPadding(i, i, i, i);
    }

    public static final void setVisible(View view, boolean z) {
        C3921.m12666(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }

    public static final void updateLayoutParams(View view, InterfaceC2392<? super ViewGroup.LayoutParams, i4> interfaceC2392) {
        C3921.m12666(view, "<this>");
        C3921.m12666(interfaceC2392, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        interfaceC2392.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, InterfaceC2392<? super T, i4> interfaceC2392) {
        C3921.m12666(view, "<this>");
        C3921.m12666(interfaceC2392, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        C3921.m12670(1, ExifInterface.GPS_DIRECTION_TRUE);
        interfaceC2392.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        C3921.m12666(view, "<this>");
        view.setPadding(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        C3921.m12666(view, "<this>");
        view.setPadding(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        C3921.m12666(view, "<this>");
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        C3921.m12666(view, "<this>");
        view.setPaddingRelative(i, i2, i3, i4);
    }
}
