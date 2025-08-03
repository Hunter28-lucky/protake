package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import defpackage.C2679;
import defpackage.C3921;
import defpackage.C5241;
import defpackage.InterfaceC2392;
import defpackage.i4;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: AtomicFile.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    public static final byte[] readBytes(android.util.AtomicFile atomicFile) throws IOException {
        C3921.m12666(atomicFile, "<this>");
        byte[] fully = atomicFile.readFully();
        C3921.m12665(fully, "readFully()");
        return fully;
    }

    @RequiresApi(17)
    public static final String readText(android.util.AtomicFile atomicFile, Charset charset) throws IOException {
        C3921.m12666(atomicFile, "<this>");
        C3921.m12666(charset, "charset");
        byte[] fully = atomicFile.readFully();
        C3921.m12665(fully, "readFully()");
        return new String(fully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = C5241.f17365;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(android.util.AtomicFile atomicFile, InterfaceC2392<? super FileOutputStream, i4> interfaceC2392) throws IOException {
        C3921.m12666(atomicFile, "<this>");
        C3921.m12666(interfaceC2392, "block");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            C3921.m12665(fileOutputStreamStartWrite, "stream");
            interfaceC2392.invoke(fileOutputStreamStartWrite);
            C2679.m9826(1);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
            C2679.m9825(1);
        } catch (Throwable th) {
            C2679.m9826(1);
            atomicFile.failWrite(fileOutputStreamStartWrite);
            C2679.m9825(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(android.util.AtomicFile atomicFile, byte[] bArr) throws IOException {
        C3921.m12666(atomicFile, "<this>");
        C3921.m12666(bArr, "array");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            C3921.m12665(fileOutputStreamStartWrite, "stream");
            fileOutputStreamStartWrite.write(bArr);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(android.util.AtomicFile atomicFile, String str, Charset charset) throws IOException {
        C3921.m12666(atomicFile, "<this>");
        C3921.m12666(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        C3921.m12666(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        C3921.m12665(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = C5241.f17365;
        }
        writeText(atomicFile, str, charset);
    }
}
