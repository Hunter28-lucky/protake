package retrofit2;

import defpackage.AbstractC4809;
import defpackage.C4539;
import defpackage.C4770;
import defpackage.C5207;
import javax.annotation.Nullable;
import okhttp3.Protocol;

/* loaded from: classes2.dex */
public final class Response<T> {

    @Nullable
    private final T body;

    @Nullable
    private final AbstractC4809 errorBody;
    private final C4770 rawResponse;

    private Response(C4770 c4770, @Nullable T t, @Nullable AbstractC4809 abstractC4809) {
        this.rawResponse = c4770;
        this.body = t;
        this.errorBody = abstractC4809;
    }

    public static <T> Response<T> error(int i, AbstractC4809 abstractC4809) {
        if (i >= 400) {
            return error(abstractC4809, new C4770.C4771().m14355(i).m14361("Response.error()").m14364(Protocol.HTTP_1_1).m14367(new C4539.C4540().m13935("http://localhost/").m13927()).m14351());
        }
        throw new IllegalArgumentException("code < 400: " + i);
    }

    public static <T> Response<T> success(@Nullable T t) {
        return success(t, new C4770.C4771().m14355(200).m14361("OK").m14364(Protocol.HTTP_1_1).m14367(new C4539.C4540().m13935("http://localhost/").m13927()).m14351());
    }

    @Nullable
    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.m14334();
    }

    @Nullable
    public AbstractC4809 errorBody() {
        return this.errorBody;
    }

    public C5207 headers() {
        return this.rawResponse.m14339();
    }

    public boolean isSuccessful() {
        return this.rawResponse.m14340();
    }

    public String message() {
        return this.rawResponse.m14341();
    }

    public C4770 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(@Nullable T t, C5207 c5207) {
        Utils.checkNotNull(c5207, "headers == null");
        return success(t, new C4770.C4771().m14355(200).m14361("OK").m14364(Protocol.HTTP_1_1).m14359(c5207).m14367(new C4539.C4540().m13935("http://localhost/").m13927()).m14351());
    }

    public static <T> Response<T> error(AbstractC4809 abstractC4809, C4770 c4770) {
        Utils.checkNotNull(abstractC4809, "body == null");
        Utils.checkNotNull(c4770, "rawResponse == null");
        if (!c4770.m14340()) {
            return new Response<>(c4770, null, abstractC4809);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(@Nullable T t, C4770 c4770) {
        Utils.checkNotNull(c4770, "rawResponse == null");
        if (c4770.m14340()) {
            return new Response<>(c4770, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
