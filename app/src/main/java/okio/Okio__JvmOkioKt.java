package okio;

import defpackage.C3921;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: JvmOkio.kt */
/* loaded from: classes2.dex */
final /* synthetic */ class Okio__JvmOkioKt {
    public static final Sink appendingSink(File file) throws FileNotFoundException {
        C3921.m12667(file, "$this$appendingSink");
        return Okio.sink(new FileOutputStream(file, true));
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        C3921.m12667(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt__StringsKt.m7275(message, "getsockname failed", false, 2, null) : false;
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        return sink$default(file, false, 1, null);
    }

    public static final Sink sink(OutputStream outputStream) {
        C3921.m12667(outputStream, "$this$sink");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    public static final Source source(InputStream inputStream) {
        C3921.m12667(inputStream, "$this$source");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Sink sink(Socket socket) throws IOException {
        C3921.m12667(socket, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        C3921.m12663(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static final Source source(Socket socket) throws IOException {
        C3921.m12667(socket, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        C3921.m12663(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    public static final Sink sink(File file, boolean z) throws FileNotFoundException {
        C3921.m12667(file, "$this$sink");
        return Okio.sink(new FileOutputStream(file, z));
    }

    public static final Source source(File file) throws FileNotFoundException {
        C3921.m12667(file, "$this$source");
        return Okio.source(new FileInputStream(file));
    }

    @IgnoreJRERequirement
    public static final Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        C3921.m12667(path, "$this$sink");
        C3921.m12667(openOptionArr, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C3921.m12663(outputStreamNewOutputStream, "Files.newOutputStream(this, *options)");
        return Okio.sink(outputStreamNewOutputStream);
    }

    @IgnoreJRERequirement
    public static final Source source(Path path, OpenOption... openOptionArr) throws IOException {
        C3921.m12667(path, "$this$source");
        C3921.m12667(openOptionArr, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C3921.m12663(inputStreamNewInputStream, "Files.newInputStream(this, *options)");
        return Okio.source(inputStreamNewInputStream);
    }
}
