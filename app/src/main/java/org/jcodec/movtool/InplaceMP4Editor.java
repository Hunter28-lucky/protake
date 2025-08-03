package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jcodec.common.Preconditions;
import org.jcodec.common.Tuple;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mp4.BoxFactory;
import org.jcodec.containers.mp4.BoxUtil;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;

/* loaded from: classes2.dex */
public class InplaceMP4Editor {
    /* JADX WARN: Multi-variable type inference failed */
    private List<Tuple._2<MP4Util.Atom, ByteBuffer>> doTheFix(SeekableByteChannel seekableByteChannel, MP4Edit mP4Edit) throws IOException {
        MP4Util.Atom moov = getMoov(seekableByteChannel);
        Preconditions.checkNotNull(moov);
        ByteBuffer byteBufferFetchBox = fetchBox(seekableByteChannel, moov);
        MovieBox movieBox = (MovieBox) parseBox(byteBufferFetchBox);
        LinkedList linkedList = new LinkedList();
        if (BoxUtil.containsBox(movieBox, "mvex")) {
            LinkedList<Tuple._2> linkedList2 = new LinkedList();
            for (MP4Util.Atom atom : getFragments(seekableByteChannel)) {
                ByteBuffer byteBufferFetchBox2 = fetchBox(seekableByteChannel, atom);
                linkedList.add(Tuple.pair(atom, byteBufferFetchBox2));
                MovieFragmentBox movieFragmentBox = (MovieFragmentBox) parseBox(byteBufferFetchBox2);
                movieFragmentBox.setMovie(movieBox);
                linkedList2.add(Tuple.pair(byteBufferFetchBox2, movieFragmentBox));
            }
            mP4Edit.applyToFragment(movieBox, (MovieFragmentBox[]) Tuple._2_project1(linkedList2).toArray(new MovieFragmentBox[0]));
            for (Tuple._2 _2 : linkedList2) {
                if (!rewriteBox((ByteBuffer) _2.v0, (Box) _2.v1)) {
                    return null;
                }
            }
        } else {
            mP4Edit.apply(movieBox);
        }
        if (!rewriteBox(byteBufferFetchBox, movieBox)) {
            return null;
        }
        linkedList.add(Tuple.pair(moov, byteBufferFetchBox));
        return linkedList;
    }

    private ByteBuffer fetchBox(SeekableByteChannel seekableByteChannel, MP4Util.Atom atom) throws IOException {
        seekableByteChannel.setPosition(atom.getOffset());
        return NIOUtils.fetchFromChannel(seekableByteChannel, (int) atom.getHeader().getSize());
    }

    private List<MP4Util.Atom> getFragments(SeekableByteChannel seekableByteChannel) throws IOException {
        LinkedList linkedList = new LinkedList();
        for (MP4Util.Atom atom : MP4Util.getRootAtoms(seekableByteChannel)) {
            if ("moof".equals(atom.getHeader().getFourcc())) {
                linkedList.add(atom);
            }
        }
        return linkedList;
    }

    private MP4Util.Atom getMoov(SeekableByteChannel seekableByteChannel) throws IOException {
        for (MP4Util.Atom atom : MP4Util.getRootAtoms(seekableByteChannel)) {
            if ("moov".equals(atom.getHeader().getFourcc())) {
                return atom;
            }
        }
        return null;
    }

    private Box parseBox(ByteBuffer byteBuffer) {
        return BoxUtil.parseBox(byteBuffer, Header.read(byteBuffer), BoxFactory.getDefault());
    }

    private void replaceBox(SeekableByteChannel seekableByteChannel, MP4Util.Atom atom, ByteBuffer byteBuffer) throws IOException {
        seekableByteChannel.setPosition(atom.getOffset());
        seekableByteChannel.write(byteBuffer);
    }

    private boolean rewriteBox(ByteBuffer byteBuffer, Box box) {
        try {
            byteBuffer.clear();
            box.write(byteBuffer);
            if (byteBuffer.hasRemaining()) {
                if (byteBuffer.remaining() < 8) {
                    return false;
                }
                byteBuffer.putInt(byteBuffer.remaining());
                byteBuffer.put(new byte[]{102, 114, 101, 101});
            }
            byteBuffer.flip();
            return true;
        } catch (BufferOverflowException unused) {
            return false;
        }
    }

    public boolean copy(File file, File file2, MP4Edit mP4Edit) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        FileChannelWrapper fileChannelWrapper2;
        boolean z;
        FileChannelWrapper fileChannelWrapperWritableChannel = null;
        try {
            fileChannelWrapper2 = NIOUtils.readableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            fileChannelWrapperWritableChannel = NIOUtils.writableChannel(file2);
            List<Tuple._2<MP4Util.Atom, ByteBuffer>> listDoTheFix = doTheFix(fileChannelWrapper2, mP4Edit);
            if (listDoTheFix == null) {
                z = false;
            } else {
                Map mapAsMap = Tuple.asMap(Tuple._2map0(listDoTheFix, new Tuple.Mapper<MP4Util.Atom, Long>() { // from class: org.jcodec.movtool.InplaceMP4Editor.1
                    @Override // org.jcodec.common.Tuple.Mapper
                    public Long map(MP4Util.Atom atom) {
                        return Long.valueOf(atom.getOffset());
                    }
                }));
                for (MP4Util.Atom atom : MP4Util.getRootAtoms(fileChannelWrapper2)) {
                    ByteBuffer byteBuffer = (ByteBuffer) mapAsMap.get(Long.valueOf(atom.getOffset()));
                    if (byteBuffer != null) {
                        fileChannelWrapperWritableChannel.write(byteBuffer);
                    } else {
                        atom.copy(fileChannelWrapper2, fileChannelWrapperWritableChannel);
                    }
                }
                z = true;
            }
            NIOUtils.closeQuietly(fileChannelWrapper2);
            NIOUtils.closeQuietly(fileChannelWrapperWritableChannel);
            return z;
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

    public boolean modify(File file, MP4Edit mP4Edit) throws Throwable {
        FileChannelWrapper fileChannelWrapperRwChannel;
        boolean z;
        try {
            fileChannelWrapperRwChannel = NIOUtils.rwChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapperRwChannel = null;
        }
        try {
            List<Tuple._2<MP4Util.Atom, ByteBuffer>> listDoTheFix = doTheFix(fileChannelWrapperRwChannel, mP4Edit);
            if (listDoTheFix == null) {
                z = false;
            } else {
                for (Tuple._2<MP4Util.Atom, ByteBuffer> _2 : listDoTheFix) {
                    replaceBox(fileChannelWrapperRwChannel, _2.v0, _2.v1);
                }
                z = true;
            }
            NIOUtils.closeQuietly(fileChannelWrapperRwChannel);
            return z;
        } catch (Throwable th2) {
            th = th2;
            NIOUtils.closeQuietly(fileChannelWrapperRwChannel);
            throw th;
        }
    }

    public boolean replace(File file, MP4Edit mP4Edit) throws IOException {
        File file2 = new File(file.getParentFile(), "." + file.getName());
        if (!copy(file, file2, mP4Edit)) {
            return false;
        }
        file2.renameTo(file);
        return true;
    }
}
