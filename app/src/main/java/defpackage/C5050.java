package defpackage;

import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import java.util.ArrayList;

/* compiled from: GridsManager.java */
/* renamed from: ཛྷ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5050 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C5050 f16824;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static ArrayList<C4460> f16825 = new ArrayList<>();

    /* renamed from: ԩ, reason: contains not printable characters */
    public static ArrayList<C2944> f16826 = new ArrayList<>();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static ArrayList<C2685> f16827 = new ArrayList<>();

    static {
        f16825.add(new C4460(0.8f));
        f16825.add(new C4460(0.85f));
        C4460 c4460 = new C4460(0.9f);
        c4460.setSelected(true);
        f16825.add(c4460);
        f16825.add(new C4460(0.95f));
        f16825.add(new C4460(1.0f));
        C2944 c2944 = new C2944(0, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_GRIDS_THIRDS), R.string.RECORDING_SETTINGS_GRIDS_THIRDS);
        c2944.setSelected(true);
        f16826.add(c2944);
        f16826.add(new C2944(1, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_GRIDS_CROSSHAIRDS), R.string.RECORDING_SETTINGS_GRIDS_CROSSHAIRDS));
        f16826.add(new C2944(2, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_GRIDS_HORIZON), R.string.RECORDING_SETTINGS_GRIDS_HORIZON));
        int iM9566 = C2618.m9566("grids_select_sp", 0);
        C2685 c2685 = new C2685(0, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_GRIDS_FRAME_RATIO).toUpperCase(), R.string.RECORDING_SETTINGS_GRIDS_FRAME_RATIO);
        if (iM9566 == 0) {
            c2685.setSelected(true);
        }
        f16827.add(c2685);
        C2685 c26852 = new C2685(1, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_GRIDS_SAFE_AREA).toUpperCase(), R.string.RECORDING_SETTINGS_GRIDS_SAFE_AREA);
        if (iM9566 == 1) {
            c26852.setSelected(true);
        }
        f16827.add(c26852);
        C2685 c26853 = new C2685(2, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_GRIDS_OTHERS).toUpperCase(), R.string.RECORDING_SETTINGS_GRIDS_OTHERS);
        if (iM9566 == 2) {
            c26853.setSelected(true);
        }
        f16827.add(c26853);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C5050 m14861() {
        if (f16824 == null) {
            synchronized (C5050.class) {
                if (f16824 == null) {
                    f16824 = new C5050();
                }
            }
        }
        return f16824;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public ArrayList<C2685> m14862() {
        return f16827;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public ArrayList<C2944> m14863() {
        return f16826;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public ArrayList<C4460> m14864() {
        return f16825;
    }
}
