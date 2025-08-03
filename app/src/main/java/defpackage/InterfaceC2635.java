package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;

/* compiled from: FileSystem.kt */
/* renamed from: ɽ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC2635 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C2636 f9814 = new C2636(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC2635 f9813 = new C5306();

    /* compiled from: FileSystem.kt */
    /* renamed from: ɽ$Ϳ, reason: contains not printable characters */
    public static final class C2636 {
        public C2636() {
        }

        public /* synthetic */ C2636(C4184 c4184) {
            this();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    Source mo9720(File file) throws FileNotFoundException;

    /* renamed from: Ԩ, reason: contains not printable characters */
    Sink mo9721(File file) throws FileNotFoundException;

    /* renamed from: ԩ, reason: contains not printable characters */
    void mo9722(File file) throws IOException;

    /* renamed from: Ԫ, reason: contains not printable characters */
    boolean mo9723(File file);

    /* renamed from: ԫ, reason: contains not printable characters */
    void mo9724(File file, File file2) throws IOException;

    /* renamed from: Ԭ, reason: contains not printable characters */
    void mo9725(File file) throws IOException;

    /* renamed from: ԭ, reason: contains not printable characters */
    Sink mo9726(File file) throws FileNotFoundException;

    /* renamed from: Ԯ, reason: contains not printable characters */
    long mo9727(File file);
}
