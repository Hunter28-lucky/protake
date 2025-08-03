package defpackage;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

/* compiled from: MigrationHelper.java */
/* renamed from: ຫ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4986 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static WeakReference<InterfaceC4987> f16740;

    /* compiled from: MigrationHelper.java */
    /* renamed from: ຫ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC4987 {
        /* renamed from: Ϳ */
        void mo10014(Database database, boolean z);

        /* renamed from: Ԩ */
        void mo10015(Database database, boolean z);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m14772(Database database, boolean z, @NonNull Class<? extends AbstractDao<?, ?>>... clsArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m14780(database, "createTable", z, clsArr);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m14773(Database database, boolean z, @NonNull Class<? extends AbstractDao<?, ?>>... clsArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m14780(database, "dropTable", z, clsArr);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m14774(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str = daoConfig.tablename;
            if (m14777(database, false, str)) {
                try {
                    String strConcat = daoConfig.tablename.concat("_TEMP");
                    database.execSQL("DROP TABLE IF EXISTS " + strConcat + ";");
                    database.execSQL("CREATE TEMPORARY TABLE " + strConcat + " AS SELECT * FROM " + str + ";");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static List<String> m14775(Database database, String str) throws Throwable {
        Cursor cursor = null;
        listAsList = null;
        List<String> listAsList = null;
        cursor = null;
        try {
            try {
                Cursor cursorRawQuery = database.rawQuery("SELECT * FROM " + str + " limit 0", null);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.getColumnCount() > 0) {
                            listAsList = Arrays.asList(cursorRawQuery.getColumnNames());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = cursorRawQuery;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return new ArrayList();
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        new ArrayList();
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return listAsList == null ? new ArrayList() : listAsList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static Object m14776(Class<?> cls) {
        return cls.equals(Integer.TYPE) ? " INTEGER DEFAULT 0" : cls.equals(Long.TYPE) ? " Long DEFAULT 0" : cls.equals(String.class) ? " TEXT " : cls.equals(Boolean.TYPE) ? " NUMERIC DEFAULT 0" : cls.equals(Float.TYPE) ? " Float DEFAULT 0" : " TEXT";
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m14777(Database database, boolean z, String str) {
        int i;
        if (database == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = database.rawQuery("SELECT COUNT(*) FROM " + (z ? "sqlite_temp_master" : "sqlite_master") + " WHERE type = ? AND name = ?", new String[]{"table", str});
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                i = 0;
            }
            if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                i = cursorRawQuery.getInt(0);
                cursorRawQuery.close();
                return i > 0;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m14778(Database database, InterfaceC4987 interfaceC4987, Class<? extends AbstractDao<?, ?>>... clsArr) throws Throwable {
        f16740 = new WeakReference<>(interfaceC4987);
        m14779(database, clsArr);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static void m14779(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) throws Throwable {
        m14774(database, clsArr);
        WeakReference<InterfaceC4987> weakReference = f16740;
        InterfaceC4987 interfaceC4987 = weakReference != null ? weakReference.get() : null;
        if (interfaceC4987 != null) {
            interfaceC4987.mo10015(database, true);
            interfaceC4987.mo10014(database, false);
        } else {
            m14773(database, true, clsArr);
            m14772(database, false, clsArr);
        }
        m14781(database, clsArr);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m14780(Database database, String str, boolean z, @NonNull Class<? extends AbstractDao<?, ?>>... clsArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (clsArr.length < 1) {
            return;
        }
        try {
            for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
                cls.getDeclaredMethod(str, Database.class, Boolean.TYPE).invoke(null, database, Boolean.valueOf(z));
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m14781(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) throws Throwable {
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str = daoConfig.tablename;
            String strConcat = str.concat("_TEMP");
            if (m14777(database, true, strConcat)) {
                try {
                    List<String> listM14775 = m14775(database, strConcat);
                    ArrayList arrayList = new ArrayList(listM14775.size());
                    int i = 0;
                    while (true) {
                        Property[] propertyArr = daoConfig.properties;
                        if (i >= propertyArr.length) {
                            break;
                        }
                        String str2 = propertyArr[i].columnName;
                        if (!listM14775.contains(str2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ALTER TABLE " + strConcat + " ADD COLUMN " + str2 + m14776(daoConfig.properties[i].type));
                            database.execSQL(sb.toString());
                        }
                        arrayList.add(str2);
                        i++;
                    }
                    if (arrayList.size() > 0) {
                        String strJoin = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList);
                        database.execSQL("REPLACE INTO " + str + " (" + strJoin + ") SELECT " + strJoin + " FROM " + strConcat + ";");
                    }
                    database.execSQL("DROP TABLE " + strConcat);
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
