package com.blink.academy.filter.core;

import android.opengl.GLES20;
import defpackage.C2584;
import defpackage.C3624;
import defpackage.C4596;
import defpackage.C4625;
import java.nio.Buffer;

/* renamed from: com.blink.academy.filter.core.ֈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1795 extends C1793 {

    /* renamed from: ނ, reason: contains not printable characters */
    public static final String f5143 = C4625.m14082("HQYAHzwXIBgFWSFiQVxUPA4A");

    /* renamed from: ށ, reason: contains not printable characters */
    public int f5144;

    public C1795() {
        this(m4830(), m4829());
    }

    public C1795(String str, String str2) {
        this.f5144 = 0;
        this.f5128 = str;
        this.f5129 = str2;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m4829() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHFxfKjALHTEVAhEPH0tVX0Bf"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m4830() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHFxfKjAbCiIGCgxPDAlBXw=="));
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: Ϳ */
    public void mo4800() {
        this.f5131 = false;
        int i = this.f5130;
        if (i != 0) {
            C2584.m9470(i);
            this.f5130 = 0;
        }
    }

    @Override // com.blink.academy.filter.core.C1793
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

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: Ԫ */
    public void mo4802(int i, float[] fArr, float[] fArr2, Drawable2d drawable2d) {
        if (!this.f5131) {
            mo4803();
        }
        C3624.m11696(C4625.m14082("Kh0MGHABGxUTHw=="));
        GLES20.glUseProgram(this.f5130);
        C3624.m11696(C4625.m14082("KQM4HDUiHRsGGQRf"));
        this.f5144 = 0;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5135, this.f5144);
        m4817();
        GLES20.glEnableVertexAttribArray(this.f5136);
        C3624.m11696(C4625.m14082("KQMoATEQAxE3DhdGVktyOhsfBjIzHQYAEg=="));
        GLES20.glVertexAttribPointer(this.f5136, drawable2d.m4774(), 5126, false, drawable2d.m4779(), (Buffer) drawable2d.m4777());
        C3624.m11696(C4625.m14082("KQM7CiIGCgwgHxFAWlFjIQYDGzUA"));
        GLES20.glEnableVertexAttribArray(this.f5137);
        C3624.m11696(C4625.m14082("KQMoATEQAxE3DhdGVktyOhsfBjIzHQYAEg=="));
        GLES20.glVertexAttribPointer(this.f5137, drawable2d.m4774(), 5126, false, drawable2d.m4776(), (Buffer) drawable2d.m4775());
        C3624.m11696(C4625.m14082("KQM7CiIGCgwgHxFAWlFjIQYDGzUA"));
        mo4804();
        GLES20.glDrawArrays(5, 0, drawable2d.m4778());
        C3624.m11696(C4625.m14082("KQMpHTEFLgYTChxB"));
        GLES20.glDisableVertexAttribArray(this.f5136);
        GLES20.glDisableVertexAttribArray(this.f5137);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        if (this.f5131) {
            return;
        }
        int iM9464 = C2584.m9464(this.f5128, this.f5129);
        this.f5130 = iM9464;
        int iM4810 = m4810(iM9464, C4625.m14082("PgAeBiQbABo="));
        this.f5136 = iM4810;
        C3624.m11697(iM4810, C4625.m14082("PgAeBiQbABo="));
        int iM48102 = m4810(this.f5130, C4625.m14082("JwEdGiQmCgwVHhdXcFxcPAsEATEGCg=="));
        this.f5137 = iM48102;
        C3624.m11697(iM48102, C4625.m14082("JwEdGiQmCgwVHhdXcFxcPAsEATEGCg=="));
        int iM4814 = m4814(this.f5130, C4625.m14082("JwEdGiQ7AhUGDjFXS0dGPAo="));
        this.f5135 = iM4814;
        C3624.m11697(iM4814, C4625.m14082("JwEdGiQ7AhUGDjFXS0dGPAo="));
        this.f5131 = true;
    }

    /* renamed from: އ */
    public void mo4804() {
    }
}
