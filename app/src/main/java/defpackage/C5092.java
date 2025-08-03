package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

/* compiled from: RecordPagerAdapter.java */
/* renamed from: ဆ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5092 extends PagerAdapter {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<View> f16912;

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<View> list = this.f16912;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        if (this.f16912.contains(obj)) {
            return this.f16912.indexOf(obj);
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        viewGroup.addView(this.f16912.get(i));
        return this.f16912.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m14921(List<View> list) {
        this.f16912 = list;
    }
}
