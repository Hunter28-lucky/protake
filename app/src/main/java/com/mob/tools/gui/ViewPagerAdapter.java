package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public abstract class ViewPagerAdapter {
    private MobViewPager parent;

    public abstract int getCount();

    public abstract View getView(int i, View view, ViewGroup viewGroup);

    public void invalidate() {
        MobViewPager mobViewPager = this.parent;
        if (mobViewPager != null) {
            mobViewPager.setAdapter(this);
        }
    }

    public void onScreenChange(int i, int i2) {
    }

    public void onScreenChanging(float f) {
    }

    public final void setMobViewPager(MobViewPager mobViewPager) {
        this.parent = mobViewPager;
    }
}
