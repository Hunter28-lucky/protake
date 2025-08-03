package okio;

import com.polidea.rxandroidble2.ClientComponent;
import defpackage.C3921;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: JvmOkio.kt */
/* loaded from: classes2.dex */
final class SocketAsyncTimeout extends AsyncTimeout {
    private final Logger logger;
    private final Socket socket;

    public SocketAsyncTimeout(Socket socket) {
        C3921.m12667(socket, "socket");
        this.socket = socket;
        this.logger = Logger.getLogger("okio.Okio");
    }

    @Override // okio.AsyncTimeout
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException(ClientComponent.NamedSchedulers.TIMEOUT);
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    public void timedOut() throws IOException {
        try {
            this.socket.close();
        } catch (AssertionError e2) {
            if (!Okio.isAndroidGetsocknameError(e2)) {
                throw e2;
            }
            this.logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e2);
        } catch (Exception e3) {
            this.logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e3);
        }
    }
}
