package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamEncoder.java */
/* loaded from: classes.dex */
public class p implements InterfaceC3823<InputStream> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4950 f8237;

    public p(InterfaceC4950 interfaceC4950) {
        this.f8237 = interfaceC4950;
    }

    @Override // defpackage.InterfaceC3823
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7881(@NonNull InputStream inputStream, @NonNull File file, @NonNull C3475 c3475) throws Throwable {
        byte[] bArr = (byte[]) this.f8237.mo9474(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, i);
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            if (Log.isLoggable("StreamEncoder", 3)) {
                                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.f8237.put(bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.f8237.put(bArr);
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    z = true;
                    fileOutputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException unused2) {
        }
        this.f8237.put(bArr);
        return z;
    }
}
