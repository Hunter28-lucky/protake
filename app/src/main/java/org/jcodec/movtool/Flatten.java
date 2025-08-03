package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mp4.Chunk;
import org.jcodec.containers.mp4.ChunkReader;
import org.jcodec.containers.mp4.ChunkWriter;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.AliasBox;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.DataRefBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.UrlBox;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class Flatten {
    public List<ProgressListener> listeners = new ArrayList();

    public interface ProgressListener {
        void trigger(int i);
    }

    private int calcProgress(int i, int i2, int i3) {
        int i4 = (i2 * 100) / i;
        if (i3 >= i4) {
            return i3;
        }
        Iterator<ProgressListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().trigger(i4);
        }
        return i4;
    }

    private int calcSpaceReq(MovieBox movieBox) {
        int length = 0;
        for (TrakBox trakBox : movieBox.getTracks()) {
            ChunkOffsetsBox stco = trakBox.getStco();
            if (stco != null) {
                length += stco.getChunkOffsets().length * 4;
            }
        }
        return length;
    }

    public static void main1(String[] strArr) throws Exception {
        if (strArr.length < 2) {
            System.out.println("Syntax: self <ref movie> <out movie>");
            System.exit(-1);
        }
        File file = new File(strArr[1]);
        Platform.deleteFile(file);
        FileChannelWrapper fileChannelWrapper = null;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(new File(strArr[0]));
            new Flatten().flatten(MP4Util.parseFullMovieChannel(fileChannelWrapper), file);
        } finally {
            if (fileChannelWrapper != null) {
                fileChannelWrapper.close();
            }
        }
    }

    private void writeHeader(Header header, SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        header.write(byteBufferAllocate);
        byteBufferAllocate.flip();
        seekableByteChannel.write(byteBufferAllocate);
    }

    public void addProgressListener(ProgressListener progressListener) {
        this.listeners.add(progressListener);
    }

    public void flatten(MP4Util.Movie movie, File file) throws IOException {
        FileChannelWrapper fileChannelWrapperWritableChannel;
        Platform.deleteFile(file);
        try {
            fileChannelWrapperWritableChannel = NIOUtils.writableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapperWritableChannel = null;
        }
        try {
            flattenChannel(movie, fileChannelWrapperWritableChannel);
            if (fileChannelWrapperWritableChannel != null) {
                fileChannelWrapperWritableChannel.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileChannelWrapperWritableChannel != null) {
                fileChannelWrapperWritableChannel.close();
            }
            throw th;
        }
    }

    public void flattenChannel(MP4Util.Movie movie, SeekableByteChannel seekableByteChannel) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        ChunkReader[] chunkReaderArr;
        movie.getFtyp();
        MovieBox moov = movie.getMoov();
        if (!moov.isPureRefMovie()) {
            throw new IllegalArgumentException("movie should be reference");
        }
        seekableByteChannel.setPosition(0L);
        MP4Util.writeFullMovie(seekableByteChannel, movie);
        seekableByteChannel.write(ByteBuffer.allocate(calcSpaceReq(moov)));
        long jPosition = seekableByteChannel.position();
        writeHeader(Header.createHeader("mdat", 4294967297L), seekableByteChannel);
        SeekableByteChannel[][] inputs = getInputs(moov);
        TrakBox[] tracks = moov.getTracks();
        int length = tracks.length;
        ChunkReader[] chunkReaderArr2 = new ChunkReader[length];
        ChunkWriter[] chunkWriterArr = new ChunkWriter[tracks.length];
        Chunk[] chunkArr = new Chunk[tracks.length];
        long[] jArr = new long[tracks.length];
        int i5 = 0;
        int i6 = 0;
        while (i5 < tracks.length) {
            ChunkReader chunkReader = new ChunkReader(tracks[i5]);
            chunkReaderArr2[i5] = chunkReader;
            int size = i6 + chunkReader.size();
            chunkWriterArr[i5] = new ChunkWriter(tracks[i5], inputs[i5], seekableByteChannel);
            chunkArr[i5] = chunkReaderArr2[i5].next();
            if (tracks[i5].isVideo()) {
                jArr[i5] = moov.getTimescale() * 2;
            }
            i5++;
            i6 = size;
        }
        int iCalcProgress = 0;
        int i7 = 0;
        while (true) {
            int i8 = -1;
            int i9 = -1;
            int i10 = 0;
            while (i10 < length) {
                Chunk chunk = chunkArr[i10];
                if (chunk == null) {
                    i3 = iCalcProgress;
                    i4 = i7;
                    i = i6;
                    i2 = length;
                    chunkReaderArr = chunkReaderArr2;
                } else {
                    if (i9 == i8) {
                        i3 = iCalcProgress;
                        i4 = i7;
                        i = i6;
                        i2 = length;
                        chunkReaderArr = chunkReaderArr2;
                    } else {
                        i = i6;
                        long startTv = chunk.getStartTv();
                        i2 = length;
                        i3 = iCalcProgress;
                        i4 = i7;
                        chunkReaderArr = chunkReaderArr2;
                        if (moov.rescale(startTv, tracks[i10].getTimescale()) + jArr[i10] < moov.rescale(chunkArr[i9].getStartTv(), tracks[i9].getTimescale()) + jArr[i9]) {
                        }
                    }
                    i9 = i10;
                }
                i10++;
                iCalcProgress = i3;
                i6 = i;
                length = i2;
                i7 = i4;
                chunkReaderArr2 = chunkReaderArr;
                i8 = -1;
            }
            int i11 = iCalcProgress;
            int i12 = i7;
            int i13 = i6;
            int i14 = length;
            ChunkReader[] chunkReaderArr3 = chunkReaderArr2;
            if (i9 == i8) {
                break;
            }
            chunkWriterArr[i9].write(chunkArr[i9]);
            chunkArr[i9] = chunkReaderArr3[i9].next();
            i7 = i12 + 1;
            i6 = i13;
            iCalcProgress = calcProgress(i13, i7, i11);
            length = i14;
            chunkReaderArr2 = chunkReaderArr3;
        }
        for (int i15 = 0; i15 < tracks.length; i15++) {
            chunkWriterArr[i15].apply();
        }
        long jPosition2 = seekableByteChannel.position() - jPosition;
        seekableByteChannel.setPosition(0L);
        MP4Util.writeFullMovie(seekableByteChannel, movie);
        long jPosition3 = jPosition - seekableByteChannel.position();
        if (jPosition3 < 0) {
            throw new RuntimeException("Not enough space to write the header");
        }
        writeHeader(Header.createHeader("free", jPosition3), seekableByteChannel);
        seekableByteChannel.setPosition(jPosition);
        writeHeader(Header.createHeader("mdat", jPosition2), seekableByteChannel);
    }

    public SeekableByteChannel[][] getInputs(MovieBox movieBox) throws IOException {
        TrakBox[] tracks = movieBox.getTracks();
        SeekableByteChannel[][] seekableByteChannelArr = new SeekableByteChannel[tracks.length][];
        for (int i = 0; i < tracks.length; i++) {
            DataRefBox dataRefBox = (DataRefBox) NodeBox.findFirstPath(tracks[i], DataRefBox.class, Box.path("mdia.minf.dinf.dref"));
            if (dataRefBox == null) {
                throw new RuntimeException("No data references");
            }
            List<Box> boxes = dataRefBox.getBoxes();
            int size = boxes.size();
            SeekableByteChannel[] seekableByteChannelArr2 = new SeekableByteChannel[size];
            SeekableByteChannel[] seekableByteChannelArr3 = new SeekableByteChannel[boxes.size()];
            for (int i2 = 0; i2 < size; i2++) {
                seekableByteChannelArr3[i2] = resolveDataRef(boxes.get(i2));
            }
            seekableByteChannelArr[i] = seekableByteChannelArr3;
        }
        return seekableByteChannelArr;
    }

    public SeekableByteChannel resolveDataRef(Box box) throws IOException {
        if (box instanceof UrlBox) {
            String url = ((UrlBox) box).getUrl();
            if (url.startsWith("file://")) {
                return NIOUtils.readableChannel(new File(url.substring(7)));
            }
            throw new RuntimeException("Only file:// urls are supported in data reference");
        }
        if (box instanceof AliasBox) {
            String unixPath = ((AliasBox) box).getUnixPath();
            if (unixPath != null) {
                return NIOUtils.readableChannel(new File(unixPath));
            }
            throw new RuntimeException("Could not resolve alias");
        }
        throw new RuntimeException(box.getHeader().getFourcc() + " dataref type is not supported");
    }
}
