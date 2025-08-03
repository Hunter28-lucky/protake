package defpackage;

import android.os.Build;
import cn.smssdk.gui.layout.SizeHelper;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.protake.R;
import com.uc.crashsdk.export.LogType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;
import org.jcodec.containers.dpx.DPXReader;

/* compiled from: CameraInfoManager.java */
/* renamed from: د, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3444 {

    /* renamed from: ޅ, reason: contains not printable characters */
    public static boolean f11842 = false;

    /* renamed from: ކ, reason: contains not printable characters */
    public static C3255 f11843;

    /* renamed from: އ, reason: contains not printable characters */
    public static C3255 f11844;

    /* renamed from: ވ, reason: contains not printable characters */
    public static C3255 f11845;

    /* renamed from: މ, reason: contains not printable characters */
    public static C3444 f11846;

    /* renamed from: ފ, reason: contains not printable characters */
    public static ArrayList<C2375> f11847 = new ArrayList<>();

    /* renamed from: ދ, reason: contains not printable characters */
    public static ArrayList<C3255> f11848 = new ArrayList<>();

    /* renamed from: ތ, reason: contains not printable characters */
    public static ArrayList<s5> f11849 = new ArrayList<>();

    /* renamed from: ލ, reason: contains not printable characters */
    public static ArrayList<v5> f11850 = new ArrayList<>();

    /* renamed from: ގ, reason: contains not printable characters */
    public static ArrayList<Float> f11851 = new ArrayList<>();

    /* renamed from: ޏ, reason: contains not printable characters */
    public static ArrayList<C3828> f11852 = new ArrayList<>();

    /* renamed from: ސ, reason: contains not printable characters */
    public static ArrayList<C3828> f11853 = new ArrayList<>();

    /* renamed from: ޑ, reason: contains not printable characters */
    public static ArrayList<w7> f11854 = new ArrayList<>();

    /* renamed from: ޒ, reason: contains not printable characters */
    public static ArrayList<C4351> f11855 = new ArrayList<>();

    /* renamed from: ޓ, reason: contains not printable characters */
    public static ArrayList<C5080> f11856 = new ArrayList<>();

    /* renamed from: ޔ, reason: contains not printable characters */
    public static ArrayList<h0> f11857 = new ArrayList<>();

    /* renamed from: ޕ, reason: contains not printable characters */
    public static ArrayList<C3741> f11858 = new ArrayList<>();

    /* renamed from: ޖ, reason: contains not printable characters */
    public static ArrayList<C5183> f11859 = new ArrayList<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f11865;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f11872;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f11860 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public ArrayList<w5> f11861 = new ArrayList<>();

    /* renamed from: ԩ, reason: contains not printable characters */
    public ArrayList<v5> f11862 = new ArrayList<>();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public ArrayList<v5> f11863 = new ArrayList<>();

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f11864 = 48000;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f11866 = 2;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f11867 = 1;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f11868 = 1;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f11869 = false;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f11870 = false;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f11871 = false;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f11873 = 1.0f;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f11874 = 0;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f11875 = 8000;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f11876 = 2000;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f11877 = 50;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f11878 = -50;

    /* compiled from: CameraInfoManager.java */
    /* renamed from: د$Ϳ, reason: contains not printable characters */
    public class C3445 implements Comparator<v5> {
        public C3445() {
        }

        @Override // java.util.Comparator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int compare(v5 v5Var, v5 v5Var2) {
            return v5Var.m8464() - v5Var2.m8464();
        }
    }

    /* compiled from: CameraInfoManager.java */
    /* renamed from: د$Ԩ, reason: contains not printable characters */
    public class C3446 implements Comparator<v5> {
        public C3446() {
        }

        @Override // java.util.Comparator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int compare(v5 v5Var, v5 v5Var2) {
            return v5Var.m8464() - v5Var2.m8464();
        }
    }

    /* compiled from: CameraInfoManager.java */
    /* renamed from: د$Ԫ, reason: contains not printable characters */
    public interface InterfaceC3447 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C2375 f11881 = new C2375(SyntaxConstants.WINDOW_SMALL_LEN_LONG, SizeHelper.DESIGNED_SCREEN_WIDTH).m8847("480P");

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final C2375 f11882 = new C2375(LogType.UNEXP_ANR, 720).m8847("720P");

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final C2375 f11883 = new C2375(DPXReader.TVINFO_OFFSET, 1080).m8847("1080P");

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final C2375 f11884 = new C2375(3840, 2160).m8847("4K");

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final C2375 f11885 = new C2375(5760, 3240).m8847("6K");
    }

    /* compiled from: CameraInfoManager.java */
    /* renamed from: د$Ԭ, reason: contains not printable characters */
    public interface InterfaceC3448 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final v5 f11886 = new v5(6);

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final v5 f11887 = new v5(24);

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final v5 f11888 = new v5(25);

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final v5 f11889 = new v5(30);

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final v5 f11890 = new v5(48);

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final v5 f11891 = new v5(50);

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final v5 f11892 = new v5(60);

        /* renamed from: Ԯ, reason: contains not printable characters */
        public static final v5 f11893 = new v5(120);

        /* renamed from: ԯ, reason: contains not printable characters */
        public static final v5 f11894 = new v5(240);
    }

    /* compiled from: CameraInfoManager.java */
    /* renamed from: د$Ԯ, reason: contains not printable characters */
    public interface InterfaceC3449 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C3828 f11895 = new C3828().m12148(FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_LENS_SELFIE_WIDE)).m12149(R.string.RECORDING_SETTINGS_LENS_SELFIE_WIDE).m12146("W.Selfie");

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final C3828 f11896 = new C3828().m12148("Selfie Tele").m12146("Selfie Tele");

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final C3828 f11897 = new C3828().m12148(FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_LENS_SELFIE)).m12149(R.string.RECORDING_SETTINGS_LENS_SELFIE).m12144("1").m12146("Selfie");

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final C3828 f11898 = new C3828().m12148(FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_LENS_ULTRA_WIDE)).m12149(R.string.RECORDING_SETTINGS_LENS_ULTRA_WIDE).m12146("Ultra Wide");

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final C3828 f11899 = new C3828().m12148(FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_LENS_WIDE)).m12149(R.string.RECORDING_SETTINGS_LENS_WIDE).m12146("Wide");

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final C3828 f11900 = new C3828().m12148(FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_LENS_TELE)).m12149(R.string.RECORDING_SETTINGS_LENS_TELE).m12146("Tele");

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final C3828 f11901 = new C3828().m12148(FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_LENS_SUPERTELE)).m12149(R.string.RECORDING_SETTINGS_LENS_SUPERTELE).m12146("S.Tele");

        /* renamed from: Ԯ, reason: contains not printable characters */
        public static final C3828 f11902 = new C3828().m12148(FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_LENS_REAR_AUTO)).m12149(R.string.RECORDING_SETTINGS_LENS_REAR_AUTO).m12144("0").m12146("Rear Auto");

        /* renamed from: ԯ, reason: contains not printable characters */
        public static final C3828 f11903 = new C3828();

        /* renamed from: ՠ, reason: contains not printable characters */
        public static final C3828 f11904 = new C3828();

        /* renamed from: ֈ, reason: contains not printable characters */
        public static final C3828 f11905 = new C3828();

        /* renamed from: ֏, reason: contains not printable characters */
        public static final C3828 f11906 = new C3828();
    }

    /* compiled from: CameraInfoManager.java */
    /* renamed from: د$ՠ, reason: contains not printable characters */
    public static class C3450 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public String f11907;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f11908;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public int m11274() {
            return this.f11908;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public String m11275() {
            return this.f11907;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public C3450 m11276(int i) {
            this.f11908 = i;
            return this;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public C3450 m11277(String str) {
            this.f11907 = str;
            return this;
        }
    }

    /* compiled from: CameraInfoManager.java */
    /* renamed from: د$ֈ, reason: contains not printable characters */
    public interface InterfaceC3451 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final String f11909 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF);

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final String f11910 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_Portrait);

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final String f11911 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_Bleach_Bypass);

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final String f11912 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_Landscape);

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final String f11913 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_Film_1);

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final String f11914 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_ROMA);

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final String f11915 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_Film_2);

        /* renamed from: Ԯ, reason: contains not printable characters */
        public static final String f11916 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_PINKY);

        /* renamed from: ԯ, reason: contains not printable characters */
        public static final String f11917 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_Film_3);

        /* renamed from: ՠ, reason: contains not printable characters */
        public static final String f11918 = FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_RETRO);
    }

    /* compiled from: CameraInfoManager.java */
    /* renamed from: د$֏, reason: contains not printable characters */
    public interface InterfaceC3452 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final w7 f11919 = new w7().m8518(FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_WB_AUTO)).m8519(R.string.RECORDING_SETTINGS_WB_AUTO).m8516("Auto").m8521(0).m8522(2);

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final w7 f11920 = new w7().m8518(FilmApp.m405().getResources().getString(R.string.RECORDING_SETTINGS_WB_REC_LOCK)).m8519(R.string.RECORDING_SETTINGS_WB_REC_LOCK).m8516("Rec Lock").m8521(0).m8522(9);

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final w7 f11921 = new w7().m8518("Tungsten").m8516("Tungsten").m8521(1).m8522(4).m8515(R.drawable.icon_34_wb_incandescent).m8519(R.string.RECORDING_SETTINGS_WB_TUNGSTEN);

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final w7 f11922 = new w7().m8518("Fluorescent").m8516("Fluorescent").m8521(1).m8522(7).m8515(R.drawable.icon_34_wb_fluorescent).m8519(R.string.RECORDING_SETTINGS_WB_FLUORESCENT);

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final w7 f11923 = new w7().m8518("Shade").m8516("Shade").m8521(1).m8522(8).m8515(R.drawable.icon_34_wb_shade).m8519(R.string.RECORDING_SETTINGS_WB_SHADE);

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final w7 f11924 = new w7().m8518("Daylight").m8516("Daylight").m8521(1).m8522(5).m8515(R.drawable.icon_34_wb_daylight).m8519(R.string.RECORDING_SETTINGS_WB_DAYLIGHT);

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final w7 f11925 = new w7().m8518("Overcast").m8516("Overcast").m8521(1).m8522(6).m8515(R.drawable.icon_34_wb_cloudy_daylight).m8519(R.string.RECORDING_SETTINGS_WB_OVERCAST);
    }

    static {
        f11847.add(InterfaceC3447.f11882);
        f11847.add(InterfaceC3447.f11883);
        if (!C2813.m10153()) {
            f11847.add(InterfaceC3447.f11884);
            f11847.add(InterfaceC3447.f11885);
        }
        int iM12429 = FilmApp.m405().m406() ? C4535.m13880().m13890().m12429() : 0;
        f11843 = new C3255(16.0f, 9.0f, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF), R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF, 0);
        f11844 = new C3255(2.37f, 1.0f, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF), R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF, 0);
        C3255 c3255 = new C3255(2.76f, 1.0f, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF), R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF, 0);
        f11845 = c3255;
        if (iM12429 == 0) {
            f11848.add(f11843);
        } else if (iM12429 == 2) {
            f11848.add(c3255);
        } else {
            f11848.add(f11844);
        }
        f11848.add(new C3255(2.39f, 1.0f, "2.39:1", R.string.RECORDING_SETTINGS_GRIDS_FRAME_RATIO_239));
        f11848.add(new C3255(2.2f, 1.0f, "2.2:1", R.string.RECORDING_SETTINGS_GRIDS_FRAME_RATIO_22));
        f11848.add(new C3255(1.85f, 1.0f, "1.85:1", R.string.RECORDING_SETTINGS_GRIDS_FRAME_RATIO_185));
        f11848.add(new C3255(16.0f, 9.0f, "16:9", R.string.RECORDING_SETTINGS_GRIDS_FRAME_RATIO_169));
        f11848.add(new C3255(1.37f, 1.0f, "1.37:1", R.string.RECORDING_SETTINGS_GRIDS_FRAME_RATIO_137));
        f11848.add(new C3255(4.0f, 3.0f, "4:3", R.string.RECORDING_SETTINGS_GRIDS_FRAME_RATIO_43));
        f11848.add(new C3255(1.0f, 1.0f, "1:1", R.string.RECORDING_SETTINGS_GRIDS_FRAME_RATIO_11));
        f11849.add(new s5("video/avc"));
        f11849.add(new s5("video/hevc"));
        f11850.add(InterfaceC3448.f11886);
        f11850.add(InterfaceC3448.f11887);
        f11850.add(InterfaceC3448.f11888);
        f11850.add(InterfaceC3448.f11889);
        f11850.add(InterfaceC3448.f11892);
        if (!"PCCM00".equalsIgnoreCase(Build.MODEL)) {
            f11850.add(InterfaceC3448.f11893);
            f11850.add(InterfaceC3448.f11894);
        }
        f11851.add(Float.valueOf(0.5f));
        f11851.add(Float.valueOf(1.0f));
        f11851.add(Float.valueOf(2.0f));
        f11851.add(Float.valueOf(3.0f));
        f11851.add(Float.valueOf(4.0f));
        f11851.add(Float.valueOf(5.0f));
        f11852.add(InterfaceC3449.f11896);
        f11852.add(InterfaceC3449.f11895);
        f11852.add(InterfaceC3449.f11897);
        f11852.add(InterfaceC3449.f11898);
        f11852.add(InterfaceC3449.f11899);
        f11852.add(InterfaceC3449.f11900);
        f11852.add(InterfaceC3449.f11901);
        f11852.add(InterfaceC3449.f11903);
        f11852.add(InterfaceC3449.f11904);
        f11852.add(InterfaceC3449.f11905);
        f11852.add(InterfaceC3449.f11906);
        f11854.add(InterfaceC3452.f11919);
        f11854.add(InterfaceC3452.f11920);
        f11854.add(InterfaceC3452.f11921);
        f11854.add(InterfaceC3452.f11922);
        f11854.add(InterfaceC3452.f11923);
        f11854.add(InterfaceC3452.f11924);
        f11854.add(InterfaceC3452.f11925);
        f11855.add(new C4351().m13508(FilmApp.m405().getResources().getString(R.string.RECORDING_ASSISTANTS_ZEBRA)).m13509(R.string.RECORDING_ASSISTANTS_ZEBRA).m13506(0));
        f11855.add(new C4351().m13508(FilmApp.m405().getResources().getString(R.string.RECORDING_ASSISTANTS_FALSE_COLOR)).m13509(R.string.RECORDING_ASSISTANTS_FALSE_COLOR).m13506(1));
        f11855.add(new C4351().m13508(FilmApp.m405().getResources().getString(R.string.RECORDING_ASSISTANTS_PEAKING)).m13509(R.string.RECORDING_ASSISTANTS_PEAKING).m13506(2));
        f11856.add(new C5080(0, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE_PHONE), R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE_PHONE).m14910("Phone"));
        f11856.add(new C5080(1, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE_EXTERNAL), R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE_EXTERNAL).m14910("External"));
        f11856.add(new C5080(2, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE_BLUETOOTH), R.string.RECORDING_SETTINGS_AUDIO_MICROPHONE_BLUETOOTH).m14910("Bluetooth"));
        f11858.add(new C3741(1, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_STRENGTH).toUpperCase(), R.string.RECORDING_SETTINGS_LOOKS_STRENGTH, 100.0f, 200.0f, 0.0f, 10.0f));
        f11858.add(new C3741(2, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_CONTRAST).toUpperCase(), R.string.RECORDING_SETTINGS_LOOKS_CONTRAST, 0.0f, 50.0f, -50.0f, 10.0f));
        f11858.add(new C3741(3, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_BRIGHTNESS).toUpperCase(), R.string.RECORDING_SETTINGS_LOOKS_BRIGHTNESS, 0.0f, 50.0f, -50.0f, 10.0f));
        f11858.add(new C3741(4, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_BLACK).toUpperCase(), R.string.RECORDING_SETTINGS_LOOKS_BLACK, 0.0f, 50.0f, -50.0f, 10.0f));
        f11858.add(new C3741(5, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_WHITE).toUpperCase(), R.string.RECORDING_SETTINGS_LOOKS_WHITE, 0.0f, 50.0f, -50.0f, 10.0f));
        C3741 c3741 = new C3741(0, FilmApp.m402().getString(R.string.RECORDING_SETTINGS_LOOKS_STYLE).toUpperCase(), f11857);
        c3741.setSelected(true);
        f11858.add(0, c3741);
        f11859.add(new C5183(1, R.drawable.icon_60_beauty_bright, R.string.RECORDING_SETTINGS_BEAUTY_BRIGHT, 5));
        f11859.add(new C5183(2, R.drawable.icon_60_beauty_smooth, R.string.RECORDING_SETTINGS_BEAUTY_SMOOTH, 4));
        f11859.add(new C5183(3, R.drawable.icon_60_beauty_chin, R.string.RECORDING_SETTINGS_BEAUTY_CHIN, 3));
        f11859.add(new C5183(4, R.drawable.icon_60_beauty_big_eyes, R.string.RECORDING_SETTINGS_BEAUTY_BIG_EYES, 3));
        f11859.add(new C5183(5, R.drawable.icon_60_beauty_dark_circles, R.string.RECORDING_SETTINGS_BEAUTY_EYE_CIRCLES, 6));
        f11859.add(new C5183(6, R.drawable.icon_60_beauty_bright_eyes, R.string.RECORDING_SETTINGS_BEAUTY_BRIGHT_EYES, 10));
        f11859.add(new C5183(7, R.drawable.icon_60_beauty_white_teeth, R.string.RECORDING_SETTINGS_BEAUTY_WHITE_TEETH, 6));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m11223(C3828 c3828) {
        return c3828 == InterfaceC3449.f11897 ? "1" : c3828 == InterfaceC3449.f11898 ? "2" : c3828 == InterfaceC3449.f11899 ? "3" : c3828 == InterfaceC3449.f11900 ? FinderManager.MACHINE_C : c3828 == InterfaceC3449.f11895 ? "5" : c3828 == InterfaceC3449.f11901 ? "6" : c3828 == InterfaceC3449.f11896 ? "7" : c3828 == InterfaceC3449.f11903 ? FinderManager.MACHINE_D : c3828 == InterfaceC3449.f11904 ? "9" : c3828 == InterfaceC3449.f11905 ? "10" : c3828 == InterfaceC3449.f11906 ? "11" : "0";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008f  */
    /* renamed from: Ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static defpackage.C3828 m11224(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            r1 = 1567(0x61f, float:2.196E-42)
            if (r0 == r1) goto L84
            r1 = 1568(0x620, float:2.197E-42)
            if (r0 == r1) goto L79
            switch(r0) {
                case 48: goto L6e;
                case 49: goto L64;
                case 50: goto L5a;
                case 51: goto L50;
                case 52: goto L46;
                case 53: goto L3c;
                case 54: goto L32;
                case 55: goto L28;
                case 56: goto L1d;
                case 57: goto L11;
                default: goto Lf;
            }
        Lf:
            goto L8f
        L11:
            java.lang.String r0 = "9"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 8
            goto L90
        L1d:
            java.lang.String r0 = "8"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 7
            goto L90
        L28:
            java.lang.String r0 = "7"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 6
            goto L90
        L32:
            java.lang.String r0 = "6"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 5
            goto L90
        L3c:
            java.lang.String r0 = "5"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 4
            goto L90
        L46:
            java.lang.String r0 = "4"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 3
            goto L90
        L50:
            java.lang.String r0 = "3"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 2
            goto L90
        L5a:
            java.lang.String r0 = "2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 1
            goto L90
        L64:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 0
            goto L90
        L6e:
            java.lang.String r0 = "0"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 11
            goto L90
        L79:
            java.lang.String r0 = "11"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 10
            goto L90
        L84:
            java.lang.String r0 = "10"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8f
            r2 = 9
            goto L90
        L8f:
            r2 = -1
        L90:
            switch(r2) {
                case 0: goto Lb4;
                case 1: goto Lb1;
                case 2: goto Lae;
                case 3: goto Lab;
                case 4: goto La8;
                case 5: goto La5;
                case 6: goto La2;
                case 7: goto L9f;
                case 8: goto L9c;
                case 9: goto L99;
                case 10: goto L96;
                default: goto L93;
            }
        L93:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11902
            return r2
        L96:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11906
            return r2
        L99:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11905
            return r2
        L9c:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11904
            return r2
        L9f:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11903
            return r2
        La2:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11896
            return r2
        La5:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11901
            return r2
        La8:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11895
            return r2
        Lab:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11900
            return r2
        Lae:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11899
            return r2
        Lb1:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11898
            return r2
        Lb4:
            ߓ r2 = defpackage.C3444.InterfaceC3449.f11897
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3444.m11224(java.lang.String):ߓ");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C3828 m11225(String str) {
        if (str != null && !str.equals("")) {
            Iterator<C3828> it = f11852.iterator();
            while (it.hasNext()) {
                C3828 next = it.next();
                if (next.m12143() && str.equals(next.m12137())) {
                    return next;
                }
            }
        }
        return InterfaceC3449.f11902;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static ArrayList<C4351> m11226() {
        return f11855;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static C3444 m11227() {
        if (f11846 == null) {
            synchronized (C3444.class) {
                if (f11846 == null) {
                    f11846 = new C3444();
                }
            }
        }
        return f11846;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static ArrayList<Float> m11228() {
        return f11851;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static ArrayList<w7> m11229() {
        return f11854;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static ArrayList<C3828> m11230() {
        if (!r1.m8144(f11853) && r1.m8144(f11852)) {
            Iterator<C3828> it = f11852.iterator();
            while (it.hasNext()) {
                C3828 next = it.next();
                if (next.m12143()) {
                    f11853.add(next);
                }
            }
        }
        return f11853;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static w7 m11231(int i) {
        switch (i) {
            case 4:
                return InterfaceC3452.f11921;
            case 5:
                return InterfaceC3452.f11924;
            case 6:
                return InterfaceC3452.f11925;
            case 7:
                return InterfaceC3452.f11922;
            case 8:
                return InterfaceC3452.f11923;
            case 9:
                return InterfaceC3452.f11920;
            default:
                return InterfaceC3452.f11919;
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static ArrayList<C3255> m11232() {
        return f11848;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public static void m11233(String str) {
        if (str == null) {
            return;
        }
        Iterator<C3828> it = f11852.iterator();
        while (it.hasNext()) {
            C3828 next = it.next();
            if (str.equals(next.m12137())) {
                next.m12147(true);
            } else {
                next.m12147(false);
            }
        }
        if (f11842) {
            C4638.m14099("CameraIdInfoManager", String.format("sPresetCameraLens : %s ", f11852));
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public static void m11234(C3485 c3485) {
        Iterator<w7> it = f11854.iterator();
        while (it.hasNext()) {
            w7 next = it.next();
            next.m8520(false);
            if (m11227().m11253() == next.m8513()) {
                next.m8517(true);
            } else {
                next.m8517(false);
            }
        }
        if (c3485 == null) {
            return;
        }
        if (c3485.m11380()) {
            f11854.get(1).m8520(true);
        }
        int[] iArrM11356 = c3485.m11356();
        if (f11842) {
            C4638.m14099("CameraInfoManager", String.format("control_awb_available_modes : %s ", Arrays.toString(iArrM11356)));
        }
        if (iArrM11356 != null) {
            for (int i : iArrM11356) {
                if (i == 1) {
                    f11854.get(0).m8520(true);
                } else if (i == 2) {
                    f11854.get(2).m8520(true);
                } else if (i == 3) {
                    f11854.get(3).m8520(true);
                } else if (i == 5) {
                    f11854.get(5).m8520(true);
                } else if (i == 6) {
                    f11854.get(6).m8520(true);
                } else if (i == 8) {
                    f11854.get(4).m8520(true);
                }
            }
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C3255 m11235() {
        return f11844;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public C3255 m11236() {
        return f11845;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float m11237() {
        return this.f11873;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public C5080 m11238(int i) {
        return i != 1 ? i != 2 ? f11856.get(0) : f11856.get(2) : f11856.get(1);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C5080> m11239() {
        return f11856;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<C5183> m11240() {
        return f11859;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public int m11241() {
        return this.f11864;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public int m11242() {
        return this.f11874;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public C3255 m11243() {
        return f11843;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public ArrayList<h0> m11244() {
        return f11857;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public List<C3450> m11245() {
        ArrayList arrayList = new ArrayList();
        C3450 c3450 = new C3450();
        c3450.m11277(InterfaceC3447.f11882.m8845());
        c3450.m11276(30);
        arrayList.add(c3450);
        return arrayList;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public List<C3450> m11246() {
        ArrayList arrayList = new ArrayList();
        ArrayList<w5> arrayList2 = this.f11861;
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (int size = this.f11861.size() - 1; size >= 0; size--) {
                C3450 c3450 = new C3450();
                c3450.m11277(this.f11861.get(size).m8506().m8845());
                c3450.m11276(30);
                arrayList.add(c3450);
            }
        }
        return arrayList;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public ArrayList<w5> m11247() {
        return this.f11861;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public ArrayList<v5> m11248() {
        return this.f11862;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public int m11249() {
        return this.f11875;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public int m11250() {
        return this.f11876;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public int m11251() {
        return this.f11877;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public int m11252() {
        return this.f11878;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public int m11253() {
        return this.f11866;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean m11254() {
        return this.f11872;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public boolean m11255(int i) {
        return i > 30;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public boolean m11256() {
        return this.f11869;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public boolean m11257() {
        return this.f11870;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean m11258() {
        return this.f11865;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean m11259() {
        return this.f11871;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean m11260(int i) {
        C3891 c3891M13890 = C4535.m13880().m13890();
        return m11261(c3891M13890.m12463(), c3891M13890.m12478(), i);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public boolean m11261(int i, int i2, int i3) {
        if (!C2813.f10275 || i2 == 1) {
            return false;
        }
        if (i == InterfaceC3447.f11882.m8846() || i == InterfaceC3447.f11883.m8846()) {
            if (i3 >= 120) {
                return true;
            }
        } else if ((i == InterfaceC3447.f11884.m8846() || i == InterfaceC3447.f11885.m8846()) && i3 >= 60) {
            return true;
        }
        return false;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public C3444 m11262(boolean z) {
        this.f11872 = z;
        return this;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public C3444 m11263(float f) {
        this.f11873 = f;
        return this;
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public C3444 m11264(int i) {
        this.f11874 = i;
        return this;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public C3444 m11265(boolean z) {
        this.f11869 = z;
        return this;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public void m11266(boolean z) {
        this.f11870 = z;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public void m11267(List<h0> list) {
        f11857.clear();
        f11857.addAll(list);
        Iterator<h0> it = list.iterator();
        while (it.hasNext()) {
            C4638.m14099("CameraInfoManager", String.format("data : %s ", it.next()));
        }
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public void m11268(SortedSet<C2375> sortedSet, C2375 c2375) {
        this.f11861.clear();
        if (sortedSet == null || sortedSet.size() <= 0) {
            return;
        }
        Iterator<C2375> it = f11847.iterator();
        while (it.hasNext()) {
            C2375 next = it.next();
            if (sortedSet.contains(next)) {
                w5 w5Var = new w5(next);
                this.f11861.add(w5Var);
                if (next.equals(c2375)) {
                    w5Var.setSelected(true);
                } else {
                    w5Var.setSelected(false);
                }
            }
        }
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public void m11269(List<Integer> list, int i, int i2) {
        this.f11862.clear();
        if (f11842) {
            C4638.m14099("CameraInfoManager", String.format("curSupportFps : %s ", list.toString()));
        }
        int iM12485 = C4535.m13880().m13890().m12485();
        int iMax = 15;
        if (list != null) {
            Iterator<v5> it = f11850.iterator();
            while (it.hasNext()) {
                v5 next = it.next();
                int iM8464 = next.m8464();
                if (list.contains(Integer.valueOf(iM8464))) {
                    if (m11255(iM8464)) {
                        next.m8468(2);
                    } else {
                        next.m8468(0);
                    }
                    this.f11862.add(next);
                    iMax = Math.max(iMax, iM8464);
                } else if (iM12485 == 2 && iM8464 < 30) {
                    next.m8468(1);
                    this.f11862.add(next);
                }
            }
        }
        Iterator<v5> it2 = this.f11862.iterator();
        while (it2.hasNext()) {
            v5 next2 = it2.next();
            if (next2.m8464() == i) {
                next2.setSelected(true);
            } else {
                next2.setSelected(false);
            }
        }
        Collections.sort(this.f11862, new C3445());
        if (f11842) {
            C4638.m14099("CameraInfoManager", String.format("mSupportedPreviewFps : %s ", this.f11862));
        }
        this.f11863.clear();
        this.f11863.addAll(this.f11862);
        Collections.sort(this.f11863, new C3446());
        Iterator<v5> it3 = this.f11863.iterator();
        while (it3.hasNext()) {
            v5 next3 = it3.next();
            if (next3.m8464() == i2) {
                next3.setSelected(true);
            } else {
                next3.setSelected(false);
            }
        }
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public C3444 m11270(boolean z) {
        this.f11871 = z;
        return this;
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public C3444 m11271(int i) {
        this.f11866 = i;
        return this;
    }
}
