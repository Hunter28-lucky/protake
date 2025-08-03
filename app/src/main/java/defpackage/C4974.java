package defpackage;

/* compiled from: GPUImageLookupFilter7.java */
/* renamed from: ຢ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4974 extends C3222 {

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f16727;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f16728;

    /* renamed from: ޑ, reason: contains not printable characters */
    public float f16729;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f16730;

    /* renamed from: ޓ, reason: contains not printable characters */
    public float[] f16731;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f16732;

    /* renamed from: ޕ, reason: contains not printable characters */
    public float[] f16733;

    public C4974() {
        this(1.0f);
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ށ */
    public void mo9737() {
        super.mo9737();
        m14762(this.f16729);
        m14761(this.f16733);
        m13485(this.f16730, this.f16731);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m14761(float[] fArr) {
        System.arraycopy(fArr, 0, this.f16733, 0, fArr.length);
        m13483(this.f16732, this.f16733);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m14762(float f) {
        this.f16729 = f;
        m13482(this.f16727, f);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m14763(float f) {
        this.f14865 = f;
        m13482(this.f16728, f);
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m14764(float[] fArr) {
        System.arraycopy(fArr, 0, this.f16731, 0, fArr.length);
        m13485(this.f16730, this.f16731);
    }

    public C4974(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nuniform highp mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", "varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2; // TODO: This is not used\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture\n \n uniform lowp float intensity;\n uniform lowp float isBnW;\n uniform lowp vec4 dims;\n \n void main()\n {\n     lowp vec4 textureColor = clamp(texture2D(inputImageTexture, textureCoordinate),vec4(0.0),vec4(1.0));\n     \n     lowp vec4 newColor = clamp(textureColor,vec4(0.0),vec4(1.0));\n     newColor.rgb *= dims.x;\n     highp float flr = floor(newColor.b);\n     highp vec2 xy = (0.5 + vec2(newColor.rg)) * dims.wz;\n     xy.x += (flr * dims.z);\n     lowp vec4 newColor1 = texture2D(inputImageTexture2, xy);\n     xy.x += dims.z;\n     lowp vec4 newColor2 = texture2D(inputImageTexture2, xy);\n     newColor = mix(newColor1, newColor2, newColor.b - flr);\n    \n    if (isBnW == 1.0){\n       textureColor.rgb = vec3(dot(textureColor.rgb,vec3(0.2126, 0.7152, 0.0722)));\n    }\n     newColor = clamp(mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity),vec4(0.0),vec4(1.0));\n     gl_FragColor = newColor;\n }");
        this.f16727 = m13476("intensity");
        this.f16728 = m13476("isBnW");
        this.f16732 = m13476("dims");
        this.f16730 = m13476("uTexMatrix");
        this.f16729 = f;
        this.f16733 = C5083.f16883;
        this.f16731 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }
}
