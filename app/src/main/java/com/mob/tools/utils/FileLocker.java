package com.mob.tools.utils;

import android.os.SystemClock;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* loaded from: classes2.dex */
public class FileLocker implements PublicMemberKeeper {
    private FileOutputStream a;
    private FileLock b;

    private boolean a(boolean z) throws Throwable {
        if (z) {
            this.b = this.a.getChannel().lock();
        } else {
            this.b = this.a.getChannel().tryLock();
        }
        return this.b != null;
    }

    public synchronized boolean lock(boolean z) {
        return lock(z, z ? 1000L : 500L, 16L);
    }

    public synchronized void release() {
        if (this.a == null) {
            return;
        }
        unlock();
        try {
            this.a.close();
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    public synchronized void setLockFile(String str) {
        try {
            this.a = new FileOutputStream(str);
        } catch (Throwable unused) {
            FileOutputStream fileOutputStream = this.a;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                this.a = null;
            }
        }
    }

    public synchronized void unlock() {
        FileLock fileLock = this.b;
        if (fileLock == null) {
            return;
        }
        try {
            fileLock.release();
        } catch (Throwable unused) {
        }
        this.b = null;
    }

    public synchronized boolean lock(boolean z, long j, long j2) {
        boolean zA;
        if (this.a == null) {
            return false;
        }
        try {
            return a(z);
        } catch (Throwable th) {
            if (j <= 0 || !(th instanceof OverlappingFileLockException)) {
                MobLog.getInstance().w(th);
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
                while (true) {
                    if (j <= 0) {
                        zA = false;
                        break;
                    }
                    try {
                        Thread.sleep(j2);
                    } catch (Throwable unused) {
                    }
                    try {
                        j = jElapsedRealtime - SystemClock.elapsedRealtime();
                        zA = a(z);
                        break;
                    } catch (Throwable th2) {
                        if (!(th2 instanceof OverlappingFileLockException)) {
                            MobLog.getInstance().w(th);
                            j = -1;
                        } else if (j <= 0) {
                            MobLog.getInstance().w("OverlappingFileLockException and timeout");
                        }
                    }
                }
                if (j > 0) {
                    return zA;
                }
            }
            FileLock fileLock = this.b;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Throwable unused2) {
                }
                this.b = null;
            }
            FileOutputStream fileOutputStream = this.a;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused3) {
                }
                this.a = null;
            }
            return false;
        }
    }

    public synchronized void lock(Runnable runnable, boolean z) {
        if (lock(z) && runnable != null) {
            runnable.run();
        }
    }
}
