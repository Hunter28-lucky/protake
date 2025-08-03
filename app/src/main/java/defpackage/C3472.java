package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ؼ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3472 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final String f11974 = C4625.m14082("CA4OChQXGxECHwpAY0FcLQoeHD8A");

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f11975 = false;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f11977 = 4;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final FaceDetector f11976 = FaceDetection.getClient(new FaceDetectorOptions.Builder().setClassificationMode(1).setContourMode(1).setLandmarkMode(2).setPerformanceMode(2).enableTracking().build());

    /* renamed from: ؼ$Ϳ, reason: contains not printable characters */
    public class C3473 implements OnFailureListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC3930 f11978;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ Bitmap f11979;

        public C3473(InterfaceC3930 interfaceC3930, Bitmap bitmap) {
            this.f11978 = interfaceC3930;
            this.f11979 = bitmap;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            if (C3472.this.f11975) {
                Log.d(C4625.m14082("CA4OChQXGxECHwpAY0FcLQoeHD8A"), String.format(C4625.m14082("IQE+GjMRCgcSS0V3S1BWPhsEAD5SVVREGEU="), exc.getMessage()));
            }
            InterfaceC3930 interfaceC3930 = this.f11978;
            if (interfaceC3930 != null) {
                interfaceC3930.mo10224(this.f11979);
            }
        }
    }

    /* renamed from: ؼ$Ԩ, reason: contains not printable characters */
    public class C3474 implements OnSuccessListener<List<Face>> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC3930 f11981;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ Bitmap f11982;

        public C3474(InterfaceC3930 interfaceC3930, Bitmap bitmap) {
            this.f11981 = interfaceC3930;
            this.f11982 = bitmap;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(@NonNull List<Face> list) {
            int i = 0;
            if (C3472.this.f11975) {
                Log.d(C4625.m14082("CA4OChQXGxECHwpAY0FcLQoeHD8A"), String.format(C4625.m14082("IQE+GjMRCgcSS0VBWklWblVNSiNS"), Integer.valueOf(list.size())));
            }
            if (this.f11981 != null) {
                ArrayList arrayList = new ArrayList();
                for (Face face : list) {
                    if (i >= 4) {
                        break;
                    }
                    Rect boundingBox = face.getBoundingBox();
                    int iMax = Math.max(boundingBox.width(), boundingBox.height());
                    arrayList.add(new C3483(face.getTrackingId(), boundingBox.centerX(), boundingBox.centerY(), new Size(iMax, iMax)));
                    i++;
                }
                this.f11981.mo10225(arrayList, this.f11982);
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m11325() {
        this.f11976.close();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m11326(Bitmap bitmap, InterfaceC3930 interfaceC3930) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f11976.process(InputImage.fromBitmap(bitmap, 0)).addOnSuccessListener(new C3474(interfaceC3930, bitmap)).addOnFailureListener(new C3473(interfaceC3930, bitmap));
    }
}
