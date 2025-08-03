package defpackage;

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
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

/* compiled from: DaoSession.java */
/* renamed from: ߢ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3862 extends AbstractDaoSession {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final DaoConfig f13278;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final DaoConfig f13279;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final DaoConfig f13280;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final DaoConfig f13281;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final DaoConfig f13282;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final DaoConfig f13283;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final DaoConfig f13284;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final DaoConfig f13285;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final DaoConfig f13286;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final DaoConfig f13287;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final DaoConfig f13288;

    /* renamed from: ֏, reason: contains not printable characters */
    public final DaoConfig f13289;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final ContentNameBeanDao f13290;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final LensInfoBeanDao f13291;

    /* renamed from: ހ, reason: contains not printable characters */
    public final PresetBeanDao f13292;

    /* renamed from: ށ, reason: contains not printable characters */
    public final WeatherInfoBeanDao f13293;

    /* renamed from: ނ, reason: contains not printable characters */
    public final ClipBeanDao f13294;

    /* renamed from: ރ, reason: contains not printable characters */
    public final LocalFilterBeanDao f13295;

    /* renamed from: ބ, reason: contains not printable characters */
    public final LocalFilterGroupBeanDao f13296;

    /* renamed from: ޅ, reason: contains not printable characters */
    public final LocalNvtInfoBeanDao f13297;

    /* renamed from: ކ, reason: contains not printable characters */
    public final LocalSubsInfoBeanDao f13298;

    /* renamed from: އ, reason: contains not printable characters */
    public final PreviewIconBeanDao f13299;

    /* renamed from: ވ, reason: contains not printable characters */
    public final UserBeanDao f13300;

    /* renamed from: މ, reason: contains not printable characters */
    public final ACBanBeanDao f13301;

    public C3862(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig daoConfigClone = map.get(ContentNameBeanDao.class).clone();
        this.f13278 = daoConfigClone;
        daoConfigClone.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone2 = map.get(LensInfoBeanDao.class).clone();
        this.f13279 = daoConfigClone2;
        daoConfigClone2.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone3 = map.get(PresetBeanDao.class).clone();
        this.f13280 = daoConfigClone3;
        daoConfigClone3.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone4 = map.get(WeatherInfoBeanDao.class).clone();
        this.f13281 = daoConfigClone4;
        daoConfigClone4.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone5 = map.get(ClipBeanDao.class).clone();
        this.f13282 = daoConfigClone5;
        daoConfigClone5.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone6 = map.get(LocalFilterBeanDao.class).clone();
        this.f13283 = daoConfigClone6;
        daoConfigClone6.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone7 = map.get(LocalFilterGroupBeanDao.class).clone();
        this.f13284 = daoConfigClone7;
        daoConfigClone7.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone8 = map.get(LocalNvtInfoBeanDao.class).clone();
        this.f13285 = daoConfigClone8;
        daoConfigClone8.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone9 = map.get(LocalSubsInfoBeanDao.class).clone();
        this.f13286 = daoConfigClone9;
        daoConfigClone9.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone10 = map.get(PreviewIconBeanDao.class).clone();
        this.f13287 = daoConfigClone10;
        daoConfigClone10.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone11 = map.get(UserBeanDao.class).clone();
        this.f13288 = daoConfigClone11;
        daoConfigClone11.initIdentityScope(identityScopeType);
        DaoConfig daoConfigClone12 = map.get(ACBanBeanDao.class).clone();
        this.f13289 = daoConfigClone12;
        daoConfigClone12.initIdentityScope(identityScopeType);
        ContentNameBeanDao contentNameBeanDao = new ContentNameBeanDao(daoConfigClone, this);
        this.f13290 = contentNameBeanDao;
        LensInfoBeanDao lensInfoBeanDao = new LensInfoBeanDao(daoConfigClone2, this);
        this.f13291 = lensInfoBeanDao;
        PresetBeanDao presetBeanDao = new PresetBeanDao(daoConfigClone3, this);
        this.f13292 = presetBeanDao;
        WeatherInfoBeanDao weatherInfoBeanDao = new WeatherInfoBeanDao(daoConfigClone4, this);
        this.f13293 = weatherInfoBeanDao;
        ClipBeanDao clipBeanDao = new ClipBeanDao(daoConfigClone5, this);
        this.f13294 = clipBeanDao;
        LocalFilterBeanDao localFilterBeanDao = new LocalFilterBeanDao(daoConfigClone6, this);
        this.f13295 = localFilterBeanDao;
        LocalFilterGroupBeanDao localFilterGroupBeanDao = new LocalFilterGroupBeanDao(daoConfigClone7, this);
        this.f13296 = localFilterGroupBeanDao;
        LocalNvtInfoBeanDao localNvtInfoBeanDao = new LocalNvtInfoBeanDao(daoConfigClone8, this);
        this.f13297 = localNvtInfoBeanDao;
        LocalSubsInfoBeanDao localSubsInfoBeanDao = new LocalSubsInfoBeanDao(daoConfigClone9, this);
        this.f13298 = localSubsInfoBeanDao;
        PreviewIconBeanDao previewIconBeanDao = new PreviewIconBeanDao(daoConfigClone10, this);
        this.f13299 = previewIconBeanDao;
        UserBeanDao userBeanDao = new UserBeanDao(daoConfigClone11, this);
        this.f13300 = userBeanDao;
        ACBanBeanDao aCBanBeanDao = new ACBanBeanDao(daoConfigClone12, this);
        this.f13301 = aCBanBeanDao;
        registerDao(C3755.class, contentNameBeanDao);
        registerDao(C2949.class, lensInfoBeanDao);
        registerDao(C3891.class, presetBeanDao);
        registerDao(x7.class, weatherInfoBeanDao);
        registerDao(C2628.class, clipBeanDao);
        registerDao(C2531.class, localFilterBeanDao);
        registerDao(C5244.class, localFilterGroupBeanDao);
        registerDao(C3699.class, localNvtInfoBeanDao);
        registerDao(C3287.class, localSubsInfoBeanDao);
        registerDao(C3756.class, previewIconBeanDao);
        registerDao(UserBean.class, userBeanDao);
        registerDao(ACBanBean.class, aCBanBeanDao);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public ACBanBeanDao m12299() {
        return this.f13301;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public ClipBeanDao m12300() {
        return this.f13294;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public ContentNameBeanDao m12301() {
        return this.f13290;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public LensInfoBeanDao m12302() {
        return this.f13291;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public LocalFilterBeanDao m12303() {
        return this.f13295;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public LocalFilterGroupBeanDao m12304() {
        return this.f13296;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public LocalNvtInfoBeanDao m12305() {
        return this.f13297;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public LocalSubsInfoBeanDao m12306() {
        return this.f13298;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public PresetBeanDao m12307() {
        return this.f13292;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public PreviewIconBeanDao m12308() {
        return this.f13299;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public UserBeanDao m12309() {
        return this.f13300;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public WeatherInfoBeanDao m12310() {
        return this.f13293;
    }
}
