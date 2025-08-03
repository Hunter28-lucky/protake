package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import defpackage.AbstractC4809;
import java.io.IOException;
import retrofit2.Converter;

/* loaded from: classes2.dex */
final class GsonResponseBodyConverter<T> implements Converter<AbstractC4809, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    @Override // retrofit2.Converter
    public T convert(AbstractC4809 abstractC4809) throws IOException {
        try {
            return this.adapter.read2(this.gson.newJsonReader(abstractC4809.charStream()));
        } finally {
            abstractC4809.close();
        }
    }
}
