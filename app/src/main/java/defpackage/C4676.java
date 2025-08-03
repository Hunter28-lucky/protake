package defpackage;

import android.opengl.GLES20;
import com.blink.academy.filter.core.C1793;
import com.blink.academy.filter.core.Drawable2d;
import java.nio.Buffer;

/* renamed from: ഊ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4676 extends C1793 {
    public C4676(int i) {
        super(m14179(), m14180(i));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m14179() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHEBaIx8BCg8ECgYVDh0cVF9AIg=="));
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static String m14180(int i) {
        return C4596.m14056(C4625.m14082(i != 0 ? "KAYBGzUAHFsDDgRHR0ocLAoMGiQLKAYEDgt0QVJUIwoDG34VAwcN" : "KAYBGzUAHFsDDgRHR0ocLAoMGiQLPREFLRdTVF5WIBtDCDwBAw=="));
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
        m4817();
        GLES20.glUniformMatrix4fv(this.f5133, 1, false, fArr, 0);
        C3624.m11696(C4625.m14082("KQM4ATkUAAYMJgRGQVpLegkb"));
        GLES20.glEnableVertexAttribArray(this.f5136);
        C3624.m11696(C4625.m14082("KQMoATEQAxE3DhdGVktyOhsfBjIzHQYAEg=="));
        GLES20.glVertexAttribPointer(this.f5136, drawable2d.m4774(), 5126, false, drawable2d.m4779(), (Buffer) drawable2d.m4777());
        C3624.m11696(C4625.m14082("KQM7CiIGCgwgHxFAWlFjIQYDGzUA"));
        GLES20.glDrawArrays(5, 0, drawable2d.m4778());
        C3624.m11696(C4625.m14082("KQMpHTEFLgYTChxB"));
        GLES20.glDisableVertexAttribArray(this.f5136);
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
        int iM4814 = m4814(iM9464, C4625.m14082("OyI7Px0TGwYIEw=="));
        this.f5133 = iM4814;
        C3624.m11697(iM4814, C4625.m14082("OyI7Px0TGwYIEw=="));
        int iM4810 = m4810(this.f5130, C4625.m14082("Lz8CHDkGBhsP"));
        this.f5136 = iM4810;
        C3624.m11697(iM4810, C4625.m14082("Lz8CHDkGBhsP"));
        this.f5131 = true;
    }
}
