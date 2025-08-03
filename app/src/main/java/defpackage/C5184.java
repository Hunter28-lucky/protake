package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.blink.academy.filter.core.C1788;
import com.blink.academy.filter.core.C1789;
import com.blink.academy.filter.core.C1793;
import com.blink.academy.filter.core.Drawable2d;
import com.blink.academy.filter.core.FramebufferTexture;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import defpackage.C2692;
import defpackage.C3764;
import defpackage.C4374;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ၿ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5184 implements C2692.InterfaceC2693 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C5182 f17162;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C1788 f17163;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C1788 f17164;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C1788 f17165;

    /* renamed from: ԫ, reason: contains not printable characters */
    public C1788 f17166;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C1788 f17167;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C1788 f17168;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C1788 f17169;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float[] f17170;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f17171;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f17172;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f17173;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float[] f17174;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C2548 f17175;

    /* renamed from: ހ, reason: contains not printable characters */
    public C1788 f17176;

    /* renamed from: ށ, reason: contains not printable characters */
    public C1788 f17177;

    /* renamed from: ނ, reason: contains not printable characters */
    public C1788 f17178;

    /* renamed from: ރ, reason: contains not printable characters */
    public C1793 f17179;

    /* renamed from: ބ, reason: contains not printable characters */
    public C4874 f17180;

    /* renamed from: ޅ, reason: contains not printable characters */
    public C3974 f17181;

    /* renamed from: ކ, reason: contains not printable characters */
    public C4676 f17182;

    /* renamed from: އ, reason: contains not printable characters */
    public C4676 f17183;

    /* renamed from: ވ, reason: contains not printable characters */
    public C3142 f17184;

    /* renamed from: މ, reason: contains not printable characters */
    public C3623 f17185;

    /* renamed from: ފ, reason: contains not printable characters */
    public C2922 f17186;

    /* renamed from: ދ, reason: contains not printable characters */
    public C4498 f17187;

    /* renamed from: ތ, reason: contains not printable characters */
    public C3934 f17188;

    /* renamed from: ލ, reason: contains not printable characters */
    public Drawable2d f17189;

    /* renamed from: ގ, reason: contains not printable characters */
    public Drawable2d f17190;

    /* renamed from: ޏ, reason: contains not printable characters */
    public Drawable2d f17191;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f17192;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f17193;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f17194;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f17195;

    /* renamed from: ޔ, reason: contains not printable characters */
    public IntBuffer f17196;

    /* renamed from: ޕ, reason: contains not printable characters */
    public C2692 f17197;

    /* renamed from: ޖ, reason: contains not printable characters */
    public float[] f17198;

    /* renamed from: ޗ, reason: contains not printable characters */
    public final Object f17199;

    /* renamed from: ޘ, reason: contains not printable characters */
    public List<List<C4374.C4376>> f17200;

    /* renamed from: ޙ, reason: contains not printable characters */
    public List<List<C4374>> f17201;

    /* renamed from: ޚ, reason: contains not printable characters */
    public int f17202;

    /* renamed from: ޛ, reason: contains not printable characters */
    public boolean f17203;

    /* renamed from: ၿ$Ϳ, reason: contains not printable characters */
    public class C5185 implements InterfaceC4739 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Bitmap f17204;

        public C5185(Bitmap bitmap) {
            this.f17204 = bitmap;
        }

        @Override // defpackage.InterfaceC4739
        /* renamed from: Ϳ */
        public void mo14277() {
            this.f17204.recycle();
        }

        @Override // defpackage.InterfaceC4739
        /* renamed from: Ԩ */
        public void mo14278() {
            this.f17204.recycle();
        }
    }

    public C5184() {
        this(null);
    }

    public C5184(C5182 c5182) {
        this.f17198 = new float[16];
        this.f17199 = new Object();
        this.f17200 = new ArrayList();
        this.f17201 = new ArrayList();
        this.f17202 = 0;
        this.f17203 = false;
        this.f17162 = c5182;
        if (c5182 == null) {
            this.f17162 = new C5182();
        }
        C2548 c2548 = new C2548();
        this.f17175 = c2548;
        c2548.m9390();
        this.f17179 = new C1793();
        this.f17180 = new C4874();
        this.f17181 = new C3974();
        this.f17182 = new C4676(0);
        this.f17183 = new C4676(1);
        this.f17184 = new C3142();
        this.f17186 = new C2922();
        this.f17185 = new C3623(5.0f);
        this.f17187 = new C4498();
        this.f17188 = new C3934();
        this.f17189 = new Drawable2d();
        this.f17190 = new Drawable2d();
        this.f17191 = new Drawable2d();
        C3764.C3765 c3765M12047 = C3764.m12047(C4596.m14055(C4625.m14082("Kg4ZQDYTDBEjGQxVW0cdKg4Z")));
        this.f17170 = c3765M12047.m12053();
        this.f17171 = C2584.m9466(c3765M12047.m12051(), -1, true);
        byte[] bArrM12049 = C3764.m12049(C4596.m14055(C4625.m14082("Kg4ZQDUQQRAAHw==")));
        this.f17172 = C2584.m9466(C3914.m12654(BitmapFactory.decodeByteArray(bArrM12049, 0, bArrM12049.length), 1.0f, -1.0f), -1, true);
        C3764.C3765 c3765M120472 = C3764.m12047(C4596.m14055(C4625.m14082("Kg4ZQCQXCgAJPA1bR1YdKg4Z")));
        Bitmap bitmapM12051 = c3765M120472.m12051();
        this.f17174 = c3765M120472.m12053();
        this.f17173 = C2584.m9466(bitmapM12051, -1, true);
    }

    @Override // defpackage.C2692.InterfaceC2693
    /* renamed from: Ϳ */
    public void mo9920(List<Face> list, List<C4374> list2, float[] fArr, int i) {
        synchronized (this.f17199) {
            ArrayList arrayList = new ArrayList();
            if (list2.size() > 0) {
                this.f17202 = 0;
                ArrayList arrayList2 = new ArrayList(list2);
                for (C4374 c4374 : list2) {
                    arrayList.add(c4374.m13541());
                    arrayList.add(c4374.m13539());
                    arrayList.add(c4374.m13536());
                    arrayList.add(c4374.m13545());
                    arrayList.add(c4374.m13544());
                    arrayList.add(c4374.m13542());
                }
                this.f17201.add(arrayList2);
                this.f17200.add(arrayList);
            } else {
                int i2 = this.f17202 + 1;
                this.f17202 = i2;
                if (i2 >= 3) {
                    this.f17201.clear();
                    this.f17200.clear();
                }
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m15148(int i) {
        if (this.f17178 == null) {
            this.f17178 = new C1788(this.f17192, this.f17193, FramebufferTexture.Format.f5087);
        }
        this.f17178.m4786();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.f17179.mo4809(this.f17176.m4792(), this.f17189);
        if (this.f17196 == null) {
            this.f17196 = IntBuffer.allocate(this.f17192 * this.f17193);
        }
        if (this.f17197 == null) {
            C2692 c2692 = new C2692(this.f17194, this.f17195);
            this.f17197 = c2692;
            c2692.m9916(this);
        }
        this.f17196.position(0);
        GLES20.glReadPixels(0, 0, this.f17192, this.f17193, 6408, 5121, this.f17196);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f17192, this.f17193, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(this.f17196);
        Bitmap bitmapM12654 = C3914.m12654(bitmapCreateBitmap, 0.5f, -0.5f);
        int i2 = i % 360;
        InputImage inputImageFromBitmap = InputImage.fromBitmap(bitmapM12654, i2);
        this.f17197.m9915(i2);
        this.f17197.m9919(this.f17162.m15134() * 0.8f);
        this.f17197.m9914(this.f17162.m15131() * 0.6f);
        this.f17197.m9918(inputImageFromBitmap, new C5185(bitmapM12654));
        this.f17178.m4793();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m15149() {
        this.f17203 = true;
        IntBuffer intBuffer = this.f17196;
        if (intBuffer != null) {
            intBuffer.clear();
            this.f17196 = null;
        }
        C2692 c2692 = this.f17197;
        if (c2692 != null) {
            c2692.m9917();
            this.f17197 = null;
        }
        synchronized (this.f17199) {
            this.f17200.clear();
            this.f17201.clear();
        }
        C2584.m9469(this.f17172);
        C2584.m9469(this.f17171);
        C2584.m9469(this.f17173);
        C1788 c1788 = this.f17163;
        if (c1788 != null) {
            c1788.m4789();
        }
        C1788 c17882 = this.f17164;
        if (c17882 != null) {
            c17882.m4789();
        }
        C1788 c17883 = this.f17168;
        if (c17883 != null) {
            c17883.m4789();
        }
        C1788 c17884 = this.f17165;
        if (c17884 != null) {
            c17884.m4789();
        }
        C1788 c17885 = this.f17169;
        if (c17885 != null) {
            c17885.m4789();
        }
        C1788 c17886 = this.f17166;
        if (c17886 != null) {
            c17886.m4789();
        }
        C1788 c17887 = this.f17167;
        if (c17887 != null) {
            c17887.m4789();
        }
        C2548 c2548 = this.f17175;
        if (c2548 != null) {
            c2548.m9388();
        }
        C1788 c17888 = this.f17176;
        if (c17888 != null) {
            c17888.m4789();
        }
        C1788 c17889 = this.f17177;
        if (c17889 != null) {
            c17889.m4789();
        }
        C1788 c178810 = this.f17178;
        if (c178810 != null) {
            c178810.m4789();
        }
        C1793 c1793 = this.f17179;
        if (c1793 != null) {
            c1793.mo4800();
        }
        C4874 c4874 = this.f17180;
        if (c4874 != null) {
            c4874.mo4800();
        }
        C3974 c3974 = this.f17181;
        if (c3974 != null) {
            c3974.mo4800();
        }
        C4676 c4676 = this.f17182;
        if (c4676 != null) {
            c4676.mo4800();
        }
        C4676 c46762 = this.f17182;
        if (c46762 != null) {
            c46762.mo4800();
        }
        C4676 c46763 = this.f17183;
        if (c46763 != null) {
            c46763.mo4800();
        }
        C3142 c3142 = this.f17184;
        if (c3142 != null) {
            c3142.mo4800();
        }
        C2922 c2922 = this.f17186;
        if (c2922 != null) {
            c2922.mo4800();
        }
        C4498 c4498 = this.f17187;
        if (c4498 != null) {
            c4498.mo4800();
        }
        C3934 c3934 = this.f17188;
        if (c3934 != null) {
            c3934.mo4800();
        }
        C1789.f5110.m4795();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: Ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m15150(int r18, com.blink.academy.filter.core.TextureFormat r19, int r20, int r21, int r22, boolean r23, int r24, long r25, int r27) {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C5184.m15150(int, com.blink.academy.filter.core.TextureFormat, int, int, int, boolean, int, long, int):int");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m15151(float f) {
        this.f17162.m15137(f);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m15152(float f) {
        this.f17162.m15138(f);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m15153(float f) {
        this.f17162.m15139(f);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m15154(float f) {
        this.f17162.m15140(f);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m15155(float f) {
        this.f17162.m15141(f);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m15156(float f) {
        this.f17162.m15142(f);
    }
}
