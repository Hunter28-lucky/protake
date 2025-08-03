package org.jcodec.common;

import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.jcodec.api.NotSupportedException;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class AudioUtil {
    private static final float f16 = 32767.0f;
    private static final float f24 = 8388607.0f;
    public static final float r16 = 3.0517578E-5f;
    public static final float r24 = 1.1920929E-7f;

    public static void deinterleave(AudioFormat audioFormat, ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        int sampleSizeInBits = audioFormat.getSampleSizeInBits() >> 3;
        int length = byteBufferArr.length * sampleSizeInBits;
        while (byteBuffer.remaining() >= length) {
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                for (int i = 0; i < sampleSizeInBits; i++) {
                    byteBuffer2.put(byteBuffer.get());
                }
            }
        }
    }

    public static void fromFloat(FloatBuffer floatBuffer, AudioFormat audioFormat, ByteBuffer byteBuffer) {
        if (!audioFormat.isSigned()) {
            throw new NotSupportedException("Unsigned PCM is not supported ( yet? ).");
        }
        if (audioFormat.getSampleSizeInBits() != 16 && audioFormat.getSampleSizeInBits() != 24) {
            throw new NotSupportedException(audioFormat.getSampleSizeInBits() + " bit PCM is not supported ( yet? ).");
        }
        if (audioFormat.isBigEndian()) {
            if (audioFormat.getSampleSizeInBits() == 16) {
                fromFloat16BE(byteBuffer, floatBuffer);
                return;
            } else {
                fromFloat24BE(byteBuffer, floatBuffer);
                return;
            }
        }
        if (audioFormat.getSampleSizeInBits() == 16) {
            fromFloat16LE(byteBuffer, floatBuffer);
        } else {
            fromFloat24LE(byteBuffer, floatBuffer);
        }
    }

    private static void fromFloat16BE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 2 && floatBuffer.hasRemaining()) {
            int iClip = MathUtil.clip((int) (floatBuffer.get() * f16), -32768, 32767) & 65535;
            byteBuffer.put((byte) (iClip >> 8));
            byteBuffer.put((byte) iClip);
        }
    }

    private static void fromFloat16LE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 2 && floatBuffer.hasRemaining()) {
            int iClip = MathUtil.clip((int) (floatBuffer.get() * f16), -32768, 32767) & 65535;
            byteBuffer.put((byte) iClip);
            byteBuffer.put((byte) (iClip >> 8));
        }
    }

    private static void fromFloat24BE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 3 && floatBuffer.hasRemaining()) {
            int iClip = MathUtil.clip((int) (floatBuffer.get() * f24), -8388608, 8388607) & ViewCompat.MEASURED_SIZE_MASK;
            byteBuffer.put((byte) (iClip >> 16));
            byteBuffer.put((byte) (iClip >> 8));
            byteBuffer.put((byte) iClip);
        }
    }

    private static void fromFloat24LE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 3 && floatBuffer.hasRemaining()) {
            int iClip = MathUtil.clip((int) (floatBuffer.get() * f24), -8388608, 8388607) & ViewCompat.MEASURED_SIZE_MASK;
            byteBuffer.put((byte) iClip);
            byteBuffer.put((byte) (iClip >> 8));
            byteBuffer.put((byte) (iClip >> 16));
        }
    }

    public static int fromInt(int[] iArr, int i, AudioFormat audioFormat, ByteBuffer byteBuffer) {
        if (!audioFormat.isSigned()) {
            throw new NotSupportedException("Unsigned PCM is not supported ( yet? ).");
        }
        if (audioFormat.getSampleSizeInBits() == 16 || audioFormat.getSampleSizeInBits() == 24) {
            return audioFormat.isBigEndian() ? audioFormat.getSampleSizeInBits() == 16 ? fromInt16BE(byteBuffer, iArr, i) : fromInt24BE(byteBuffer, iArr, i) : audioFormat.getSampleSizeInBits() == 16 ? fromInt16LE(byteBuffer, iArr, i) : fromInt24LE(byteBuffer, iArr, i);
        }
        throw new NotSupportedException(audioFormat.getSampleSizeInBits() + " bit PCM is not supported ( yet? ).");
    }

    private static int fromInt16BE(ByteBuffer byteBuffer, int[] iArr, int i) {
        int i2 = 0;
        while (byteBuffer.remaining() >= 2 && i2 < i) {
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            byteBuffer.put((byte) (i4 >> 8));
            byteBuffer.put((byte) i4);
            i2 = i3;
        }
        return i2;
    }

    private static int fromInt16LE(ByteBuffer byteBuffer, int[] iArr, int i) {
        int i2 = 0;
        while (byteBuffer.remaining() >= 2 && i2 < i) {
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            byteBuffer.put((byte) i4);
            byteBuffer.put((byte) (i4 >> 8));
            i2 = i3;
        }
        return i2;
    }

    private static int fromInt24BE(ByteBuffer byteBuffer, int[] iArr, int i) {
        int i2 = 0;
        while (byteBuffer.remaining() >= 3 && i2 < i) {
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            byteBuffer.put((byte) (i4 >> 16));
            byteBuffer.put((byte) (i4 >> 8));
            byteBuffer.put((byte) i4);
            i2 = i3;
        }
        return i2;
    }

    private static int fromInt24LE(ByteBuffer byteBuffer, int[] iArr, int i) {
        int i2 = 0;
        while (byteBuffer.remaining() >= 3 && i2 < i) {
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            byteBuffer.put((byte) i4);
            byteBuffer.put((byte) (i4 >> 8));
            byteBuffer.put((byte) (i4 >> 16));
            i2 = i3;
        }
        return i2;
    }

    public static void interleave(AudioFormat audioFormat, ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) {
        int sampleSizeInBits = audioFormat.getSampleSizeInBits() >> 3;
        int length = byteBufferArr.length * sampleSizeInBits;
        int iRemaining = 0;
        for (int i = 0; i < byteBufferArr.length; i++) {
            if (byteBufferArr[i].remaining() > iRemaining) {
                iRemaining = byteBufferArr[i].remaining();
            }
        }
        for (int i2 = 0; i2 < iRemaining && byteBuffer.remaining() >= length; i2++) {
            for (int i3 = 0; i3 < byteBufferArr.length; i3++) {
                if (byteBufferArr[i3].remaining() < sampleSizeInBits) {
                    for (int i4 = 0; i4 < sampleSizeInBits; i4++) {
                        byteBuffer.put((byte) 0);
                    }
                } else {
                    for (int i5 = 0; i5 < sampleSizeInBits; i5++) {
                        byteBuffer.put(byteBufferArr[i3].get());
                    }
                }
            }
        }
    }

    public static void toFloat(AudioFormat audioFormat, ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        if (!audioFormat.isSigned()) {
            throw new NotSupportedException("Unsigned PCM is not supported ( yet? ).");
        }
        if (audioFormat.getSampleSizeInBits() != 16 && audioFormat.getSampleSizeInBits() != 24) {
            throw new NotSupportedException(audioFormat.getSampleSizeInBits() + " bit PCM is not supported ( yet? ).");
        }
        if (audioFormat.isBigEndian()) {
            if (audioFormat.getSampleSizeInBits() == 16) {
                toFloat16BE(byteBuffer, floatBuffer);
                return;
            } else {
                toFloat24BE(byteBuffer, floatBuffer);
                return;
            }
        }
        if (audioFormat.getSampleSizeInBits() == 16) {
            toFloat16LE(byteBuffer, floatBuffer);
        } else {
            toFloat24LE(byteBuffer, floatBuffer);
        }
    }

    private static void toFloat16BE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 2 && floatBuffer.hasRemaining()) {
            floatBuffer.put(((short) (((byteBuffer.get() & ExifInterface.MARKER) << 8) | (byteBuffer.get() & ExifInterface.MARKER))) * 3.0517578E-5f);
        }
    }

    private static void toFloat16LE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 2 && floatBuffer.hasRemaining()) {
            floatBuffer.put(((short) ((byteBuffer.get() & ExifInterface.MARKER) | ((byteBuffer.get() & ExifInterface.MARKER) << 8))) * 3.0517578E-5f);
        }
    }

    private static void toFloat24BE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 3 && floatBuffer.hasRemaining()) {
            floatBuffer.put((((((byteBuffer.get() & ExifInterface.MARKER) << 24) | ((byteBuffer.get() & ExifInterface.MARKER) << 16)) | ((byteBuffer.get() & ExifInterface.MARKER) << 8)) >> 8) * 1.1920929E-7f);
        }
    }

    private static void toFloat24LE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 3 && floatBuffer.hasRemaining()) {
            floatBuffer.put((((((byteBuffer.get() & ExifInterface.MARKER) << 8) | ((byteBuffer.get() & ExifInterface.MARKER) << 16)) | ((byteBuffer.get() & ExifInterface.MARKER) << 24)) >> 8) * 1.1920929E-7f);
        }
    }

    public static int toInt(AudioFormat audioFormat, ByteBuffer byteBuffer, int[] iArr) {
        if (!audioFormat.isSigned()) {
            throw new NotSupportedException("Unsigned PCM is not supported ( yet? ).");
        }
        if (audioFormat.getSampleSizeInBits() == 16 || audioFormat.getSampleSizeInBits() == 24) {
            return audioFormat.isBigEndian() ? audioFormat.getSampleSizeInBits() == 16 ? toInt16BE(byteBuffer, iArr) : toInt24BE(byteBuffer, iArr) : audioFormat.getSampleSizeInBits() == 16 ? toInt16LE(byteBuffer, iArr) : toInt24LE(byteBuffer, iArr);
        }
        throw new NotSupportedException(audioFormat.getSampleSizeInBits() + " bit PCM is not supported ( yet? ).");
    }

    private static int toInt16BE(ByteBuffer byteBuffer, int[] iArr) {
        int i = 0;
        while (byteBuffer.remaining() >= 2 && i < iArr.length) {
            iArr[i] = (short) (((byteBuffer.get() & ExifInterface.MARKER) << 8) | (byteBuffer.get() & ExifInterface.MARKER));
            i++;
        }
        return i;
    }

    private static int toInt16LE(ByteBuffer byteBuffer, int[] iArr) {
        int i = 0;
        while (byteBuffer.remaining() >= 2 && i < iArr.length) {
            iArr[i] = (short) ((byteBuffer.get() & ExifInterface.MARKER) | ((byteBuffer.get() & ExifInterface.MARKER) << 8));
            i++;
        }
        return i;
    }

    private static int toInt24BE(ByteBuffer byteBuffer, int[] iArr) {
        int i = 0;
        while (byteBuffer.remaining() >= 3 && i < iArr.length) {
            iArr[i] = ((((byteBuffer.get() & ExifInterface.MARKER) << 24) | ((byteBuffer.get() & ExifInterface.MARKER) << 16)) | ((byteBuffer.get() & ExifInterface.MARKER) << 8)) >> 8;
            i++;
        }
        return i;
    }

    private static int toInt24LE(ByteBuffer byteBuffer, int[] iArr) {
        int i = 0;
        while (byteBuffer.remaining() >= 3 && i < iArr.length) {
            iArr[i] = ((((byteBuffer.get() & ExifInterface.MARKER) << 8) | ((byteBuffer.get() & ExifInterface.MARKER) << 16)) | ((byteBuffer.get() & ExifInterface.MARKER) << 24)) >> 8;
            i++;
        }
        return i;
    }
}
