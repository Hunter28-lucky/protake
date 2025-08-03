package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.blink.academy.film.setting.pager.PresetPagerItem;
import java.util.List;

/* compiled from: PresetPagerAdapter.java */
/* renamed from: ѩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2938 extends PagerAdapter {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<PresetPagerItem> f10652;

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<PresetPagerItem> list = this.f10652;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        if (this.f10652.contains(obj)) {
            return this.f10652.indexOf(obj);
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        viewGroup.addView(this.f10652.get(i));
        return this.f10652.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m10336(List<PresetPagerItem> list) {
        this.f10652 = list;
    }
}
