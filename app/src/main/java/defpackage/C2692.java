package defpackage;

import android.graphics.PointF;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceContour;
import defpackage.C5126;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ʠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2692 implements C5126.InterfaceC5127 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f9990;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f9991;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f9994;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC2693 f9995;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public float f9992 = 0.0f;

    /* renamed from: ԫ, reason: contains not printable characters */
    public float f9993 = 0.0f;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C5126 f9989 = new C5126(null, this);

    /* renamed from: ʠ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2693 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo9920(List<Face> list, List<C4374> list2, float[] fArr, int i);
    }

    public C2692(int i, int i2) {
        this.f9990 = i;
        this.f9991 = i2;
    }

    @Override // defpackage.C5126.InterfaceC5127
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo9912(Exception exc) {
        exc.printStackTrace();
    }

    @Override // defpackage.C5126.InterfaceC5127
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo9913(List<Face> list) {
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[1000];
        int i = 0;
        for (Face face : list) {
            arrayList.add(new C4374(face, new C4390(this.f9990, this.f9991), this.f9992, this.f9993, this.f9994));
            Iterator<FaceContour> it = face.getAllContours().iterator();
            while (it.hasNext()) {
                for (PointF pointF : it.next().getPoints()) {
                    int i2 = i + 1;
                    fArr[i] = ((pointF.x / this.f9990) * 2.0f) - 1.0f;
                    i = i2 + 1;
                    fArr[i2] = 1.0f - ((pointF.y / this.f9991) * 2.0f);
                }
            }
        }
        InterfaceC2693 interfaceC2693 = this.f9995;
        if (interfaceC2693 != null) {
            interfaceC2693.mo9920(list, arrayList, fArr, i + 1);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public C2692 m9914(float f) {
        this.f9993 = f;
        return this;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C2692 m9915(int i) {
        this.f9994 = i;
        return this;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public C2692 m9916(InterfaceC2693 interfaceC2693) {
        this.f9995 = interfaceC2693;
        return this;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m9917() {
        this.f9989.m15044();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m9918(InputImage inputImage, InterfaceC4739 interfaceC4739) {
        this.f9989.m14093(inputImage, interfaceC4739);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C2692 m9919(float f) {
        this.f9992 = f;
        return this;
    }
}
