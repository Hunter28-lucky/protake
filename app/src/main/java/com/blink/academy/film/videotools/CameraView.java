package com.blink.academy.film.videotools;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.ConnectionManager;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.secondscreen.SecondScreenPresenter;
import com.blink.academy.film.videotools.camera.AspectRatio;
import com.blink.academy.filter.core.C1793;
import com.blink.academy.filter.core.Drawable2d;
import com.blink.academy.filter.core.TextureFormat;
import com.uc.crashsdk.export.LogType;
import defpackage.AbstractC2341;
import defpackage.C2375;
import defpackage.C2390;
import defpackage.C2500;
import defpackage.C2579;
import defpackage.C2597;
import defpackage.C2650;
import defpackage.C2764;
import defpackage.C2811;
import defpackage.C3229;
import defpackage.C3255;
import defpackage.C3439;
import defpackage.C3444;
import defpackage.C3485;
import defpackage.C3606;
import defpackage.C3641;
import defpackage.C3732;
import defpackage.C3835;
import defpackage.C3891;
import defpackage.C4077;
import defpackage.C4112;
import defpackage.C4327;
import defpackage.C4378;
import defpackage.C4506;
import defpackage.C4535;
import defpackage.C4565;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.C5220;
import defpackage.InterfaceC3860;
import defpackage.a2;
import defpackage.d1;
import defpackage.d9;
import defpackage.q5;
import defpackage.v5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.Rotation;
import org.jcodec.containers.dpx.DPXReader;

/* loaded from: classes.dex */
public class CameraView extends GLRenderView {

