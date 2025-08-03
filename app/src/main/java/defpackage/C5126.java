package defpackage;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.List;

/* renamed from: ဟ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5126 extends AbstractC4631<List<Face>> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final String f17037 = C4625.m14082("CA4OChQXGxECHwpAY0FcLQoeHD8A");

    /* renamed from: ԩ, reason: contains not printable characters */
    public final FaceDetector f17038;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InterfaceC5127 f17039;

    /* renamed from: ဟ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC5127 {
        /* renamed from: Ϳ */
        void mo9912(Exception exc);

        /* renamed from: Ԩ */
        void mo9913(List<Face> list);
    }

    public C5126(Handler handler, InterfaceC5127 interfaceC5127) {
        super(handler);
        this.f17038 = FaceDetection.getClient(new FaceDetectorOptions.Builder().setClassificationMode(1).setContourMode(2).setLandmarkMode(1).setPerformanceMode(1).build());
        this.f17039 = interfaceC5127;
    }

    @Override // defpackage.AbstractC4631
    /* renamed from: Ϳ */
    public Task<List<Face>> mo14091(InputImage inputImage) {
        return this.f17038.process(inputImage);
    }

    @Override // defpackage.AbstractC4631
    /* renamed from: Ԫ */
    public void mo14094(Exception exc) {
        Log.e(f17037, C4625.m14082("CA4OCnAWCgAECBFbXF0TKA4EAzUWTw==") + exc);
        InterfaceC5127 interfaceC5127 = this.f17039;
        if (interfaceC5127 != null) {
            interfaceC5127.mo9912(exc);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m15044() {
        this.f17038.close();
    }

    @Override // defpackage.AbstractC4631
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo14095(List<Face> list) {
        InterfaceC5127 interfaceC5127 = this.f17039;
        if (interfaceC5127 != null) {
            interfaceC5127.mo9913(list);
        }
    }
}
