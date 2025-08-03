package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import defpackage.C2523;
import defpackage.C3921;
import defpackage.C4542;
import defpackage.C4709;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4590;
import defpackage.InterfaceC4947;
import defpackage.i4;
import java.util.Iterator;

/* compiled from: ViewGroup.kt */
/* loaded from: classes.dex */
public final class ViewGroupKt {

    /* compiled from: ViewGroup.kt */
    /* renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<View>, InterfaceC4947 {
        public final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        public AnonymousClass1(ViewGroup viewGroup) {
            this.$this_iterator = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            viewGroup.removeViewAt(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup viewGroup = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(ViewGroup viewGroup, View view) {
        C3921.m12666(viewGroup, "<this>");
        C3921.m12666(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, InterfaceC2392<? super View, i4> interfaceC2392) {
        C3921.m12666(viewGroup, "<this>");
        C3921.m12666(interfaceC2392, "action");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            C3921.m12665(childAt, "getChildAt(index)");
            interfaceC2392.invoke(childAt);
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, InterfaceC2849<? super Integer, ? super View, i4> interfaceC2849) {
        C3921.m12666(viewGroup, "<this>");
        C3921.m12666(interfaceC2849, "action");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Integer numValueOf = Integer.valueOf(i);
            View childAt = viewGroup.getChildAt(i);
            C3921.m12665(childAt, "getChildAt(index)");
            interfaceC2849.invoke(numValueOf, childAt);
        }
    }

    public static final View get(ViewGroup viewGroup, int i) {
        C3921.m12666(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + viewGroup.getChildCount());
    }

    public static final InterfaceC4590<View> getChildren(final ViewGroup viewGroup) {
        C3921.m12666(viewGroup, "<this>");
        return new InterfaceC4590<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // defpackage.InterfaceC4590
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final InterfaceC4590<View> getDescendants(ViewGroup viewGroup) {
        C3921.m12666(viewGroup, "<this>");
        return C4709.m14248(new ViewGroupKt$descendants$1(viewGroup, null));
    }

    public static final C2523 getIndices(ViewGroup viewGroup) {
        C3921.m12666(viewGroup, "<this>");
        return C4542.m13950(0, viewGroup.getChildCount());
    }

    public static final int getSize(ViewGroup viewGroup) {
        C3921.m12666(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        C3921.m12666(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        C3921.m12666(viewGroup, "<this>");
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        C3921.m12666(viewGroup, "<this>");
        return new AnonymousClass1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        C3921.m12666(viewGroup, "<this>");
        C3921.m12666(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        C3921.m12666(viewGroup, "<this>");
        C3921.m12666(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i) {
        C3921.m12666(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        C3921.m12666(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        C3921.m12666(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        C3921.m12666(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        C3921.m12666(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }
}
