package defpackage;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import jp.co.cyberagent.android.gpuimage.RenderException;

/* compiled from: GPUImageFilter.java */
/* renamed from: ઘ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4327 {

    /* renamed from: ނ, reason: contains not printable characters */
    public static long f14850;

    /* renamed from: ރ, reason: contains not printable characters */
    public static AtomicInteger f14851 = new AtomicInteger(1000);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f14852;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final LinkedList<Runnable> f14853;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String f14854;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String f14855;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f14856;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f14857;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f14858;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f14859;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f14860;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f14861;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f14862;

    /* renamed from: ֏, reason: contains not printable characters */
    public volatile boolean f14863;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f14864;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f14865;

    /* renamed from: ހ, reason: contains not printable characters */
    public C4332<String, Integer> f14866;

    /* renamed from: ށ, reason: contains not printable characters */
    public HashMap<Integer, Integer> f14867;

    /* compiled from: GPUImageFilter.java */
    /* renamed from: ઘ$Ϳ, reason: contains not printable characters */
    public class RunnableC4328 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14868;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ float[] f14869;

        public RunnableC4328(int i, float[] fArr) {
            this.f14868 = i;
            this.f14869 = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glUniformMatrix4fv(C4327.this.m13474(this.f14868), 1, false, this.f14869, 0);
        }
    }

    /* compiled from: GPUImageFilter.java */
    /* renamed from: ઘ$Ԩ, reason: contains not printable characters */
    public class RunnableC4329 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14871;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f14872;

        public RunnableC4329(int i, float f) {
            this.f14871 = i;
            this.f14872 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glUniform1f(C4327.this.m13474(this.f14871), this.f14872);
        }
    }

    /* compiled from: GPUImageFilter.java */
    /* renamed from: ઘ$Ԫ, reason: contains not printable characters */
    public class RunnableC4330 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14874;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ float[] f14875;

        public RunnableC4330(int i, float[] fArr) {
            this.f14874 = i;
            this.f14875 = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glUniform4fv(C4327.this.m13474(this.f14874), 1, FloatBuffer.wrap(this.f14875));
        }
    }

    /* compiled from: GPUImageFilter.java */
    /* renamed from: ઘ$Ԭ, reason: contains not printable characters */
    public class RunnableC4331 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f14877;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int[] f14878;

        public RunnableC4331(int i, int[] iArr) {
            this.f14877 = i;
            this.f14878 = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iM13474 = C4327.this.m13474(this.f14877);
            int[] iArr = this.f14878;
            GLES20.glUniform1iv(iM13474, iArr.length, iArr, 0);
        }
    }

    public C4327() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform highp float inputAlpha;\n \nvoid main()\n{\n     highp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n     color.a *= inputAlpha;\n     gl_FragColor = color;\n}");
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m13470(int i) {
        if (i < 1000) {
            throw new RuntimeException("invalid VLOC");
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m13471() {
        this.f14863 = false;
        int i = this.f14856;
        if (i != 0) {
            if (this.f14852) {
                Log.d("GPUImageFilter", String.format("destroyed program:%d", Integer.valueOf(i)));
            }
            C4650.m14132(this.f14856);
            this.f14856 = 0;
        }
        mo10878();
    }

    /* renamed from: ԩ */
    public void mo10877() {
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int m13472() {
        return this.f14862;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m13473() {
        return this.f14861;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m13474(int i) {
        Integer num = this.f14867.get(Integer.valueOf(i));
        if (num == null) {
            String strM13487 = this.f14866.m13487(Integer.valueOf(i));
            if (strM13487 == null) {
                throw new RuntimeException("vloc was never retrieved");
            }
            Integer num2 = new Integer(GLES20.glGetUniformLocation(this.f14856, strM13487));
            this.f14867.put(Integer.valueOf(i), num2);
            num = num2;
        }
        return num.intValue();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public int m13475() {
        return this.f14856;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int m13476(String str) {
        if (this instanceof C3606) {
            throw new RuntimeException("groups are not filters or programs.");
        }
        Integer numM13486 = this.f14866.m13486(str);
        if (numM13486 == null) {
            numM13486 = new Integer(f14851.getAndIncrement());
            this.f14866.m13488(str, numM13486);
        }
        return numM13486.intValue();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m13477() {
        mo8361();
        this.f14863 = true;
        mo9737();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public synchronized boolean m13478() {
        return this.f14863;
    }

    /* renamed from: ֈ */
    public void mo10878() {
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m13479(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, iArr, 0);
        C2390 c2390M8877 = C2390.m8877(iArr[0]);
        C2390 c2390M8876 = C2390.m8876(i, 0, 0);
        C3439 c3439 = C3439.f11831;
        c3439.m11206(c2390M8877);
        c3439.m11206(c2390M8876);
        try {
            mo8360(c2390M8877, c2390M8876, floatBuffer, floatBuffer2);
        } catch (RenderException e2) {
            if (this.f14852) {
                Log.e("GPUImageFilter", "RenderException", e2);
            }
        }
        if (c3439.m11211(c2390M8876)) {
            if (this.f14852) {
                Log.w("GPUImageFilter", "source still in use!");
            }
            c3439.m11213(c2390M8876);
        }
        if (!c3439.m11211(c2390M8877) && this.f14852) {
            Log.w("GPUImageFilter", "target has been freed!");
        }
        c3439.m11213(c2390M8877);
    }

    /* renamed from: ׯ */
    public C2390 mo8360(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (!this.f14863) {
            if (this.f14852) {
                Log.e("GPUImageFilter", "rendering filter without initialization!");
            }
            return c23902;
        }
        if (c2390 == null) {
            c2390 = C3439.f11831.m11214(this.f14861, this.f14862, 6408);
        }
        GLES20.glBindFramebuffer(36160, c2390.m8881());
        GLES20.glUseProgram(this.f14856);
        m13481();
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f14857, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f14857);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.f14860, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.f14860);
        if (c23902.m8882() != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, c23902.m8882());
            GLES20.glUniform1i(m13474(this.f14858), 0);
        }
        mo10879();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f14857);
        GLES20.glDisableVertexAttribArray(this.f14860);
        GLES20.glBindTexture(3553, 0);
        C3439.f11831.m11213(c23902);
        long jNanoTime = System.nanoTime();
        if (f14850 == 0) {
            f14850 = jNanoTime;
        }
        if (jNanoTime - f14850 > 8000000) {
            f14850 = jNanoTime;
            GLES20.glFinish();
            Thread.yield();
        }
        return c2390;
    }

    /* renamed from: ؠ */
    public void mo10879() {
    }

    /* renamed from: ހ */
    public void mo8361() {
        if (this.f14863) {
            if (this.f14852) {
                Log.e("GPUImagefilter", "already initialized");
                return;
            }
            return;
        }
        int iM14126 = C4650.m14126(this.f14854, this.f14855);
        this.f14856 = iM14126;
        this.f14857 = GLES20.glGetAttribLocation(iM14126, "position");
        this.f14860 = GLES20.glGetAttribLocation(this.f14856, "inputTextureCoordinate");
        this.f14863 = true;
        mo11635(this.f14864);
        if (this.f14852) {
            Log.d("GPUImageFilter", String.format("allocated program:%d", Integer.valueOf(this.f14856)));
        }
    }

    /* renamed from: ށ */
    public void mo9737() {
    }

    /* renamed from: ނ */
    public void mo9491(int i, int i2) {
        this.f14861 = i;
        this.f14862 = i2;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m13480(Runnable runnable) {
        synchronized (this.f14853) {
            this.f14853.addLast(runnable);
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m13481() {
        while (!this.f14853.isEmpty()) {
            this.f14853.removeFirst().run();
        }
    }

    /* renamed from: ޅ */
    public void mo11635(float f) {
        this.f14864 = f;
        int i = this.f14859;
        if (i != -1) {
            m13482(i, f);
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m13482(int i, float f) {
        m13470(i);
        m13480(new RunnableC4329(i, f));
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m13483(int i, float[] fArr) {
        m13470(i);
        m13480(new RunnableC4330(i, fArr));
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m13484(int i, int[] iArr) {
        m13470(i);
        m13480(new RunnableC4331(i, iArr));
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m13485(int i, float[] fArr) {
        m13470(i);
        m13480(new RunnableC4328(i, fArr));
    }

    public C4327(String str, String str2) {
        this.f14852 = false;
        this.f14856 = -1;
        this.f14857 = -1;
        this.f14858 = -1;
        this.f14859 = -1;
        this.f14860 = -1;
        this.f14864 = 1.0f;
        this.f14865 = 0.0f;
        this.f14866 = new C4332<>(null);
        this.f14867 = new HashMap<>();
        this.f14853 = new LinkedList<>();
        this.f14854 = str;
        this.f14855 = str2;
        if (this instanceof C3606) {
            return;
        }
        this.f14858 = m13476("inputImageTexture");
        this.f14859 = m13476("inputAlpha");
    }

    /* compiled from: GPUImageFilter.java */
    /* renamed from: ઘ$Ԯ, reason: contains not printable characters */
    public static final class C4332<KeyType, ValueType> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public HashMap<KeyType, ValueType> f14880;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public HashMap<ValueType, KeyType> f14881;

        public C4332() {
            this.f14880 = new HashMap<>();
            this.f14881 = new HashMap<>();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public ValueType m13486(KeyType keytype) {
            return this.f14880.get(keytype);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public KeyType m13487(ValueType valuetype) {
            return this.f14881.get(valuetype);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public synchronized void m13488(KeyType keytype, ValueType valuetype) {
            this.f14880.put(keytype, valuetype);
            this.f14881.put(valuetype, keytype);
        }

        public /* synthetic */ C4332(RunnableC4412 runnableC4412) {
            this();
        }
    }
}
