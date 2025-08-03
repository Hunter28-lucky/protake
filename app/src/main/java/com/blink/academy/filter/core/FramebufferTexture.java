package com.blink.academy.filter.core;

import android.opengl.GLES20;
import defpackage.C4625;
import defpackage.C4679;

/* loaded from: classes.dex */
public class FramebufferTexture {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final String f5078 = C4625.m14082("CB0MAjUQGhIHDhdmVktHOx0I");

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean f5079;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f5080;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f5081;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Format f5082;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f5083;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int[] f5084;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int[] f5085;

    public enum Format {
        f5086(6408, 6408, 5121),
        f5087(6408, 6408, 5121),
        f5088(32849, 6407, 5121),
        f5089(33321, 6403, 5121),
        f5090(34842, 6408, 5126),
        f5091(34842, 6408, 5131),
        f5092(34836, 6408, 5126);

        public int format;
        public int internalformat;
        public int type;

        Format(int i, int i2, int i3) {
            this.internalformat = i;
            this.format = i2;
            this.type = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FramebufferTexture(int r18, int r19, com.blink.academy.filter.core.FramebufferTexture.Format r20) {
        /*
            r17 = this;
            r0 = r17
            r10 = r18
            r11 = r19
            r12 = r20
            r17.<init>()
            r13 = 0
            r0.f5079 = r13
            r14 = 1
            int[] r15 = new int[r14]
            r1 = -1
            r15[r13] = r1
            r0.f5084 = r15
            int[] r1 = new int[r14]
            r0.f5085 = r1
            r0.f5080 = r10
            r0.f5081 = r11
            r0.f5082 = r12
            r0.f5083 = r14
            java.lang.String r1 = "LAoLACIXTwAEExFHQVYTLwMBADM="
            java.lang.String r1 = defpackage.C4625.m14082(r1)
            defpackage.C2584.m9461(r1)
            android.opengl.GLES20.glGenTextures(r14, r15, r13)
            r1 = 33984(0x84c0, float:4.7622E-41)
            android.opengl.GLES20.glActiveTexture(r1)
            r1 = r15[r13]
            r9 = 3553(0xde1, float:4.979E-42)
            android.opengl.GLES20.glBindTexture(r9, r1)
            int r3 = r12.internalformat
            int r7 = r12.format
            int r8 = r12.type
            r1 = 3553(0xde1, float:4.979E-42)
            r2 = 0
            r6 = 0
            r16 = 0
            r4 = r18
            r5 = r19
            r14 = r9
            r9 = r16
            android.opengl.GLES20.glTexImage2D(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = 10242(0x2802, float:1.4352E-41)
            r2 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r14, r1, r2)
            r1 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r14, r1, r2)
            r1 = 10241(0x2801, float:1.435E-41)
            r2 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r14, r1, r2)
            r1 = 10240(0x2800, float:1.4349E-41)
            android.opengl.GLES20.glTexParameteri(r14, r1, r2)
            int r1 = android.opengl.GLES20.glGetError()
            if (r1 != 0) goto La1
            com.blink.academy.filter.core.FramebufferTexture$Format r1 = com.blink.academy.filter.core.FramebufferTexture.Format.f5087
            r2 = 3
            if (r12 != r1) goto L76
            goto L8e
        L76:
            com.blink.academy.filter.core.FramebufferTexture$Format r1 = com.blink.academy.filter.core.FramebufferTexture.Format.f5090
            if (r12 != r1) goto L7d
            r14 = 8
            goto L95
        L7d:
            com.blink.academy.filter.core.FramebufferTexture$Format r1 = com.blink.academy.filter.core.FramebufferTexture.Format.f5092
            if (r12 != r1) goto L84
            r14 = 16
            goto L95
        L84:
            com.blink.academy.filter.core.FramebufferTexture$Format r1 = com.blink.academy.filter.core.FramebufferTexture.Format.f5088
            if (r12 != r1) goto L8a
        L88:
            r14 = r2
            goto L95
        L8a:
            com.blink.academy.filter.core.FramebufferTexture$Format r1 = com.blink.academy.filter.core.FramebufferTexture.Format.f5091
            if (r12 != r1) goto L90
        L8e:
            r14 = 4
            goto L95
        L90:
            com.blink.academy.filter.core.FramebufferTexture$Format r1 = com.blink.academy.filter.core.FramebufferTexture.Format.f5089
            if (r12 != r1) goto L88
            r14 = 1
        L95:
            r1 = r15[r13]
            java.lang.String r2 = "OgoVGyUACg=="
            java.lang.String r2 = defpackage.C4625.m14082(r2)
            defpackage.C4679.m14183(r1, r2, r10, r11, r14)
            return
        La1:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "KQAZTzUAHRsTSwFHQVpdKU8ZCigGGgYESwReX1xQLxsEAD5I"
            java.lang.String r4 = defpackage.C4625.m14082(r4)
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.filter.core.FramebufferTexture.<init>(int, int, com.blink.academy.filter.core.FramebufferTexture$Format):void");
    }

    public FramebufferTexture(int i, int i2, Format format, int i3) {
        this.f5079 = false;
        int[] iArr = {-1};
        this.f5084 = iArr;
        this.f5085 = new int[1];
        this.f5080 = i;
        this.f5081 = i2;
        this.f5082 = format;
        this.f5083 = false;
        iArr[0] = i3;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4783() {
        if (this.f5083) {
            int[] iArr = this.f5084;
            if (iArr[0] != -1) {
                GLES20.glDeleteTextures(1, iArr, 0);
                C4679.m14182(this.f5084[0]);
                this.f5084[0] = -1;
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m4784() {
        return this.f5084[0];
    }
}
