package defpackage;

import android.app.usage.StorageStatsManager;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStatVfs;
import androidx.annotation.RequiresApi;
import com.blink.academy.film.FilmApp;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* compiled from: StorageUtil.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static m f7959;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f7960;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f7961;

    /* renamed from: ԫ, reason: contains not printable characters */
    public StorageManager f7964;

    /* renamed from: ԩ, reason: contains not printable characters */
    public HashSet<Uri> f7962 = new HashSet<>();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public List<StorageVolume> f7963 = new ArrayList();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public HashMap<String, C2171> f7965 = new HashMap<>();

    /* compiled from: StorageUtil.java */
    /* renamed from: m$Ԩ, reason: contains not printable characters */
    public class C2171 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public StorageVolume f7966;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public long f7967;

        /* renamed from: ԩ, reason: contains not printable characters */
        public long f7968;

        public C2171(StorageVolume storageVolume, long j, long j2) {
            this.f7966 = storageVolume;
            this.f7967 = j;
            this.f7968 = j2;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static m m7511() {
        synchronized (m.class) {
            if (f7959 == null) {
                f7959 = new m();
            }
        }
        return f7959;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m7512() {
        List<UriPermission> persistedUriPermissions = FilmApp.m402().getContentResolver().getPersistedUriPermissions();
        this.f7962.clear();
        Iterator<UriPermission> it = persistedUriPermissions.iterator();
        while (it.hasNext()) {
            this.f7962.add(it.next().getUri());
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m7513(int i, int i2) throws ErrnoException {
        File file;
        long jM7515;
        this.f7960 = i2;
        if (C2813.m10150() && i2 == 0) {
            m7512();
            m7517();
            C2171 c2171 = this.f7965.get("android.os.storage.extra.STORAGE_VOLUME");
            Objects.requireNonNull(c2171);
            jM7515 = c2171.f7968;
        } else {
            if (i2 == 0) {
                file = Environment.getExternalStorageDirectory();
            } else {
                C4638.m14100("mSdPath: " + this.f7961);
                file = new File(this.f7961);
            }
            jM7515 = m7515(file);
        }
        return o4.m7683(jM7515, i);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m7514() {
        return this.f7960;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final long m7515(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String m7516() {
        try {
            String[] strArr = (String[]) StorageManager.class.getMethod("getVolumePaths", new Class[0]).invoke((StorageManager) FilmApp.m402().getSystemService("storage"), new Object[0]);
            if (strArr.length <= 1) {
                return null;
            }
            return strArr[1];
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @RequiresApi(api = 26)
    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m7517() throws ErrnoException {
        long j;
        long freeBytes;
        String str;
        try {
            StorageManager storageManager = (StorageManager) FilmApp.m402().getSystemService("storage");
            this.f7964 = storageManager;
            if (storageManager == null) {
                return;
            }
            List<StorageVolume> storageVolumes = storageManager.getStorageVolumes();
            this.f7963 = storageVolumes;
            Iterator<StorageVolume> it = storageVolumes.iterator();
            long j2 = 0;
            long j3 = 0;
            while (it.hasNext()) {
                StorageVolume next = it.next();
                if (next.isPrimary()) {
                    UUID uuid = StorageManager.UUID_DEFAULT;
                    StorageStatsManager storageStatsManager = (StorageStatsManager) FilmApp.m402().getSystemService("storagestats");
                    if (storageStatsManager == null) {
                        return;
                    }
                    long totalBytes = storageStatsManager.getTotalBytes(uuid);
                    str = "android.os.storage.extra.STORAGE_VOLUME";
                    freeBytes = storageStatsManager.getFreeBytes(uuid);
                    j = totalBytes;
                } else {
                    String strM7516 = m7516();
                    if (next.getState().equals("mounted")) {
                        StructStatVfs structStatVfsStatvfs = Os.statvfs(strM7516);
                        long j4 = structStatVfsStatvfs.f_bsize;
                        long j5 = structStatVfsStatvfs.f_blocks * j4;
                        freeBytes = structStatVfsStatvfs.f_bavail * j4;
                        str = strM7516;
                        j = j5;
                    } else {
                        j = j2;
                        freeBytes = j3;
                        str = strM7516;
                    }
                }
                Iterator<StorageVolume> it2 = it;
                this.f7965.put(str, new C2171(next, j, freeBytes));
                j2 = j;
                j3 = freeBytes;
                it = it2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m7518() {
        if (C2813.m10150()) {
            Iterator<Uri> it = this.f7962.iterator();
            while (it.hasNext()) {
                FilmApp.m402().getContentResolver().releasePersistableUriPermission(it.next(), 3);
            }
        }
    }
}
