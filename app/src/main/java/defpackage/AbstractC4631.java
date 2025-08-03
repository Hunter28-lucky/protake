package defpackage;

import android.graphics.Bitmap;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import java.util.concurrent.Executor;

/* renamed from: ಧ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4631<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Handler f15761;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Executor f15762 = new ExecutorC4634();

    /* renamed from: ಧ$Ϳ, reason: contains not printable characters */
    public class C4632 implements OnFailureListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4739 f15763;

        public C4632(InterfaceC4739 interfaceC4739) {
            this.f15763 = interfaceC4739;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            InterfaceC4739 interfaceC4739 = this.f15763;
            if (interfaceC4739 != null) {
                interfaceC4739.mo14277();
            }
            AbstractC4631.this.mo14094(exc);
        }
    }

    /* renamed from: ಧ$Ԩ, reason: contains not printable characters */
    public class C4633 implements OnSuccessListener<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4739 f15765;

        public C4633(InterfaceC4739 interfaceC4739) {
            this.f15765 = interfaceC4739;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(T t) {
            InterfaceC4739 interfaceC4739 = this.f15765;
            if (interfaceC4739 != null) {
                interfaceC4739.mo14278();
            }
            AbstractC4631.this.mo14095(t);
        }
    }

    /* renamed from: ಧ$Ԫ, reason: contains not printable characters */
    public class ExecutorC4634 implements Executor {
        public ExecutorC4634() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public AbstractC4631(Handler handler) {
        this.f15761 = handler;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public abstract Task<T> mo14091(InputImage inputImage);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Task<T> m14092(InputImage inputImage, @Nullable Bitmap bitmap, InterfaceC4739 interfaceC4739) {
        return mo14091(inputImage).addOnSuccessListener(this.f15762, new C4633(interfaceC4739)).addOnFailureListener(this.f15762, new C4632(interfaceC4739));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m14093(InputImage inputImage, InterfaceC4739 interfaceC4739) {
        m14092(inputImage, null, interfaceC4739);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public abstract void mo14094(Exception exc);

    /* renamed from: ԫ, reason: contains not printable characters */
    public abstract void mo14095(T t);
}
