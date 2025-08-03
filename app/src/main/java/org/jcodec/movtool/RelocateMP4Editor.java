package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.containers.mp4.BoxFactory;
import org.jcodec.containers.mp4.BoxUtil;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;

/* loaded from: classes2.dex */
public class RelocateMP4Editor {
    private ByteBuffer fetchBox(SeekableByteChannel seekableByteChannel, MP4Util.Atom atom) throws IOException {
        seekableByteChannel.setPosition(atom.getOffset());
        return NIOUtils.fetchFromChannel(seekableByteChannel, (int) atom.getHeader().getSize());
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

    public void modifyOrRelocate(File file, MP4Edit mP4Edit) throws Throwable {
        if (new InplaceMP4Editor().modify(file, mP4Edit)) {
            return;
        }
        relocate(file, mP4Edit);
    }

    public void relocate(File file, MP4Edit mP4Edit) throws Throwable {
        FileChannelWrapper fileChannelWrapperRwChannel;
        try {
            fileChannelWrapperRwChannel = NIOUtils.rwChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapperRwChannel = null;
        }
        try {
            MP4Util.Atom moov = getMoov(fileChannelWrapperRwChannel);
            MovieBox movieBox = (MovieBox) parseBox(fetchBox(fileChannelWrapperRwChannel, moov));
            mP4Edit.apply(movieBox);
            if (moov.getOffset() + moov.getHeader().getSize() < fileChannelWrapperRwChannel.size()) {
                Logger.info("Relocating movie header to the end of the file.");
                fileChannelWrapperRwChannel.setPosition(moov.getOffset() + 4);
                fileChannelWrapperRwChannel.write(ByteBuffer.wrap(Header.FOURCC_FREE));
                fileChannelWrapperRwChannel.setPosition(fileChannelWrapperRwChannel.size());
            } else {
                fileChannelWrapperRwChannel.setPosition(moov.getOffset());
            }
            MP4Util.writeMovie(fileChannelWrapperRwChannel, movieBox);
            NIOUtils.closeQuietly(fileChannelWrapperRwChannel);
        } catch (Throwable th2) {
            th = th2;
            NIOUtils.closeQuietly(fileChannelWrapperRwChannel);
            throw th;
        }
    }
}
