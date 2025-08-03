package defpackage;

import android.content.Context;
import android.database.SQLException;
import com.blink.academy.film.greendao.ACBanBeanDao;
import com.blink.academy.film.greendao.ClipBeanDao;
import com.blink.academy.film.greendao.ContentNameBeanDao;
import com.blink.academy.film.greendao.LensInfoBeanDao;
import com.blink.academy.film.greendao.LocalFilterBeanDao;
import com.blink.academy.film.greendao.LocalFilterGroupBeanDao;
import com.blink.academy.film.greendao.LocalNvtInfoBeanDao;
import com.blink.academy.film.greendao.LocalSubsInfoBeanDao;
import com.blink.academy.film.greendao.PresetBeanDao;
import com.blink.academy.film.greendao.PreviewIconBeanDao;
import com.blink.academy.film.greendao.UserBeanDao;
import com.blink.academy.film.greendao.WeatherInfoBeanDao;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.stream.ban.ACBanBean;
import defpackage.y7;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.async.AsyncSession;

/* compiled from: DBManager.java */
/* renamed from: Լ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3184 {

    /* renamed from: ހ, reason: contains not printable characters */
    public static C3184 f11266;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C3862 f11267;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public PresetBeanDao f11268;

    /* renamed from: ԩ, reason: contains not printable characters */
    public ContentNameBeanDao f11269;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public ClipBeanDao f11270;

    /* renamed from: ԫ, reason: contains not printable characters */
    public LensInfoBeanDao f11271;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public UserBeanDao f11272;

    /* renamed from: ԭ, reason: contains not printable characters */
    public LocalFilterBeanDao f11273;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public LocalFilterGroupBeanDao f11274;

    /* renamed from: ԯ, reason: contains not printable characters */
    public WeatherInfoBeanDao f11275;

    /* renamed from: ՠ, reason: contains not printable characters */
    public PreviewIconBeanDao f11276;

    /* renamed from: ֈ, reason: contains not printable characters */
    public LocalSubsInfoBeanDao f11277;

    /* renamed from: ֏, reason: contains not printable characters */
    public ACBanBeanDao f11278;

    /* renamed from: ׯ, reason: contains not printable characters */
    public LocalNvtInfoBeanDao f11279;

    /* renamed from: ؠ, reason: contains not printable characters */
    public AsyncSession f11280;

    /* compiled from: DBManager.java */
    /* renamed from: Լ$Ϳ, reason: contains not printable characters */
    public class RunnableC3185 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2628 f11281;

        public RunnableC3185(C2628 c2628) {
            this.f11281 = c2628;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11270.update(this.f11281);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$Ԩ, reason: contains not printable characters */
    public class RunnableC3186 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2949 f11283;

        public RunnableC3186(C2949 c2949) {
            this.f11283 = c2949;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11271.insert(this.f11283);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$Ԫ, reason: contains not printable characters */
    public class RunnableC3187 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2949 f11285;

        public RunnableC3187(C2949 c2949) {
            this.f11285 = c2949;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11271.update(this.f11285);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$Ԭ, reason: contains not printable characters */
    public class RunnableC3188 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ UserBean f11287;

        public RunnableC3188(UserBean userBean) {
            this.f11287 = userBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11272.update(this.f11287);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$Ԯ, reason: contains not printable characters */
    public class RunnableC3189 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ UserBean f11289;

        public RunnableC3189(UserBean userBean) {
            this.f11289 = userBean;
        }

        @Override // java.lang.Runnable
        public void run() throws SQLException {
            C3184.this.f11272.deleteAll();
            this.f11289.setDb_id(System.currentTimeMillis());
            C3184.this.f11272.insert(this.f11289);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ՠ, reason: contains not printable characters */
    public class RunnableC3190 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ List f11291;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC3217 f11292;

        public RunnableC3190(List list, InterfaceC3217 interfaceC3217) {
            this.f11291 = list;
            this.f11292 = interfaceC3217;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r1.m8144(this.f11291)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (int i = 0; i < this.f11291.size(); i++) {
                    C2531 c2531 = (C2531) this.f11291.get(i);
                    if (c2531.m9345() == 0) {
                        c2531.m9351(i + jCurrentTimeMillis);
                    }
                }
                C3184.this.f11273.insertOrReplaceInTx(this.f11291);
                InterfaceC3217 interfaceC3217 = this.f11292;
                if (interfaceC3217 != null) {
                    interfaceC3217.mo10874();
                }
            }
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ֈ, reason: contains not printable characters */
    public class RunnableC3191 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3891 f11294;

        public RunnableC3191(C3891 c3891) {
            this.f11294 = c3891;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11268.insert(this.f11294);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$֏, reason: contains not printable characters */
    public class RunnableC3192 implements Runnable {
        public RunnableC3192() {
        }

        @Override // java.lang.Runnable
        public void run() throws SQLException {
            C3184.this.f11273.deleteAll();
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ׯ, reason: contains not printable characters */
    public class RunnableC3193 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ List f11297;

        public RunnableC3193(List list) {
            this.f11297 = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11273.deleteInTx(this.f11297);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ؠ, reason: contains not printable characters */
    public class RunnableC3194 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2531 f11299;

        public RunnableC3194(C2531 c2531) {
            this.f11299 = c2531;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11273.delete(this.f11299);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ހ, reason: contains not printable characters */
    public class RunnableC3195 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C5244 f11301;

        public RunnableC3195(C5244 c5244) {
            this.f11301 = c5244;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11301.m15271(System.currentTimeMillis());
            C3184.this.f11274.insert(this.f11301);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ށ, reason: contains not printable characters */
    public class RunnableC3196 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C5244 f11303;

        public RunnableC3196(C5244 c5244) {
            this.f11303 = c5244;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11274.update(this.f11303);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ނ, reason: contains not printable characters */
    public class RunnableC3197 implements Runnable {
        public RunnableC3197() {
        }

        @Override // java.lang.Runnable
        public void run() throws SQLException {
            C3184.this.f11275.deleteAll();
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ރ, reason: contains not printable characters */
    public class RunnableC3198 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ x7 f11306;

        public RunnableC3198(x7 x7Var) {
            this.f11306 = x7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11275.insertOrReplace(this.f11306);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ބ, reason: contains not printable characters */
    public class RunnableC3199 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ y7.InterfaceC2307 f11308;

        public RunnableC3199(y7.InterfaceC2307 interfaceC2307) {
            this.f11308 = interfaceC2307;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<x7> list;
            x7 x7Var = null;
            try {
                list = C3184.this.f11275.queryBuilder().list();
            } catch (Exception unused) {
                list = null;
            }
            if (list != null && list.size() > 0) {
                x7Var = list.get(0);
            }
            y7.InterfaceC2307 interfaceC2307 = this.f11308;
            if (interfaceC2307 != null) {
                interfaceC2307.mo433(x7Var);
            }
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ޅ, reason: contains not printable characters */
    public class RunnableC3200 implements Runnable {
        public RunnableC3200() {
        }

        @Override // java.lang.Runnable
        public void run() throws SQLException {
            C3184.this.f11276.deleteAll();
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ކ, reason: contains not printable characters */
    public class RunnableC3201 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3891 f11311;

        public RunnableC3201(C3891 c3891) {
            this.f11311 = c3891;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11268.delete(this.f11311);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$އ, reason: contains not printable characters */
    public class RunnableC3202 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3756 f11313;

        public RunnableC3202(C3756 c3756) {
            this.f11313 = c3756;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11276.delete(this.f11313);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ވ, reason: contains not printable characters */
    public class RunnableC3203 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3756 f11315;

        public RunnableC3203(C3756 c3756) {
            this.f11315 = c3756;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11276.insertOrReplace(this.f11315);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$މ, reason: contains not printable characters */
    public class RunnableC3204 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3287 f11317;

        public RunnableC3204(C3287 c3287) {
            this.f11317 = c3287;
        }

        @Override // java.lang.Runnable
        public void run() throws SQLException {
            C3184.this.f11277.deleteAll();
            this.f11317.m11050(System.currentTimeMillis());
            C3184.this.f11277.insert(this.f11317);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ފ, reason: contains not printable characters */
    public class RunnableC3205 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3287 f11319;

        public RunnableC3205(C3287 c3287) {
            this.f11319 = c3287;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11277.update(this.f11319);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ދ, reason: contains not printable characters */
    public class RunnableC3206 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ ACBanBean f11321;

        public RunnableC3206(ACBanBean aCBanBean) {
            this.f11321 = aCBanBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11321.setDb_id(System.currentTimeMillis());
            C3184.this.f11278.insert(this.f11321);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ތ, reason: contains not printable characters */
    public class RunnableC3207 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ ACBanBean f11323;

        public RunnableC3207(ACBanBean aCBanBean) {
            this.f11323 = aCBanBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11278.delete(this.f11323);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ލ, reason: contains not printable characters */
    public class RunnableC3208 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3699 f11325;

        public RunnableC3208(C3699 c3699) {
            this.f11325 = c3699;
        }

        @Override // java.lang.Runnable
        public void run() throws SQLException {
            C3184.this.f11279.deleteAll();
            this.f11325.m11847(System.currentTimeMillis());
            C3184.this.f11279.insert(this.f11325);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ގ, reason: contains not printable characters */
    public class RunnableC3209 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3699 f11327;

        public RunnableC3209(C3699 c3699) {
            this.f11327 = c3699;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11279.update(this.f11327);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ޏ, reason: contains not printable characters */
    public class RunnableC3210 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3891 f11329;

        public RunnableC3210(C3891 c3891) {
            this.f11329 = c3891;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11268.update(this.f11329);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ސ, reason: contains not printable characters */
    public class RunnableC3211 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3755 f11331;

        public RunnableC3211(C3755 c3755) {
            this.f11331 = c3755;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11269.insert(this.f11331);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ޑ, reason: contains not printable characters */
    public class RunnableC3212 implements Runnable {
        public RunnableC3212() {
        }

        @Override // java.lang.Runnable
        public void run() throws SQLException {
            C3184.this.f11269.deleteAll();
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ޒ, reason: contains not printable characters */
    public class RunnableC3213 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3755 f11334;

        public RunnableC3213(C3755 c3755) {
            this.f11334 = c3755;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11269.update(this.f11334);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ޓ, reason: contains not printable characters */
    public class RunnableC3214 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2628 f11336;

        public RunnableC3214(C2628 c2628) {
            this.f11336 = c2628;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11270.insert(this.f11336);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ޔ, reason: contains not printable characters */
    public class RunnableC3215 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2628 f11338;

        public RunnableC3215(C2628 c2628) {
            this.f11338 = c2628;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11270.delete(this.f11338);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ޕ, reason: contains not printable characters */
    public class RunnableC3216 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ List f11340;

        public RunnableC3216(List list) {
            this.f11340 = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184.this.f11270.deleteInTx(this.f11340);
        }
    }

    /* compiled from: DBManager.java */
    /* renamed from: Լ$ޖ, reason: contains not printable characters */
    public interface InterfaceC3217 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo10874();
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public static C3184 m10827() {
        if (f11266 == null) {
            synchronized (C3184.class) {
                if (f11266 == null) {
                    f11266 = new C3184();
                }
            }
        }
        return f11266;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m10828(C3891 c3891) {
        m10863(new RunnableC3191(c3891));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m10829(C2628 c2628) {
        m10863(new RunnableC3214(c2628));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m10830(C3755 c3755) {
        m10863(new RunnableC3211(c3755));
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m10831(C2949 c2949) {
        m10863(new RunnableC3186(c2949));
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m10832(List<C2531> list, InterfaceC3217 interfaceC3217) {
        m10863(new RunnableC3190(list, interfaceC3217));
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m10833(C5244 c5244) {
        m10863(new RunnableC3195(c5244));
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m10834(C3699 c3699) {
        m10863(new RunnableC3208(c3699));
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m10835(C3287 c3287) {
        m10863(new RunnableC3204(c3287));
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m10836(ACBanBean aCBanBean) {
        m10863(new RunnableC3206(aCBanBean));
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m10837(UserBean userBean) {
        m10863(new RunnableC3189(userBean));
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m10838() {
        m10863(new RunnableC3212());
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m10839() {
        m10863(new RunnableC3192());
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m10840(C3891 c3891) {
        m10863(new RunnableC3201(c3891));
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m10841(C2628 c2628) {
        m10863(new RunnableC3215(c2628));
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m10842(List<C2628> list) {
        m10863(new RunnableC3216(list));
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m10843(C2531 c2531) {
        m10863(new RunnableC3194(c2531));
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m10844(List<C2531> list) {
        m10863(new RunnableC3193(list));
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m10845() {
        m10863(new RunnableC3200());
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m10846(C3756 c3756) {
        m10863(new RunnableC3202(c3756));
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m10847() {
        this.f11272.deleteAll();
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m10848() {
        m10863(new RunnableC3197());
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m10849(Context context) {
        C3862 c3862M13216 = new C4188(new C2761(context, "film-db", null).getWritableDatabase()).m13216();
        this.f11267 = c3862M13216;
        this.f11280 = c3862M13216.startAsyncSession();
        this.f11268 = this.f11267.m12307();
        this.f11269 = this.f11267.m12301();
        this.f11270 = this.f11267.m12300();
        this.f11271 = this.f11267.m12302();
        this.f11272 = this.f11267.m12309();
        this.f11273 = this.f11267.m12303();
        this.f11274 = this.f11267.m12304();
        this.f11275 = this.f11267.m12310();
        this.f11276 = this.f11267.m12308();
        this.f11277 = this.f11267.m12306();
        this.f11279 = this.f11267.m12305();
        this.f11278 = this.f11267.m12299();
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public List<C3891> m10850() {
        List<C3891> list = this.f11268.queryBuilder().orderDesc(PresetBeanDao.Properties.Id).list();
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public List<C2628> m10851() {
        List<C2628> list = this.f11270.queryBuilder().orderDesc(ClipBeanDao.Properties.Id).list();
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public List<C3755> m10852() {
        List<C3755> list = this.f11269.queryBuilder().list();
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public List<C2949> m10853() {
        List<C2949> list = this.f11271.queryBuilder().orderDesc(LensInfoBeanDao.Properties.Id).list();
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public List<C2531> m10854() {
        List<C2531> list = this.f11273.queryBuilder().list();
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public List<C3756> m10855() {
        List<C3756> list = this.f11276.queryBuilder().list();
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public List<ACBanBean> m10856() {
        List<ACBanBean> list = this.f11278.queryBuilder().list();
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public C5244 m10857() {
        List<C5244> list = this.f11274.queryBuilder().list();
        if (r1.m8144(list)) {
            return list.get(0);
        }
        return null;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public C3699 m10858() {
        List<C3699> list = this.f11279.queryBuilder().list();
        if (r1.m8144(list)) {
            return list.get(0);
        }
        return null;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public C3287 m10859() {
        List<C3287> list = this.f11277.queryBuilder().list();
        if (r1.m8144(list)) {
            return list.get(0);
        }
        return null;
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public UserBean m10860() {
        List<UserBean> list = this.f11272.queryBuilder().list();
        if (r1.m8144(list)) {
            return list.get(0);
        }
        return null;
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public void m10861(y7.InterfaceC2307 interfaceC2307) {
        this.f11267.runInTx(new RunnableC3199(interfaceC2307));
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public void m10862(ACBanBean aCBanBean) {
        m10863(new RunnableC3207(aCBanBean));
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m10863(Runnable runnable) {
        this.f11280.runInTx(runnable);
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public void m10864(C3891 c3891) {
        m10863(new RunnableC3210(c3891));
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public void m10865(C2628 c2628) {
        m10863(new RunnableC3185(c2628));
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public void m10866(C3755 c3755) {
        m10863(new RunnableC3213(c3755));
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public void m10867(C2949 c2949) {
        m10863(new RunnableC3187(c2949));
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public void m10868(C5244 c5244) {
        m10863(new RunnableC3196(c5244));
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public void m10869(C3699 c3699) {
        m10863(new RunnableC3209(c3699));
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public void m10870(C3756 c3756) {
        m10863(new RunnableC3203(c3756));
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public void m10871(C3287 c3287) {
        m10863(new RunnableC3205(c3287));
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public void m10872(UserBean userBean) {
        m10863(new RunnableC3188(userBean));
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public void m10873(x7 x7Var) {
        m10863(new RunnableC3198(x7Var));
    }
}
