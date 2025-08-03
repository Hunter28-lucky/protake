package defpackage;

/* compiled from: HistogramBrightFilter.java */
/* renamed from: б, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2878 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public int[] f10545;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f10546;

    public C2878() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", C4982.m14767(m10227()));
        this.f10545 = new int[128];
        this.f10546 = m13476("bright");
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static String m10227() {
        return "histogram_bright.glsl";
    }

    @Override // defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
        m13484(this.f10546, this.f10545);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m10228(int[] iArr) {
        System.arraycopy(iArr, 0, this.f10545, 0, iArr.length);
        m13484(this.f10546, this.f10545);
    }
}
