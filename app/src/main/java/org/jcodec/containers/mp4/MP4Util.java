package org.jcodec.containers.mp4;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jcodec.common.AutoFileChannelWrapper;
import org.jcodec.common.Codec;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.FileTypeBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public class MP4Util {
    private static Map<Codec, String> codecMapping;

    public static class Atom {
        private Header header;
        private long offset;

        public Atom(Header header, long j) {
            this.header = header;
            this.offset = j;
        }

        public void copy(SeekableByteChannel seekableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
            seekableByteChannel.setPosition(this.offset);
            NIOUtils.copy(seekableByteChannel, writableByteChannel, this.header.getSize());
        }

        public Header getHeader() {
            return this.header;
        }

        public long getOffset() {
            return this.offset;
        }

        public Box parseBox(SeekableByteChannel seekableByteChannel) throws IOException {
            seekableByteChannel.setPosition(this.offset + this.header.headerSize());
            return BoxUtil.parseBox(NIOUtils.fetchFromChannel(seekableByteChannel, (int) this.header.getBodySize()), this.header, BoxFactory.getDefault());
        }
    }

    public static class Movie {
        private FileTypeBox ftyp;
        private MovieBox moov;

        public Movie(FileTypeBox fileTypeBox, MovieBox movieBox) {
            this.ftyp = fileTypeBox;
            this.moov = movieBox;
        }

        public FileTypeBox getFtyp() {
            return this.ftyp;
        }

        public MovieBox getMoov() {
            return this.moov;
        }
    }

    static {
        HashMap map = new HashMap();
        codecMapping = map;
        map.put(Codec.MPEG2, "m2v1");
        codecMapping.put(Codec.H264, "avc1");
        codecMapping.put(Codec.J2K, "mjp2");
    }

    public static Atom atom(SeekableByteChannel seekableByteChannel) throws IOException {
        long jPosition = seekableByteChannel.position();
        Header header = Header.read(NIOUtils.fetchFromChannel(seekableByteChannel, 16));
        if (header == null) {
            return null;
        }
        return new Atom(header, jPosition);
    }

    public static Movie createRefFullMovie(SeekableByteChannel seekableByteChannel, String str) throws IOException {
        Movie fullMovieChannel = parseFullMovieChannel(seekableByteChannel);
        for (TrakBox trakBox : fullMovieChannel.moov.getTracks()) {
            trakBox.setDataRef(str);
        }
        return fullMovieChannel;
    }

    public static Movie createRefFullMovieFromFile(File file) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            Movie movieCreateRefFullMovie = createRefFullMovie(fileChannelWrapper, "file://" + file.getCanonicalPath());
            if (fileChannelWrapper != null) {
                fileChannelWrapper.close();
            }
            return movieCreateRefFullMovie;
        } catch (Throwable th2) {
            th = th2;
            if (fileChannelWrapper != null) {
                fileChannelWrapper.close();
            }
            throw th;
        }
    }

    public static MovieBox createRefMovie(SeekableByteChannel seekableByteChannel, String str) throws IOException {
        MovieBox movieChannel = parseMovieChannel(seekableByteChannel);
        for (TrakBox trakBox : movieChannel.getTracks()) {
            trakBox.setDataRef(str);
        }
        return movieChannel;
    }

    public static MovieBox createRefMovieFromFile(File file) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            MovieBox movieBoxCreateRefMovie = createRefMovie(fileChannelWrapper, "file://" + file.getCanonicalPath());
            if (fileChannelWrapper != null) {
                fileChannelWrapper.close();
            }
            return movieBoxCreateRefMovie;
        } catch (Throwable th2) {
            th = th2;
            if (fileChannelWrapper != null) {
                fileChannelWrapper.close();
            }
            throw th;
        }
    }

    public static void doWriteFullMovieToChannel(SeekableByteChannel seekableByteChannel, Movie movie, int i) throws IOException {
        int iEstimateMoovBoxSize = estimateMoovBoxSize(movie.getMoov()) + i;
        Logger.debug("Using " + iEstimateMoovBoxSize + " bytes for MOOV box");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iEstimateMoovBoxSize + 128);
        movie.getFtyp().write(byteBufferAllocate);
        movie.getMoov().write(byteBufferAllocate);
        byteBufferAllocate.flip();
        seekableByteChannel.write(byteBufferAllocate);
    }

    public static void doWriteMovieToChannel(SeekableByteChannel seekableByteChannel, MovieBox movieBox, int i) throws IOException {
        int iEstimateMoovBoxSize = estimateMoovBoxSize(movieBox) + i;
        Logger.debug("Using " + iEstimateMoovBoxSize + " bytes for MOOV box");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iEstimateMoovBoxSize * 4);
        movieBox.write(byteBufferAllocate);
        byteBufferAllocate.flip();
        seekableByteChannel.write(byteBufferAllocate);
    }

    public static int estimateMoovBoxSize(MovieBox movieBox) {
        return movieBox.estimateSize() + 4096;
    }

    public static Atom findFirstAtom(String str, SeekableByteChannel seekableByteChannel) throws IOException {
        for (Atom atom : getRootAtoms(seekableByteChannel)) {
            if (str.equals(atom.getHeader().getFourcc())) {
                return atom;
            }
        }
        return null;
    }

    public static Atom findFirstAtomInFile(String str, File file) throws IOException {
        AutoFileChannelWrapper autoFileChannelWrapper = new AutoFileChannelWrapper(file);
        try {
            return findFirstAtom(str, autoFileChannelWrapper);
        } finally {
            IOUtils.closeQuietly(autoFileChannelWrapper);
        }
    }

    public static String getFourcc(Codec codec) {
        return codecMapping.get(codec);
    }

    public static List<Atom> getRootAtoms(SeekableByteChannel seekableByteChannel) throws IOException {
        long size = 0;
        seekableByteChannel.setPosition(0L);
        ArrayList arrayList = new ArrayList();
        while (size < seekableByteChannel.size()) {
            seekableByteChannel.setPosition(size);
            Header header = Header.read(NIOUtils.fetchFromChannel(seekableByteChannel, 16));
            if (header == null) {
                break;
            }
            arrayList.add(new Atom(header, size));
            size += header.getSize();
        }
        return arrayList;
    }

    public static Movie parseFullMovie(File file) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(file);
            try {
                Movie fullMovieChannel = parseFullMovieChannel(fileChannelWrapper);
                if (fileChannelWrapper != null) {
                    fileChannelWrapper.close();
                }
                return fullMovieChannel;
            } catch (Throwable th) {
                th = th;
                if (fileChannelWrapper != null) {
                    fileChannelWrapper.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannelWrapper = null;
        }
    }

    public static Movie parseFullMovieChannel(SeekableByteChannel seekableByteChannel) throws IOException {
        FileTypeBox fileTypeBox = null;
        for (Atom atom : getRootAtoms(seekableByteChannel)) {
            if ("ftyp".equals(atom.getHeader().getFourcc())) {
                fileTypeBox = (FileTypeBox) atom.parseBox(seekableByteChannel);
            } else if ("moov".equals(atom.getHeader().getFourcc())) {
                return new Movie(fileTypeBox, (MovieBox) atom.parseBox(seekableByteChannel));
            }
        }
        return null;
    }

    public static MovieBox parseMovie(File file) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(file);
            try {
                MovieBox movieChannel = parseMovieChannel(fileChannelWrapper);
                if (fileChannelWrapper != null) {
                    fileChannelWrapper.close();
                }
                return movieChannel;
            } catch (Throwable th) {
                th = th;
                if (fileChannelWrapper != null) {
                    fileChannelWrapper.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannelWrapper = null;
        }
    }

    public static MovieBox parseMovieChannel(SeekableByteChannel seekableByteChannel) throws IOException {
        for (Atom atom : getRootAtoms(seekableByteChannel)) {
            if ("moov".equals(atom.getHeader().getFourcc())) {
                return (MovieBox) atom.parseBox(seekableByteChannel);
            }
        }
        return null;
    }

    public static List<MovieFragmentBox> parseMovieFragments(SeekableByteChannel seekableByteChannel) throws IOException {
        LinkedList linkedList = new LinkedList();
        MovieBox movieBox = null;
        for (Atom atom : getRootAtoms(seekableByteChannel)) {
            if ("moov".equals(atom.getHeader().getFourcc())) {
                movieBox = (MovieBox) atom.parseBox(seekableByteChannel);
            } else if ("moof".equalsIgnoreCase(atom.getHeader().getFourcc())) {
                linkedList.add((MovieFragmentBox) atom.parseBox(seekableByteChannel));
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((MovieFragmentBox) it.next()).setMovie(movieBox);
        }
        return linkedList;
    }

    public static ByteBuffer writeBox(Box box, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        box.write(byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static void writeFullMovie(SeekableByteChannel seekableByteChannel, Movie movie) throws IOException {
        doWriteFullMovieToChannel(seekableByteChannel, movie, 0);
    }

    public static void writeFullMovieToFile(File file, Movie movie) throws Throwable {
        FileChannelWrapper fileChannelWrapperWritableChannel;
        try {
            fileChannelWrapperWritableChannel = NIOUtils.writableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapperWritableChannel = null;
        }
        try {
            writeFullMovie(fileChannelWrapperWritableChannel, movie);
            IOUtils.closeQuietly(fileChannelWrapperWritableChannel);
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(fileChannelWrapperWritableChannel);
            throw th;
        }
    }

    public static void writeMovie(SeekableByteChannel seekableByteChannel, MovieBox movieBox) throws IOException {
        doWriteMovieToChannel(seekableByteChannel, movieBox, 0);
    }

    public static void writeMovieToFile(File file, MovieBox movieBox) throws Throwable {
        FileChannelWrapper fileChannelWrapperWritableChannel;
        try {
            fileChannelWrapperWritableChannel = NIOUtils.writableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapperWritableChannel = null;
        }
        try {
            writeMovie(fileChannelWrapperWritableChannel, movieBox);
            IOUtils.closeQuietly(fileChannelWrapperWritableChannel);
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(fileChannelWrapperWritableChannel);
            throw th;
        }
    }
}
