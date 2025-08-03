package com.blink.academy.filter.core;

import android.opengl.GLES20;
import android.util.Log;
import defpackage.C2584;
import defpackage.C3624;
import defpackage.C4596;
import defpackage.C4625;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;

/* renamed from: com.blink.academy.filter.core.Ԯ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1793 {

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final String f5126 = C4625.m14082("HQYAHzwXOxEZHxBAVgF3Hh0CCCITAg==");

    /* renamed from: ހ, reason: contains not printable characters */
    public static boolean f5127 = false;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f5128;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f5129;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f5130;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean f5131;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final LinkedList<Runnable> f5132;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f5133;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f5134;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f5135;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f5136;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f5137;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f5138;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f5139;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f5140;

    public C1793() {
        this(m4808(), m4807());
    }

    public C1793(String str, String str2) {
        this.f5133 = -1;
        this.f5134 = -1;
        this.f5135 = -1;
        this.f5136 = -1;
        this.f5137 = -1;
        this.f5138 = 0;
        this.f5132 = new LinkedList<>();
        this.f5128 = str;
        this.f5129 = str2;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m4807() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHEBaIx8BCg8UHRUGBgBcRx1UIhwB"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m4808() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHEBaIx8BCg8ECgYVDh0cVF9AIg=="));
    }

    /* renamed from: Ϳ */
    public void mo4800() {
        this.f5131 = false;
        if (this.f5130 != 0) {
            if (f5127) {
                Log.d(f5126, String.format(C4625.m14082("KgoeGyIdFhEFSxVAXFRBLwJXSjQ="), Integer.valueOf(this.f5130)));
            }
            C2584.m9470(this.f5130);
            this.f5130 = 0;
        }
    }

    /* renamed from: Ԩ */
    public C1788 mo4801(C1788 c1788, C1788 c17882, float[] fArr, float[] fArr2, Drawable2d drawable2d) {
        if (c1788 == null) {
            int i = this.f5139;
            int i2 = this.f5140;
            if (i == 0 || i2 == 0) {
                i = c17882.f5101;
                i2 = c17882.f5102;
            }
            c1788 = C1789.f5110.m4798(i, i2, c17882.f5103);
        }
        c1788.m4786();
        mo4802(c17882.m4792(), fArr, fArr2, drawable2d);
        c1788.m4793();
        return c1788;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void mo4809(int i, Drawable2d drawable2d) {
        float[] fArr = C3624.f12578;
        mo4802(i, fArr, fArr, drawable2d);
    }

    /* renamed from: Ԫ */
    public void mo4802(int i, float[] fArr, float[] fArr2, Drawable2d drawable2d) {
        if (!this.f5131) {
            mo4803();
        }
        C3624.m11696(C4625.m14082("Kh0MGHABGxUTHw=="));
        GLES20.glUseProgram(this.f5130);
        C3624.m11696(C4625.m14082("KQM4HDUiHRsGGQRf"));
        this.f5138 = 0;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5135, this.f5138);
        m4817();
        GLES20.glUniformMatrix4fv(this.f5133, 1, false, fArr, 0);
        C3624.m11696(C4625.m14082("KQM4ATkUAAYMJgRGQVpLegkb"));
        GLES20.glUniformMatrix4fv(this.f5134, 1, false, fArr2, 0);
        C3624.m11696(C4625.m14082("KQM4ATkUAAYMJgRGQVpLegkb"));
        GLES20.glEnableVertexAttribArray(this.f5136);
        C3624.m11696(C4625.m14082("KQMoATEQAxE3DhdGVktyOhsfBjIzHQYAEg=="));
        GLES20.glVertexAttribPointer(this.f5136, drawable2d.m4774(), 5126, false, drawable2d.m4779(), (Buffer) drawable2d.m4777());
        C3624.m11696(C4625.m14082("KQM7CiIGCgwgHxFAWlFjIQYDGzUA"));
        GLES20.glEnableVertexAttribArray(this.f5137);
        C3624.m11696(C4625.m14082("KQMoATEQAxE3DhdGVktyOhsfBjIzHQYAEg=="));
        GLES20.glVertexAttribPointer(this.f5137, drawable2d.m4774(), 5126, false, drawable2d.m4776(), (Buffer) drawable2d.m4775());
        C3624.m11696(C4625.m14082("KQM7CiIGCgwgHxFAWlFjIQYDGzUA"));
        GLES20.glDrawArrays(5, 0, drawable2d.m4778());
        C3624.m11696(C4625.m14082("KQMpHTEFLgYTChxB"));
        GLES20.glDisableVertexAttribArray(this.f5136);
        GLES20.glDisableVertexAttribArray(this.f5137);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m4810(int i, String str) {
        return GLES20.glGetAttribLocation(i, str);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m4811(String str) {
        return m4810(this.f5130, str);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int m4812() {
        return this.f5140;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int m4813() {
        return this.f5139;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public int m4814(int i, String str) {
        return GLES20.glGetUniformLocation(i, str);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public int m4815(String str) {
        return GLES20.glGetUniformLocation(this.f5130, str);
    }

    /* renamed from: ׯ */
    public void mo4803() {
        if (this.f5131) {
            return;
        }
        int iM9464 = C2584.m9464(this.f5128, this.f5129);
        this.f5130 = iM9464;
        int iM4814 = m4814(iM9464, C4625.m14082("OyI7Px0TGwYIEw=="));
        this.f5133 = iM4814;
        C3624.m11697(iM4814, C4625.m14082("OyI7Px0TGwYIEw=="));
        int iM48142 = m4814(this.f5130, C4625.m14082("OzsIFx0TGwYIEw=="));
        this.f5134 = iM48142;
        C3624.m11697(iM48142, C4625.m14082("OzsIFx0TGwYIEw=="));
        int iM4810 = m4810(this.f5130, C4625.m14082("Lz8CHDkGBhsP"));
        this.f5136 = iM4810;
        C3624.m11697(iM4810, C4625.m14082("Lz8CHDkGBhsP"));
        int iM48102 = m4810(this.f5130, C4625.m14082("LzsIFyQHHREiBApAVw=="));
        this.f5137 = iM48102;
        C3624.m11697(iM48102, C4625.m14082("LzsIFyQHHREiBApAVw=="));
        int iM48143 = m4814(this.f5130, C4625.m14082("PTsIFyQHHRE="));
        this.f5135 = iM48143;
        C3624.m11697(iM48143, C4625.m14082("PTsIFyQHHRE="));
        this.f5131 = true;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m4816(Runnable runnable) {
        synchronized (this.f5132) {
            this.f5132.addLast(runnable);
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m4817() {
        while (!this.f5132.isEmpty()) {
            this.f5132.removeFirst().run();
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m4818(int i, float f) {
        GLES20.glUniform1f(i, f);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m4819(int i, float[] fArr) {
        GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m4820(int i, float[] fArr) {
        GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m4821(int i, int i2) {
        GLES20.glUniform1i(i, i2);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m4822(int i, float[] fArr) {
        GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void mo4823(int i, int i2) {
        this.f5139 = i;
        this.f5140 = i2;
    }
}
