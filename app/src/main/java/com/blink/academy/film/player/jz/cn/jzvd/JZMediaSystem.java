package com.blink.academy.film.player.jz.cn.jzvd;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.blink.academy.film.player.jz.cn.jzvd.JZMediaSystem;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes.dex */
public class JZMediaSystem extends JZMediaInterface implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    public MediaPlayer mediaPlayer;

    public JZMediaSystem(Jzvd jzvd) {
        super(jzvd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBufferingUpdate$8(int i) {
        this.jzvd.setBufferProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCompletion$7() {
        this.jzvd.onCompletion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$10(int i, int i2) {
        this.jzvd.onError(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInfo$11(int i, int i2) {
        this.jzvd.onInfo(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPrepared$6() {
        this.jzvd.onPrepared();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSeekComplete$9() {
        this.jzvd.onSeekComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoSizeChanged$12(int i, int i2) {
        this.jzvd.onVideoSizeChanged(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pause$2() throws IllegalStateException {
        this.mediaPlayer.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepare$0() throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setLooping(this.jzvd.jzDataSource.looping);
            this.mediaPlayer.setOnPreparedListener(this);
            this.mediaPlayer.setOnCompletionListener(this);
            this.mediaPlayer.setOnBufferingUpdateListener(this);
            this.mediaPlayer.setScreenOnWhilePlaying(true);
            this.mediaPlayer.setOnSeekCompleteListener(this);
            this.mediaPlayer.setOnErrorListener(this);
            this.mediaPlayer.setOnInfoListener(this);
            this.mediaPlayer.setOnVideoSizeChangedListener(this);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.mediaPlayer, this.jzvd.jzDataSource.getCurrentUrl().toString(), this.jzvd.jzDataSource.headerMap);
            float f = this.jzvd.jzDataSource.mSpeed;
            if (f != 0.0f) {
                MediaPlayer mediaPlayer2 = this.mediaPlayer;
                mediaPlayer2.setPlaybackParams(mediaPlayer2.getPlaybackParams().setSpeed(f));
            }
            this.mediaPlayer.prepareAsync();
            this.mediaPlayer.setSurface(new Surface(JZMediaInterface.SAVED_SURFACE));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$release$4(MediaPlayer mediaPlayer, HandlerThread handlerThread) {
        mediaPlayer.setSurface(null);
        mediaPlayer.release();
        handlerThread.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seekTo$3(long j) throws IllegalStateException {
        try {
            this.mediaPlayer.seekTo((int) j);
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVolume$5(float f, float f2) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$1() throws IllegalStateException {
        this.mediaPlayer.start();
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public long getCurrentPosition() {
        if (this.mediaPlayer != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public long getDuration() {
        if (this.mediaPlayer != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i) {
        this.handler.post(new Runnable() { // from class: പ
            @Override // java.lang.Runnable
            public final void run() {
                this.f15990.lambda$onBufferingUpdate$8(i);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: थ
            @Override // java.lang.Runnable
            public final void run() {
                this.f14200.lambda$onCompletion$7();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
        this.handler.post(new Runnable() { // from class: ʄ
            @Override // java.lang.Runnable
            public final void run() {
                this.f9850.lambda$onError$10(i, i2);
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, final int i, final int i2) {
        this.handler.post(new Runnable() { // from class: ॾ
            @Override // java.lang.Runnable
            public final void run() {
                this.f14313.lambda$onInfo$11(i, i2);
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: ࡖ
            @Override // java.lang.Runnable
            public final void run() {
                this.f13650.lambda$onPrepared$6();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: ڻ
            @Override // java.lang.Runnable
            public final void run() {
                this.f12553.lambda$onSeekComplete$9();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = JZMediaInterface.SAVED_SURFACE;
        if (surfaceTexture2 != null) {
            this.jzvd.textureView.setSurfaceTexture(surfaceTexture2);
        } else {
            JZMediaInterface.SAVED_SURFACE = surfaceTexture;
            prepare();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i, final int i2) {
        this.handler.post(new Runnable() { // from class: ƻ
            @Override // java.lang.Runnable
            public final void run() {
                this.f9165.lambda$onVideoSizeChanged$12(i, i2);
            }
        });
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public void pause() {
        this.mMediaHandler.post(new Runnable() { // from class: శ
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f15599.lambda$pause$2();
            }
        });
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public void prepare() {
        release();
        HandlerThread handlerThread = new HandlerThread("JZVD");
        this.mMediaHandlerThread = handlerThread;
        handlerThread.start();
        this.mMediaHandler = new Handler(this.mMediaHandlerThread.getLooper());
        this.handler = new Handler();
        this.mMediaHandler.post(new Runnable() { // from class: ݩ
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f12971.lambda$prepare$0();
            }
        });
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public void release() {
        final HandlerThread handlerThread;
        final MediaPlayer mediaPlayer;
        Handler handler = this.mMediaHandler;
        if (handler == null || (handlerThread = this.mMediaHandlerThread) == null || (mediaPlayer = this.mediaPlayer) == null) {
            return;
        }
        JZMediaInterface.SAVED_SURFACE = null;
        handler.post(new Runnable() { // from class: ઢ
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.lambda$release$4(mediaPlayer, handlerThread);
            }
        });
        this.mediaPlayer = null;
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public void seekTo(final long j) {
        this.mMediaHandler.post(new Runnable() { // from class: ঘ
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f14427.lambda$seekTo$3(j);
            }
        });
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public void setSpeed(float f) {
        PlaybackParams playbackParams = this.mediaPlayer.getPlaybackParams();
        playbackParams.setSpeed(f);
        this.mediaPlayer.setPlaybackParams(playbackParams);
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public void setSurface(Surface surface) {
        this.mediaPlayer.setSurface(surface);
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public void setVolume(final float f, final float f2) {
        Handler handler = this.mMediaHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: ݯ
            @Override // java.lang.Runnable
            public final void run() {
                this.f12987.lambda$setVolume$5(f, f2);
            }
        });
    }

    @Override // com.blink.academy.film.player.jz.cn.jzvd.JZMediaInterface
    public void start() {
        this.mMediaHandler.post(new Runnable() { // from class: צ
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f11751.lambda$start$1();
            }
        });
    }
}
