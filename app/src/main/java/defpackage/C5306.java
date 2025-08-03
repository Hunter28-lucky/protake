package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Sink;
import okio.Source;

/* compiled from: FileSystem.kt */
/* renamed from: ჰ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5306 implements InterfaceC2635 {
    public String toString() {
        return "FileSystem.SYSTEM";
    }

    @Override // defpackage.InterfaceC2635
    /* renamed from: Ϳ */
    public Source mo9720(File file) throws FileNotFoundException {
        C3921.m12667(file, "file");
        return Okio.source(file);
    }

    @Override // defpackage.InterfaceC2635
    /* renamed from: Ԩ */
    public Sink mo9721(File file) throws FileNotFoundException {
        C3921.m12667(file, "file");
        try {
            return Okio__JvmOkioKt.sink$default(file, false, 1, null);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return Okio__JvmOkioKt.sink$default(file, false, 1, null);
        }
    }

    @Override // defpackage.InterfaceC2635
    /* renamed from: ԩ */
    public void mo9722(File file) throws IOException {
        C3921.m12667(file, "directory");
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            C3921.m12663(file2, "file");
            if (file2.isDirectory()) {
                mo9722(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete " + file2);
            }
        }
    }

    @Override // defpackage.InterfaceC2635
    /* renamed from: Ԫ */
    public boolean mo9723(File file) {
        C3921.m12667(file, "file");
        return file.exists();
    }

    @Override // defpackage.InterfaceC2635
    /* renamed from: ԫ */
    public void mo9724(File file, File file2) throws IOException {
        C3921.m12667(file, TypedValues.TransitionType.S_FROM);
        C3921.m12667(file2, TypedValues.TransitionType.S_TO);
        mo9725(file2);
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException("failed to rename " + file + " to " + file2);
    }

    @Override // defpackage.InterfaceC2635
    /* renamed from: Ԭ */
    public void mo9725(File file) throws IOException {
        C3921.m12667(file, "file");
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("failed to delete " + file);
    }

    @Override // defpackage.InterfaceC2635
    /* renamed from: ԭ */
    public Sink mo9726(File file) throws FileNotFoundException {
        C3921.m12667(file, "file");
        try {
            return Okio.appendingSink(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return Okio.appendingSink(file);
        }
    }

    @Override // defpackage.InterfaceC2635
    /* renamed from: Ԯ */
    public long mo9727(File file) {
        C3921.m12667(file, "file");
        return file.length();
    }
}
