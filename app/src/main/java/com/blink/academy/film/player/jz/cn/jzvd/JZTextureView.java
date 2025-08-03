package com.blink.academy.film.player.jz.cn.jzvd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* loaded from: classes.dex */
public class JZTextureView extends TextureView {
    public static final String TAG = "JZResizeTextureView";
    public int currentVideoHeight;
    public int currentVideoWidth;

    public JZTextureView(Context context) {
        super(context);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0141  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.player.jz.cn.jzvd.JZTextureView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }

    public void setVideoSize(int i, int i2) {
        if (this.currentVideoWidth == i && this.currentVideoHeight == i2) {
            return;
        }
        this.currentVideoWidth = i;
        this.currentVideoHeight = i2;
        requestLayout();
    }

    public JZTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }
}
