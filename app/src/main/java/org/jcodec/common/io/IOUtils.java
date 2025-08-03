package org.jcodec.common.io;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class IOUtils {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return i;
            }
            outputStream.write(bArr, 0, i2);
            i += i2;
        }
    }

    public static int copyDumb(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = inputStream.read();
            if (-1 == i2) {
                return i;
            }
            outputStream.write(i2);
            i++;
        }
    }

    public static void copyFile(File file, File file2) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        FileChannelWrapper fileChannelWrapper2;
        FileChannelWrapper fileChannelWrapperWritableChannel = null;
        try {
            fileChannelWrapper2 = NIOUtils.readableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            fileChannelWrapperWritableChannel = NIOUtils.writableChannel(file2);
            NIOUtils.copy(fileChannelWrapper2, fileChannelWrapperWritableChannel, Long.MAX_VALUE);
            NIOUtils.closeQuietly(fileChannelWrapper2);
            NIOUtils.closeQuietly(fileChannelWrapperWritableChannel);
        } catch (Throwable th2) {
            th = th2;
            FileChannelWrapper fileChannelWrapper3 = fileChannelWrapperWritableChannel;
            fileChannelWrapperWritableChannel = fileChannelWrapper2;
            fileChannelWrapper = fileChannelWrapper3;
            NIOUtils.closeQuietly(fileChannelWrapperWritableChannel);
            NIOUtils.closeQuietly(fileChannelWrapper);
            throw th;
        }
    }

    public static void forceMkdir(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
        }
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new IOException("Unable to create directory " + file);
    }

    public static byte[] readFileToByteArray(File file) throws IOException {
        return NIOUtils.toArray(NIOUtils.fetchFromFile(file));
    }

    public static String readToString(InputStream inputStream) throws IOException {
        return Platform.stringFromBytes(toByteArray(inputStream));
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void writeStringToFile(File file, String str) throws IOException {
        NIOUtils.writeTo(ByteBuffer.wrap(str.getBytes()), file);
    }
}
