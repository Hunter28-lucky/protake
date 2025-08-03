package retrofit2.adapter.rxjava2;

import defpackage.AbstractC2900;
import defpackage.AbstractC3630;
import defpackage.AbstractC4262;
import defpackage.AbstractC4274;
import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;

    @Nullable
    private final AbstractC4585 scheduler;

    private RxJava2CallAdapterFactory(@Nullable AbstractC4585 abstractC4585, boolean z) {
        this.scheduler = abstractC4585;
        this.isAsync = z;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(AbstractC4585 abstractC4585) {
        if (abstractC4585 != null) {
            return new RxJava2CallAdapterFactory(abstractC4585, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type parameterUpperBound;
        boolean z;
        boolean z2;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == AbstractC2900.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        boolean z3 = rawType == AbstractC3630.class;
        boolean z4 = rawType == AbstractC4838.class;
        boolean z5 = rawType == AbstractC4274.class;
        if (rawType != AbstractC4262.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound2);
        if (rawType2 == Response.class) {
            if (!(parameterUpperBound2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound2);
            z2 = false;
            z = false;
        } else if (rawType2 != Result.class) {
            parameterUpperBound = parameterUpperBound2;
            z = true;
            z2 = false;
        } else {
            if (!(parameterUpperBound2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound2);
            z2 = true;
            z = false;
        }
        return new RxJava2CallAdapter(parameterUpperBound, this.scheduler, this.isAsync, z2, z, z3, z4, z5, false);
    }
}
