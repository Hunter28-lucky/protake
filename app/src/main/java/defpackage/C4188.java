package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
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
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* compiled from: DaoMaster.java */
/* renamed from: দ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4188 extends AbstractDaoMaster {

    /* compiled from: DaoMaster.java */
    /* renamed from: দ$Ϳ, reason: contains not printable characters */
    public static abstract class AbstractC4189 extends DatabaseOpenHelper {
        public AbstractC4189(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 69);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onCreate(Database database) {
            Log.i("greenDAO", "Creating tables for schema version 69");
            C4188.m13214(database, false);
        }
    }

    public C4188(SQLiteDatabase sQLiteDatabase) {
        this(new StandardDatabase(sQLiteDatabase));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13214(Database database, boolean z) {
        ContentNameBeanDao.m531(database, z);
        LensInfoBeanDao.m540(database, z);
        PresetBeanDao.m585(database, z);
        WeatherInfoBeanDao.m612(database, z);
        ClipBeanDao.m522(database, z);
        LocalFilterBeanDao.m549(database, z);
        LocalFilterGroupBeanDao.m558(database, z);
        LocalNvtInfoBeanDao.m567(database, z);
        LocalSubsInfoBeanDao.m576(database, z);
        PreviewIconBeanDao.m594(database, z);
        UserBeanDao.m603(database, z);
        ACBanBeanDao.m513(database, z);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m13215(Database database, boolean z) {
        ContentNameBeanDao.m532(database, z);
        LensInfoBeanDao.m541(database, z);
        PresetBeanDao.m586(database, z);
        WeatherInfoBeanDao.m613(database, z);
        ClipBeanDao.m523(database, z);
        LocalFilterBeanDao.m550(database, z);
        LocalFilterGroupBeanDao.m559(database, z);
        LocalNvtInfoBeanDao.m568(database, z);
        LocalSubsInfoBeanDao.m577(database, z);
        PreviewIconBeanDao.m595(database, z);
        UserBeanDao.m604(database, z);
        ACBanBeanDao.m514(database, z);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public C3862 m13216() {
        return new C3862(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public C4188(Database database) {
        super(database, 69);
        registerDaoClass(ContentNameBeanDao.class);
        registerDaoClass(LensInfoBeanDao.class);
        registerDaoClass(PresetBeanDao.class);
        registerDaoClass(WeatherInfoBeanDao.class);
        registerDaoClass(ClipBeanDao.class);
        registerDaoClass(LocalFilterBeanDao.class);
        registerDaoClass(LocalFilterGroupBeanDao.class);
        registerDaoClass(LocalNvtInfoBeanDao.class);
        registerDaoClass(LocalSubsInfoBeanDao.class);
        registerDaoClass(PreviewIconBeanDao.class);
        registerDaoClass(UserBeanDao.class);
        registerDaoClass(ACBanBeanDao.class);
    }
}
