package com.mob.tools.utils;

import android.os.Build;
import android.text.TextUtils;
import com.mob.tools.MobLog;

/* loaded from: classes2.dex */
public class d {
    private static d a;
    private String b;

    /* renamed from: com.mob.tools.utils.d$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.MIUI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.EMUI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.AMIGO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.FLYME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[a.LENOVO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[a.ONEUI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[a.COLOR_OS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[a.FUNTOUCH_OS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[a.EUI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[a.SENSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[a.GOOGLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[a.SMARTISAN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[a.ONEPLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[a.YUNOS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[a.QIHOO.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[a.NUBIA.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[a.LGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public enum a {
        MIUI(com.mob.commons.a.d.a("0061emefegfd;m$ef")),
        EMUI(com.mob.commons.a.d.a("006d.edegge1j!ef")),
        FLYME(com.mob.commons.a.d.a("005mjQefhded")),
        ONEUI(com.mob.commons.a.d.a("007%ghegCm[ghedelgg")),
        COLOR_OS(com.mob.commons.a.d.a("004!fdIff0fd")),
        FUNTOUCH_OS(com.mob.commons.a.d.a("004k=ef-kMfd")),
        EUI(com.mob.commons.a.d.a("004Mfe)jek")),
        SENSE(com.mob.commons.a.d.a("003de8eh")),
        GOOGLE(com.mob.commons.a.d.a("006 ggfdfdggfe*j")),
        LENOVO(com.mob.commons.a.d.a("006UfeDjKelfd_kWfd")),
        SMARTISAN(com.mob.commons.a.d.a("006!ehMdYedefhdef")),
        ONEPLUS(com.mob.commons.a.d.a("007Ufdel.jfCfeedgh")),
        YUNOS(com.mob.commons.a.d.a("0057ejedelfdgh")),
        QIHOO(com.mob.commons.a.d.a("005lEefHdTfdfd")),
        NUBIA(com.mob.commons.a.d.a("005:eledgdefeg")),
        LGE(com.mob.commons.a.d.a("002!fegg")),
        AMIGO(com.mob.commons.a.d.a("0051igefelfeef")),
        OTHER("");

        private String s;

        a(String str) {
            this.s = str;
        }

        public String a() {
            return this.s;
        }
    }

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private a c() {
        if (!TextUtils.isEmpty(a("ro.miui.ui.version.code")) || !TextUtils.isEmpty(a(com.mob.commons.a.d.a("023Teifdfm6m'efedeffmedeffmLkj+eigheffdelfmeleg:mj"))) || !TextUtils.isEmpty(a("ro.miui.internal.storage"))) {
            return a.MIUI;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("021*eifdfmgdedeffe!iFfmEkjIeigheffdelfmKjm]edef"))) || !TextUtils.isEmpty(a("ro.build.hw_emui_api_level")) || !TextUtils.isEmpty(a("ro.confg.hw_systemversion"))) {
            return a.EMUI;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("026fjLeighefgh8e!fmghejghfmedgh?j7fmgifeej[mj<fmefehfdel"))) || !TextUtils.isEmpty(a(com.mob.commons.a.d.a("0262eifdfm=mj_efhdedfmgh-je8ed[f[geefhdegeiYi[fmgifeejImj"))) || !TextUtils.isEmpty(a(com.mob.commons.a.d.a("018.eifdfmgifeej?mj fmMfEedgdfeefghZdji")))) {
            return a.FLYME;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("024QehfdNmOfmgheg=m%ghedelggfmghCfj1ggfmHiXefgheggdfe-j"))) || !TextUtils.isEmpty(a("init.svc.health-hal-2-1-samsung"))) {
            return a.ONEUI;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("024'eifdfmgdedeffe(i%fmLkj>eigheffdelfmfd@ffOfdeifd3m")))) {
            return a.COLOR_OS;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("027WeifdfmSk5ef9kRfdfmfdghfmgdedeffeCi.fmJi)efgh0f@feegejfmefRi"))) || !TextUtils.isEmpty(a(com.mob.commons.a.d.a("018GeifdfmUkSef!k'fdfmfdghfm kj<eigheffdel")))) {
            return a.FUNTOUCH_OS;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("0238eifdfmfeVjek7fmeiPj7fe1j:eggh%jZfm[kjUeigheffdel")))) {
            return a.EUI;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("0224eifdfmgdedeffe@i9fmghFj)elgh6j;fmNkjVeigheffdel")))) {
            return a.SENSE;
        }
        if (com.mob.commons.a.d.a("014 egel0i$eifdef8iFijggfdfdggfeWj").equals(a(com.mob.commons.a.d.a("026MeifdfmehfdAm7fmggfdfdggfeJj.fmehfeefHj*el@eAef'iTgdeggh)j")))) {
            return a.GOOGLE;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("020VeifdfmghRm)egeiPe8efghegelfm<kjEeigheffdel")))) {
            return a.SMARTISAN;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("014+eifdfmeifd1m$fm%kjOeigheffdel")))) {
            return a.ONEPLUS;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("020AeifdfmehTe@egfmejedelfdghfmUkj-eigheffdel")))) {
            return a.YUNOS;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("018?eifdfmgdedeffeNi*fmedef$kj;eigheffdel")))) {
            return a.QIHOO;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("023Beifdfmgdedeffe7i$fmeledgdefegfmeifdEm!fmehfd2ij"))) || !TextUtils.isEmpty(a(com.mob.commons.a.d.a("0154eifdfmgdedeffe%i5fmeifd4m]fmef2i")))) {
            return a.NUBIA;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("021]ghejghfmfeggKjEfmfeggRmimUee:kjZeigheffdel")))) {
            return a.LGE;
        }
        if (!TextUtils.isEmpty(a(com.mob.commons.a.d.a("019>eifdfmgdedeffeQi4fm7i efghVfTfeegejfmefPi"))) && a(com.mob.commons.a.d.a("019[eifdfmgdedeffe[iHfmUi-efgh5fBfeegejfmef3i")).matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return a.AMIGO;
        }
        for (a aVar : a.values()) {
            if (aVar.a().equalsIgnoreCase(d())) {
                return aVar;
            }
        }
        return a.OTHER;
    }

    private String d() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = Build.MANUFACTURER;
        }
        return this.b;
    }

    public String b() {
        try {
            return a(c());
        } catch (Throwable th) {
            MobLog.getInstance().e(th);
            return null;
        }
    }

    private String a(a aVar) {
        String strA;
        switch (AnonymousClass1.a[aVar.ordinal()]) {
            case 1:
                strA = a(com.mob.commons.a.d.a("023+eifdfmUmZefedeffmedeffmXkjCeigheffdelfmeleg+mj"));
                break;
            case 2:
                strA = a(com.mob.commons.a.d.a("021Feifdfmgdedeffe i$fmXkj0eigheffdelfm$jm7edef"));
                break;
            case 3:
            case 4:
                strA = a(com.mob.commons.a.d.a("019Neifdfmgdedeffe8iQfm2iXefgh!fSfeegejfmefHi"));
                break;
            case 5:
            case 6:
                strA = a(com.mob.commons.a.d.a("0286eifdfmgdedeffe(i3fmDkjZeigheffdelfmefelehei?jmjGel<eBegfe"));
                break;
            case 7:
                strA = a(com.mob.commons.a.d.a("024Beifdfmgdedeffe[i1fm'kjZeigheffdelfmfd-ffYfdeifd1m"));
                break;
            case 8:
                strA = a(com.mob.commons.a.d.a("0277eifdfm<kMefDkEfdfmfdghfmgdedeffeUi$fm>iOefgh6f9feegejfmef?i"));
                if (TextUtils.isEmpty(strA)) {
                    strA = a(com.mob.commons.a.d.a("018Peifdfm_k5ef9k.fdfmfdghfm?kjJeigheffdel"));
                    break;
                }
                break;
            case 9:
                strA = a(com.mob.commons.a.d.a("023YeifdfmfeEjek9fmeiCj3fe!jCegghTj,fmTkjUeigheffdel"));
                break;
            case 10:
                strA = a(com.mob.commons.a.d.a("022Ueifdfmgdedeffe9i+fmgh<j2elgh-j(fm1kj+eigheffdel"));
                break;
            case 11:
                strA = a(com.mob.commons.a.d.a("024^eifdfmgdedeffe4iSfmLkjKeigheffdelfmei<j8feNj=eggh.j"));
                break;
            case 12:
                strA = a(com.mob.commons.a.d.a("020%eifdfmghXm*egei%e>efghegelfmPkjAeigheffdel"));
                break;
            case 13:
                strA = a(com.mob.commons.a.d.a("014'eifdfmeifdHmXfm-kj-eigheffdel"));
                break;
            case 14:
                strA = a(com.mob.commons.a.d.a("020MeifdfmehPe]egfmejedelfdghfm:kjTeigheffdel"));
                break;
            case 15:
                strA = a(com.mob.commons.a.d.a("018<eifdfmgdedeffe>iIfmedef_kjFeigheffdel"));
                break;
            case 16:
                strA = a(com.mob.commons.a.d.a("023;eifdfmgdedeffeZiRfmeledgdefegfmeifdIm8fmehfdHij"));
                if (TextUtils.isEmpty(strA)) {
                    strA = a(com.mob.commons.a.d.a("015ZeifdfmgdedeffeQi'fmeifdFm3fmef6i"));
                    break;
                }
                break;
            case 17:
                strA = a(com.mob.commons.a.d.a("0217ghejghfmfegg6j9fmfeggKmimZeeJkjKeigheffdel"));
                break;
            default:
                strA = a(com.mob.commons.a.d.a("019Weifdfmgdedeffe4i5fm4i*efgh]f3feegejfmefFi"));
                break;
        }
        return TextUtils.isEmpty(strA) ? a(com.mob.commons.a.d.a("019<eifdfmgdedeffeSi7fmPiHefgh]f5feegejfmef*i")) : strA;
    }

    private String a(String str) {
        try {
            Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(com.mob.commons.a.d.a("027Oegel_i@eifdefMi@fmfdghfmfiejgh[ejm<hieifd@fjUeiLe3efQjWgh")), com.mob.commons.a.d.a("003+gg'je"), str);
            return objInvokeStaticMethod != null ? String.valueOf(objInvokeStaticMethod) : "";
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return "";
        }
    }
}
