package defpackage;

import android.graphics.Bitmap;
import com.blink.academy.film.FilmApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PreviewIconManager.java */
/* renamed from: ƣ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2445 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C2445 f9132;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<C3756> f9133 = C3184.m10827().m10855();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public List<C3893> f9134;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f9135;

    /* compiled from: PreviewIconManager.java */
    /* renamed from: ƣ$Ϳ, reason: contains not printable characters */
    public class RunnableC2446 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2449 f9136;

        /* compiled from: PreviewIconManager.java */
        /* renamed from: ƣ$Ϳ$Ϳ, reason: contains not printable characters */
        public class C2447 implements InterfaceC2450 {
            public C2447() {
            }

            @Override // defpackage.C2445.InterfaceC2450
            /* renamed from: Ϳ, reason: contains not printable characters */
            public void mo9012() {
                InterfaceC2449 interfaceC2449 = RunnableC2446.this.f9136;
                if (interfaceC2449 != null) {
                    interfaceC2449.mo9013(1.0f - ((C2445.this.f9134.size() * 1.0f) / C2445.this.f9135));
                }
                RunnableC2446 runnableC2446 = RunnableC2446.this;
                C2445.this.m9006(runnableC2446.f9136);
            }
        }

        public RunnableC2446(InterfaceC2449 interfaceC2449) {
            this.f9136 = interfaceC2449;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r1.m8144(C2445.this.f9134)) {
                C2445.this.m9007((C3893) C2445.this.f9134.remove(0), new C2447());
            } else {
                InterfaceC2449 interfaceC2449 = this.f9136;
                if (interfaceC2449 != null) {
                    interfaceC2449.onSuc();
                }
            }
        }
    }

    /* compiled from: PreviewIconManager.java */
    /* renamed from: ƣ$Ԩ, reason: contains not printable characters */
    public class RunnableC2448 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3893 f9139;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2450 f9140;

        public RunnableC2448(C3893 c3893, InterfaceC2450 interfaceC2450) {
            this.f9139 = c3893;
            this.f9140 = interfaceC2450;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            ArrayList arrayList = new ArrayList();
            for (C2531 c2531 : this.f9139.m12557()) {
                String strM9349 = c2531.m9349();
                if (!r1.m8143(strM9349)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C4151.m13162().m13181(c2531.m9346() + ""));
                    sb.append("real_");
                    sb.append(c2531.m9350());
                    sb.append(".dat");
                    strM9349 = sb.toString();
                }
                if (!new File(strM9349).exists()) {
                    C4151.m13162().m13196(c2531);
                }
                arrayList.add(strM9349);
            }
            String strM12558 = this.f9139.m12558();
            Bitmap bitmapM10017 = C2764.m10017(arrayList);
            C2735.m9989(bitmapM10017, strM12558);
            bitmapM10017.recycle();
            C2445.this.m9009(this.f9139);
            InterfaceC2450 interfaceC2450 = this.f9140;
            if (interfaceC2450 != null) {
                interfaceC2450.mo9012();
            }
        }
    }

    /* compiled from: PreviewIconManager.java */
    /* renamed from: ƣ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC2449 {
        void onSuc();

        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo9013(float f);
    }

    /* compiled from: PreviewIconManager.java */
    /* renamed from: ƣ$Ԭ, reason: contains not printable characters */
    public interface InterfaceC2450 {
        /* renamed from: Ϳ */
        void mo9012();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static C2445 m9004() {
        if (f9132 == null) {
            synchronized (C2445.class) {
                if (f9132 == null) {
                    f9132 = new C2445();
                }
            }
        }
        return f9132;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m9005() {
        C3184.m10827().m10845();
        this.f9133 = new ArrayList();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m9006(InterfaceC2449 interfaceC2449) {
        FilmApp.m405().m427(new RunnableC2446(interfaceC2449));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m9007(C3893 c3893, InterfaceC2450 interfaceC2450) {
        new Thread(new RunnableC2448(c3893, interfaceC2450)).start();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public List<C3756> m9008() {
        return this.f9133;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m9009(C3893 c3893) {
        C3756 c3756 = new C3756();
        c3756.m12039(System.currentTimeMillis());
        c3756.m12040(c3893.m12558());
        this.f9133.add(c3756);
        C3184.m10827().m10870(c3756);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m9010(List<String> list) {
        if (r1.m8144(list) && r1.m8144(this.f9133)) {
            Iterator<C3756> it = this.f9133.iterator();
            while (it.hasNext()) {
                C3756 next = it.next();
                Iterator<String> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (it2.next().equals(next.m12038())) {
                        it.remove();
                        C3184.m10827().m10846(next);
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m9011(List<C3893> list, InterfaceC2449 interfaceC2449) {
        if (r1.m8144(this.f9134)) {
            return;
        }
        this.f9134 = list;
        this.f9135 = list.size();
        if (r1.m8144(this.f9134)) {
            m9006(interfaceC2449);
        } else if (interfaceC2449 != null) {
            interfaceC2449.onSuc();
        }
    }
}
