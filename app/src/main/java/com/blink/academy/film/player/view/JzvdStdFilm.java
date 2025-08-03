package com.blink.academy.film.player.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import com.blink.academy.film.player.jz.cn.jzvd.JZDataSource;
import com.blink.academy.film.player.jz.cn.jzvd.JZTextureView;
import com.blink.academy.film.player.jz.cn.jzvd.Jzvd;
import com.blink.academy.film.player.jz.cn.jzvd.JzvdStd;
import com.blink.academy.film.player.view.PlayerTextureView;
import defpackage.C5052;

/* loaded from: classes.dex */
public class JzvdStdFilm extends JzvdStd {

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f1197;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f1198;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1199;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public PlayerTextureView.InterfaceC0592 f1200;

    /* renamed from: com.blink.academy.film.player.view.JzvdStdFilm$Ϳ, reason: contains not printable characters */
    public class C0574 implements PlayerTextureView.InterfaceC0592 {

        /* renamed from: com.blink.academy.film.player.view.JzvdStdFilm$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC0575 implements Runnable {
            public RunnableC0575() {
            }

            @Override // java.lang.Runnable
            public void run() {
                JzvdStdFilm.this.onStatePlaying();
            }
        }

        public C0574() {
        }

        @Override // com.blink.academy.film.player.view.PlayerTextureView.InterfaceC0592
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1613() {
            JzvdStdFilm.this.postDelayed(new RunnableC0575(), 0L);
        }
    }

    public JzvdStdFilm(Context context) {
        super(context);
        this.f1197 = true;
        this.f1200 = new C0574();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void addTextureView() {
        if (!this.f1197) {
            super.addTextureView();
            return;
        }
        JZTextureView jZTextureView = this.textureView;
        if (jZTextureView != null) {
            this.textureViewContainer.removeView(jZTextureView);
        }
        PlayerTextureView playerTextureView = new PlayerTextureView(getContext().getApplicationContext());
        this.textureView = playerTextureView;
        playerTextureView.m1644(this.mediaInterface);
        ((PlayerTextureView) this.textureView).m1646(this.f1198, this.f1199);
        ((PlayerTextureView) this.textureView).m1643(this.f1200);
        this.textureViewContainer.addView(this.textureView, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onInfo(int i, int i2) {
        if (!this.f1197) {
            super.onInfo(i, i2);
            return;
        }
        Log.d("JZVD", "onInfo what - " + i + " extra - " + i2);
        if (i == 3) {
            Log.d("JZVD", "MEDIA_INFO_VIDEO_RENDERING_START");
            return;
        }
        if (i == 701) {
            Log.d("JZVD", "MEDIA_INFO_BUFFERING_START");
            Jzvd.backUpBufferState = this.state;
            setState(3);
        } else if (i == 702) {
            Log.d("JZVD", "MEDIA_INFO_BUFFERING_END");
            int i3 = Jzvd.backUpBufferState;
            if (i3 != -1) {
                setState(i3);
                Jzvd.backUpBufferState = -1;
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m1609() throws InterruptedException {
        JZTextureView jZTextureView;
        if (this.f1197 && (jZTextureView = this.textureView) != null) {
            ((PlayerTextureView) jZTextureView).m1637();
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m1610() {
        JZTextureView jZTextureView;
        if (this.f1197 && (jZTextureView = this.textureView) != null) {
            ((PlayerTextureView) jZTextureView).m1638();
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public JzvdStdFilm m1611(boolean z) {
        return this;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m1612(String str, String str2, int i, int i2, float f) {
        this.f1198 = i;
        this.f1199 = i2;
        if (i == 0 || i2 == 0) {
            C5052 c5052M14866 = C5052.m14866(str);
            int iM14868 = c5052M14866.m14868();
            int iM14867 = c5052M14866.m14867();
            this.f1198 = iM14868;
            this.f1199 = iM14867;
        }
        setUp(new JZDataSource(str, str2, f), 0);
    }

    public JzvdStdFilm(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1197 = true;
        this.f1200 = new C0574();
    }
}
