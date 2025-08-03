package defpackage;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.C2130;
import jp.co.cyberagent.android.gpuimage.Rotation;

/* compiled from: GPUImageFilterGroup.java */
/* renamed from: ڶ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3606 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public List<C4327> f12535;

    /* renamed from: ޅ, reason: contains not printable characters */
    public List<C4327> f12536;

    /* renamed from: ކ, reason: contains not printable characters */
    public final FloatBuffer f12537;

    /* renamed from: އ, reason: contains not printable characters */
    public final FloatBuffer f12538;

    /* renamed from: ވ, reason: contains not printable characters */
    public final FloatBuffer f12539;

    public C3606() {
        this(null);
    }

    @Override // defpackage.C4327
    /* renamed from: ԩ */
    public void mo10877() {
        Iterator<C4327> it = this.f12535.iterator();
        while (it.hasNext()) {
            it.next().mo10877();
        }
        super.mo10877();
    }

    @Override // defpackage.C4327
    /* renamed from: ֈ */
    public synchronized void mo10878() {
        Iterator<C4327> it = this.f12535.iterator();
        while (it.hasNext()) {
            it.next().m13471();
        }
        super.mo10878();
    }

    @Override // defpackage.C4327
    @SuppressLint({"WrongCall"})
    /* renamed from: ׯ */
    public C2390 mo8360(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.f14856);
        if (getClass() == C3606.class && !this.f14853.isEmpty()) {
            Log.e("GPUImageFilterGroup", "filter group has a pending onDraw task, weird.");
            this.f14853.clear();
        }
        m13481();
        if (!m13478()) {
            Log.e("GPUImageFilterGroup", "rendering filter which is not initialized");
            return null;
        }
        List<C4327> list = this.f12536;
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                C4327 c4327 = this.f12536.get(i);
                c23902 = i == size + (-1) ? c4327.mo8360(c2390, c23902, floatBuffer, floatBuffer2) : c4327.mo8360(null, c23902, floatBuffer, floatBuffer2);
                floatBuffer = this.f12537;
                floatBuffer2 = this.f12538;
                i++;
            }
        }
        return c23902;
    }

    @Override // defpackage.C4327
    /* renamed from: ހ */
    public synchronized void mo8361() {
        super.mo8361();
        Iterator<C4327> it = this.f12535.iterator();
        while (it.hasNext()) {
            it.next().m13477();
        }
    }

    @Override // defpackage.C4327
    /* renamed from: ނ */
    public synchronized void mo9491(int i, int i2) {
        super.mo9491(i, i2);
        for (int i3 = 0; i3 < this.f12535.size(); i3++) {
            this.f12535.get(i3).mo9491(i, i2);
        }
    }

    @Override // defpackage.C4327
    /* renamed from: ޅ, reason: contains not printable characters */
    public void mo11635(float f) {
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m11636(C4327 c4327) {
        if (c4327 == null) {
            return;
        }
        this.f12535.add(c4327);
        m11639();
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public List<C4327> m11637() {
        return this.f12535;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public List<C4327> m11638() {
        return this.f12536;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m11639() {
        if (this.f12535 == null) {
            return;
        }
        List<C4327> list = this.f12536;
        if (list == null) {
            this.f12536 = new ArrayList();
        } else {
            list.clear();
        }
        for (C4327 c4327 : this.f12535) {
            if (c4327 instanceof C3606) {
                C3606 c3606 = (C3606) c4327;
                c3606.m11639();
                List<C4327> listM11638 = c3606.m11638();
                if (listM11638 != null && !listM11638.isEmpty()) {
                    this.f12536.addAll(listM11638);
                }
            } else {
                this.f12536.add(c4327);
            }
        }
    }

    public C3606(List<C4327> list) {
        this.f12535 = list;
        if (list == null) {
            this.f12535 = new ArrayList();
        } else {
            m11639();
        }
        float[] fArr = C2130.f7782;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f12537 = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        float[] fArr2 = b2.f98;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f12538 = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(fArr2).position(0);
        float[] fArrM111 = b2.m111(Rotation.NORMAL, false, true);
        FloatBuffer floatBufferAsFloatBuffer3 = ByteBuffer.allocateDirect(fArrM111.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f12539 = floatBufferAsFloatBuffer3;
        floatBufferAsFloatBuffer3.put(fArrM111).position(0);
    }
}
