package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import defpackage.AbstractC2613;
import defpackage.C2314;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okio.Buffer;
import org.jcodec.platform.Platform;
import retrofit2.Converter;

/* loaded from: classes2.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, AbstractC2613> {
    private static final C2314 MEDIA_TYPE = C2314.m8683("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName(Platform.UTF_8);
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ AbstractC2613 convert(Object obj) throws IOException {
        return convert((GsonRequestBodyConverter<T>) obj);
    }

    @Override // retrofit2.Converter
    public AbstractC2613 convert(T t) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter jsonWriterNewJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), UTF_8));
        this.adapter.write(jsonWriterNewJsonWriter, t);
        jsonWriterNewJsonWriter.close();
        return AbstractC2613.create(MEDIA_TYPE, buffer.readByteString());
    }
}
