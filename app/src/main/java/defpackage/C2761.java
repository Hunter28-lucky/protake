package defpackage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
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
import defpackage.C4188;
import defpackage.C4986;
import java.io.File;
import org.greenrobot.greendao.database.Database;

/* compiled from: DbOpenHelper.java */
/* renamed from: ͷ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2761 extends C4188.AbstractC4189 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean f10102 = false;

    /* compiled from: DbOpenHelper.java */
    /* renamed from: ͷ$Ϳ, reason: contains not printable characters */
    public class C2762 implements C4986.InterfaceC4987 {
        public C2762() {
        }

        @Override // defpackage.C4986.InterfaceC4987
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo10014(Database database, boolean z) {
            C4188.m13214(database, z);
        }

        @Override // defpackage.C4986.InterfaceC4987
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo10015(Database database, boolean z) {
            C4188.m13215(database, z);
        }
    }

    public C2761(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, str, cursorFactory);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() throws SQLException {
        if (f10102) {
            return super.getWritableDatabase();
        }
        f10102 = true;
        try {
            new File("/data/data/com.blink.academy/databases/main").mkdir();
            super.getWritableDatabase().execSQL("PRAGMA temp_store_directory = '/data/data/com.blink.academy/databases/main'");
        } catch (Exception unused) {
        }
        return super.getWritableDatabase();
    }

    @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
    public void onUpgrade(Database database, int i, int i2) throws Throwable {
        super.onUpgrade(database, i, i2);
        C4986.m14778(database, new C2762(), PresetBeanDao.class, ContentNameBeanDao.class, ClipBeanDao.class, LensInfoBeanDao.class, UserBeanDao.class, LocalFilterBeanDao.class, LocalFilterGroupBeanDao.class, WeatherInfoBeanDao.class, PreviewIconBeanDao.class, LocalSubsInfoBeanDao.class, ACBanBeanDao.class, LocalNvtInfoBeanDao.class);
    }
}
