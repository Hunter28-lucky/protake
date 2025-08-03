package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import defpackage.InterfaceC4950;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    ImageType mo4850(@NonNull ByteBuffer byteBuffer) throws IOException;

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    ImageType mo4851(@NonNull InputStream inputStream) throws IOException;

    /* renamed from: ԩ, reason: contains not printable characters */
    int mo4852(@NonNull InputStream inputStream, @NonNull InterfaceC4950 interfaceC4950) throws IOException;
}
