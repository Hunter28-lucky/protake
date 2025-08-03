package defpackage;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class nd implements FileFilter {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final /* synthetic */ wc f8057;

    public nd(wc wcVar) {
        this.f8057 = wcVar;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
