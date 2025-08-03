package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import defpackage.C2679;
import defpackage.C3921;
import defpackage.InterfaceC2392;

/* compiled from: SQLiteDatabase.kt */
/* loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z, InterfaceC2392<? super SQLiteDatabase, ? extends T> interfaceC2392) {
        C3921.m12666(sQLiteDatabase, "<this>");
        C3921.m12666(interfaceC2392, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T tInvoke = interfaceC2392.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return tInvoke;
        } finally {
            C2679.m9826(1);
            sQLiteDatabase.endTransaction();
            C2679.m9825(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z, InterfaceC2392 interfaceC2392, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        C3921.m12666(sQLiteDatabase, "<this>");
        C3921.m12666(interfaceC2392, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object objInvoke = interfaceC2392.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return objInvoke;
        } finally {
            C2679.m9826(1);
            sQLiteDatabase.endTransaction();
            C2679.m9825(1);
        }
    }
}
