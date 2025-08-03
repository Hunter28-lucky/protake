package defpackage;

import android.opengl.GLES20;
import com.blink.academy.filter.core.C1793;
import com.blink.academy.filter.core.Drawable2d;
import java.nio.Buffer;

/* renamed from: ฏ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4874 extends C1793 {
    public C4874() {
        this(m14597(), m14596());
    }

    public C4874(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m14596() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHEBaIx8BCg8dCgc+DRdTVF5WIBtDCDwBAw=="));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m14597() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHEBaIx8BCg8ECgYVDh0cVF9AIg=="));
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
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(this.f5135, 0);
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
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
    }
}
