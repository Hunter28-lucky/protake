package defpackage;

import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import com.blink.academy.film.videotools.camera.AspectRatio;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

/* compiled from: CameraController.java */
/* renamed from: İ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC2341 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f8871;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C2343 f8872;

    /* renamed from: ԩ, reason: contains not printable characters */
    public InterfaceC2342 f8873;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C2375 f8876;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C2375 f8877;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C4808 f8874 = new C4808();

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C4808 f8875 = new C4808();

    /* renamed from: Ԯ, reason: contains not printable characters */
    public HashMap<C2375, List<Integer>> f8878 = new HashMap<>();

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f8879 = 16000000;

    /* compiled from: CameraController.java */
    /* renamed from: İ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2342 {
        /* renamed from: Ϳ */
        void mo1358(C2343 c2343);

        /* renamed from: Ԩ */
        void mo1359();

        /* renamed from: ԩ */
        void mo1360(C2344 c2344);

        /* renamed from: Ԫ */
        void mo1361(C2343 c2343);

        /* renamed from: ԫ */
        void mo1362(String str);

        /* renamed from: Ԭ */
        void mo1363(C2343 c2343);

        /* renamed from: ԭ */
        void mo2047(C4378 c4378);

        /* renamed from: ԯ */
        void mo1365(C2344 c2344);
    }

    /* compiled from: CameraController.java */
    /* renamed from: İ$Ԩ, reason: contains not printable characters */
    public static class C2343 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public d1 f8880;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C4506 f8881;

        public C2343() {
            d1 d1Var = new d1();
            this.f8880 = d1Var;
            this.f8881 = new C4506(d1Var);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static C2343 m8783() {
            return new C2343();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C4506 m8784() {
            return this.f8881;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public d1 m8785() {
            return this.f8880;
        }
    }

    /* compiled from: CameraController.java */
    /* renamed from: İ$Ԫ, reason: contains not printable characters */
    public static class C2344 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public String f8882;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean f8883;

        /* renamed from: ԩ, reason: contains not printable characters */
        public String f8884;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public String f8885;

        /* renamed from: ԫ, reason: contains not printable characters */
        public String f8886;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public C3286 f8887;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public String m8786() {
            return this.f8884;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C3286 m8787() {
            return this.f8887;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public String m8788() {
            return this.f8882;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean m8789() {
            return this.f8883;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public C2344 m8790(String str) {
            this.f8886 = str;
            return this;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public C2344 m8791(boolean z) {
            this.f8883 = z;
            return this;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public C2344 m8792(String str) {
            this.f8884 = str;
            return this;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public C2344 m8793(C3286 c3286) {
            this.f8887 = c3286;
            return this;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public C2344 m8794(String str) {
            this.f8885 = str;
            return this;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public void m8795(String str) {
            this.f8882 = str;
        }
    }

    public AbstractC2341(C2343 c2343, Handler handler, InterfaceC2342 interfaceC2342) {
        this.f8872 = c2343;
        if (c2343 == null) {
            this.f8872 = C2343.m8783();
        }
        this.f8873 = interfaceC2342;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public abstract void mo8760(RectF rectF, Runnable runnable);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public HashMap<C2375, List<Integer>> m8761() {
        return this.f8878;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public abstract void mo8762();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public abstract void mo8763();

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m8764(C2343 c2343) {
        C2375 c2375First = null;
        this.f8877 = null;
        this.f8876 = null;
        d1 d1VarM8785 = c2343.m8785();
        C4506 c4506M8784 = c2343.m8784();
        AspectRatio aspectRatioM12210 = d1VarM8785.m12210();
        SortedSet<C2375> sortedSetM14530 = this.f8874.m14530(aspectRatioM12210);
        if (sortedSetM14530 == null) {
            return;
        }
        c4506M8784.m13834(sortedSetM14530);
        long jM12227 = d1VarM8785.m12227() * d1VarM8785.m12226();
        Iterator<C2375> it = sortedSetM14530.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C2375 next = it.next();
            if (next.m8844() <= jM12227) {
                c2375First = next;
                break;
            }
        }
        if (c2375First == null) {
            c2375First = sortedSetM14530.first();
        }
        this.f8877 = c2375First;
        int iM13041 = C4092.m13041();
        SortedSet<C2375> sortedSetM145302 = this.f8875.m14530(aspectRatioM12210);
        if (sortedSetM145302 == null) {
            return;
        }
        Iterator<C2375> it2 = sortedSetM145302.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            C2375 next2 = it2.next();
            if (next2.m8844() <= iM13041) {
                this.f8876 = next2;
                break;
            }
        }
        if (this.f8876 == null) {
            this.f8876 = sortedSetM145302.first();
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public abstract void mo8765();

    /* renamed from: ԭ, reason: contains not printable characters */
    public abstract void mo8766();

    /* renamed from: Ԯ, reason: contains not printable characters */
    public abstract void mo8767();

    /* renamed from: ԯ, reason: contains not printable characters */
    public abstract void mo8768();

    /* renamed from: ՠ, reason: contains not printable characters */
    public abstract void mo8769(float f, float f2);

    /* renamed from: ֈ, reason: contains not printable characters */
    public AbstractC2341 m8770(int i) {
        this.f8871 = i;
        return this;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public abstract void mo8771(int i);

    /* renamed from: ׯ, reason: contains not printable characters */
    public abstract void mo8772(int i);

    /* renamed from: ؠ, reason: contains not printable characters */
    public abstract void mo8773(float f);

    /* renamed from: ހ, reason: contains not printable characters */
    public abstract void mo8774(int i, long j);

    /* renamed from: ށ, reason: contains not printable characters */
    public abstract void mo8775(RectF rectF);

    /* renamed from: ނ, reason: contains not printable characters */
    public abstract void mo8776(RectF rectF);

    /* renamed from: ރ, reason: contains not printable characters */
    public abstract void mo8777(Surface surface);

    /* renamed from: ބ, reason: contains not printable characters */
    public abstract void mo8778(SurfaceTexture surfaceTexture);

    /* renamed from: ޅ, reason: contains not printable characters */
    public abstract void mo8779(float f, float f2);

    /* renamed from: ކ, reason: contains not printable characters */
    public abstract void mo8780();

    /* renamed from: އ, reason: contains not printable characters */
    public abstract void mo8781();

    /* renamed from: ވ, reason: contains not printable characters */
    public abstract void mo8782();
}
