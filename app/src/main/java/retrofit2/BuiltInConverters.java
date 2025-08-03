package retrofit2;

import defpackage.AbstractC2613;
import defpackage.AbstractC4809;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* loaded from: classes2.dex */
final class BuiltInConverters extends Converter.Factory {

    public static final class BufferingResponseBodyConverter implements Converter<AbstractC4809, AbstractC4809> {
        public static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        @Override // retrofit2.Converter
        public AbstractC4809 convert(AbstractC4809 abstractC4809) throws IOException {
            try {
                return Utils.buffer(abstractC4809);
            } finally {
                abstractC4809.close();
            }
        }
    }

    public static final class RequestBodyConverter implements Converter<AbstractC2613, AbstractC2613> {
        public static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        @Override // retrofit2.Converter
        public AbstractC2613 convert(AbstractC2613 abstractC2613) {
            return abstractC2613;
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter<AbstractC4809, AbstractC4809> {
        public static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        @Override // retrofit2.Converter
        public AbstractC4809 convert(AbstractC4809 abstractC4809) {
            return abstractC4809;
        }
    }

    public static final class ToStringConverter implements Converter<Object, String> {
        public static final ToStringConverter INSTANCE = new ToStringConverter();

        @Override // retrofit2.Converter
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    public static final class VoidResponseBodyConverter implements Converter<AbstractC4809, Void> {
        public static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        @Override // retrofit2.Converter
        public Void convert(AbstractC4809 abstractC4809) {
            abstractC4809.close();
            return null;
        }
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, AbstractC2613> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (AbstractC2613.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<AbstractC4809, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == AbstractC4809.class) {
            return Utils.isAnnotationPresent(annotationArr, Streaming.class) ? StreamingResponseBodyConverter.INSTANCE : BufferingResponseBodyConverter.INSTANCE;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        return null;
    }
}
