package defpackage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* compiled from: FilmLittlePreviewFilter.java */
/* renamed from: ढ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4077 extends AbstractC3724 {

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f14173;

    /* renamed from: މ, reason: contains not printable characters */
    public C4974 f14174;

    /* renamed from: ފ, reason: contains not printable characters */
    public u7 f14175;

    /* renamed from: ދ, reason: contains not printable characters */
    public v7 f14176;

    /* renamed from: ތ, reason: contains not printable characters */
    public C2581 f14177;

    /* renamed from: ލ, reason: contains not printable characters */
    public C4327 f14178;

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean f14179;

    /* renamed from: ޏ, reason: contains not printable characters */
    public FloatBuffer f14180;

    /* renamed from: ސ, reason: contains not printable characters */
    public FloatBuffer f14181;

    /* renamed from: ޑ, reason: contains not printable characters */
    public C2390 f14182;

    /* renamed from: ޒ, reason: contains not printable characters */
    public C2390 f14183;

    /* renamed from: ޓ, reason: contains not printable characters */
    public float f14184;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f14185;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f14186;

    /* renamed from: ޖ, reason: contains not printable characters */
    public int f14187;

    /* renamed from: ޗ, reason: contains not printable characters */
    public int f14188;

    /* renamed from: ޘ, reason: contains not printable characters */
    public int f14189;

    /* renamed from: ޙ, reason: contains not printable characters */
    public int f14190;

    /* renamed from: ޚ, reason: contains not printable characters */
    public int f14191;

    /* renamed from: ޛ, reason: contains not printable characters */
    public float[] f14192;

    public C4077(int i, int i2, boolean z, int i3, int i4) {
        super(i, i2);
        this.f14173 = false;
        this.f14184 = 0.0f;
        this.f14185 = 0;
        this.f14186 = 500;
        this.f14187 = 500;
        this.f14188 = 640;
        this.f14189 = 256;
        this.f14190 = 500;
        this.f14191 = 256;
        this.f14192 = new float[16];
        this.f14179 = z;
        this.f14178 = new C4327();
        if (z) {
            C2581 c2581 = new C2581();
            this.f14177 = c2581;
            this.f12894.m11636(c2581);
            this.f14186 = 320;
            this.f14187 = MPEGConst.SEQUENCE_ERROR_CODE;
            this.f14190 = 320;
            this.f14191 = MPEGConst.SEQUENCE_ERROR_CODE;
        } else {
            this.f14175 = new u7(640);
            v7 v7Var = new v7(640);
            this.f14176 = v7Var;
            this.f12894.m11636(v7Var);
            this.f14186 = 640;
            this.f14187 = 360;
            this.f14188 = 640;
            this.f14189 = 256;
            this.f14183 = new C2390(640, 256, true);
            this.f14190 = i3;
            this.f14191 = i4;
            C4638.m14099("FilmLittlePreviewFilter", String.format("resultWidth : %s , resultHeight : %s ", Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f14180 = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(b2.f93).position(0);
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f14181 = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(b2.f99).position(0);
        this.f14182 = new C2390(this.f14186, this.f14187, true);
    }

    @Override // defpackage.AbstractC3724
    /* renamed from: ԩ */
    public void mo11903() {
        C4974 c4974 = new C4974();
        this.f14174 = c4974;
        c4974.m10884(this.f12895.m8883());
        this.f14174.m14761(C5083.f16883);
        this.f12894.m11636(this.f14174);
    }

    @Override // defpackage.AbstractC3724
    /* renamed from: ԭ */
    public void mo11907() {
        super.mo11907();
        C4974 c4974 = this.f14174;
        if (c4974 != null) {
            c4974.m13471();
            this.f14174.mo10877();
            this.f14174 = null;
        }
        C2390 c2390 = this.f14182;
        if (c2390 != null) {
            c2390.m8880();
            this.f14182 = null;
        }
        C2390 c23902 = this.f14183;
        if (c23902 != null) {
            c23902.m8880();
            this.f14183 = null;
        }
        C4327 c4327 = this.f14178;
        if (c4327 != null) {
            c4327.m13471();
            this.f14178 = null;
        }
        v7 v7Var = this.f14176;
        if (v7Var != null) {
            v7Var.m13471();
            this.f14176.mo10877();
            this.f14176 = null;
        }
        u7 u7Var = this.f14175;
        if (u7Var != null) {
            u7Var.m13471();
            this.f14175.mo10877();
            this.f14175 = null;
        }
    }

    @Override // defpackage.AbstractC3724
    /* renamed from: ބ */
    public void mo11919() {
    }

    /* renamed from: އ, reason: contains not printable characters */
    public byte[] m13010() {
        return this.f14177.m9458();
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean m13011() {
        return this.f14179;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m13012(C4327 c4327, int i, int i2) {
        C3732.m11943("befault renderFilter ");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, i, i2);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
        c4327.mo9491(i, i2);
        this.f14181.clear();
        this.f14181.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}).position(0);
        this.f14180.clear();
        this.f14180.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f}).position(0);
        c4327.m13479(0, this.f14180, this.f14181);
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m13013(int i) {
        System.nanoTime();
        C3732.m11943("after renderFrameOnOther");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.f14186, this.f14187);
        GLES20.glClearColor(0.0745f, 0.0706f, 0.0667f, 1.0f);
        C4327 c4327 = this.f14178;
        c4327.m13477();
        c4327.mo9491(this.f14186, this.f14187);
        float f = this.f14184;
        this.f14180.clear();
        this.f14180.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}).position(0);
        this.f14181.clear();
        this.f14181.put(new float[]{0.0f, 0.0f - f, 1.0f, 0.0f - f, 0.0f, f + 1.0f, 1.0f, f + 1.0f}).position(0);
        GLES20.glBindFramebuffer(36160, this.f14182.m8881());
        GLES20.glViewport(0, 0, this.f14186, this.f14187);
        GLES20.glClearColor(0.0745f, 0.0706f, 0.0667f, 1.0f);
        c4327.m13479(i, this.f14180, this.f14181);
        GLES20.glBindFramebuffer(36160, 0);
        System.nanoTime();
        if (this.f14179) {
            GLES20.glViewport(0, 0, this.f14190, this.f14191);
            C3606 c3606M11908 = m11908();
            c3606M11908.m13477();
            c3606M11908.mo9491(this.f14190, this.f14191);
            this.f14180.clear();
            this.f14180.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f}).position(0);
            float fM5922 = 1.0f / d9.m5921().m5922();
            Matrix.setIdentityM(this.f14192, 0);
            if (fM5922 != 1.0f) {
                float f2 = (1.0f - fM5922) * 0.5f;
                Matrix.translateM(this.f14192, 0, f2, f2, 0.0f);
                Matrix.scaleM(this.f14192, 0, fM5922, fM5922, 0.0f);
            }
            m13016(this.f14192);
            c3606M11908.m13479(this.f14182.m8882(), this.f14180, this.f14181);
        } else {
            GLES20.glBindFramebuffer(36160, this.f14183.m8881());
            GLES20.glViewport(0, 0, this.f14188, this.f14189);
            C3606 c3606M119082 = m11908();
            c3606M119082.m13477();
            c3606M119082.mo9491(this.f14188, this.f14189);
            float fM59222 = 1.0f / d9.m5921().m5922();
            Matrix.setIdentityM(this.f14192, 0);
            if (fM59222 != 1.0f) {
                float f3 = (1.0f - fM59222) * 0.5f;
                Matrix.translateM(this.f14192, 0, f3, f3, 0.0f);
                Matrix.scaleM(this.f14192, 0, fM59222, fM59222, 0.0f);
            }
            m13016(this.f14192);
            c3606M119082.m13479(this.f14182.m8882(), this.f14180, this.f14181);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, this.f14190, this.f14191);
            C4327 c43272 = this.f14178;
            c43272.m13477();
            c43272.mo9491(this.f14190, this.f14191);
            this.f14181.clear();
            this.f14181.put(new float[]{0.0f, -0.01f, 1.0f, -0.01f, 0.0f, 1.01f, 1.0f, 1.01f}).position(0);
            c43272.m13479(this.f14183.m8882(), this.f14180, this.f14181);
        }
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m13014() {
        List<C4327> listM11637 = this.f12894.m11637();
        if (listM11637 != null) {
            listM11637.clear();
        }
        List<C4327> listM11638 = this.f12894.m11638();
        if (listM11638 != null) {
            listM11638.clear();
        }
        this.f12894.m11636(this.f14174);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m13015(int i) {
        this.f14185 = i;
        m13014();
        if (i == 2) {
            this.f12894.m11636(this.f14175);
        } else {
            if (i != 3) {
                return;
            }
            this.f12894.m11636(this.f14176);
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m13016(float[] fArr) {
        this.f14174.m14764(fArr);
    }

    public C4077(boolean z, int i, int i2) {
        this.f14173 = false;
        this.f14184 = 0.0f;
        this.f14185 = 0;
        this.f14186 = 500;
        this.f14187 = 500;
        this.f14188 = 640;
        this.f14189 = 256;
        this.f14190 = 500;
        this.f14191 = 256;
        this.f14192 = new float[16];
        this.f14179 = z;
        this.f14178 = new C4327();
        if (z) {
            C2581 c2581 = new C2581();
            this.f14177 = c2581;
            this.f12894.m11636(c2581);
            this.f14186 = 320;
            this.f14187 = MPEGConst.SEQUENCE_ERROR_CODE;
            this.f14190 = 320;
            this.f14191 = MPEGConst.SEQUENCE_ERROR_CODE;
        } else {
            this.f14175 = new u7(640);
            v7 v7Var = new v7(640);
            this.f14176 = v7Var;
            this.f12894.m11636(v7Var);
            this.f14186 = 640;
            this.f14187 = 360;
            this.f14188 = 640;
            this.f14189 = 256;
            this.f14183 = new C2390(640, 256, true);
            this.f14190 = i;
            this.f14191 = i2;
            C4638.m14099("FilmLittlePreviewFilter", String.format("resultWidth : %s , resultHeight : %s ", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f14180 = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(b2.f93).position(0);
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f14181 = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(b2.f99).position(0);
        this.f14182 = new C2390(this.f14186, this.f14187, true);
    }
}
