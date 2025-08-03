package defpackage;

import org.jcodec.containers.dpx.DPXReader;

/* compiled from: TargetCameraConfig.java */
/* loaded from: classes.dex */
public class d1 extends C3843 {

    /* renamed from: ތ, reason: contains not printable characters */
    public C3255 f6532 = new C3255(16.0f, 9.0f);

    /* renamed from: ލ, reason: contains not printable characters */
    public int f6533 = DPXReader.TVINFO_OFFSET;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f6534 = 1080;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f6535 = 0;

    /* renamed from: ސ, reason: contains not printable characters */
    public String f6536 = "video/avc";

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f6537 = 0;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f6538 = 48000;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f6539 = 320000;

    /* renamed from: ޔ, reason: contains not printable characters */
    public float f6540 = 1.0f;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f6541 = 0;

    @Override // defpackage.C3843
    public String toString() {
        return "TargetCameraConfig{, mCropRatio=" + this.f6532 + ", mCroppedVideoWidth=" + this.f6533 + ", mCroppedVideoHeight=" + this.f6534 + ", targetTimeLapseTimeMs=" + this.f6535 + ", mVideoCodecMimeType='" + this.f6536 + "', mVideoBitrateLevel=" + this.f6537 + ", mAudioSampleRate=" + this.f6538 + ", mAudioBitRate=" + this.f6539 + ", mAudioLevel=" + this.f6540 + ", mAudioSource=" + this.f6541 + "} " + super.toString();
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public int m5896() {
        return this.f6539;
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public float m5897() {
        return this.f6540;
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public int m5898() {
        return this.f6538;
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public int m5899() {
        return this.f6541;
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public int m5900() {
        return this.f6534;
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public int m5901() {
        return this.f6533;
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public int m5902() {
        return this.f6535;
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public int m5903() {
        return this.f6537;
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public String m5904() {
        return this.f6536;
    }

    /* renamed from: ࡤ, reason: contains not printable characters */
    public d1 m5905(float f) {
        this.f6540 = f;
        return this;
    }

    /* renamed from: ࡥ, reason: contains not printable characters */
    public d1 m5906(int i) {
        this.f6538 = i;
        return this;
    }

    /* renamed from: ࡦ, reason: contains not printable characters */
    public d1 m5907(int i) {
        this.f6541 = i;
        return this;
    }

    /* renamed from: ࡧ, reason: contains not printable characters */
    public d1 m5908(C3255 c3255) {
        this.f6532 = c3255;
        return this;
    }

    /* renamed from: ࡨ, reason: contains not printable characters */
    public d1 m5909(int i) {
        this.f6534 = i;
        return this;
    }

    /* renamed from: ࡩ, reason: contains not printable characters */
    public d1 m5910(int i) {
        this.f6533 = i;
        return this;
    }

    /* renamed from: ࡪ, reason: contains not printable characters */
    public d1 m5911(int i) {
        this.f6535 = i;
        return this;
    }

    /* renamed from: ࢠ, reason: contains not printable characters */
    public d1 m5912(int i) {
        this.f6537 = i;
        return this;
    }

    /* renamed from: ࢡ, reason: contains not printable characters */
    public d1 m5913(String str) {
        this.f6536 = str;
        return this;
    }
}
