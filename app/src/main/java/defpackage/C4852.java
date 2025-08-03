package defpackage;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.blink.academy.film.FilmApp;

/* compiled from: SoundHelper.java */
/* renamed from: ළ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4852 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C4852 f16373;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public MediaPlayer f16374;

    /* compiled from: SoundHelper.java */
    /* renamed from: ළ$Ϳ, reason: contains not printable characters */
    public class C4853 implements MediaPlayer.OnCompletionListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4855 f16375;

        public C4853(InterfaceC4855 interfaceC4855) {
            this.f16375 = interfaceC4855;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            C4638.m14099("ccccccc", "onCompletion:");
            InterfaceC4855 interfaceC4855 = this.f16375;
            if (interfaceC4855 != null) {
                interfaceC4855.onFinish();
            }
        }
    }

    /* compiled from: SoundHelper.java */
    /* renamed from: ළ$Ԩ, reason: contains not printable characters */
    public class C4854 implements MediaPlayer.OnInfoListener {
        public C4854() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            C4638.m14099("ccccccc", "what:" + i);
            return false;
        }
    }

    /* compiled from: SoundHelper.java */
    /* renamed from: ළ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC4855 {
        void onFinish();
    }

    public C4852() {
        if (this.f16374 != null) {
            return;
        }
        this.f16374 = new MediaPlayer();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C4852 m14581() {
        if (f16373 == null) {
            synchronized (C4852.class) {
                if (f16373 == null) {
                    f16373 = new C4852();
                }
            }
        }
        return f16373;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m14582(Context context, String str, InterfaceC4855 interfaceC4855) {
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        try {
            try {
                try {
                    assetFileDescriptorOpenFd = context.getAssets().openFd(str);
                    this.f16374.reset();
                    boolean z = false;
                    this.f16374.setLooping(false);
                    this.f16374.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                    AudioManager audioManager = (AudioManager) FilmApp.m405().getSystemService("audio");
                    float f = 0.2f;
                    if (audioManager != null) {
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        int streamVolume = audioManager.getStreamVolume(3);
                        if (streamVolume > 0 && streamMaxVolume > 0) {
                            f = (streamVolume * 1.0f) / streamMaxVolume;
                            z = true;
                        }
                    }
                    if (!z) {
                        this.f16374.setAudioStreamType(4);
                    }
                    this.f16374.setOnCompletionListener(new C4853(interfaceC4855));
                    this.f16374.setOnInfoListener(new C4854());
                    this.f16374.prepare();
                    this.f16374.start();
                    this.f16374.setVolume(f, f);
                    assetFileDescriptorOpenFd.close();
                } catch (Throwable th) {
                    if (assetFileDescriptorOpenFd != null) {
                        try {
                            assetFileDescriptorOpenFd.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (assetFileDescriptorOpenFd != null) {
                    try {
                        assetFileDescriptorOpenFd.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (assetFileDescriptorOpenFd != null) {
                    assetFileDescriptorOpenFd.close();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
