package defpackage;

import android.graphics.Typeface;
import android.view.View;
import com.blink.academy.film.widgets.wheel.view.WheelView;
import com.blink.academy.protake.R;
import java.util.List;

/* compiled from: WheelOptions.java */
/* loaded from: classes.dex */
public class b8<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public View f115;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public WheelView f116;

    /* renamed from: ԩ, reason: contains not printable characters */
    public WheelView f117;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public WheelView f118;

    /* renamed from: ԫ, reason: contains not printable characters */
    public List<T> f119;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public List<List<T>> f120;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<List<List<T>>> f121;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f122 = true;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f123;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC3488 f124;

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC3488 f125;

    /* renamed from: ֏, reason: contains not printable characters */
    public InterfaceC3632 f126;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f127;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f128;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f129;

    /* renamed from: ށ, reason: contains not printable characters */
    public WheelView.DividerType f130;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f131;

    /* compiled from: WheelOptions.java */
    /* renamed from: b8$Ϳ, reason: contains not printable characters */
    public class C0046 implements InterfaceC3488 {
        public C0046() {
        }

        @Override // defpackage.InterfaceC3488
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo158(int i) {
            int currentItem;
            if (b8.this.f120 == null) {
                if (b8.this.f126 != null) {
                    b8.this.f126.mo3975(b8.this.f116.getCurrentItem(), 0, 0);
                    return;
                }
                return;
            }
            if (b8.this.f123) {
                currentItem = 0;
            } else {
                currentItem = b8.this.f117.getCurrentItem();
                if (currentItem >= ((List) b8.this.f120.get(i)).size() - 1) {
                    currentItem = ((List) b8.this.f120.get(i)).size() - 1;
                }
            }
            b8.this.f117.setAdapter(new C4952((List) b8.this.f120.get(i)));
            b8.this.f117.setCurrentItem(currentItem);
            if (b8.this.f121 != null) {
                b8.this.f125.mo158(currentItem);
            } else if (b8.this.f126 != null) {
                b8.this.f126.mo3975(i, currentItem, 0);
            }
        }
    }

    /* compiled from: WheelOptions.java */
    /* renamed from: b8$Ԩ, reason: contains not printable characters */
    public class C0047 implements InterfaceC3488 {
        public C0047() {
        }

        @Override // defpackage.InterfaceC3488
        /* renamed from: Ϳ */
        public void mo158(int i) {
            int size = 0;
            if (b8.this.f121 == null) {
                if (b8.this.f126 != null) {
                    b8.this.f126.mo3975(b8.this.f116.getCurrentItem(), i, 0);
                    return;
                }
                return;
            }
            int currentItem = b8.this.f116.getCurrentItem();
            if (currentItem >= b8.this.f121.size() - 1) {
                currentItem = b8.this.f121.size() - 1;
            }
            if (i >= ((List) b8.this.f120.get(currentItem)).size() - 1) {
                i = ((List) b8.this.f120.get(currentItem)).size() - 1;
            }
            if (!b8.this.f123) {
                size = b8.this.f118.getCurrentItem() >= ((List) ((List) b8.this.f121.get(currentItem)).get(i)).size() + (-1) ? ((List) ((List) b8.this.f121.get(currentItem)).get(i)).size() - 1 : b8.this.f118.getCurrentItem();
            }
            b8.this.f118.setAdapter(new C4952((List) ((List) b8.this.f121.get(b8.this.f116.getCurrentItem())).get(i)));
            b8.this.f118.setCurrentItem(size);
            if (b8.this.f126 != null) {
                b8.this.f126.mo3975(b8.this.f116.getCurrentItem(), i, size);
            }
        }
    }

    /* compiled from: WheelOptions.java */
    /* renamed from: b8$Ԫ, reason: contains not printable characters */
    public class C0048 implements InterfaceC3488 {
        public C0048() {
        }

        @Override // defpackage.InterfaceC3488
        /* renamed from: Ϳ */
        public void mo158(int i) {
            b8.this.f126.mo3975(b8.this.f116.getCurrentItem(), b8.this.f117.getCurrentItem(), i);
        }
    }

    public b8(View view, boolean z) {
        this.f123 = z;
        this.f115 = view;
        this.f116 = (WheelView) view.findViewById(R.id.options1);
        this.f117 = (WheelView) view.findViewById(R.id.options2);
        this.f118 = (WheelView) view.findViewById(R.id.options3);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int[] m137() {
        int[] iArr = new int[3];
        iArr[0] = this.f116.getCurrentItem();
        List<List<T>> list = this.f120;
        if (list == null || list.size() <= 0) {
            iArr[1] = this.f117.getCurrentItem();
        } else {
            iArr[1] = this.f117.getCurrentItem() > this.f120.get(iArr[0]).size() - 1 ? 0 : this.f117.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f121;
        if (list2 == null || list2.size() <= 0) {
            iArr[2] = this.f118.getCurrentItem();
        } else {
            iArr[2] = this.f118.getCurrentItem() <= this.f121.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f118.getCurrentItem() : 0;
        }
        return iArr;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m138(boolean z) {
        this.f116.m4720(z);
        this.f117.m4720(z);
        this.f118.m4720(z);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m139(int i, int i2, int i3) {
        if (this.f119 != null) {
            this.f116.setCurrentItem(i);
        }
        List<List<T>> list = this.f120;
        if (list != null) {
            this.f117.setAdapter(new C4952(list.get(i)));
            this.f117.setCurrentItem(i2);
        }
        List<List<List<T>>> list2 = this.f121;
        if (list2 != null) {
            this.f118.setAdapter(new C4952(list2.get(i).get(i2)));
            this.f118.setCurrentItem(i3);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m140(int i, int i2, int i3) {
        if (this.f122) {
            m139(i, i2, i3);
            return;
        }
        this.f116.setCurrentItem(i);
        this.f117.setCurrentItem(i2);
        this.f118.setCurrentItem(i3);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m141(boolean z, boolean z2, boolean z3) {
        this.f116.setCyclic(z);
        this.f117.setCyclic(z2);
        this.f118.setCyclic(z3);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m142() {
        this.f116.setDividerColor(this.f129);
        this.f117.setDividerColor(this.f129);
        this.f118.setDividerColor(this.f129);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m143(int i) {
        this.f129 = i;
        m142();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m144() {
        this.f116.setDividerType(this.f130);
        this.f117.setDividerType(this.f130);
        this.f118.setDividerType(this.f130);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m145(WheelView.DividerType dividerType) {
        this.f130 = dividerType;
        m144();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m146(String str, String str2, String str3) {
        if (str != null) {
            this.f116.setLabel(str);
        }
        if (str2 != null) {
            this.f117.setLabel(str2);
        }
        if (str3 != null) {
            this.f118.setLabel(str3);
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m147() {
        this.f116.setLineSpacingMultiplier(this.f131);
        this.f117.setLineSpacingMultiplier(this.f131);
        this.f118.setLineSpacingMultiplier(this.f131);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m148(float f) {
        this.f131 = f;
        m147();
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m149(InterfaceC3632 interfaceC3632) {
        this.f126 = interfaceC3632;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m150(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f119 = list;
        this.f120 = list2;
        this.f121 = list3;
        this.f116.setAdapter(new C4952(list));
        this.f116.setCurrentItem(0);
        List<List<T>> list4 = this.f120;
        if (list4 != null) {
            this.f117.setAdapter(new C4952(list4.get(0)));
        }
        WheelView wheelView = this.f117;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        List<List<List<T>>> list5 = this.f121;
        if (list5 != null) {
            this.f118.setAdapter(new C4952(list5.get(0).get(0)));
        }
        WheelView wheelView2 = this.f118;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f116.setIsOptions(true);
        this.f117.setIsOptions(true);
        this.f118.setIsOptions(true);
        if (this.f120 == null) {
            this.f117.setVisibility(8);
        } else {
            this.f117.setVisibility(0);
        }
        if (this.f121 == null) {
            this.f118.setVisibility(8);
        } else {
            this.f118.setVisibility(0);
        }
        this.f124 = new C0046();
        this.f125 = new C0047();
        if (list != null && this.f122) {
            this.f116.setOnItemSelectedListener(this.f124);
        }
        if (list2 != null && this.f122) {
            this.f117.setOnItemSelectedListener(this.f125);
        }
        if (list3 == null || !this.f122 || this.f126 == null) {
            return;
        }
        this.f118.setOnItemSelectedListener(new C0048());
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m151() {
        this.f116.setTextColorCenter(this.f128);
        this.f117.setTextColorCenter(this.f128);
        this.f118.setTextColorCenter(this.f128);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m152(int i) {
        this.f128 = i;
        m151();
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m153() {
        this.f116.setTextColorOut(this.f127);
        this.f117.setTextColorOut(this.f127);
        this.f118.setTextColorOut(this.f127);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m154(int i) {
        this.f127 = i;
        m153();
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m155(int i) {
        float f = i;
        this.f116.setTextSize(f);
        this.f117.setTextSize(f);
        this.f118.setTextSize(f);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m156(int i, int i2, int i3) {
        this.f116.setTextXOffset(i);
        this.f117.setTextXOffset(i2);
        this.f118.setTextXOffset(i3);
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m157(Typeface typeface) {
        this.f116.setTypeface(typeface);
        this.f117.setTypeface(typeface);
        this.f118.setTypeface(typeface);
    }
}
