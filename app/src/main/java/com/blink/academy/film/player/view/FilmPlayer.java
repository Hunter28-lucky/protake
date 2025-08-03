package com.blink.academy.film.player.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.blink.academy.film.player.jz.cn.jzvd.JZDataSource;
import com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface;
import com.blink.academy.film.player.jz.cn.jzvd.JZMediaSystem;
import com.blink.academy.film.player.jz.cn.jzvd.JZUtils;
import com.blink.academy.film.player.jz.cn.jzvd.Jzvd;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes.dex */
public class FilmPlayer extends JzvdStdFilm {

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f1184;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC0566 f1185;

    /* renamed from: com.blink.academy.film.player.view.FilmPlayer$Ϳ, reason: contains not printable characters */
    public interface InterfaceC0566 {
        void onFinish();

        /* renamed from: Ϳ */
        boolean mo1562();

        /* renamed from: Ԩ */
        void mo1563(int i, String str);
    }

    public FilmPlayer(Context context) {
        this(context, null);
    }

    private JZMediaSystem getJZMediaSystem() {
        JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            try {
                return (JZMediaSystem) jZMediaInterface;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JzvdStd, com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onCompletion() {
        Runtime.getRuntime().gc();
        cancelProgressTimer();
        dismissBrightnessDialog();
        dismissProgressDialog();
        dismissVolumeDialog();
        onStateAutoComplete();
        JZUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        JZUtils.saveProgress(getContext(), this.jzDataSource.getCurrentUrl(), 0L);
        cancelDismissControlViewTimer();
        this.posterImageView.setVisibility(8);
        if (!this.f1184) {
            InterfaceC0566 interfaceC0566 = this.f1185;
            if (interfaceC0566 != null) {
                interfaceC0566.onFinish();
                return;
            }
            return;
        }
        InterfaceC0566 interfaceC05662 = this.f1185;
        if (interfaceC05662 == null || !interfaceC05662.mo1562()) {
            return;
        }
        startVideo();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onPrepared() {
        super.onPrepared();
        if (this.preloading) {
            m1595(0);
        }
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JzvdStd, com.blink.academy.film.player.jz.cn.jzvd.Jzvd
    public void onProgress(int i, long j, long j2) {
        super.onProgress(i, j, j2);
        InterfaceC0566 interfaceC0566 = this.f1185;
        if (interfaceC0566 != null) {
            interfaceC0566.mo1563(i, m1596(j));
        }
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        super.onProgressChanged(seekBar, i, z);
    }

    public void setOnProChange(InterfaceC0566 interfaceC0566) {
        this.f1185 = interfaceC0566;
    }

    public void setRepeat(boolean z) {
        this.f1184 = z;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m1591(float f) {
        JZDataSource jZDataSource = this.jzDataSource;
        if (jZDataSource != null) {
            jZDataSource.mSpeed = f;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m1592(float f) {
        JZMediaSystem jZMediaSystem = getJZMediaSystem();
        if (jZMediaSystem == null || jZMediaSystem.mediaPlayer == null) {
            return;
        }
        jZMediaSystem.setSpeed(f);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m1593() {
        JZMediaSystem jZMediaSystem = getJZMediaSystem();
        if (jZMediaSystem == null || jZMediaSystem.mediaPlayer == null) {
            return false;
        }
        return this.mediaInterface.isPlaying();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean m1594() {
        JZMediaInterface jZMediaInterface = this.mediaInterface;
        return (jZMediaInterface == null || !(jZMediaInterface instanceof JZMediaSystem) || ((JZMediaSystem) jZMediaInterface).mediaPlayer == null) ? false : true;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m1595(int i) {
        JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface == null || jZMediaInterface.mMediaHandler == null) {
            return;
        }
        long duration = (i * getDuration()) / 100;
        this.seekToManulPosition = i;
        this.mediaInterface.seekTo(duration);
        int i2 = this.state;
        if (i2 != 6 && i2 != 5) {
            this.seekToInAdvance = duration;
        }
        this.bottomProgressBar.setProgress(i);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public String m1596(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00:00";
        }
        long j2 = j / 1000;
        return new Formatter(new StringBuilder(), Locale.getDefault()).format("%02d:%02d:%02d", Integer.valueOf((int) (j2 / 3600)), Integer.valueOf((int) ((j2 / 60) % 60)), Integer.valueOf((int) (j2 % 60))).toString();
    }

    public FilmPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Jzvd.SAVE_PROGRESS = false;
        Jzvd.WIFI_TIP_DIALOG_SHOWED = true;
        this.bottomContainer.setAlpha(0.0f);
        this.bottomProgressBar.setAlpha(0.0f);
        this.replayTextView.setAlpha(0.0f);
        this.startButton.setAlpha(0.0f);
        this.progressBar.setAlpha(0.0f);
        this.loadingProgressBar.setAlpha(0.0f);
        this.topContainer.setAlpha(0.0f);
    }
}
