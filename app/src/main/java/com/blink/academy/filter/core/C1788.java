package com.blink.academy.filter.core;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;
import com.blink.academy.filter.core.FramebufferTexture;
import defpackage.C2584;
import defpackage.C4625;
import java.nio.ByteBuffer;

/* renamed from: com.blink.academy.filter.core.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1788 {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final String f5097 = C4625.m14082("CB0MAjUQGhIHDhc=");

    /* renamed from: ֈ, reason: contains not printable characters */
    public static boolean f5098 = false;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int[] f5099;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public FramebufferTexture f5100;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f5101;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f5102;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final FramebufferTexture.Format f5103;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f5104;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f5105;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f5106;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f5107;

    public C1788(int i, int i2) {
        this(i, i2, FramebufferTexture.Format.f5087);
    }

    public C1788(int i, int i2, FramebufferTexture.Format format) {
        int[] iArr = {0};
        this.f5099 = iArr;
        this.f5101 = i;
        this.f5102 = i2;
        this.f5103 = format;
        this.f5104 = true;
        this.f5105 = true;
        this.f5107 = C2584.m9463();
        this.f5100 = new FramebufferTexture(i, i2, format);
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, m4792(), 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            throw new RuntimeException(String.format(C4625.m14082("KB0MAjUQGhIHDhcSWl1QIQIdAzUGClpBHEUIExZAbkNNB3BIT1ESSw=="), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        if (f5098) {
            Log.d(C4625.m14082("CB0MAjUQGhIHDhc="), String.format(C4625.m14082("LwMBADMTGxEFSwQSXVZEbgkPAGpXC1QHBBcSR1ZLOhofCmpXCwMIDxFaCRZXbgcIBjcaG05EDw=="), Integer.valueOf(iArr[0]), Integer.valueOf(m4792()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public C1788(int i, int i2, FramebufferTexture.Format format, int i3, int i4) {
        int[] iArr = {0};
        this.f5099 = iArr;
        this.f5101 = i;
        this.f5102 = i2;
        this.f5103 = format;
        this.f5107 = C2584.m9463();
        iArr[0] = i3;
        this.f5100 = new FramebufferTexture(i, i2, format, i4);
        this.f5104 = false;
        this.f5105 = false;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C1788 m4785(int i, int i2, int i3) {
        return new C1788(i2, i3, FramebufferTexture.Format.f5086, 0, i);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4786() {
        GLES20.glBindFramebuffer(36160, m4790());
        GLES20.glViewport(0, 0, this.f5101, this.f5102);
        GLES20.glScissor(0, 0, this.f5101, this.f5102);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4787() {
        m4786();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m4788() {
        if (C2584.m9463() != this.f5107) {
            if (f5098) {
                Log.e(f5097, C4625.m14082("CC0iTzMdAQAEExESXlpAIw4ZDDg="));
            }
            throw new RenderException(C4625.m14082("CC0iTzMdAQAEExESXlpAIw4ZDDg="));
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized void m4789() {
        FramebufferTexture framebufferTexture;
        this.f5106 = true;
        if (this.f5104 && (framebufferTexture = this.f5100) != null) {
            framebufferTexture.m4783();
            this.f5100 = null;
        }
        if (this.f5105) {
            m4788();
            int[] iArr = this.f5099;
            if (iArr[0] != 0) {
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.f5099[0] = 0;
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m4790() {
        m4788();
        if (!this.f5106) {
            return this.f5099[0];
        }
        Log.e(f5097, C4625.m14082("KA0CTzEeHREADxwSV1ZAOh0CFjUW"));
        return 0;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public byte[] m4791() {
        m4786();
        GLES30.glReadBuffer(36064);
        byte[] bArr = new byte[this.f5101 * this.f5102 * 4];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.position(0);
        GLES20.glReadPixels(0, 0, this.f5101, this.f5102, 6408, 5121, byteBufferWrap);
        m4793();
        return bArr;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int m4792() {
        return this.f5100.m4784();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4793() {
        GLES20.glBindFramebuffer(36160, 0);
    }
}
