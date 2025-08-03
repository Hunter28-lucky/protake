package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4590;
import defpackage.InterfaceC4947;
import defpackage.i4;
import java.util.Iterator;

/* compiled from: Menu.kt */
/* loaded from: classes.dex */
public final class MenuKt {

    /* compiled from: Menu.kt */
    /* renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<MenuItem>, InterfaceC4947 {
        public final /* synthetic */ Menu $this_iterator;
        private int index;

        public AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu menu = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            menu.removeItem(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            MenuItem item = menu.getItem(i);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(Menu menu, MenuItem menuItem) {
        C3921.m12666(menu, "<this>");
        C3921.m12666(menuItem, "item");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (C3921.m12662(menu.getItem(i), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, InterfaceC2392<? super MenuItem, i4> interfaceC2392) {
        C3921.m12666(menu, "<this>");
        C3921.m12666(interfaceC2392, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            C3921.m12665(item, "getItem(index)");
            interfaceC2392.invoke(item);
        }
    }

    public static final void forEachIndexed(Menu menu, InterfaceC2849<? super Integer, ? super MenuItem, i4> interfaceC2849) {
        C3921.m12666(menu, "<this>");
        C3921.m12666(interfaceC2849, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            Integer numValueOf = Integer.valueOf(i);
            MenuItem item = menu.getItem(i);
            C3921.m12665(item, "getItem(index)");
            interfaceC2849.invoke(numValueOf, item);
        }
    }

    public static final MenuItem get(Menu menu, int i) {
        C3921.m12666(menu, "<this>");
        MenuItem item = menu.getItem(i);
        C3921.m12665(item, "getItem(index)");
        return item;
    }

    public static final InterfaceC4590<MenuItem> getChildren(final Menu menu) {
        C3921.m12666(menu, "<this>");
        return new InterfaceC4590<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // defpackage.InterfaceC4590
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(Menu menu) {
        C3921.m12666(menu, "<this>");
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        C3921.m12666(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        C3921.m12666(menu, "<this>");
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        C3921.m12666(menu, "<this>");
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        C3921.m12666(menu, "<this>");
        C3921.m12666(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}