    /* renamed from: ൖ, reason: contains not printable characters */
    public static final float[] f1610 = {1.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: ൟ, reason: contains not printable characters */
    public static final float[] f1611 = {0.0f, 1.0f, -1.0f, 0.0f};

    /* renamed from: ຆ, reason: contains not printable characters */
    public static final float[] f1612 = {-1.0f, 0.0f, 0.0f, -1.0f};

    /* renamed from: ຉ, reason: contains not printable characters */
    public static final float[] f1613 = {0.0f, -1.0f, 1.0f, 0.0f};

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f1614;

    /* renamed from: ވ, reason: contains not printable characters */
    public FrameRenderer f1615;

    /* renamed from: މ, reason: contains not printable characters */
    public AbstractC2341 f1616;

    /* renamed from: ފ, reason: contains not printable characters */
    public C2500 f1617;

    /* renamed from: ދ, reason: contains not printable characters */
    public C3229 f1618;

    /* renamed from: ތ, reason: contains not printable characters */
    public SecondScreenPresenter f1619;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f1620;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f1621;

    /* renamed from: ޏ, reason: contains not printable characters */
    public String f1622;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f1623;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f1624;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f1625;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f1626;

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean f1627;

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean f1628;

    /* renamed from: ޖ, reason: contains not printable characters */
    public int f1629;

    /* renamed from: ޗ, reason: contains not printable characters */
    public int f1630;

    /* renamed from: ޘ, reason: contains not printable characters */
    public int f1631;

    /* renamed from: ޙ, reason: contains not printable characters */
    public int f1632;

    /* renamed from: ޚ, reason: contains not printable characters */
    public int f1633;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f1634;

    /* renamed from: ޜ, reason: contains not printable characters */
    public C3255 f1635;

    /* renamed from: ޝ, reason: contains not printable characters */
    public boolean f1636;

    /* renamed from: ޞ, reason: contains not printable characters */
    public C2375 f1637;

    /* renamed from: ޟ, reason: contains not printable characters */
    public int f1638;

    /* renamed from: ޠ, reason: contains not printable characters */
    public int f1639;

    /* renamed from: ޡ, reason: contains not printable characters */
    public String f1640;

    /* renamed from: ޢ, reason: contains not printable characters */
    public int f1641;

    /* renamed from: ޣ, reason: contains not printable characters */
    public int f1642;

    /* renamed from: ޤ, reason: contains not printable characters */
    public float f1643;

    /* renamed from: ޥ, reason: contains not printable characters */
    public int f1644;

    /* renamed from: ޱ, reason: contains not printable characters */
    public boolean f1645;

    /* renamed from: ߾, reason: contains not printable characters */
    public boolean f1646;

    /* renamed from: ߿, reason: contains not printable characters */
    public int f1647;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public int f1648;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public int f1649;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public int f1650;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public float[] f1651;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public float[] f1652;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public InterfaceC0828 f1653;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public int f1654;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public int f1655;

    /* renamed from: ࡨ, reason: contains not printable characters */
    public int f1656;

    /* renamed from: ࡩ, reason: contains not printable characters */
    public int f1657;

    /* renamed from: ࡪ, reason: contains not printable characters */
    public int f1658;

    /* renamed from: ࢠ, reason: contains not printable characters */
    public boolean f1659;

    /* renamed from: ࢡ, reason: contains not printable characters */
    public boolean f1660;

    /* renamed from: ࢢ, reason: contains not printable characters */
    public boolean f1661;

    /* renamed from: ࢣ, reason: contains not printable characters */
    public AbstractC0827 f1662;

    /* renamed from: ࢤ, reason: contains not printable characters */
    public int f1663;

    /* renamed from: ࢥ, reason: contains not printable characters */
    public OrientationEventListener f1664;

    /* renamed from: ࢦ, reason: contains not printable characters */
    public final Object f1665;

    /* renamed from: ࢧ, reason: contains not printable characters */
    public AbstractC2341.C2343 f1666;

    /* renamed from: ࢨ, reason: contains not printable characters */
    public boolean f1667;

    /* renamed from: ࢩ, reason: contains not printable characters */
    public float f1668;

    /* renamed from: ࢪ, reason: contains not printable characters */
    public float f1669;

    /* renamed from: ࢫ, reason: contains not printable characters */
    public float f1670;

    /* renamed from: ࢬ, reason: contains not printable characters */
    public float f1671;

    /* renamed from: ࢭ, reason: contains not printable characters */
    public C4565 f1672;

    /* renamed from: ࢮ, reason: contains not printable characters */
    public C4565 f1673;

    /* renamed from: ࢯ, reason: contains not printable characters */
    public boolean f1674;

    /* renamed from: ࢰ, reason: contains not printable characters */
    public q5 f1675;

    /* renamed from: ࢱ, reason: contains not printable characters */
    public C2597 f1676;

    /* renamed from: ࢲ, reason: contains not printable characters */
    public q5.InterfaceC2244 f1677;

    /* renamed from: ࢳ, reason: contains not printable characters */
    public C5220.InterfaceC5224 f1678;

    /* renamed from: ࢴ, reason: contains not printable characters */
    public C5220.InterfaceC5225 f1679;

    /* renamed from: ࢶ, reason: contains not printable characters */
    public C5220 f1680;

    /* renamed from: ࢷ, reason: contains not printable characters */
    public long f1681;

    /* renamed from: ࢸ, reason: contains not printable characters */
    public long f1682;

    /* renamed from: ࢹ, reason: contains not printable characters */
    public long f1683;

    /* renamed from: ࢺ, reason: contains not printable characters */
    public long f1684;

    /* renamed from: ࢻ, reason: contains not printable characters */
    public long f1685;

    /* renamed from: ࢼ, reason: contains not printable characters */
    public C4565 f1686;

    /* renamed from: ࢽ, reason: contains not printable characters */
    public C4565 f1687;

    /* renamed from: ࢾ, reason: contains not printable characters */
    public float[] f1688;

    /* renamed from: ࢿ, reason: contains not printable characters */
    public long f1689;

    /* renamed from: ࣀ, reason: contains not printable characters */
    public long f1690;

    /* renamed from: ࣁ, reason: contains not printable characters */
    public boolean f1691;

    /* renamed from: ࣂ, reason: contains not printable characters */
    public C1793 f1692;

    /* renamed from: ࣃ, reason: contains not printable characters */
    public Drawable2d f1693;

    /* renamed from: ࣄ, reason: contains not printable characters */
    public C2390 f1694;

    /* renamed from: ࣅ, reason: contains not printable characters */
    public C2390 f1695;

    /* renamed from: ࣆ, reason: contains not printable characters */
    public C2390 f1696;

    /* renamed from: ࣇ, reason: contains not printable characters */
    public C4327 f1697;

    /* renamed from: ৼ, reason: contains not printable characters */
    public int f1698;

    /* renamed from: ૹ, reason: contains not printable characters */
    public int f1699;

    /* renamed from: ಀ, reason: contains not printable characters */
    public float f1700;

    /* renamed from: ೱ, reason: contains not printable characters */
    public float f1701;

    /* renamed from: ೲ, reason: contains not printable characters */
    public long f1702;

    /* renamed from: ഄ, reason: contains not printable characters */
    public float f1703;

    /* renamed from: ഩ, reason: contains not printable characters */
    public int f1704;

    /* renamed from: ഺ, reason: contains not printable characters */
    public long f1705;

    /* renamed from: ൎ, reason: contains not printable characters */
    public int f1706;

    /* renamed from: ൔ, reason: contains not printable characters */
    public float f1707;

    /* renamed from: ൕ, reason: contains not printable characters */
    public int f1708;

    /* renamed from: com.blink.academy.film.videotools.CameraView$Ϳ, reason: contains not printable characters */
    public class C0794 extends AbstractC0827 {

        /* renamed from: com.blink.academy.film.videotools.CameraView$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC0795 implements Runnable {
            public RunnableC0795() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C4565 filmPreviewFilter = CameraView.this.getFilmPreviewFilter();
                if (filmPreviewFilter != null) {
                    filmPreviewFilter.m11904();
                    filmPreviewFilter.m11918();
                }
            }
        }

        /* renamed from: com.blink.academy.film.videotools.CameraView$Ϳ$Ԩ, reason: contains not printable characters */
        public class RunnableC0796 implements Runnable {
            public RunnableC0796() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C4077 c4077 = C2650.f9865;
                if (c4077 != null) {
                    c4077.m11904();
                    C2650.f9865.m11918();
                }
            }
        }

        /* renamed from: com.blink.academy.film.videotools.CameraView$Ϳ$Ԫ, reason: contains not printable characters */
        public class C0797 extends OrientationEventListener {
            public C0797(Context context) {
                super(context);
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                int i2 = ((i + 45) / 90) * 90;
                if (CameraView.this.f1620 == 1) {
                    i2 = ((i2 + 360) - 270) % 360;
                }
                CameraView.this.m2015(i2);
            }
        }

        public C0794() {
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ϳ */
        public void mo1358(AbstractC2341.C2343 c2343) {
            if (CameraView.this.f1614) {
                C4638.m14099("FilmAudioRecord", String.format("onCameraInitFinished start paused : %s  , isGlDestroy : %s ", Boolean.valueOf(CameraView.this.f1660), Boolean.valueOf(CameraView.this.f1636)));
            }
            if (CameraView.this.f1660 || CameraView.this.f1636) {
                return;
            }
            d1 d1VarM8785 = c2343.m8785();
            C4506 c4506M8784 = c2343.m8784();
            CameraView.this.m2008(d1VarM8785.m12212());
            CameraView.this.setTargetVideoSize(new C2375(d1VarM8785.m12227(), d1VarM8785.m12226()));
            CameraView.this.m2026(d1VarM8785.m12225());
            CameraView.this.m2027(d1VarM8785.m12229());
            CameraView.this.m2032(d1VarM8785.m12231());
            Iterator<C3485> it = C3641.m11713(null).m11726().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C3485 next = it.next();
                if (c4506M8784.m12212().equals(next.m11360())) {
                    CameraView.this.f1659 = next.m11383();
                    break;
                }
            }
            if (CameraView.this.f1620 == 1) {
                CameraView cameraView = CameraView.this;
                cameraView.f1651 = cameraView.m1979(90);
            } else {
                CameraView cameraView2 = CameraView.this;
                cameraView2.f1651 = cameraView2.m1979(0);
            }
            int iM12225 = d1VarM8785.m12225();
            C3891 c3891M13890 = C4535.m13880().m13890();
            if (c3891M13890.m12485() == 2 && iM12225 <= 30) {
                c3891M13890.m12359(0);
                C4535.m13880().m13915();
                CameraView.this.f1621 = 0;
                d1VarM8785.m12239(CameraView.this.f1621);
                if (C2764.m10018().m10029() != 0) {
                    CameraView.this.m2064(new RunnableC0795());
                    C2650.m9790(new RunnableC0796());
                }
            }
            if (C2764.m10018().m10034() != CameraView.this.f1691) {
                CameraView.this.m2038();
            }
            CameraView.this.m1980(c2343);
            if (CameraView.this.f1614) {
                C4638.m14099("FilmAudioRecord", String.format("onCameraInitFinished end  paused : %s , isGlDestroy : %s ", Boolean.valueOf(CameraView.this.f1660), Boolean.valueOf(CameraView.this.f1636)));
            }
            CameraView.this.f1683 = -1L;
            CameraView.this.f1684 = 0L;
            CameraView.this.f1685 = -1L;
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ԩ */
        public void mo1359() {
            if (CameraView.this.f1653 != null) {
                CameraView.this.f1653.mo1359();
            }
        }

        @Override // defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԩ */
        public void mo1360(AbstractC2341.C2344 c2344) {
            if (CameraView.this.f1653 != null) {
                CameraView.this.f1653.mo1360(c2344);
            }
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ԫ */
        public void mo1361(AbstractC2341.C2343 c2343) {
            if (CameraView.this.f1653 != null) {
                CameraView.this.f1653.mo1361(c2343);
            }
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԫ */
        public void mo1362(String str) {
            if (CameraView.this.f1653 != null) {
                CameraView.this.f1653.mo1362(str);
            }
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ԭ */
        public void mo1363(AbstractC2341.C2343 c2343) {
            if (CameraView.this.f1660 || CameraView.this.f1636) {
                return;
            }
            C4506 c4506M8784 = c2343.m8784();
            C2375 c2375M13816 = c4506M8784.m13816();
            C2375 c2375M13815 = c4506M8784.m13815();
            CameraView.this.f1656 = c2375M13816.m8846();
            CameraView.this.f1657 = c2375M13816.m8843();
            CameraView.this.f1654 = c2375M13815.m8846();
            CameraView.this.f1655 = c2375M13815.m8843();
            CameraView.this.f1658 = c4506M8784.m13808();
            if (CameraView.this.f1614) {
                C4638.m14099("CameraView", String.format("mCameraPreviewWidth : %s , mCameraPreviewHeight : %s , mCameraStillWidth : %s , mCameraStillHeight : %s , mCameraOrientation : %s ", Integer.valueOf(CameraView.this.f1656), Integer.valueOf(CameraView.this.f1657), Integer.valueOf(CameraView.this.f1654), Integer.valueOf(CameraView.this.f1655), Integer.valueOf(CameraView.this.f1658)));
            }
            Iterator<C3485> it = C3641.m11713(null).m11726().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C3485 next = it.next();
                if (c4506M8784.m12212().equals(next.m11360())) {
                    CameraView.this.f1659 = next.m11383();
                    break;
                }
            }
            if (CameraView.this.f1620 == 1) {
                CameraView cameraView = CameraView.this;
                cameraView.f1651 = cameraView.m1979(90);
            } else {
                CameraView cameraView2 = CameraView.this;
                cameraView2.f1651 = cameraView2.m1979(0);
            }
            CameraView.this.f1664 = new C0797(CameraView.this.getContext());
            CameraView.this.f1664.enable();
            if (CameraView.this.f1653 != null) {
                CameraView.this.f1653.mo1363(c2343);
            }
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo2047(C4378 c4378) {
            if (CameraView.this.f1661 || c4378 == null) {
                return;
            }
            if (!FinderManager.getInstance().isStart() || C4792.m14375().m14498()) {
                CameraView.this.m1993(c4378, false, System.nanoTime());
            } else {
                CameraView.this.m1969(c4378, false, System.nanoTime());
            }
            CameraView.this.m1995(c4378);
            CameraView cameraView = CameraView.this;
            if (cameraView.f1695 != null && !cameraView.f1636) {
                CameraView cameraView2 = CameraView.this;
                cameraView2.m1994(cameraView2.f1695.m8882());
            }
            if (CameraView.this.f1619 != null) {
                CameraView cameraView3 = CameraView.this;
                if (cameraView3.f1694 == null || cameraView3.f1636) {
                    return;
                }
                SecondScreenPresenter secondScreenPresenter = CameraView.this.f1619;
                int iM8882 = CameraView.this.f1694.m8882();
                C2390 c2390 = CameraView.this.f1694;
                secondScreenPresenter.drawTex(iM8882, c2390.f8945, c2390.f8946);
            }
        }

        @Override // com.blink.academy.film.videotools.CameraView.InterfaceC0828
        /* renamed from: Ԯ */
        public void mo1364() {
            if (CameraView.this.f1653 != null) {
                CameraView.this.f1653.mo1364();
            }
        }

        @Override // com.blink.academy.film.videotools.CameraView.AbstractC0827, defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԯ */
        public void mo1365(AbstractC2341.C2344 c2344) {
            if (CameraView.this.f1653 != null) {
                CameraView.this.f1653.mo1365(c2344);
            }
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$Ԩ, reason: contains not printable characters */
    public class RunnableC0798 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1713;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f1714;

        public RunnableC0798(boolean z, int i) {
            this.f1713 = z;
            this.f1714 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f1713) {
                CameraView.this.f1672.mo11907();
                CameraView.this.f1687.mo11907();
                CameraView cameraView = CameraView.this;
                cameraView.m1971(cameraView.f1686, null);
                return;
            }
            CameraView cameraView2 = CameraView.this;
            cameraView2.f1686 = cameraView2.getFilmPreviewFilter();
            C4565 c4565 = new C4565();
            c4565.m11905(0);
            c4565.m11906();
            c4565.m11918();
            C4565 c45652 = new C4565(this.f1714);
            c45652.m11921(100);
            c45652.m11918();
            CameraView.this.m2031(0.5f, 0.0f, 0.5f, 1.0f);
            CameraView.this.m1971(c4565, c45652);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$Ԫ, reason: contains not printable characters */
    public class RunnableC0799 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C4565 f1716;

        public RunnableC0799(C4565 c4565) {
            this.f1716 = c4565;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraView.this.f1672 != null) {
                CameraView.this.f1672.mo11907();
            }
            CameraView.this.f1672 = this.f1716;
            if (CameraView.this.f1687 != null) {
                CameraView.this.f1687 = null;
            }
            if (CameraView.this.f1673 != null) {
                CameraView.this.f1673.mo11907();
            }
            CameraView.this.f1673 = new C4565();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$Ԭ, reason: contains not printable characters */
    public class RunnableC0800 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C4565 f1718;

        public RunnableC0800(C4565 c4565) {
            this.f1718 = c4565;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraView.this.f1687 != null) {
                CameraView.this.f1687.mo11907();
            }
            CameraView.this.f1687 = this.f1718;
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$Ԯ, reason: contains not printable characters */
    public class RunnableC0801 implements Runnable {
        public RunnableC0801() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.m2039();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ՠ, reason: contains not printable characters */
    public class RunnableC0802 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float f1721;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f1722;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f1723;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ float f1724;

        public RunnableC0802(float f, float f2, float f3, float f4) {
            this.f1721 = f;
            this.f1722 = f2;
            this.f1723 = f3;
            this.f1724 = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView cameraView = CameraView.this;
            cameraView.f1668 = this.f1721;
            cameraView.f1669 = this.f1722;
            cameraView.f1670 = this.f1723;
            cameraView.f1671 = this.f1724;
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ֈ, reason: contains not printable characters */
    public class RunnableC0803 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float f1726;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f1727;

        public RunnableC0803(float f, float f2) {
            this.f1726 = f;
            this.f1727 = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1616.mo8779(this.f1726, this.f1727);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$֏, reason: contains not printable characters */
    public class RunnableC0804 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float f1729;

        public RunnableC0804(float f) {
            this.f1729 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1666.m8785().m12245(CameraView.this.f1703);
            CameraView.this.f1616.mo8773(this.f1729);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ׯ, reason: contains not printable characters */
    public class RunnableC0805 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f1731;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f1732;

        public RunnableC0805(int i, float f) {
            this.f1731 = i;
            this.f1732 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1 d1VarM8785 = CameraView.this.f1666.m8785();
            d1VarM8785.m12246(CameraView.this.f1704);
            d1VarM8785.m12242(CameraView.this.f1705);
            if (this.f1731 == 0 && this.f1732 == 0.0f) {
                CameraView.this.f1616.mo8774(0, 0L);
            } else {
                CameraView.this.f1616.mo8774(this.f1731, (long) (this.f1732 * Math.pow(10.0d, 9.0d)));
            }
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ؠ, reason: contains not printable characters */
    public class RunnableC0806 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1734;

        public RunnableC0806(boolean z) {
            this.f1734 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1734) {
                if (CameraView.this.f1614) {
                    C4638.m14099("CameraController2", String.format("restartCamera : %s ", "reConfigCamera"));
                }
                CameraView.this.m1997();
                return;
            }
            CameraView.this.m2040(CameraView.this.f1637.m8846(), CameraView.this.f1637.m8843());
            AbstractC2341 abstractC2341 = CameraView.this.f1616;
            if (abstractC2341 != null) {
                abstractC2341.mo8780();
            }
            AbstractC2341 abstractC23412 = CameraView.this.f1616;
            if (abstractC23412 != null) {
                abstractC23412.mo8766();
            }
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ހ, reason: contains not printable characters */
    public class RunnableC0807 implements Runnable {
        public RunnableC0807() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1666.m8785().m5911(CameraView.this.f1648);
            if (CameraView.this.f1621 == 0) {
                CameraView.this.f1675.m8057(CameraView.this.f1648);
                if (CameraView.this.f1614) {
                    C4638.m14099("reConfigAudio", String.format("reConfigAudio : %s ", "refreshTimeLapseConfig"));
                }
                CameraView.this.m1986();
                return;
            }
            if (CameraView.this.f1621 == 1) {
                if (CameraView.this.f1614) {
                    C4638.m14099("CameraController2", String.format("restartCamera : %s ", "refreshTimeLapseConfig"));
                }
                CameraView.this.m1997();
            }
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ށ, reason: contains not printable characters */
    public class RunnableC0808 implements Runnable {
        public RunnableC0808() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5220 c5220 = CameraView.this.f1680;
            if (c5220 != null) {
                c5220.m15243();
                CameraView.this.f1680.m15244();
            }
            CameraView.this.m1992();
            if (CameraView.this.f1614) {
                C4638.m14099("CameraController2", String.format("releaseCamera : %s ", "closeCamera"));
            }
            AbstractC2341 abstractC2341 = CameraView.this.f1616;
            if (abstractC2341 != null) {
                abstractC2341.mo8765();
            }
            C3439.f11831.m11208();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ނ, reason: contains not printable characters */
    public class RunnableC0809 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f1738;

        public RunnableC0809(int i) {
            this.f1738 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.m2013(this.f1738);
            d1 d1VarM8785 = CameraView.this.f1666.m8785();
            d1VarM8785.m12243(CameraView.this.f1623);
            CameraView.this.f1616.mo8772(d1VarM8785.m12217());
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ރ, reason: contains not printable characters */
    public class RunnableC0810 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ RectF f1740;

        public RunnableC0810(RectF rectF) {
            this.f1740 = rectF;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1616.mo8775(this.f1740);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ބ, reason: contains not printable characters */
    public class RunnableC0811 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ RectF f1742;

        /* renamed from: com.blink.academy.film.videotools.CameraView$ބ$Ϳ, reason: contains not printable characters */
        public class RunnableC0812 implements Runnable {

            /* renamed from: com.blink.academy.film.videotools.CameraView$ބ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC0813 implements Runnable {
                public RunnableC0813() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RunnableC0811 runnableC0811 = RunnableC0811.this;
                    CameraView.this.f1616.mo8775(runnableC0811.f1742);
                }
            }

            /* renamed from: com.blink.academy.film.videotools.CameraView$ބ$Ϳ$Ԩ, reason: contains not printable characters */
            public class RunnableC0814 implements Runnable {
                public RunnableC0814() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RunnableC0811 runnableC0811 = RunnableC0811.this;
                    CameraView.this.f1616.mo8776(runnableC0811.f1742);
                }
            }

            public RunnableC0812() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView.this.m2065(new RunnableC0813(), 100);
                CameraView.this.m2065(new RunnableC0814(), 300);
            }
        }

        public RunnableC0811(RectF rectF) {
            this.f1742 = rectF;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1616.mo8760(this.f1742, new RunnableC0812());
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ޅ, reason: contains not printable characters */
    public class RunnableC0815 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f1747;

        public RunnableC0815(Runnable runnable) {
            this.f1747 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1616.mo8782();
            Runnable runnable = this.f1747;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ކ, reason: contains not printable characters */
    public class RunnableC0816 implements Runnable {
        public RunnableC0816() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1616.mo8763();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$އ, reason: contains not printable characters */
    public class RunnableC0817 implements Runnable {
        public RunnableC0817() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1704 = 0;
            CameraView.this.f1705 = 0L;
            d1 d1VarM8785 = CameraView.this.f1666.m8785();
            d1VarM8785.m12246(CameraView.this.f1704);
            d1VarM8785.m12242(CameraView.this.f1705);
            CameraView.this.f1616.mo8768();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ވ, reason: contains not printable characters */
    public class RunnableC0818 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f1751;

        public RunnableC0818(int i) {
            this.f1751 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1663 = this.f1751;
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$މ, reason: contains not printable characters */
    public class RunnableC0819 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f1753;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f1754;

        public RunnableC0819(int i, float f) {
            this.f1753 = i;
            this.f1754 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1708 = this.f1753;
            CameraView.this.f1707 = this.f1754;
            d1 d1VarM8785 = CameraView.this.f1666.m8785();
            d1VarM8785.m12254(this.f1753);
            d1VarM8785.m12240(this.f1754);
            CameraView.this.f1616.mo8771(this.f1753);
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ފ, reason: contains not printable characters */
    public class RunnableC0820 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float f1756;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f1757;

        public RunnableC0820(float f, float f2) {
            this.f1756 = f;
            this.f1757 = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1703 = -1.0f;
            CameraView.this.f1704 = 0;
            CameraView.this.f1705 = 0L;
            CameraView.this.f1625 = 2;
            CameraView.this.m2014(this.f1756);
            CameraView.this.m2033(this.f1757);
            if (CameraView.this.f1666 == null) {
                return;
            }
            d1 d1VarM8785 = CameraView.this.f1666.m8785();
            d1VarM8785.m12245(CameraView.this.f1703);
            d1VarM8785.m12246(CameraView.this.f1704);
            d1VarM8785.m12242(CameraView.this.f1705);
            d1VarM8785.m12257(CameraView.this.f1625);
            if (this.f1756 != 0.0f || CameraView.this.f1621 != 0) {
                d1VarM8785.m12244(this.f1756);
                d1VarM8785.m12259(this.f1757);
                CameraView.this.f1616.mo8769(this.f1756, this.f1757);
            } else {
                d1VarM8785.m12244(0.0f);
                d1VarM8785.m12259(1.0f);
                d9.m5921().m5923(this.f1757);
                CameraView.this.f1616.mo8769(0.0f, 1.0f);
            }
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ދ, reason: contains not printable characters */
    public class RunnableC0821 implements Runnable {
        public RunnableC0821() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraView.this.f1614) {
                C4638.m14099("reConfigAudio", String.format("reConfigAudio : %s ", "refreshAudioRecord"));
            }
            CameraView.this.m1986();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ތ, reason: contains not printable characters */
    public class RunnableC0822 implements Runnable {
        public RunnableC0822() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.m2044();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ލ, reason: contains not printable characters */
    public class RunnableC0823 implements Runnable {
        public RunnableC0823() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3439.f11831.m11208();
            if (CameraView.this.f1614) {
                C4638.m14099("FilmAudioRecord", String.format("destroyAllOnCurrentContext : %s ", "end"));
            }
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ގ, reason: contains not printable characters */
    public class RunnableC0824 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1762;

        public RunnableC0824(boolean z) {
            this.f1762 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1762) {
                CameraView.this.f1672.m11904();
                CameraView.this.f1673.m11904();
            } else {
                CameraView.this.f1672.m11920();
                CameraView.this.f1673.m11920();
            }
            CameraView.this.f1672.m11918();
            CameraView.this.f1673.m11918();
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ޏ, reason: contains not printable characters */
    public class RunnableC0825 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1764;

        public RunnableC0825(boolean z) {
            this.f1764 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.f1674 = this.f1764;
            C4638.m14099("MeasureTime", String.format("start record change state : %s", Boolean.valueOf(this.f1764)));
            if (CameraView.this.f1674) {
                CameraView.this.m2036();
            } else {
                CameraView.this.m2037();
            }
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ސ, reason: contains not printable characters */
    public class RunnableC0826 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1766;

        public RunnableC0826(boolean z) {
            this.f1766 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f1766) {
                CameraView.this.f1672.mo11907();
                CameraView cameraView = CameraView.this;
                cameraView.m1971(cameraView.f1687, null);
            } else {
                C4565 filmPreviewFilter = CameraView.this.getFilmPreviewFilter();
                C4565 c4565 = new C4565(0);
                c4565.m11906();
                c4565.m11918();
                CameraView.this.m2031(0.5f, 0.0f, 0.5f, 1.0f);
                CameraView.this.m1971(c4565, filmPreviewFilter);
            }
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ޑ, reason: contains not printable characters */
    public static abstract class AbstractC0827 implements InterfaceC0828 {
        @Override // defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ϳ */
        public void mo1358(AbstractC2341.C2343 c2343) {
        }

        @Override // defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ԩ */
        public void mo1359() {
        }

        @Override // defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ԫ */
        public void mo1361(AbstractC2341.C2343 c2343) {
        }

        @Override // defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԫ */
        public void mo1362(String str) {
        }

        @Override // defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: Ԭ */
        public void mo1363(AbstractC2341.C2343 c2343) {
        }

        @Override // defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԭ */
        public void mo2047(C4378 c4378) {
        }

        @Override // defpackage.AbstractC2341.InterfaceC2342
        /* renamed from: ԯ */
        public void mo1365(AbstractC2341.C2344 c2344) {
        }
    }

    /* renamed from: com.blink.academy.film.videotools.CameraView$ޒ, reason: contains not printable characters */
    public interface InterfaceC0828 extends AbstractC2341.InterfaceC2342 {
        /* renamed from: Ԯ */
        void mo1364();
    }

    public CameraView(Context context) {
        this(context, null);
    }

    private float getAnamorphicRatio() {
        if (this.f1621 != 1) {
            int i = this.f1626;
            if (i == 1) {
                return 1.3333334f;
            }
            if (i == 2) {
                return 1.55f;
            }
        }
        return 1.0f;
    }

    public AbstractC2341 getCamera() {
        return this.f1616;
    }

    public int getCameraHeight() {
        return this.f1657;
    }

    public String getCameraID() {
        return this.f1622;
    }

    public AbstractC2341.C2343 getCameraParams() {
        return this.f1666;
    }

    public int getCameraWidth() {
        return this.f1656;
    }

    public int getCaptureMode() {
        return this.f1621;
    }

    public C3255 getCropRatio() {
        return this.f1635;
    }

    public int getEdgeEnhancementType() {
        return this.f1650;
    }

    public C4565 getFilmPreviewFilter() {
        return this.f1672;
    }

    public int getFlashMode() {
        return this.f1623;
    }

    public float getFocusPercent() {
        return this.f1703;
    }

    public int getISOBiasState() {
        return this.f1624;
    }

    public int getIso() {
        return this.f1704;
    }

    public int getLeicaMode() {
        return this.f1647;
    }

    public int getNoiseReductionType() {
        return this.f1649;
    }

    public int getSelectedExp() {
        return this.f1708;
    }

    public HashMap<C2375, List<Integer>> getSupportedVideoSizeWithFps() {
        return this.f1616.m8761();
    }

    public int getTargetCroppedVideoHeight() {
        return this.f1634;
    }

    public int getTargetCroppedVideoWidth() {
        return this.f1633;
    }

    public int getTargetPreviewFps() {
        return this.f1638;
    }

    public int getTargetVideoFps() {
        return this.f1639;
    }

    public C2375 getTargetVideoSize() {
        return this.f1637;
    }

    public long getTime() {
        return this.f1705;
    }

    public int getTimeLapseTimeMs() {
        return this.f1648;
    }

    public int getVideoBitRateLevel() {
        return this.f1641;
    }

    public String getVideoCodecMime() {
        return this.f1640;
    }

    public int getWhiteBalanceMode() {
        return this.f1625;
    }

    public float getmEVPercent() {
        return this.f1707;
    }

    @Override // com.blink.academy.film.videotools.GLRenderView, android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == 1) {
            this.f1616.mo8778((SurfaceTexture) message.obj);
            return true;
        }
        if (i == 2) {
            this.f1616.mo8777((Surface) message.obj);
            return true;
        }
        if (i != 3) {
            return super.handleMessage(message);
        }
        this.f1616.mo8781();
        return true;
    }

    public void setAudioLevel(float f) {
        this.f1643 = f;
        AbstractC2341.C2343 c2343 = this.f1666;
        if (c2343 != null) {
            c2343.m8785().m5905(this.f1643);
        }
        C5220 c5220 = this.f1680;
        if (c5220 != null) {
            c5220.m15237(f);
        }
    }

    public void setCaptureListener(AbstractC0827 abstractC0827) {
        this.f1653 = abstractC0827;
    }

    public void setCurrentFilter(C4565 c4565) {
        m2064(new RunnableC0799(c4565));
    }

    public void setEVPercent(float f) {
        this.f1707 = f;
    }

    public void setExposureValue(int i) {
        this.f1708 = i;
    }

    public void setFilter(C4327 c4327) {
    }

    public void setFocusPercent(float f) {
        this.f1703 = f;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C4638.m14099("CameraView", String.format("CameraView params:  w=%s , h=%s ", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)));
        super.setLayoutParams(layoutParams);
    }

    public void setMeterAeRegion(RectF rectF) {
        m2064(new RunnableC0810(rectF));
    }

    public void setMeterAfRegion(RectF rectF) {
        m2064(new RunnableC0811(rectF));
    }

    public void setTargetVideoSize(C2375 c2375) {
        this.f1637 = c2375;
    }

    public void setVideoStabilizationModeValue(int i) {
        this.f1706 = i;
        AbstractC2341.C2343 c2343 = this.f1666;
        if (c2343 != null) {
            c2343.m8785().m12256(this.f1706);
        }
    }

    @Override // com.blink.academy.film.videotools.GLRenderView
    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean mo1960() {
        return false;
    }

    @Override // com.blink.academy.film.videotools.GLRenderView
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo1961(int i, int i2) {
        this.f1617.m9215(i, i2);
    }

    @Override // com.blink.academy.film.videotools.GLRenderView
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo1962() {
        C3229 c3229;
        if (this.f1636) {
            return;
        }
        if (this.f1614 && (c3229 = this.f1618) != null) {
            c3229.m10891();
        }
        this.f1636 = true;
        C5220 c5220 = this.f1680;
        if (c5220 != null) {
            c5220.m15243();
            this.f1680.m15244();
        }
        C2390 c2390 = this.f1695;
        if (c2390 != null) {
            c2390.m8880();
            this.f1695 = null;
        }
        C2390 c23902 = this.f1696;
        if (c23902 != null) {
            c23902.m8880();
            this.f1696 = null;
        }
        SecondScreenPresenter secondScreenPresenter = this.f1619;
        if (secondScreenPresenter != null) {
            secondScreenPresenter.destroyFromOther();
        }
        C2390 c23903 = this.f1694;
        if (c23903 != null) {
            c23903.m8880();
            this.f1694 = null;
        }
        C1793 c1793 = this.f1692;
        if (c1793 != null) {
            c1793.mo4800();
            this.f1692 = null;
        }
        m1992();
        q5.m8028();
        C2650.m9792();
        C4565 c4565 = this.f1672;
        if (c4565 != null) {
            c4565.mo11907();
            this.f1672 = null;
        }
        C4565 c45652 = this.f1673;
        if (c45652 != null) {
            c45652.mo11907();
            this.f1673 = null;
        }
        FrameRenderer frameRenderer = this.f1615;
        if (frameRenderer != null) {
            frameRenderer.m2049();
            this.f1615 = null;
        }
        this.f1683 = -1L;
        C2500 c2500 = this.f1617;
        if (c2500 != null) {
            c2500.m9212();
        }
        OrientationEventListener orientationEventListener = this.f1664;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.f1664 = null;
        }
        m1991();
        if (this.f1614) {
            C4638.m14099("FilmAudioRecord", String.format("CameraView :  %s ", "onGLDestroy"));
        }
    }

    @Override // com.blink.academy.film.videotools.GLRenderView
    /* renamed from: Ԭ, reason: contains not printable characters */
    public void mo1963() {
        int i;
        Log.d("GL", "GL_RENDERER = " + GLES20.glGetString(7937));
        Log.d("GL", "GL_VENDOR = " + GLES20.glGetString(7936));
        Log.d("GL", "GL_VERSION = " + GLES20.glGetString(7938));
        Log.i("GL", "GL_EXTENSIONS = " + GLES20.glGetString(7939));
        this.f1804 = true;
        this.f1661 = false;
        this.f1629 = C2579.m9443(getContext());
        this.f1630 = C2579.m9442(getContext());
        this.f1636 = false;
        this.f1683 = -1L;
        long jNanoTime = System.nanoTime();
        C2500 c2500 = new C2500(getContext());
        this.f1617 = c2500;
        this.f1667 = c2500.m9214();
        C4638.m14099("DouYinSDKManager", String.format("init douyin sdk cost : %s ", Long.valueOf((System.nanoTime() - jNanoTime) / 1000000)));
        this.f1672 = new C4565();
        this.f1673 = new C4565();
        this.f1615 = new FrameRenderer();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i2 = layoutParams.width;
        if (i2 == 0 || (i = layoutParams.height) == 0 || i2 == -1 || i == -1) {
            i = 1920;
            i2 = 1080;
        }
        this.f1631 = i2;
        this.f1632 = i;
        m2039();
        if (this.f1614) {
            C3229 c3229 = new C3229();
            this.f1618 = c3229;
            c3229.m10890();
        }
        if (this.f1695 == null) {
            this.f1695 = new C2390(DPXReader.TVINFO_OFFSET, 1080, 6408);
        }
        if (this.f1696 == null) {
            this.f1696 = new C2390(DPXReader.TVINFO_OFFSET, 1080, 6408);
        }
        if (C4792.m14375().m14498()) {
            this.f1694 = new C2390(1080, DPXReader.TVINFO_OFFSET, 6408);
        } else {
            this.f1694 = new C2390(DPXReader.TVINFO_OFFSET, 1080, 6408);
        }
        this.f1692 = new C1793();
        this.f1693 = new Drawable2d();
        if (this.f1697 == null) {
            C4327 c4327 = new C4327();
            this.f1697 = c4327;
            c4327.m13477();
        }
        m1985(i2, i);
    }

    @Override // com.blink.academy.film.videotools.GLRenderView
    /* renamed from: ԭ, reason: contains not printable characters */
    public void mo1964() {
    }

    @Override // com.blink.academy.film.videotools.GLRenderView
    /* renamed from: Ԯ, reason: contains not printable characters */
    public void mo1965(double d) {
    }

    @Override // com.blink.academy.film.videotools.GLRenderView
    /* renamed from: ՠ, reason: contains not printable characters */
    public void mo1966() {
        AbstractC2341 abstractC2341 = this.f1616;
        if (abstractC2341 != null) {
            abstractC2341.mo8767();
        }
    }

    @Override // com.blink.academy.film.videotools.GLRenderView
    /* renamed from: ֈ, reason: contains not printable characters */
    public void mo1967() {
        super.mo1967();
        this.f1660 = true;
        C5220 c5220 = this.f1680;
        if (c5220 != null) {
            c5220.m15243();
            this.f1680.m15244();
        }
    }

    @Override // com.blink.academy.film.videotools.GLRenderView
    /* renamed from: ֏, reason: contains not printable characters */
    public void mo1968() {
        super.mo1968();
        this.f1660 = false;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m1969(C4378 c4378, boolean z, double d) {
        int iM9216;
        int i;
        int i2;
        float anamorphicRatio;
        int i3;
        if (c4378 == null) {
            Log.d("CameraView", "cameraview has no surfacetexture?");
            return;
        }
        System.nanoTime();
        int i4 = this.f1639;
        if (i4 < 30 && (i3 = this.f1638) != i4) {
            if (this.f1689 == 0) {
                this.f1689 = i3;
            }
            long j = this.f1705;
            if (j == 0) {
                this.f1690 = i3;
            } else {
                long jRound = Math.round(1.0E9d / j);
                this.f1690 = jRound;
                int i5 = this.f1638;
                if (jRound > i5) {
                    this.f1690 = i5;
                }
            }
            long j2 = this.f1690;
            if (j2 != this.f1689) {
                this.f1689 = j2;
                this.f1683 = -1L;
            }
            if (this.f1683 == -1) {
                this.f1683 = System.nanoTime();
                this.f1681 = 0L;
                this.f1682 = 0L;
            }
            long j3 = this.f1682 + 1;
            this.f1682 = j3;
            long j4 = this.f1689;
            int i6 = this.f1639;
            if (j4 != i6) {
                long j5 = ((j3 % j4) * i6) / j4;
                if (j4 != 1 && j5 == this.f1685) {
                    c4378.m13551().updateTexImage();
                    return;
                }
                this.f1685 = j5;
            }
            this.f1681++;
            long jNanoTime = System.nanoTime() - this.f1683;
            if (jNanoTime > 2000000000) {
                this.f1684 = (this.f1681 * 1000000000) / jNanoTime;
            }
        }
        this.f1809.m11957(this.f1810);
        C3732.m11943("cameraview before render");
        C3732.m11943("before updateTexImage");
        SurfaceTexture surfaceTextureM13551 = c4378.m13551();
        int i7 = c4378.f15063;
        int i8 = c4378.f15062;
        surfaceTextureM13551.updateTexImage();
        surfaceTextureM13551.getTransformMatrix(this.f1652);
        C3732.m11943("after updateTexImage");
        long timestamp = surfaceTextureM13551.getTimestamp();
        if (timestamp == 0) {
            timestamp = SystemClock.elapsedRealtimeNanos();
        }
        long j6 = timestamp;
        float[] fArr = this.f1652;
        float fAbs = Math.abs(fArr[0] + fArr[1]);
        float[] fArr2 = this.f1652;
        float fAbs2 = Math.abs(fArr2[4] + fArr2[5]);
        int iFloor = (int) Math.floor(i8 * fAbs);
        int iFloor2 = (int) Math.floor(i7 * fAbs2);
        int i9 = iFloor + (iFloor % 2);
        int i10 = iFloor2 + (iFloor2 % 2);
        this.f1695.m8878();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1672.m11908().mo9491(i9, i10);
        int iM13552 = c4378.m13552();
        if (this.f1691) {
            this.f1617.m9215(c4378.f15062, c4378.f15063);
            this.f1617.m9217(this.f1659);
            Rotation rotation = this.f1620 == 1 ? Rotation.ROTATION_270 : Rotation.NORMAL;
            this.f1617.m9218(this.f1663);
            iM9216 = this.f1617.m9216(iM13552, TextureFormat.f5095, this.f1656, this.f1657, this.f1658, this.f1659, rotation, c4378.m13551().getTimestamp());
        } else {
            iM9216 = iM13552;
        }
        float fM5922 = 1.0f / d9.m5921().m5922();
        if (this.f1691 && C2764.m10018().m10024() != 0.0f) {
            fM5922 = 1.0f / (d9.m5921().m5922() + 0.05f);
        }
        Matrix.setIdentityM(this.f1688, 0);
        if (fM5922 != 1.0f) {
            float f = (1.0f - fM5922) * 0.5f;
            Matrix.translateM(this.f1688, 0, f, f, 0.0f);
            Matrix.scaleM(this.f1688, 0, fM5922, fM5922, 0.0f);
        }
        this.f1672.m13992(this.f1688);
        this.f1673.m13992(this.f1688);
        C3606 c3606M11908 = this.f1672.m11908();
        int i11 = this.f1657;
        int i12 = this.f1656;
        this.f1698 = 0;
        int iM1978 = m1978(i12);
        C2390 c2390 = this.f1695;
        if (iM1978 != c2390.f8945) {
            c2390.m8880();
            this.f1695 = new C2390(m1978(i12), m1977(i11), 6408);
        }
        int iM19782 = m1978(i12);
        C2390 c23902 = this.f1696;
        if (iM19782 != c23902.f8945) {
            c23902.m8880();
            this.f1696 = new C2390(m1978(i12), m1977(i11), 6408);
        }
        C2390 c23903 = this.f1695;
        int i13 = c23903.f8945;
        int i14 = c23903.f8946;
        int i15 = (int) (i14 / 1.0f);
        int i16 = i15 - (i15 % 2);
        this.f1699 = (i14 - i16) / 2;
        if (this.f1620 == 1) {
            i = i13;
            i14 = i16;
        } else {
            this.f1699 = 0;
            int i17 = (int) (i13 / 1.0f);
            i = i17 - (i17 % 2);
            this.f1698 = (i13 - i) / 2;
        }
        int i18 = (int) 1080.0f;
        int i19 = i18 - (i18 % 2);
        System.nanoTime();
        FrameRenderer frameRenderer = this.f1615;
        int iM8881 = this.f1695.m8881();
        int i20 = this.f1698;
        int i21 = this.f1699;
        frameRenderer.m2051(true, iM8881, i20, i21, i, i14, i20, i21, i, i14, this.f1673.m11908(), iM9216, i12, i11, i9, i10, DPXReader.TVINFO_OFFSET, i19, this.f1651, this.f1659, m1981());
        this.f1695.m8884();
        FrameRenderer frameRenderer2 = this.f1615;
        int iM88812 = this.f1696.m8881();
        int i22 = this.f1698;
        int i23 = this.f1699;
        frameRenderer2.m2051(true, iM88812, i22, i23, i, i14, i22, i23, i, i14, c3606M11908, iM9216, i12, i11, i9, i10, DPXReader.TVINFO_OFFSET, i19, this.f1651, this.f1659, m1981());
        C4565 c4565 = this.f1687;
        if (c4565 != null) {
            C3606 c3606M119082 = c4565.m11908();
            c3606M119082.mo9491(i9, i10);
            this.f1687.m13992(this.f1688);
            FrameRenderer frameRenderer3 = this.f1615;
            int iM88813 = this.f1696.m8881();
            int i24 = this.f1698;
            int i25 = this.f1699;
            float f2 = this.f1668;
            C2390 c23904 = this.f1695;
            int i26 = c23904.f8945;
            int i27 = (int) (f2 * i26);
            float f3 = this.f1669;
            int i28 = c23904.f8946;
            frameRenderer3.m2051(false, iM88813, i24, i25, i, i14, i27, (int) (f3 * i28), (int) (this.f1670 * i26), (int) (this.f1671 * i28), c3606M119082, iM9216, i12, i11, i9, i10, DPXReader.TVINFO_OFFSET, i19, this.f1651, this.f1659, m1981());
        }
        System.nanoTime();
        this.f1696.m8884();
        if (m1982()) {
            anamorphicRatio = getAnamorphicRatio();
            i2 = 0;
        } else {
            i2 = 0;
            anamorphicRatio = 1.0f;
        }
        this.f1698 = i2;
        C2390 c23905 = this.f1694;
        int i29 = c23905.f8945;
        int i30 = c23905.f8946;
        int i31 = (int) (i30 / anamorphicRatio);
        int i32 = i31 - (i31 % 2);
        this.f1699 = (i30 - i32) / 2;
        c23905.m8878();
        GLES20.glViewport(this.f1698, this.f1699, i29, i32);
        GLES20.glScissor(this.f1698, this.f1699, i29, i32);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1697.m13479(this.f1696.m8882(), ACHelper.getInstance().getGLCubeBuffer(), ACHelper.getInstance().getGLTextureBuffer());
        this.f1694.m8884();
        GLES20.glViewport(0, 0, this.f1806, this.f1807);
        GLES20.glScissor(0, 0, this.f1806, this.f1807);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1692.mo4809(this.f1694.m8882(), this.f1693);
        EGLSurface eGLSurface = this.f1810;
        if (eGLSurface != null) {
            this.f1809.m11960(eGLSurface);
        }
        if (this.f1691 && this.f1621 == 0) {
            this.f1675.m8035(i12, i11, iM9216, j6);
        }
        C3439.f11831.m11210();
        System.nanoTime();
        if (this.f1614) {
            this.f1618.m10888();
        }
    }

    /* renamed from: ࢨ, reason: contains not printable characters */
    public final void m1970(C4565 c4565, int i) {
        if (i == -1) {
            c4565.m13988(false);
            c4565.m13989(false);
        } else if (i == 0) {
            c4565.m13989(true);
        } else if (i == 1) {
            c4565.m13987(true);
        } else {
            if (i != 2) {
                return;
            }
            c4565.m13988(true);
        }
    }

    /* renamed from: ࢩ, reason: contains not printable characters */
    public void m1971(C4565 c4565, C4565 c45652) {
        this.f1672 = c4565;
        this.f1687 = c45652;
    }

    /* renamed from: ࢪ, reason: contains not printable characters */
    public void m1972(float f) {
        this.f1703 = f;
        m2064(new RunnableC0804(f));
    }

    /* renamed from: ࢫ, reason: contains not printable characters */
    public void m1973(int i, float f) {
        this.f1704 = i;
        this.f1705 = (long) (f * Math.pow(10.0d, 9.0d));
        m2064(new RunnableC0805(i, f));
    }

    /* renamed from: ࢬ, reason: contains not printable characters */
    public void m1974(boolean z) {
        m2064(new RunnableC0825(z));
    }

    /* renamed from: ࢭ, reason: contains not printable characters */
    public void m1975(float f, float f2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C4638.m14099("cccccc", "t:" + (jCurrentTimeMillis - this.f1702) + "  zoom:" + f2);
        this.f1702 = jCurrentTimeMillis;
        this.f1700 = f;
        this.f1701 = f2;
        d1 d1VarM8785 = this.f1666.m8785();
        if (f == 0.0f && this.f1621 == 0) {
            d9.m5921().m5923(f2);
            d1VarM8785.m12244(0.0f);
            d1VarM8785.m12259(1.0f);
            C4638.m14099("CameraView", String.format("zoom : %s ", Float.valueOf(f2)));
            return;
        }
        d1VarM8785.m12244(f);
        d1VarM8785.m12259(this.f1701);
        d9.m5921().m5923(1.0f);
        m2064(new RunnableC0803(f, f2));
    }

    /* renamed from: ࢮ, reason: contains not printable characters */
    public void m1976() {
        m2064(new RunnableC0808());
    }

    /* renamed from: ࢯ, reason: contains not printable characters */
    public final int m1977(int i) {
        return ACHelper.getInstance().isSpeed() ? Math.min(720, i) : Math.min(1080, i);
    }

    /* renamed from: ࢰ, reason: contains not printable characters */
    public final int m1978(int i) {
        return ACHelper.getInstance().isSpeed() ? Math.min(LogType.UNEXP_ANR, i) : Math.min(DPXReader.TVINFO_OFFSET, i);
    }

    /* renamed from: ࢱ, reason: contains not printable characters */
    public float[] m1979(int i) {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, i, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArr, 0, this.f1659 ? -1.0f : 1.0f, 1.0f, 1.0f);
        Matrix.rotateM(fArr, 0, -this.f1658, 0.0f, 0.0f, 1.0f);
        for (int i2 = 0; i2 < 16; i2++) {
            fArr[i2] = Math.round(fArr[i2]);
        }
        return fArr;
    }

    /* renamed from: ࢲ, reason: contains not printable characters */
    public final void m1980(AbstractC2341.C2343 c2343) {
        int i;
        m1992();
        d1 d1VarM8785 = c2343.m8785();
        int iM12227 = d1VarM8785.m12227();
        int iM12226 = d1VarM8785.m12226();
        if (m1982()) {
            int anamorphicRatio = (int) (iM12226 / getAnamorphicRatio());
            i = anamorphicRatio - (anamorphicRatio % 2);
        } else {
            i = iM12226;
        }
        int iM12229 = d1VarM8785.m12229();
        int iM5903 = d1VarM8785.m5903();
        String strM5904 = d1VarM8785.m5904();
        String str = (strM5904.equalsIgnoreCase("video/avc") && C3444.m11227().m11261(iM12227, 0, iM12229)) ? "video/hevc" : strM5904;
        boolean zEqualsIgnoreCase = "video/hevc".equalsIgnoreCase(str);
        d1VarM8785.m12225();
        int iM10145 = C2811.m10145(iM12227, iM12226, iM5903, iM12229, zEqualsIgnoreCase ? 1 : 0);
        int iM5902 = d1VarM8785.m5902();
        int iM5901 = d1VarM8785.m5901();
        int iM5900 = d1VarM8785.m5900();
        if (iM5901 == 0 || iM5900 == 0 || !C3444.m11227().m11256()) {
            iM5900 = i;
            iM5901 = iM12227;
        }
        if (this.f1621 == 1) {
            int iM10142 = iM12226 > 1080 ? C2811.m10142() : iM12226 > 720 ? C2811.m10141() : C2811.m10143();
            if (this.f1614) {
                C4638.m14099("CameraView", String.format("previewHeight : %s , recommendBitrate : %s , mul : %s", Integer.valueOf(iM12226), Integer.valueOf(iM10142), Integer.valueOf(iM10145)));
            }
            if (iM10145 > iM10142) {
                iM10145 = iM10142;
            }
        }
        if (iM12229 == 6) {
            iM10145 *= 4;
        }
        a2 a2Var = new a2(iM5901, iM5900, iM10145, iM12229, iM12229, iM5902, str, this.f1801, EGL14.eglGetCurrentContext(), iM12227, iM12226, m1982(), getAnamorphicRatio(), this.f1620 == 2, this.f1658, m1983());
        boolean z = iM5902 == 0;
        if (this.f1645) {
            z = false;
        }
        boolean zM13055 = C4112.m13055();
        if (z) {
            z = zM13055;
        }
        int iM5898 = d1VarM8785.m5898();
        int iM5896 = d1VarM8785.m5896();
        float fM5897 = d1VarM8785.m5897();
        int iM5899 = d1VarM8785.m5899();
        int iM12224 = d1VarM8785.m12224();
        boolean zM12234 = d1VarM8785.m12234();
        if (iM5899 == 2) {
            iM5898 = 8000;
        }
        C5220.C5226 c5226 = new C5220.C5226(iM5898, iM5896, fM5897, iM5899, iM12224, false, zM12234);
        if (this.f1621 != 0) {
            this.f1680.m15238(null);
            this.f1680.m15243();
            C5220.InterfaceC5224 interfaceC5224 = this.f1678;
            if (interfaceC5224 != null) {
                interfaceC5224.mo1333(-1.0d, -1.0d, false);
            }
            C2597 c2597 = new C2597(z, this.f1659, a2Var, c5226);
            this.f1676 = c2597;
            InterfaceC0828 interfaceC0828 = this.f1653;
            if (interfaceC0828 != null) {
                c2597.m9532(interfaceC0828);
            }
            this.f1676.m9531(this.f1678);
            this.f1676.m9535(this.f1679);
            this.f1676.m9533(this.f1677);
            return;
        }
        if (this.f1614) {
            C4638.m14099("FilmAudioRecord", String.format("initVideoEncoder :  %s ", "restart"));
        }
        if (z) {
            this.f1680.m15238(this.f1678);
            this.f1680.m15235(c5226);
        } else {
            this.f1680.m15238(null);
            this.f1680.m15243();
            C5220.InterfaceC5224 interfaceC52242 = this.f1678;
            if (interfaceC52242 != null) {
                interfaceC52242.mo1333(-1.0d, -1.0d, false);
            }
        }
        this.f1680.m15239(this.f1679);
        q5 q5Var = new q5(z, this.f1659, m1981(), this.f1680, a2Var, c5226);
        this.f1675 = q5Var;
        InterfaceC0828 interfaceC08282 = this.f1653;
        if (interfaceC08282 != null) {
            q5Var.m8055(interfaceC08282);
        }
        this.f1675.m8056(this.f1677);
    }

    /* renamed from: ࢳ, reason: contains not printable characters */
    public boolean m1981() {
        return this.f1627 && this.f1621 != 1;
    }

    /* renamed from: ࢴ, reason: contains not printable characters */
    public boolean m1982() {
        int i;
        return this.f1621 != 1 && ((i = this.f1626) == 1 || i == 2);
    }

    /* renamed from: ࢶ, reason: contains not printable characters */
    public boolean m1983() {
        return this.f1628;
    }

    /* renamed from: ࢷ, reason: contains not printable characters */
    public void m1984() {
        m2064(new RunnableC0816());
    }

    /* renamed from: ࢸ, reason: contains not printable characters */
    public final void m1985(int i, int i2) {
        int iM8846;
        int iM8843;
        C2375 c2375 = this.f1637;
        if (c2375 != null) {
            iM8846 = c2375.m8846();
            iM8843 = this.f1637.m8843();
        } else {
            iM8846 = DPXReader.TVINFO_OFFSET;
            iM8843 = 1080;
        }
        this.f1666 = new AbstractC2341.C2343();
        m2040(iM8846, iM8843);
        if (this.f1614) {
            C4638.m14099("CameraController2", String.format("releaseCamera : %s ", "openCamera"));
        }
        AbstractC2341 abstractC2341 = this.f1616;
        if (abstractC2341 != null) {
            abstractC2341.mo8765();
            this.f1616 = null;
        }
        C3835 c3835 = new C3835(this.f1666, this.f1801, this.f1662);
        this.f1616 = c3835;
        c3835.mo8762();
    }

    /* renamed from: ࢹ, reason: contains not printable characters */
    public final void m1986() {
        if (this.f1614) {
            C4638.m14099("reConfigAudio", String.format("reConfigAudio : %s ", "reConfigAudio"));
        }
        d1 d1VarM8785 = this.f1666.m8785();
        int iM5898 = d1VarM8785.m5898();
        int iM5896 = d1VarM8785.m5896();
        float fM5897 = d1VarM8785.m5897();
        int iM5899 = d1VarM8785.m5899();
        int iM12224 = d1VarM8785.m12224();
        boolean zM12234 = d1VarM8785.m12234();
        d1VarM8785.m12225();
        d1VarM8785.m12229();
        boolean z = d1VarM8785.m5902() == 0;
        if (this.f1645) {
            z = false;
        }
        boolean zM13055 = C4112.m13055();
        if (z) {
            z = zM13055;
        }
        if (iM5899 == 2) {
            iM5898 = 8000;
        }
        C5220.C5226 c5226 = new C5220.C5226(iM5898, iM5896, fM5897, iM5899, iM12224, false, zM12234);
        if (this.f1621 != 0) {
            if (this.f1676 == null) {
                return;
            }
            this.f1680.m15238(null);
            this.f1680.m15243();
            this.f1680.m15244();
            C5220.InterfaceC5224 interfaceC5224 = this.f1678;
            if (interfaceC5224 != null) {
                interfaceC5224.mo1333(-1.0d, -1.0d, false);
            }
            this.f1676.m9535(this.f1679);
            this.f1676.m9528(c5226);
            return;
        }
        if (this.f1675 == null) {
            return;
        }
        if (this.f1614) {
            C4638.m14099("FilmAudioRecord", String.format("reConfigAudio :  %s ", "restart"));
        }
        if (z) {
            this.f1680.m15238(this.f1678);
            this.f1680.m15235(c5226);
        } else {
            this.f1680.m15238(null);
            this.f1680.m15243();
            this.f1680.m15244();
            C5220.InterfaceC5224 interfaceC52242 = this.f1678;
            if (interfaceC52242 != null) {
                interfaceC52242.mo1333(-1.0d, -1.0d, false);
            }
        }
        this.f1680.m15239(this.f1679);
        this.f1675.m8063(c5226, z, fM5897);
    }

    /* renamed from: ࢺ, reason: contains not printable characters */
    public void m1987(boolean z) {
        m2064(new RunnableC0806(z));
    }

    /* renamed from: ࢻ, reason: contains not printable characters */
    public void m1988() {
        if (this.f1675 == null && this.f1676 == null) {
            return;
        }
        d1 d1VarM8785 = this.f1666.m8785();
        d1VarM8785.m5907(this.f1644);
        d1VarM8785.m12236(this.f1646);
        m2064(new RunnableC0821());
    }

    /* renamed from: ࢼ, reason: contains not printable characters */
    public void m1989() {
        m2038();
    }

    /* renamed from: ࢽ, reason: contains not printable characters */
    public void m1990() {
        m2064(new RunnableC0807());
    }

    /* renamed from: ࢾ, reason: contains not printable characters */
    public void m1991() {
        if (this.f1614) {
            C4638.m14099("FilmAudioRecord", String.format("releaseCamera : %s ", "releaseCamera"));
        }
        AbstractC2341 abstractC2341 = this.f1616;
        if (abstractC2341 != null) {
            abstractC2341.mo8765();
        }
        m2064(new RunnableC0823());
    }

    /* renamed from: ࢿ, reason: contains not printable characters */
    public final void m1992() {
        int i = this.f1621;
        if (i == 0) {
            q5 q5Var = this.f1675;
            if (q5Var != null) {
                q5Var.m8061();
                this.f1675.m8053();
                this.f1675 = null;
            }
            C2597 c2597 = this.f1676;
            if (c2597 != null) {
                c2597.m9538();
                this.f1676.m9529();
                this.f1676.m9539();
                this.f1676 = null;
                return;
            }
            return;
        }
        if (i == 1) {
            q5 q5Var2 = this.f1675;
            if (q5Var2 != null) {
                q5Var2.m8061();
                this.f1675.m8053();
                this.f1675 = null;
            }
            C2597 c25972 = this.f1676;
            if (c25972 != null) {
                c25972.m9538();
                this.f1676.m9529();
                this.f1676.m9539();
                this.f1676 = null;
            }
        }
    }

    /* renamed from: ࣀ, reason: contains not printable characters */
    public void m1993(C4378 c4378, boolean z, double d) {
        int iM9216;
        int i;
        int i2;
        if (c4378 == null) {
            Log.d("CameraView", "cameraview has no surfacetexture?");
            return;
        }
        System.nanoTime();
        int i3 = this.f1639;
        if (i3 < 30 && (i2 = this.f1638) != i3) {
            if (this.f1689 == 0) {
                this.f1689 = i2;
            }
            long j = this.f1705;
            if (j == 0) {
                this.f1690 = i2;
            } else {
                long jRound = Math.round(1.0E9d / j);
                this.f1690 = jRound;
                int i4 = this.f1638;
                if (jRound > i4) {
                    this.f1690 = i4;
                }
            }
            long j2 = this.f1690;
            if (j2 != this.f1689) {
                this.f1689 = j2;
                this.f1683 = -1L;
            }
            if (this.f1683 == -1) {
                this.f1683 = System.nanoTime();
                this.f1681 = 0L;
                this.f1682 = 0L;
            }
            long j3 = this.f1682 + 1;
            this.f1682 = j3;
            long j4 = this.f1689;
            int i5 = this.f1639;
            if (j4 != i5) {
                long j5 = ((j3 % j4) * i5) / j4;
                if (j4 != 1 && j5 == this.f1685) {
                    c4378.m13551().updateTexImage();
                    return;
                }
                this.f1685 = j5;
            }
            this.f1681++;
            long jNanoTime = System.nanoTime() - this.f1683;
            if (jNanoTime > 2000000000) {
                this.f1684 = (this.f1681 * 1000000000) / jNanoTime;
            }
        }
        this.f1809.m11957(this.f1810);
        C3732.m11943("cameraview before render");
        C3732.m11943("before updateTexImage");
        SurfaceTexture surfaceTextureM13551 = c4378.m13551();
        int i6 = c4378.f15063;
        int i7 = c4378.f15062;
        surfaceTextureM13551.updateTexImage();
        surfaceTextureM13551.getTransformMatrix(this.f1652);
        C3732.m11943("after updateTexImage");
        long timestamp = surfaceTextureM13551.getTimestamp();
        if (timestamp == 0) {
            timestamp = SystemClock.elapsedRealtimeNanos();
        }
        long j6 = timestamp;
        float[] fArr = this.f1652;
        float fAbs = Math.abs(fArr[0] + fArr[1]);
        float[] fArr2 = this.f1652;
        float fAbs2 = Math.abs(fArr2[4] + fArr2[5]);
        int iFloor = (int) Math.floor(i7 * fAbs);
        int iFloor2 = (int) Math.floor(i6 * fAbs2);
        int i8 = iFloor + (iFloor % 2);
        int i9 = iFloor2 + (iFloor2 % 2);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.f1806, this.f1807);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1672.m11908().mo9491(i8, i9);
        int iM13552 = c4378.m13552();
        if (this.f1691) {
            this.f1617.m9215(c4378.f15062, c4378.f15063);
            this.f1617.m9217(this.f1659);
            Rotation rotation = this.f1620 == 1 ? Rotation.ROTATION_270 : Rotation.NORMAL;
            this.f1617.m9218(this.f1663);
            iM9216 = this.f1617.m9216(iM13552, TextureFormat.f5095, this.f1656, this.f1657, this.f1658, this.f1659, rotation, c4378.m13551().getTimestamp());
        } else {
            iM9216 = iM13552;
        }
        float fM5922 = 1.0f / d9.m5921().m5922();
        if (this.f1691 && C2764.m10018().m10024() != 0.0f) {
            fM5922 = 1.0f / (d9.m5921().m5922() + 0.05f);
        }
        Matrix.setIdentityM(this.f1688, 0);
        if (fM5922 != 1.0f) {
            float f = (1.0f - fM5922) * 0.5f;
            Matrix.translateM(this.f1688, 0, f, f, 0.0f);
            Matrix.scaleM(this.f1688, 0, fM5922, fM5922, 0.0f);
        }
        this.f1672.m13992(this.f1688);
        C3606 c3606M11908 = this.f1672.m11908();
        int i10 = this.f1657;
        int i11 = this.f1656;
        float anamorphicRatio = m1982() ? getAnamorphicRatio() : 1.0f;
        this.f1698 = 0;
        C2390 c2390 = this.f1694;
        int i12 = c2390.f8945;
        int i13 = c2390.f8946;
        int i14 = (int) (i13 / anamorphicRatio);
        int i15 = i14 - (i14 % 2);
        this.f1699 = (i13 - i15) / 2;
        if (this.f1620 == 1) {
            i = i12;
            i13 = i15;
        } else {
            this.f1699 = 0;
            int i16 = (int) (i12 / anamorphicRatio);
            i = i16 - (i16 % 2);
            this.f1698 = (i12 - i) / 2;
        }
        int i17 = (int) (1080.0f / anamorphicRatio);
        int i18 = i17 - (i17 % 2);
        System.nanoTime();
        FrameRenderer frameRenderer = this.f1615;
        int iM8881 = this.f1694.m8881();
        int i19 = this.f1698;
        int i20 = this.f1699;
        frameRenderer.m2051(true, iM8881, i19, i20, i, i13, i19, i20, i, i13, c3606M11908, iM9216, i11, i10, i8, i9, DPXReader.TVINFO_OFFSET, i18, this.f1651, this.f1659, m1981());
        C4565 c4565 = this.f1687;
        if (c4565 != null) {
            C3606 c3606M119082 = c4565.m11908();
            c3606M119082.mo9491(i8, i9);
            this.f1687.m13992(this.f1688);
            FrameRenderer frameRenderer2 = this.f1615;
            int iM88812 = this.f1694.m8881();
            int i21 = this.f1698;
            int i22 = this.f1699;
            float f2 = this.f1668;
            C2390 c23902 = this.f1694;
            int i23 = c23902.f8945;
            float f3 = this.f1669;
            int i24 = c23902.f8946;
            frameRenderer2.m2051(false, iM88812, i21, i22, i, i13, (int) (f2 * i23), (int) (f3 * i24), (int) (this.f1670 * i23), (int) (this.f1671 * i24), c3606M119082, iM9216, i11, i10, i8, i9, DPXReader.TVINFO_OFFSET, i18, this.f1651, this.f1659, m1981());
        }
        System.nanoTime();
        this.f1694.m8884();
        GLES20.glViewport(0, 0, this.f1806, this.f1807);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1692.mo4809(this.f1694.m8882(), this.f1693);
        EGLSurface eGLSurface = this.f1810;
        if (eGLSurface != null) {
            this.f1809.m11960(eGLSurface);
        }
        if (this.f1691 && this.f1621 == 0) {
            this.f1675.m8035(i11, i10, iM9216, j6);
        }
        C3439.f11831.m11210();
        System.nanoTime();
        if (this.f1614) {
            this.f1618.m10888();
        }
    }

    /* renamed from: ࣁ, reason: contains not printable characters */
    public final void m1994(int i) {
        ConnectionManager.getInstance().renderFrameEncoder(i, this.f1621 == 1 ? 0 : this.f1626);
    }

    /* renamed from: ࣂ, reason: contains not printable characters */
    public final void m1995(C4378 c4378) {
        if (c4378 == null) {
            if (this.f1614) {
                Log.d("CameraView", "cameraview has no surfacetexture?");
            }
        } else {
            if (this.f1636) {
                return;
            }
            C2650.m9793(c4378.m13552(), this.f1659, this.f1620 == 2, m1981(), this.f1658);
            C2650.m9787();
        }
    }

    /* renamed from: ࣃ, reason: contains not printable characters */
    public void m1996(Runnable runnable) {
        m2066("twoFilterChange", runnable);
    }

    /* renamed from: ࣄ, reason: contains not printable characters */
    public final void m1997() {
        m1992();
        if (this.f1614) {
            C4638.m14099("CameraController2", String.format("releaseCamera : %s ", "restartCamera"));
        }
        AbstractC2341 abstractC2341 = this.f1616;
        if (abstractC2341 != null) {
            abstractC2341.mo8765();
            this.f1616 = null;
        }
        C3439.f11831.m11208();
        m1985(this.f1631, this.f1632);
    }

    /* renamed from: ࣅ, reason: contains not printable characters */
    public CameraView m1998(boolean z) {
        this.f1627 = z;
        return this;
    }

    /* renamed from: ࣆ, reason: contains not printable characters */
    public CameraView m1999(int i) {
        this.f1626 = i;
        return this;
    }

    /* renamed from: ࣇ, reason: contains not printable characters */
    public CameraView m2000(C4565 c4565) {
        m2064(new RunnableC0800(c4565));
        return this;
    }

    /* renamed from: ৼ, reason: contains not printable characters */
    public CameraView m2001(boolean z) {
        this.f1646 = z;
        return this;
    }

    /* renamed from: ૹ, reason: contains not printable characters */
    public CameraView m2002(C5220.InterfaceC5224 interfaceC5224) {
        this.f1678 = interfaceC5224;
        return this;
    }

    /* renamed from: ಀ, reason: contains not printable characters */
    public CameraView m2003(C5220.InterfaceC5225 interfaceC5225) {
        this.f1679 = interfaceC5225;
        return this;
    }

    /* renamed from: ೱ, reason: contains not printable characters */
    public CameraView m2004(int i) {
        this.f1642 = i;
        return this;
    }

    /* renamed from: ೲ, reason: contains not printable characters */
    public CameraView m2005(int i) {
        this.f1644 = i;
        return this;
    }

    /* renamed from: ഄ, reason: contains not printable characters */
    public void m2006(float f, float f2) {
        if (this.f1614) {
            C4638.m14099("slimmm", "length:" + f + " zoomRatio:" + f2);
        }
        m2064(new RunnableC0820(f, f2));
    }

    /* renamed from: ഩ, reason: contains not printable characters */
    public void m2007() {
        m2064(new RunnableC0817());
    }

    /* renamed from: ഺ, reason: contains not printable characters */
    public CameraView m2008(String str) {
        this.f1622 = str;
        return this;
    }

    /* renamed from: ൎ, reason: contains not printable characters */
    public CameraView m2009(int i) {
        this.f1621 = i;
        return this;
    }

    /* renamed from: ൔ, reason: contains not printable characters */
    public CameraView m2010(q5.InterfaceC2244 interfaceC2244) {
        this.f1677 = interfaceC2244;
        return this;
    }

    /* renamed from: ൕ, reason: contains not printable characters */
    public CameraView m2011(int i) {
        this.f1650 = i;
        return this;
    }

    /* renamed from: ൖ, reason: contains not printable characters */
    public void m2012(int i, float f) {
        m2064(new RunnableC0819(i, f));
    }

    /* renamed from: ൟ, reason: contains not printable characters */
    public CameraView m2013(int i) {
        this.f1623 = i;
        return this;
    }

    /* renamed from: ຆ, reason: contains not printable characters */
    public CameraView m2014(float f) {
        this.f1700 = f;
        if (f == 0.0f && this.f1621 == 0) {
            d9.m5921().m5923(this.f1701);
        } else {
            d9.m5921().m5923(1.0f);
        }
        return this;
    }

    /* renamed from: ຉ, reason: contains not printable characters */
    public CameraView m2015(int i) {
        m2064(new RunnableC0818(i));
        return this;
    }

    /* renamed from: ຌ, reason: contains not printable characters */
    public CameraView m2016(int i) {
        this.f1624 = i;
        return this;
    }

    /* renamed from: ຎ, reason: contains not printable characters */
    public void m2017(int i, float f) {
        this.f1704 = i;
        this.f1705 = (long) (f * Math.pow(10.0d, 9.0d));
    }

    /* renamed from: ຏ, reason: contains not printable characters */
    public CameraView m2018(int i) {
        this.f1647 = i;
        return this;
    }

    /* renamed from: ຐ, reason: contains not printable characters */
    public CameraView m2019(boolean z) {
        this.f1628 = z;
        return this;
    }

    /* renamed from: ຑ, reason: contains not printable characters */
    public CameraView m2020(int i) {
        this.f1649 = i;
        return this;
    }

    /* renamed from: ຒ, reason: contains not printable characters */
    public CameraView m2021(boolean z) {
        this.f1645 = z;
        return this;
    }

    /* renamed from: ຓ, reason: contains not printable characters */
    public CameraView m2022(int i) {
        this.f1620 = i;
        return this;
    }

    /* renamed from: ຘ, reason: contains not printable characters */
    public CameraView m2023(SecondScreenPresenter secondScreenPresenter) {
        this.f1619 = secondScreenPresenter;
        return this;
    }

    /* renamed from: ຠ, reason: contains not printable characters */
    public CameraView m2024(int i) {
        this.f1634 = i;
        return this;
    }

    /* renamed from: ຨ, reason: contains not printable characters */
    public CameraView m2025(int i) {
        this.f1633 = i;
        return this;
    }

    /* renamed from: ຩ, reason: contains not printable characters */
    public CameraView m2026(int i) {
        this.f1638 = i;
        if (i <= 0) {
            this.f1638 = InterfaceC3860.f13266.m8464();
        }
        return this;
    }

    /* renamed from: ຬ, reason: contains not printable characters */
    public CameraView m2027(int i) {
        this.f1639 = i;
        if (i <= 0) {
            this.f1639 = InterfaceC3860.f13266.m8464();
        }
        return this;
    }

    /* renamed from: ໞ, reason: contains not printable characters */
    public CameraView m2028(int i) {
        this.f1648 = i;
        return this;
    }

    /* renamed from: ໟ, reason: contains not printable characters */
    public CameraView m2029(int i) {
        this.f1641 = i;
        return this;
    }

    /* renamed from: ྈ, reason: contains not printable characters */
    public CameraView m2030(String str) {
        this.f1640 = str;
        return this;
    }

    /* renamed from: ྉ, reason: contains not printable characters */
    public void m2031(float f, float f2, float f3, float f4) {
        this.f1668 = f;
        this.f1669 = f2;
        this.f1670 = f3;
        this.f1671 = f4;
    }

    /* renamed from: ྌ, reason: contains not printable characters */
    public CameraView m2032(int i) {
        this.f1625 = i;
        return this;
    }

    /* renamed from: ဢ, reason: contains not printable characters */
    public CameraView m2033(float f) {
        this.f1701 = f;
        if (this.f1700 == 0.0f && this.f1621 == 0) {
            d9.m5921().m5923(f);
        } else {
            d9.m5921().m5923(1.0f);
        }
        return this;
    }

    /* renamed from: ဨ, reason: contains not printable characters */
    public void m2034(boolean z) {
        m2064(new RunnableC0826(z));
    }

    /* renamed from: ၚ, reason: contains not printable characters */
    public void m2035(boolean z, int i) {
        m2064(new RunnableC0798(z, i));
    }

    /* renamed from: ၛ, reason: contains not printable characters */
    public final void m2036() {
        if (this.f1621 == 0) {
            q5 q5Var = this.f1675;
            if (q5Var != null) {
                q5Var.m8059(this.f1643);
                return;
            }
            return;
        }
        C2597 c2597 = this.f1676;
        if (c2597 != null) {
            c2597.m9537();
        }
    }

    /* renamed from: ၜ, reason: contains not printable characters */
    public final void m2037() {
        if (this.f1621 == 0) {
            q5 q5Var = this.f1675;
            if (q5Var != null) {
                q5Var.m8061();
                return;
            }
            return;
        }
        C2597 c2597 = this.f1676;
        if (c2597 != null) {
            c2597.m9538();
        }
    }

    /* renamed from: ၝ, reason: contains not printable characters */
    public void m2038() {
        m2064(new RunnableC0801());
    }

    /* renamed from: ၡ, reason: contains not printable characters */
    public final void m2039() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12375 = c3891M13890.m12375();
        if (!c3891M13890.m12495()) {
            iM12375 = -1;
        }
        boolean z = C2764.m10018().m10034() && this.f1667;
        this.f1691 = z;
        if (!z) {
            if (this.f1672.m11909() != 0) {
                this.f1672.mo11907();
                C4565 c4565 = new C4565();
                this.f1672 = c4565;
                m1970(c4565, iM12375);
            }
            if (this.f1673.m11909() != 0) {
                this.f1673.mo11907();
                this.f1673 = new C4565();
                return;
            }
            return;
        }
        float fM10020 = C2764.m10018().m10020();
        float fM10022 = C2764.m10018().m10022();
        this.f1617.m9219(C2764.m10018().m10030(), C2764.m10018().m10024(), fM10020, C2764.m10018().m10026(), C2764.m10018().m10027(), C2764.m10018().m10031());
        if (this.f1672.m11909() != 1) {
            this.f1672.mo11907();
            this.f1672 = new C4565();
        }
        if (this.f1673.m11909() != 1) {
            this.f1673.mo11907();
            this.f1673 = new C4565();
        }
        this.f1672.m11917(fM10022);
        this.f1672.m11918();
        this.f1673.m11917(fM10022);
        this.f1673.m11918();
        m1970(this.f1672, iM12375);
    }

    /* renamed from: ၥ, reason: contains not printable characters */
    public final void m2040(int i, int i2) {
        AbstractC2341.C2343 c2343 = this.f1666;
        if (c2343 == null) {
            if (this.f1614) {
                C4638.m14099("CameraView", String.format("mCameraParams = null , w : %s , h : %s ", Integer.valueOf(i), Integer.valueOf(i2)));
                return;
            }
            return;
        }
        d1 d1VarM8785 = c2343.m8785();
        C4506 c4506M8784 = this.f1666.m8784();
        d1VarM8785.m12235(AspectRatio.m2074(16, 9));
        d1VarM8785.m12253(i);
        d1VarM8785.m12252(i2);
        d1VarM8785.m5910(this.f1633);
        d1VarM8785.m5909(this.f1634);
        d1VarM8785.m5908(this.f1635);
        d1VarM8785.m12246(this.f1704);
        d1VarM8785.m12242(this.f1705);
        d1VarM8785.m12254(this.f1708);
        d1VarM8785.m12240(this.f1707);
        d1VarM8785.m12251(this.f1638);
        d1VarM8785.m12255(this.f1639);
        d1VarM8785.m5911(this.f1648);
        d1VarM8785.m12239(this.f1621);
        d1VarM8785.m12238(this.f1622);
        d1VarM8785.m12243(this.f1623);
        d1VarM8785.m12257(this.f1625);
        d1VarM8785.m5913(this.f1640);
        d1VarM8785.m5912(this.f1641);
        d1VarM8785.m5906(this.f1642);
        d1VarM8785.m5905(this.f1643);
        d1VarM8785.m5907(this.f1644);
        d1VarM8785.m12236(this.f1646);
        d1VarM8785.m12248(this.f1647);
        d1VarM8785.m12245(this.f1703);
        if (this.f1621 == 1 || this.f1700 != 0.0f) {
            d1VarM8785.m12244(this.f1700);
            d1VarM8785.m12259(this.f1701);
        } else {
            d1VarM8785.m12244(0.0f);
            d1VarM8785.m12259(1.0f);
        }
        d1VarM8785.m12250(this.f1649);
        d1VarM8785.m12241(this.f1650);
        d1VarM8785.m12256(this.f1706);
        c4506M8784.m13806(d1VarM8785);
    }

    /* renamed from: ၦ, reason: contains not printable characters */
    public void m2041() {
        m2064(new RunnableC0822());
    }

    /* renamed from: ၮ, reason: contains not printable characters */
    public void m2042(boolean z) {
        m2064(new RunnableC0824(z));
    }

    /* renamed from: ၯ, reason: contains not printable characters */
    public void m2043(int i) {
        m2064(new RunnableC0809(i));
    }

    /* renamed from: ၰ, reason: contains not printable characters */
    public final void m2044() {
        int i;
        d1 d1VarM8785 = this.f1666.m8785();
        d1VarM8785.m5910(this.f1633);
        d1VarM8785.m5909(this.f1634);
        d1VarM8785.m5908(this.f1635);
        d1VarM8785.m5912(this.f1641);
        int iM12227 = d1VarM8785.m12227();
        int iM12226 = d1VarM8785.m12226();
        if (m1982()) {
            int anamorphicRatio = (int) (iM12226 / getAnamorphicRatio());
            i = anamorphicRatio - (anamorphicRatio % 2);
        } else {
            i = iM12226;
        }
        int iM12229 = d1VarM8785.m12229();
        int iM5903 = d1VarM8785.m5903();
        String strM5904 = d1VarM8785.m5904();
        if (strM5904.equalsIgnoreCase("video/avc") && C3444.m11227().m11261(iM12227, 0, iM12229)) {
            strM5904 = "video/hevc";
        }
        boolean zEqualsIgnoreCase = "video/hevc".equalsIgnoreCase(strM5904);
        d1VarM8785.m12225();
        int iM10145 = C2811.m10145(iM12227, iM12226, iM5903, iM12229, zEqualsIgnoreCase ? 1 : 0);
        int iM5901 = d1VarM8785.m5901();
        int iM5900 = d1VarM8785.m5900();
        if (iM5901 != 0 && iM5900 != 0 && C3444.m11227().m11256()) {
            i = iM5900;
            iM12227 = iM5901;
        }
        if (this.f1621 == 1) {
            int iM10142 = iM12226 > 1080 ? C2811.m10142() : iM12226 > 720 ? C2811.m10141() : C2811.m10143();
            if (this.f1614) {
                C4638.m14099("CameraView", String.format("previewHeight : %s , recommendBitrate : %s , mul : %s", Integer.valueOf(iM12226), Integer.valueOf(iM10142), Integer.valueOf(iM10145)));
            }
            if (iM10145 > iM10142) {
                iM10145 = iM10142;
            }
        }
        if (iM12229 == 6) {
            iM10145 *= 4;
        }
        if (this.f1621 == 0) {
            this.f1675.m8065(iM12227, i, iM10145);
        }
    }

    /* renamed from: ၵ, reason: contains not printable characters */
    public void m2045(float f, float f2, float f3, float f4) {
        m2064(new RunnableC0802(f, f2, f3, f4));
    }

    /* renamed from: ၶ, reason: contains not printable characters */
    public void m2046(int i, Runnable runnable) {
        this.f1625 = i;
        AbstractC2341.C2343 c2343 = this.f1666;
        if (c2343 != null) {
            c2343.m8785().m12257(this.f1625);
            m2064(new RunnableC0815(runnable));
        } else if (this.f1614) {
            C4638.m14099("CameraView", String.format("mCameraParams = null ", new Object[0]));
        }
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1614 = false;
        this.f1615 = null;
        this.f1620 = 1;
        this.f1621 = 0;
        this.f1622 = "0";
        this.f1623 = 0;
        this.f1624 = 0;
        this.f1625 = 2;
        this.f1626 = 0;
        this.f1627 = false;
        this.f1628 = false;
        this.f1635 = new C3255(16.0f, 9.0f);
        this.f1637 = InterfaceC3860.f13265;
        v5 v5Var = InterfaceC3860.f13266;
        this.f1638 = v5Var.m8464();
        this.f1639 = v5Var.m8464();
        this.f1640 = "video/avc";
        this.f1641 = 1;
        this.f1642 = 48000;
        this.f1643 = 1.0f;
        this.f1644 = 0;
        this.f1645 = false;
        this.f1646 = true;
        this.f1647 = 0;
        this.f1648 = 0;
        this.f1649 = 1;
        this.f1650 = 0;
        this.f1652 = new float[16];
        this.f1661 = false;
        this.f1662 = new C0794();
        this.f1663 = 0;
        this.f1665 = new Object();
        this.f1667 = false;
        this.f1680 = new C5220();
        this.f1681 = 0L;
        this.f1682 = 0L;
        this.f1683 = -1L;
        this.f1684 = 0L;
        this.f1685 = -1L;
        this.f1688 = new float[16];
        this.f1691 = false;
        this.f1694 = null;
        this.f1695 = null;
        this.f1696 = null;
        this.f1698 = 0;
        this.f1699 = 0;
        this.f1703 = -1.0f;
        this.f1704 = 400;
        this.f1705 = (long) (Math.pow(10.0d, 9.0d) * 0.02083333395421505d);
        this.f1706 = 1;
        this.f1707 = 0.5f;
        this.f1708 = 0;
    }
}
