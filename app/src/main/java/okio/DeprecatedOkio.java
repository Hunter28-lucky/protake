package okio;

import defpackage.C3921;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;

/* compiled from: -DeprecatedOkio.kt */
/* renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* loaded from: classes2.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    public final Sink appendingSink(File file) {
        C3921.m12667(file, "file");
        return Okio.appendingSink(file);
    }

    public final Sink blackhole() {
        return Okio.blackhole();
    }

    public final BufferedSink buffer(Sink sink) {
        C3921.m12667(sink, "sink");
        return Okio.buffer(sink);
    }

    public final Sink sink(File file) {
        C3921.m12667(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    public final Source source(File file) {
        C3921.m12667(file, "file");
        return Okio.source(file);
    }

    public final BufferedSource buffer(Source source) {
        C3921.m12667(source, "source");
        return Okio.buffer(source);
    }

    public final Sink sink(OutputStream outputStream) {
        C3921.m12667(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    public final Source source(InputStream inputStream) {
        C3921.m12667(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    public final Sink sink(Path path, OpenOption... openOptionArr) {
        C3921.m12667(path, "path");
        C3921.m12667(openOptionArr, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Source source(Path path, OpenOption... openOptionArr) {
        C3921.m12667(path, "path");
        C3921.m12667(openOptionArr, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Sink sink(Socket socket) {
        C3921.m12667(socket, "socket");
        return Okio.sink(socket);
    }

    public final Source source(Socket socket) {
        C3921.m12667(socket, "socket");
        return Okio.source(socket);
    }
}
