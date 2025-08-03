package defpackage;

/* compiled from: HistogramRGBFilter.java */
/* renamed from: ह, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4100 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public int[] f14242;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int[] f14243;

    /* renamed from: ކ, reason: contains not printable characters */
    public int[] f14244;

    /* renamed from: އ, reason: contains not printable characters */
    public int f14245;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f14246;

    /* renamed from: މ, reason: contains not printable characters */
    public int f14247;

    public C4100() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", C4982.m14767(m13047()));
        this.f14242 = new int[128];
        this.f14243 = new int[128];
        this.f14244 = new int[128];
        this.f14245 = m13476("redData");
        this.f14246 = m13476("greenData");
        this.f14247 = m13476("blueData");
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static String m13047() {
        return "histogram_rgb.glsl";
    }

    @Override // defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
        m13484(this.f14245, this.f14242);
        m13484(this.f14246, this.f14244);
        m13484(this.f14247, this.f14243);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m13048(int[] iArr, int[] iArr2, int[] iArr3) {
        System.arraycopy(iArr, 0, this.f14242, 0, iArr.length);
        System.arraycopy(iArr2, 0, this.f14244, 0, iArr2.length);
        System.arraycopy(iArr3, 0, this.f14243, 0, iArr3.length);
        m13484(this.f14245, this.f14242);
        m13484(this.f14246, this.f14244);
        m13484(this.f14247, this.f14243);
    }
}
