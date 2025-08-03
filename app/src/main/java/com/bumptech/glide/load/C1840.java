package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import defpackage.InterfaceC4950;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageHeaderParserUtils.java */
/* renamed from: com.bumptech.glide.load.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C1840 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m5021(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull InterfaceC4950 interfaceC4950) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, interfaceC4950);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int iMo4852 = list.get(i).mo4852(inputStream, interfaceC4950);
                if (iMo4852 != -1) {
                    return iMo4852;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static ImageHeaderParser.ImageType m5022(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull InterfaceC4950 interfaceC4950) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, interfaceC4950);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser.ImageType imageTypeMo4851 = list.get(i).mo4851(inputStream);
                if (imageTypeMo4851 != ImageHeaderParser.ImageType.UNKNOWN) {
                    return imageTypeMo4851;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public static ImageHeaderParser.ImageType m5023(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType imageTypeMo4850 = list.get(i).mo4850(byteBuffer);
            if (imageTypeMo4850 != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeMo4850;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
