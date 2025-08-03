package defpackage;

/* compiled from: FIlmEffectFilter2.java */
/* renamed from: ɤ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2591 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public int f9642;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f9643;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f9644;

    /* renamed from: އ, reason: contains not printable characters */
    public int f9645;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f9646;

    /* renamed from: މ, reason: contains not printable characters */
    public int f9647;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f9648;

    /* renamed from: ދ, reason: contains not printable characters */
    public float f9649;

    /* renamed from: ތ, reason: contains not printable characters */
    public float f9650;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f9651;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f9652;

    /* renamed from: ޏ, reason: contains not printable characters */
    public float[] f9653;

    /* renamed from: ސ, reason: contains not printable characters */
    public float[] f9654;

    /* renamed from: ޑ, reason: contains not printable characters */
    public float f9655;

    public C2591() {
        super("uniform mat4 uMVPMatrix;\n    uniform mat4 uTexMatrix;\n    \n    uniform lowp float wOffset;\n    uniform lowp float hOffset;\n    \n    attribute vec4 position;\n    attribute vec4 inputTextureCoordinate;\n    \n    varying vec2 centerCoordinate;\n    varying vec2 topLeftCoordinate;\n    varying vec2 topRightCoordinate;\n    varying vec2 bottomLeftCoordinate;\n    varying vec2 bottomRightCoordinate;\n    \n    void main() {\n        gl_Position = uMVPMatrix * position;\n        centerCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n    \n        topLeftCoordinate = centerCoordinate + vec2(-wOffset, -hOffset);\n        topRightCoordinate = centerCoordinate + vec2(-wOffset, hOffset);\n        bottomLeftCoordinate = centerCoordinate + vec2(wOffset, -hOffset);\n        bottomRightCoordinate = centerCoordinate + vec2(wOffset, hOffset);\n    }", "precision highp float;\n    uniform sampler2D inputImageTexture;\n    varying vec2 centerCoordinate;\n    varying vec2 topLeftCoordinate;\n    varying vec2 topRightCoordinate;\n    varying vec2 bottomLeftCoordinate;\n    varying vec2 bottomRightCoordinate;\n    varying vec2 topMiddleCoordinate;\n    varying vec2 bottomMiddleCoordinate;\n    varying vec2 leftMiddleCoordinate;\n    varying vec2 rightMiddleCoordinate;\n\n\n    #define luminanceVec   vec3(0.2126, 0.7152, 0.0722)\n    #define greenishColor   vec4(0.0, 1.0, 0.0,1.0)\n    #define blueColor   vec4(0.0, 1.0, 0.0, 1.0)\n    #define redZebraColor   vec4(0.690, 0.227, 0.263, 1.0)\n    #define blueZebraColor  vec4(0.227, 0.663, 0.965, 1.0)\n    \n    uniform lowp float zebraAlpha;\n    uniform lowp float mode;\n    \n    vec4 zebraStripes(vec4 rootSample, float luminance) {\n    \n        float over = mod(centerCoordinate.x*1.77-centerCoordinate.y,0.015);\n        float under = mod(centerCoordinate.x*1.77+centerCoordinate.y,0.015);\n    \n        vec4 overPixel = mix(rootSample, redZebraColor, step(0.0075, over));\n        vec4 underPixel = mix(rootSample, blueZebraColor, step(0.0075, under));\n    \n        overPixel = mix(rootSample, overPixel, zebraAlpha*(luminance - 0.95)*20.0);\n        underPixel = mix(rootSample, underPixel, zebraAlpha*(0.05-luminance)*20.0);\n    \n        vec4 overColor = mix(rootSample, overPixel, step(0.95, luminance));\n        vec4 underColor = mix(underPixel, overColor, step(0.05, luminance));\n    \n        return underColor;\n    }\n    \n    uniform lowp float focusAlpha;\n    \n    vec4 focusPeaking(vec4 centerSample) {\n    \n        vec4 topLeftSample = texture2D(inputImageTexture, topLeftCoordinate);\n        vec4 topRightSample = texture2D(inputImageTexture, topRightCoordinate);\n        vec4 bottomLeftSample = texture2D(inputImageTexture, bottomLeftCoordinate);\n        vec4 bottomRightSample = texture2D(inputImageTexture, bottomRightCoordinate);\n    \n        lowp float microcontrast = min(1.25, length(topLeftSample - bottomRightSample) + length(topRightSample - bottomLeftSample))/1.25;\n    \n        vec4 contrastMapColor = mix(blueColor, greenishColor, microcontrast);\n        vec4 focusSample = mix(contrastMapColor, centerSample, step(microcontrast, 0.8));\n    \n        return mix(focusSample, centerSample, 0.0);\n    }\n    vec4 focusPeakingg(vec4 centerSample,float microcontrast) {\n    \n        vec4 contrastMapColor = mix(blueColor, greenishColor, microcontrast);\n        vec4 focusSample = mix(contrastMapColor, centerSample, step(microcontrast, 0.8));\n    \n        return mix(focusSample, centerSample, 0.0);\n    }\n\n\n\n\n    void main() {\n        vec4 centerSample = texture2D(inputImageTexture,centerCoordinate);\n        float luminance = centerSample.a;\n        if(mode==1.0){centerSample = zebraStripes(centerSample, luminance);}\n        if(mode==2.0){centerSample = focusPeakingg(centerSample,luminance);}\n        gl_FragColor = centerSample;\n    } ");
        this.f9642 = m13476("zebraAlpha");
        this.f9643 = m13476("focusAlpha");
        this.f9644 = m13476("uMVPMatrix");
        this.f9645 = m13476("uTexMatrix");
        this.f9646 = m13476("wOffset");
        this.f9647 = m13476("hOffset");
        this.f9648 = m13476("mode");
        this.f9649 = 1.0f;
        this.f9650 = 1.0f;
        this.f9653 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.f9654 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.f9651 = 0.0f;
        this.f9652 = 0.0f;
        this.f9655 = 0.0f;
        m13482(this.f9642, 1.0f);
        m13482(this.f9643, this.f9650);
        m13482(this.f9647, this.f9652);
        m13482(this.f9646, this.f9651);
        m13485(this.f9644, this.f9653);
        m13485(this.f9645, this.f9654);
        m13482(this.f9648, this.f9655);
    }

    @Override // defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
        m13482(this.f9642, this.f9649);
        m13482(this.f9643, this.f9650);
        m13482(this.f9647, this.f9652);
        m13482(this.f9646, this.f9651);
        m13485(this.f9644, this.f9653);
        m13485(this.f9645, this.f9654);
    }

    @Override // defpackage.C4327
    /* renamed from: ނ, reason: contains not printable characters */
    public void mo9491(int i, int i2) {
        super.mo9491(i, i2);
        if (i == 0 || i2 == 0) {
            return;
        }
        this.f9651 = 1.0f / i;
        float f = 1.0f / i2;
        this.f9652 = f;
        m13482(this.f9647, f);
        m13482(this.f9646, this.f9651);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m9492(float f) {
        this.f9655 = f;
        m13482(this.f9648, f);
    }
}
