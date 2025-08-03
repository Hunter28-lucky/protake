package org.jcodec.common.io;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.AutoFileChannelWrapper;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class NIOUtils {

    public static abstract class FileReader {
        private int oldPd;

        public abstract void data(ByteBuffer byteBuffer, long j);

        public abstract void done();

        public void readChannel(SeekableByteChannel seekableByteChannel, int i, FileReaderListener fileReaderListener) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            long size = seekableByteChannel.size();
            while (true) {
                long jPosition = seekableByteChannel.position();
                if (seekableByteChannel.read(byteBufferAllocate) == -1) {
                    done();
                    return;
                }
                byteBufferAllocate.flip();
                data(byteBufferAllocate, jPosition);
                byteBufferAllocate.flip();
                if (fileReaderListener != null) {
                    int i2 = (int) ((jPosition * 100) / size);
                    if (i2 != this.oldPd) {
                        fileReaderListener.progress(i2);
                    }
                    this.oldPd = i2;
                }
            }
        }

        public void readFile(File file, int i, FileReaderListener fileReaderListener) throws Throwable {
            FileChannelWrapper fileChannelWrapper;
            try {
                fileChannelWrapper = NIOUtils.readableChannel(file);
            } catch (Throwable th) {
                th = th;
                fileChannelWrapper = null;
            }
            try {
                readChannel(fileChannelWrapper, i, fileReaderListener);
                NIOUtils.closeQuietly(fileChannelWrapper);
            } catch (Throwable th2) {
                th = th2;
                NIOUtils.closeQuietly(fileChannelWrapper);
                throw th;
            }
        }
    }

    public interface FileReaderListener {
        void progress(int i);
    }

    public static ByteBuffer asByteBuffer(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    public static ByteBuffer asByteBufferInt(int[] iArr) {
        return asByteBuffer(ArrayUtil.toByteArray(iArr));
    }

    public static byte[] asciiString(String str) {
        return Platform.getBytes(str);
    }

    public static AutoFileChannelWrapper autoChannel(File file) throws IOException {
        return new AutoFileChannelWrapper(file);
    }

    public static ByteBuffer clone(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byteBufferAllocate.put(byteBuffer.duplicate());
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer cloneBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byteBufferAllocate.put(byteBuffer.duplicate());
        byteBufferAllocate.clear();
        return byteBufferAllocate;
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static ByteBuffer combineBuffers(Iterable<ByteBuffer> iterable) {
        Iterator<ByteBuffer> it = iterable.iterator();
        int iRemaining = 0;
        while (it.hasNext()) {
            iRemaining += it.next().remaining();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
        Iterator<ByteBuffer> it2 = iterable.iterator();
        while (it2.hasNext()) {
            write(byteBufferAllocate, it2.next());
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static boolean combineBuffersInto(ByteBuffer byteBuffer, List<ByteBuffer> list) {
        throw new RuntimeException("Stan");
    }

    public static void copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel, long j) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(65536);
        do {
            byteBufferAllocate.position(0);
            byteBufferAllocate.limit((int) Math.min(j, byteBufferAllocate.capacity()));
            int i = readableByteChannel.read(byteBufferAllocate);
            if (i != -1) {
                byteBufferAllocate.flip();
                writableByteChannel.write(byteBufferAllocate);
                j -= i;
            }
            if (i == -1) {
                return;
            }
        } while (j > 0);
    }

    public static ByteBuffer duplicate(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byteBufferAllocate.put(byteBuffer.duplicate());
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer fetchAllFromChannel(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer byteBufferFetchFromChannel;
        ArrayList arrayList = new ArrayList();
        do {
            byteBufferFetchFromChannel = fetchFromChannel(seekableByteChannel, 1048576);
            arrayList.add(byteBufferFetchFromChannel);
        } while (byteBufferFetchFromChannel.hasRemaining());
        return combineBuffers(arrayList);
    }

    public static ByteBuffer fetchFrom(ByteBuffer byteBuffer, ReadableByteChannel readableByteChannel, int i) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.limit(i);
        readFromChannel(readableByteChannel, byteBufferDuplicate);
        byteBufferDuplicate.flip();
        return byteBufferDuplicate;
    }

    public static ByteBuffer fetchFromChannel(ReadableByteChannel readableByteChannel, int i) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        readFromChannel(readableByteChannel, byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer fetchFromFile(File file) throws IOException {
        return fetchFromFileL(file, (int) file.length());
    }

    public static ByteBuffer fetchFromFileL(File file, int i) throws IOException {
        FileChannel channel = null;
        try {
            channel = new FileInputStream(file).getChannel();
            return fetchFromChannel(channel, i);
        } finally {
            closeQuietly(channel);
        }
    }

    public static void fill(ByteBuffer byteBuffer, byte b) {
        while (byteBuffer.hasRemaining()) {
            byteBuffer.put(b);
        }
    }

    public static int find(List<ByteBuffer> list, ByteBuffer byteBuffer) {
        byte[] array = toArray(byteBuffer);
        for (int i = 0; i < list.size(); i++) {
            if (Platform.arrayEqualsByte(toArray(list.get(i)), array)) {
                return i;
            }
        }
        return -1;
    }

    public static ByteBuffer from(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(byteBufferDuplicate.position() + i);
        return byteBufferDuplicate;
    }

    public static byte getRel(ByteBuffer byteBuffer, int i) {
        return byteBuffer.get(byteBuffer.position() + i);
    }

    public static final MappedByteBuffer map(String str) throws IOException {
        return mapFile(new File(str));
    }

    public static final MappedByteBuffer mapFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
        fileInputStream.close();
        return map;
    }

    public static final ByteBuffer read(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        int iPosition = byteBuffer.position() + i;
        byteBufferDuplicate.limit(iPosition);
        byteBuffer.position(iPosition);
        return byteBufferDuplicate;
    }

    public static ByteBuffer readBuf(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBuffer.position(byteBuffer.limit());
        return byteBufferDuplicate;
    }

    public static byte readByte(ReadableByteChannel readableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1);
        readableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate.get();
    }

    public static int readFromChannel(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int iPosition = byteBuffer.position();
        while (readableByteChannel.read(byteBuffer) != -1 && byteBuffer.hasRemaining()) {
        }
        return byteBuffer.position() - iPosition;
    }

    public static int readInt(ReadableByteChannel readableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        readableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate.getInt();
    }

    public static int readIntOrder(ReadableByteChannel readableByteChannel, ByteOrder byteOrder) throws IOException {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(byteOrder);
        readableByteChannel.read(byteBufferOrder);
        byteBufferOrder.flip();
        return byteBufferOrder.getInt();
    }

    public static int readL(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.limit(Math.min(byteBufferDuplicate.position() + i, byteBufferDuplicate.limit()));
        while (readableByteChannel.read(byteBufferDuplicate) != -1 && byteBufferDuplicate.hasRemaining()) {
        }
        byteBuffer.position(byteBufferDuplicate.position());
        if (byteBuffer.position() == 0) {
            return -1;
        }
        return byteBuffer.position();
    }

    public static byte[] readNByte(ReadableByteChannel readableByteChannel, int i) throws IOException {
        byte[] bArr = new byte[i];
        readableByteChannel.read(ByteBuffer.wrap(bArr));
        return bArr;
    }

    public static String readNullTermString(ByteBuffer byteBuffer) {
        return readNullTermStringCharset(byteBuffer, Platform.UTF_8);
    }

    public static String readNullTermStringCharset(ByteBuffer byteBuffer, String str) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        while (byteBuffer.hasRemaining() && byteBuffer.get() != 0) {
        }
        if (byteBuffer.hasRemaining()) {
            byteBufferDuplicate.limit(byteBuffer.position() - 1);
        }
        return Platform.stringFromCharset(toArray(byteBufferDuplicate), str);
    }

    public static String readPascalString(ByteBuffer byteBuffer) {
        return readString(byteBuffer, byteBuffer.get() & ExifInterface.MARKER);
    }

    public static String readPascalStringL(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBuffer2 = read(byteBuffer, i + 1);
        return Platform.stringFromBytes(toArray(read(byteBuffer2, Math.min(byteBuffer2.get() & ExifInterface.MARKER, i))));
    }

    public static String readString(ByteBuffer byteBuffer, int i) {
        return Platform.stringFromBytes(toArray(read(byteBuffer, i)));
    }

    public static FileChannelWrapper readableChannel(File file) throws FileNotFoundException {
        return new FileChannelWrapper(new FileInputStream(file).getChannel());
    }

    public static FileChannelWrapper readableFileChannel(String str) throws FileNotFoundException {
        return new FileChannelWrapper(new FileInputStream(str).getChannel());
    }

    public static void relocateLeftover(ByteBuffer byteBuffer) {
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            byteBuffer.put(i, byteBuffer.get());
            i++;
        }
        byteBuffer.position(i);
        byteBuffer.limit(byteBuffer.capacity());
    }

    public static FileChannelWrapper rwChannel(File file) throws FileNotFoundException {
        return new FileChannelWrapper(new RandomAccessFile(file, "rw").getChannel());
    }

    public static FileChannelWrapper rwFileChannel(String str) throws FileNotFoundException {
        return new FileChannelWrapper(new RandomAccessFile(str, "rw").getChannel());
    }

    public static ByteBuffer search(ByteBuffer byteBuffer, int i, byte[] bArr) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        int iPosition = byteBuffer.position();
        loop0: while (true) {
            int i2 = 0;
            while (true) {
                if (!byteBuffer.hasRemaining()) {
                    break loop0;
                }
                if (byteBuffer.get() == bArr[i2]) {
                    i2++;
                    if (i2 == bArr.length) {
                        if (i == 0) {
                            byteBuffer.position(iPosition);
                            byteBufferDuplicate.limit(byteBuffer.position());
                            break;
                        }
                        i--;
                    }
                } else {
                    if (i2 != 0) {
                        iPosition++;
                        byteBuffer.position(iPosition);
                        break;
                    }
                    iPosition = byteBuffer.position();
                }
            }
        }
        return byteBufferDuplicate;
    }

    public static int skip(ByteBuffer byteBuffer, int i) {
        int iMin = Math.min(byteBuffer.remaining(), i);
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }

    public static byte[] toArray(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(bArr);
        return bArr;
    }

    public static byte[] toArrayL(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[Math.min(byteBuffer.remaining(), i)];
        byteBuffer.duplicate().get(bArr);
        return bArr;
    }

    public static FileChannelWrapper writableChannel(File file) throws FileNotFoundException {
        return new FileChannelWrapper(new FileOutputStream(file).getChannel());
    }

    public static FileChannelWrapper writableFileChannel(String str) throws FileNotFoundException {
        return new FileChannelWrapper(new FileOutputStream(str).getChannel());
    }

    public static void write(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer2.hasArray()) {
            byteBuffer.put(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), Math.min(byteBuffer.remaining(), byteBuffer2.remaining()));
        } else {
            byteBuffer.put(toArrayL(byteBuffer2, byteBuffer.remaining()));
        }
    }

    public static void writeByte(WritableByteChannel writableByteChannel, byte b) throws IOException {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(1).put(b).flip());
    }

    public static void writeInt(WritableByteChannel writableByteChannel, int i) throws IOException {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(4).putInt(i).flip());
    }

    public static void writeIntLE(WritableByteChannel writableByteChannel, int i) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.putInt(i).flip());
    }

    public static void writeIntOrder(WritableByteChannel writableByteChannel, int i, ByteOrder byteOrder) throws IOException {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(4).order(byteOrder).putInt(i).flip());
    }

    public static void writeL(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        if (byteBuffer2.hasArray()) {
            byteBuffer.put(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), Math.min(byteBuffer2.remaining(), i));
        } else {
            byteBuffer.put(toArrayL(byteBuffer2, i));
        }
    }

    public static void writeLong(WritableByteChannel writableByteChannel, long j) throws IOException {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(8).putLong(j).flip());
    }

    public static void writePascalString(ByteBuffer byteBuffer, String str) {
        byteBuffer.put((byte) str.length());
        byteBuffer.put(asciiString(str));
    }

    public static void writePascalStringL(ByteBuffer byteBuffer, String str, int i) {
        byteBuffer.put((byte) str.length());
        byteBuffer.put(asciiString(str));
        skip(byteBuffer, i - str.length());
    }

    public static void writeTo(ByteBuffer byteBuffer, File file) throws IOException {
        FileChannel channel = null;
        try {
            channel = new FileOutputStream(file).getChannel();
            channel.write(byteBuffer);
        } finally {
            closeQuietly(channel);
        }
    }
}
